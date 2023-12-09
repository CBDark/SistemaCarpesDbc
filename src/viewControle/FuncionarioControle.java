/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControle;

import bean.FuncionarioDbc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duals
 */
public class FuncionarioControle extends AbstractTableModel{
    private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}


public FuncionarioDbc getbean(int linha){
return (FuncionarioDbc) lista.get(linha);
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
       FuncionarioDbc funcionarioDbc = (FuncionarioDbc) lista.get(rowIndex);
      if (columnIndex == 0) {
             return funcionarioDbc.getIdfuncionarioDbc();
        }
        if (columnIndex == 1) {
             return funcionarioDbc.getNomeDbc();
        }
        if (columnIndex == 2) {
             return funcionarioDbc.getDepartamentoDbc();
        }
        if (columnIndex == 3) {
             return funcionarioDbc.getNumeroTelefoneDbc();
        
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
             return "Departamento";
        }
        if (columnIndex == 3) {
             return "Telefone";
        }
       
    return null;
    }
}
