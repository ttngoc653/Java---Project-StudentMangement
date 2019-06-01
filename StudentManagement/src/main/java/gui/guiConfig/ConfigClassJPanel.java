/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guiConfig;

import dto.Cauhinh;
import dto.Lop;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author tuhuy
 */
public class ConfigClassJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel3
     */
    public ConfigClassJPanel() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaxCount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnMaxSudent = new javax.swing.JButton();
        ckbNew = new javax.swing.JCheckBox();
        ckbOld = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClass = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaxCountClass = new javax.swing.JTextField();
        btnMaxCountClass = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listType = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        ckbGeneral = new javax.swing.JCheckBox();
        ckbType = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(380, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Sỉ số tối đa:");

        txtMaxCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaxCount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxCountKeyTyped(evt);
            }
        });

        jLabel2.setText("Áp dụng:");

        btnMaxSudent.setText("Áp dụng sỉ số tối đa");
        btnMaxSudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxSudentActionPerformed(evt);
            }
        });

        ckbNew.setText("Khi tạo lớp mới");

        ckbOld.setText("Lớp cũ:");
        ckbOld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbOldActionPerformed(evt);
            }
        });

        listClass.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listClass);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ckbNew)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckbOld)
                                    .addComponent(txtMaxCount, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnMaxSudent)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbNew)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckbOld)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaxSudent)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel3.setText("Số lượng lớp tối đa:");

        txtMaxCountClass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaxCountClass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxCountClassKeyTyped(evt);
            }
        });

        btnMaxCountClass.setText("Áp dụng số lượng lớp");
        btnMaxCountClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxCountClassActionPerformed(evt);
            }
        });

        listType.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listType);

        jLabel5.setText("Áp dụng:");

        ckbGeneral.setText("Tất cả các khối");

        ckbType.setText("Theo khối:");
        ckbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnMaxCountClass))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaxCountClass, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbType)
                    .addComponent(ckbGeneral))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaxCountClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbGeneral)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckbType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaxCountClass)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quy định lớp");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ckbOldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbOldActionPerformed
        listClass.setEnabled(ckbOld.isSelected());
    }//GEN-LAST:event_ckbOldActionPerformed

    private void ckbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbTypeActionPerformed
        listType.setEnabled(ckbType.isSelected());
    }//GEN-LAST:event_ckbTypeActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        //init panel max count student
        ckbNew.setSelected(true);
        listClass.setModel(bll.ConfigBLL.getListGradeLimitStudent());
        listClass.setEnabled(ckbOld.isSelected());
        txtMaxCount.setText(bll.ConfigBLL.getMaxStudent().toString());
        
        //init panel max class
        ckbGeneral.setSelected(true);
        listType.setModel(bll.ConfigBLL.getListBlockLimitGrade());
        listType.setEnabled(ckbType.isSelected());
        txtMaxCountClass.setText(bll.ConfigBLL.getMaxGrade().toString());
    }//GEN-LAST:event_formComponentShown

    private void btnMaxSudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxSudentActionPerformed
        if (txtMaxCount.getText().isEmpty()) {
            showError("Vui lòng nhập số lượng học sinh tối đa.");
            return;
        }else if (!bll.HelperBLL.IsInteger(txtMaxCount.getText())) {
            showError("Sĩ số tối đa phải là số nguyên.");
            return;
        }

        // create or modify number of students of all class in school
        if (ckbNew.isSelected() && !bll.ConfigBLL.saveMaxSizeStudents(txtMaxCount.getText())) {
            showError("Áp dụng sỉ số tối đa thất bại.");
        }

        // create or modify maximun number of students acconding to class seleted in jlist
        if (ckbOld.isSelected() && !bll.ConfigBLL.saveMaxSizeStudentsAccordingToGrade(listClass.getSelectedValuesList(), txtMaxCount.getText())) {
            showError("Lưu sĩ số tối đa theo lớp thất bại.");
        }
        
        formComponentShown(null);
    }//GEN-LAST:event_btnMaxSudentActionPerformed

    private void btnMaxCountClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxCountClassActionPerformed
        if (txtMaxCountClass.getText().isEmpty()) {
            showError("Vui lòng nhập số lượng lớp.");
            return;
        }else if (!bll.HelperBLL.IsInteger(txtMaxCountClass.getText())) {
            showError("Số lượng lớp phải có giá trị số.");
            return;
        }

        if (ckbGeneral.isSelected() && !bll.ConfigBLL.saveMaxSizeGrades(txtMaxCount.getText())) {
            showError("Lưu số lớp tối đa thất bại.");
        }

        if (ckbType.isSelected()) {
            if (!bll.ConfigBLL.saveMaxSizeGradesAccordingToBlock( listType.getSelectedValuesList(), txtMaxCountClass.getText())) {
                showError("Lưu số lớp tối đa theo khối thất bại");
            }
        }
    }//GEN-LAST:event_btnMaxCountClassActionPerformed

    private void txtMaxCountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxCountKeyTyped
//        if (!bll.HelperBLL.IsInteger(txtMaxCount.getText() + evt.getKeyChar())) {
//            //evt.consume();
//        }
    }//GEN-LAST:event_txtMaxCountKeyTyped

    private void txtMaxCountClassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxCountClassKeyTyped
//        if (!bll.HelperBLL.IsInteger(txtMaxCountClass.getText() + evt.getKeyChar())) {
//            evt.consume();
//        }
    }//GEN-LAST:event_txtMaxCountClassKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMaxCountClass;
    private javax.swing.JButton btnMaxSudent;
    private javax.swing.JCheckBox ckbGeneral;
    private javax.swing.JCheckBox ckbNew;
    private javax.swing.JCheckBox ckbOld;
    private javax.swing.JCheckBox ckbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listClass;
    private javax.swing.JList listType;
    private javax.swing.JTextField txtMaxCount;
    private javax.swing.JTextField txtMaxCountClass;
    // End of variables declaration//GEN-END:variables

    private void showError(String content_error) {
        JOptionPane.showMessageDialog(this, content_error, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
