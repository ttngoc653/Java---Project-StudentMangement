/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.DiemDAL;
import dal.HockyDAL;
import dal.HocsinhLophocDAL;
import dal.LopDAL;
import dal.MonhocDAL;
import dal.NamhocDAL;
import dto.*;
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
        List<Hocky> l = new HockyDAL().getAll();
        List<Integer> lResult = new ArrayList<>();
        for (Hocky l1 : l) {
            lResult.add(l1.getTenHocKy());
        }
        return lResult;
    }

    public List<String> listSchoolYearName() {
        List<Namhoc> l = new NamhocDAL().getAll();
        List<String> lResult = new ArrayList<>();
        for (int i = l.size(); i >= 0; i--) {
            lResult.add(l.get(i).getTenNamHoc());
        }
        return lResult;
    }

    public List<String> listSubjectName() {
        List<Monhoc> l = new MonhocDAL().getAll();
        List<String> lResult = new ArrayList<>();
        for (Monhoc l1 : l) {
            lResult.add(l1.getTenMh());
        }
        return lResult;
    }

    public List<Map<String, ?>> dataReportBySubject(String subject, String schoolYear, int semester) {
        List<Map<String, ?>> lResult = new ArrayList<>();
        List<Lop> lLop = new LopDAL().getAll();
        for (int i = 0; i < lLop.size() - 1; i++) {
            for (int j = i + 1; j < lLop.size(); j++) {
                if (lLop.get(j).getTenLop().compareToIgnoreCase(lLop.get(i).getTenLop()) < 0) {
                    Collections.swap(lLop, i, j);
                }
            }
        }
        List<HocsinhLophoc> lHL = null;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, Object> mL = new HashMap<String, Object>();
            lHL = new HocsinhLophocDAL().getByNamHocLop(new Namhoc(schoolYear), new Lop(lLop.get(i).getTenLop(), lLop.get(i).getKhoi()));
            int summary = 0, reacted = 0;
            Double diem15, diem1, diemhk, dtb;
            for (HocsinhLophoc lHL1 : lHL) {
                List<Diem> lDiem = new DiemDAL().getByHocSinhLopHocMonHoc(new HocsinhLophocDAL().get(new HocsinhLophocId(lHL1.getHocsinh().getIdHocSinh(), lLop.get(i).getIdLop(), new NamhocDAL().getByTen(schoolYear).getIdNamHoc())), new MonhocDAL().getByTen(subject));
                for (Diem lDiem1 : lDiem) {
                    if (lDiem1.getHocky().getTenHocKy() == semester) {
                        summary++;
                        diem15 = lDiem1.getDiem15Phut();
                        diem1 = lDiem1.getDiem1Tiet();
                        diemhk = lDiem1.getDiemCuoiKy();
                        dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));
                        if (dtb >= 5) {
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
        List<Lop> lLop = new LopDAL().getAll();
        for (int i = 0; i < lLop.size() - 1; i++) {
            for (int j = i + 1; j < lLop.size(); j++) {
                if (lLop.get(j).getTenLop().compareToIgnoreCase(lLop.get(i).getTenLop()) < 0) {
                    Collections.swap(lLop, i, j);
                }
            }
        }
        List<HocsinhLophoc> lHL;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, Object> mL = new HashMap<String, Object>();
            lHL = new HocsinhLophocDAL().getByNamHocLop(new Namhoc(schoolYear), new Lop(lLop.get(i).getTenLop(), lLop.get(i).getKhoi()));
            int summary = 0, reacted = 0;
            Double diem15, diem1, diemhk, dtb;
            boolean bReacted = true;
            for (HocsinhLophoc lHL1 : lHL) {
                List<Diem> lDiem = new DiemDAL().getByHocSinhLopHocHocKy(lHL1, new HockyDAL().getByTen(semester));
                summary++;
                for (Diem lDiem1 : lDiem) {
                    diem15 = lDiem1.getDiem15Phut();
                    diem1 = lDiem1.getDiem1Tiet();
                    diemhk = lDiem1.getDiemCuoiKy();
                    dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));
                    if (dtb < 5) {
                        bReacted = false;
                    }
                }
                if (!bReacted) {
                    reacted++;
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
}
