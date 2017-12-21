/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.PhiDAO;
import Model.House;
import Model.Phi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author procc
 */
public class JInternalFrameDongTien extends javax.swing.JInternalFrame {

    PhiDAO dao = new PhiDAO();
    public JInternalFrameDongTien() {
        initComponents();
        LoadData();
    }
    private void LoadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String phiXD;
        String phiTT;
        String quyQP;
        String phiPhuong;
        String quyKH;
        String quyNgCaoTuoi;
        for(Phi p : dao.list()){
            if(p.isPhiXdCsht()) phiXD="Đã đóng";
            else phiXD="Chưa đóng";
            if(p.isPhiTuThien()) phiTT="Đã đóng";
            else phiTT="Chưa đóng";
            if(p.isQuyQuocPhong()) quyQP="Đã đóng";
            else quyQP="Chưa đóng";
            if(p.isPhiDuyTriPhuong()) phiPhuong="Đã đóng";
            else phiPhuong="Chưa đóng";
            if(p.isQuyKhuyenHoc()) quyKH="Đã đóng";
            else quyKH="Chưa đóng";
            if(p.isQuyCsNgCaoTuoi()) quyNgCaoTuoi="Đã đóng";
            else quyNgCaoTuoi="Chưa đóng";
            model.addRow(new Object[]{p.getHouseId(),phiXD,phiTT,quyQP,phiPhuong,quyKH,quyNgCaoTuoi});
        }
        jTable1.repaint();
        jTable1.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonPhiXD = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonPhiTT = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonQuyQP = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonQuyNCT = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonQuyKH = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonPhiDT = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButtonPhiXD.setText("Đã đóng");
        getContentPane().add(jRadioButtonPhiXD, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        jLabel1.setText("Số nhà ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 59, 29));

        jRadioButtonPhiTT.setText("Đã đóng");
        getContentPane().add(jRadioButtonPhiTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, -1, -1));

        jLabel2.setText("Phí xây dựng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, 40));

        jRadioButtonQuyQP.setText("Đã đóng");
        getContentPane().add(jRadioButtonQuyQP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        jLabel3.setText("Phí từ thiện");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 74, 24));

        jRadioButtonQuyNCT.setText("Đã đóng");
        getContentPane().add(jRadioButtonQuyNCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        jLabel4.setText("Quỹ quốc phòng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 100, -1));

        jRadioButtonQuyKH.setText("Đã đóng");
        getContentPane().add(jRadioButtonQuyKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, -1, 30));

        jLabel6.setText("Phí Duy trì Phường");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, 30));

        jRadioButtonPhiDT.setText("Đã đóng");
        jRadioButtonPhiDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPhiDTActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonPhiDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, 30));

        jLabel5.setText("Quỹ Khuyến Học");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 100, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, -1));

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        jLabel7.setText("Quỹ Người cao tuổi");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số nhà", "Phí Xây dựng", "Phí Từ Thiện", "Quỹ quốc phòng", "Phí Duy Trì Phường", "Quỹ Khuyến Học", "Quỹ Người cao tuổi"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 4, 1000, 230));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 87, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonPhiDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPhiDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonPhiDTActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa không ? ", "Thông báo ", JOptionPane.YES_NO_OPTION);
        if(check == JOptionPane.YES_OPTION ){

            if(dao.delete(dao.search(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()))){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                LoadData();
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn là muốn cập nhật không ? ", "Thông báo cập nhật", JOptionPane.YES_NO_OPTION);
        if(check == JOptionPane.YES_OPTION ){
            Phi p = dao.search(jTextField1.getText());
            if(p==null) p = new Phi();
            p.setHouseId(jTextField1.getText());
            p.setPhiDuyTriPhuong(jRadioButtonPhiDT.isSelected());
            p.setPhiTuThien(jRadioButtonPhiTT.isSelected());
            p.setPhiXdCsht(jRadioButtonPhiXD.isSelected());
            p.setQuyCsNgCaoTuoi(jRadioButtonQuyNCT.isSelected());
            p.setQuyKhuyenHoc(jRadioButtonQuyKH.isSelected());
            p.setQuyQuocPhong(jRadioButtonQuyQP.isSelected());
            p.setHouse(new House(p.getHouseId()));
            if(dao.edit(p) || dao.save(p)){
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                LoadData();
            }else{
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        Phi p = dao.search(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTextField1.setText(p.getHouseId());
        jRadioButtonPhiDT.setSelected(p.isPhiDuyTriPhuong());
        jRadioButtonPhiTT.setSelected(p.isPhiTuThien());
        jRadioButtonPhiXD.setSelected(p.isPhiXdCsht());
        jRadioButtonQuyKH.setSelected(p.isQuyKhuyenHoc());
        jRadioButtonQuyNCT.setSelected(p.isQuyCsNgCaoTuoi());
        jRadioButtonQuyQP.setSelected(p.isQuyQuocPhong());
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonPhiDT;
    private javax.swing.JRadioButton jRadioButtonPhiTT;
    private javax.swing.JRadioButton jRadioButtonPhiXD;
    private javax.swing.JRadioButton jRadioButtonQuyKH;
    private javax.swing.JRadioButton jRadioButtonQuyNCT;
    private javax.swing.JRadioButton jRadioButtonQuyQP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
