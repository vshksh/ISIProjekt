/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.DataTransferObjects.KartaDTO;
import com.mycompany.DataTransferObjects.KartaMapper;
import com.mycompany.DataTransferObjects.PrzelewDTO;
import com.mycompany.DataTransferObjects.PrzelewMapper;
import java.util.List;
import javax.sql.DataSource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jeremiasz
 */
@Controller
public class KontrolerPrzelewow {

  
	@Autowired
	DataSource dataSource;
	

                   	@RequestMapping(value =  "/histprzelewow" , method = RequestMethod.GET)
	public ModelAndView mojeKartyPage() {
                
                String nrRachunku;
                JdbcTemplate jt = new JdbcTemplate(dataSource);
                
                //tworzenie modelu i widoku
		ModelAndView modelAndView = new ModelAndView();              

                //Pobieranie informacji o logowaniu               
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                //Pobieranie nazwy zalogowanego użytkownika (aby użyć jej w zapytaniu)
                String currentPrincipalName = authentication.getName();
                

                
                try
                {
                    nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'", String.class);
                }catch (org.springframework.dao.EmptyResultDataAccessException e) { 
                    nrRachunku = null;
                }
                
                String SQL = "SELECT * FROM `przelewy_zewnetrzne` WHERE rachunek_zleceniodawcy = '" + nrRachunku + "'";
                List<PrzelewDTO> przelew = jt.query(SQL, new PrzelewMapper());
                
                //do zmiennych przekazywane sa obiekty z listy
                int kartaCount = przelew.size();
                if(kartaCount>0)
                {   
                    modelAndView.addObject("infODaciePrzel1", "Data przelewu: ");
                    modelAndView.addObject("infOTytulePrzel1", "Tytul: ");
                    modelAndView.addObject("infORachOdb1", "Rachunek docelowy: ");
                    modelAndView.addObject("dataWykPrzel1", przelew.get(0).getDataWykonania());
                    modelAndView.addObject("tytulPrzelewu1",przelew.get(0).getTytul());
                    modelAndView.addObject("rachunekOdbiorcy1", przelew.get(0).getRachunekOdbiorcy());

                    if(kartaCount>1)
                    {   
                        modelAndView.addObject("infODaciePrzel2", "Data przelewu: ");
                        modelAndView.addObject("infOTytulePrzel2", "Tytul: ");
                        modelAndView.addObject("infORachOdb2", "Rachunek docelowy: ");
                        modelAndView.addObject("dataWykPrzel2", przelew.get(1).getDataWykonania());
                        modelAndView.addObject("tytulPrzelewu2",przelew.get(1).getTytul());
                        modelAndView.addObject("rachunekOdbiorcy2", przelew.get(1).getRachunekOdbiorcy());

                        if(kartaCount>2)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel3", przelew.get(2).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu3",przelew.get(2).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy3", przelew.get(2).getRachunekOdbiorcy());

                        }
                        if(kartaCount>3)
                        {   
                            modelAndView.addObject("infODaciePrzel4", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel4", "Tytul: ");
                            modelAndView.addObject("infORachOdb4", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel4", przelew.get(3).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu4",przelew.get(3).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy4", przelew.get(3).getRachunekOdbiorcy());

                        }
                        if(kartaCount>4)
                        {   
                            modelAndView.addObject("infODaciePrzel5", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel5", "Tytul: ");
                            modelAndView.addObject("infORachOdb5", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel5", przelew.get(4).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu5",przelew.get(4).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy5", przelew.get(4).getRachunekOdbiorcy());

                        }
                        if(kartaCount>5)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel6", przelew.get(5).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu6",przelew.get(5).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy6", przelew.get(5).getRachunekOdbiorcy());

                        }
                        if(kartaCount>6)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel7", przelew.get(6).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu7",przelew.get(6).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy7", przelew.get(6).getRachunekOdbiorcy());

                        }
                        if(kartaCount>7)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel8", przelew.get(7).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu8",przelew.get(7).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy8", przelew.get(7).getRachunekOdbiorcy());

                        }
                        if(kartaCount>8)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel9", przelew.get(8).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu9",przelew.get(8).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy9", przelew.get(8).getRachunekOdbiorcy());

                        }
                        if(kartaCount>9)
                        {   
                            modelAndView.addObject("infODaciePrzel3", "Data przelewu: ");
                            modelAndView.addObject("infOTytulePrzel3", "Tytul: ");
                            modelAndView.addObject("infORachOdb3", "Rachunek docelowy: ");
                            modelAndView.addObject("dataWykPrzel10", przelew.get(9).getDataWykonania());
                            modelAndView.addObject("tytulPrzelewu10",przelew.get(9).getTytul());
                            modelAndView.addObject("rachunekOdbiorcy10", przelew.get(9).getRachunekOdbiorcy());
                        }
                    }
                }
                else
                {
                    modelAndView.addObject("informacjaOPrzelewach", "Nie wykonałeś jeszcze żadnego przelewu.");
                }
                
                
                
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje karty:");
                modelAndView.addObject("nrRachunku", nrRachunku);
                
