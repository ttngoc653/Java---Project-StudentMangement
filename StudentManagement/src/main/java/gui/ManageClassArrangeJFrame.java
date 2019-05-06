package gui;

import static bll.HocsinhLopHocBLL.*;
import dal.*;
import dto.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuhuy
 */
public class ManageClassArrangeJFrame extends javax.swing.JFrame {

    int SiSoToiDa = 2;

    /**
     * Creates new form ArrangeClassJFrame
     */
    public ManageClassArrangeJFrame() {
        initComponents();
        LoadCbo();
        LoadData();
    }

    dto.Nguoidung nd;

    public ManageClassArrangeJFrame(Nguoidung nguoidung) {
        initComponents();
        nd = nguoidung;
        lblTenTaiKhoan.setText(nd.getHoTen());
        LoadCbo();
        LoadData();
    }

    private void LoadData() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("MSHS");
        dtm.addColumn("Tên lớp");
        dtm.addColumn("Năm học");

        List<HocsinhLophoc> l = new HocsinhLophocDAL().getAll();
        for (HocsinhLophoc a : l) {
            dtm.addRow(new Object[]{a.getIdHocSinhLopHoc(), a.getHocsinh().getIdHocSinh(), new LopDAL().getById(a.getLop().getIdLop()).getTenLop(), new NamhocDAL().getById(a.getNamhoc().getIdNamHoc()).getTenNamHoc()});
        }

        this.jTableXepLop.setModel(dtm);
        this.jTableXepLop.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void LoadCbo() {
        for (Hocsinh a : new HocsinhDAL().getAll()) {
            cboMSHS.addItem(a.getIdHocSinh().toString());
        }

        for (Lop a : new LopDAL().getAll()) {
            cboTenLop.addItem(a.getTenLop());
        }

        for (Namhoc a : new NamhocDAL().getAll()) {
            cboNamHoc.addItem(a.getTenNamHoc());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboNamHoc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboTenLop = new javax.swing.JComboBox<>();
        cboMSHS = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableXepLop = new javax.swing.JTable();
        lblTenTaiKhoan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý xếp lớp");

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setText("MSHS:");

        jLabel3.setText("Năm học:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");

        jButton3.setText("Sửa");

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên lớp:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboNamHoc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTenLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMSHS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuayLai))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(60, 60, 60)
                                .addComponent(txtID)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMSHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(jButton3)
                    .addComponent(btnQuayLai)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTableXepLop.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableXepLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableXepLopMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableXepLop);

        lblTenTaiKhoan.setText("Tên tài khoản");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed

        ManageStudentJFrame f = new ManageStudentJFrame(nd);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screenSize.width, 700);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void jTableXepLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableXepLopMouseClicked

        String stt = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 0).toString();
        String idHS = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 1).toString();
        String idLop = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 2).toString();
        String idNamHoc = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 3).toString();

        this.txtID.setText(stt);
        this.cboMSHS.setSelectedItem(idHS);
        this.cboTenLop.setSelectedItem(idLop);
        this.cboNamHoc.setSelectedItem(idNamHoc);
    }//GEN-LAST:event_jTableXepLopMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        int idHS = Integer.parseInt(this.cboMSHS.getSelectedItem().toString());

        String tenLop = this.cboTenLop.getSelectedItem().toString();
        Lop lop = new LopDAL().getByTen(tenLop);
        int idLop = lop.getIdLop();

        String tenNamHoc = this.cboNamHoc.getSelectedItem().toString();
        Namhoc namhoc = new NamhocDAL().getByTen(tenNamHoc);
        int idNamHoc = namhoc.getIdNamHoc();

        if (checkStudentArrangedClass(idHS)) {
            //Lop lop = new LopDAL().getById(idLop);
            //Namhoc namhoc = new NamhocDAL().getById(idNamHoc);
//            int Size = new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size();
            int Size = new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size();

            if (Size == SiSoToiDa) {
                JOptionPane.showMessageDialog(null, "si so: " + Size + "đủ sỉ số");
            } else {
                HocsinhLophocDAL hslophocDAL = new HocsinhLophocDAL();

                HocsinhLophocId a = new HocsinhLophocId();
                a.setIdHocSinh(idHS);
                a.setIdLopHoc(idLop);
                a.setIdNamHoc(idNamHoc);

                if (hslophocDAL.add(a) != null) {
                    JOptionPane.showMessageDialog(null, "Xếp lớp cho học sinh thành công");
                    LoadData();
                    LoadCbo();
                } else {
                    JOptionPane.showMessageDialog(null, "Xếp lớp cho học sinh thất bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "MSHS này đã có lớp rồi");
        }
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageClassArrangeJFrame f = new ManageClassArrangeJFrame();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboMSHS;
    private javax.swing.JComboBox<String> cboNamHoc;
    private javax.swing.JComboBox<String> cboTenLop;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableXepLop;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
