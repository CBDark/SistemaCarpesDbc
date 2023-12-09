package viewControle;

import bean.ProdutoVendasDbc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoVendasControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public ProdutoVendasDbc getBean(int linha) {
        return (ProdutoVendasDbc) lista.get(linha);
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
        ProdutoVendasDbc ProdutoVendas = (ProdutoVendasDbc) lista.get(rowIndex);
        if (columnIndex == 0) {
            return ProdutoVendas.getProdutoDbc().getNomeDbc();
        }
        if (columnIndex == 1) {
            return ProdutoVendas.getQuantidadeDbc();
        }
        if (columnIndex == 2) {
            return ProdutoVendas.getValorUnitarioDbc();
        }
        if (columnIndex == 3) {
            return ProdutoVendas.getQuantidadeDbc() * ProdutoVendas.getValorUnitarioDbc();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Quantidade";
        }
        if (columnIndex == 2) {
            return "Valor Unitario";
        }
        if (columnIndex == 3) {
            return "Valor Total";
        }
        return null;
    }

    public void addBean(ProdutoVendasDbc produtoVendasDbc) {
        lista.add(produtoVendasDbc);
        this.fireTableDataChanged();
    }
 public void removeBean(int index) {
        if (lista != null && index >= 0 && index < lista.size()) {
            lista.remove(index);
            this.fireTableDataChanged();
        } else {
            System.out.println("Índice inválido ou lista não inicializada corretamente.");
        }
    }
    public void updateBean(int index, ProdutoVendasDbc produtoVendasDbc) {
        lista.set(index, produtoVendasDbc);
        this.fireTableDataChanged();
    }
    public void limparTabela() {
        lista.clear();
        this.fireTableDataChanged();
    }
}
