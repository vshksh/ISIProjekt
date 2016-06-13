package com.mycompany.DataTransferObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OfertyMapper implements RowMapper<Oferty> 
{
    
   public Oferty mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      Oferty oferta = new Oferty();
      oferta.setNazwa(rs.getString("Nazwa"));
      oferta.setTyp(rs.getString("Typ"));
      oferta.setLimity(rs.getDouble("Limity"));
      oferta.setProcent(rs.getFloat("Procent"));
      return oferta;
      
   }
   
}