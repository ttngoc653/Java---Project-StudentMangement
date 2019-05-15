package dto;
// Generated May 16, 2019 1:50:36 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChitietCauhinhDiemId generated by hbm2java
 */
@Embeddable
public class ChitietCauhinhDiemId  implements java.io.Serializable {


     private int idDiem;
     private int idCauHinh;

    public ChitietCauhinhDiemId() {
    }

    public ChitietCauhinhDiemId(int idDiem, int idCauHinh) {
       this.idDiem = idDiem;
       this.idCauHinh = idCauHinh;
    }
   


    @Column(name="idDiem", nullable=false)
    public int getIdDiem() {
        return this.idDiem;
    }
    
    public void setIdDiem(int idDiem) {
        this.idDiem = idDiem;
    }


    @Column(name="idCauHinh", nullable=false)
    public int getIdCauHinh() {
        return this.idCauHinh;
    }
    
    public void setIdCauHinh(int idCauHinh) {
        this.idCauHinh = idCauHinh;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChitietCauhinhDiemId) ) return false;
		 ChitietCauhinhDiemId castOther = ( ChitietCauhinhDiemId ) other; 
         
		 return (this.getIdDiem()==castOther.getIdDiem())
 && (this.getIdCauHinh()==castOther.getIdCauHinh());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdDiem();
         result = 37 * result + this.getIdCauHinh();
         return result;
   }   


}


