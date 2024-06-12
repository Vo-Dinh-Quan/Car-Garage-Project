package Models.entity;

public class CTSuDungVTPT {
    private String maPhieuSuaChua;
    private String maVTPT;
    private String tenVTPT;
    private double donGiaBan;
    private int soLuongSuDung;
    private double thanhTien;

    // Constructors
    public CTSuDungVTPT() {}

    public CTSuDungVTPT(String maPhieuSuaChua, String maVTPT, String tenVTPT, double donGiaBan, int soLuongSuDung, double thanhTien) {
        this.maPhieuSuaChua = maPhieuSuaChua;
        this.maVTPT = maVTPT;
        this.tenVTPT = tenVTPT;
        this.donGiaBan = donGiaBan;
        this.soLuongSuDung = soLuongSuDung;
        this.thanhTien = thanhTien;
    }

    // Getters and Setters
    public String getMaPhieuSuaChua() {
        return maPhieuSuaChua;
    }

    public void setMaPhieuSuaChua(String maPhieuSuaChua) {
        this.maPhieuSuaChua = maPhieuSuaChua;
    }

    public String getMaVTPT() {
        return maVTPT;
    }

    public void setMaVTPT(String maVTPT) {
        this.maVTPT = maVTPT;
    }

    public String getTenVTPT() {
        return tenVTPT;
    }

    public void setTenVTPT(String tenVTPT) {
        this.tenVTPT = tenVTPT;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public int getSoLuongSuDung() {
        return soLuongSuDung;
    }

    public void setSoLuongSuDung(int soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
