/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frs;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELCOT
 */
public class ManageMenu extends javax.swing.JFrame {

    
    Connection con = javaConnect.connectdb();
    PreparedStatement ps =null;
    Statement stmt=con.createStatement();
    ResultSet rs = null;
    public ManageMenu() throws SQLException{
        
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        n = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        c = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        t = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOOD", "COST", "QUANTITY", "TYPE"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 19, 689, 203));

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setText("SHOW MENU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 240, 132, 39));

        n.setText("FoodName");
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 315, 191, 41));

        add.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 398, 131, 39));

        delete.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 399, 126, 39));

        update.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 399, 131, 39));

        c.setText("Enter_cost");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 316, 131, 38));

        q.setText("Enter_quantity");
        q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qActionPerformed(evt);
            }
        });
        getContentPane().add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 316, 144, 38));

        t.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        t.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VEG", "NON-VEG" }));
        getContentPane().add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 313, 129, 43));

        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton5.setText("LOG OUT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 467, 124, 31));

        msg.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 456, 378, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frs/bg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
            tb1Model.setRowCount(0);
            // TODO add your handling code here:
            
            String sql = "select *from menu";
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String name = rs.getString("fname");
                String cost = String.valueOf(rs.getInt("fcost"));
                String quan = String.valueOf(rs.getInt("fquan"));
                String type = rs.getString("foodtype");
                String tbData[]={name,cost,quan,type};
                //DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
                tb1Model.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            // TODO add your handling code here:
            String name = n.getText();
            msg.setText(null);
            if(name.equals("FoodName"))
            {
                msg.setText("Enter the Food Name in the MENU!!!1");
            }
            else
            {    
                int x = stmt.executeUpdate("delete from menu where fname = '"+name+"'");
                msg.setText("Food is Deleted!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            String name = n.getText();
            String cost = c.getText();
            String quan = q.getText();
            msg.setText(null);
            if(name.equals("FoodName"))
            {
                msg.setText("Enter the Food Name in the MENU!!!1");
            }
            else if(!cost.equals("Enter_cost") && !quan.equals("Enter_quantity"))
            {
                System.out.println("1st");
              int x = stmt.executeUpdate("update menu set fcost = '"+cost+"',fquan = '"+quan+"' where fname = '"+name+"'");
              msg.setText("Updation Done!!!");
            }
            else if(cost.equals("Enter_cost") && quan.equals("Enter_quantity"))
            {
                System.out.println("2");
                msg.setText("Enter the cost or Quantity to update !!!!!");
            }
            else if(cost.equals("Enter_cost"))
            {
                System.out.println("3");
                int x = stmt.executeUpdate("update menu set fquan = '"+quan+"' where fname = '"+name+"'");
                msg.setText("Updation Done!!!");
            }
            else{
                System.out.println("4");
                int x = stmt.executeUpdate("update menu set fcost = '"+cost+"' where fname = '"+name+"'");
                msg.setText("Updation Done!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String fid;
        try {                                         
            
                // TODO add your handling code here:
                
                String sql = "select count(*) as c from menu";
                rs = stmt.executeQuery(sql);
                String count=null;
                while(rs.next())
                {
                    count = rs.getString("c");
                }
               System.out.println("hello");
                int coun = Integer.parseInt(count) + 1;
                String o = Integer.toString(coun);
                fid = "F"+o;
                //System.out.println(fid);
                 String name = n.getText();
                 //System.out.println(name);
                 String costs = c.getText();
                 //System.out.println(costs);
                 String quans = q.getText();
                // System.out.println(quans);
            
            String type = (String) t.getSelectedItem();  
            System.out.println("hi");
            msg.setText(null);
            if(name.equals("FoodName") || costs.equals("Enter_cost") || quans.equals("Enter_quantity"))
            {
                System.out.println("1st");
                msg.setText("Fill all the needed details!!!!");
                
            }
            else
            {
                System.out.println("3nd");
               int x = stmt.executeUpdate("insert into menu values('"+fid+"','"+name+"','"+costs+"','"+quans+"','"+type+"')");
               msg.setText("Insertion Done!!!");
            }
            } catch (SQLException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
           
    }//GEN-LAST:event_addActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageMenu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField c;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField n;
    private javax.swing.JTextField q;
    private javax.swing.JComboBox<String> t;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
