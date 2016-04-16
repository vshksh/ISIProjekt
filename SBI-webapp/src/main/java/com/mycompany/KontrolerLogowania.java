package com.mycompany;


import com.mycompany.DataTransferObjects.FormularzLogowaniaDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@Controller
public class KontrolerLogowania {
    
 // @Autowired MieszkaniecRepository mieszRep;
    
  
    @RequestMapping(value="/logowanie", method=RequestMethod.GET)
    public ModelAndView reqLogowanieGET() {
        
         
        return new ModelAndView("stronaLogowania", "formularzLog", new FormularzLogowaniaDTO()); //Przekazuje nowy objekt tej klasy jako formularzLog
    }
    
     @RequestMapping(value = "/logowanie", method=RequestMethod.POST)
    public String reqLogowaniPOST(@ModelAttribute("FormularzLogowaniaDTO") @Valid FormularzLogowaniaDTO formularzLog, BindingResult result, Model model) {
             
                
        
        if(result.hasErrors())
        {
            return "stronaLogowania";
        }
            
        else 
        {
            /*
            Osoba osoba = new Osoba();
            osoba.setEmail(formularzLog.getEmail());
            osoba.setNazwisko(formularzLog.getNazwisko());
            */
            return "redirect:/zalogowano";
        }
        
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)   //logowanie do panelu administratora
    public String adminPage(Model model) {  //być może musi być ModelMap
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
    
    
    @RequestMapping(value="/wylogowanie", method = RequestMethod.GET)
       public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          if (auth != null){    
             new SecurityContextLogoutHandler().logout(request, response, auth);
          }
          return "indeks";
       }
    
    
    
    
    
    
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
  
    
}
