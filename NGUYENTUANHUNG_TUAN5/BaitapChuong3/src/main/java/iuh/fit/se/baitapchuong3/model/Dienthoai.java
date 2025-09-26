package iuh.fit.se.baitapchuong3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;


/**
 * @author DAILOC
 */

@Entity
@Table(name = "DIENTHOAI")
public class Dienthoai implements Serializable {
    @Id
    @NotBlank(message = "Mã ĐT không được để trống")
    @Column(name = "MADT", length = 50)
    private String maDT;

    @NotBlank(message = "Tên điện thoại không được để trống")
    @Column(name = "TENDT", nullable = false)
    private String tenDT;

    @NotNull(message = "Năm sản xuất không được để trống")
    @Min(value = 1000, message = "Năm sản xuất phải là 4 chữ số")
    @Max(value = 9999, message = "Năm sản xuất phải là 4 chữ số")
    @Column(name = "NAMSANXUAT", nullable = false)
    private int namSanXuat;

    @NotBlank(message = "Cấu hình không được để trống")
    @Size(max = 255, message = "Cấu hình không quá 255 ký tự")
    @Column(name = "CAUHINH", nullable = false, length = 255)
    private String cauHinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANCC", nullable = false)
    private Nhacungcap nhaCungCap;

    @Pattern(regexp = "^$|.*\\.(png|jpg|jpeg)$", message = "Chỉ chấp nhận hình ảnh png, jpg, jpeg")
    @Column(name = "HINHANH")
    private String hinhAnh;

    public Dienthoai() {}

    public Dienthoai(String maDT, String tenDT, int namSanXuat, String cauHinh, Nhacungcap nhaCungCap, String hinhAnh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
        this.hinhAnh = hinhAnh;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public Nhacungcap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(Nhacungcap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
