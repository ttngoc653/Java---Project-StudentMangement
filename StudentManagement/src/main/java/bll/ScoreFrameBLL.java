/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.*;
import dto.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tan
 */
public class ScoreFrameBLL {

    public DefaultTableModel getData(String tenLop, String monHoc, String namHoc, String hocKy) {
        List<Map<String, ?>> data = new ArrayList<>();
        dto.Namhoc namhoc = new NamhocDAL().getByTen(namHoc);
        dto.Lop lop = new LopDAL().getByTen(tenLop);
        dto.Monhoc monhoc = new MonhocDAL().getByTen(monHoc);
        dto.Hocky hocky = new dal.HockyDAL().getByTen(Integer.parseInt(hocKy));
        List<Diem> lhslhmh = new DiemDAL().getByLopHocHocKyMonHoc(lop, namhoc, hocky, monhoc);
        for (int j = 0; j < lhslhmh.size(); j++) {
            Map<String, Object> map = new HashMap<>();
            map.put("stt", data.size() + 1);
            map.put("tenhs", lhslhmh.get(j).getHocsinhLophoc().getHocsinh().getHoTen());
            map.put("diem15", lhslhmh.get(j).getDiem15phut() == null ? "" : lhslhmh.get(j).getDiem15phut());
            map.put("diem1", lhslhmh.get(j).getDiem1tiet() == null ? "" : lhslhmh.get(j).getDiem1tiet());
            map.put("diemck", lhslhmh.get(j).getDiemCuoiKy() == null ? "" : lhslhmh.get(j).getDiemCuoiKy());
            data.add(map);
        }

        DefaultTableModel dtm = new DefaultTableModel();
        for (int i = 0; i < data.size(); i++) {
            dtm.addRow(new Object[]{data.get(i).get("stt"), data.get(i).get("tenhs"), data.get(i).get("diem15"), data.get(i).get("diem1"), data.get(i).get("diemck")});
        }
        return dtm;
    }
}
