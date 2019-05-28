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
        dto.Monhoc monhoc = new dal.MonhocDAL().getByTen(subject);
        dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolYear);

        List<dto.HocsinhLophoc> lHL = null;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, String> mL = new HashMap<String, String>();
            lHL = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lLop.get(i));
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
                mL.put("no", String.valueOf(i + 1));
                mL.put("className", lLop.get(i).getTenLop());
                mL.put("summary", String.valueOf(summary));
                mL.put("reached", String.valueOf(reacted));
                mL.put("radio", String.valueOf(Math.round(reacted / summary * 10000) / 100) + "%");
                lResult.add(mL);
            }
        }
        return lResult;
    }

    public List<Map<String, ?>> dataReportBySemester(String schoolYear, int semester) {
        List<Map<String, ?>> lResult = new ArrayList<>();
        List<dto.Lop> lLop = new dal.LopDAL().getAll();
        dto.Hocky hocky = new dal.HockyDAL().getByTen(semester);
        List<dto.HocsinhLophoc> hocsinhLophocs;
        dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolYear);
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            hocsinhLophocs = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lLop.get(i));
            int summary = 0, reacted = 0, sum_heso = 0;
            Double diem15, diem1, diemhk, dtb, tongdiemHK;
            boolean bReacted = true;
            for (dto.HocsinhLophoc hocsinhLophoc : hocsinhLophocs) {
                bReacted = true;
                tongdiemHK = 0D;
                sum_heso = 0;

                List<dto.Diem> lDiem = new dal.DiemDAL().getByHocSinhLopHocHocKy(hocsinhLophoc, hocky);
                for (int j = 0; j < lDiem.size(); j++) {
                    if (lDiem.get(j).getDiem15phut() == null && lDiem.get(j).getDiem1tiet() == null && lDiem.get(j).getDiemCuoiKy() == null) {
                        lDiem.remove(j);
                        j--;
                    }
                }
                if (lDiem.size() > 0) {
                    for (dto.Diem lDiem1 : lDiem) {
                        diem15 = lDiem1.getDiem15phut();
                        diem1 = lDiem1.getDiem1tiet();
                        diemhk = lDiem1.getDiemCuoiKy();
                        dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));

                        tongdiemHK += dtb * lDiem1.getMonhoc().getHeSo();
                        sum_heso += lDiem1.getMonhoc().getHeSo();

                        if (dtb < bll.ConfigBLL.getBenchMarkSubject(lDiem1.getMonhoc())) {
                            bReacted = false;
                        }
                    }

                    summary++;
                    if (bReacted && (tongdiemHK / sum_heso) >= bll.ConfigBLL.getBenchMarkClass(lLop.get(i))) {
                        reacted++;
                    }
                }
            }
            if (summary > 0) {
                map.put("no", String.valueOf(i + 1));
                map.put("class", lLop.get(i).getTenLop());
                map.put("summary", String.valueOf(summary));
                map.put("reached", String.valueOf(reacted));
                map.put("radio", String.valueOf(Math.round(reacted / summary * 10000) / 100) + "%");
                lResult.add(map);
            }
        }
        return lResult;
    }
}
