/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frs;

import java.sql.*;
/**
 *
 * @author ELCOT
 */
public class javaConnect {
    public static Connection connectdb() throws SQLException
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frs","root","Parkavi@2003");
            return con;
        }
        catch(Exception e)
        {
            System .out.println(e.getMessage());
        }
        return null;
    }
}
