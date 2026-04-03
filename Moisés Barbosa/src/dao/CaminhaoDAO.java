/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author MOISESSILVASANTOSBAR
 */

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Caminhao;

public class CaminhaoDAO {
    private Connection connection;

    public CaminhaoDAO() {
        // Toda vez que você criar um DAO, ele pede uma conexão nova para a fábrica
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Caminhao caminhao) {
        String sql = "INSERT INTO caminhao (placa, modelo, capacidade_ton, status_atual, comentario) VALUES (?,?,?,?,?)";

        try {
            // Preparando a "carta" para o banco
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Substituindo os '?' pelos dados reais do objeto
            stmt.setString(1, caminhao.getPlaca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setDouble(3, caminhao.getCapacidadeTon());
            stmt.setString(4, caminhao.getStatusAtual());
            stmt.setString(5, caminhao.getComentario());

            // Executa o comando no banco
            stmt.execute();
            stmt.close();
            
            System.out.println("Caminhão gravado com sucesso no banco!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir caminhão: " + e.getMessage());
        }
    }
    
    public void atualiza(Caminhao caminhao) {
        String sql = "UPDATE caminhao SET placa = ?, modelo = ?, capacidade_ton = ?, comentario = ? WHERE id_caminhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getPlaca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setDouble(3, caminhao.getCapacidadeTon());
            stmt.setString(4, caminhao.getComentario());
            stmt.setInt(5, caminhao.getIdCaminhao());
            
            stmt.execute();
            System.out.println("Caminhao atualizado com sucesso!");            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados: " + e.getMessage());
        }
    }
    
    public void remova(int id) {
        String sql = "DELETE FROM caminhao WHERE id_caminhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            stmt.execute();
            System.out.println("Caminhao deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar caminhao: " + e.getMessage());
        }
    }
    
    public boolean buscarId(int id) {
        String sql = "SELECT COUNT(*) FROM caminhao where id_caminhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    
    public Caminhao buscarPorId(int id) {
        String sql = "SELECT * FROM caminhao WHERE id_caminhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Caminhao c = new Caminhao();
                    c.setIdCaminhao(rs.getInt("id_caminhao"));
                    c.setPlaca(rs.getString("placa"));
                    c.setModelo(rs.getString("modelo"));
                    c.setCapacidadeTon(rs.getDouble("capacidade_ton"));
                    c.setStatusAtual(rs.getString("status_atual"));
                    c.setComentario(rs.getString("comentario"));
                    return c;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
        
    public List<Caminhao> listaTodos() {
        String sql = "SELECT * FROM caminhao ORDER BY id_caminhao";
        List<Caminhao> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Caminhao c = new Caminhao();
                c.setIdCaminhao(rs.getInt("id_caminhao"));
                c.setPlaca(rs.getString("placa"));
                c.setModelo(rs.getString("modelo"));
                c.setCapacidadeTon(rs.getDouble("capacidade_ton"));
                c.setStatusAtual(rs.getString("status_atual"));
                c.setComentario(rs.getString("comentario"));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar caminhões: " + e.getMessage());
        }
        return lista;
    }
}
