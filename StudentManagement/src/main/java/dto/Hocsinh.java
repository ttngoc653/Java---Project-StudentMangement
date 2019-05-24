package dto;
// Generated May 24, 2019 9:44:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Hocsinh generated by hbm2java
 */
public class Hocsinh  implements java.io.Serializable {


     private Integer idHocSinh;
     private String hoTen;
     private String ngaySinh;
     private String email;
     private String gioiTinh;
     private String diaChi;
     private String sdtCaNhan;
     private String sdtGiamHo;
     private byte tinhTrang;
     private Set<HocsinhLophoc> hocsinhLophocs = new HashSet<HocsinhLophoc>(0);
     private Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs = new HashSet<ChitietCauhinhHocsinh>(0);

    public Hocsinh() {
    }

	
    public Hocsinh(String hoTen, String ngaySinh, String gioiTinh, String diaChi, byte tinhTrang) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
    }
    public Hocsinh(String hoTen, String ngaySinh, String email, String gioiTinh, String diaChi, String sdtCaNhan, String sdtGiamHo, byte tinhTrang, Set<HocsinhLophoc> hocsinhLophocs, Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs) {
       this.hoTen = hoTen;
       this.ngaySinh = ngaySinh;
       this.email = email;
       this.gioiTinh = gioiTinh;
       this.diaChi = diaChi;
       this.sdtCaNhan = sdtCaNhan;
       this.sdtGiamHo = sdtGiamHo;
       this.tinhTrang = tinhTrang;
       this.hocsinhLophocs = hocsinhLophocs;
       this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
    }
   
    public Integer getIdHocSinh() {
        return this.idHocSinh;
    }
    
    public void setIdHocSinh(Integer idHocSinh) {
        this.idHocSinh = idHocSinh;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSdtCaNhan() {
        return this.sdtCaNhan;
    }
    
    public void setSdtCaNhan(String sdtCaNhan) {
        this.sdtCaNhan = sdtCaNhan;
    }
    public String getSdtGiamHo() {
        return this.sdtGiamHo;
    }
    
    public void setSdtGiamHo(String sdtGiamHo) {
        this.sdtGiamHo = sdtGiamHo;
    }
    public byte getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Set<HocsinhLophoc> getHocsinhLophocs() {
        return this.hocsinhLophocs;
    }
    
    public void setHocsinhLophocs(Set<HocsinhLophoc> hocsinhLophocs) {
        this.hocsinhLophocs = hocsinhLophocs;
    }
    public Set<ChitietCauhinhHocsinh> getChitietCauhinhHocsinhs() {
        return this.chitietCauhinhHocsinhs;
    }
    
    public void setChitietCauhinhHocsinhs(Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs) {
        this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
    }




}


