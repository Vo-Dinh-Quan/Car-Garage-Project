package Models.entity;

public class CTSuDungVTPT {
    private String maPhieuSuaChua;
    private String maVTPT;
    private int soLuongSuDung;
    private double thanhTien;

    // Constructors
    public CTSuDungVTPT() {}

    public CTSuDungVTPT(String maPhieuSuaChua, String maVTPT, int soLuongSuDung, double thanhTien) {
        this.maPhieuSuaChua = maPhieuSuaChua;
        this.maVTPT = maVTPT;
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
