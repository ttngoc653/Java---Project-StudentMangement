package gui;

import static bll.HocsinhBLL.*;
import dal.*;
import dto.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author tuhuy
 */
public class ManageStudentJFrame extends javax.swing.JFrame {

    HocsinhDAL hsDao = new HocsinhDAL();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    int TuoiToiDa = 20, TuoiToiThieu = 15;

    /**
     * Creates new form ManageHSJFrame
     */
    public ManageStudentJFrame() {
        //setUndecorated(true); //Bỏ khung viền tiêu đề frame (bỏ 3 nút trên cùng bên phải)
        initComponents();
        LoadData();
    }

    dto.Nguoidung nd;

    public ManageStudentJFrame(Nguoidung nguoidung) {
        initComponents();
        nd = nguoidung;
        lblTenTaiKhoan.setText(nd.getHoTen());

        /*
        //Customize Code cho jDateChooserNgaySinh để đặt ngày hiển thị mặc định
        long millis = System.currentTimeMillis();
        Date NgayHienTai = new Date(millis);
        //String Nam = dateFormat.format(NgayHienTai).substring(6);
        jDateChooserNgaySinh.setDate(NgayHienTai);
         */
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

        for (Hocsinh hs : new HocsinhDAL().getAll()) {
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
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jDateComponentFactory1 = new org.jdatepicker.JDateComponentFactory();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHocSinh = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
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
        rbNam = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMSHS = new javax.swing.JTextField();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnXepLop = new javax.swing.JButton();
        lblTenTaiKhoan = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

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
        jTableHocSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHocSinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHocSinh);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin học sinh"));

        jLabel7.setText("SĐT cá nhân:");

        jLabel3.setText("Ngày sinh (*):");

        rbNu.setText("Nữ");

        jLabel8.setText("SĐT giám hộ:");

        jLabel4.setText("Email:");

        jLabel5.setText("Giới tính (*):");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jLabel2.setText("Họ tên (*):");

        jLabel6.setText("Địa chỉ (*):");

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel9.setText("Tình trạng:");

        txtTinhTrang.setEditable(false);
        txtTinhTrang.setText("1");

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Định dạng dd-MM-yyyy");

        jLabel11.setText("MSHS:");

        txtMSHS.setEditable(false);

        jDateChooserNgaySinh.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMSHS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSdtCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(24, 24, 24)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(21, 21, 21)
                                        .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSdtGiamHo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(rbNam)
                                .addGap(24, 24, 24)
                                .addComponent(rbNu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(txtMSHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSdtCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdtGiamHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNam)
                        .addComponent(rbNu)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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

        btnXepLop.setText("Xếp lớp");
        btnXepLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXepLopActionPerformed(evt);
            }
        });

        lblTenTaiKhoan.setText("Tên tài khoản");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm kiếm:");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTenTaiKhoan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuayLai)
                                .addGap(18, 18, 18)
                                .addComponent(btnXepLop)
                                .addGap(8, 8, 8)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXepLop)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(btnTim))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTenTaiKhoan)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuayLai))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed

        ManageMainJFrame f = new ManageMainJFrame(nd);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Date newDate = jDateChooserNgaySinh.getDate();
        int kqNgaySinh = 0;
        if (checkDateOfBirth(newDate)) {
            kqNgaySinh = 1;
        } else {
            kqNgaySinh = 0;
        }

        if (!this.txtHoTen.getText().equals("") && !this.txtDiaChi.getText().equals("") && kqNgaySinh == 1) {
            Hocsinh hs = new Hocsinh();
            String hoTen = this.txtHoTen.getText();
            String ngaySinh = dateFormat.format(newDate);
            String email = this.txtEmail.getText();
            String gioiTinh = "";
            if (rbNam.isSelected()) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            String diaChi = this.txtDiaChi.getText();
            String sdtCaNhan = this.txtSdtCaNhan.getText();
            String sdtGiamHo = this.txtSdtGiamHo.getText();
            Byte tinhTrang = Byte.parseByte("1");

            if (checkAge(ngaySinh, TuoiToiDa, TuoiToiThieu) == true) {
                hs.setHoTen(hoTen);
                hs.setNgaySinh(ngaySinh);
                hs.setEmail(email);
                hs.setGioiTinh(gioiTinh);
                hs.setDiaChi(diaChi);
                hs.setSdtCaNhan(sdtCaNhan);
                hs.setSdtGiamHo(sdtGiamHo);
                hs.setTinhTrang(tinhTrang);

                if (checkEmail(email)) {
                    if (checkPhoneNumber(sdtCaNhan) && checkPhoneNumber(sdtGiamHo)) {
                        if (checkStudentExists(hoTen, diaChi, ngaySinh)) {
                            if (new HocsinhDAL().add(hs) != -1) {
                                JOptionPane.showMessageDialog(null, "Thêm học sinh thành công");
                                LoadData();
                            } else {
                                JOptionPane.showMessageDialog(null, "Thêm học sinh thất bại");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Học sinh đã tồn tại");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Tuổi từ " + TuoiToiThieu + " đến " + TuoiToiDa);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Điền thông tin cho các ô có (*) và ngày sinh phải hợp lệ");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXepLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXepLopActionPerformed

        ManageClassArrangeJFrame f = new ManageClassArrangeJFrame(nd);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnXepLopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //String kq = checkPhoneNumber(txtSdtCaNhan.getText());
        //JOptionPane.showMessageDialog(null, kq);     
        //String kq2 = checkEmail(txtEmail.getText());
        //JOptionPane.showMessageDialog(null, kq2);
//        long millis = System.currentTimeMillis();
//        Date date = new java.sql.Date(millis);
//        String year1 = dateFormat.format(date).substring(6);
//        int year = Integer.parseInt(year1);
//        //JOptionPane.showMessageDialog(null, year);    
//
//        Date newDate = jDateChooserNgaySinh.getDate();
//        String NamSinh1 = dateFormat.format(newDate).substring(6);
//        //JOptionPane.showMessageDialog(null, NamSinh1);        
//        int NamSinh = 0;
//        try {
//            NamSinh = Integer.parseInt(NamSinh1);
//        } catch (NumberFormatException e) {
//            System.out.println("ERROR: NamSinh");
//        }
//        
//        int tuoi = year - NamSinh;
//        int tuoiToiThieu = 15, tuoiToiDa = 20;
//        if (tuoi < tuoiToiThieu || tuoi > tuoiToiDa) {
//            JOptionPane.showMessageDialog(null, "Tuoi: " + year + "-" + NamSinh + "=" + tuoi + "khong hop le");
//        } else {
//            JOptionPane.showMessageDialog(null, "Tuoi hop le");
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableHocSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHocSinhMouseClicked

        String tenHS = this.jTableHocSinh.getValueAt(this.jTableHocSinh.getSelectedRow(), 1).toString();
        Hocsinh a = new HocsinhDAL().getByName(tenHS);

        this.txtMSHS.setText(a.getIdHocSinh().toString());
        this.txtHoTen.setText(a.getHoTen());
        Date ngaySinh = setDatejDateChooser(a.getNgaySinh());
        this.jDateChooserNgaySinh.setDate(ngaySinh);
        this.txtEmail.setText(a.getEmail());

        if (a.getGioiTinh().equals("Nam")) {
            this.rbNam.setSelected(true);
        } else {
            this.rbNu.setSelected(true);
        }

        this.txtDiaChi.setText(a.getDiaChi());
        this.txtSdtCaNhan.setText(a.getSdtCaNhan());
        this.txtSdtGiamHo.setText(a.getSdtGiamHo());

        Byte bytes = a.getTinhTrang();
        String str = bytes.toString();
        this.txtTinhTrang.setText(str);
    }//GEN-LAST:event_jTableHocSinhMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        String tenLop = this.jTableHocSinh.getValueAt(this.jTableHocSinh.getSelectedRow(), 1).toString();
        int idHS = Integer.parseInt(this.jTableHocSinh.getValueAt(this.jTableHocSinh.getSelectedRow(), 0).toString());
        int cf = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa học sinh " + tenLop + " không?", "Xác nhận", JOptionPane.YES_OPTION);

        if (cf == JOptionPane.YES_OPTION) {
            if (new HocsinhDAL().delete(idHS)) {
                JOptionPane.showMessageDialog(null, "Xóa học sinh thành công");
                LoadData();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa học sinh thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        Date newDate = jDateChooserNgaySinh.getDate();
        int kqNgaySinh = 0;
        if (checkDateOfBirth(newDate)) {
            kqNgaySinh = 1;
        } else {
            kqNgaySinh = 0;
        }

        if (!this.txtHoTen.getText().equals("") && !this.txtDiaChi.getText().equals("") && kqNgaySinh == 1) {
            Hocsinh hs = new Hocsinh();
            int maHS = Integer.parseInt(this.txtMSHS.getText());
            String hoTen = this.txtHoTen.getText();
            String ngaySinh = dateFormat.format(newDate);
            String email = this.txtEmail.getText();
            String gioiTinh = "";
            if (rbNam.isSelected()) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            String diaChi = this.txtDiaChi.getText();
            String sdtCaNhan = this.txtSdtCaNhan.getText();
            String sdtGiamHo = this.txtSdtGiamHo.getText();
            Byte tinhTrang = Byte.parseByte("1");

            if (checkAge(ngaySinh, TuoiToiDa, TuoiToiThieu) == true) {
                hs.setHoTen(hoTen);
                hs.setNgaySinh(ngaySinh);
                hs.setEmail(email);
                hs.setGioiTinh(gioiTinh);
                hs.setDiaChi(diaChi);
                hs.setSdtCaNhan(sdtCaNhan);
                hs.setSdtGiamHo(sdtGiamHo);
                hs.setTinhTrang(tinhTrang);

                if (checkEmail(email)) {
                    if (checkPhoneNumber(sdtCaNhan) && checkPhoneNumber(sdtGiamHo)) {
                        if (checkInfoUpdateStudent(maHS, hoTen, diaChi, ngaySinh)) {
                            if (new HocsinhDAL().update(hs)) {
                                JOptionPane.showMessageDialog(null, "Cập nhật thông tin học sinh thành công");
                                LoadData();
                            } else {
                                JOptionPane.showMessageDialog(null, "Cập nhật thông tin học sinh thất bại");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Thông tin học sinh này trùng với học sinh khác");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Tuổi từ " + TuoiToiThieu + " đến " + TuoiToiDa);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Điền thông tin cho các ô có (*) và ngày sinh phải hợp lệ");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String key = this.txtTim.getText();
    }//GEN-LAST:event_btnTimActionPerformed

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
                f.setSize(screenSize.width, 700);
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
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXepLop;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private org.jdatepicker.JDateComponentFactory jDateComponentFactory1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHocSinh;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMSHS;
    private javax.swing.JTextField txtSdtCaNhan;
    private javax.swing.JTextField txtSdtGiamHo;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
