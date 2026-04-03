/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import exception.ValidacaoException;
import validations.Validador;

/**
 *
 * @author MOISESSILVASANTOSBAR
 */
public class Caminhao {
    // Atributos privados (Encapsulamento)
    private int idCaminhao;
    private String placa;
    private String modelo;
    private double capacidadeTon;
    private String statusAtual;
    private String comentario;

    // Construtor vazio (Importante para o Java)
    public Caminhao() {}

    // Getters e Setters (Para acessar os dados com segurança)
    public int getIdCaminhao() { return idCaminhao; }
    public void setIdCaminhao(int idCaminhao) {
        Validador.idPositivo(idCaminhao, "Id Caminhao");
        this.idCaminhao = idCaminhao; 
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { 
        if (placa == null || placa.isBlank() || placa.length() > 8) {
            throw new ValidacaoException("ERRO: Insira uma placa válida dentro do limite.");
        }
        this.placa = placa; 
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) {
        Validador.campoObrigatorio(modelo, "Modelo");
        this.modelo = modelo; 
    }

    public double getCapacidadeTon() { return capacidadeTon; }
    public void setCapacidadeTon(double capacidadeTon) { 
        Validador.doublePositivo(capacidadeTon, "Capacidade de Tonelada");
        this.capacidadeTon = capacidadeTon; 
    }

    public String getStatusAtual() { return statusAtual; }
    public void setStatusAtual(String statusAtual) { 
        Validador.stringDisponivel(statusAtual, "Status Atual");
        this.statusAtual = statusAtual; 
    }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id do Caminhão: ").append(idCaminhao);
        sb.append("\nPlaca: ").append(placa);
        sb.append("\nModelo:").append(modelo);
        sb.append("\nCapacidade de Toneladas: ").append(capacidadeTon);
        sb.append("\nStatus Atual: ").append(statusAtual);
        sb.append("\nComentário: ").append(comentario);
        sb.append("\n --- x --- x ---");
        return sb.toString();
    }
}
