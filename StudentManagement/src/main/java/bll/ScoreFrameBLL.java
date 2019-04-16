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

/**
 *
 * @author Tan
 */
public class ScoreFrameBLL {

    public List<Map<String, ?>> getData(String tenLop, String monHoc, String namHoc, String hocKy) {
        List<Map<String, ?>> data = new ArrayList<>();
        List<HocsinhLophoc> lhslh = new HocsinhLophocDAL().getByNamHocLop(new NamhocDAL().getByTen(namHoc), new LopDAL().getByTen(tenLop));

        for (int i = 0; i < lhslh.size(); i++) {
            List<Diem> lhslhmh = new DiemDAL().getByHocSinhLopHocMonHoc(lhslh.get(i), new MonhocDAL().getByTen(monHoc));
            for (int j = 0; j < lhslhmh.size(); j++) {
                if (lhslhmh.get(j).getHocky().getTenHocKy() == Integer.parseInt(hocKy)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("stt", data.size() + 1);
                    map.put("tenhs", lhslh.get(i).getHocsinh().getHoTen());
                    map.put("diem15", lhslhmh.get(j).getDiem15Phut() == null ? "" : lhslhmh.get(j).getDiem15Phut());
                    map.put("diem1", lhslhmh.get(j).getDiem1Tiet() == null ? "" : lhslhmh.get(j).getDiem1Tiet());
                    map.put("diemck", lhslhmh.get(j).getDiemCuoiKy() == null ? "" : lhslhmh.get(j).getDiemCuoiKy());
                    data.add(map);
                    break;
                } else if (lhslhmh.size() == j + 1) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("stt", data.size() + 1);
                    map.put("tenhs", lhslh.get(i).getHocsinh().getHoTen());
                    map.put("diem15", "");
                    map.put("diem1", "");
                    map.put("diemck", "");
                    data.add(map);
                }
            }
        }

        return data;
    }
}
