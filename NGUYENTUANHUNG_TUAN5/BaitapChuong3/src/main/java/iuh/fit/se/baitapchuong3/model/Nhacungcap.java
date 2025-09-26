package iuh.fit.se.baitapchuong3.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author DAILOC
 */

@Entity
@Table(name = "NHACUNGCAP")
public class Nhacungcap implements Serializable {
    @Id
    @Column(name = "MANCC", length = 50)
    private String maNCC;

    @Column(name = "TENNHACC", nullable = false)
    private String tenNhaCC;

    @Column(name = "DIACHI", nullable = false)
    private String diaChi;

    @Column(name = "SODIENTHOAI", nullable = false)
    private String soDienThoai;

    public Nhacungcap() {}

    public Nhacungcap(String maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
        this.maNCC = maNCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
