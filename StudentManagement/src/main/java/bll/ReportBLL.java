
package bll;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jossion
 */
public class ReportBLL {

    public void returnReport() {
        //JasperPrint jp =JasperFillManager.fillReport(jasperReport, parameter, jrDataSource)

        File f = new File(new File("").getAbsolutePath() + "\\src\\main\\java\\gui\\ReportFinalSemesterReport.jrxml");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.exists());
    }

    public List<Integer> listSemesterName() {
        List<dto.Hocky> l = new dal.HockyDAL().getAll();
        List<Integer> lResult = new ArrayList<>();
        for (dto.Hocky l1 : l) {
            lResult.add(l1.getTenHocKy());
        }
        return lResult;
    }

    public List<String> listSchoolYearName() {
        List<dto.Namhoc> l = new dal.NamhocDAL().getAll();
        List<String> lResult = new ArrayList<>();
        for (int i = l.size(); i >= 0; i--) {
            lResult.add(l.get(i).getTenNamHoc());
        }
        return lResult;
    }

    public List<String> listSubjectName() {
        List<dto.Monhoc> l = new dal.MonhocDAL().getAll();
        List<String> lResult = new ArrayList<>();
        for (dto.Monhoc l1 : l) {
            lResult.add(l1.getTenMh());
        }
        return lResult;
    }

    public List<Map<String, ?>> dataReportBySubject(String subject, String schoolYear, int semester) {
        List<Map<String, ?>> lResult = new ArrayList<>();
        List<dto.Lop> lLop = new dal.LopDAL().getAll();
        dto.Monhoc monhoc=new dal.MonhocDAL().getByTen(subject);
        for (int i = 0; i < lLop.size() - 1; i++) {
            for (int j = i + 1; j < lLop.size(); j++) {
                if (lLop.get(j).getTenLop().compareToIgnoreCase(lLop.get(i).getTenLop()) < 0) {
                    Collections.swap(lLop, i, j);
                }
            }
        }
        List<dto.HocsinhLophoc> lHL = null;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, Object> mL = new HashMap<String, Object>();
            dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolYear);
            dto.Lop lop = new dal.LopDAL().getByTen(lLop.get(i).getTenLop());
            lHL = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lop);
            int summary = 0, reacted = 0;
            Double diem15, diem1, diemhk, dtb;
            for (dto.HocsinhLophoc lHL1 : lHL) {
                List<dto.Diem> lDiem = new dal.DiemDAL().getByHocSinhLopHocMonHoc(lHL1, monhoc);
                for (dto.Diem lDiem1 : lDiem) {
                    if (lDiem1.getHocky().getTenHocKy() == semester) {
                        summary++;
                        diem15 = lDiem1.getDiem15phut();
                        diem1 = lDiem1.getDiem1tiet();
                        diemhk = lDiem1.getDiemCuoiKy();
                        dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));
                        if (dtb >= bll.ConfigBLL.getBenchMarkSubject(monhoc)) {
                            reacted++;
                        }
                    }
                }
            }
            if (summary > 0) {
                mL.put("no", i + 1);
                mL.put("class", lLop.get(i).getTenLop());
                mL.put("summary", summary);
                mL.put("reacted", reacted);
                lResult.add(mL);
            }
        }
        return lResult;
    }

    public List<Map<String, ?>> dataReportBySemester(String schoolYear, int semester) {
        List<Map<String, ?>> lResult = new ArrayList<>();
        List<dto.Lop> lLop = new dal.LopDAL().getAll();
        dto.Hocky hocky=new dal.HockyDAL().getByTen(semester);
        for (int i = 0; i < lLop.size() - 1; i++) {
            for (int j = i + 1; j < lLop.size(); j++) {
                if (lLop.get(j).getTenLop().compareToIgnoreCase(lLop.get(i).getTenLop()) < 0) {
                    Collections.swap(lLop, i, j);
                }
            }
        }
        List<dto.HocsinhLophoc> hocsinhLophocs;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolYear);
            dto.Lop lop = new dal.LopDAL().getByTen(lLop.get(i).getTenLop());
            hocsinhLophocs = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lop);
            int summary = 0, reacted = 0;
            Double diem15, diem1, diemhk, dtb;
            boolean bReacted = true;
            for (dto.HocsinhLophoc hocsinhLophoc : hocsinhLophocs) {
                bReacted=false;
                List<dto.Diem> lDiem = new dal.DiemDAL().getByHocSinhLopHocHocKy(hocsinhLophoc, hocky);
                summary++;
                for (dto.Diem lDiem1 : lDiem) {
                    diem15 = lDiem1.getDiem15phut();
                    diem1 = lDiem1.getDiem1tiet();
                    diemhk = lDiem1.getDiemCuoiKy();
                    dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));
                    if (dtb < bll.ConfigBLL.getBenchMarkSubject(lDiem1.getMonhoc())) {
                        bReacted = false;
                    }
                }
                if (!bReacted) {
                    reacted++;
                }
            }
            if (summary > 0) {
                map.put("no", i + 1);
                map.put("class", lLop.get(i).getTenLop());
                map.put("summary", summary);
                map.put("reacted", reacted);
                lResult.add(map);
            }
        }
        return lResult;
    }
}
