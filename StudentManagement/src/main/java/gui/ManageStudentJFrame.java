/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.HocsinhDAL;
import dto.Hocsinh;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuhuy
 */
public class ManageStudentJFrame extends javax.swing.JFrame {

    HocsinhDAL hsDao = new HocsinhDAL();

    /**
     * Creates new form ManageHSJFrame
     */
    public ManageStudentJFrame() {
        //setUndecorated(true); //Bỏ khung viền tiêu đề frame (bỏ 3 nút trên cùng bên phải)
        initComponents();
        LoadData();
    }

    public void LoadData() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("MSHS");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Email");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("SĐT cá nhân");
        dtm.addColumn("SĐT giám hộ");
        dtm.addColumn("Tình trạng");

        for (Hocsinh hs : this.hsDao.getAll()) {
            dtm.addRow(new Object[]{hs.getIdHocSinh(), hs.getHoTen(), hs.getNgaySinh(), hs.getEmail(),
                hs.getGioiTinh(), hs.getDiaChi(), hs.getSdtCaNhan(), hs.getSdtGiamHo(),
                hs.getTinhTrang()});
        }

        this.jTableHocSinh.setModel(dtm);

        this.jTableHocSinh.getColumnModel().getColumn(0).setPreferredWidth(10);  //MSHS
        this.jTableHocSinh.getColumnModel().getColumn(1).setPreferredWidth(150); //Họ tên
        this.jTableHocSinh.getColumnModel().getColumn(2).setPreferredWidth(120); //Ngày sinh
        this.jTableHocSinh.getColumnModel().getColumn(3).setPreferredWidth(200); //Email
        this.jTableHocSinh.getColumnModel().getColumn(4).setPreferredWidth(20);  //Giới tính
        this.jTableHocSinh.getColumnModel().getColumn(5).setPreferredWidth(200); //Địa chỉ
        this.jTableHocSinh.getColumnModel().getColumn(6).setPreferredWidth(100); //SĐT cá nhân
        this.jTableHocSinh.getColumnModel().getColumn(7).setPreferredWidth(100); //SĐT giám hộ
        this.jTableHocSinh.getColumnModel().getColumn(8).setPreferredWidth(100); //Tình trạng

        this.jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHocSinh = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        rbNu = new javax.swing.JRadioButton();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSdtCaNhan = new javax.swing.JTextField();
        txtSdtGiamHo = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        rbNam = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        buttonGroup2.add(rbNam);
        buttonGroup2.add(rbNu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableHocSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MSHS", "Họ tên", "Ngày sinh", "Email", "Giới tính", "Địa chỉ", "SĐT cá nhân", "SĐT giám hộ", "Tình trạng"
            }
        ));
        jTableHocSinh.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableHocSinh.setFillsViewportHeight(true);
        jTableHocSinh.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableHocSinh);

        jLabel7.setText("SĐT cá nhân:");

        jButton3.setText("Sửa");

        jLabel3.setText("Ngày sinh:");

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        rbNu.setText("Nữ");

        txtNgaySinh.setText("09/09/2019");

        jLabel8.setText("SĐT giám hộ:");

        jLabel4.setText("Email:");

        jLabel5.setText("Giới tính:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setText("227 nguyen van cu phuong 6 quan 5");
        jScrollPane2.setViewportView(txtDiaChi);

        jLabel2.setText("Họ tên:");

        jLabel6.setText("Địa chỉ:");

        txtHoTen.setText("a");

        txtEmail.setText("a");

        txtSdtCaNhan.setText("0909256880");

        txtSdtGiamHo.setText("0909256880");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jButton2.setText("Xóa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbNam)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbNu))
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSdtCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSdtGiamHo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(86, 86, 86))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnQuayLai)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdtCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNam)
                        .addComponent(rbNu)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)
                        .addComponent(txtSdtGiamHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnQuayLai))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
//        // TODO add your handling code here:
//        ManageMainJFrame f = new ManageMainJFrame();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        f.setResizable(false);
//        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Hocsinh hs = new Hocsinh();

        String gioiTinh = "";
        if (rbNam.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nu";
        }
        
        hs.setHoTen(this.txtHoTen.getText());
        hs.setNgaySinh(this.txtNgaySinh.getText());
        hs.setEmail(this.txtEmail.getText());
        hs.setGioiTinh(gioiTinh);
        hs.setDiaChi(this.txtDiaChi.getText());
        hs.setSdtCaNhan(this.txtSdtCaNhan.getText());
        hs.setSdtGiamHo(this.txtSdtGiamHo.getText());
        hs.setTinhTrang(Byte.parseByte("1"));

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String dateInString = this.txtNgaySinh.getText();
//
//        try {
//
//            Date date = formatter.parse(dateInString);
//            //System.out.println(date);
//            //System.out.println(formatter.format(date));
//            hs.setNgaySinh(date);
//        } catch (ParseException e) {
//            //e.printStackTrace();
//            System.out.println("Loi Ngay Sinh: ");
//        }

        //if(hsDao.SaveOrUpdate(hs)){
        if (hsDao.add(hs) != -1) {
            JOptionPane.showMessageDialog(null, "Thêm học sinh thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm học sinh thất bại");
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
            java.util.logging.Logger.getLogger(ManageStudentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageStudentJFrame f = new ManageStudentJFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                f.setSize(screenSize.width, 500);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setResizable(false);

                //Show frame maximun size
//                Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
//                f.setMaximumSize(DimMax);
//                f.setExtendedState(JFrame.MAXIMIZED_BOTH);

                /*
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                //f.setSize(screenSize.width, screenSize.height);
                f.setSize(screenSize.width, 450);
                f.setLocationRelativeTo(null);
                 */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHocSinh;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdtCaNhan;
    private javax.swing.JTextField txtSdtGiamHo;
    // End of variables declaration//GEN-END:variables
}
