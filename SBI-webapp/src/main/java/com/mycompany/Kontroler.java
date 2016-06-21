package com.mycompany;


import com.mycompany.DataTransferObjects.*;
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
 * Ta klasa realizuje w odpowiedzi na ĹĽÄ…dania HTTP (GET i POST) wysyĹ‚a strony do odbiorcy
 * W metodach mogÄ… byÄ‡ realizowane rĂłĹĽne operacje, ktĂłre sÄ… potrzebne ĹĽeby odbiorcy wysĹ‚aÄ‡ potrzebne dane.
 * UĹĽywajÄ…c tych samych adnotacji moĹĽna zrobiÄ‡ wiÄ™cej klas-kontrolerĂłw.
 */
@Controller
public class Kontroler {

    
	@Autowired
	DataSource dataSource;
	
    

    @RequestMapping(value="/rejestracja", method=RequestMethod.GET)//Po podaniu "rejestracja" w URL
    public ModelAndView reqRejestracjaGET() {
        
         /* Metoda zwraca model (obiekt klasy KlientIndywidualnyDTO() jako formularzRej)
            oraz widok (stronÄ™ stronaRejestracji.jsp        
         */
        return new ModelAndView("stronaRejestracji", "formularzRej", new FormularzRejestracjiDTO());
    }
    /*
        Ta metoda jest wywoĹ‚ywana dla takiego samego URL, ale z ĹĽÄ…daniem POST.
        UĹĽytkownik najpierw wywoĹ‚uje stonÄ™ z GET, wiÄ™c metoda z GET tworzy model, ktĂłry jest przekazywany metodzie z POST
        W niej realizowane jest to, co siÄ™ dzieje po poprawnym lub niepoprawnym wypeĹ‚nieniu formularza.
    */
     @RequestMapping(value = "/rejestracja", method=RequestMethod.POST)
    public String reqRejestracjaPOST(@ModelAttribute("formularzRej") @Valid FormularzRejestracjiDTO formularzRej, BindingResult result, Model model) {
                 
        if(result.hasErrors())
        {
            model.addAttribute("message", "Przepraszamy, coĹ› poszĹ‚o nie tak. Prosimy sprĂłbowaÄ‡ ponownie:");
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

    
    

        
        
    	@RequestMapping(value =  "/zalogowano" , method = RequestMethod.GET)
	public ModelAndView zalogowanoPage() 
        {
            ModelAndView modelAndView = new ModelAndView();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            JdbcTemplate jt = new JdbcTemplate(dataSource);           
            String typ = jt.queryForObject("SELECT rola FROM `konta` WHERE login = '" + currentPrincipalName + "'", String.class);
            if (typ.equals("USER"))
            {
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Witamy!");

		modelAndView.setViewName("logged"); //nazwa strony .jsp zwracanej po wywolaniu metody
		return modelAndView;

            }
            
            else if (typ.equals("ADMIN"))
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("kontoAdmina");
            }
            
            else if (typ.equals("BANK"))
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("kontoBankiera");       
            }
            else 
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("brakuprawnien");
            }
            return modelAndView;
        }


}
