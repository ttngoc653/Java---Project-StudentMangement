/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.NamhocDAL;
import dto.Hocky;
import dto.Monhoc;
import dto.Namhoc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Jossion
 */
public class ReportJFrame extends javax.swing.JFrame {

    public static Boolean openFrame = true;
    /**
     * Creates new form ReportFinalSubjectJFrame
     */
    public ReportJFrame() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbSchoolYear = new javax.swing.JComboBox();
        cbbSemester = new javax.swing.JComboBox();
        cbbSubject = new javax.swing.JComboBox();
        btnSummarySemester = new javax.swing.JButton();
        btnSummarySubject = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StuMng - THỐNG KÊ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("TẠO BÁO CÁO"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Năm học: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Học kỳ: ");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Môn học: ");

        cbbSchoolYear.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbbSchoolYearPopupMenuWillBecomeVisible(evt);
            }
        });

        cbbSemester.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbbSemesterPopupMenuWillBecomeVisible(evt);
            }
        });

        cbbSubject.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbbSubjectPopupMenuWillBecomeVisible(evt);
            }
        });

        btnSummarySemester.setText("Thống kê điểm học kỳ (theo lớp)");
        btnSummarySemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummarySemesterActionPerformed(evt);
            }
        });

        btnSummarySubject.setText("Thống kê điểm môn học (theo lớp)");
        btnSummarySubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummarySubjectActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Báo cáo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSchoolYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSummarySemester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSummarySubject, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSummarySubject)
                .addGap(18, 18, 18)
                .addComponent(btnSummarySemester)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbSchoolYearPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbSchoolYearPopupMenuWillBecomeVisible
        List<Namhoc> l = new NamhocDAL().getAll();
        cbbSchoolYear.removeAllItems();
        for (Namhoc i : l) {
            cbbSchoolYear.addItem(i.getTenNamHoc());
        }
    }//GEN-LAST:event_cbbSchoolYearPopupMenuWillBecomeVisible

    private void cbbSemesterPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbSemesterPopupMenuWillBecomeVisible
        List<Hocky> l = new dal.HockyDAL().getAll();
        cbbSemester.removeAllItems();
        for (Hocky i : l) {
            cbbSemester.addItem(i.getTenHocKy());
        }
    }//GEN-LAST:event_cbbSemesterPopupMenuWillBecomeVisible

    private void cbbSubjectPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbSubjectPopupMenuWillBecomeVisible
        List<Monhoc> l = new dal.MonhocDAL().getAll();
        cbbSubject.removeAllItems();
        for (Monhoc i : l) {
            cbbSubject.addItem(i.getTenMh());
        }
    }//GEN-LAST:event_cbbSubjectPopupMenuWillBecomeVisible

    private void btnSummarySubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummarySubjectActionPerformed
        if (cbbSchoolYear.getSelectedItem().equals("") || cbbSemester.getSelectedItem().equals("") || cbbSubject.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đủ thông tin!");
            return;
        }
        List<Map<String, ?>> dataSource = new bll.ReportBLL().dataReportBySubject(cbbSubject.getSelectedItem().toString(), cbbSchoolYear.getSelectedItem().toString(), Integer.parseInt((String) cbbSemester.getSelectedItem()));
        if (dataSource.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Môn " + cbbSubject.getSelectedItem().toString() + " ở học kỳ " + cbbSemester.getSelectedItem().toString() + " thuộc năm học " + cbbSchoolYear.getSelectedItem().toString() + " hiện tại chưa có lớp nào có điểm.");
            return;
        }
        JRDataSource jrSource = new JRBeanCollectionDataSource(dataSource);

        HashMap param = new HashMap();
        param.put("subjectName", cbbSubject.getSelectedItem().toString());
        param.put("semester", cbbSemester.getSelectedItem().toString());
        param.put("schoolYear", cbbSchoolYear.getSelectedItem().toString());

        String dirReport = System.getProperty("user.dir") + "\\src\\main\\java\\gui\\ReportFinalSubjectReport.jrxml";
        try {
            InputStream input = new FileInputStream(new File(dirReport));
            JasperReport jR = JasperCompileManager.compileReport(input);
            JasperPrint jP = JasperFillManager.fillReport(jR, param, jrSource);
            JasperExportManager.exportReportToPdf(jP);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSummarySubjectActionPerformed

    private void btnSummarySemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummarySemesterActionPerformed
        if (cbbSchoolYear.getSelectedItem().equals("") || cbbSemester.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đủ thông tin!");
            return;
        }
        List<Map<String, ?>> dataSource = new bll.ReportBLL().dataReportBySemester(cbbSchoolYear.getSelectedItem().toString(), Integer.parseInt((String) cbbSemester.getSelectedItem()));
        if (dataSource.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Học kỳ " + cbbSemester.getSelectedItem().toString() + " thuộc năm học " + cbbSchoolYear.getSelectedItem().toString() + " này hiện tại chưa có lớp nào điểm.");
            return;
        }
        JRDataSource jrSource = new JRBeanCollectionDataSource(dataSource);

        HashMap param = new HashMap();
        param.put("semester", cbbSemester.getSelectedItem().toString());
        param.put("schoolYear", cbbSchoolYear.getSelectedItem().toString());

        String dirReport = System.getProperty("user.dir") + "\\src\\main\\java\\gui\\ReportFinalSemesterReport.jrxml";
        try {
            InputStream input = new FileInputStream(new File(dirReport));
            JasperReport jR = JasperCompileManager.compileReport(input);
            JasperPrint jP = JasperFillManager.fillReport(jR, param, jrSource);
            JasperExportManager.exportReportToPdf(jP);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSummarySemesterActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSummarySemester;
    private javax.swing.JButton btnSummarySubject;
    private javax.swing.JComboBox cbbSchoolYear;
    private javax.swing.JComboBox cbbSemester;
    private javax.swing.JComboBox cbbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
