/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class PrzelewMapper implements RowMapper<PrzelewDTO> 
{
    
   public PrzelewDTO mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      PrzelewDTO przelew = new PrzelewDTO();
      przelew.setDataWykonania(rs.getString("data_wykonania"));
      przelew.setDataZlecenia(rs.getString("data_zlecenia"));
      przelew.setKwota(rs.getDouble("kwota"));
      przelew.setRachunekOdbiorcy(rs.getString("rachunek_odbiorcy"));
      przelew.setTytul(rs.getString("tytul"));
      return przelew;
      
   }
   
}
