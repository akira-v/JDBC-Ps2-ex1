package org.example;
import java.sql.*;
import java.util.Scanner;


public class App
{
    public static void main( String[] args ) {

        Connection conn = null;
        Scanner input = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "xd";
            String url = "jdbc:mysql://dorime.dlinkddns.com/32775" + db;
            String user = "root";
            String psw = "root";


            System.out.println("Digite o número da conta:");
            int nrConta = input.nextInt();
            System.out.println("Digite o saldo da conta: ");
            String saldo = input.next();

            conn = DriverManager.getConnection(url, user, psw);

            String sql = "INSERT INTO CONTAS values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nrConta);
            ps.setString(2, saldo);
            ps.executeUpdate();

            ps.close();
            conn.close();


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha na carga do Driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Falha de conexão com a base de dados.");
            e.printStackTrace();
        }
    }


}

