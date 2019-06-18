package gui;

import static bll.ConfigBLL.*;
import static bll.HocsinhBLL.*;
import dal.*;
import dto.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

/**
 *
 * @author tuhuy
 */
public class ManageStudentJFrame extends javax.swing.JFrame {

    public static Boolean openFrame = true;
    HocsinhDAL hsDao = new HocsinhDAL();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //int TuoiToiDa = 20, TuoiToiThieu = 15;
    DefaultTableModel dtm;

    /**
     * Creates new form ManageHSJFrame
     */
    public ManageStudentJFrame() {
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
        //DefaultTableModel dtm = new DefaultTableModel();
        dtm = new DefaultTableModel() {
            //Chặn edit các ô trong JTable
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        dtm.addColumn("MSHS");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Email");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("SĐT cá nhân");
        dtm.addColumn("SĐT giám hộ");

        for (Hocsinh hs : new HocsinhDAL().getAll()) {
            dtm.addRow(new Object[]{hs.getIdHocSinh(), hs.getHoTen(), hs.getNgaySinh(), hs.getEmail(),
                hs.getGioiTinh(), hs.getDiaChi(), hs.getSdtCaNhan(), hs.getSdtGiamHo()});
        }

        this.jTableHocSinh.setModel(dtm);

        this.jTableHocSinh.getColumnModel().getColumn(0).setPreferredWidth(50);  //MSHS
        this.jTableHocSinh.getColumnModel().getColumn(1).setPreferredWidth(200); //Họ tên
        this.jTableHocSinh.getColumnModel().getColumn(2).setPreferredWidth(80); //Ngày sinh
        this.jTableHocSinh.getColumnModel().getColumn(3).setPreferredWidth(200); //Email
        this.jTableHocSinh.getColumnModel().getColumn(4).setPreferredWidth(60);  //Giới tính
        this.jTableHocSinh.getColumnModel().getColumn(5).setPreferredWidth(500); //Địa chỉ
        this.jTableHocSinh.getColumnModel().getColumn(6).setPreferredWidth(90); //SĐT cá nhân
        this.jTableHocSinh.getColumnModel().getColumn(7).setPreferredWidth(90); //SĐT giám hộ

        //Canh phải cho cột
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        this.jTableHocSinh.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);//Canh phải cột MSHS

        this.jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        if (jTableHocSinh.getPreferredSize().width < jTableHocSinh.getParent().getWidth()) {
            jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblTenTaiKhoan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rbNam = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtMSHS = new javax.swing.JTextField();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        txtSdtCaNhan = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtSdtGiamHo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHocSinh = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXepLop = new javax.swing.JButton();
        btnXemDanhSach = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        buttonGroup2.add(rbNam);
        buttonGroup2.add(rbNu);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý học sinh");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblTenTaiKhoan.setText("Tên tài khoản");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý học sinh");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin học sinh"));

        jLabel30.setText("Ngày sinh (*):");

        rbNu.setText("Nữ");

        jLabel32.setText("Email:");

        jLabel33.setText("Giới tính (*):");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane5.setViewportView(txtDiaChi);

        jLabel34.setText("Họ tên (*):");

        jLabel35.setText("Địa chỉ (*):");

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel36.setForeground(new java.awt.Color(255, 51, 51));
        jLabel36.setText("Định dạng dd-MM-yyyy");

        jLabel37.setText("MSHS:");

        txtMSHS.setEditable(false);

        jDateChooserNgaySinh.setDateFormatString("dd-MM-yyyy");

        jLabel29.setText("SĐT cá nhân:");

        jLabel31.setText("SĐT giám hộ:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(txtSdtCaNhan)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(55, 55, 55)
                        .addComponent(txtEmail))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(24, 24, 24)
                        .addComponent(rbNam)
                        .addGap(12, 12, 12)
                        .addComponent(rbNu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen)
                            .addComponent(txtMSHS)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtSdtGiamHo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMSHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNam)
                    .addComponent(rbNu)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdtCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtSdtGiamHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTableHocSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MSHS", "Họ tên", "Ngày sinh", "Email", "Giới tính", "Địa chỉ", "SĐT cá nhân", "SĐT giám hộ"
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

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXepLop.setText("Xếp lớp");
        btnXepLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXepLopActionPerformed(evt);
            }
        });

        btnXemDanhSach.setText("Xem danh sách");
        btnXemDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDanhSachActionPerformed(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTenTaiKhoan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXemDanhSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXepLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btnXepLop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXemDanhSach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTim)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

