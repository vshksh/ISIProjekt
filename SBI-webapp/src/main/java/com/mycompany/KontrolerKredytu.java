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
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.SessionAttributes;

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
    public ModelAndView reqKredytGET(HttpServletRequest request) 
    {
        DaneKredyt DaneKredyt1=new DaneKredyt();
        request.getSession().setAttribute("DaneKredyt1",DaneKredyt1);
        return new ModelAndView("DaneDoKredytu", "formularzKr", new DaneKredyt());
    }
    
    @RequestMapping(value = "/kredyt", method=RequestMethod.POST)
    public String reqKredytPOST(HttpServletRequest request,
            @RequestParam (value = "action") String action,
            @RequestParam(value = "formazatrudnienia") String praca,
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
        DaneKredyt DaneKredyt1=(DaneKredyt)request.getSession().getAttribute("DaneKredyt1");
        DaneKredyt1.setFormazatrudnienia(praca);
        DaneKredyt1.setKwota(kwota);
        DaneKredyt1.setOkres(okres);
        DaneKredyt1.setStancywilny(stan);
        DaneKredyt1.setWyksztalcenie(wyksztalcenie);
        DaneKredyt1.setStatusmieszkaniowy(statusmieszkaniowy);
        DaneKredyt1.setIle_w_domu(ile_w_domu);
        DaneKredyt1.setLacznydochod(lacznydochod);
        DaneKredyt1.setWaluta(waluta);
        DaneKredyt1.setRachunek(rachunek);
        request.getSession().setAttribute("DaneKredyt1",DaneKredyt1);
        if ( action.equals("Strona glowna") )
        {
            return "redirect:/"; 
        }
        else if ( action.equals("Sprawdz dostepny kredyt") )
        {
           return "redirect:/oferta"; 
        }
        else
        {
            return "redirect:/blad"; // nie powinno to nigdy wyjsc i poki co prowadzi w puste miejsce, można potem wstawić jakąś stronę błędu
        }       
    }
    
    
    @RequestMapping(value = "/oferta", method=RequestMethod.GET)
    public ModelAndView reqOfertaGET(HttpServletRequest request)   
        {
            DaneKredyt DaneKredyt1=(DaneKredyt)request.getSession().getAttribute("DaneKredyt1");
            JdbcTemplate jt = new JdbcTemplate(dataSource);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            String konto="";
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + DaneKredyt1.getRachunek() + "", String.class);
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
            
            
            if (DaneKredyt1.getStancywilny().equals("separacja"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (DaneKredyt1.getStancywilny().equals("malzenstwo"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            
            if (DaneKredyt1.getFormazatrudnienia().equals("emerytura")||DaneKredyt1.getFormazatrudnienia().equals("renta"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (DaneKredyt1.getFormazatrudnienia().equals("zlecenie")||DaneKredyt1.getFormazatrudnienia().equals("wojsko"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (DaneKredyt1.getFormazatrudnienia().equals("menager")||DaneKredyt1.getFormazatrudnienia().equals("radny"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (DaneKredyt1.getFormazatrudnienia().equals("prezes")||DaneKredyt1.getFormazatrudnienia().equals("posel"))
            {
                zdolnosc=zdolnosc*1.3;
            }
            
            if (DaneKredyt1.getWyksztalcenie().equals("podstawowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (DaneKredyt1.getWyksztalcenie().equals("srednie"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (DaneKredyt1.getWyksztalcenie().equals("dr"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            
            if (DaneKredyt1.getStatusmieszkaniowy().equals("wlasne"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            else if (DaneKredyt1.getStatusmieszkaniowy().equals("sluzbowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (DaneKredyt1.getStatusmieszkaniowy().equals("wynajem"))
            {
                zdolnosc=zdolnosc*0.9;
            }
            
            if (DaneKredyt1.getIle_w_domu()>2)
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (DaneKredyt1.getIle_w_domu()==1)
            {
                zdolnosc=zdolnosc*0.8;
            }
            
            /**
             * kredyty na dom itp
             */
            if (DaneKredyt1.getOkres()>240)
            {
                if (DaneKredyt1.getLacznydochod()*DaneKredyt1.getOkres()/2*zdolnosc<DaneKredyt1.getKwota()) 
                {
                    zdolnosc=0; //odmowa kredytu
                }
            }
            else if (DaneKredyt1.getLacznydochod()*5*zdolnosc<DaneKredyt1.getKwota())
            {
                zdolnosc=0; //odmowa kredytu
            }
            // wartości do zmiany
            double prowizja=2/zdolnosc; 
            double oprocentowanie=6/zdolnosc; 
            DaneKredyt1.setProwizja(prowizja);
            DaneKredyt1.setOprocentowanie(oprocentowanie);
            DaneKredyt1.setZdolnosc_kredytowa(zdolnosc);
            request.getSession().setAttribute("DaneKredyt1",DaneKredyt1);
            
             return new ModelAndView("DaneDoOferty", "formularzOf", DaneKredyt1);
        }
    
    @RequestMapping(value = "/oferta", method=RequestMethod.POST)
    public String reqOfertaPOST(@RequestParam (value = "action") String action)   
        {
            if ( action.equals("Strona glowna") )
            {
                return "redirect:/"; 
            }
            else if ( action.equals("zmiana danych") )
            {
                return "redirect:/kredyt"; 
            }
            else if ( action.equals("Wez kredyt") )
            {
                return "redirect:/bierzkredyt"; 
            }
            else
            {
                return "redirect:/blad"; // nie powinno to nigdy wyjsc i poki co prowadzi w puste miejsce, można potem wstawić jakąś stronę błędu
            }    
        }
    
    @RequestMapping(value = "/bierzkredyt", method=RequestMethod.GET)
    public String reqbierzkredytGET(HttpServletRequest request)  
    {
        DaneKredyt DaneKredyt1=(DaneKredyt)request.getSession().getAttribute("DaneKredyt1");
        JdbcTemplate jt = new JdbcTemplate(dataSource);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            String konto="";
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + DaneKredyt1.getRachunek() + "", String.class);
            }
             catch (EmptyResultDataAccessException e) 
             {
		konto="";
             }		
            if (!currentPrincipalName.equals(konto))
            {
                return "redirect:/";
            }
            
            String oprocentowanie1=String.format("%.2f", DaneKredyt1.getOprocentowanie()); // źle to formatuje
            try 
            {	
                konto = jt.queryForObject("SELECT kontaID_konta FROM `rachunki` WHERE numer_rachunku = " + DaneKredyt1.getRachunek() + "", String.class);
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
            String SQL="INSERT INTO kredyty (ID_kredytu,kwota,waluta,oprocentowanie,termin_splaty,naliczone_odsetki,rachunkinumer_rachunku) VALUES ("+id+","+DaneKredyt1.getKwota()+","+oprocentowanie1+",now()+interval "+DaneKredyt1.getOkres()+" month ,0,"+DaneKredyt1.getRachunek()+");" ;
            jt.execute(SQL);
            String typ = jt.queryForObject("SELECT rola FROM `konta` WHERE login = '" + currentPrincipalName + "'", String.class);
            // poniewaz trzeba miec rachunek żeby wziąć kredyt, powinno zawsze wracać na stronę zalogowanego użytkownika
            if (typ.equals("USER")||typ.equals("ADMIN")||typ.equals("BANK"))
            {
		return "redirect:/zalogowano";
            }
            else
            {
                 return "redirect:/"; //jakby ktoś miał czas to można zrobić jakąś stronę w stylu "gratki, udało ci się wziąć kredyt
            }
           
    }  
}
