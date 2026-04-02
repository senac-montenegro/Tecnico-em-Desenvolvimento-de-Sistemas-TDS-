/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Timestamp;
import validations.Validador;

public class Checkin {
    private int idCheckin;
    private Viagem viagem; // Associado a uma viagem específica
    private String localizacao;
    private Timestamp dataHoraRegistro;

    public Checkin() {}

    // Getters e Setters
    public int getIdCheckin() { return idCheckin; }
    public void setIdCheckin(int idCheckin) { 
        Validador.idPositivo(idCheckin, " Id Checkin");
        this.idCheckin = idCheckin;
    }

    public Viagem getViagem() { return viagem; }
    public void setViagem(Viagem viagem) {
        Validador.objetoNulo(viagem, "Viagem");
        this.viagem = viagem;
    }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) {
        Validador.campoObrigatorio(localizacao, "Localização");
        this.localizacao = localizacao; 
    }

    public Timestamp getDataHoraRegistro() { return dataHoraRegistro; }
    public void setDataHoraRegistro(String dataDigitada) {
        this.dataHoraRegistro = Validador.timestampValido(dataDigitada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id do Checkin=").append(idCheckin);
        sb.append("\nId da Viagem: ").append(viagem.getIdViagem());
        sb.append("\nLocalizacao: ").append(localizacao);
        sb.append("\nData e Hora do Registro: ").append(dataHoraRegistro);
        sb.append("\n --- x --- x ---");
        return sb.toString();
    }
}
