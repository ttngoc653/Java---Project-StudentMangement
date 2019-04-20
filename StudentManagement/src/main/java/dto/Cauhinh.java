package dto;
// Generated Apr 21, 2019 1:19:18 AM by Hibernate Tools 4.3.1


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
 * Cauhinh generated by hbm2java
 */
@Entity
@Table(name="cauhinh"
    ,catalog="quanlyhocsinh"
)
public class Cauhinh  implements java.io.Serializable {


     private Integer idCauHinh;
     private String tenThuocTinh;
     private String loaiThuocTinh;
     private String giaTri;
     private String tenDayDu;
     private Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs = new HashSet<ChitietCauhinhHocsinh>(0);
     private Set<ChitietCauhinhLop> chitietCauhinhLops = new HashSet<ChitietCauhinhLop>(0);
     private Set<ChitietCauhinhDiem> chitietCauhinhDiems = new HashSet<ChitietCauhinhDiem>(0);

    public Cauhinh() {
    }

	
    public Cauhinh(String tenThuocTinh, String giaTri) {
        this.tenThuocTinh = tenThuocTinh;
        this.giaTri = giaTri;
    }
    public Cauhinh(String tenThuocTinh, String loaiThuocTinh, String giaTri, String tenDayDu, Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs, Set<ChitietCauhinhLop> chitietCauhinhLops, Set<ChitietCauhinhDiem> chitietCauhinhDiems) {
       this.tenThuocTinh = tenThuocTinh;
       this.loaiThuocTinh = loaiThuocTinh;
       this.giaTri = giaTri;
       this.tenDayDu = tenDayDu;
       this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
       this.chitietCauhinhLops = chitietCauhinhLops;
       this.chitietCauhinhDiems = chitietCauhinhDiems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCauHinh", unique=true, nullable=false)
    public Integer getIdCauHinh() {
        return this.idCauHinh;
    }
    
    public void setIdCauHinh(Integer idCauHinh) {
        this.idCauHinh = idCauHinh;
    }

    
    @Column(name="TenThuocTinh", nullable=false, length=45)
    public String getTenThuocTinh() {
        return this.tenThuocTinh;
    }
    
    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }

    
    @Column(name="LoaiThuocTinh", length=45)
    public String getLoaiThuocTinh() {
        return this.loaiThuocTinh;
    }
    
    public void setLoaiThuocTinh(String loaiThuocTinh) {
        this.loaiThuocTinh = loaiThuocTinh;
    }

    
    @Column(name="GiaTri", nullable=false, length=45)
    public String getGiaTri() {
        return this.giaTri;
    }
    
    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    
    @Column(name="TenDayDu", length=45)
    public String getTenDayDu() {
        return this.tenDayDu;
    }
    
    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cauhinh")
    public Set<ChitietCauhinhHocsinh> getChitietCauhinhHocsinhs() {
        return this.chitietCauhinhHocsinhs;
    }
    
    public void setChitietCauhinhHocsinhs(Set<ChitietCauhinhHocsinh> chitietCauhinhHocsinhs) {
        this.chitietCauhinhHocsinhs = chitietCauhinhHocsinhs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cauhinh")
    public Set<ChitietCauhinhLop> getChitietCauhinhLops() {
        return this.chitietCauhinhLops;
    }
    
    public void setChitietCauhinhLops(Set<ChitietCauhinhLop> chitietCauhinhLops) {
        this.chitietCauhinhLops = chitietCauhinhLops;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cauhinh")
    public Set<ChitietCauhinhDiem> getChitietCauhinhDiems() {
        return this.chitietCauhinhDiems;
    }
    
    public void setChitietCauhinhDiems(Set<ChitietCauhinhDiem> chitietCauhinhDiems) {
        this.chitietCauhinhDiems = chitietCauhinhDiems;
    }




}


