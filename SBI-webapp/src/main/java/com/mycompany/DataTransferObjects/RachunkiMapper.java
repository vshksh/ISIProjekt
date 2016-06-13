/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jeremiasz
 */
public class RachunkiMapper implements RowMapper<RachunkiDTO> 
{
    
   public RachunkiDTO mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      RachunkiDTO rachunek = new RachunkiDTO();
      rachunek.setNumerRachunku(rs.getString("numer_rachunku"));
      rachunek.setSaldo(rs.getDouble("saldo"));
      rachunek.setLogin(rs.getString("kontaID_konta"));
      rachunek.setWaluta(rs.getString("waluta"));
      return rachunek;
      
   }
   
}
