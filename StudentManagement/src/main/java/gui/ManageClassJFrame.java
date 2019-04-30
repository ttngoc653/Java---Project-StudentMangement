package gui;

import dal.*;
import dto.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuhuy
 */
public class ManageClassJFrame extends javax.swing.JFrame {

    LopDAL lopDao = new LopDAL();

    /**
     * Creates new form ManageClassJFrame
     */
    public ManageClassJFrame() {
        initComponents();
        LoadData();
    }

    dto.Nguoidung nd;

    public ManageClassJFrame(Nguoidung nguoidung) {
        initComponents();
        nd = nguoidung;
        lblTenTaiKhoan.setText(nd.getHoTen());
        LoadData();
    }

    private void LoadData() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã lớp");
        dtm.addColumn("Tên lớp");
        dtm.addColumn("Khối");
        dtm.addColumn("Tình trạng");

        for (Lop a : new LopDAL().getAll()) {
            dtm.addRow(new Object[]{a.getIdLop(), a.getTenLop(), a.getKhoi(), a.getTinhTrang()});
        }

        this.jTableLop.setModel(dtm);
        this.jTableLop.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        //SwingUtilities.updateComponentTreeUI(this);
        this.jTableLop.repaint();
        this.jTableLop.revalidate();
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
        jTableLop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenLop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        cboKhoi = new javax.swing.JComboBox<>();
        btnXem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        lblTenTaiKhoan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý lớp");

        jTableLop.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLop);

        jLabel1.setText("Tên lớp:");

        jLabel2.setText("Khối:");

        jLabel3.setText("Tình trạng:");

        txtTinhTrang.setEditable(false);
        txtTinhTrang.setText("1");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        cboKhoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        btnXem.setText("Xem danh sách lớp");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã lớp:");

        txtMaLop.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem)
                                    .addComponent(jLabel1))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboKhoi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnQuayLai)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addGap(3, 3, 3)
                .addComponent(btnXem)
                .addContainerGap())
        );

        lblTenTaiKhoan.setText("Tên tài khoản");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quản lý lớp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTenTaiKhoan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (!this.txtTenLop.getText().equals("")) {
            String tenLop = this.txtTenLop.getText();
            Byte tinhTrang = Byte.parseByte("1");
            Integer Khoi = 0;

            LopDAL lopDAL = new LopDAL();
            if (lopDAL.getByTen(tenLop) == null) {
                if (cboKhoi.getSelectedIndex() != -1) {
                    Khoi = Integer.parseInt(cboKhoi.getSelectedItem().toString());
                }

                Lop a = new Lop();
                a.setTenLop(tenLop);
                a.setKhoi(Khoi);
                a.setTinhTrang(tinhTrang);

                if (new LopDAL().add(a) != -1) {
                    JOptionPane.showMessageDialog(null, "Thêm lớp thành công");
                    LoadData();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm lớp thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tên lớp đã tồn tại");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nhập tên lớp");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        ShowListClassJFrame f = new ShowListClassJFrame(nd);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnXemActionPerformed

    private void jTableLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLopMouseClicked

        String tenLop = this.jTableLop.getValueAt(this.jTableLop.getSelectedRow(), 1).toString();
        //Lop a = this.lopDao.getByTen2(tenLop);
        Lop a = new LopDAL().getByTen(tenLop);

        int indexCbo = 0;
        if (a.getKhoi() == 10) {
            indexCbo = 0;
        }
        if (a.getKhoi() == 11) {
            indexCbo = 1;
        }
        if (a.getKhoi() == 12) {
            indexCbo = 2;
        }

        this.txtMaLop.setText(a.getIdLop().toString());
        this.txtTenLop.setText(a.getTenLop());
        this.cboKhoi.setSelectedIndex(indexCbo);
        this.txtTinhTrang.setText(a.getTinhTrang().toString());
    }//GEN-LAST:event_jTableLopMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        String tenLop = this.jTableLop.getValueAt(this.jTableLop.getSelectedRow(), 1).toString();
        int idLop = Integer.parseInt(this.jTableLop.getValueAt(this.jTableLop.getSelectedRow(), 0).toString());
        int cf = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa lớp " + tenLop + " không?", "Xác nhận", JOptionPane.YES_OPTION);

        if (cf == JOptionPane.YES_OPTION) {
            //if (this.lopDao.delete(lopDao.find(idLop))) {
            if (new LopDAL().delete(idLop)) {
                JOptionPane.showMessageDialog(null, "Xóa lớp thành công");
                LoadData();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa lớp thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        if (!this.txtTenLop.getText().equals("")) {
            int id = Integer.parseInt(this.txtMaLop.getText());
            String tenLop = this.txtTenLop.getText();
            Byte tinhTrang = Byte.parseByte(this.txtTinhTrang.getText());
            int Khoi = 0;

            LopDAL lopDALmoi = new LopDAL();
            Lop LopMoi = lopDALmoi.getByTen(tenLop);

            if (LopMoi == null || LopMoi.getIdLop() == id) {
                if (cboKhoi.getSelectedIndex() != -1) {
                    Khoi = Integer.parseInt(cboKhoi.getSelectedItem().toString());
                }

                Lop a = new Lop();
                a.setIdLop(id);
                a.setTenLop(tenLop);
                a.setKhoi(Khoi);
                a.setTinhTrang(tinhTrang);

                if (new LopDAL().update(a)) {
                    JOptionPane.showMessageDialog(null, "Cập nhật lớp thành công");
                    LoadData();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật lớp thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tên lớp đã tồn tại");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nhập tên lớp");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed

        ManageMainJFrame f = new ManageMainJFrame(nd);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(ManageClassJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageClassJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageClassJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageClassJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ManageClassJFrame().setVisible(true);
                ManageClassJFrame f = new ManageClassJFrame();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboKhoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLop;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
