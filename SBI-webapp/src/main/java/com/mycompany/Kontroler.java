<<<<<<< HEAD

package com.mycompany;

=======
package com.mycompany;


>>>>>>> refs/remotes/origin/przemek
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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
=======
>>>>>>> refs/remotes/origin/przemek

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
            jt.execute("CALL nowy_przelew(" + nrRachunku + ", " + przelew.getRachunekDoc() + ", " + przelew.getKwota() + ",  '" + przelew.getWaluta() + "',  '" + przelew.getTytul() + "')");

            
            return "redirect:/zalogowano";
         }
    }
        
<<<<<<< HEAD
    /**
     * przechodzi na odpowiednia strone w zależności od typu zalogowanego użytkownika
     * spytać się czy da się to otrzymać od razu z security bez sqla
     */
        
    	@RequestMapping(value =  "/zalogowano" , method = RequestMethod.GET)
	public ModelAndView zalogowanoPage() 
        {
            ModelAndView modelAndView = new ModelAndView();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            JdbcTemplate jt = new JdbcTemplate(dataSource);           
            String typ = jt.queryForObject("SELECT rola FROM `konta` WHERE nazwa_konta = '" + currentPrincipalName + "'", String.class);
            if (typ.equals("USER"))
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("kontoIndywidualne"); //nazwa strony .jsp zwracanej po wywolaniu metody
            }
            
            else if (typ.equals("ADMIN"))
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("kontoAdmina"); //nazwa strony .jsp zwracanej po wywolaniu metody
            }
            
            else if (typ.equals("BANK"))
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("kontoBankiera"); //nazwa strony .jsp zwracanej po wywolaniu metody
            }
            else 
            {
                modelAndView.addObject("title", "System Bankowosci Internetowej");
                modelAndView.addObject("message", "Witamy!");
                modelAndView.setViewName("NiepoprawnyTyp"); //nazwa strony .jsp zwracanej po wywolaniu metody
            }
            
            
            return modelAndView;

	}
        
         @RequestMapping(value="/kredyt", method=RequestMethod.GET)
    public ModelAndView reqKredytGET() 
    {       
        return new ModelAndView("DaneDoKredytu", "formularzKr", new DaneKredyt());
    }
    
    @RequestMapping(value = "/kredyt", method=RequestMethod.POST)
    public String reqKredytPOST(@RequestParam String action) 
    {
        if( action.equals("zmiana danych") )
        {
            return "redirect:/kredyt";
        }
        else if ( action.equals("Strona glowna") )
        {
            return "redirect:/"; 
        }
        else if ( action.equals("Sprawdz dostepny kredyt") )
        {
           return "forward:/oferta"; 
        }
        else
        {
            return "redirect:/blad"; // nie powinno to nigdy wyjsc i poki co prowadzi w puste miejsce, można potem wstawić jakąś stronę błędu
        }       
    }
    
    @RequestMapping(value = "/oferta", method=RequestMethod.POST)
    public ModelAndView reqOfertaPOST(@RequestParam(value = "formazatrudnienia") String praca,
            @RequestParam(value = "kwota") int kwota,
            @RequestParam(value = "okres") int okres,
            @RequestParam(value = "stancywilny") String stan,
            @RequestParam(value = "wyksztalcenie") String wyksztalcenie,
            @RequestParam(value = "statusmieszkaniowy") String statusmieszkaniowy,
            @RequestParam(value = "ile_w_domu") int ile_w_domu,
            @RequestParam(value = "lacznydochod") int lacznydochod)   
        {
            /**
             * obliczanie zdolnosci kredytowej
             */
            double zdolnosc=1;
            
            
            if (stan.equals("separacja"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (stan.equals("malzenstwo"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            
            if (praca.equals("emerytura")||praca.equals("renta"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (praca.equals("zlecenie")||praca.equals("wojsko"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (praca.equals("menager")||praca.equals("radny"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (praca.equals("prezes")||praca.equals("posel"))
            {
                zdolnosc=zdolnosc*1.3;
            }
            
            if (wyksztalcenie.equals("podstawowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (wyksztalcenie.equals("srednie"))
            {
                zdolnosc=zdolnosc*0.8;
            }
            else if (wyksztalcenie.equals("dr"))
            {
                zdolnosc=zdolnosc*1.1;
            }
            
            if (statusmieszkaniowy.equals("wlasne"))
            {
                zdolnosc=zdolnosc*1.2;
            }
            else if (statusmieszkaniowy.equals("sluzbowe"))
            {
                zdolnosc=zdolnosc*0.7;
            }
            else if (statusmieszkaniowy.equals("wynajem"))
            {
                zdolnosc=zdolnosc*0.9;
            }
            
            if (ile_w_domu>2)
            {
                zdolnosc=zdolnosc*1.1;
            }
            else if (ile_w_domu==1)
            {
                zdolnosc=zdolnosc*0.8;
            }
            
            /**
             * kredyty na dom itp
             */
            if (okres>240)
            {
                if (lacznydochod*okres/2*zdolnosc<kwota) 
                {
                    zdolnosc=0; //odmowa kredytu
                }
            }
            else if (lacznydochod*5*zdolnosc<kwota)
            {
                zdolnosc=0; //odmowa kredytu
            }
            // wartości do zmiany
            double prowizja=5/zdolnosc; 
            double oprocentowanie=7/zdolnosc; 
            
             return new ModelAndView("DaneDoOferty", "formularzOf", new DaneOferty (kwota,okres,zdolnosc, prowizja, oprocentowanie));
        }
    
    @RequestMapping(value="/zmiana_stanu", method=RequestMethod.GET)
    public ModelAndView reqzmiana_stanuGET() 
    {       
        return new ModelAndView("StronaStanuKonta", "formularzZmianyStanu", new ZmianaStanu());
    }
    
    @RequestMapping(value = "/zmiana_stanu", method=RequestMethod.POST)
    public String reqzmiana_stanuPOST(@RequestParam(value = "co_zmienic") String co_zmienic,
            @RequestParam(value = "nowa_wartosc") String nowa_wartosc,
            @RequestParam(value = "nazwa") String nazwa) 
    {   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU2");
        EntityManager em;
        em = emf.createEntityManager();
        Konta konto=em.find(Konta.class, nazwa);
        em.getTransaction().begin();
        em.createQuery("update Konta set " +co_zmienic+"='"+nowa_wartosc+"' where nazwa_konta='"+nazwa+"' and rola='USER'").executeUpdate(); 
        em.getTransaction().commit();
        return "redirect:/";
        
    }
    @RequestMapping(value="/zmiana_danych", method=RequestMethod.GET)
    public ModelAndView reqzmiana_danychGET() 
    {       
        return new ModelAndView("StronaZmianyDanych", "formularzZmianyDanych", new ZmianaStanu());
    }
    
    @RequestMapping(value = "/zmiana_danych", method=RequestMethod.POST)
    public String reqzmiana_danychPOST(@RequestParam(value = "co_zmienic") String co_zmienic,
            @RequestParam(value = "nowa_wartosc") String nowa_wartosc,
            @RequestParam(value = "nazwa") String nazwa) 
    {  
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU2");
        EntityManager em;
        em = emf.createEntityManager();
        Konta konto=em.find(Konta.class, nazwa);
        em.getTransaction().begin();
        em.createQuery("update KlientIndywidualnyDTO set " +co_zmienic+"='"+nowa_wartosc+"' where pesel='"+nazwa+"'").executeUpdate();    
        em.getTransaction().commit();
        return "redirect:/";
        
    }
    /**
     * Jeśli jest zalogowany to przechodzi do strony wyboru lokat a jeśli nie to wraca na początek 
     *  
     */
    @RequestMapping(value = "/lokaty", method=RequestMethod.GET)
     public String reqzlokatyGET() 
     {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) 
        {
            return "forward:/lokatyLog"; 
        }
        else
        {
            return "redirect:/";
        }
     }
     
     /**
      * strona z wyborem lokat jeśli jest zalogowany
      *  
      */
     @RequestMapping(value = "/lokatyLog", method=RequestMethod.GET)
     public ModelAndView reqzlokatyLogGET() 
     {
         return new ModelAndView("DaneDoLokaty", "formularzLokaty", new DaneLokata());
     }
     
     /**
      * póki co redirectuje do nikąd po to tylko żeby sprawdzić czy dobrze działa if
      * po stworzeniu panelu bankiera trzeba mu będzie przesyłać te dane aby zatwierdzał wnioski o lokatę
      */
     
     @RequestMapping(value = "/lokaty", method=RequestMethod.POST)
     public String reqzlokatyPOST(@RequestParam String okres) 
     {
        if( okres.equals("6") )
        {
            return "redirect:/6miesiecy"; 
        }
        else if ( okres.equals("12") )
        {
           return "redirect:/rok"; 
        }
        else if ( okres.equals("24") )
        {
           return "redirect:/2lata"; 
        }
        else if ( okres.equals("Strona glowna") )
        {
            return "redirect:/"; 
        }
        else
        {
            return "redirect:/blad"; // nie powinno to nigdy wyjsc i poki co prowadzi w puste miejsce, można potem wstawić jakąś stronę błędu
        } 
     }
=======
        
        
        
        
    	@RequestMapping(value =  "/zalogowano" , method = RequestMethod.GET)
	public ModelAndView zalogowanoPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "System Bankowosci Internetowej");
		modelAndView.addObject("message", "Witamy!");
		modelAndView.setViewName("kontoIndywidualne"); //nazwa strony .jsp zwracanej po wywolaniu metody
		return modelAndView;

	}
    
>>>>>>> refs/remotes/origin/przemek
}
