/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.mysql.jdbc.Statement;
import controle.ConectaBanco;
import controle.ControlaUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.MUsuario;

/**
 *
 * @author Bruno
 */
public class VEditar extends javax.swing.JFrame {

    MUsuario usuario = MUsuario.getInstance();

    ConectaBanco conexao = new ConectaBanco();
    ControlaUsuario cadastraUsuario = new ControlaUsuario();

    public String getTxtConfirmarSenha() {
        return txtConfirmarSenha.getText();
    }

    public void setTxtConfirmarSenha(String txtConfirmarSenha) {
        this.txtConfirmarSenha.setText(txtConfirmarSenha);
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public String getTxtNomeUsuario() {
        return txtNomeUsuario.getText();
    }

    public void setTxtNomeUsuario(String txtNomeUsuario) {
        this.txtNomeUsuario.setText(txtNomeUsuario);
    }

    public String getTxtSenha() {
        return txtSenha.getText();
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha.setText(txtSenha);
    }

    public String getTxtSalarioMensal() {
        return txtSalarioMensal.getText();
    }

    public void setTxtSalarioMensal(String txtSalariomensal) {
        this.txtSalarioMensal.setText(txtSalariomensal);
    }

    public String getTxtRendaExtra() {
        return txtRendaExtra.getText();
    }

    public void setTxtRendaExtra(String txtRendaExtra) {
        this.txtRendaExtra.setText(txtRendaExtra);
    }

    public void pegaDados(String email) throws SQLException {
        conexao.conexao();

        if (conexao.conn != null) {

            try {

                conexao.executaSQL("SELECT * FROM usuario WHERE email='" + email + "'");

                while (conexao.rs.next()) {

                    setTxtNomeUsuario(conexao.rs.getString("nome"));
                    setTxtSenha(conexao.rs.getString("senha"));
                    String sm = String.valueOf(conexao.rs.getString("salarioMensal"));
                    setTxtSalarioMensal(sm);
                    String re = String.valueOf(conexao.rs.getString("rendaExtra"));
                    setTxtRendaExtra(re);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Inserção \n Erro:" + ex);
            }
        }
    }

    public boolean validacao() {

        if (getTxtNomeUsuario() == null || getTxtNomeUsuario().isEmpty() || "0".equals(getTxtNomeUsuario())) {
            JOptionPane.showMessageDialog(null, "Preencha o Nome de Usuario para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtNomeUsuario.requestFocus();
            this.setVisible(true);
        }
        /*
         if (getTxtEmail() == null || getTxtEmail().isEmpty() || "0".equals(getTxtEmail())) {
         JOptionPane.showMessageDialog(null, "Preencha o Email para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
         txtEmail.requestFocus();
         this.setVisible(true);
         }
         */
        
        if (getTxtSenha() == null || getTxtSenha().isEmpty() || "0".equals(getTxtSenha())) {
            JOptionPane.showMessageDialog(null, "Preencha a Senha para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            this.setVisible(true);
        }

        if (getTxtConfirmarSenha() == null || getTxtConfirmarSenha().isEmpty() || "0".equals(getTxtConfirmarSenha())) {
            JOptionPane.showMessageDialog(null, "Preencha o Confirmação de Senha para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            this.setVisible(true);
        }

        if (getTxtSalarioMensal() == null || getTxtSalarioMensal().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o Salario Mensal para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            this.setVisible(true);
        }

        if (getTxtRendaExtra() == null || getTxtRendaExtra().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a Renda Extra para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            this.setVisible(true);
        }

        return true;
    }

    public boolean validacaoSenha() {
        String senha = txtSenha.getText();
        int comp = senha.compareTo(txtConfirmarSenha.getText());

        if (comp == 0) {
            usuario.setSenha(txtSenha.getText());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Senha Incorreta", "Aviso", JOptionPane.WARNING_MESSAGE);
            this.setVisible(true);
            return false;
        }

    }

    public VEditar() {
        initComponents();
        txtEmail.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSalarioMensal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRendaExtra = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Nome do Usuario:");

        txtNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Email:");

        jLabel3.setText("Senha:");

        jLabel4.setText("Confirmar senha:");

        jLabel5.setText("Salário Mensal");

        jLabel6.setText("Renda Extra");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSalarioMensal))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtRendaExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtConfirmarSenha)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalarioMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRendaExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeUsuarioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (validacao() && validacaoSenha()) {
            double salarioMensal = Double.parseDouble(getTxtSalarioMensal());
            double rendaExtra = Double.parseDouble(getTxtRendaExtra());

            usuario.updateUsuario(getTxtNomeUsuario(), getTxtSenha(), salarioMensal, rendaExtra);

            try {

                String senha = txtSenha.getText();

                int comp = senha.compareTo(txtConfirmarSenha.getText());

                if (comp == 0) {
                    cadastraUsuario.UpdateUsuario(usuario.getEmail());
                    JOptionPane.showMessageDialog(null, "Editado com Sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } else {
                    this.setVisible(true);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na Edição \n Erro:" + ex);
            }
        }
        /*
         String senha = txtSenha.getText();
         int comp = senha.compareTo(txtConfirmarSenha.getText());

         if (comp == 0) {

         usuario.setSenha(txtSenha.getText());
         JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
         this.setVisible(true);

         } else {
         JOptionPane.showMessageDialog(null, "Senha Incorreta", "Aviso", JOptionPane.WARNING_MESSAGE);
         this.setVisible(false);

         }
         */


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VCadastramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VCadastramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VCadastramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VCadastramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VEditar().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtRendaExtra;
    private javax.swing.JTextField txtSalarioMensal;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
