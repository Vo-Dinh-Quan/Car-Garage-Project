package Models.entity;

import java.util.Date;

public class PhieuThuTien {
    private String maPhieuThuTien;
    private String bienSo;
    private double soTienThu;
    private Date ngayThuTien;

    public PhieuThuTien(String maPhieuThuTien, String bienSo, double soTienThu, Date ngayThuTien) {
        this.maPhieuThuTien = maPhieuThuTien;
        this.bienSo = bienSo;
        this.soTienThu = soTienThu;
        this.ngayThuTien = ngayThuTien;
    }

    public PhieuThuTien() {
    }

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

    @Override
    public String toString() {
        return "PhieuThuTien{" +
                "maPhieuThuTien='" + maPhieuThuTien + '\'' +
                ", bienSo='" + bienSo + '\'' +
                ", soTienThu=" + soTienThu +
                ", ngayThuTien=" + ngayThuTien +
                '}';
    }
}
