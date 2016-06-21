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
public class LokatyMapper implements RowMapper<LokatyDTO> 
{
    
   public LokatyDTO mapRow(ResultSet rs, int rowNum) throws SQLException
   {
       
      LokatyDTO lokata = new LokatyDTO();
      lokata.setIdLokaty(rs.getInt("ID_lokaty"));
      lokata.setNumerRachunku(rs.getString("rachunkinumer_rachunku"));
      lokata.setKwota(rs.getFloat("kwota"));
      lokata.setDataZalozenia(rs.getString("data_zalozenia"));
      lokata.setTerminZakonczenia(rs.getString("termin_zakonczenia"));
      lokata.setNaliczenia(rs.getFloat("naliczenia"));
      lokata.setProcent(rs.getFloat("procent"));
      return lokata;
      
   }
   
}