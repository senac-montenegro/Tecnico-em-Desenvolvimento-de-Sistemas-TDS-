/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author MOISESSILVASANTOSBAR
 */

import java.sql.Connection; // Interface para conexões
import java.sql.DriverManager; // Gerenciador de drivers
import java.sql.SQLException; // Tratamento de erros de SQL


public class ConnectionFactory {
    public Connection getConnection(){
        try {
                // Endereço do banco: protocolo:sub-protocolo://servidor:porta/nome_do_banco
                String url = "jdbc:postgresql://localhost:5432/ProjetoIntegrador";
                String usuario = "postgres"; // Usuário padrão do pgAdmin
                String senha = "1234"; // <-- Coloque a senha que você definiu no pgAdmin

                return DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                // Se der erro (senha errada, banco desligado), ele avisa aqui
                throw new RuntimeException("Erro ao conectar ao banco de dados: ", e);
            }
    }
}
