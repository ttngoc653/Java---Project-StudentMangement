package hibernate;
// Generated Mar 23, 2019 12:36:47 AM by Hibernate Tools 4.3.1


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
import javax.persistence.UniqueConstraint;

/**
 * Namhoc generated by hbm2java
 */
@Entity
@Table(name="namhoc"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames="TenNamHoc") 
)
public class Namhoc  implements java.io.Serializable {


     private Integer idNamHoc;
     private String tenNamHoc;
     private Set<HocsinhLophoc> hocsinhLophocs = new HashSet<HocsinhLophoc>(0);
     private Set<ChitietCauhinhLop> chitietCauhinhLops = new HashSet<ChitietCauhinhLop>(0);

    public Namhoc() {
    }

	
    public Namhoc(String tenNamHoc) {
        this.tenNamHoc = tenNamHoc;
    }
    public Namhoc(String tenNamHoc, Set<HocsinhLophoc> hocsinhLophocs, Set<ChitietCauhinhLop> chitietCauhinhLops) {
       this.tenNamHoc = tenNamHoc;
       this.hocsinhLophocs = hocsinhLophocs;
       this.chitietCauhinhLops = chitietCauhinhLops;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idNamHoc", unique=true, nullable=false)
    public Integer getIdNamHoc() {
        return this.idNamHoc;
    }
    
    public void setIdNamHoc(Integer idNamHoc) {
        this.idNamHoc = idNamHoc;
    }

    
    @Column(name="TenNamHoc", unique=true, nullable=false, length=45)
    public String getTenNamHoc() {
        return this.tenNamHoc;
    }
    
    public void setTenNamHoc(String tenNamHoc) {
        this.tenNamHoc = tenNamHoc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="namhoc")
    public Set<HocsinhLophoc> getHocsinhLophocs() {
        return this.hocsinhLophocs;
    }
    
    public void setHocsinhLophocs(Set<HocsinhLophoc> hocsinhLophocs) {
        this.hocsinhLophocs = hocsinhLophocs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="namhoc")
    public Set<ChitietCauhinhLop> getChitietCauhinhLops() {
        return this.chitietCauhinhLops;
    }
    
    public void setChitietCauhinhLops(Set<ChitietCauhinhLop> chitietCauhinhLops) {
        this.chitietCauhinhLops = chitietCauhinhLops;
    }




}

