/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Talhao;

public class TalhaoDAO {
    private Connection connection;
    
    public TalhaoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Talhao talhao) {
        String sql = "INSERT INTO talhao (codigo_area, tch_estimado, brix, data_plantio, umidade, tem_florada) VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, talhao.getCodigoArea());
            stmt.setDouble(2, talhao.getTchEstimado());
            stmt.setDouble(3, talhao.getBrix());
            stmt.setDate(4, talhao.getDataPlantio());
            stmt.setDouble(5, talhao.getUmidade());
            stmt.setBoolean(6, talhao.getTemFlorada());
            
            stmt.execute();
            System.out.println("Talhão " + talhao.getCodigoArea() + " cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar talhão: " + e.getMessage());
        }
    }
    
    public void atualiza(Talhao talhao) {
        String sql = "UPDATE talhao SET codigo_area = ?, tch_estimado = ?, brix = ?, data_plantio = ?, umidade = ?, tem_florada = ? WHERE id_talhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, talhao.getCodigoArea());
            stmt.setDouble(2, talhao.getTchEstimado());
            stmt.setDouble(3, talhao.getBrix());
            stmt.setDate(4, talhao.getDataPlantio());
            stmt.setDouble(5, talhao.getUmidade());
            stmt.setBoolean(6, talhao.getTemFlorada());
            stmt.setInt(7, talhao.getIdTalhao());
            
            stmt.execute();
            System.out.println("Talhão atualizado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar talhao: " + e.getMessage());
        }
    }
    
    public void remova(int id) {
        String sql = "DELETE FROM talhao WHERE id_talhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            stmt.execute();
            System.out.println("Talhao deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar talhao: " + e.getMessage());
        }
    }
    
    public boolean buscarId(int id) {
        String sql = "SELECT COUNT(*) FROM talhao where id_talhao = ?";
        
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
    
    public Talhao buscarPorId(int id) {
        String sql = "SELECT * FROM talhao WHERE id_talhao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Talhao t = new Talhao();
                    t.setIdTalhao(rs.getInt("id_talhao"));
                    t.setCodigoArea(rs.getString("codigo_area"));
                    t.setTchEstimado(rs.getDouble("tch_estimado"));
                    t.setBrix(rs.getDouble("brix"));
                    t.setDataPlantioBanco(rs.getDate("data_plantio"));
                    t.setUmidade(rs.getDouble("umidade"));
                    t.setTemFlorada(rs.getBoolean("tem_florada"));
                    return t;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Talhao> listaTodos() {
        String sql = "SELECT * FROM talhao ORDER BY id_talhao";
        List<Talhao> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Talhao t = new Talhao();
                    t.setIdTalhao(rs.getInt("id_talhao"));
                    t.setCodigoArea(rs.getString("codigo_area"));
                    t.setTchEstimado(rs.getDouble("tch_estimado"));
                    t.setBrix(rs.getDouble("brix"));
                    t.setDataPlantioBanco(rs.getDate("data_plantio"));
                    t.setUmidade(rs.getDouble("umidade"));
                    t.setTemFlorada(rs.getBoolean("tem_florada"));
                    lista.add(t);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Talhões: " + e.getMessage());
        }
        return lista;
    }
}
