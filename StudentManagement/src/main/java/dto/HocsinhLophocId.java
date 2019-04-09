package dto;
// Generated Apr 9, 2019 7:50:29 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HocsinhLophocId generated by hbm2java
 */
@Embeddable
public class HocsinhLophocId implements java.io.Serializable {

    private int idHocSinh = -1;
    private int idLopHoc = -1;
    private int idNamHoc = -1;

    public HocsinhLophocId() {
    }

    public HocsinhLophocId(int idHocSinh, int idLopHoc, int idNamHoc) {
        this.idHocSinh = idHocSinh;
        this.idLopHoc = idLopHoc;
        this.idNamHoc = idNamHoc;
    }

    @Column(name = "idHocSinh", nullable = false)
    public int getIdHocSinh() {
        return this.idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    @Column(name = "idLopHoc", nullable = false)
    public int getIdLopHoc() {
        return this.idLopHoc;
    }

    public void setIdLopHoc(int idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    @Column(name = "idNamHoc", nullable = false)
    public int getIdNamHoc() {
        return this.idNamHoc;
    }

    public void setIdNamHoc(int idNamHoc) {
        this.idNamHoc = idNamHoc;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof HocsinhLophocId)) {
            return false;
        }
        HocsinhLophocId castOther = (HocsinhLophocId) other;

        return (this.getIdHocSinh() == castOther.getIdHocSinh())
                && (this.getIdLopHoc() == castOther.getIdLopHoc())
                && (this.getIdNamHoc() == castOther.getIdNamHoc());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getIdHocSinh();
        result = 37 * result + this.getIdLopHoc();
        result = 37 * result + this.getIdNamHoc();
        return result;
    }

}
