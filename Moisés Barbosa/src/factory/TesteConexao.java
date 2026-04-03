/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factory;

/**
 *
 * @author MOISESSILVASANTOSBAR
 */
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta com sucesso!");
        con.close(); // Sempre feche a porta depois de usar!
    }
    
}
