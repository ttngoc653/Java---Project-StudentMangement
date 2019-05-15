package dto;
// Generated May 16, 2019 1:50:36 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * HocsinhLophoc generated by hbm2java
 */
@Entity
@Table(name="hocsinh_lophoc"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames={"idHocSinh", "idNamHoc"}) 
)
public class HocsinhLophoc  implements java.io.Serializable {


     private Integer idHocSinhLopHoc;
     private Hocsinh hocsinh;
     private Lop lop;
     private Namhoc namhoc;
     private Set<Diem> diems = new HashSet<Diem>(0);

    public HocsinhLophoc() {
    }

	
    public HocsinhLophoc(Hocsinh hocsinh, Lop lop, Namhoc namhoc) {
        this.hocsinh = hocsinh;
        this.lop = lop;
        this.namhoc = namhoc;
    }
    public HocsinhLophoc(Hocsinh hocsinh, Lop lop, Namhoc namhoc, Set<Diem> diems) {
       this.hocsinh = hocsinh;
       this.lop = lop;
       this.namhoc = namhoc;
       this.diems = diems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idHocSinhLopHoc", unique=true, nullable=false)
    public Integer getIdHocSinhLopHoc() {
        return this.idHocSinhLopHoc;
    }
    
    public void setIdHocSinhLopHoc(Integer idHocSinhLopHoc) {
        this.idHocSinhLopHoc = idHocSinhLopHoc;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idHocSinh", nullable=false)
    public Hocsinh getHocsinh() {
        return this.hocsinh;
    }
    
    public void setHocsinh(Hocsinh hocsinh) {
        this.hocsinh = hocsinh;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idLopHoc", nullable=false)
    public Lop getLop() {
        return this.lop;
    }
    
    public void setLop(Lop lop) {
        this.lop = lop;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idNamHoc", nullable=false)
    public Namhoc getNamhoc() {
        return this.namhoc;
    }
    
    public void setNamhoc(Namhoc namhoc) {
        this.namhoc = namhoc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hocsinhLophoc")
    public Set<Diem> getDiems() {
        return this.diems;
    }
    
    public void setDiems(Set<Diem> diems) {
        this.diems = diems;
    }




}


