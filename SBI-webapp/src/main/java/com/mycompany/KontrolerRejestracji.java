package com.mycompany;


import com.mycompany.DataTransferObjects.KlientIndywidualnyDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class KontrolerRejestracji {
    //@Autowired
    
    @RequestMapping("/")//po podaniu tego w URL
    public String metoda() {
        return "glowna";//wyswietlony zostaje widok glowna.jsp
    }
    
    /**Metody dotyczące rejestracji **/
   
    @RequestMapping(value="/rejestracja", method=RequestMethod.GET)
    public ModelAndView reqRejestracjaGET() {
        
         
        return new ModelAndView("stronaRejestracji", "formularzRej", new KlientIndywidualnyDTO()); //Przekazuje nowy objekt tej klasy jako formularzRej
    }
    
     @RequestMapping(value = "/rejestracja", method=RequestMethod.POST)
    public String reqRejestracjaPOST(@ModelAttribute("FormularzRejestracjiDTO") @Valid KlientIndywidualnyDTO formularzRej, BindingResult result, Model model) {
                 
        if(result.hasErrors())
        {
            model.addAttribute("message", "Przepraszamy, coś poszło nie tak. Prosimy spróbować ponownie:"); //Nie jestem pewny czy nie wysłać nowego ModelAndView
            return "stronaRejestracji";
        }
            
        else 
        {
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
    
  
    
}
