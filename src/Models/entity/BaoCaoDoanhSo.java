package Models.entity;

public class BaoCaoDoanhSo {
    private String maBCDS;
    private int thang;
    private int nam;
    private double tongDoanhThu;

    // Constructors
    public BaoCaoDoanhSo() {}

    public BaoCaoDoanhSo(String maBCDS, int thang, int nam, double tongDoanhThu) {
        this.maBCDS = maBCDS;
        this.thang = thang;
        this.nam = nam;
        this.tongDoanhThu = tongDoanhThu;
    }

    // Getters and Setters
    public String getMaBCDS() {
        return maBCDS;
    }

    public void setMaBCDS(String maBCDS) {
        this.maBCDS = maBCDS;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
}
