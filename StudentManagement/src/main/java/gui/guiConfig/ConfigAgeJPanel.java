/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guiConfig;

import bll.HelperBLL;
import dto.ChitietCauhinhHocsinh;
import dto.ChitietCauhinhLop;
import dto.ChitietCauhinhLopId;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author tuhuy
 */
public class ConfigAgeJPanel extends javax.swing.JPanel {

    boolean checkSelectedNode(String key_find) {
        TreePath[] treePaths = treeApply.getSelectionModel().getSelectionPaths();
        for (TreePath treePath : treePaths) {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            Object userObject = selectedElement.getUserObject(); //Do what you want with selected element's user object
            if (userObject.equals(key_find)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates new form NewJPanel3
     */
    public ConfigAgeJPanel() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeApply = new javax.swing.JTree();
        btnApply = new javax.swing.JButton();
        txtMinAge = new javax.swing.JTextField();
        txtMaxAge = new javax.swing.JTextField();
        ckbApply = new javax.swing.JCheckBox();
        cbxApplyAll = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(380, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quy định tuổi");
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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("(Chỉ áp dụng khi thêm mới học sinh và thêm học sinh vào lớp)");

        jLabel1.setText("Tuổi tối thiểu:");

        jLabel2.setText("Tuổi tối đa:");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Áp dụng cho tất cả lớp và năm học");
        treeApply.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeApply.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        treeApply.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeApplyValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeApply);

        btnApply.setText("Áp dụng");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        txtMinAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinAgeKeyTyped(evt);
            }
        });

        txtMaxAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxAgeKeyTyped(evt);
            }
        });

        ckbApply.setText("Áp dụng riêng");
        ckbApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbApplyActionPerformed(evt);
            }
        });

        cbxApplyAll.setText("Áp dụng khi tạo mới học sinh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnApply)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMinAge, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtMaxAge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbxApplyAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ckbApply)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMinAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaxAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cbxApplyAll))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbApply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApply)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        DefaultTreeModel model = (DefaultTreeModel) treeApply.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.add(new DefaultMutableTreeNode("Lớp"));
        root.add(new DefaultMutableTreeNode("Năm học"));
        model.nodesWereInserted(root, new int[]{root.getChildCount() - 1, root.getChildCount() - 2});

        Enumeration children = root.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
            if (node.toString().equals("Lớp")) {
                bll.ConfigBLL.addAllClassToTree(model, node);
            } else if (node.toString().equals("Năm học")) {
                bll.ConfigBLL.addAllSchoolYearToTree(model, node);
            }
        }

        treeApply.expandRow(0);

        treeApply.enable(ckbApply.isSelected());
        cbxApplyAll.setSelected(true);
    }//GEN-LAST:event_formComponentShown

    private void txtMinAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinAgeKeyTyped
        if (!HelperBLL.IsInteger(Character.toString(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMinAgeKeyTyped

    private void txtMaxAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxAgeKeyTyped
        if (!HelperBLL.IsInteger(Character.toString(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaxAgeKeyTyped

    private void treeApplyValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeApplyValueChanged
        System.out.println("start show all selection");
        TreePath[] treePaths = treeApply.getSelectionModel().getSelectionPaths();
        for (TreePath treePath : treePaths) {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            Object userObject = selectedElement.getUserObject(); //Do what you want with selected element's user object
            //System.out.println(userObject.toString());
        }
    }//GEN-LAST:event_treeApplyValueChanged

    private void ckbApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbApplyActionPerformed
        treeApply.enable(ckbApply.isSelected());
    }//GEN-LAST:event_ckbApplyActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed

        dto.Cauhinh chToiTieu = new dal.CauHinhDAL().getByName("tuoiToiTieuDauVao");
        dto.Cauhinh chToiDa = new dal.CauHinhDAL().getByName("tuoiToiDaDauVao");

        if (cbxApplyAll.isSelected()) {
            if (chToiTieu != null && chToiDa != null) {
                chToiDa.setGiaTri(txtMaxAge.getText());
                new dal.CauHinhDAL().update(chToiDa);
                chToiTieu.setGiaTri(txtMinAge.getText());
                new dal.CauHinhDAL().update(chToiTieu);
            } else if (new dal.CauHinhDAL().add(new dto.Cauhinh("tuoiToiTieuDauVao", "minAgeToSchool", txtMinAge.getText(), "Tuổi tối thiểu vào trường", null, null, null)) > 0
                    && new dal.CauHinhDAL().add(new dto.Cauhinh("tuoiToiDaDauVao", "maxAgeToSchool", txtMaxAge.getText(), "Tuổi tối đa khi vào trường", null, null, null)) > 0) {

            }
        }
        
        if (ckbApply.isSelected()) {
            if (checkSelectedNode("Lớp")) {
                List<dto.Lop> list_class = new dal.LopDAL().getAll();
                for (int i = 0; i < list_class.size(); i++) {
                    if (list_class.get(i).getChitietCauhinhLops().size()==0) {
                        Set<dto.ChitietCauhinhLop> hash=new HashSet<dto.ChitietCauhinhLop>();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JCheckBox cbxApplyAll;
    private javax.swing.JCheckBox ckbApply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree treeApply;
    private javax.swing.JTextField txtMaxAge;
    private javax.swing.JTextField txtMinAge;
    // End of variables declaration//GEN-END:variables
}
