/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Timestamp;
import validations.Validador;

public class Viagem {
    private int idViagem;
    private Caminhao caminhao; // Objeto Caminhao completo
    private Talhao talhao;     // Objeto Talhao completo
    private Timestamp dataHoraInicio;
    private Timestamp dataHoraFim;
    private double pesoBruto;

    // Construtor vazio
    public Viagem() {}

    // Getters e Setters
    public int getIdViagem() { return idViagem; }
    public void setIdViagem(int idViagem) { 
        Validador.idPositivo(idViagem, "Id Viagem");
        this.idViagem = idViagem; 
    }

    public Caminhao getCaminhao() { return caminhao; }
    public void setCaminhao(Caminhao caminhao) { 
        Validador.objetoNulo(caminhao, "Caminhao");
        this.caminhao = caminhao; 
    }

    public Talhao getTalhao() { return talhao; }
    public void setTalhao(Talhao talhao) { 
        Validador.objetoNulo(talhao, "Talhao");
        this.talhao = talhao; 
    }

    public Timestamp getDataHoraInicio() { return dataHoraInicio; }
    public void setDataHoraInicio(String dataDigitada) { 
        this.dataHoraInicio = Validador.timestampValido(dataDigitada); 
    }
    
    public void setDataHoraInicioBanco(java.sql.Timestamp data) { 
        this.dataHoraInicio = data; 
    }

    public Timestamp getDataHoraFim() { return dataHoraFim; }
    public void setDataHoraFim(String dataDigitada) { 
        this.dataHoraFim = Validador.timestampValido(dataDigitada); 
    }
    
    public void setDataHoraFimBanco(java.sql.Timestamp data) { 
        this.dataHoraFim = data; 
    }

    public double getPesoBruto() { return pesoBruto; }
    public void setPesoBruto(double pesoBruto) { 
        Validador.doublePositivo(pesoBruto, "Peso Bruto");
        this.pesoBruto = pesoBruto; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId Viagem: ").append(idViagem);
        sb.append("\nCaminhao: ").append(caminhao.getIdCaminhao());
        sb.append("\nTalhao: ").append(talhao.getIdTalhao());
        sb.append("\nData e Hora do Início: ").append(dataHoraInicio);
        sb.append("\nData e Hora do Fim: ").append(dataHoraFim);
        sb.append("\nPeso Bruto: ").append(pesoBruto);
        sb.append("\n --- x --- x ---");
        return sb.toString();
    }
}
