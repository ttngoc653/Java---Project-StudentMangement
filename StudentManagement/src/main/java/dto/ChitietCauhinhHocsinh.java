package dto;
// Generated May 24, 2019 11:31:06 PM by Hibernate Tools 4.3.1


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
 * ChitietCauhinhHocsinh generated by hbm2java
 */
@Entity
@Table(name="chitiet_cauhinh_hocsinh"
    ,catalog="quanlyhocsinh"
)
public class ChitietCauhinhHocsinh  implements java.io.Serializable {


     private ChitietCauhinhHocsinhId id;
     private Cauhinh cauhinh;
     private Hocsinh hocsinh;
     private Boolean apDung;

    public ChitietCauhinhHocsinh() {
    }

	
    public ChitietCauhinhHocsinh(ChitietCauhinhHocsinhId id, Cauhinh cauhinh, Hocsinh hocsinh) {
        this.id = id;
        this.cauhinh = cauhinh;
        this.hocsinh = hocsinh;
    }
    public ChitietCauhinhHocsinh(ChitietCauhinhHocsinhId id, Cauhinh cauhinh, Hocsinh hocsinh, Boolean apDung) {
       this.id = id;
       this.cauhinh = cauhinh;
       this.hocsinh = hocsinh;
       this.apDung = apDung;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idHocSinh", column=@Column(name="idHocSinh", nullable=false) ), 
        @AttributeOverride(name="idCauHinh", column=@Column(name="idCauHinh", nullable=false) ) } )
    public ChitietCauhinhHocsinhId getId() {
        return this.id;
    }
    
    public void setId(ChitietCauhinhHocsinhId id) {
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
    @JoinColumn(name="idHocSinh", nullable=false, insertable=false, updatable=false)
    public Hocsinh getHocsinh() {
        return this.hocsinh;
    }
    
    public void setHocsinh(Hocsinh hocsinh) {
        this.hocsinh = hocsinh;
    }

    
    @Column(name="apDung")
    public Boolean getApDung() {
        return this.apDung;
    }
    
    public void setApDung(Boolean apDung) {
        this.apDung = apDung;
    }




}


