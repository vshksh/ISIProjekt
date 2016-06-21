/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.DataTransferObjects.*;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * Ta klasa realizuje w odpowiedzi na żądania HTTP (GET i POST) wysyła strony do odbiorcy
 * W metodach mogą być realizowane różne operacje, które są potrzebne żeby odbiorcy wysłać potrzebne dane.
 * Używając tych samych adnotacji można zrobić więcej klas-kontrolerów.
 */
@Controller
public class KontrolerLokat {

    
	@Autowired
	DataSource dataSource;
	

            	@RequestMapping(value =  "/lokaty" , method = RequestMethod.GET)
	public ModelAndView rachunkiPage() {

                //tworzenie modelu i widoku
		ModelAndView modelAndView = new ModelAndView();              

                //Pobieranie informacji o logowaniu               
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                //Pobieranie nazwy zalogowanego użytkownika (aby użyć jej w zapytaniu)
                String currentPrincipalName = authentication.getName();
                
                
                //Tutaj jest drugi sposób na realizowanie operacji na bazie danych: przez zwykłe zapytnaia SQLowe.
                JdbcTemplate jt = new JdbcTemplate(dataSource);
                String  nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'", String.class);
                
                String SQL = "SELECT * FROM `lokaty` WHERE rachunkinumer_rachunku = '" + nrRachunku + "'";
                List<LokatyDTO> lokaty = jt.query(SQL, new LokatyMapper());
                
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje Lokaty:");
                
                //do zmiennych przekazywane sa obiekty z listy
                int lokatyCount = lokaty.size();
                if(lokatyCount>0)
                {   
                    modelAndView.addObject("infODacieZalLokaty1", "Data zalożenia lokaty: ");
                    modelAndView.addObject("infODacieZakLokaty1", "Data zakończenia: ");
                    modelAndView.addObject("infOKwocie1", "Kwota: ");
                    modelAndView.addObject("infONaliczeniach1", "Odsetki: ");
                    modelAndView.addObject("infOProcencie1", "Oprocentowanie: ");
                    modelAndView.addObject("proc1", "%");
                    modelAndView.addObject("dataZalLokaty1", lokaty.get(0).getDataZalozenia());
                    modelAndView.addObject("dataZakLokaty1", lokaty.get(0).getTerminZakonczenia());
                    modelAndView.addObject("kwotaLokaty1", lokaty.get(0).getKwota());
                    modelAndView.addObject("odsetkiLokaty1", lokaty.get(0).getNaliczenia());
                    modelAndView.addObject("procentLokaty1", lokaty.get(0).getProcent());
                    
                    if(lokatyCount>1)
                    {   
                        modelAndView.addObject("infODacieZalLokaty2", "Data zalożenia lokaty numer 2: ");
                        modelAndView.addObject("infODacieZakLokaty2", "Data zakończenia: ");
                        modelAndView.addObject("infOKwocie2", "Kwota: ");
                        modelAndView.addObject("infONaliczeniach2", "Odsetki: ");
                        modelAndView.addObject("infOProcencie2", "Oprocentowanie: ");
                        modelAndView.addObject("proc2", "%");
                        modelAndView.addObject("dataZalLokaty1", lokaty.get(1).getDataZalozenia());
                        modelAndView.addObject("dataZakLokaty1", lokaty.get(1).getTerminZakonczenia());
                        modelAndView.addObject("kwotaLokaty1", lokaty.get(1).getKwota());
                        modelAndView.addObject("odsetkiLokaty1", lokaty.get(1).getNaliczenia());
                        modelAndView.addObject("procentLokaty1", lokaty.get(1).getProcent());
                        
                        if(lokatyCount>2)
                        {   
                            modelAndView.addObject("infODacieZalLokaty3", "Data zalożenia lokaty numer 3: ");
                            modelAndView.addObject("infODacieZakLokaty3", "Data zakończenia: ");
                            modelAndView.addObject("infOKwocie3", "Kwota: ");
                            modelAndView.addObject("infONaliczeniach3", "Odsetki: ");
                            modelAndView.addObject("infOProcencie3", "Oprocentowanie: ");
                            modelAndView.addObject("proc3", "%");
                            modelAndView.addObject("dataZalLokaty1", lokaty.get(2).getDataZalozenia());
                            modelAndView.addObject("dataZakLokaty1", lokaty.get(2).getTerminZakonczenia());
                            modelAndView.addObject("kwotaLokaty1", lokaty.get(2).getKwota());
                            modelAndView.addObject("odsetkiLokaty1", lokaty.get(2).getNaliczenia());
                            modelAndView.addObject("procentLokaty1", lokaty.get(2).getProcent());
                            
                        }
                    }
                }
                else
                {
                    modelAndView.addObject("informacjaOKarcie", "Nie masz jeszcze żadnej karty.");
                }
                //przekazywanie widoku (strony .jsp)
		modelAndView.setViewName("lokaty");
		return modelAndView;

	}
        
    
}