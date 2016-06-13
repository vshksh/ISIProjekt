
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
 * @author Przemek
 */
@Controller
public class KontrolerOfert 
{
  @Autowired
          DataSource dataSource;
	
  @RequestMapping(value =  "/oferty" , method = RequestMethod.GET)
  public ModelAndView ofertyPage() {
	ModelAndView modelAndView = new ModelAndView();                          
                
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String SQL = "SELECT * FROM `oferty`";
        List<Oferty> oferta = jt.query(SQL, new OfertyMapper());
               
               
	modelAndView.addObject("title", "System Bankowosci Internetowej");
	modelAndView.addObject("message", "Dostępne oferty:");
        int liczbaofert = oferta.size();
        Integer liczba=liczbaofert;
        modelAndView.addObject("ileofert", liczba);
        for (int i=0;i<liczbaofert;i++)
        {
            modelAndView.addObject("nazwa"+i, oferta.get(i).getNazwa());
            modelAndView.addObject("typ"+i, oferta.get(i).getTyp());
            modelAndView.addObject("limity"+i, oferta.get(i).getLimity());
            modelAndView.addObject("procent"+i, oferta.get(i).getProcent());
        }
        if (liczbaofert<1)
        {
            modelAndView.addObject("brakofert", "Nie ma dostępnych ofert.");
        }
	modelAndView.setViewName("oferty");
	return modelAndView;
	}
        
    
}
