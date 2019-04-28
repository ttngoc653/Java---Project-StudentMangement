package dto;
// Generated Apr 28, 2019 12:28:32 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChitietCauhinhLop generated by hbm2java
 */
@Entity
@Table(name="chitiet_cauhinh_lop"
    ,catalog="quanlyhocsinh"
)
public class ChitietCauhinhLop  implements java.io.Serializable {


     private ChitietCauhinhLopId id;
     private Cauhinh cauhinh;
     private Lop lop;
     private Namhoc namhoc;

    public ChitietCauhinhLop() {
    }

    public ChitietCauhinhLop(ChitietCauhinhLopId id, Cauhinh cauhinh, Lop lop, Namhoc namhoc) {
       this.id = id;
       this.cauhinh = cauhinh;
       this.lop = lop;
       this.namhoc = namhoc;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idLop", column=@Column(name="idLop", nullable=false) ), 
        @AttributeOverride(name="idNamHoc", column=@Column(name="idNamHoc", nullable=false) ), 
        @AttributeOverride(name="idCauHinh", column=@Column(name="idCauHinh", nullable=false) ) } )
    public ChitietCauhinhLopId getId() {
        return this.id;
    }
    
    public void setId(ChitietCauhinhLopId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCauHinh", nullable=false, insertable=false, updatable=false)
    public Cauhinh getCauhinh() {
        return this.cauhinh;
    }
    
    public void setCauhinh(Cauhinh cauhinh) {
        this.cauhinh = cauhinh;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idLop", nullable=false, insertable=false, updatable=false)
    public Lop getLop() {
        return this.lop;
    }
    
    public void setLop(Lop lop) {
        this.lop = lop;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idNamHoc", nullable=false, insertable=false, updatable=false)
    public Namhoc getNamhoc() {
        return this.namhoc;
    }
    
    public void setNamhoc(Namhoc namhoc) {
        this.namhoc = namhoc;
    }




}


