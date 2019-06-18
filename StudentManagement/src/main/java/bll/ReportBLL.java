package bll;

import dto.Diem;
import dto.Lop;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
        dto.Hocky hocky = new dal.HockyDAL().getByTen(semester);

        List<dto.HocsinhLophoc> lHL = null;
        for (int i = 0; i < lLop.size(); i++) {
            Map<String, String> mL = new HashMap<String, String>();
            lHL = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lLop.get(i));
            int summary = 0, reacted = 0;
            Double diem15, diem1, diemhk, dtb;
            for (dto.HocsinhLophoc lHL1 : lHL) {
                Diem diem = new dal.DiemDAL().getByLopHocHocKyMonHocHocSinh(lHL1, hocky, monhoc);
                if(diem!=null) {
                    summary++;
                    diem15 = diem.getDiem15phut();
                    diem1 = diem.getDiem1tiet();
                    diemhk = diem.getDiemCuoiKy();
                    dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / ((diem15 != null ? 1 : 0) + (diem1 != null ? 2 : 0) + (diemhk != null ? 3 : 0));
                    if (dtb >= bll.ConfigBLL.getBenchMark(monhoc)) {
                        reacted++;
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

                        if (dtb < bll.ConfigBLL.getBenchMark(lDiem1.getMonhoc())) {
                            bReacted = false;
                        }
                    }

                    summary++;
                    if (bReacted && (tongdiemHK / sum_heso) >= bll.ConfigBLL.getBenchMark(lLop.get(i))) {
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

    public Result dataReportCardBySemester(int keyStudent, String schoolYear, String semester, String grade) {
        dto.Hocsinh hocsinh = new dal.HocsinhDAL().getById(keyStudent);
        dto.Namhoc namhoc = new dal.NamhocDAL().getByTen(schoolYear);
        dto.Hocky hocky = new dal.HockyDAL().getByTen(Integer.parseInt(semester));
        dto.Lop lop = new dal.LopDAL().getByTen(grade);
        dto.HocsinhLophoc hocsinhLophoc = new dal.HocsinhLophocDAL().getByNamHocLopHocSinh(namhoc, lop, hocsinh);
        List<dto.Diem> diems = new dal.DiemDAL().getByHocSinhLopHocHocKy(hocsinhLophoc, hocky);

        /*
         Parameter:  schoolyear  semester    grade   studentname studentkey  studentsex  studentdob  mediumscore summaryresult
         Field:   no subject score15 score1  scorefinish scoresummary    resurt 
         */
        Double diem15, diem1, diemhk, dtb, tongdiemHK = 0D, sum_heso = 0D;
        boolean bReacted = true;
        List<Map<String, ?>> lResult = new ArrayList<>();
        for (int i = 0; i < diems.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            diem15 = diems.get(i).getDiem15phut();
            diem1 = diems.get(i).getDiem1tiet();
            diemhk = diems.get(i).getDiemCuoiKy();
            dtb = ((diem15 != null ? diem15 : 0) + (diem1 != null ? diem1 : 0) * 2 + (diemhk != null ? diemhk : 0) * 3) / 6;

            tongdiemHK += dtb * diems.get(i).getMonhoc().getHeSo();
            sum_heso += diems.get(i).getMonhoc().getHeSo();

            if (dtb < bll.ConfigBLL.getBenchMark(diems.get(i).getMonhoc())) {
                bReacted = false;
            }
            map.put("no", i + 1);
            map.put("subject", diems.get(i).getMonhoc().getTenMh());
            map.put("score15", diem15 != null ? diem15 : "");
            map.put("score1", diem1 != null ? diem1 : "");
            map.put("scorefinish", diemhk != null ? diemhk : "");
            map.put("scoresummary", (double) Math.round(dtb * 100) / 100);
            map.put("result", bll.ConfigBLL.getBenchMark(diems.get(i).getMonhoc()) <= dtb ? "Đạt" : "Rớt");

            lResult.add(map);
        }
        if (lResult.isEmpty()) {
            return Result.EMPTY;
        } else if (bReacted && tongdiemHK / sum_heso < bll.ConfigBLL.getBenchMark(lop)) {
            bReacted = false;
        }
        JRDataSource jrSource = new JRBeanCollectionDataSource(lResult);

        HashMap param = new HashMap();
        param.put("schoolyear", schoolYear);
        param.put("semester", semester);
        param.put("grade", grade);
        param.put("studentname", hocsinh.getHoTen());
        param.put("studentkey", hocsinh.getIdHocSinh());
        param.put("studentsex", hocsinh.getGioiTinh());
        param.put("studentdob", hocsinh.getNgaySinh());
        param.put("mediumscore", (double) Math.round(tongdiemHK / sum_heso * 100) / 100);
        param.put("summaryresult", bReacted ? "Đạt" : "Không đạt");

        try {
            JasperReport jR = JasperCompileManager.compileReport("src/main/java/gui/SummaryStudentScoreAccordingToSemester.jrxml");
            JasperPrint jP = JasperFillManager.fillReport(jR, param, jrSource);
            JasperExportManager.exportReportToPdf(jP);
            JasperViewer.viewReport(jP, false);
        } catch (JRException ex) {
            ex.printStackTrace();
            return Result.ERROR;
        }
        return Result.SUCCESS;
    }

    public ComboBoxModel listGrade() {
        List<dto.Lop> list=new dal.LopDAL().getAll();
        List<String> output=new ArrayList<>();
        for (Lop list1 : list) {
            output.add(list1.getTenLop());
        }
        
        return (ComboBoxModel) output;
    }

}
