package dto;
// Generated May 24, 2019 11:31:06 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Nguoidung generated by hbm2java
 */
@Entity
@Table(name="nguoidung"
    ,catalog="quanlyhocsinh"
    , uniqueConstraints = @UniqueConstraint(columnNames="TenTaiKhoan") 
)
public class Nguoidung  implements java.io.Serializable {


     private Integer idNguoiDung;
     private String hoTen;
     private String tenTaiKhoan;
     private String matKhau;
     private byte loaiNguoiDung;
     private byte tinhTrang;
     private String sdt;
     private String email;

    public Nguoidung() {
    }

	
    public Nguoidung(String hoTen, String tenTaiKhoan, String matKhau, byte loaiNguoiDung, byte tinhTrang) {
        this.hoTen = hoTen;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.loaiNguoiDung = loaiNguoiDung;
        this.tinhTrang = tinhTrang;
    }
    public Nguoidung(String hoTen, String tenTaiKhoan, String matKhau, byte loaiNguoiDung, byte tinhTrang, String sdt, String email) {
       this.hoTen = hoTen;
       this.tenTaiKhoan = tenTaiKhoan;
       this.matKhau = matKhau;
       this.loaiNguoiDung = loaiNguoiDung;
       this.tinhTrang = tinhTrang;
       this.sdt = sdt;
       this.email = email;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idNguoiDung", unique=true, nullable=false)
    public Integer getIdNguoiDung() {
        return this.idNguoiDung;
    }
    
    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    
    @Column(name="HoTen", nullable=false, length=45)
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    
    @Column(name="TenTaiKhoan", unique=true, nullable=false, length=45)
    public String getTenTaiKhoan() {
        return this.tenTaiKhoan;
    }
    
    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    
    @Column(name="MatKhau", nullable=false, length=45)
    public String getMatKhau() {
        return this.matKhau;
    }
    
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    @Column(name="LoaiNguoiDung", nullable=false)
    public byte getLoaiNguoiDung() {
        return this.loaiNguoiDung;
    }
    
    public void setLoaiNguoiDung(byte loaiNguoiDung) {
        this.loaiNguoiDung = loaiNguoiDung;
    }

    
    @Column(name="TinhTrang", nullable=false)
    public byte getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
    @Column(name="Sdt", length=16)
    public String getSdt() {
        return this.sdt;
    }
    
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
    @Column(name="Email", length=128)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


