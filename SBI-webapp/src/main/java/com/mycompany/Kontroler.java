package com.mycompany;


import com.mycompany.DataTransferObjects.KlientIndywidualnyDTO;
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
        return new ModelAndView("stronaRejestracji", "formularzRej", new KlientIndywidualnyDTO());
    }
    /*
        Ta metoda jest wywoływana dla takiego samego URL, ale z żądaniem POST.
        Użytkownik najpierw wywołuje stonę z GET, więc metoda z GET tworzy model, który jest przekazywany metodzie z POST
        W niej realizowane jest to, co się dzieje po poprawnym lub niepoprawnym wypełnieniu formularza.
    */
     @RequestMapping(value = "/rejestracja", method=RequestMethod.POST)
    public String reqRejestracjaPOST(@ModelAttribute("FormularzRejestracjiDTO") @Valid KlientIndywidualnyDTO formularzRej, BindingResult result, Model model) {
                 
        if(result.hasErrors())
        {
            model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:");
            return "stronaRejestracji";
        }
            
        else 
        {
            /*  Jest to jeden sposób na realizowanie operacji na bazie danych.
                Za pomocą EntityManagerFactory dokonuje się tu zapisywanie nowego użytkownika do bazy
                Którego dane zostały wprowadzone za pomocą formularza rejestracji.
                Obiekt formularzRej jest klasy KlientIndywidualnyDTO, który jest zmapowaniem tabeli z bazy.            
                (jest trochę niefortunnie nazwany, pewnie to zmienię)
            */
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU2");
            EntityManager em;
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(formularzRej);
            em.getTransaction().commit();
            em.close();
            return "redirect:/zarejestrowano";
        }
        
    }
    /*    @RequestMapping(value="/", method=RequestMethod.GET)
    public String reqStronaGlownaGET() {
        
        nie działa
    
        return "glowna";
        
    }*/

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
        
        
    	@RequestMapping(value =  "/zalogowano" , method = RequestMethod.GET)
	public ModelAndView zalogowanoPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Witamy!");
		modelAndView.setViewName("zalogowano"); //nazwa strony .jsp zwracanej po wywolaniu metody
		return modelAndView;

	}
    
}
