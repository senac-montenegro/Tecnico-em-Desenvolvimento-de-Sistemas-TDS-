/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package validations;

import exception.ValidacaoException;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class Validador {
    
    public static void campoObrigatorio(String valor, String nomeCampo) {
        if (valor == null || valor.isBlank()) {
            throw new ValidacaoException("ERRO: O campo " + nomeCampo + " é obrigatório.");
        }
    }
    
    public static void idPositivo(int valor, String nomeCampo) {
        if (valor <= 0) {
            throw new ValidacaoException("ERRO: O campo " + nomeCampo + " deve ser maior que zero.");
        }
    }
    
    public static void doublePositivo(double valor, String nomeCampo) {
       if (valor <= 0) {
            throw new ValidacaoException("ERRO: O campo " + nomeCampo + " deve ser maior que zero.");
        } 
    }
    
    public static void objetoNulo(Object obj, String nomeCampo) {
        if (obj == null) {
            throw new ValidacaoException("ERRO: É necessário selecionar um(a) " + nomeCampo + ".");
        }
    }
    
    public static void stringDisponivel(String valor, String nomeCampo) {
        if (valor == null || valor.isBlank() || (!"disponivel".equalsIgnoreCase(valor) && !"indisponivel".equalsIgnoreCase(valor))){
            throw new ValidacaoException("ERRO: O campo " + nomeCampo + " deve ser apenas 'DISPONIVEL' ou 'INDISPONIVEL'.");
        }
    }
    
    public static Timestamp timestampValido(String dataDigitada) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/uuu HH:mm").withResolverStyle(ResolverStyle.STRICT);
            LocalDateTime dataValidada = LocalDateTime.parse(dataDigitada, dtf);
            Timestamp ts = Timestamp.valueOf(dataValidada);
            
            if (ts.after(new Timestamp(System.currentTimeMillis()))) {
                throw new ValidacaoException("ERRO: a data não pode ser futura.");
            }
            
            return ts;
        } catch (Exception e) {
            throw new ValidacaoException("ERRO: Formato de data inválida ou data inexistente.");
        }
    }
    
    public static Date dataValido(String dataDigitada) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/uuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate dataValidada = LocalDate.parse(dataDigitada, dtf);
            Date d = Date.valueOf(dataValidada);
            
            if (d.after(new Timestamp(System.currentTimeMillis()))) {
                throw new ValidacaoException("ERRO: a data não pode ser futura.");
            }
            
            return d;
        } catch (Exception e) {
            throw new ValidacaoException("ERRO: Formato de data inválida ou data inexistente.");
        }
    }
}