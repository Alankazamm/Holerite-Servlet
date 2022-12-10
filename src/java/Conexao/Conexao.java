package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

   public Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/trabalho?user=root&password=";
            con = DriverManager.getConnection(url);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: "
                    + ((SQLException) e).getSQLState());
            System.err.println("Message: " + e.getMessage());
        }
        return con;
    }
}