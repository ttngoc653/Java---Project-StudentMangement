/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accordingToForm;

import dto.Diem;
import dto.Hocky;
import dto.HocsinhLophoc;
import dto.Lop;
import dto.Namhoc;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jossion
 */
public class ListScoreStudentByClass extends javax.swing.JFrame {

    /**
     * Creates new form ListScoreStudentByClass
     */
    public ListScoreStudentByClass() {
        initComponents();

        List<dto.Namhoc> lNh = new dal.NamhocDAL().getAll();
        cbbSchoolYear.removeAllItems();
        cbbSchoolYear.addItem("");
        for (Namhoc i : lNh) {
            cbbSchoolYear.addItem(i.getTenNamHoc());
        }

        List<dto.Lop> lL = new dal.LopDAL().getAll();
        cbbBlock.removeAllItems();
        cbbBlock.addItem("");
        for (dto.Lop i : lL) {
            cbbBlock.removeItem(i.getKhoi());
            cbbBlock.addItem(i.getKhoi());
        }

        cbbGrade.removeAllItems();
        cbbGrade.addItem("");
        for (dto.Lop i : lL) {
            cbbGrade.addItem(i.getTenLop());
        }
        
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(125);
        
        this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        if (jTable1.getPreferredSize().width < jTable1.getParent().getWidth()) {
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else {
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        
        
        process(cbbSchoolYear.getSelectedItem().toString(), cbbBlock.getSelectedItem().toString(), cbbGrade.getSelectedItem().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbbSchoolYear = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbBlock = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbbGrade = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG KẾT ĐIỂM HỌC SINH");

        cbbSchoolYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSchoolYear.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbSchoolYearPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "Lớp", "TB học kỳ 1", "TB học kỳ 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Năm học:");

        jLabel3.setText("Khối lớp:");

        cbbBlock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbBlock.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbBlockPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setText("Lớp:");

        cbbGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbGrade.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbGradePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbbBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbSchoolYearPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbSchoolYearPopupMenuWillBecomeInvisible
        process(cbbSchoolYear.getSelectedItem().toString(), cbbBlock.getSelectedItem().toString(), cbbGrade.getSelectedItem().toString());
    }//GEN-LAST:event_cbbSchoolYearPopupMenuWillBecomeInvisible

    private void cbbBlockPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbBlockPopupMenuWillBecomeInvisible
        process(cbbSchoolYear.getSelectedItem().toString(), cbbBlock.getSelectedItem().toString(), cbbGrade.getSelectedItem().toString());
    }//GEN-LAST:event_cbbBlockPopupMenuWillBecomeInvisible

    private void cbbGradePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbGradePopupMenuWillBecomeInvisible
        process(cbbSchoolYear.getSelectedItem().toString(), cbbBlock.getSelectedItem().toString(), cbbGrade.getSelectedItem().toString());
    }//GEN-LAST:event_cbbGradePopupMenuWillBecomeInvisible

    private void process(String schoolyear, String block, String grade) {
        List<dto.HocsinhLophoc> hocsinhLophocs = new dal.HocsinhLophocDAL().getAll();

        dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolyear);
        List<dto.Lop> lops=null;
        try {
            lops = new dal.LopDAL().getByKhoi(block);
        } catch (Exception e) {
        }
        dto.Lop lop = new dal.LopDAL().getByTen(grade);

        for (HocsinhLophoc hocsinhLophoc : hocsinhLophocs) {
            if (namhoc != null && !Objects.equals(namhoc.getIdNamHoc(), hocsinhLophoc.getNamhoc().getIdNamHoc())) {
                hocsinhLophocs.remove(hocsinhLophoc);
            }
            for (Lop lop1 : lops) {
                if (!Objects.equals(lop1.getIdLop(), hocsinhLophoc.getLop().getIdLop())) {
                    hocsinhLophocs.remove(hocsinhLophoc);
                }
            }
            if (lop != null && !Objects.equals(lop.getIdLop(), hocsinhLophoc.getLop().getIdLop())) {
                hocsinhLophocs.remove(hocsinhLophoc);
            }
        }

        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }

        Double diem15, diem1, diemhk, dtb, sum_heso = 0D;
        int heso;
        List<dto.Hocky> hockys = new dal.HockyDAL().getAll();
        List<Double> tongdiemHK = new ArrayList<>();
        for (int j = 0; j < hocsinhLophocs.size(); j++) {
            for (int i = 0; i < hockys.size(); i++) {
                tongdiemHK.add(0D);
                dtb = 0D;
                heso = 0;
                List<dto.Diem> diems = new dal.DiemDAL().getByHocSinhLopHocHocKy(hocsinhLophocs.get(j), hockys.get(i));
                for (Diem diem : diems) {
                    diem15 = diem.getDiem15phut();
                    diem1 = diem.getDiem1tiet();
                    diemhk = diem.getDiemCuoiKy();

                    dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / 6;

                    tongdiemHK.set(i, dtb * diem.getMonhoc().getHeSo() + tongdiemHK.get(i));
                    sum_heso += diem.getMonhoc().getHeSo();
                }
                tongdiemHK.set(i, (double) Math.round(tongdiemHK.get(i) / sum_heso * 100) / 100);
            }

            dm.addRow(new Object[]{j, hocsinhLophocs.get(j).getHocsinh().getHoTen(), hocsinhLophocs.get(j).getLop().getTenLop(), tongdiemHK.get(0), tongdiemHK.get(1)});
            
            tongdiemHK.clear();
        }
    }

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
            java.util.logging.Logger.getLogger(ListScoreStudentByClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListScoreStudentByClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListScoreStudentByClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListScoreStudentByClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListScoreStudentByClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbbBlock;
    private javax.swing.JComboBox cbbGrade;
    private javax.swing.JComboBox cbbSchoolYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
