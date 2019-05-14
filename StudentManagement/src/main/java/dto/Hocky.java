package dto;
// Generated Apr 28, 2019 12:28:32 PM by Hibernate Tools 4.3.1


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
 * Hocky generated by hbm2java
 */
@Entity
@Table(name="hocky"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames="TenHocKy") 
)
public class Hocky  implements java.io.Serializable {


     private Integer idHocKy;
     private int tenHocKy;
     private Set<Diem> diems = new HashSet<Diem>(0);

    public Hocky() {
    }

	
    public Hocky(int tenHocKy) {
        this.tenHocKy = tenHocKy;
    }
    public Hocky(int tenHocKy, Set<Diem> diems) {
       this.tenHocKy = tenHocKy;
       this.diems = diems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idHocKy", unique=true, nullable=false)
    public Integer getIdHocKy() {
        return this.idHocKy;
    }
    
    public void setIdHocKy(Integer idHocKy) {
        this.idHocKy = idHocKy;
    }

    
    @Column(name="TenHocKy", unique=true, nullable=false)
    public int getTenHocKy() {
        return this.tenHocKy;
    }
    
    public void setTenHocKy(int tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hocky")
    public Set<Diem> getDiems() {
        return this.diems;
    }
    
    public void setDiems(Set<Diem> diems) {
        this.diems = diems;
    }




}


