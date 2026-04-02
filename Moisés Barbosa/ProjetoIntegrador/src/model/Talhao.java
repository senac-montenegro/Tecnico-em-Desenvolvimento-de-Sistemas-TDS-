/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;
import validations.Validador;

public class Talhao {
    private int idTalhao;
    private String codigoArea; // Ex: "TALHAO-A1"
    private double tchEstimado; // Toneladas de Cana por Hectare
    private double brix; // Teor de açúcar
    private Date dataPlantio;
    private double umidade;
    private boolean temFlorada;

    public Talhao() {}
    
    // Getters e Setters
    public int getIdTalhao() { return idTalhao; }
    public void setIdTalhao(int idTalhao) { 
        Validador.idPositivo(idTalhao, "Id Talhao");
        this.idTalhao = idTalhao; 
    }

    public String getCodigoArea() { return codigoArea; }
    public void setCodigoArea(String codigoArea) { 
        Validador.campoObrigatorio(codigoArea, "Codigo Área");
        this.codigoArea = codigoArea; 
    }

    public double getTchEstimado() { return tchEstimado; }
    public void setTchEstimado(double tchEstimado) { 
        Validador.doublePositivo(tchEstimado, "TCH Estimado");
        this.tchEstimado = tchEstimado; 
    }

    public double getBrix() { return brix; }
    public void setBrix(double brix) {
        Validador.doublePositivo(brix, "BRIX");
        this.brix = brix; 
    }

    public Date getDataPlantio() { return dataPlantio; }
    public void setDataPlantio(String dataPlantioDigitada) {
        this.dataPlantio = Validador.dataValido(dataPlantioDigitada);
    }
    
    public void setDataPlantioBanco(java.sql.Date data) {
        this.dataPlantio = data;
    }
    
    public double getUmidade() { return umidade; }
    public void setUmidade(double umidade) {
        Validador.doublePositivo(umidade, "Umidade");
        this.umidade = umidade;
    }
    
    public boolean getTemFlorada() { return temFlorada; }
    public void setTemFlorada(boolean temFlorada) {
        this.temFlorada = temFlorada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id do Talhao: ").append(idTalhao);
        sb.append("\nCodigo da Área: ").append(codigoArea);
        sb.append("\nTCH Estimado: ").append(tchEstimado);
        sb.append("\nBrix: ").append(brix);
        sb.append("\nData do Plantio: ").append(dataPlantio);
        sb.append("\nUmidade: ").append(umidade);
        sb.append("\nTem Florada: ").append(temFlorada);
        sb.append("\n --- x --- x ---");
        return sb.toString();
    }
}
