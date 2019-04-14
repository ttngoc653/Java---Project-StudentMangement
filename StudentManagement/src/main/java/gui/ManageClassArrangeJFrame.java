package gui;

import dal.*;
import dto.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuhuy
 */
public class ManageClassArrangeJFrame extends javax.swing.JFrame {

    /*
    HocsinhLophocDAL hslopDao = null;
    HocsinhDAL hsDao = new HocsinhDAL();
    LopDAL lopDao = new LopDAL();
    NamhocDAL namhocDao = new NamhocDAL();
     */
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
        dtm.addColumn("STT");
        dtm.addColumn("MSHS");
        dtm.addColumn("Mã lớp");
        //dtm.addColumn("Tên lớp");
        dtm.addColumn("Mã năm học");
        //int Size = this.hslopDao.getAll().size();
        int i = 1;

        for (HocsinhLophoc a : new HocsinhLophocDAL().getAll()) {
            dtm.addRow(new Object[]{i, a.getHocsinh().getIdHocSinh(), a.getLop().getIdLop(), a.getNamhoc().getIdNamHoc()});
            //dtm.addRow(new Object[]{i, a.getHocsinh().getIdHocSinh(), a.getLop().getTenLop(), a.getNamhoc().getIdNamHoc()});
            i++;
        }

        this.jTableXepLop.setModel(dtm);
        this.jTableXepLop.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void LoadCbo() {
        for (Hocsinh a : new HocsinhDAL().getAll()) {
            cboMSHS.addItem(a.getIdHocSinh().toString());
        }
        for (Lop a : new LopDAL().getAll()) {
            cboMaLop.addItem(a.getIdLop().toString());
        }
//        for (Lop a : new LopDAL().getAll()) {
//            cboMaLop.addItem(a.getTenLop());
//        }
        for (Namhoc a : new NamhocDAL().getAll()) {
            cboMaNamHoc.addItem(a.getIdNamHoc().toString());
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
        txtSTT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboMaNamHoc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboMaLop = new javax.swing.JComboBox<>();
        cboMSHS = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableXepLop = new javax.swing.JTable();
        lblTenTaiKhoan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý xếp lớp");

        jLabel1.setText("STT:");

        txtSTT.setEditable(false);

        jLabel2.setText("MSHS:");

        jLabel3.setText("Mã năm học:");

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

        jLabel4.setText("Mã lớp:");

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
                            .addComponent(cboMaNamHoc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMaLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMSHS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuayLai)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(txtSTT)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMSHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        f.setSize(screenSize.width, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void jTableXepLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableXepLopMouseClicked

        String stt = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 0).toString();
//        int idHS = Integer.parseInt(this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 1).toString());
//        int idLop = Integer.parseInt(this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 2).toString());
//        int idNamHoc = Integer.parseInt(this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 3).toString());

        String idHS = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 1).toString();
        String idLop = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 2).toString();
        String idNamHoc = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 3).toString();

        //Lop a = this.lopDao.getByTen2(tenLop);
        //HocsinhLophoc a = new HocsinhLophocDAL().getByIdHocsinh(idHS);
        this.txtSTT.setText(stt);
        //this.cboMSHS.setSelectedItem(a.getHocsinh().getIdHocSinh().toString());
        this.cboMSHS.setSelectedItem(idHS);
        this.cboMaLop.setSelectedItem(idLop);
        this.cboMaNamHoc.setSelectedItem(idNamHoc);
    }//GEN-LAST:event_jTableXepLopMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int maHS = Integer.parseInt(this.cboMSHS.getSelectedItem().toString());
        String maLop = this.cboMaLop.getSelectedItem().toString();
        String maNamHoc = this.cboMaNamHoc.getSelectedItem().toString();

        HocsinhLophocDAL hslopDAL = new HocsinhLophocDAL();
        if (hslopDAL.getByIdHocsinh(maHS) == null) {
            JOptionPane.showMessageDialog(null, "yes");
        }else{
            JOptionPane.showMessageDialog(null, "no");
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
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageClassArrangeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> cboMaLop;
    private javax.swing.JComboBox<String> cboMaNamHoc;
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
    private javax.swing.JTextField txtSTT;
    // End of variables declaration//GEN-END:variables
}
