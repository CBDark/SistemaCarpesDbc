/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Melany
 */
public class Util {
    public static void habilitar(boolean valor, JComponent ... vetComp){
        for (int i = 0; i< vetComp.length; i++){
            vetComp[i].setEnabled(valor);
        }
    }
    public static void limparCampos(JComponent ... vetComp ){
        for (JComponent jComponent : vetComp) {
            if (jComponent instanceof JTextField){
            ((JTextField) jComponent).setText("");
            }
            if (jComponent instanceof JComboBox){
            ((JComboBox) jComponent).setSelectedIndex(-1);
            }
            if (jComponent instanceof JCheckBox){
            ((JCheckBox) jComponent).setSelected(false);
            }
        }
    }
    public static void mensagem(String cadeia){        
         JOptionPane.showMessageDialog(null, cadeia);
    }
    public static boolean perguntar(String cadeia) {
       //JOptionPane.showConfirmDialog(null, cadeia, "Perguntar", JOptionPane.YES_NO_OPTION);
       int resp =  JOptionPane.showConfirmDialog(null, "Deseja excluir o registro",
       "confirmar", JOptionPane.YES_NO_OPTION);
       if (resp == JOptionPane.YES_OPTION){
       return true;
       }else {
       return false;}
    }
}
