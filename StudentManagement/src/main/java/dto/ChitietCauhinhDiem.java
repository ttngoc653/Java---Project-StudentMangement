package dto;
// Generated Apr 15, 2019 3:40:32 PM by Hibernate Tools 4.3.1

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
 * ChitietCauhinhDiem generated by hbm2java
 */
@Entity
@Table(name = "chitiet_cauhinh_diem", catalog = "quanlyhocsinh"
)
public class ChitietCauhinhDiem implements java.io.Serializable {

    private ChitietCauhinhDiemId id;
    private Cauhinh cauhinh;
    private Diem diem;
    private Boolean apDung;

    public ChitietCauhinhDiem() {
    }

    public ChitietCauhinhDiem(ChitietCauhinhDiemId id, Cauhinh cauhinh, Diem diem) {
        this.id = id;
        this.cauhinh = cauhinh;
        this.diem = diem;
    }

    public ChitietCauhinhDiem(ChitietCauhinhDiemId id, Cauhinh cauhinh, Diem diem, Boolean apDung) {
        this.id = id;
        this.cauhinh = cauhinh;
        this.diem = diem;
        this.apDung = apDung;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "idDiem", column = @Column(name = "idDiem", nullable = false)),
        @AttributeOverride(name = "idCauHinh", column = @Column(name = "idCauHinh", nullable = false))})
    public ChitietCauhinhDiemId getId() {
        return this.id;
    }

    public void setId(ChitietCauhinhDiemId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCauHinh", nullable = false, insertable = false, updatable = false)
    public Cauhinh getCauhinh() {
        return this.cauhinh;
    }

    public void setCauhinh(Cauhinh cauhinh) {
        this.cauhinh = cauhinh;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDiem", nullable = false, insertable = false, updatable = false)
    public Diem getDiem() {
        return this.diem;
    }

    public void setDiem(Diem diem) {
        this.diem = diem;
    }

    @Column(name = "apDung")
    public Boolean getApDung() {
        return this.apDung;
    }

    public void setApDung(Boolean apDung) {
        this.apDung = apDung;
    }

}
