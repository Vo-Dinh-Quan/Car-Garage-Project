package Models.entity;

import java.sql.Date;

public class PhieuThuTien {
    private String maPhieuThuTien;
    private String bienSo;
    private double soTienThu;
    private Date ngayThuTien;

    // Constructors
    public PhieuThuTien() {}

    public PhieuThuTien(String maPhieuThuTien, String bienSo, double soTienThu, Date ngayThuTien) {
        this.maPhieuThuTien = maPhieuThuTien;
        this.bienSo = bienSo;
        this.soTienThu = soTienThu;
        this.ngayThuTien = ngayThuTien;
    }

    // Getters and Setters
    public String getMaPhieuThuTien() {
        return maPhieuThuTien;
    }

    public void setMaPhieuThuTien(String maPhieuThuTien) {
        this.maPhieuThuTien = maPhieuThuTien;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public double getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(double soTienThu) {
        this.soTienThu = soTienThu;
    }

    public Date getNgayThuTien() {
        return ngayThuTien;
    }

    public void setNgayThuTien(Date ngayThuTien) {
        this.ngayThuTien = ngayThuTien;
    }
}
