package Models.entity;

public class VatTuPhuTung {
    private String maVTPT;
    private String tenVTPT;
    private double donGiaNhap;
    private double donGiaBan;
    private int soLuongTon;

    // Constructors
    public VatTuPhuTung() {}

    public VatTuPhuTung(String maVTPT, String tenVTPT, double donGiaNhap, double donGiaBan, int soLuongTon) {
        this.maVTPT = maVTPT;
        this.tenVTPT = tenVTPT;
        this.donGiaNhap = donGiaNhap;
        this.donGiaBan = donGiaBan;
        this.soLuongTon = soLuongTon;
    }

    // Getters and Setters
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

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
}
