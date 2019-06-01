package gui;

import static bll.ConfigBLL.getMaxStudent;
import static bll.HocsinhBLL.dateFormat;
import static bll.HocsinhLopHocBLL.*;
import dal.*;
import dto.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuhuy
 */
public class ManageClassArrangeJFrame extends javax.swing.JFrame {
    
    public static Boolean openFrame = true;

    //int SiSoToiDa = 2;
    /**
     * Creates new form ArrangeClassJFrame
     */
    public ManageClassArrangeJFrame() {
        initComponents();
        
        java.awt.Dimension dim =java.awt. Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        LoadCbo();
        LoadData();
    }
    
    dto.Nguoidung nd;
    
    public ManageClassArrangeJFrame(Nguoidung nguoidung) {
        initComponents();
        
        java.awt.Dimension dim =java.awt. Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        nd = nguoidung;
        lblTenTaiKhoan.setText(nd.getHoTen());
        LoadCbo();
        LoadData();
    }
    
    private void LoadData() {
        DefaultTableModel dtm = new DefaultTableModel() {
            //Chặn edit các ô trong JTable
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        dtm.addColumn("ID");
        dtm.addColumn("MSHS");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Tên lớp");
        dtm.addColumn("Năm học");
        
        List<HocsinhLophoc> l = new HocsinhLophocDAL().getAll();
        for (HocsinhLophoc a : l) {
            dtm.addRow(new Object[]{a.getIdHocSinhLopHoc(), a.getHocsinh().getIdHocSinh(), a.getHocsinh().getHoTen(), new LopDAL().getById(a.getLop().getIdLop()).getTenLop(), new NamhocDAL().getById(a.getNamhoc().getIdNamHoc()).getTenNamHoc()});
        }
        
        this.jTableXepLop.setModel(dtm);
        this.jTableXepLop.getColumnModel().getColumn(0).setPreferredWidth(10);  //ID
        this.jTableXepLop.getColumnModel().getColumn(1).setPreferredWidth(10);   //MSHS
        this.jTableXepLop.getColumnModel().getColumn(2).setPreferredWidth(100); //Họ tên
        this.jTableXepLop.getColumnModel().getColumn(3).setPreferredWidth(50); //Tên lớp
        this.jTableXepLop.getColumnModel().getColumn(4).setPreferredWidth(50); //Năm học

        this.jTableXepLop.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    private void LoadCbo() {
        for (Hocsinh a : new HocsinhDAL().getAll()) {
            cboMSHS.addItem(a.getIdHocSinh().toString() + " - " + a.getHoTen());
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
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboTenLop = new javax.swing.JComboBox<>();
        cboMSHS = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableXepLop = new javax.swing.JTable();
        lblTenTaiKhoan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý xếp lớp");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboNamHoc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTenLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMSHS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addContainerGap(106, Short.MAX_VALUE))
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
        )
    );
    jTableXepLop.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTableXepLopMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTableXepLop);

    lblTenTaiKhoan.setText("Tên tài khoản");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("Quản lý xếp lớp");

    btnQuayLai.setText("Quay lại");
    btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnQuayLaiActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(btnQuayLai)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenTaiKhoan)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTenTaiKhoan)
                .addComponent(btnQuayLai))
            .addGap(3, 3, 3)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableXepLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableXepLopMouseClicked
        
        String idHocSinhLopHoc = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 0).toString();
        String idHS = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 1).toString();
        String hoTenHS = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 2).toString();
        String idLop = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 3).toString();
        String idNamHoc = this.jTableXepLop.getValueAt(this.jTableXepLop.getSelectedRow(), 4).toString();
        
        this.txtID.setText(idHocSinhLopHoc);
        //this.cboMSHS.setSelectedItem(idHS);
        this.cboMSHS.setSelectedItem(idHS + " - " + hoTenHS);
        this.cboTenLop.setSelectedItem(idLop);
        this.cboNamHoc.setSelectedItem(idNamHoc);
    }//GEN-LAST:event_jTableXepLopMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        String ThongTinHocSinh = this.cboMSHS.getSelectedItem().toString();                   // MSHS - Họ tên học sinh 
        String[] thongTinHs = ThongTinHocSinh.split(" - "); //Cắt tách chuỗi theo kí tự " - " // => [0] - [1]
        int idHS = Integer.parseInt(thongTinHs[0]);
        Hocsinh hocsinh = new HocsinhDAL().getById(idHS);
        
        String tenLop = this.cboTenLop.getSelectedItem().toString();
        Lop lop = new LopDAL().getByTen(tenLop);
        int idLop = lop.getIdLop();

