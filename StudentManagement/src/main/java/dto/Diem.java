package dto;
// Generated Apr 9, 2019 10:15:09 AM by Hibernate Tools 4.3.1


import java.util.ArrayList;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Diem generated by hbm2java
 */
@Entity
@Table(name="diem"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames={"idHocSinh", "idNamHoc", "idHocKy", "idMonHoc"}) 
)
public class Diem  implements java.io.Serializable {

    private Integer idDiem = null;
    private Hocky hocky = null;
    private HocsinhLophoc hocsinhLophoc = null;
    private Monhoc monhoc = null;
    private Double diem15phut = null;
    private Double diem1tiet = null;
    private Double diemCuoiKy = null;
     private Set<ChitietCauhinhDiem> chitietCauhinhDiems = new HashSet<ChitietCauhinhDiem>(0);

    public Diem() {
    }

	
    public Diem(Hocky hocky, HocsinhLophoc hocsinhLophoc, Monhoc monhoc) {
        this.hocky = hocky;
        this.hocsinhLophoc = hocsinhLophoc;
        this.monhoc = monhoc;
    }
    public Diem(Hocky hocky, HocsinhLophoc hocsinhLophoc, Monhoc monhoc, Double diem15phut, Double diem1tiet, Double diemCuoiKy, Set<ChitietCauhinhDiem> chitietCauhinhDiems) {
        this.hocky = hocky;
        this.hocsinhLophoc = hocsinhLophoc;
        this.monhoc = monhoc;
        this.diem15phut = diem15phut;
        this.diem1tiet = diem1tiet;
        this.diemCuoiKy = diemCuoiKy;
        this.chitietCauhinhDiems = chitietCauhinhDiems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDiem", unique=true, nullable=false)
    public Integer getIdDiem() {
        return this.idDiem;
    }
    
    public void setIdDiem(Integer idDiem) {
        this.idDiem = idDiem;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idHocKy", nullable=false)
    public Hocky getHocky() {
        return this.hocky;
    }
    
    public void setHocky(Hocky hocky) {
        this.hocky = hocky;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="idHocSinh", referencedColumnName="idHocSinh", nullable=false), 
        @JoinColumn(name="idNamHoc", referencedColumnName="idLopHoc", nullable=false), 
        @JoinColumn(name="idLop", referencedColumnName="idNamHoc", nullable=false) } )
    public HocsinhLophoc getHocsinhLophoc() {
        return this.hocsinhLophoc;
    }
    
    public void setHocsinhLophoc(HocsinhLophoc hocsinhLophoc) {
        this.hocsinhLophoc = hocsinhLophoc;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMonHoc", nullable=false)
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    
    @Column(name = "15Phut", precision = 22, scale = 0)
    public Double getDiem15phut() {
        return this.diem15phut;
    }

    public void setDiem15phut(Double diem15phut) {
        this.diem15phut = diem15phut;
    }

    @Column(name = "1Tiet", precision = 22, scale = 0)
    public Double getDiem1tiet() {
        return this.diem1tiet;
    }

    public void setDiem1tiet(Double diem1tiet) {
        this.diem1tiet = diem1tiet;
    }

    @Column(name = "CuoiKy", precision = 22, scale = 0)
    public Double getDiemCuoiKy() {
        return this.diemCuoiKy;
    }

    public void setDiemCuoiKy(Double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="diem")
    public Set<ChitietCauhinhDiem> getChitietCauhinhDiems() {
        return this.chitietCauhinhDiems;
    }
    
    public void setChitietCauhinhDiems(Set<ChitietCauhinhDiem> chitietCauhinhDiems) {
        this.chitietCauhinhDiems = chitietCauhinhDiems;
    }

@OneToMany
    public List<ChitietCauhinhDiem> getChitietCauhinhDieml() {
        return new ArrayList<>(this.chitietCauhinhDiems);
    }

    public void setChitietCauhinhDieml(List<ChitietCauhinhDiem> chitietCauhinhDieml) {
        this.chitietCauhinhDiems = new HashSet<>(chitietCauhinhDieml);
    }

    // so sanh theo Id
    public boolean equals(Diem obj) {
        return Objects.equals(obj.idDiem, this.idDiem);
    }

}