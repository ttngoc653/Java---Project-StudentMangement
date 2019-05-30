/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Cauhinh;
import dto.Lop;
import dto.Monhoc;
import dto.Namhoc;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JPopupMenu;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Jossion
 */
public class ConfigBLL {

    private static dto.Cauhinh cauhinh;
    private static Integer myInt;
    private static Double myDouble;

    public static Integer getMaxAgeStudent() {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaDauVao");
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : 20;
    }

    public static Integer getMaxAgeStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : null;
    }

    public static Integer getMaxAgeStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : getMaxAgeStudent();
    }

    public static Integer getMinAgeStudent() {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuDauVao");
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : 15;
    }

    public static Integer getMinAgeStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : getMinAgeStudent();
    }

    public static Integer getMinAgeStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : null;
    }

    public static Integer getMaxStudent() {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDa");
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : 40;
    }

    public static Integer getMaxStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDaLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : getMaxStudent();
    }

    public static Integer getMaxStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDaLop" + lop.getIdLop());
        return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : null;
    }

    public static Integer getMaxClass() {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("soLopToiDa");
        return Integer.parseInt(cauhinh == null ? null : cauhinh.getGiaTri());
    }

    public static Integer getMaxGradeNull(String block) {
        cauhinh = new dal.CauHinhDAL().getByName("soLopToiDaKhoi" + block);
        return cauhinh != null ? Integer.parseInt(cauhinh.getGiaTri()) : null;
    }

    public static Integer getMaxGrade(String block) {
        cauhinh = new dal.CauHinhDAL().getByName("soLopToiDaKhoi" + block);
        return cauhinh != null ? Integer.parseInt(cauhinh.getGiaTri()) : getMaxClass();
    }

    public static Double getBenchMask() {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuan");
        return Double.valueOf(cauhinh != null ? cauhinh.getGiaTri() : "5");
    }

    static Double getBenchMark(Monhoc monhoc) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + monhoc.getIdMonHoc());

        return cauhinh != null ? Double.valueOf(cauhinh.getGiaTri()) : getBenchMask();
    }

    static Double getBenchMark(Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());
        return cauhinh != null ? Double.valueOf(cauhinh.getGiaTri()) : getBenchMask();
    }

    static Double getBenchMarkNull(dto.Monhoc monhoc) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + monhoc.getIdMonHoc());

        return cauhinh != null ? Double.valueOf(cauhinh.getGiaTri()) : null;
    }

    static Double getBenchMarkNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());
        return cauhinh != null ? Double.valueOf(cauhinh.getGiaTri()) : null;
    }

    public static Integer getMaxSubject() {
        cauhinh = new dal.CauHinhDAL().getByName("soMonToiDa");
        return Integer.valueOf(cauhinh != null ? cauhinh.getGiaTri() : "9");
    }

    @SuppressWarnings("null")
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

    @SuppressWarnings("null")
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

        for (Lop list_lop1 : list_lop) {
            String stringItem = list_lop1.getTenLop();
            dto.Cauhinh maxAge = null, minAge = null;
            for (Cauhinh item : list_lop1.getCauhinhs()) {
                switch (item.getLoaiThuocTinh()) {
                    case "minAge":
                        minAge = item;
                        break;
                    case "maxAge":
                        maxAge = item;
                        break;
                }
            }
            if (maxAge != null && minAge != null) {
                stringItem += " ~` Hiện tại từ " + minAge.getGiaTri() + " đến " + maxAge.getGiaTri() + " tuổi";
            }
            model.addElement(stringItem);
        }
        return model;
    }

    public static boolean saveSubjectTeaching(List l, boolean b) {
        try {
            for (Object l1 : l) {
                dto.Monhoc monhoc = new dal.MonhocDAL().getByTen(l1.toString());
                if (monhoc != null) {
                    monhoc.setDangGiangDay(b);

                    new dal.MonhocDAL().update(monhoc);
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Double getMinAgeGerenal() {
        dto.Cauhinh cauhinhChuanChung = new dal.CauHinhDAL().getByName("tuoiToiTieuDauVao");

        return Double.valueOf(cauhinhChuanChung != null ? cauhinhChuanChung.getGiaTri() : "0");
    }

    public static Double getMaxAgeGerenal() {
        dto.Cauhinh cauhinhChuanChung = new dal.CauHinhDAL().getByName("tuoiToiDaDauVao");

        return Double.valueOf(cauhinhChuanChung != null ? cauhinhChuanChung.getGiaTri() : "100");
    }

    public static ListModel getListBlockLimitGrade() {
        List<dto.Lop> lops = new dal.LopDAL().getByTinhTrang(Byte.parseByte("1"));
        DefaultListModel model = new DefaultListModel();
        for (Lop lop : lops) {
            dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Số lớp tối đa của khối ~` " + String.valueOf(lop.getKhoi()));
            String stringConfig = String.valueOf(lop.getKhoi()) + (cauhinh != null ? (" ~` AD riêng là: " + cauhinh.getGiaTri() + " lớp") : "");
            model.removeElement(stringConfig);
            model.addElement(stringConfig);
        }
        return model;
    }

    public static ListModel getListGradeLimitStudent() {
        List<dto.Lop> lops = new dal.LopDAL().getAll();
        DefaultListModel model = new DefaultListModel();
        for (Lop lop : lops) {
            myInt = getMaxStudent(lop);
            model.addElement(lop.getTenLop() + (myInt != null ? (" ~`AD riêng: " + myInt + " học sinh") : ""));
        }
        return model;
    }

    public static void deleteOwnConfig(final Point point, final String name_config, final javax.swing.JList list) {
        if (!list.isSelectionEmpty()) {
            javax.swing.JPopupMenu menu = new JPopupMenu();
            menu.add(new javax.swing.JMenuItem("Xóa áp dụng riêng"));
            menu.show(list, point.x, point.y);

            menu.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                    String value = list.getModel().getElementAt(list.locationToIndex(point)).toString().split(" ~` ")[0];

                    switch (name_config) {
                        case "tuoiVaoLop":
                            break;
                    }
                }

            });
        }
    }

    public static void addAllSchoolYearToTree(DefaultTreeModel model, DefaultMutableTreeNode node) {
        List<dto.Namhoc> list_namhoc = new dal.NamhocDAL().getAll();

        for (Namhoc list_namhoc1 : list_namhoc) {
            node.add(new DefaultMutableTreeNode(list_namhoc1.getTenNamHoc()));
            model.nodesWereInserted(node, new int[]{node.getChildCount() - 1});
        }
    }
}
