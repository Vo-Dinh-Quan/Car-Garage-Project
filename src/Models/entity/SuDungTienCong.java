package Models.entity;

public class SuDungTienCong {
    private String maPhieuSuaChua;
    private String maTC;
    private String tenTC;
    private double chiPhiTC;

    // Constructors, getters, and setters
    public SuDungTienCong() {}

    public SuDungTienCong(String maPhieuSuaChua, String maTC, String tenTC, double chiPhiTC) {
        this.maPhieuSuaChua = maPhieuSuaChua;
        this.maTC = maTC;
        this.tenTC = tenTC;
        this.chiPhiTC = chiPhiTC;
    }

    public String getMaPhieuSuaChua() {
        return maPhieuSuaChua;
    }

    public void setMaPhieuSuaChua(String maPhieuSuaChua) {
        this.maPhieuSuaChua = maPhieuSuaChua;
    }

    public String getMaTC() {
        return maTC;
    }

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public double getChiPhiTC() {
        return chiPhiTC;
    }

    public void setChiPhiTC(double chiPhiTC) {
        this.chiPhiTC = chiPhiTC;
    }
}
