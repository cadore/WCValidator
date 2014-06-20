package testes;

import br.com.cadore.wcvalidator.main.ConditionsValidation;
import br.com.cadore.wcvalidator.main.WCCustomValidation;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Form extends javax.swing.JFrame {

    WCCustomValidation wcc;
    
    public Form() {
        initComponents();
        wcc = new WCCustomValidation();
        wcc.addRule(tfText, ConditionsValidation.NotEmpty, null, null, "Campo Obrigatório.", Color.RED);
        wcc.addRule(tf1, ConditionsValidation.NotEmpty, null, null, "Campo Obrigatório.", Color.RED);
        wcc.addRule(tf2, ConditionsValidation.Empty, null, null, "Este campo deve estar vazio.", Color.YELLOW);
        wcc.addRule(tf3, ConditionsValidation.Empty, null, null, "Campo Obrigatório.", Color.RED);
        wcc.addRule(cb, ConditionsValidation.NotEmpty, null, null, "Campo Obrigatório.", Color.RED);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnValidate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf1 = new javax.swing.JTextArea();
        tf2 = new javax.swing.JFormattedTextField();
        tf3 = new javax.swing.JPasswordField();
        cb = new javax.swing.JComboBox();
        tfText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnValidate.setText("Validar");
        btnValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidateActionPerformed(evt);
            }
        });

        tf1.setColumns(20);
        tf1.setRows(5);
        jScrollPane1.setViewportView(tf1);

        cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnValidate))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(tfText)
                            .addComponent(tf2)
                            .addComponent(tf3)
                            .addComponent(cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValidate))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidateActionPerformed
        if(!wcc.Validate()){
            JOptionPane.showMessageDialog(rootPane, "Não Validou");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Validou");
    }//GEN-LAST:event_btnValidateActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValidate;
    private javax.swing.JComboBox cb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tf1;
    private javax.swing.JFormattedTextField tf2;
    private javax.swing.JPasswordField tf3;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables
}
