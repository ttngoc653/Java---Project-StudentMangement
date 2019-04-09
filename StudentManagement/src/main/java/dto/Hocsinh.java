package dto;
// Generated Apr 9, 2019 10:15:09 AM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private Byte tinhTrang;
    private Set<HocsinhLophoc> hocsinhLophocs = new HashSet<HocsinhLophoc>(0);
     private Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs = new HashSet<ChitietCauhinhHocsinh>(0);

    public Hocsinh() {
        this.idHocSinh = null;
        this.hoTen = "";
        this.ngaySinh = null;
        this.email = "";
        this.gioiTinh = "";
        this.diaChi = "";
        this.sdtCaNhan = "";
        this.sdtGiamHo = "";
        this.tinhTrang = null;
        this.hocsinhLophocs = new HashSet<>(0);
        this.chitietCauhinhHocsinhs = new HashSet<>(0);
    }

	
    public Hocsinh(String hoTen, String ngaySinh, String gioiTinh, String diaChi, byte tinhTrang) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
    }
    public Hocsinh(String hoTen, String ngaySinh, String email, String gioiTinh, String diaChi, String sdtCaNhan, String sdtGiamHo, byte tinhTrang, Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs, Set<HocsinhLophoc> hocsinhLophocs) {
       this.hoTen = hoTen;
       this.ngaySinh = ngaySinh;
       this.email = email;
       this.gioiTinh = gioiTinh;
       this.diaChi = diaChi;
       this.sdtCaNhan = sdtCaNhan;
       this.sdtGiamHo = sdtGiamHo;
       this.tinhTrang = tinhTrang;
       this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
       this.hocsinhLophocs = hocsinhLophocs;
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
    public Set<ChitietCauhinhHocsinh> getChitietCauhinhHocsinhs() {
        return this.chitietCauhinhHocsinhs;
    }
    
    public void setChitietCauhinhHocsinhs(Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs) {
        this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hocsinh")
    public Set<HocsinhLophoc> getHocsinhLophocs() {
        return this.hocsinhLophocs;
    }
    
    public void setHocsinhLophocs(Set<HocsinhLophoc> hocsinhLophocs) {
        this.hocsinhLophocs = hocsinhLophocs;
    }

	@OneToMany
    public List<HocsinhLophoc> getHocsinhLophocl() {
        return new ArrayList<HocsinhLophoc>(this.hocsinhLophocs);
    }

    public void setHocsinhLophocl(List<HocsinhLophoc> hocsinhLophocl) {
        this.hocsinhLophocs = new HashSet<HocsinhLophoc>(hocsinhLophocl);
    }

    @OneToMany
    public List<ChitietCauhinhHocsinh> getChitietCauhinhHocsinhl() {
        return new ArrayList<ChitietCauhinhHocsinh>(this.chitietCauhinhHocsinhs);
    }

    public void setChitietCauhinhHocsinhl(List<ChitietCauhinhHocsinh> chitietCauhinhHocsinhl) {
        this.chitietCauhinhHocsinhs = new HashSet<ChitietCauhinhHocsinh>(chitietCauhinhHocsinhl);
    }

    public boolean equals(Hocsinh obj) {
        return Objects.equals(obj.idHocSinh, this.idHocSinh) || this.hoTen.equals(obj.hoTen);
    }

}
