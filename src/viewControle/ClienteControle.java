/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControle;

import bean.ClienteDbc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duals
 */
    public class ClienteControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}

public ClienteDbc getbean(int linha){
return (ClienteDbc) lista.get(linha);
}
@Override
public int getRowCount() {
        return lista.size();
    }
@Override
 public int getColumnCount() {
      return 4;
    }
@Override
 public Object getValueAt(int rowIndex, int columnIndex) {
        ClienteDbc clienteDbc = (ClienteDbc) lista.get(rowIndex);
      if (columnIndex == 0) {
             return clienteDbc.getIdclienteDbc();
        }
        if (columnIndex == 1) {
             return clienteDbc.getNomeDbc();
        }
        if (columnIndex == 2) {
             return clienteDbc.getEmailDbc();
        }
        if (columnIndex == 3) {
             return clienteDbc.getCpfDbc();
        
        }
       return null;
    }
@Override
 public String getColumnName(int columnIndex){
        if (columnIndex == 0) {
             return "ID";
        }
        if (columnIndex == 1) {
             return "Nome";
        }
        if (columnIndex == 2) {
             return "Email";
        }
        if (columnIndex == 3) {
             return "CPF";
        }
       
    return null;
    }
}

    
    

