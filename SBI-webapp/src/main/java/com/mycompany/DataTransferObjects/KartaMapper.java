/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class KartaMapper implements RowMapper<KartaDTO> 
{
    
   public KartaDTO mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      KartaDTO karta = new KartaDTO();
      karta.setNumerKarty(rs.getString("numer_karty"));
      karta.setPIN(rs.getString("PIN"));
      karta.setLimitKarty(rs.getInt("limit_karty"));
      karta.setDataWaznosci(rs.getString("data_waznosci"));
      karta.setStatusKarty(rs.getInt("status_karty"));
      return karta;
      
   }
   
}
