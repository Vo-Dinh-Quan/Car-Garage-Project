package Models.entity;

public class VatTuPhuTung {
    private String maVTPT;
    private String tenVTPT;
    private double donGiaNhap;
    private double donGiaBan;
    private int soLuongTon;

    public VatTuPhuTung(String tenVTPT, String maVTPT, double donGiaBan, double donGiaNhap, int soLuongTon) {
        this.tenVTPT = tenVTPT;
        this.maVTPT = maVTPT;
        this.donGiaBan = donGiaBan;
        this.donGiaNhap = donGiaNhap;
        this.soLuongTon = soLuongTon;
    }

    public VatTuPhuTung() {
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

    @Override
    public String toString() {
        return "VatTuPhuTung{" +
                "maVTPT='" + maVTPT + '\'' +
                ", tenVTPT='" + tenVTPT + '\'' +
                ", donGiaNhap=" + donGiaNhap +
                ", donGiaBan=" + donGiaBan +
                ", soLuongTon=" + soLuongTon +
                '}';
    }
}
