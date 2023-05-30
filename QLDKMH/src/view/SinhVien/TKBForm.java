/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SinhVien;

import controller.QLLopHocController;
import controller.QLMonHocController;
import controller.QLPhongHocController;
import controller.QLSVDangKyController;
import controller.QLSinhVienController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LopHoc;
import model.MonHoc;
import model.PhongHoc;
import model.SVDangKy;
import model.SinhVien;

/**
 *
 * @author ninhv
 */
public class TKBForm extends javax.swing.JFrame {

    private int selectedRow;
    private DefaultTableModel tblModel = new DefaultTableModel();
    private QLSVDangKyController qlsvdkc = new QLSVDangKyController();
    private QLSinhVienController qlsvc = new QLSinhVienController();
    private List<LopHoc> listLH = new ArrayList<>();
    private String id;

    /**
     * Creates new form TKBView
     */
    public TKBForm(String id) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.id = id;
        initTable();
        fillTable();
    }

    private void initTable() {
        String[] columns = new String[]{"Thứ", "Tiết", "Môn Học", "Phòng"};
        tblModel.setColumnIdentifiers(columns);
        tblTKB.setModel(tblModel);
    }

    private void fillTable() {
        SinhVien sv = qlsvc.getSVById(this.id);
        tblModel.setRowCount(0);
        listLH = qlsvdkc.getListLopHoc1SVDangKy(sv.getMaSV());
        Collections.sort(listLH);
        for (LopHoc lh : listLH) {
            MonHoc mh = new QLMonHocController().getMH(lh.getMaMH());
            PhongHoc ph = new QLPhongHocController().getPH(lh.getMaPH());
            tblModel.addRow(new Object[]{lh.getThu(), lh.getTiet(), mh.getTenMH(), ph.getTenPH()});
        }
        tblModel.fireTableDataChanged();
    }

    private void resetData() {
        String empty = "...";
        lbMaLH.setText(empty);
        lbTenLH.setText(empty);
        lbTenMH.setText(empty);
        lbSoTC.setText(empty);
        lbTiet.setText(empty);
        lbThu.setText(empty);
        lbNgayBatDau.setText(empty);
        lbTenPH.setText(empty);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTKB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbNgayBatDau = new javax.swing.JLabel();
        lbThu = new javax.swing.JLabel();
        lbTiet = new javax.swing.JLabel();
        lbSoTC = new javax.swing.JLabel();
        lbTenMH = new javax.swing.JLabel();
        lbTenLH = new javax.swing.JLabel();
        lbMaLH = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbTenPH = new javax.swing.JLabel();
        btnHuyMon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jLabel16.setText("jLabel16");

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTKB.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Thứ", "Môn Học"
            }
        ));
        tblTKB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTKBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTKB);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("THỜI KHÓA BIỂU");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Môn Học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã lớp:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên lớp:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Số Tín Chỉ: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tiết: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Thứ: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tên môn:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Ngày bắt đầu:");

        lbNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNgayBatDau.setText("...");

        lbThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbThu.setText("...");

        lbTiet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTiet.setText("...");

        lbSoTC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSoTC.setText("...");

        lbTenMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTenMH.setText("...");

        lbTenLH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTenLH.setText("...");

        lbMaLH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbMaLH.setText("...");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Phòng:");

        lbTenPH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTenPH.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaLH, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lbTenLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSoTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenPH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbMaLH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTenLH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTenMH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbSoTC))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbTiet))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbThu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbNgayBatDau))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbTenPH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnHuyMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icondelete16.png"))); // NOI18N
        btnHuyMon.setText("Hủy Môn");
        btnHuyMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyMonActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconthoat16.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuyMon)
                        .addGap(33, 33, 33)
                        .addComponent(btnThoat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thoát không?",
                "Hỏi", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.NO_OPTION) {
            return;
        }
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblTKBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTKBMouseClicked
        selectedRow = tblTKB.getSelectedRow();
        if (selectedRow >= 0) {
            LopHoc lh = listLH.get(selectedRow);
            MonHoc mh = new QLMonHocController().getMH(lh.getMaMH());
            PhongHoc ph = new QLPhongHocController().getPH(lh.getMaPH());
            lbMaLH.setText(lh.getMaLH());
            lbTenLH.setText(lh.getTenLH());
            lbTenMH.setText(mh.getTenMH());
            lbSoTC.setText(mh.getSoTinChi() + "");
            lbTiet.setText(lh.getTiet());
            lbThu.setText(lh.getThu());
            lbNgayBatDau.setText(lh.getNgayBatDau() + "");
            lbTenPH.setText(ph.getTenPH());
        }
    }//GEN-LAST:event_tblTKBMouseClicked

    private void btnHuyMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMonActionPerformed
        int choice = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa môn học này không?",
                "Hỏi", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.NO_OPTION) {
            return;
        }
        selectedRow = tblTKB.getSelectedRow();
        if (selectedRow >= 0) {
            LopHoc lh = listLH.get(selectedRow);
            SinhVien sv = new QLSinhVienController().getSVById(this.id);
            new QLSVDangKyController().xoaLopHocSV(sv.getMaSV(), lh.getMaLH());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn 1 dòng để xóa");
        }
        fillTable();
        resetData();
    }//GEN-LAST:event_btnHuyMonActionPerformed

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
            java.util.logging.Logger.getLogger(TKBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TKBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TKBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TKBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TKBForm("sv001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyMon;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaLH;
    private javax.swing.JLabel lbNgayBatDau;
    private javax.swing.JLabel lbSoTC;
    private javax.swing.JLabel lbTenLH;
    private javax.swing.JLabel lbTenMH;
    private javax.swing.JLabel lbTenPH;
    private javax.swing.JLabel lbThu;
    private javax.swing.JLabel lbTiet;
    private javax.swing.JTable tblTKB;
    // End of variables declaration//GEN-END:variables
}