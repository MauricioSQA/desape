package com.isil.sesion1;

import java.sql.*;

public class MainApp {


    public static void main(String[] args) throws Exception {

        //1.Cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.Crear Conexion
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PRUEBA", "root", "");

        //3.crear statement
        //Statement stmt2 = con.createStatement();

        //4.ejecutar query
        //ResultSet resulSet = stmt2.executeQuery("select * from Users where name = 'Ronaldo'");

        //5.recorrer resultados


        // Con PreparedStatement

        //PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=? and city=?");

        //preparedStatement.setString(1,"Cueva");
        //preparedStatement.setString(2,"Lima");


        //ResultSet resultSet2 = preparedStatement.executeQuery();

        //while(resultSet2.next()){
        //System.out.println(resultSet2.getString("name")+ "\n"+
        //resultSet2.getString("phone")+ "\n"+
        //resultSet2.getString("city"));
        // }


        Statement stCreate = con.createStatement();
        int filasAfectas =
                stCreate.executeUpdate("insert  into users values(6,'Luis','Francia','30546723')");

        System.out.println("Filas Afectas: " + filasAfectas);

        Statement stmt1 = con.createStatement();
        ResultSet resultSet = stmt1.executeQuery("Select * from users");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + "\n" +
                    resultSet.getString("phone") + "\n" +
                    resultSet.getString("city"));
        }


        //PreparedStatement ejemplo
        //PreparedStatement preparedStatement= con.prepareStatement("Select * from users where name=?");
        //preparedStatement.setString(1,"Luis");

        PreparedStatement preparedStatement = con.prepareStatement("Delete  from users where name=?");
        preparedStatement.setString(1, "Luis");

        int delnum = preparedStatement.executeUpdate();

        Statement stmt2 = con.createStatement();
        ResultSet resultSet2 = stmt2.executeQuery("Select * from users");


        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("name") + "\n" +
                    resultSet2.getString("phone") + "\n" +
                    resultSet2.getString("city"));

        }

        PreparedStatement preparedStatement2 = con.prepareStatement("Update users set phone=? , city=? where name = 'Jaime'");
        preparedStatement2.setString(1,"987167365");

        preparedStatement2.setString(2, "Cajamarco");
        int delnum2 = preparedStatement2.executeUpdate();

        Statement stmt3 = con.createStatement();
        ResultSet resultSet3 = stmt3.executeQuery("Select * from users");


        while (resultSet3.next()) {
            System.out.println(resultSet3.getString("name") + "\n" +
                    resultSet3.getString("phone") + "\n" +
                    resultSet3.getString("city"));
        }
    }
}


