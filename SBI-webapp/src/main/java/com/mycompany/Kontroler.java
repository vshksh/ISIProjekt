package com.mycompany;


import com.mycompany.DataTransferObjects.*;
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

/**
 * 
 * Ta klasa realizuje w odpowiedzi na żądania HTTP (GET i POST) wysyła strony do odbiorcy
 * W metodach mogą być realizowane różne operacje, które są potrzebne żeby odbiorcy wysłać potrzebne dane.
 * Używając tych samych adnotacji można zrobić więcej klas-kontrolerów.
 */
@Controller
public class Kontroler {

    
	@Autowired
	DataSource dataSource;
	
    

    @RequestMapping(value="/rejestracja", method=RequestMethod.GET)//Po podaniu "rejestracja" w URL
    public ModelAndView reqRejestracjaGET() {
        
         /* Metoda zwraca model (obiekt klasy KlientIndywidualnyDTO() jako formularzRej)
            oraz widok (stronę stronaRejestracji.jsp        
         */
        return new ModelAndView("stronaRejestracji", "formularzRej", new FormularzRejestracjiDTO());
    }
    /*
        Ta metoda jest wywoływana dla takiego samego URL, ale z żądaniem POST.
        Użytkownik najpierw wywołuje stonę z GET, więc metoda z GET tworzy model, który jest przekazywany metodzie z POST
        W niej realizowane jest to, co się dzieje po poprawnym lub niepoprawnym wypełnieniu formularza.
    */
     @RequestMapping(value = "/rejestracja", method=RequestMethod.POST)
    public String reqRejestracjaPOST(@ModelAttribute("formularzRej") @Valid FormularzRejestracjiDTO formularzRej, BindingResult result, Model model) {
                 
        if(result.hasErrors())
        {
            model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:");
            return "stronaRejestracji";
        }
            
        else 
        {
            JdbcTemplate jt = new JdbcTemplate(dataSource);
            jt.execute("INSERT INTO konta (login, haslo) VALUES ('" +  formularzRej.getLogin() + "', '" + formularzRej.getHaslo() + "');");
            jt.execute("INSERT INTO klienci_indywidualni (PESEL, imiona, nazwisko, telefon, adres_email, adres_korespondencji, kod_pocztowy, login_konta) VALUES ('" +  formularzRej.getPesel() + "', '" + formularzRej.getImiona() + "', '" + formularzRej.getNazwisko() + "', '" + formularzRej.getTelefon() + "', '" + formularzRej.getAdresEmail() + "', '" + formularzRej.getAdresKorespondencji() + "', '" + formularzRej.getKodPocztowy() + "', '" + formularzRej.getLogin() + "');");
            return "redirect:/login";
        }
        
    }
       @RequestMapping(value="/", method=RequestMethod.GET) //NIE DZIALA
    public ModelAndView reqStronaGlownaGET() {
       
    
       return new ModelAndView("index");
        
    }


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
                String nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
                String saldo = jt.queryForObject("SELECT saldo FROM `rachunki` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
                
                
                
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje rachunki:");
                modelAndView.addObject("nrRachunku", nrRachunku);
                modelAndView.addObject("saldo",saldo);
                //przekazywanie widoku (strony .jsp)
		modelAndView.setViewName("rachunki");
		return modelAndView;

	}
        
        
            	@RequestMapping(value =  "/mojekarty" , method = RequestMethod.GET)
	public ModelAndView mojeKartyPage() {
                
                String nrRachunku;
                String numerKarty;
                
                //tworzenie modelu i widoku
		ModelAndView modelAndView = new ModelAndView();              

                //Pobieranie informacji o logowaniu               
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                //Pobieranie nazwy zalogowanego użytkownika (aby użyć jej w zapytaniu)
                String currentPrincipalName = authentication.getName();
                
                
                //Tutaj jest drugi sposób na realizowanie operacji na bazie danych: przez zwykłe zapytnaia SQLowe.
                JdbcTemplate jt = new JdbcTemplate(dataSource);
                
                try
                {
                nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
                }catch (org.springframework.dao.EmptyResultDataAccessException e) { 
		nrRachunku = null;
                }
                try
                {
                numerKarty = jt.queryForObject("SELECT numer_karty FROM `karty` WHERE numer_rachunku = '" + nrRachunku + "'", String.class);
                } catch (org.springframework.dao.EmptyResultDataAccessException e) {
		numerKarty = null;
                    }
                //przekazywanie danych, które trzeba wyświetlić na stronie
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Moje karty:");
                modelAndView.addObject("nrRachunku", nrRachunku);
                
                if(numerKarty == null)
                    modelAndView.addObject("informacjaOKarcie", "Nie masz jeszcze żadnej karty.");
                else
                    modelAndView.addObject("numerKarty",numerKarty);
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
            String nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
            jt.execute("CALL nowa_karta(" + nrRachunku + ", " + karta.getNazwa() + ", " + karta.getPIN() + ", @cvc, @nr)");

            
            return "redirect:/mojekarty";
         }
    }
    
         @RequestMapping(value="/przelew", method=RequestMethod.GET)//Po podaniu "rejestracja" w URL
    public ModelAndView reqPrzelewGET() {
        
        return new ModelAndView("nowyprzelew", "przelew", new PrzelewDTO());
    }
    
    
    
     @RequestMapping(value = "/przelew", method=RequestMethod.POST)
    public String reqPrzelewPOST(@ModelAttribute("przelew") @Valid PrzelewDTO przelew, BindingResult result, Model model) {
                 
         if(result.hasErrors())
        {
            model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:");
            return "zalogowano";
        }
        else
         {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();


            JdbcTemplate jt = new JdbcTemplate(dataSource);
            String nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
            jt.execute("CALL nowy_przelew(" + nrRachunku + ", " + przelew.getRachunekDoc() + ", " + przelew.getKwota() + ",  '" + przelew.getWaluta() + "',  '" + przelew.getTytul() + "', @ou)");

            
            return "redirect:/zalogowano";
         }
    }
        
        
    	@RequestMapping(value =  "/zalogowano" , method = RequestMethod.GET)
	public ModelAndView zalogowanoPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Witamy!");
		modelAndView.setViewName("kontoIndywidualne"); //nazwa strony .jsp zwracanej po wywolaniu metody
		return modelAndView;

	}
    
}