               //przekazywanie widoku (strony .jsp)
		modelAndView.setViewName("przelewy");
		return modelAndView;

	}
        
                @RequestMapping(value="/nowyprzelew", method=RequestMethod.GET)
           public ModelAndView reqNowaKartaGET() {

               return new ModelAndView("nowyprzelew", "przelew", new PrzelewDTO());
           }

            @RequestMapping(value = "/nowyprzelew", method=RequestMethod.POST)
           public String reqNowaKartaPOST(@ModelAttribute("przelew") @Valid PrzelewDTO przelew, BindingResult result, Model model) {

                if(result.hasErrors())
               {
                   model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:");
                   return "nowyprzelew";
               }
               else
                {
                   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                   String currentPrincipalName = authentication.getName();

                   JdbcTemplate jt = new JdbcTemplate(dataSource);
                   String nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'", String.class);
                   String czyRachunekWNaszymBanku ="";
                   try{
                       czyRachunekWNaszymBanku = jt.queryForObject("SELECT * FROM rachunki where numer_rachunku = '" + przelew.getRachunekOdbiorcy() + "'", String.class );
                    }
                   catch(org.springframework.dao.EmptyResultDataAccessException e)
                   {    
                       
                   }
                   
                   if(czyRachunekWNaszymBanku.isEmpty())
                   {
                       if(przelew.getKwota() > 50000 )
                       {
                           jt.execute("");
                       }
                       else
                       {
                           jt.execute("INSERT INTO przelewy_zewnetrzne (kwota, data_zlecenia, data_wykonania, status, tytul, rachunek_zleceniodawcy, rachunek_odbiorcy) VALUES (" +
                                przelew.getKwota() + ", date(now()), date(date_add(now(), interval 1 day)),  'O', '" + przelew.getTytul() + "', '" + nrRachunku + "', '" + przelew.getRachunekOdbiorcy() +
                                    "')");
                           
                           jt.execute("UPDATE `rachunki` SET `saldo` = saldo - " + przelew.getKwota() + " WHERE `rachunki`.`numer_rachunku` = '" + nrRachunku + "';");
                           
                           
                           
                       }
                   }
                   else
                   {
                       if(przelew.getKwota() > 50000 )
                       {
                           jt.execute("");
                       }
                       else
                       {
                            jt.execute("INSERT INTO przelewy_wewnetrzne (kwota, data_zlecenia, data_wykonania, status, tytul, rachunek_zleceniodawcy, rachunek_odbiorcy) VALUES (" +
                                   przelew.getKwota() + ",date(now()), date(date_add(now(), interval 1 day)), 'W', '" + przelew.getTytul() + "', '" + nrRachunku + "', '" + przelew.getRachunekOdbiorcy() +
                                    "')");
                            jt.execute("UPDATE `rachunki` SET `saldo` = saldo - " + przelew.getKwota() + " WHERE `rachunki`.`numer_rachunku` = '" + nrRachunku + "';");
                            
                            
                       }
                   }
                   


                   return "redirect:/histprzelewow";
                }
           }
        
    
}