/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author tamyres.carla.santos
 */
public class Main {
    
    public static void main(String[] args) {
             String nome = "Tiago";
          System.out.println(nome);
          
          Servico servico = new Servico(1, "barba", 30);
          System.out.println(servico.getDescricao());
          System.out.println(servico.getValor());
          
          Cliente cliente = new Cliente(1,"tiago","rua tesla 9456","5800393938");
          System.out.println(cliente.getNome());
          
          Usuario usuario = new Usuario(1,"barbeiro","senha");
          System.out.println(usuario);
          
          Agendamento agendamento = new Agendamento( 1, cliente, servico, 30, "26/07/2018 09:15");
          System.out.println(agendamento.getCliente().getNome());
    }
    
}
