package dto;
// Generated May 24, 2019 11:31:06 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hocsinh generated by hbm2java
 */
@Entity
@Table(name="hocsinh"
    ,catalog="quanlyhocsinh"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idHocSinh", unique=true, nullable=false)
    public Integer getIdHocSinh() {
        return this.idHocSinh;
    }
    
    public void setIdHocSinh(Integer idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    
    @Column(name="HoTen", nullable=false, length=45)
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    
    @Column(name="NgaySinh", nullable=false, length=12)
    public String getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    @Column(name="Email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="GioiTinh", nullable=false, length=45)
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    
    @Column(name="DiaChi", nullable=false, length=200)
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
    @Column(name="sdtCaNhan", length=16)
    public String getSdtCaNhan() {
        return this.sdtCaNhan;
    }
    
    public void setSdtCaNhan(String sdtCaNhan) {
        this.sdtCaNhan = sdtCaNhan;
    }

    
    @Column(name="sdtGiamHo", length=16)
    public String getSdtGiamHo() {
        return this.sdtGiamHo;
    }
    
    public void setSdtGiamHo(String sdtGiamHo) {
        this.sdtGiamHo = sdtGiamHo;
    }

    
    @Column(name="TinhTrang", nullable=false)
    public byte getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hocsinh")
    public Set<HocsinhLophoc> getHocsinhLophocs() {
        return this.hocsinhLophocs;
    }
    
    public void setHocsinhLophocs(Set<HocsinhLophoc> hocsinhLophocs) {
        this.hocsinhLophocs = hocsinhLophocs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hocsinh")
    public Set<ChitietCauhinhHocsinh> getChitietCauhinhHocsinhs() {
        return this.chitietCauhinhHocsinhs;
    }
    
    public void setChitietCauhinhHocsinhs(Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs) {
        this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
    }




}


