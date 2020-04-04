/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author tamyres.carla.santos
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        //Buscar a lista de agendamentos do banco de dados
       
       AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
       ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
         //Exibir essa lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
    //Busca Cliente do banco de dados
     ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList<Cliente> clientes = clienteDAO.selectAll();
    // Lista cliente no Combobox cliente
    helper.preencherCliente(clientes);
    }
    
    
    public void atualizaServico(){
    
        ServicoDAO servicoDAO = new ServicoDAO();
       ArrayList<Servico> servicos =servicoDAO.selectAll();
       
       helper.preencherServico(servicos);
    }
    
    public void atualizaValor(){
       Servico servico = helper.obterServico();
       helper.setarValor(servico.getValor());
    }
    public void agendar(){
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        //Salva objeto no banco de dados 
        new AgendamentoDAO().insert(agendamento);
        
        //Inserir elemento na tabela 
        atualizaTabela();
        helper.limparTela();
    
    }

}
