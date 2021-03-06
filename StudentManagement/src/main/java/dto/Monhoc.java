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
import javax.persistence.UniqueConstraint;

/**
 * Monhoc generated by hbm2java
 */
@Entity
@Table(name="monhoc"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames="TenMH") 
)
public class Monhoc  implements java.io.Serializable {


     private Integer idMonHoc;
     private String tenMh;
     private int heSo;
     private boolean dangGiangDay;
     private Set<Diem> diems = new HashSet<Diem>(0);

    public Monhoc() {
    }

	
    public Monhoc(String tenMh, int heSo, boolean dangGiangDay) {
        this.tenMh = tenMh;
        this.heSo = heSo;
        this.dangGiangDay = dangGiangDay;
    }
    public Monhoc(String tenMh, int heSo, boolean dangGiangDay, Set<Diem> diems) {
       this.tenMh = tenMh;
       this.heSo = heSo;
       this.dangGiangDay = dangGiangDay;
       this.diems = diems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idMonHoc", unique=true, nullable=false)
    public Integer getIdMonHoc() {
        return this.idMonHoc;
    }
    
    public void setIdMonHoc(Integer idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    
    @Column(name="TenMH", unique=true, nullable=false, length=45)
    public String getTenMh() {
        return this.tenMh;
    }
    
    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    
    @Column(name="heSo", nullable=false)
    public int getHeSo() {
        return this.heSo;
    }
    
    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    
    @Column(name="dangGiangDay", nullable=false)
    public boolean isDangGiangDay() {
        return this.dangGiangDay;
    }
    
    public void setDangGiangDay(boolean dangGiangDay) {
        this.dangGiangDay = dangGiangDay;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="monhoc")
    public Set<Diem> getDiems() {
        return this.diems;
    }
    
    public void setDiems(Set<Diem> diems) {
        this.diems = diems;
    }




}


