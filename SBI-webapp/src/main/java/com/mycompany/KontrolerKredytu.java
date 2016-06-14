/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.DataTransferObjects.*;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Przemek
 */
@Controller
public class KontrolerKredytu 
{
      @Autowired
          DataSource dataSource;
      
      @RequestMapping(value="/kredyt", method=RequestMethod.GET)
    public ModelAndView reqKredytGET() 
    {       
        return new ModelAndView("DaneDoKredytu", "formularzKr", new DaneKredyt());
    }
    
    @RequestMapping(value="/kredyt1", method=RequestMethod.GET)
    public ModelAndView reqKredyt1GET() 
    {       
        return new ModelAndView("DaneDoKredytu1", "formularzKr", new DaneKredyt());
    }
    
    @RequestMapping(value = "/kredyt", method=RequestMethod.POST)
    public String reqKredytPOST(@RequestParam String action) 
    {
        if( action.equals("zmiana danych") )
        {
            return "redirect:/kredyt";
        }
        else if ( action.equals("Strona glowna") )
        {
            return "redirect:/"; 
        }
        else if ( action.equals("Sprawdz dostepny kredyt") )
        {
           return "forward:/oferta"; 
        }
        else if ( action.equals("Wez kredyt") )
        {
           return "redirect:/kredyt1"; 
        }
        else
        {
            return "redirect:/blad"; // nie powinno to nigdy wyjsc i poki co prowadzi w puste miejsce, można potem wstawić jakąś stronę błędu
        }       
    }
    
