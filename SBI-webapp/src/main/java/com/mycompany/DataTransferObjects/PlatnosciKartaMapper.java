package com.mycompany.DataTransferObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PlatnosciKartaMapper implements RowMapper<PlatnosciKartaDTO> 
{
    
   public PlatnosciKartaDTO mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      PlatnosciKartaDTO platnosc = new PlatnosciKartaDTO();
      
	  
      platnosc.setIDPlatnosci(rs.getString("ID_platnosci"));
	  platnosc.setIDKarty(rs.getString("ID_karty"));
	  platnosc.setDataPlatnosci(rs.getString("data_platnosci"));
	  platnosc.setNazwa(rs.getString("nazwa"));
	  platnosc.setKwota(rs.getDouble("Kwota"));
	  
	  
      return platnosc;
      
   }
   
}