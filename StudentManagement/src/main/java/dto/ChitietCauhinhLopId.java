package dto;
// Generated Mar 24, 2019 2:56:57 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChitietCauhinhLopId generated by hbm2java
 */
@Embeddable
public class ChitietCauhinhLopId implements java.io.Serializable {

    private int idLop;
    private int idNamHoc;
    private int idCauHinh;

    public ChitietCauhinhLopId() {
    }

    public ChitietCauhinhLopId(int idLop, int idNamHoc, int idCauHinh) {
        this.idLop = idLop;
        this.idNamHoc = idNamHoc;
        this.idCauHinh = idCauHinh;
    }

    @Column(name = "idLop", nullable = false)
    public int getIdLop() {
        return this.idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    @Column(name = "idNamHoc", nullable = false)
    public int getIdNamHoc() {
        return this.idNamHoc;
    }

    public void setIdNamHoc(int idNamHoc) {
        this.idNamHoc = idNamHoc;
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
        if (!(other instanceof ChitietCauhinhLopId)) {
            return false;
        }
        ChitietCauhinhLopId castOther = (ChitietCauhinhLopId) other;

        return (this.getIdLop() == castOther.getIdLop())
                && (this.getIdNamHoc() == castOther.getIdNamHoc())
                && (this.getIdCauHinh() == castOther.getIdCauHinh());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getIdLop();
        result = 37 * result + this.getIdNamHoc();
        result = 37 * result + this.getIdCauHinh();
        return result;
    }

}