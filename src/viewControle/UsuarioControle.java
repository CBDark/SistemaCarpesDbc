/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControle;

import bean.UsuariosDbc;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author u13766540670
 */
public class UsuarioControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public UsuariosDbc getbean(int linha) {
        return (UsuariosDbc) lista.get(linha);
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
        UsuariosDbc usuariosDbc = (UsuariosDbc) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuariosDbc.getIdusuariosDbc();
        }
        if (columnIndex == 1) {
            return usuariosDbc.getNomeDbc();
        }
        if (columnIndex == 2) {
            return usuariosDbc.getEmailDbc();
        }
        if (columnIndex == 3) {
            return usuariosDbc.getCpfDbc();

        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
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
