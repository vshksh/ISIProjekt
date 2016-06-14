/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.dao.EmptyResultDataAccessException;


/**
 *
 * @author Przemek
 */
@Controller
public class KontrolerPotwierdzaniaKredytow 
{
    @Autowired
	DataSource dataSource;
    
     @RequestMapping(value =  "/zatwierdzkredyt" , method = RequestMethod.GET)
  public ModelAndView reqZatwierdzKredytGET() 
  {
      JdbcTemplate jt = new JdbcTemplate(dataSource);
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String currentPrincipalName = authentication.getName();
      String rola="";
      try 
      {	
         rola = jt.queryForObject("SELECT rola FROM `konta` WHERE login = '" + currentPrincipalName + "'", String.class);
      }
      catch (EmptyResultDataAccessException e) 
      {
	return new ModelAndView("brakuprawnien");
      }		
      if (!rola.equals("BANK"))
      {
        return new ModelAndView("brakuprawnien");
      }
      return new ModelAndView("ZatwierdzKredyt", "formularzKr", new KredytZatwierdzany());
  }
  
     @RequestMapping(value =  "/zatwierdzkredyt" , method = RequestMethod.POST)
  public String reqZatwierdzKredytPOST(@RequestParam int id,
          @RequestParam String action) 
  {
      String SQL="";
      JdbcTemplate jt = new JdbcTemplate(dataSource);
      if (action.equals("Zatwierdz"))
      {
          SQL="UPDATE kredyty SET zatwierdzenie=1 WHERE ID_kredytu="+id;
      }
      else if (action.equals("Odrzuc"))
      {
          SQL="UPDATE kredyty SET zatwierdzenie=-1 WHERE ID_kredytu="+id;
      }
      jt.execute(SQL);
      return "redirect:/kontoBankiera"; 
  }
  
    @RequestMapping(value =  "/przejrzyjkredyt" , method = RequestMethod.GET)
  public ModelAndView reqPrzejrzyjKredytGET() 
  {
      JdbcTemplate jt = new JdbcTemplate(dataSource);
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String currentPrincipalName = authentication.getName();
      String rola="";
      try 
      {	
         rola = jt.queryForObject("SELECT rola FROM `konta` WHERE login = '" + currentPrincipalName + "'", String.class);
      }
      catch (EmptyResultDataAccessException e) 
      {
	return new ModelAndView("brakuprawnien");
      }		
      if (!rola.equals("BANK"))
      {
        return new ModelAndView("brakuprawnien");
      }
      return new ModelAndView("przejrzyjkredyt", "formularzKr1", new Kredyty());
  }
  
     @RequestMapping(value =  "/przejrzyjkredyt" , method = RequestMethod.POST)
  public String reqPrzeyjrzyjKredytPOST(@RequestParam int id) 
  {
      JdbcTemplate jt = new JdbcTemplate(dataSource);
      double kwota=jt.queryForObject("SELECT kwota FROM `kredyty` WHERE ID_kredytu = " + id , Double.class);
      return "redirect:/PokazKredyt";
  }
}
  
