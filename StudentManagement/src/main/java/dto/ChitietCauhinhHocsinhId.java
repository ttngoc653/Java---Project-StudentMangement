package dto;
// Generated Apr 15, 2019 3:40:32 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChitietCauhinhHocsinhId generated by hbm2java
 */
@Embeddable
public class ChitietCauhinhHocsinhId implements java.io.Serializable {

    private int idHocSinh;
    private int idCauHinh;

    public ChitietCauhinhHocsinhId() {
    }

    public ChitietCauhinhHocsinhId(int idHocSinh, int idCauHinh) {
        this.idHocSinh = idHocSinh;
        this.idCauHinh = idCauHinh;
    }

    @Column(name = "idHocSinh", nullable = false)
    public int getIdHocSinh() {
        return this.idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    @Column(name = "idCauHinh", nullable = false)
    public int getIdCauHinh() {
        return this.idCauHinh;
    }

    public void setIdCauHinh(int idCauHinh) {
        this.idCauHinh = idCauHinh;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ChitietCauhinhHocsinhId)) {
            return false;
        }
        ChitietCauhinhHocsinhId castOther = (ChitietCauhinhHocsinhId) other;

        return (this.getIdHocSinh() == castOther.getIdHocSinh())
                && (this.getIdCauHinh() == castOther.getIdCauHinh());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getIdHocSinh();
        result = 37 * result + this.getIdCauHinh();
        return result;
    }
    /**/

    /**
     *
     * @param obj
     * @return 
     */
    
    public boolean equals(ChitietCauhinhHocsinhId obj) {
        if (obj == null) {
            return false;
}
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChitietCauhinhHocsinhId other = (ChitietCauhinhHocsinhId) obj;
        if (this.idHocSinh != other.idHocSinh) {
            return false;
        }
        return this.idCauHinh == other.idCauHinh;
    }

}
