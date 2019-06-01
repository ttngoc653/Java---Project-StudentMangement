/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Cauhinh;
import dto.Lop;
import dto.Monhoc;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPopupMenu;
import javax.swing.ListModel;

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

        try {
            return cauhinh != null ? Integer.valueOf(cauhinh.getGiaTri()) : 20;
        } catch (Exception e) {
        }

        return 20;
    }

    public static Integer getMaxAgeStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer getMaxAgeStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }

        return getMaxAgeStudent();
    }

    public static Integer getMinAgeStudent() {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuDauVao");
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return 15;
    }

    public static Integer getMinAgeStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return getMinAgeStudent();
    }

    public static Integer getMinAgeStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer getMaxStudent() {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDa");
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return 40;
    }

    public static Integer getMaxStudent(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDaLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return getMaxStudent();
    }

    public static Integer getMaxStudentNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("siSoToiDaLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer getMaxGrade() {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("soLopToiDa");
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return 40;
    }

    public static Integer getMaxGradeNull(String block) {
        cauhinh = new dal.CauHinhDAL().getByName("Số lớp tối đa của khối ~` " + block);
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer getMaxGrade(String block) {
        cauhinh = new dal.CauHinhDAL().getByName("Số lớp tối đa của khối ~` " + block);
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return getMaxGrade();
    }

    public static Double getBenchMask() {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuan");
        try {
            if (cauhinh != null) {
                return Double.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return 5D;
    }

    static Double getBenchMark(Monhoc monhoc) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + monhoc.getIdMonHoc());
        try {
            if (cauhinh != null) {
                return Double.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return getBenchMask();
    }

    static Double getBenchMark(Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Double.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return getBenchMask();
    }

    static Double getBenchMarkNull(dto.Monhoc monhoc) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + monhoc.getIdMonHoc());
        try {
            if (cauhinh != null) {
                return Double.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    static Double getBenchMarkNull(dto.Lop lop) {
        cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());
        try {
            if (cauhinh != null) {
                return Double.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer getMaxSubject() {
        cauhinh = new dal.CauHinhDAL().getByName("soMonToiDa");
        try {
            if (cauhinh != null) {
                return Integer.valueOf(cauhinh.getGiaTri());
            }
        } catch (Exception e) {
        }
        return 9;
    }

    @SuppressWarnings("null")
    public static boolean saveBenchMarkAccordingToSubject(List subject_selecteds, String benchmark_new) {
        for (Object subjectSelected : subject_selecteds) {
            String subject = subjectSelected.toString().split(" ~` ")[0];
            dto.Monhoc mon = new dal.MonhocDAL().getByTen(subject);

            cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + mon.getIdMonHoc());

            if (cauhinh == null && new dal.CauHinhDAL().add(new dto.Cauhinh("diemChuanMon" + mon.getIdMonHoc(), "benchmark", benchmark_new, "Điểm chuẩn môn ~` " + subject, null, null, null)) <= 0) {
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

            cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());

            if (myDouble == null && new dal.CauHinhDAL().add(new Cauhinh("diemChuanLop" + lop.getIdLop(), "benchmark", score, "Điểm chuẩn lớp ~` " + lop.getTenLop(), null, null, null)) <= 0) {
                return false;
            } else {

                cauhinh.setGiaTri(score);
                if (!new dal.CauHinhDAL().update(cauhinh)) {
                    return false;
                }
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
            cauhinh = new dal.CauHinhDAL().getByName("diemChuanMon" + monhoc.getIdMonHoc());
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
            cauhinh = new dal.CauHinhDAL().getByName("diemChuanLop" + lop.getIdLop());
            if (cauhinh != null) {
                stringItem += String.format(" ~` Chuẩn riêng: %s điểm", cauhinh.getGiaTri());
            }
            listModel.addElement(stringItem);
        }
        return listModel;
    }

    @SuppressWarnings("null")
    public static ListModel addAllClassToTree() {
        List<dto.Lop> list_lop = new dal.LopDAL().getAll();

        DefaultListModel model = new DefaultListModel();

        for (Lop list_lop1 : list_lop) {
            String stringItem = list_lop1.getTenLop();
            Integer maxAge = getMinAgeStudentNull(list_lop1), minAge = getMaxAgeStudentNull(list_lop1);
            if (maxAge != null && minAge != null) {
                stringItem += " ~` AD riêng: ";
                if (minAge != null) {
                    stringItem += "từ " + minAge;
                }
                if (maxAge != null) {
                    stringItem += " đến " + maxAge;
                }

                stringItem += " tuổi";
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

    public static ListModel getListBlockLimitGrade() {
        List<dto.Lop> lops = new dal.LopDAL().getByTinhTrang(Byte.parseByte("1"));
        DefaultListModel model = new DefaultListModel();
        for (Lop lop : lops) {
            dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Số lớp tối đa của khối ~` " + String.valueOf(lop.getKhoi()));
            String stringConfig = String.valueOf(lop.getKhoi()) + (cauhinh != null ? (" ~` AD riêng: " + cauhinh.getGiaTri() + " lớp") : "");
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

    static boolean error;

    public static Boolean deleteOwnConfig(final Point point, final String name_config, final javax.swing.JList list) {
        error = false;
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
                            cauhinh = new dal.CauHinhDAL().getByNameDetail("Tuối tối đa lớp " + value);
                            if (!new dal.CauHinhDAL().delete(cauhinh.getIdCauHinh())) {
                                error = true;
                            }
                            cauhinh = new dal.CauHinhDAL().getByNameDetail("Tuối tối tiếu lớp " + value);
                            if (!new dal.CauHinhDAL().delete(cauhinh.getIdCauHinh())) {
                                error = true;
                            }
                            break;
                    }
                }

            });
        }
        return !error;
    }

    public static boolean saveLimitAgeGerenal(String minAge, String maxAge) {

        dto.Cauhinh chToiTieu = getAgeMin();
        dto.Cauhinh chToiDa = getAgeMax();

        if (chToiDa != null) {
            chToiDa.setGiaTri(maxAge);

            if (!new dal.CauHinhDAL().update(chToiDa)) {
                return false;
            }
        } else if (new dal.CauHinhDAL().add(new dto.Cauhinh("tuoiToiDaDauVao", "maxAge", maxAge, "Tuổi tối đa vào trường", null, null, null)) <= 0) {
            return false;
        }
        if (chToiTieu != null) {
            chToiTieu.setGiaTri(minAge);
            if (!new dal.CauHinhDAL().update(chToiTieu)) {
                return false;
            }
        } else if (new dal.CauHinhDAL().add(new dto.Cauhinh("tuoiToiTieuDauVao", "minAge", minAge, "Tuổi tối tiểu vào trường", null, null, null)) <= 0) {
            return false;
        }

        return true;
    }

    public static Cauhinh getAgeMax() {
        return new dal.CauHinhDAL().getByName("tuoiToiDaDauVao");
    }

    public static Cauhinh getAgeMin() {
        return new dal.CauHinhDAL().getByName("tuoiToiTieuDauVao");
    }

    public static boolean saveLimitAgeAcoordingToGrade(List list_selected, String minAge, String maxAge) {
        for (Object o : list_selected) {
            String select_string = o.toString().split(" ~` ")[0];
            dto.Lop lop = new dal.LopDAL().getByTen(select_string);

            if (lop != null && getMaxAgeStudentNull(lop) == null && getMinAgeStudentNull(lop) == null) {
                cauhinh = new dto.Cauhinh("tuoiToiTieuLop"+lop.getIdLop(), "minAge", minAge, "Tuổi tối tiểu vào lớp "+lop.getTenLop(), null, null, null);
                if (new dal.CauHinhDAL().add(cauhinh) <= 0) {
                    return false;
                }

                cauhinh = new dto.Cauhinh("tuoiToiDaLop"+lop.getIdLop(), "maxAge", maxAge, "Tuổi tối đa vào lớp "+lop.getTenLop(), null, null, null);
                if (new dal.CauHinhDAL().add(cauhinh) <= 0) {
                    return false;
                }
            } else if (lop != null) {
                cauhinh = new dal.CauHinhDAL().getByName("tuoiToiTieuLop" + lop.getIdLop());
                cauhinh.setGiaTri(minAge);
                if (!new dal.CauHinhDAL().update(cauhinh)) {
                    return false;
                }

                cauhinh = new dal.CauHinhDAL().getByName("tuoiToiDaLop" + lop.getIdLop());
                cauhinh.setGiaTri(maxAge);
                if (!new dal.CauHinhDAL().update(cauhinh)) {
                    return false;
                }
            }

        }
        return true;

    }

    public static boolean saveMaxSizeGrades(String maxSizeGrades) {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("soLopToiDa");
        if (cauhinh == null) {
            cauhinh = new Cauhinh("soLopToiDa", "maxSizeGrades", maxSizeGrades, "Số lớp tối đa của trường", null, null, null);
            if (new dal.CauHinhDAL().add(cauhinh) <= 0) {
                return false;
            }
        } else {
            cauhinh.setGiaTri(maxSizeGrades);
            if (!new dal.CauHinhDAL().update(cauhinh)) {
                return false;
            }
        }
        return true;
    }

    public static boolean saveMaxSizeGradesAccordingToBlock(List selectList, String maxCountClass) {
        for (Object selectItem : selectList) {
            String block = selectItem.toString().split(" ~` ")[0];
            Integer loptoida = bll.ConfigBLL.getMaxGradeNull(block);
            if (loptoida == null && new dal.CauHinhDAL().add(new Cauhinh("soLopToiDaKhoi", "maxSizeGrades", maxCountClass, "Số lớp tối đa của khối ~` " + block, null, null, null)) >= 0) {
                return false;
            } else {
                dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByNameDetail("Số lớp tối đa của khối ~` " + block);
                cauhinh.setGiaTri(maxCountClass);
                if (!new dal.CauHinhDAL().update(cauhinh)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean saveMaxSizeStudents(String maxSizeStudents) {
        dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("siSoToiDa");
        if (cauhinh == null) {
            cauhinh = new Cauhinh("siSoToiDa", "maxSizeStudents", maxSizeStudents, "Sỉ số tối đa chung", null, null, null);
            if (new dal.CauHinhDAL().add(cauhinh) <= 0) {
                return false;
            }
        } else {
            cauhinh.setGiaTri(maxSizeStudents);
            if (!new dal.CauHinhDAL().update(cauhinh)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("null")
    public static boolean saveMaxSizeStudentsAccordingToGrade(List selectedValuesList, String maxSizeStudents) {
        for (Object selectList1 : selectedValuesList) {
            dto.Lop lop = new dal.LopDAL().getByTen(selectList1.toString().split(" ~` ")[0]);
            if (lop != null) {
                dto.Cauhinh cauhinh = new dal.CauHinhDAL().getByName("siSoToiDaLop" + lop.getIdLop());
                if (cauhinh == null && new dal.CauHinhDAL().add(new Cauhinh("siSoToiDaLop" + lop.getIdLop(), "maxSizeStudents", maxSizeStudents, "Sỉ số tối đa lớp ~` " + lop.getTenLop(), null, null, null)) <= 0) {
                    return false;
                } else {
                    cauhinh.setGiaTri(maxSizeStudents);
                    if (!new dal.CauHinhDAL().update(cauhinh)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static ListModel getListSubjectCastrate() {
        List<Monhoc> ds = new dal.MonhocDAL().getByTinhTrang(false);
        DefaultListModel ten = new DefaultListModel();
        for (Monhoc mh : ds) {
            ten.addElement(mh.getTenMh());
        }
        return ten;
    }

    public static ListModel getListSubjectTeaching() {
        List<Monhoc> ds = new dal.MonhocDAL().getByTinhTrang(true);
        DefaultListModel ten = new DefaultListModel();
        for (Monhoc mh : ds) {
            ten.addElement(mh.getTenMh());
        }
        return ten;
    }
}
