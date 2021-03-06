/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.PersonalDAO;
import Model.Personal;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author procc
 */
public class JInternalFrameNghiaVu extends javax.swing.JInternalFrame {

    PersonalDAO dao = new PersonalDAO();
    public JInternalFrameNghiaVu() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(Personal ps : dao.findSeiJinPeoPle()){
            model.addRow(new Object[]{ps.getIdentityCode(),ps.getName(),ps.getAge(),ps.getBirthYear(),ps.getHouse().getHouseId(),ps.getCareer()});
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelHoDan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(1000, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số Cmt", "Tên", "Tuổi", "Năm sinh", "Số nhà", "Công việc"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 340));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        jLabelHoDan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHoDan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHoDan.setText("Xuất ra excel");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_XLS_48px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelHoDan)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabelHoDan)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1000, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        setColor(jPanel1);
        exportExcel(jTable1);
        resetColor(jPanel1);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        setColor(jPanel1);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        resetColor(jPanel1);
    }//GEN-LAST:event_jPanel1MouseExited
    public void exportExcel(JTable table) {
    JFileChooser chooser = new JFileChooser();
    int i = chooser.showSaveDialog(chooser);
    if (i == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
  try {
   FileWriter out = new FileWriter(file + ".xls");
   BufferedWriter bwrite = new BufferedWriter(out);
      TableModel model = table.getModel();
   // ten Cot
   for (int j = 0; j < table.getColumnCount(); j++) {
    bwrite.write(model.getColumnName(j) + "\t");
   }
   bwrite.write("\n");
   // Lay du lieu dong
   for (int j = 0; j < table.getRowCount(); j++) {
    for (int k = 0; k < table.getColumnCount(); k++) {
     bwrite.write(model.getValueAt(j, k) + "\t");
    }
    bwrite.write("\n");
   }
   bwrite.close();
   out.close();
   JOptionPane.showMessageDialog(null, "Lưu file thành công!");
  } catch (Exception e2) {
   JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
  }
 }
}
public void setColor(JPanel panel){
        panel.setBackground(new Color(153,153,255));
    }
    public void resetColor(JPanel panel){
        panel.setBackground(new Color(102,204,255));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHoDan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
