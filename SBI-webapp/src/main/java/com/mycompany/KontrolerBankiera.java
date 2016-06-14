/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.DataTransferObjects.Oferty;
import com.mycompany.DataTransferObjects.OfertyMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
public class KontrolerBankiera {
 @Autowired
          DataSource dataSource;
	
  @RequestMapping(value =  "/kontoBankiera" , method = RequestMethod.GET)
  public ModelAndView reqBankierGET() 
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
        return new ModelAndView("kontoBankiera");
    }      
    
}
