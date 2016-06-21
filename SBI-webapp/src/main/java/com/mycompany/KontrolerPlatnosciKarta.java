
package com.mycompany;

import com.mycompany.DataTransferObjects.*;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Jeremiasz
 */
@Controller
public class KontrolerPlatnosciKarta 
{
  @Autowired
          DataSource dataSource;
	
  @RequestMapping(value =  "/historiaplatnosci" , method = RequestMethod.GET)
  public ModelAndView ofertyPage() {
	ModelAndView modelAndView = new ModelAndView();                   
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
                
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String  nrRachunku = jt.queryForObject("SELECT numer_rachunku FROM `rachunki` WHERE kontaID_konta = '" + currentPrincipalName + "'", String.class);
        String numerKarty = jt.queryForObject("SELECT numer_karty FROM `karty` WHERE numer_rachunku = '" + nrRachunku + "'", String.class);
        
        String SQL = "SELECT * FROM `platnosci_karta` WHERE ID_karty = '" + numerKarty + "'";
        List<PlatnosciKartaDTO> platnosci = jt.query(SQL, new PlatnosciKartaMapper());
        
        int liczbaplatnosci = platnosci.size();
        Integer liczba=liczbaplatnosci;
        modelAndView.addObject("ileplatnosci", liczba);
        for (int i=0;i<liczbaplatnosci;i++)
        {
            modelAndView.addObject("IDPlatnosci"+i, platnosci.get(i).getIDPlatnosci());
            modelAndView.addObject("kwota"+i, platnosci.get(i).getKwota());
            modelAndView.addObject("nazwa"+i, platnosci.get(i).getNazwa());
            modelAndView.addObject("dataPlatnosci"+i, platnosci.get(i).getDataPlatnosci());

        }
        if (liczbaplatnosci<1)
        {
            modelAndView.addObject("brakplatnosci", "Nie ma jeszcze żadnej płatności.");
        }
	modelAndView.setViewName("historiaplatnosci");
	return modelAndView;
	}
        
    
}