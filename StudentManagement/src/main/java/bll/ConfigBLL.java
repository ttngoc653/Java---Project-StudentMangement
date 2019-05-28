/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Cauhinh;
import dto.Lop;
import dto.Monhoc;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Jossion
 */
public class ConfigBLL {

    public static void addAllSchoolYearToTree(DefaultTreeModel model, DefaultMutableTreeNode node) {
        List<dto.Namhoc> list_namhoc = new dal.NamhocDAL().getAll();

        for (int i = 0; i < list_namhoc.size(); i++) {
            node.add(new DefaultMutableTreeNode(list_namhoc.get(i).getTenNamHoc()));
            model.nodesWereInserted(node, new int[]{node.getChildCount() - 1});
        }
    }

    public static String getValueMaxClassCurrent(Set<Cauhinh> cauhinhs) {
        dto.Cauhinh cauhinhChuanChung = new dal.CauHinhDAL().getByName("diemChuan");

        return cauhinhChuanChung != null ? cauhinhChuanChung.getGiaTri() : "0";
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

    public static String getBenchMaskGerenalCurrent() {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("diemChuan");

        return cauhinh != null ? cauhinh.getGiaTri() : "5";
    }

    static Double getBenchMarkSubject(Monhoc monhoc) {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Điểm chuẩn môn ~` " + monhoc.getTenMh());
        try {
            return Double.valueOf(cauhinh.getGiaTri());
        } catch (Exception e) {
        }
        return Double.parseDouble(getBenchMaskGerenalCurrent());
    }

    static Double getBenchMarkClass(Lop lop) {
        for (Cauhinh cauhinh : lop.getCauhinhs()) {
            if (cauhinh.getTenThuocTinh().equals("diemChuanTheoLop")) {
                try {
                    return Double.valueOf(cauhinh.getGiaTri());
                } catch (Exception e) {
                }
            }
        }
        return Double.parseDouble(getBenchMaskGerenalCurrent());
    }

    public static boolean saveBenchMarkAccordingToSubject(List subject_selecteds, String benchmark_new) {
        for (Object subjectSelected : subject_selecteds) {
            String subject = subjectSelected.toString().split(" ~` ")[0];
            dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Điểm chuẩn môn ~` " + subject);

            if (cauhinh == null && new dal.CauHinhDAL().add(new dto.Cauhinh("diemChuanTheoMon", "benchmark", benchmark_new, "Điểm chuẩn môn ~` " + subject, null, null, null)) <= 0) {
                return false;
            } else {
                cauhinh.setGiaTri(benchmark_new);
                if (!new dal.CauHinhDAL().update(cauhinh)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean saveBenchMarkAccordingToClass(List list_grade_selecteds, String score) {
        for (Object listGradeSelected : list_grade_selecteds) {
            String grade = listGradeSelected.toString().split(" ~` ")[0];
            dto.Lop lop = new dal.LopDAL().getByTen(grade);
            Boolean hasConfig = false;
            for (dto.Cauhinh cauhinh : lop.getCauhinhs()) {
                if (cauhinh.getTenThuocTinh().equals("diemChuanTheoLop")) {
                    lop.getCauhinhs().remove(cauhinh);
                    cauhinh.setGiaTri(score);
                    lop.getCauhinhs().add(cauhinh);
                    hasConfig = true;
                    break;
                }
            }
            if (!hasConfig) {
                dto.Cauhinh cauhinh = new dto.Cauhinh("diemChuanLop", "benchmark", score, "Điểm chuẩn lớp " + grade, null, null, null);
                Set<dto.Cauhinh> cauhinhs = lop.getCauhinhs();
                cauhinhs.add(cauhinh);
                lop.setCauhinhs(cauhinhs);
            }
            if (!new dal.LopDAL().update(lop)) {
                return false;
            }
        }
        return true;
    }

    public static boolean saveBenchMarkGerenal(String score) {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("diemChuan");
        if (cauhinh == null && new dal.CauHinhDAL().add(new dto.Cauhinh("diemChuan", "benchmark", score, "Điểm chuẩn mặc định", null, null, null)) <= 0) {
            return false;
        } else {
            cauhinh.setGiaTri(score);
            if (!new dal.CauHinhDAL().update(cauhinh)) {
                return false;
            }
        }
        return true;

    }

    public static ListModel getListSubjectBenchmark() {
        List<dto.Monhoc> monhocs = new dal.MonhocDAL().getAll();
        DefaultListModel listModel = new DefaultListModel();
        for (dto.Monhoc monhoc : monhocs) {
            String stringItem = monhoc.getTenMh();
            dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Điểm chuẩn môn ~` " + monhoc.getTenMh());
            if (cauhinh != null) {
                stringItem += String.format(" ~` Chuẩn riêng: %s điểm", cauhinh.getGiaTri());
            }
            listModel.addElement(stringItem);
        }
        return listModel;
    }

    public static ListModel getListGradeBenchmark() {
        DefaultListModel listModel = new DefaultListModel();
        List<dto.Lop> lops = new dal.LopDAL().getAll();
        for (dto.Lop lop : lops) {
            String stringItem = lop.getTenLop();
            for (Cauhinh item : lop.getCauhinhs()) {
                if (item.getTenThuocTinh().equals("diemChuanTheoLop")) {
                    stringItem += String.format(" ~` Chuẩn riêng: %s điểm", item.getGiaTri());
                    break;
                }
            }
            listModel.addElement(stringItem);
        }
        return listModel;
    }

    public static ListModel addAllClassToTree() {
        List<dto.Lop> list_lop = new dal.LopDAL().getAll();

        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < list_lop.size(); i++) {
            String stringItem = list_lop.get(i).getTenLop();
            dto.Cauhinh maxAge = null, minAge = null;
            for (Cauhinh item : list_lop.get(i).getCauhinhs()) {
                if (item.getLoaiThuocTinh().equals("minAge")) {
                    minAge = item;
                } else if (item.getLoaiThuocTinh().equals("maxAge")) {
                    maxAge = item;
                }
            }
            if (maxAge != null && minAge != null) {
                stringItem += " ~` Hiện tại từ " + minAge.getGiaTri() + " đến " + maxAge.getGiaTri() + " tuổi";
            }
            model.addElement(stringItem);
        }
        return model;
    }

}
