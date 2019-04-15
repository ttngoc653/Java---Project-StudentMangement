package dto;
// Generated Apr 15, 2019 3:40:32 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lop generated by hbm2java
 */
@Entity
@Table(name = "lop", catalog = "quanlyhocsinh"
)
public class Lop implements java.io.Serializable {

    private Integer idLop;
    private String tenLop;
    private int khoi;
    private Byte tinhTrang;
    private Set<HocsinhLophoc> hocsinhLophocs = new HashSet<HocsinhLophoc>(0);
    private Set<ChitietCauhinhLop> chitietCauhinhLops = new HashSet<ChitietCauhinhLop>(0);

    public Lop() {
    }

    public Lop(String tenLop, int khoi) {
        this.tenLop = tenLop;
        this.khoi = khoi;
    }

    public Lop(String tenLop, int khoi, Byte tinhTrang, Set<HocsinhLophoc> hocsinhLophocs, Set<ChitietCauhinhLop> chitietCauhinhLops) {
        this.tenLop = tenLop;
        this.khoi = khoi;
        this.tinhTrang = tinhTrang;
        this.hocsinhLophocs = hocsinhLophocs;
        this.chitietCauhinhLops = chitietCauhinhLops;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idLop", unique = true, nullable = false)
    public Integer getIdLop() {
        return this.idLop;
    }

    public void setIdLop(Integer idLop) {
        this.idLop = idLop;
    }

    @Column(name = "TenLop", nullable = false, length = 45)
    public String getTenLop() {
        return this.tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Column(name = "Khoi", nullable = false)
    public int getKhoi() {
        return this.khoi;
    }

    public void setKhoi(int khoi) {
        this.khoi = khoi;
    }

    @Column(name = "TinhTrang")
    public Byte getTinhTrang() {
        return this.tinhTrang;
    }

    public void setTinhTrang(Byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lop")
    public Set<HocsinhLophoc> getHocsinhLophocs() {
        return this.hocsinhLophocs;
    }

    public void setHocsinhLophocs(Set<HocsinhLophoc> hocsinhLophocs) {
        this.hocsinhLophocs = hocsinhLophocs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lop")
    public Set<ChitietCauhinhLop> getChitietCauhinhLops() {
        return this.chitietCauhinhLops;
    }

    public void setChitietCauhinhLops(Set<ChitietCauhinhLop> chitietCauhinhLops) {
        this.chitietCauhinhLops = chitietCauhinhLops;
    }

    @OneToMany
    public List<HocsinhLophoc> getHocsinhLophocl() {
        return new ArrayList<HocsinhLophoc>(this.hocsinhLophocs);
    }

    public void setHocsinhLophocl(List<HocsinhLophoc> hocsinhLophocl) {
        this.hocsinhLophocs = new HashSet<HocsinhLophoc>(hocsinhLophocl);
    }

    @OneToMany
    public List<ChitietCauhinhLop> getChitietCauhinhLopl() {
        return new ArrayList<ChitietCauhinhLop>(this.chitietCauhinhLops);
    }

    public void setChitietCauhinhLopl(List<ChitietCauhinhLop> chitietCauhinhLopl) {
        this.chitietCauhinhLops = new HashSet<ChitietCauhinhLop>(chitietCauhinhLopl);
    }

    public boolean equals(Lop obj) {
        return Objects.equals(obj.idLop, this.idLop) || obj.tenLop.equals(this.tenLop);
    }

}
