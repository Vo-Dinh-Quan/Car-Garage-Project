package Models.entity;

public class CTPhieuNhapVTPT {
    private String maPNVTPT;
    private String maVTPT;
    private int soLuongNhap;
    private double tienNhapVTPT;

    // Constructors
    public CTPhieuNhapVTPT() {}

    public CTPhieuNhapVTPT(String maPNVTPT, String maVTPT, int soLuongNhap, double tienNhapVTPT) {
        this.maPNVTPT = maPNVTPT;
        this.maVTPT = maVTPT;
        this.soLuongNhap = soLuongNhap;
        this.tienNhapVTPT = tienNhapVTPT;
    }

    // Getters and Setters
    public String getMaPNVTPT() {
        return maPNVTPT;
    }

    public void setMaPNVTPT(String maPNVTPT) {
        this.maPNVTPT = maPNVTPT;
    }

    public String getMaVTPT() {
        return maVTPT;
    }

    public void setMaVTPT(String maVTPT) {
        this.maVTPT = maVTPT;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public double getTienNhapVTPT() {
        return tienNhapVTPT;
    }

    public void setTienNhapVTPT(double tienNhapVTPT) {
        this.tienNhapVTPT = tienNhapVTPT;
    }
}
