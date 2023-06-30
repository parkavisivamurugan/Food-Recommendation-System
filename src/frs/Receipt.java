/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frs;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELCOT
 */
public class Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Receipt
     */
    String[][] pass = new String [10][10];
    int totcost;
    int n;
    public Receipt(String[][]pass1,int n1,int tot1) {
        n = n1;
        totcost = tot1;
        
            // TODO add your handling code here:
                
        
        initComponents();
        DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
        tb1Model.setRowCount(0);
        for(int i=0;i<n;i++)
        {
            int cost = Integer.parseInt(pass1[i][1]);
            int quan = Integer.parseInt(pass1[i][2]);
            int amt = cost*quan;
            String amt1 = Integer.toString(amt);
            String tbData[]={pass1[i][0],pass1[i][1],pass1[i][2],amt1};
                //DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
            tb1Model.addRow(tbData);
        }
        tot.setText(Integer.toString(tot1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("HAPPY EATING !!!!!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 11, 261, 52));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("HERE IS YOUR BILL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 74, 296, 31));

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 140, -1));

        jTable1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOOD", "COST", "QUANTITY", "AMOUNT"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 123, 692, 228));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("TOTAL COST =");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 362, -1, 30));

        tot.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        getContentPane().add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 362, 133, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frs/bg5.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String [][] a = new String[2][2];
                new Receipt(a,0,0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}