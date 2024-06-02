package Models.entity;

import java.util.Date;

public class PhieuSuaChua {
    private String maPhieuSuaChua;
    private String bienSo;
    private Date ngaySuaChua;
    private double thanhTienPSC;

    // Constructors
    public PhieuSuaChua() {}

    public PhieuSuaChua(String maPhieuSuaChua, String bienSo, Date ngaySuaChua, double thanhTienPSC) {
        this.maPhieuSuaChua = maPhieuSuaChua;
        this.bienSo = bienSo;
        this.ngaySuaChua = ngaySuaChua;
        this.thanhTienPSC = thanhTienPSC;
    }

    // Getters and Setters
    public String getMaPhieuSuaChua() {
        return maPhieuSuaChua;
    }

    public void setMaPhieuSuaChua(String maPhieuSuaChua) {
        this.maPhieuSuaChua = maPhieuSuaChua;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public Date getNgaySuaChua() {
        return ngaySuaChua;
    }

    public void setNgaySuaChua(Date ngaySuaChua) {
        this.ngaySuaChua = ngaySuaChua;
    }

    public double getThanhTienPSC() {
        return thanhTienPSC;
    }

    public void setThanhTienPSC(double thanhTienPSC) {
        this.thanhTienPSC = thanhTienPSC;
    }
}
