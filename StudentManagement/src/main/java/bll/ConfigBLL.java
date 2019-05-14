/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Jossion
 */
public class ConfigBLL {

    public static void addAllClassToTree(DefaultTreeModel model, DefaultMutableTreeNode node) {
        List<dto.Lop> list_lop = new dal.LopDAL().getAll();
        for (int i = 0; i < list_lop.size(); i++) {
            node.add(new DefaultMutableTreeNode(list_lop.get(i).getTenLop()));
            model.nodesWereInserted(node, new int[]{node.getChildCount() - 1});
        }
    }

}
