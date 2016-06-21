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

@Controller
public class KontrolerRachunkow {

    
	@Autowired
	DataSource dataSource;
	

            	@RequestMapping(value =  "/rachunki" , method = RequestMethod.GET)
	public ModelAndView rachunkiPage() {

                //tworzenie modelu i widoku
		ModelAndView modelAndView = new ModelAndView();              

                //Pobieranie informacji o logowaniu               
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                //Pobieranie nazwy zalogowanego użytkownika (aby użyć jej w zapytaniu)
                String currentPrincipalName = authentication.getName();
                
                
                //Tutaj jest drugi sposób na realizowanie operacji na bazie danych: przez zwykłe zapytnaia SQLowe.
                JdbcTemplate jt = new JdbcTemplate(dataSource);
                String SQL = "SELECT * FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'";

                //RachunkiMapper to klasa, ktora przypisuje to co zwroci query do nowo powstalych obiektow listy
                //implementuje RowMapper, jest bardzo prosta, musi byc cos takiego jesli chce sie miec >1 wynikow
                List<RachunkiDTO> rachunek = jt.query(SQL, new RachunkiMapper());
                
                
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje rachunki:");
                
                //do zmiennych przekazywane sa obiekty z listy
                int rachunekCount = rachunek.size();
                if(rachunekCount>0)
                {
                    modelAndView.addObject("infORachunku1", "Numer rachunku:");
                    modelAndView.addObject("infOSaldzie1", "Saldo:");
                    modelAndView.addObject("nrRachunku1", rachunek.get(0).getNumerRachunku());
                    modelAndView.addObject("saldo1",rachunek.get(0).getSaldo());
                    if(rachunekCount>1)
                    {   
                        modelAndView.addObject("infORachunku2", "Numer rachunku 2:");
                        modelAndView.addObject("infOSaldzie2", "Saldo rachunku nr 2:");
                        modelAndView.addObject("nrRachunku2", rachunek.get(1).getNumerRachunku());
                        modelAndView.addObject("saldo2",rachunek.get(1).getSaldo());
                        if(rachunekCount>2)
                        {
                            modelAndView.addObject("infORachunku3", "Numer rachunku 3:");
                            modelAndView.addObject("infOSaldzie3", "Saldo rachunku nr 3:");
                            modelAndView.addObject("nrRachunku3", rachunek.get(2).getNumerRachunku());
                            modelAndView.addObject("saldo3",rachunek.get(2).getSaldo());
                        }
                    }
                }
                else
                {
                    modelAndView.addObject("brakRachunku", "Nie otworzyles jeszcze w naszym banku rachunku.");
                }
                //przekazywanie widoku (strony .jsp)
		modelAndView.setViewName("rachunki");
		return modelAndView;

	}
        
    
}