//        int TuoiToiThieu = Integer.parseInt(new CauHinhDAL().getByName("TuoiToiThieu").getGiaTri());
//        int TuoiToiDa = Integer.parseInt(new CauHinhDAL().getByName("TuoiToiDa").getGiaTri());
        int TuoiToiThieu = getMinAgeStudent();
        int TuoiToiDa = getMaxAgeStudent();

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

        if (ManageClassArrangeJFrame.openFrame == true) {
            ManageClassArrangeJFrame.openFrame = false;
            ManageClassArrangeJFrame f = new ManageClassArrangeJFrame(nd);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setResizable(false);
            this.setVisible(false);
            this.openFrame = true;
        } else {
            this.setVisible(false);
            this.openFrame = true;
        }
    }//GEN-LAST:event_btnXepLopActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        if (txtMSHS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn học sinh bạn muốn xóa");
        } else {
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
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

//        int TuoiToiThieu = Integer.parseInt(new CauHinhDAL().getByName("TuoiToiThieu").getGiaTri());
//        int TuoiToiDa = Integer.parseInt(new CauHinhDAL().getByName("TuoiToiDa").getGiaTri());
        int TuoiToiThieu = getMinAgeStudent();
        int TuoiToiDa = getMaxAgeStudent();

        if (txtMSHS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn học sinh bạn muốn sửa");
        } else {
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
                    hs.setIdHocSinh(maHS);
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
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        String key = this.txtTim.getText();

        if (key.equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập thông tin cần tìm");
        } else {
            List<Hocsinh> lHs = new HocsinhDAL().Search(key);

            if (lHs.size() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy học sinh cần tìm");
            } else {
                dtm = new DefaultTableModel() {
                    //Chặn edit các ô trong JTable
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }
                };

                dtm.addColumn("MSHS");
                dtm.addColumn("Họ tên");
                dtm.addColumn("Ngày sinh");
                dtm.addColumn("Email");
                dtm.addColumn("Giới tính");
                dtm.addColumn("Địa chỉ");
                dtm.addColumn("SĐT cá nhân");
                dtm.addColumn("SĐT giám hộ");

                for (Hocsinh hs : lHs) {
                    dtm.addRow(new Object[]{hs.getIdHocSinh(), hs.getHoTen(), hs.getNgaySinh(), hs.getEmail(),
                        hs.getGioiTinh(), hs.getDiaChi(), hs.getSdtCaNhan(), hs.getSdtGiamHo()});
                }

                this.jTableHocSinh.setModel(dtm);

                this.jTableHocSinh.getColumnModel().getColumn(0).setPreferredWidth(50);  //MSHS
                this.jTableHocSinh.getColumnModel().getColumn(1).setPreferredWidth(200); //Họ tên
                this.jTableHocSinh.getColumnModel().getColumn(2).setPreferredWidth(80); //Ngày sinh
                this.jTableHocSinh.getColumnModel().getColumn(3).setPreferredWidth(200); //Email
                this.jTableHocSinh.getColumnModel().getColumn(4).setPreferredWidth(60);  //Giới tính
                this.jTableHocSinh.getColumnModel().getColumn(5).setPreferredWidth(500); //Địa chỉ
                this.jTableHocSinh.getColumnModel().getColumn(6).setPreferredWidth(90); //SĐT cá nhân
                this.jTableHocSinh.getColumnModel().getColumn(7).setPreferredWidth(90); //SĐT giám hộ

                //Canh phải cho cột
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
                this.jTableHocSinh.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);//Canh phải cột MSHS

                this.jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

                if (jTableHocSinh.getPreferredSize().width < jTableHocSinh.getParent().getWidth()) {
                    jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                } else {
                    jTableHocSinh.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                }
            }
        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        openFrame = true;
    }//GEN-LAST:event_formWindowClosed

    private void btnXemDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDanhSachActionPerformed

        LoadData();
    }//GEN-LAST:event_btnXemDanhSachActionPerformed

    private void jTableHocSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHocSinhMouseClicked

        int idHS = Integer.parseInt(this.jTableHocSinh.getValueAt(this.jTableHocSinh.getSelectedRow(), 0).toString());
        Hocsinh a = new HocsinhDAL().getById(idHS);

        this.txtMSHS.setText(a.getIdHocSinh().toString());
        this.txtHoTen.setText(a.getHoTen());
        Date ngaySinh = setDatejDateChooser(a.getNgaySinh());
        this.jDateChooserNgaySinh.setDate(ngaySinh);
        this.txtEmail.setText(a.getEmail());

        if (a.getGioiTinh().equals("Nam") || a.getGioiTinh().equals("nam")) {
            this.rbNam.setSelected(true);
        } else {
            this.rbNu.setSelected(true);
        }

        this.txtDiaChi.setText(a.getDiaChi());
        this.txtSdtCaNhan.setText(a.getSdtCaNhan());
        this.txtSdtGiamHo.setText(a.getSdtGiamHo());

        Byte bytes = a.getTinhTrang();
        String str = bytes.toString();
    }//GEN-LAST:event_jTableHocSinhMouseClicked

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
                //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                //f.setSize(screenSize.width, 700);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXemDanhSach;
    private javax.swing.JButton btnXepLop;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
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
    // End of variables declaration//GEN-END:variables
}