//        int SiSoToiDa = Integer.parseInt(new CauHinhDAL().getByName("SiSoToiDa").getGiaTri());
        int SiSoToiDa = getMaxStudent(lop);
        //JOptionPane.showMessageDialog(null, SiSoToiDa);

        String tenNamHoc = this.cboNamHoc.getSelectedItem().toString();
        Namhoc namhoc = new NamhocDAL().getByTen(tenNamHoc);
        int idNamHoc = namhoc.getIdNamHoc();
        
        HocsinhLophoc a = new HocsinhLophoc();
        a.setHocsinh(hocsinh);
        a.setLop(lop);
        a.setNamhoc(namhoc);
        
        Integer namsinh = Integer.parseInt(hocsinh.getNgaySinh().substring(6)), maxAge = bll.ConfigBLL.getMaxAgeStudent(lop), minAge = bll.ConfigBLL.getMinAgeStudent(lop);
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        String year1 = dateFormat.format(date).substring(6);
        int year = Integer.parseInt(year1);
        int tuoi = year - namsinh;
        
        if (findStudentByNamHocLop(idHS, namhoc, lop)) {
            JOptionPane.showMessageDialog(null, "MSHS " + idHS + " đã thuộc lớp " + tenLop + " - năm học " + tenNamHoc);
        } else if (bll.HocsinhLopHocBLL.checkMaximumStudentInClass(idNamHoc, idLop, SiSoToiDa)) {
            JOptionPane.showMessageDialog(null, "Lớp này đã đủ sỉ số: " + SiSoToiDa + " học sinh");
        } else if (findStudentByNamHoc(idHS, namhoc)) {
            JOptionPane.showMessageDialog(null, "Trong 1 năm học sinh chỉ được học 1 lớp duy nhất");
        } else if (minAge >= tuoi || tuoi >= maxAge) {
            JOptionPane.showMessageDialog(null, "Đã quá giới hạn tuối cho phép để vào lớp.\n"
                    + "Tuổi hiện tại của học sinh " + hocsinh.getIdHocSinh() + " - " + hocsinh.getHoTen() + " là " + tuoi + "\n"
                    + "Giới hạn tuối của lớp " + lop.getTenLop() + " từ " + minAge + " đến " + maxAge + " tuối.");
        } else {
            if (new HocsinhLophocDAL().add(a) != null) {
                JOptionPane.showMessageDialog(null, "Xếp lớp cho học sinh thành công");
                LoadData();
            } else {
                JOptionPane.showMessageDialog(null, "Xếp lớp cho học sinh thất bại");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn dòng thông tin bạn muốn xóa");
        } else {
            int idHocSinhLopHoc = Integer.parseInt(txtID.getText());
            if (new HocsinhLophocDAL().delete(idHocSinhLopHoc)) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                LoadData();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        
        if (ManageStudentJFrame.openFrame == true) {
            ManageStudentJFrame.openFrame = false;
            ManageStudentJFrame f = new ManageStudentJFrame(nd);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            f.setSize(screenSize.width, 700);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setResizable(false);
            this.setVisible(false);
            this.openFrame = true;
        } else {
            //JOptionPane.showMessageDialog(null, "Màn hình quản lý lớp đã mở rồi");
            this.setVisible(false);
            this.openFrame = true;
        }
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        openFrame = true;
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboMSHS;
    private javax.swing.JComboBox<String> cboNamHoc;
    private javax.swing.JComboBox<String> cboTenLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableXepLop;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
