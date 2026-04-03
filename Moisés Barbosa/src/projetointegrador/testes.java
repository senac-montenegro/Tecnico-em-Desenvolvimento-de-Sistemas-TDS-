/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetointegrador;

import model.*;
import dao.*;

public class testes {
    public static void main(String[] args) {
        CaminhaoDAO cDao = new CaminhaoDAO();
        
        System.out.println(cDao.buscarPorId(5));
    }
}
