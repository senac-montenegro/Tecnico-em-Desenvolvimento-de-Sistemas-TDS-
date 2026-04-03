/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Checkin;
import model.Viagem;

public class CheckinDAO {
    private Connection connection;
    
    public CheckinDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void registrarCheckin(Checkin checkin) {
        String sql = "INSERT INTO checkin (id_viagem, localizacao) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, checkin.getViagem().getIdViagem());
            stmt.setString(2, checkin.getLocalizacao());
        
            stmt.execute();
            System.out.println("Check-in em " + checkin.getLocalizacao() + " realizado!");
        } catch (SQLException e){
            throw new RuntimeException("Erro ao registrar check-in: " + e.getMessage());
        }
    }
    
    public void atualizarCheckin(Checkin checkin) {
        String sql = "UPDATE checkin SET id_viagem = ?, localizacao = ?, data_hora_registro = ? WHERE id_checkin = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, checkin.getViagem().getIdViagem());
            stmt.setString(2, checkin.getLocalizacao());
            stmt.setTimestamp(3, checkin.getDataHoraRegistro());
            stmt.setInt(4, checkin.getIdCheckin());
            
            stmt.execute();
            System.out.println("Check-in atualizado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar check-in: " + e.getMessage());
        }
    }
    
    public void deletarCheckin(int id) {
        String sql = "DELETE FROM checkin WHERE id_checkin = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            stmt.execute();
            System.out.println("Check-in deletado com sucesso!");            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar check-in.");
        }
    }
    
    public boolean buscarId(int id) {
        String sql = "SELECT COUNT(*) FROM checkin where id_checkin = ?";
        
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
    
    public Checkin buscarPorId(int id) {
        String sql = "SELECT * FROM checkin WHERE id_checkin = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Checkin c = new Checkin();
                    c.setIdCheckin(rs.getInt("id_checkin"));
                    
                    int IdViagem = rs.getInt("id_viagem");
                    ViagemDAO vDao = new ViagemDAO();
                    Viagem v = vDao.buscarPorId(IdViagem);
                    c.setViagem(v);
                    
                    c.setIdCheckin(rs.getInt("localizacao"));
                    c.setIdCheckin(rs.getInt("data_hora_registro"));
                    return c;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Checkin> listaTodos() {
        String sql = "SELECT * FROM checkin ORDER BY id_checkin";
        List<Checkin> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Checkin c = new Checkin();
                c.setIdCheckin(rs.getInt("id_checkin"));
                int IdViagem = rs.getInt("id_viagem");
                
                ViagemDAO vDao = new ViagemDAO();
                Viagem v = vDao.buscarPorId(IdViagem);
                c.setViagem(v);
                
                c.setIdCheckin(rs.getInt("localizacao"));
                c.setIdCheckin(rs.getInt("data_hora_registro"));
                lista.add(c);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar check-ins: " + e.getMessage());
        }
        return lista;
    }
}
