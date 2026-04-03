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
import model.Caminhao;
import model.Talhao;
import model.Viagem;

public class ViagemDAO {
    private Connection connection;
    
    public ViagemDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void registrarInicio(Viagem viagem) { 
        String sql = "INSERT INTO viagem (id_caminhao, id_talhao) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, viagem.getCaminhao().getIdCaminhao());
            stmt.setInt(2, viagem.getTalhao().getIdTalhao());
            
            stmt.execute();
            System.out.println("Viagem iniciada com sucesso!");            
        } catch (SQLException e){
            throw new RuntimeException("Erro ao iniciar viagem: " + e.getMessage());            
        }
    }
    
    public void registrarFim(Viagem viagem) {
        String sql = "UPDATE viagem SET data_hora_fim = CURRENT_TIMESTAMP, peso_bruto = ? WHERE id_viagem = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, viagem.getPesoBruto());
            stmt.setInt(2, viagem.getIdViagem());
            
            stmt.execute();
            System.out.println("Viagem " + viagem.getIdViagem() + " finalizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao finalizar viagem: " + e.getMessage());
        }
    }
    
    public void atualiza(Viagem viagem) {
        String sql = "UPDATE viagem SET id_caminhao = ?, id_talhao = ?, data_hora_inicio = ?, data_hora_fim = ?, peso_bruto = ? WHERE id_viagem = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, viagem.getCaminhao().getIdCaminhao());
            stmt.setInt(2, viagem.getTalhao().getIdTalhao());
            stmt.setTimestamp(3, viagem.getDataHoraInicio());
            stmt.setTimestamp(4, viagem.getDataHoraFim());
            stmt.setDouble(5, viagem.getPesoBruto());
            stmt.setInt(6, viagem.getIdViagem());
            
            stmt.execute();
            System.out.println("Viagem atualizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar viagem: " + e.getMessage());
        }
    }
    
    public void remova(int id) {
        String sql = "DELETE FROM viagem WHERE id_viagem = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            stmt.execute();
            System.out.println("Viagem deletada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar viagem: " + e.getMessage());
        }
    }
    
    public boolean buscarId(int id) {
        String sql = "SELECT COUNT(*) FROM viagem where id_viagem = ?";
        
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
    
    public Viagem buscarPorId(int id) {
        String sql = "SELECT * FROM viagem WHERE id_viagem = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Viagem v = new Viagem();              
                    v.setIdViagem(rs.getInt("id_viagem"));
                    
                    int IdCaminhao = rs.getInt("id_caminhao");
                    CaminhaoDAO cDao = new CaminhaoDAO();
                    Caminhao c = cDao.buscarPorId(IdCaminhao);
                    v.setCaminhao(c);
                    
                    int IdTalhao = rs.getInt("id_talhao");
                    TalhaoDAO tDao = new TalhaoDAO();
                    Talhao t = tDao.buscarPorId(IdTalhao);
                    v.setTalhao(t);
                    
                    v.setDataHoraInicioBanco(rs.getTimestamp("data_hora_inicio"));
                    v.setDataHoraFimBanco(rs.getTimestamp("data_hora_fim"));
                    v.setPesoBruto(rs.getDouble("peso_bruto"));
                    return v;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Viagem> listaTodos() {
        String sql = "SELECT * FROM viagem ORDER BY id_viagem";
        List<Viagem> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Viagem v = new Viagem();              
                    v.setIdViagem(rs.getInt("id_viagem"));
                    
                    int IdCaminhao = rs.getInt("id_caminhao");
                    CaminhaoDAO cDao = new CaminhaoDAO();
                    Caminhao c = cDao.buscarPorId(IdCaminhao);
                    v.setCaminhao(c);
                    
                    int IdTalhao = rs.getInt("id_talhao");
                    TalhaoDAO tDao = new TalhaoDAO();
                    Talhao t = tDao.buscarPorId(IdTalhao);
                    v.setTalhao(t);
                    
                    v.setDataHoraInicioBanco(rs.getTimestamp("data_hora_inicio"));
                    v.setDataHoraFimBanco(rs.getTimestamp("data_hora_fim"));
                    v.setPesoBruto(rs.getDouble("peso_bruto"));
                    lista.add(v);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Viagens: " + e.getMessage());
        }
        return lista;
    }
}
