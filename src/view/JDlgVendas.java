/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteDbc;
import bean.FuncionarioDbc;
import bean.ProdutoVendasDbc;
import bean.VendasDbc;
import dao.ClientesDAO;
import dao.FuncionarioDAO;
import dao.ProdutoVendasDAO;
import dao.VendasDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.UtilDbc;
import viewControle.ProdutoControle;
import viewControle.ProdutoVendasControle;
import viewControle.VendasControle;
import viewPesquisa.JDlgProdutoNovo;
import viewPesquisa.JDlgVendasPesquisa;

/**
 *
 * @author Daniel
 */
public class JDlgVendas extends javax.swing.JDialog {
    JDlgVendasPesquisa jDlgVendasPesquisa;
    private boolean incl;
    MaskFormatter maskdata;
    JDlgVendasProdutos jDlgVendasProdutos;
    VendasControle vendasControle;
   public ProdutoVendasControle produtoVendasControle;
    ProdutoControle produtoControle;
    JDlgVendas jDlgVendas;
    VendasDbc quekralhoDbc;
    ProdutoVendasDAO produtoVendasDAO;
    VendasDAO vendasDAO;
    /**
     * Creates new form JDlgPedidos
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        List lista = new ArrayList();    
        VendasDAO vendasDAO = new VendasDAO();
        ProdutoVendasDAO  produtoVendasDAO = new ProdutoVendasDAO();
       
                                System.out.println("estouchegand");

        jDlgVendasProdutos = new JDlgVendasProdutos(null, true);
        vendasControle = new VendasControle();
        produtoVendasControle = new ProdutoVendasControle();
        produtoVendasControle.setList(lista);

        List listProduto = produtoVendasDAO.listAll();
        jTable1.setModel(produtoVendasControle);
   

        UtilDbc.habilitar(false,jBtnCancelar,jBtnConfirmar, jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
        UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir);
        UtilDbc.habilitar(true, jBtnIncluir,jBtnExcluir, jBtnAlterar);
        
        try{
             maskdata = new MaskFormatter("##/##/####");
        }catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData_dbc.setFormatterFactory(new DefaultFormatterFactory(maskdata));
     
    
        ClientesDAO clientesDAO = new ClientesDAO() ;
        List listaa = clientesDAO.listAll();
        for (int i = 0; i < listaa.size(); i++) {
           jCboClientes_dbc.addItem((ClienteDbc) listaa.get(i)); 
            
        }
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO() ;
        List lista1 = funcionarioDAO.listAll();
        for (int j = 0; j < lista1.size(); j++) {
           jCboVendedor_dbc.addItem((FuncionarioDbc) lista1.get(j)); 
            
        
        }
        
    
    }
     public VendasDbc viewBean() {
         /*SetarID*/
        VendasDbc vendasDbc = new VendasDbc();
        int id = UtilDbc.strInt(jTxtNumPed.getText());
        vendasDbc.setIdvendasDbc(id);
        /*SetarDouble*/
        double total = UtilDbc.strDouble(jTxtTotal.getText());
        vendasDbc.setValorTotalDbc(total);
        /*SetarDatas*/
        Date data = UtilDbc.strDate(jFmtData_dbc.getText());
        vendasDbc.setDatadaVendasDbc(data);
        /*SetarCombo*/
        vendasDbc.setClienteDbc((ClienteDbc) jCboClientes_dbc.getSelectedItem());
        vendasDbc.setFuncionarioDbc((FuncionarioDbc) jCboVendedor_dbc.getSelectedItem());
        return vendasDbc;
     }
     public void beanView(VendasDbc vendasDbc) {
         quekralhoDbc = vendasDbc;
         /*SetarID*/
        String intStr = UtilDbc.intStr(vendasDbc.getIdvendasDbc());
        jTxtNumPed.setText(intStr);
        /*SetarDouble*/
        String total = UtilDbc.doubleStr(vendasDbc.getValorTotalDbc());
        jTxtTotal.setText(total);
        /*SetarDatas*/
        jFmtData_dbc.setText(UtilDbc.dateStr(vendasDbc.getDatadaVendasDbc()));
        /*SetarCombo*/
        jCboVendedor_dbc.setSelectedItem(vendasDbc.getFuncionarioDbc());
        jCboClientes_dbc.setSelectedItem(vendasDbc.getClienteDbc());
        
//        produtoVendasDAO = new ProdutoVendasDAO();
//        List listaProd = (List) produtoVendasDAO.listProduto(quekralhoDbc);
//        produtoVendasControle.setList(listaProd);   
     }
      public  void  setTelaAnterior(JDlgVendas jDlgVendas){
            this.jDlgVendas  = jDlgVendas;
    }
    public int getSelectedRowProd(){
        return jTable1.getSelectedRow();
    }
   /**
  1   * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtNumPed = new javax.swing.JTextField();
        jCboClientes_dbc = new javax.swing.JComboBox<>();
        jCboVendedor_dbc = new javax.swing.JComboBox<>();
        jTxtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnAlterarTable = new javax.swing.JButton();
        jBtnExcluirTable = new javax.swing.JButton();
        jbtnIncluirTable = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jFmtData_dbc = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num. Pedido");

        jLabel2.setText("Data");

        jLabel3.setText("CLientes");

        jLabel4.setText("Vendedor");

        jLabel5.setText("Total");

        jTxtNumPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNumPedActionPerformed(evt);
            }
        });

        jCboClientes_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClientes_dbcActionPerformed(evt);
            }
        });

        jTxtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTotalActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jBtnAlterarTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Alterar.png"))); // NOI18N
        jBtnAlterarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarTableActionPerformed(evt);
            }
        });

        jBtnExcluirTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Excluir (1).png"))); // NOI18N
        jBtnExcluirTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirTableActionPerformed(evt);
            }
        });

        jbtnIncluirTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Incluir.png"))); // NOI18N
        jbtnIncluirTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIncluirTableActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ok .png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Excluir (1).png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Cancelar .png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Pesquisa (1).png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterar)
                .addGap(18, 18, 18)
                .addComponent(jBtnExcluir)
                .addGap(12, 12, 12)
                .addComponent(jBtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCancelar)
                .addGap(18, 18, 18)
                .addComponent(jBtnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnAlterar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnConfirmar)
                        .addComponent(jBtnExcluir)
                        .addComponent(jBtnCancelar)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTxtNumPed, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jFmtData_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboClientes_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jCboVendedor_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnIncluirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxtNumPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFmtData_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCboClientes_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboVendedor_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIncluirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterarTable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNumPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNumPedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNumPedActionPerformed

    private void jTxtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTotalActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        incl = true;
        
        UtilDbc.habilitar(true, jBtnConfirmar, jBtnCancelar,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
        UtilDbc.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
      //  vendaControle.setList(new ArrayList());
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        incl = false;
        jDlgVendasProdutos.setVisible(true);
        UtilDbc.habilitar(true, jBtnConfirmar, jBtnCancelar,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
        UtilDbc.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
    if(quekralhoDbc != null){
       if (UtilDbc.perguntar("Excluir?") == true) {
       ProdutoVendasDAO produtoVendasDAO = new ProdutoVendasDAO();
        ProdutoVendasDbc produtoVendasDbc;
        for(int linha = 0; linha< jTable1.getRowCount(); linha++){
            produtoVendasDbc = produtoVendasControle.getBean(linha);
            produtoVendasDAO.delete(produtoVendasDbc);
        }
        vendasDAO.delete(quekralhoDbc);
    }
      else{
             UtilDbc.mensagem("Pesquisa");
               }
    UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
    }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        VendasDbc vendasDbc = viewBean();
        VendasDAO vendaDAO = new VendasDAO();

         if (incl == true) {
                vendaDAO.insert(vendasDbc);
                 UtilDbc.mensagem("Registro incluido com sucesso.");
             } else {
                vendaDAO.update(vendasDbc);
                 UtilDbc.mensagem("Registro alterado com sucesso.");

                 }
           produtoVendasControle.limparTabela();
    UtilDbc.habilitar(false,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
    UtilDbc.habilitar(true, jBtnIncluir,jBtnPesquisar);
    UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        UtilDbc.mensagem("Operação Cancelada!");
    UtilDbc.habilitar(false, jBtnCancelar, jBtnConfirmar, jBtnAlterar, jBtnExcluir,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
    UtilDbc.habilitar(true, jBtnIncluir, jBtnPesquisar);
    UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtNumPed, jFmtData_dbc, jCboClientes_dbc, jCboVendedor_dbc, jTxtTotal, jBtnAlterarTable, jBtnExcluirTable, jbtnIncluirTable);
  
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
    jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true);
    jDlgVendasPesquisa.setTitle("Pesquisar");
    jDlgVendasPesquisa.setTelaAnterior(this);
    jDlgVendasPesquisa.setVisible(true);
//    vendaControle.setList(new ArrayList());
    UtilDbc.habilitar(true, jBtnAlterar, jBtnExcluir, jBtnIncluir);
    UtilDbc.habilitar(false, jBtnCancelar, jBtnConfirmar);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jbtnIncluirTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirTableActionPerformed
    jDlgVendasProdutos.setTitle("Incluir");
    jDlgVendasProdutos.setTelaAnterior(this);
    jDlgVendasProdutos.setVisible(true);
    }//GEN-LAST:event_jbtnIncluirTableActionPerformed

    private void jCboClientes_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClientes_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClientes_dbcActionPerformed

    private void jBtnAlterarTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarTableActionPerformed
    JDlgVendasProdutos jDlgVendasProduto = new JDlgVendasProdutos(null, true);
    jDlgVendasProduto.setTitle("Alteração de Produto");
    jDlgVendasProduto.setTelaAnterior(this);
    int linSel = jTable1.getSelectedRow();
    ProdutoVendasDbc produtoVendasDbc = (ProdutoVendasDbc) produtoVendasControle.getBean(linSel);
    jDlgVendasProduto.beanView(produtoVendasDbc);
    jDlgVendasProduto.setVisible(true);
    UtilDbc.mensagem("Produto Alterado.");
    }//GEN-LAST:event_jBtnAlterarTableActionPerformed

    private void jBtnExcluirTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirTableActionPerformed
        ProdutoVendasControle produtoVendasControle = new  ProdutoVendasControle ();
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            UtilDbc.mensagem("Nenhuma linha selecionada");
            
        } else {
            if (UtilDbc.perguntar("Confirma exclusão do produto?") == true) {
                produtoVendasControle.removeBean(linha);
                    UtilDbc.mensagem("Produto Excluido.");
        ((ProdutoVendasControle) jTable1.getModel()).removeBean(linha);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnExcluirTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarTable;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirTable;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<ClienteDbc> jCboClientes_dbc;
    private javax.swing.JComboBox<FuncionarioDbc> jCboVendedor_dbc;
    private javax.swing.JFormattedTextField jFmtData_dbc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumPed;
    private javax.swing.JTextField jTxtTotal;
    private javax.swing.JButton jbtnIncluirTable;
    // End of variables declaration//GEN-END:variables
}
