/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jeremiasz
 */
@Controller
public class KontrolerInformacji {
    @RequestMapping(value="/informacje", method=RequestMethod.GET) //NIE DZIALA
    public ModelAndView reqStronaGlownaGET() {
       
    
       return new ModelAndView("informacje");
        
    }
}