    @RequestMapping(value = "/kredyt1", method=RequestMethod.POST)
    public String reqKredyt1POST(@RequestParam String action) 
    {
        return "forward:/bierzkredyt" ;      
    }
    
    
    @RequestMapping(value = "/oferta", method=RequestMethod.POST)
    public ModelAndView reqOfertaPOST(@RequestParam(value = "formazatrudnienia") String praca,
            @RequestParam(value = "kwota") int kwota,
            @RequestParam(value = "okres") int okres,
            @RequestParam(value = "stancywilny") String stan,
            @RequestParam(value = "wyksztalcenie") String wyksztalcenie,
            @RequestParam(value = "statusmieszkaniowy") String statusmieszkaniowy,
            @RequestParam(value = "ile_w_domu") int ile_w_domu,
            @RequestParam(value = "lacznydochod") int lacznydochod,
            @RequestParam(value = "waluta") String waluta,
            @RequestParam(value = "rachunek") int rachunek)   
        {
            
            JdbcTemplate jt = new JdbcTemplate(dataSource);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            String konto="";
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + rachunek + "", String.class);
            }
             catch (EmptyResultDataAccessException e) 
             {
		konto="";
             }		
            if (!currentPrincipalName.equals(konto))
            {
                return new ModelAndView("ZlyNumerRachunku","formularzZly", new DaneKredyt());
            }
            
            /**
             * obliczanie zdolnosci kredytowej
             */
            double zdolnosc=1;
            
            
            if (stan.equals("separacja"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (stan.equals("malzenstwo"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            
            if (praca.equals("emerytura")||praca.equals("renta"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (praca.equals("zlecenie")||praca.equals("wojsko"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (praca.equals("menager")||praca.equals("radny"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (praca.equals("prezes")||praca.equals("posel"))
            {
                zdolnosc=zdolnosc*1.3;
            }
            
            if (wyksztalcenie.equals("podstawowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (wyksztalcenie.equals("srednie"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (wyksztalcenie.equals("dr"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            
            if (statusmieszkaniowy.equals("wlasne"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            else if (statusmieszkaniowy.equals("sluzbowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (statusmieszkaniowy.equals("wynajem"))
            {
                zdolnosc=zdolnosc*0.9;
            }
            
            if (ile_w_domu>2)
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (ile_w_domu==1)
            {
                zdolnosc=zdolnosc*0.8;
            }
            
            /**
             * kredyty na dom itp
             */
            if (okres>240)
            {
                if (lacznydochod*okres/2*zdolnosc<kwota) 
                {
                    zdolnosc=0; //odmowa kredytu
                }
            }
            else if (lacznydochod*5*zdolnosc<kwota)
            {
                zdolnosc=0; //odmowa kredytu
            }
            // wartości do zmiany
            double prowizja=2/zdolnosc; 
            double oprocentowanie=6/zdolnosc; 
            
             return new ModelAndView("DaneDoOferty", "formularzOf", new DaneOferty (kwota,okres,zdolnosc, prowizja, oprocentowanie,waluta,rachunek));
        }
    
    @RequestMapping(value = "/bierzkredyt", method=RequestMethod.POST)
    public String reqbierzkredytPOST(@RequestParam(value = "formazatrudnienia") String praca,
            @RequestParam(value = "kwota") int kwota,
            @RequestParam(value = "okres") int okres,
            @RequestParam(value = "stancywilny") String stan,
            @RequestParam(value = "wyksztalcenie") String wyksztalcenie,
            @RequestParam(value = "statusmieszkaniowy") String statusmieszkaniowy,
            @RequestParam(value = "ile_w_domu") int ile_w_domu,
            @RequestParam(value = "lacznydochod") int lacznydochod,
            @RequestParam(value = "waluta") String waluta,
            @RequestParam(value = "rachunek") int rachunek)  
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            String konto="";
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + rachunek + "", String.class);
            }
             catch (EmptyResultDataAccessException e) 
             {
		konto="";
             }		
            if (!currentPrincipalName.equals(konto))
            {
                return "redirect:/";
            }
            
            /**
             * obliczanie zdolnosci kredytowej
             */
            double zdolnosc=1;
            
            
            if (stan.equals("separacja"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (stan.equals("malzenstwo"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            
            if (praca.equals("emerytura")||praca.equals("renta"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (praca.equals("zlecenie")||praca.equals("wojsko"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (praca.equals("menager")||praca.equals("radny"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (praca.equals("prezes")||praca.equals("posel"))
            {
                zdolnosc=zdolnosc*1.3;
            }
            
            if (wyksztalcenie.equals("podstawowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (wyksztalcenie.equals("srednie"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (wyksztalcenie.equals("dr"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            
            if (statusmieszkaniowy.equals("wlasne"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            else if (statusmieszkaniowy.equals("sluzbowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (statusmieszkaniowy.equals("wynajem"))
            {
                zdolnosc=zdolnosc*0.9;
            }
            
            if (ile_w_domu>2)
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (ile_w_domu==1)
            {
                zdolnosc=zdolnosc*0.8;
            }
            
            /**
             * kredyty na dom itp
             */
            if (okres>240)
            {
                if (lacznydochod*okres/2*zdolnosc<kwota) 
                {
                    zdolnosc=0; //odmowa kredytu
                }
            }
            else if (lacznydochod*5*zdolnosc<kwota)
            {
                zdolnosc=0; //odmowa kredytu
            }
            // wartości do zmiany
            double prowizja=5/zdolnosc; 
            double oprocentowanie=7/zdolnosc; 
            String oprocentowanie1=String.format("%.2f", oprocentowanie);
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + rachunek + "", String.class);
            }
            catch (EmptyResultDataAccessException e) 
             {
		konto="";
             }		
            if (!currentPrincipalName.equals(konto))
            {
                return "redirect:/";
            }
            int id=0;
            try
            {
                id = jt.queryForObject("SELECT MAX(ID_kredytu) AS ID_kredytu FROM kredyty;",Integer.class);
            }
            catch (EmptyResultDataAccessException e) 
             {
		id=0;
             }	
            ++id;
            String SQL="INSERT INTO kredyty (ID_kredytu,kwota,waluta,oprocentowanie,termin_splaty,naliczone_odsetki,rachunkinumer_rachunku) VALUES ("+id+","+kwota+","+oprocentowanie1+",now()+interval "+okres+" month ,0,"+rachunek+");" ;
            jt.execute(SQL);
        return "redirect:/"; 
    }  
}
