/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.*;
import dto.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tan
 */
public class ScoreFrameBLL {

    public EditableTableModel getData(String tenLop, String monHoc, String namHoc, String hocKy) {
        dto.Namhoc namhoc = new NamhocDAL().getByTen(namHoc);
        dto.Lop lop = new LopDAL().getByTen(tenLop);
        dto.Monhoc monhoc = new MonhocDAL().getByTen(monHoc);
        dto.Hocky hocky = new dal.HockyDAL().getByTen(Integer.parseInt(hocKy));
        /*List<Diem> lhslhmh = new DiemDAL().getByLopHocHocKyMonHoc(lop, namhoc, hocky, monhoc);
         for (int j = 0; j < lhslhmh.size(); j++) {
         Map<String, Object> map = new HashMap<>();
         map.put("stt", data.size() + 1);
         map.put("tenhs", lhslhmh.get(j).getHocsinhLophoc().getHocsinh().getHoTen());
         map.put("diem15", lhslhmh.get(j).getDiem15phut() == null ? "" : lhslhmh.get(j).getDiem15phut());
         map.put("diem1", lhslhmh.get(j).getDiem1tiet() == null ? "" : lhslhmh.get(j).getDiem1tiet());
         map.put("diemck", lhslhmh.get(j).getDiemCuoiKy() == null ? "" : lhslhmh.get(j).getDiemCuoiKy());
         data.add(map);
         }*/
        List<dto.HocsinhLophoc> lhocsinhlophoc = new dal.HocsinhLophocDAL().getByNamHocLop(namhoc, lop);
        Object[][] data = new Object[lhocsinhlophoc.size()][5];
        for (int i = 0; i < lhocsinhlophoc.size(); i++) {
            dto.Diem diem = new dal.DiemDAL().getByLopHocHocKyMonHocHocSinh(lhocsinhlophoc.get(i), hocky, monhoc);
            String[] map = new String[5];
            map[0] = String.valueOf(i + 1);//.put("stt", i + 1);
            map[1] = lhocsinhlophoc.get(i).getHocsinh().getHoTen();
            map[2] = String.valueOf(diem == null ? "" : diem.getDiem15phut() == null ? "" : diem.getDiem15phut());
            map[3] = String.valueOf(diem == null ? "" : diem.getDiem1tiet() == null ? "" : diem.getDiem1tiet());
            map[4] = String.valueOf(diem == null ? "" : diem.getDiemCuoiKy() == null ? "" : diem.getDiemCuoiKy());

            data[i] = map;
        }
        return new EditableTableModel(data, new String[]{"STT", "Họ Tên", "Điểm 15'", "Điểm 1 tiết", "Điểm cuối kỳ"});
    }

    public boolean CreateListScore(Integer idHocSinhLopHoc) {
        try {
            dto.HocsinhLophoc hocsinhLophoc = new dal.HocsinhLophocDAL().get(idHocSinhLopHoc);
            List<dto.Hocky> hockys = new dal.HockyDAL().getAll();
            List<dto.Monhoc> monhocs = new dal.MonhocDAL().getByTinhTrang(true);
            for (Monhoc monhoc : monhocs) {
                for (Hocky hocky : hockys) {
                    new dal.DiemDAL().add(new dto.Diem(hocky, hocsinhLophoc, monhoc));
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Result DeleteListScoreIfNull(Integer idHocsinhLophoc) {
        try {
            dto.HocsinhLophoc hocsinhLophoc = new dal.HocsinhLophocDAL().get(idHocsinhLophoc);
            List<dto.Diem> diems = new dal.DiemDAL().getByHocSinhLopHoc(hocsinhLophoc);
            for (Diem diem : diems) {
                if (diem.getDiem15phut() != null || diem.getDiem1tiet() != null || diem.getDiemCuoiKy() != null) {
                    return Result.FAILURE;
                }
            }
            for (Diem diem : diems) {
                new dal.DiemDAL().delete(diem.getIdDiem());
            }
        } catch (Exception e) {
            return Result.ERROR;
        }
        return Result.SUCCESS;
    }

    private static class EditableTableModel extends DefaultTableModel {

        boolean[] columnEditable;

        public EditableTableModel() {
        }

        private EditableTableModel(Object[][] data, String[] string) {
            super(data, string);
            columnEditable = new boolean[string.length];
            Arrays.fill(columnEditable, true);

            setColumnEditable(0, false);
            setColumnEditable(1, false);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (!columnEditable[column]) {
                return false;
            } else {
                return super.isCellEditable(row, column);
            }
        }

        public void setColumnEditable(int column, boolean editable) {
            columnEditable[column] = editable;
        }

        public boolean getColumnEditable(int column) {
            return columnEditable[column];
        }
    }
}
