/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteDbc;
import dao.ClientesDAO;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.UtilDbc;
import viewPesquisa.JDlgClientesPesquisa;

/**
 *
 * @author u03402615100
 */
public class JDlgClientes extends javax.swing.JDialog {
    private JDlgClientesPesquisa jDlgClientesPesquisa; 
    private boolean incl;
    MaskFormatter maskdata;
    MaskFormatter maskcpf;
    MaskFormatter maskrg;
    MaskFormatter masktel;
    MaskFormatter maskdatareg;
    MaskFormatter maskcep;
    UtilDbc util;
/**
     * Creates new form JDlgClientes
     */
    public JDlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Clientes");
        setLocationRelativeTo(null);
        
        UtilDbc.habilitar(false, jCboFormacao_dbc,jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
        UtilDbc.limparCampos(jBtnAlterar,jCboFormacao_dbc,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
        jBtnIncluir.setEnabled(true);
        
        
        try {
            maskcpf = new MaskFormatter("###.###.###-##");
            maskdata = new MaskFormatter("##/##/####");
            maskrg = new MaskFormatter("#.###.###");
            masktel = new MaskFormatter("(##)#####-####");
            maskdatareg = new MaskFormatter("##/##/####");
            maskcep = new MaskFormatter("#####-###");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtTelefone_dbc.setFormatterFactory(new DefaultFormatterFactory(masktel));
        jFmtRg_Dbc.setFormatterFactory(new DefaultFormatterFactory(maskrg));
        jFmtCpf_Dbc.setFormatterFactory(new DefaultFormatterFactory(maskcpf));
        jFmtData_dbc.setFormatterFactory(new DefaultFormatterFactory(maskdata));
        jFmtDataRegistro_dbc.setFormatterFactory(new DefaultFormatterFactory(maskdatareg));
        jFmtCep_dbc.setFormatterFactory(new DefaultFormatterFactory(maskcep));
    }
    
    
    public ClienteDbc viewBean() {
        /*SetarID*/
        ClienteDbc clienteDbc = new ClienteDbc();
        int id = UtilDbc.strInt(jTxtCodigo_dbc.getText());
        clienteDbc.setIdclienteDbc(id);
        
        /*SetarDatas*/
        Date dataNascimento = UtilDbc.strDate(jFmtData_dbc.getText());
        clienteDbc.setDataNascDbc(dataNascimento);
        Date dataRegistro = UtilDbc.strDate(jFmtDataRegistro_dbc.getText());
        clienteDbc.setDataRegistroDbc(dataRegistro);
        /*SetarTextos*/
        clienteDbc.setNomeDbc(jTxtNome_dbc.getText());
        clienteDbc.setProfissaoDbc(JTxtProfissao_dbc.getText());
        clienteDbc.setCpfDbc(jFmtCpf_Dbc.getText());
        clienteDbc.setEmailDbc(JTxtEmail_dbc.getText());
        clienteDbc.setEnderecoDbc(JTxtEndereco_dbc.getText());
        clienteDbc.setCidadeDbc(JTxtCidade_dbc.getText());
        clienteDbc.setTelefoneDbc(jFmtTelefone_dbc.getText());
        clienteDbc.setEstadoDbc(JTxtEstado_dbc.getText());
        clienteDbc.setCepDbc(jFmtCep_dbc.getText());
        clienteDbc.setRgDbc(jFmtRg_Dbc.getText());  
        /*SetarCombo*/
        if ((JCboEstadoCivil_dbc.getSelectedIndex() == 0)) {
            clienteDbc.setEstadoCivilDbc("Solteiro");
        } else if ((JCboEstadoCivil_dbc.getSelectedIndex() == 1)) {
            clienteDbc.setEstadoCivilDbc("Casado");
        } else if ((JCboEstadoCivil_dbc.getSelectedIndex() == 2)) {
            clienteDbc.setEstadoCivilDbc("Viuvo");
        } else {
            clienteDbc.setEstadoCivilDbc("Namorando");
        }
        if ((jCboFormacao_dbc.getSelectedIndex() == 0)) {
            clienteDbc.setFormacaoDbc("Fundamental");
        } else if ((jCboFormacao_dbc.getSelectedIndex() == 1)) {
            clienteDbc.setFormacaoDbc("Medio");
        } else {
            clienteDbc.setFormacaoDbc("Superior");
        }
        return clienteDbc;
    }
    
    public void beanView(ClienteDbc clienteDbc) {
        /*SetarId*/
        String intStr = UtilDbc.intStr(clienteDbc.getIdclienteDbc());
        jTxtCodigo_dbc.setText(intStr);
        /*SetarDatas*/
        jFmtData_dbc.setText(UtilDbc.dateStr(clienteDbc.getDataNascDbc()));
        jFmtDataRegistro_dbc.setText(UtilDbc.dateStr(clienteDbc.getDataRegistroDbc()));
        
        /*SetarTextos*/
        jTxtNome_dbc.setText(clienteDbc.getNomeDbc());
        jFmtCep_dbc.setText(clienteDbc.getCepDbc());
        JTxtProfissao_dbc.setText(clienteDbc.getProfissaoDbc());
        JTxtEmail_dbc.setText(clienteDbc.getEmailDbc());
        jFmtCpf_Dbc.setText(clienteDbc.getCpfDbc());
        JTxtEndereco_dbc.setText(clienteDbc.getEnderecoDbc());
        JTxtCidade_dbc.setText(clienteDbc.getCidadeDbc());
        jFmtTelefone_dbc.setText(clienteDbc.getTelefoneDbc());
        JTxtEstado_dbc.setText(clienteDbc.getEstadoDbc());
        jFmtRg_Dbc.setText(clienteDbc.getRgDbc());
        
        /*SetarCombo*/
        String estadoCivil =clienteDbc.getEstadoCivilDbc();
        if(estadoCivil.equals("Solteiro")){
            JCboEstadoCivil_dbc.setSelectedIndex(0);
        }else if(estadoCivil.equals("Casado")){
            JCboEstadoCivil_dbc.setSelectedIndex(1);
        }else if(estadoCivil.equals("Viuvo")){
            JCboEstadoCivil_dbc.setSelectedIndex(2);
        }else if(estadoCivil.equals("Divorciado")){
            JCboEstadoCivil_dbc.setSelectedIndex(3);
        }else {
            JCboEstadoCivil_dbc.setSelectedIndex(4);
        }
        
        String formacao =clienteDbc.getFormacaoDbc();
        if(formacao.equals("Fundamental")){
            jCboFormacao_dbc.setSelectedIndex(0);
        }else if(formacao.equals("Medio")){
            jCboFormacao_dbc.setSelectedIndex(1);
        }else {
            jCboFormacao_dbc.setSelectedIndex(2);
        }
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigo_dbc = new javax.swing.JTextField();
        jTxtNome_dbc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTxtEmail_dbc = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JCboEstadoCivil_dbc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JTxtProfissao_dbc = new javax.swing.JTextField();
        JTxtEndereco_dbc = new javax.swing.JTextField();
        JTxtCidade_dbc = new javax.swing.JTextField();
        JTxtEstado_dbc = new javax.swing.JTextField();
        jFmtData_dbc = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFmtRg_Dbc = new javax.swing.JFormattedTextField();
        jFmtCpf_Dbc = new javax.swing.JFormattedTextField();
        jFmtCep_dbc = new javax.swing.JFormattedTextField();
        jFmtDataRegistro_dbc = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFmtTelefone_dbc = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jCboFormacao_dbc = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jTxtCodigo_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigo_dbcActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        JTxtEmail_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtEmail_dbcActionPerformed(evt);
            }
        });

