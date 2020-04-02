/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Model.Agendamento;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tamyres.carla.santos
 */
public class AgendaHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
   DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
   tableModel.setNumRows(0);
   
   //Percorrer a lista preeenchendo os table model 
        for (Agendamento agendamento : agendamentos) {
 
            tableModel.addRow(new Object[] {
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
        
        
        
        });
            
            
        }

    }
    
   
    
    
}
