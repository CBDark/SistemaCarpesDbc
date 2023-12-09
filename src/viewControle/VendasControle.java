/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControle;

import bean.VendasDbc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duals
 */
    public class VendasControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}

public VendasDbc getbean(int linha){
return (VendasDbc) lista.get(linha);
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
        VendasDbc vendasDbc = (VendasDbc) lista.get(rowIndex);
        if (columnIndex == 0) {
             return vendasDbc.getIdvendasDbc();
        }
        if (columnIndex == 1) {
             return vendasDbc.getClienteDbc();
        }
        if (columnIndex == 2) {
             return vendasDbc.getDatadaVendasDbc();
        }
        if (columnIndex == 3) {
            return vendasDbc.getValorTotalDbc();
        }
       return null;
    }
@Override
 public String getColumnName(int columnIndex){
        if (columnIndex == 0) {
             return "ID";
        }
        if (columnIndex == 1) {
             return "Cliente";
        }
        if (columnIndex == 2) {
             return "Data";
        }
        if (columnIndex == 3) {
             return "Valor Total";
        }
    return null;
    }
}

    
    