        jLabel7.setText("email");

        jLabel3.setText("Telefone");

        JCboEstadoCivil_dbc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Viuvo", "Divorciado", "Namorando" }));

        jLabel4.setText("Estado Civil");

        jLabel5.setText("Profissao");

        jLabel6.setText("RG");

        jLabel8.setText("CPF");

        jLabel10.setText("Endereço");

        jLabel11.setText("Estado");

        jLabel12.setText("Cidade");

        jLabel13.setText("Cep");

        jLabel14.setText("Data de Registro");

        jFmtData_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtData_dbcActionPerformed(evt);
            }
        });

        jLabel15.setText("Data de Nascimento");

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

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Excluir (1).png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ok .png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Pesquisa (1).png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Cancelar .png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jFmtCep_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCep_dbcActionPerformed(evt);
            }
        });

        jFmtDataRegistro_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataRegistro_dbcActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel9.setText("Cadastro de Clientes");

        jFmtTelefone_dbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtTelefone_dbcActionPerformed(evt);
            }
        });

        jLabel16.setText("Formação");

        jCboFormacao_dbc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundamental", "Medio", "Superior" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jFmtRg_Dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFmtCpf_Dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(JTxtProfissao_dbc))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(132, 132, 132)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFmtDataRegistro_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jFmtTelefone_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTxtCodigo_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTxtNome_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7)
                                        .addComponent(JTxtEmail_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)
                                    .addComponent(jFmtData_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel2)
                                    .addGap(370, 370, 370)
                                    .addComponent(jLabel15))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(176, 176, 176)
                                    .addComponent(jLabel9))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtCep_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCboFormacao_dbc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCboEstadoCivil_dbc, javax.swing.GroupLayout.Alignment.LEADING, 0, 107, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnIncluir)
                                .addGap(6, 6, 6)
                                .addComponent(jBtnAlterar)
                                .addGap(6, 6, 6)
                                .addComponent(jBtnExcluir)
                                .addGap(10, 10, 10)
                                .addComponent(jBtnConfirmar)
                                .addGap(6, 6, 6)
                                .addComponent(jBtnCancelar)
                                .addGap(6, 6, 6)
                                .addComponent(jBtnPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(JTxtEndereco_dbc))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(203, 203, 203)
                                        .addComponent(jLabel12))
                                    .addComponent(JTxtEstado_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(180, 180, 180)))))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTxtCidade_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtCep_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboFormacao_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25))
                            .addComponent(jFmtTelefone_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel15))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtCodigo_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtNome_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtData_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(JTxtEmail_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jFmtDataRegistro_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCboEstadoCivil_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxtProfissao_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCpf_Dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtRg_Dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTxtCidade_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTxtEstado_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxtEndereco_dbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtCodigo_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigo_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo_dbcActionPerformed

    private void JTxtEmail_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtEmail_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtEmail_dbcActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
    incl = true;
    UtilDbc.habilitar(true, jBtnConfirmar,jCboFormacao_dbc,jCboFormacao_dbc, jBtnCancelar, jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    UtilDbc.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    UtilDbc.limparCampos(jBtnAlterar,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
    incl = false;
    UtilDbc.habilitar(true, jBtnConfirmar,jCboFormacao_dbc, jBtnCancelar,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    UtilDbc.habilitar(false, jBtnIncluir,jBtnAlterar, jBtnExcluir, jBtnPesquisar, jTxtCodigo_dbc);
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
    ClienteDbc clienteDbc = viewBean();
    ClientesDAO clientesDAO = new ClientesDAO();
    
    if (incl == true) {
        clientesDAO.insert(clienteDbc);
        UtilDbc.mensagem("Registro incluido com sucesso.");
    } else {
        clientesDAO.update(clienteDbc);
        UtilDbc.mensagem("Registro alterado com sucesso.");
        }
    UtilDbc.habilitar(false, jCboFormacao_dbc,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    UtilDbc.habilitar(true, jBtnIncluir,jBtnPesquisar);
    UtilDbc.limparCampos(jBtnAlterar,jCboFormacao_dbc,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
    jDlgClientesPesquisa = new JDlgClientesPesquisa(null, true);
    jDlgClientesPesquisa.setTitle("Pesquisar");
    jDlgClientesPesquisa.setTelaAnterior(this);
    jDlgClientesPesquisa.setVisible(true);
    UtilDbc.habilitar(true, jBtnAlterar, jBtnExcluir, jBtnIncluir);
    UtilDbc.habilitar(false, jBtnCancelar, jBtnConfirmar);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
    UtilDbc.mensagem("Operação Cancelada!");
    UtilDbc.habilitar(false, jBtnCancelar,jCboFormacao_dbc, jBtnConfirmar, jBtnAlterar, jBtnExcluir, jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    UtilDbc.habilitar(true, jBtnIncluir, jBtnPesquisar);
    UtilDbc.limparCampos(jBtnAlterar,jCboFormacao_dbc,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
    if (UtilDbc.perguntar("Deseja excluir o registro?") == true) {
        ClienteDbc clienteDbc = viewBean();
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.delete(clienteDbc);
        UtilDbc.mensagem("Registro Excluido.");
    }else{
        UtilDbc.mensagem("Exclusão Cancelada.");
       }
    UtilDbc.limparCampos(jBtnAlterar,jCboFormacao_dbc,jBtnCancelar,jBtnConfirmar,jBtnExcluir,jTxtCodigo_dbc,jTxtNome_dbc,jFmtData_dbc,JTxtEmail_dbc,JCboEstadoCivil_dbc,jFmtCep_dbc,jFmtRg_Dbc,jFmtCpf_Dbc,JTxtProfissao_dbc,JTxtEndereco_dbc,JTxtEstado_dbc,JTxtCidade_dbc,jFmtTelefone_dbc,jFmtDataRegistro_dbc);
    }//GEN-LAST:event_jBtnExcluirActionPerformed
 
    private void jFmtData_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtData_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtData_dbcActionPerformed

    private void jFmtCep_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCep_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCep_dbcActionPerformed

    private void jFmtDataRegistro_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataRegistro_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataRegistro_dbcActionPerformed

    private void jFmtTelefone_dbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtTelefone_dbcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtTelefone_dbcActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgClientes dialog = new JDlgClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JCboEstadoCivil_dbc;
    private javax.swing.JTextField JTxtCidade_dbc;
    private javax.swing.JFormattedTextField JTxtEmail_dbc;
    private javax.swing.JTextField JTxtEndereco_dbc;
    private javax.swing.JTextField JTxtEstado_dbc;
    private javax.swing.JTextField JTxtProfissao_dbc;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboFormacao_dbc;
    private javax.swing.JFormattedTextField jFmtCep_dbc;
    private javax.swing.JFormattedTextField jFmtCpf_Dbc;
    private javax.swing.JFormattedTextField jFmtDataRegistro_dbc;
    private javax.swing.JFormattedTextField jFmtData_dbc;
    private javax.swing.JFormattedTextField jFmtRg_Dbc;
    private javax.swing.JFormattedTextField jFmtTelefone_dbc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTxtCodigo_dbc;
    private javax.swing.JTextField jTxtNome_dbc;
    // End of variables declaration//GEN-END:variables
}
