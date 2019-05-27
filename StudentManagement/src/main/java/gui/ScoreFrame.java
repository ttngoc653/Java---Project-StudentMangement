/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.HockyDAL;
import dal.LopDAL;
import dal.MonhocDAL;
import dal.NamhocDAL;
import dto.Hocky;
import dto.Lop;
import dto.Monhoc;
import dto.Namhoc;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tan
 */
public class ScoreFrame extends javax.swing.JFrame {

    public static Boolean openFrame = true;
    private int temp = -1;
    private dto.Namhoc namhoc;
    private dto.Hocky hocky;
    private dto.Monhoc monhoc;
    private dto.Lop lop;

    /**
     * Creates new form ScoreFrame
     */
    public ScoreFrame() {
        initComponents();
        initLop();
        initHocky();
        initMonhoc();
        initNamhoc();
        this.setLocationRelativeTo(null);

    }

    private void initLop() {
        //DefaultComboBoxModel modelLop = new DefaultComboBoxModel();
        LopDAL lopdal = new LopDAL();
        List<Lop> DSlop = new ArrayList<Lop>();
        DSlop = lopdal.getAll();
        lopCBX.removeAllItems();
        if (DSlop != null) {
            for (Lop _lop : DSlop) {
                lopCBX.addItem(_lop.getTenLop());
            }
        }

    }

    private void initHocky() {
        DefaultComboBoxModel modelHocky = new DefaultComboBoxModel();
        HockyDAL hockydal = new HockyDAL();
        List<Hocky> DSHocky = new ArrayList<Hocky>();
        DSHocky = hockydal.getAll();
        hockyCBX.removeAllItems();
        if (DSHocky != null) {
            for (Hocky hk : DSHocky) {
                modelHocky.addElement(hk.getTenHocKy());
            }
            hockyCBX.setModel(modelHocky);

        }
    }

    private void initMonhoc() {
        DefaultComboBoxModel modelmonhoc = new DefaultComboBoxModel();
        MonhocDAL monhocdal = new MonhocDAL();
        List<Monhoc> DSmon = new ArrayList<>();
        DSmon = monhocdal.getAll();
        monCBX.removeAllItems();
        if (DSmon != null) {
            for (Monhoc mh : DSmon) {
                modelmonhoc.addElement(mh.getTenMh());
            }
            monCBX.setModel(modelmonhoc);

        }
    }

    private void initNamhoc() {
        DefaultComboBoxModel modelNamhoc = new DefaultComboBoxModel();
        NamhocDAL namhocdal = new NamhocDAL();
        List<Namhoc> DSnamhoc = new ArrayList<Namhoc>();
        DSnamhoc = namhocdal.getAll();
        namhocCBX.removeAllItems();
        if (DSnamhoc != null) {
            for (Namhoc nh : DSnamhoc) {
                modelNamhoc.addElement(nh.getTenNamHoc());
            }
            namhocCBX.setModel(modelNamhoc);

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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lopCBX = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        hockyCBX = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        namhocCBX = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        monCBX = new javax.swing.JComboBox<>();
        chonBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lớp");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Học Kỳ");

        hockyCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hockyCBXActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Năm Học");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Môn");

        chonBT.setText("Chọn");
        chonBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chonBT)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(monCBX, 0, 112, Short.MAX_VALUE)
                    .addComponent(namhocCBX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lopCBX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hockyCBX, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namhocCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hockyCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lopCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chonBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("ĐIỂM");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học sinh"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ Tên", "Điểm 15'", "Điểm 1 tiết", "Điểm cuối kỳ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hockyCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hockyCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hockyCBXActionPerformed

    private void chonBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonBTActionPerformed
        // TODO add your handling code here:
        namhoc = new dal.NamhocDAL().getByTen(namhocCBX.getSelectedItem().toString());
        monhoc = new dal.MonhocDAL().getByTen(monCBX.getSelectedItem().toString());
        hocky = new dal.HockyDAL().getByTen(Integer.valueOf(hockyCBX.getSelectedItem().toString()));
        lop = new dal.LopDAL().getByTen(lopCBX.getSelectedItem().toString());
        this.jTable1.setModel(new bll.ScoreFrameBLL().getData(lopCBX.getSelectedItem().toString(), monCBX.getSelectedItem().toString(), namhocCBX.getSelectedItem().toString(), hockyCBX.getSelectedItem().toString()));
    }//GEN-LAST:event_chonBTActionPerformed

    String value_old;

    @SuppressWarnings("null")
    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
        String value = "";
        if (jTable1.getSelectedRow() != -1 || jTable1.getSelectedColumn() != -1) {
            value = jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString();
        }
        if (temp == jTable1.getSelectedRow() && jTable1.getSelectedRow() != -1) {
            System.out.println(jTable1.getSelectedRow() + "____" + jTable1.getSelectedColumn() + "____" + value);
            if (!value.isEmpty() && !(Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 10D)) {
                JOptionPane.showMessageDialog(this, "Điểm không hợp lệ. Điểm phải từ 0 đến 10.", value, WIDTH);
                jTable1.setValueAt(value_old, jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                return;
            }
            String strTenHocSinh = jTable1.getModel().getValueAt(temp, 1).toString();
            dto.Hocsinh hs = new dal.HocsinhDAL().getByName(strTenHocSinh);
            Double diem15 = null, diem1 = null, diemck = null;
            try {
                diem15 = Double.valueOf(jTable1.getModel().getValueAt(temp, 2).toString());
            } catch (NumberFormatException e) {
            }
            try {
                diem1 = Double.valueOf(jTable1.getModel().getValueAt(temp, 3).toString());
            } catch (NumberFormatException e) {
            }
            try {
                diemck = Double.valueOf(jTable1.getModel().getValueAt(temp, 4).toString());
            } catch (NumberFormatException e) {
            }
            dto.HocsinhLophoc hl = new dal.HocsinhLophocDAL().getByNamHocLopHocSinh(namhoc, lop, hs);
            dto.Diem diem = new dal.DiemDAL().getByLopHocHocKyMonHocHocSinh(lop, namhoc, hocky, monhoc, hs);
            if (diem == null) {
                if (new dal.DiemDAL().add(new dto.Diem(hocky, hl, monhoc, diem15, diem1, diemck, null)) > -1) {
                    // JOptionPane.showMessageDialog(chonBT, "them thanh cong");
                } else {
                    JOptionPane.showMessageDialog(chonBT, "Them that bai");
                }
            } else {
                diem.setDiem15phut(diem15);
                diem.setDiem1tiet(diem1);
                diem.setDiemCuoiKy(diemck);
                if (new dal.DiemDAL().update(diem)) {
                    //JOptionPane.showMessageDialog(chonBT, "cap nhat thanh cong");
                } else {
                    JOptionPane.showMessageDialog(chonBT, "Cập nhật thất bại");
                }
            }
        }
        temp = jTable1.getSelectedRow();

        value_old = value;

    }//GEN-LAST:event_jTable1PropertyChange

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
            java.util.logging.Logger.getLogger(ScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreFrame().setVisible(true);

                //  ScoreFrame f = new ScoreFrame();
                //  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                //  f.setSize(750, 600);
                //  f.setLocationRelativeTo(null);
                //f.setVisible(true);
                //f.setResizable(false);
                // this.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chonBT;
    private javax.swing.JComboBox<String> hockyCBX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> lopCBX;
    private javax.swing.JComboBox<String> monCBX;
    private javax.swing.JComboBox<String> namhocCBX;
    // End of variables declaration//GEN-END:variables
}
