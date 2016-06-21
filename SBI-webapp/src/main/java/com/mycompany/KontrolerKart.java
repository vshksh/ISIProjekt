/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;


import com.mycompany.DataTransferObjects.KartaDTO;
import com.mycompany.DataTransferObjects.KartaMapper;
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
public class KontrolerKart {

    
	@Autowired
	DataSource dataSource;
	

                   	@RequestMapping(value =  "/mojekarty" , method = RequestMethod.GET)
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
                
                String SQL = "SELECT * FROM `karty` WHERE numer_rachunku = '" + nrRachunku + "'";
                //KartaMapper to klasa, ktora przypisuje to co zwroci query do nowo powstalych obiektow listy
                //implementuje RowMapper, jest bardzo prosta, musi byc cos takiego jesli chce sie miec >1 wynikow
                List<KartaDTO> karta = jt.query(SQL, new KartaMapper());
                
                //do zmiennych przekazywane sa obiekty z listy
                int kartaCount = karta.size();
                if(kartaCount>0)
                {   
                    modelAndView.addObject("infONrKarty1", "Numer karty płatniczej: ");
                    modelAndView.addObject("infODacieWaz1", "Data ważności: ");
                    modelAndView.addObject("infOLimicie1", "Limit: ");
                    modelAndView.addObject("infOStatusie1", "Status: ");
                    modelAndView.addObject("nrKarty1", karta.get(0).getNumerKarty());
                    modelAndView.addObject("dataWaznosciKarty1",karta.get(0).getDataWaznosci());
                    modelAndView.addObject("limitKarty1", karta.get(0).getLimitKarty());
                    String statusKarty1;
                    if(karta.get(0).getStatusKarty()==1)
                        statusKarty1 = "aktywna";
                        else
                        {
                           statusKarty1 = (karta.get(0).getStatusKarty()==3) ? "zablokowana" : "nieaktywna";
                                
                        }
                    modelAndView.addObject("statusKarty1", statusKarty1);
                    if(kartaCount>1)
                    {   
                        modelAndView.addObject("infONrKarty2", "Numer karty płatniczej 2: ");
                        modelAndView.addObject("infODacieWaz2", "Data ważności: ");
                        modelAndView.addObject("infOLimicie2", "Limit: ");
                        modelAndView.addObject("infOStatusie2", "Status: ");
                        modelAndView.addObject("nrKarty2", karta.get(1).getNumerKarty());
                        modelAndView.addObject("dataWaznosciKarty2",karta.get(1).getDataWaznosci());
                        modelAndView.addObject("limitKarty2", karta.get(1).getLimitKarty());
                            String statusKarty2;
                        if(karta.get(0).getStatusKarty()==1)
                            statusKarty2 = "aktywna";
                            else
                            {
                               statusKarty2 = (karta.get(1).getStatusKarty()==3) ? "zablokowana" : "nieaktywna";

                            }
                        modelAndView.addObject("statusKarty2", statusKarty2);
                        if(kartaCount>2)
                        {   
                            modelAndView.addObject("infONrKarty3", "Numer karty płatniczej 3: ");
                            modelAndView.addObject("infODacieWaz3", "Data ważności: ");
                            modelAndView.addObject("infOLimicie3", "Limit: ");
                            modelAndView.addObject("infOStatusie3", "Status: ");
                            modelAndView.addObject("nrKarty3", karta.get(2).getNumerKarty());
                            modelAndView.addObject("dataWaznosciKarty3",karta.get(2).getDataWaznosci());
                            modelAndView.addObject("limitKarty3", karta.get(2).getLimitKarty());
                            String statusKarty3;
                            if(karta.get(2).getStatusKarty()==1)
                                statusKarty3 = "aktywna";
                                else
                                {
                                   statusKarty3 = (karta.get(2).getStatusKarty()==3) ? "zablokowana" : "nieaktywna";

                                }
                            modelAndView.addObject("statusKarty3", statusKarty3);
                        }
                    }
                }
                else
                {
                    modelAndView.addObject("informacjaOKarcie", "Nie masz jeszcze żadnej karty.");
                }
                
                
                
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje karty:");
                modelAndView.addObject("nrRachunku", nrRachunku);
                
               //przekazywanie widoku (strony .jsp)
		modelAndView.setViewName("mojekarty");
		return modelAndView;

	}
        
                @RequestMapping(value="/nowakarta", method=RequestMethod.GET)//Po podaniu "rejestracja" w URL
           public ModelAndView reqNowaKartaGET() {

               return new ModelAndView("nowakarta", "karta", new KartaDTO());
           }

            @RequestMapping(value = "/nowakarta", method=RequestMethod.POST)
           public String reqNowaKartaPOST(@ModelAttribute("karta") @Valid KartaDTO karta, BindingResult result, Model model) {

                if(result.hasErrors())
               {
                   model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:");
                   return "mojekarty";
               }
               else
                {
                   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                   String currentPrincipalName = authentication.getName();


                   JdbcTemplate jt = new JdbcTemplate(dataSource);
                   String nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'", String.class);
                   
                   jt.execute("SET @p1='" + nrRachunku + "'; SET @p2='"+ karta.getPIN() + "'; SET @p3='" + karta.getLimitKarty() + "'; CALL `dodaj_karte`(@p0, @p1, @p2, @p3); SELECT @p0 AS `@new_karta`;"); 
                   


                   return "redirect:/mojekarty";
                }
           }
        
    
}
