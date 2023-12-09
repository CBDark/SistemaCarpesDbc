/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControle;

import bean.ProdutoDbc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duals
 */
public class ProdutoControle extends AbstractTableModel {
private List lista;

public void setList(List lista){
this.lista=lista;
this.fireTableDataChanged();
}


public ProdutoDbc getbean(int linha){
return (ProdutoDbc) lista.get(linha);
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
        ProdutoDbc produtoDbc = (ProdutoDbc) lista.get(rowIndex);
      if (columnIndex == 0) {
             return produtoDbc.getIdprodutoDbc();
        }
        if (columnIndex == 1) {
             return produtoDbc.getNomeDbc();
        }
        if (columnIndex == 2) {
             return produtoDbc.getPrecoDbc();
        }
        if (columnIndex == 3) {
             return produtoDbc.getCategoriaDbc();
        
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
             return "Preço";
        }
        if (columnIndex == 3) {
             return "Categoria";
        }
       
    return null;
    }
}

