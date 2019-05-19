/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Cauhinh;
import java.util.List;
import java.util.Set;
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

    public static void addAllSchoolYearToTree(DefaultTreeModel model, DefaultMutableTreeNode node) {
        List<dto.Namhoc> list_namhoc = new dal.NamhocDAL().getAll();

        for (int i = 0; i < list_namhoc.size(); i++) {
            node.add(new DefaultMutableTreeNode(list_namhoc.get(i).getTenNamHoc()));
            model.nodesWereInserted(node, new int[]{node.getChildCount() - 1});
        }
    }

    public static String getValueMaxClassCurrent(Set<Cauhinh> cauhinhs) {
        return "";
    }

    public static Cauhinh searchCauHinhAccoundToBlock(String split) {
        List<dto.Cauhinh> cauhinhs = new dal.CauHinhDAL().getAll();
        for (int i = 0; i < cauhinhs.size(); i++) {
            if (cauhinhs.get(i).getTenDayDu().equals("Số lớp tối đa của khối ~` " + split)) {
                return cauhinhs.get(i);
            }
        }
        return null;
    }

}
