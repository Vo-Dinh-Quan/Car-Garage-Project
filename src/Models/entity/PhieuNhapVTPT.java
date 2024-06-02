package Models.entity;

import java.sql.Date;

public class PhieuNhapVTPT {
    private String maPNVTPT;
    private double thanhTienNhap;
    private Date ngayNhap;

    // Constructors
    public PhieuNhapVTPT() {}

    public PhieuNhapVTPT(String maPNVTPT, double thanhTienNhap, Date ngayNhap) {
        this.maPNVTPT = maPNVTPT;
        this.thanhTienNhap = thanhTienNhap;
        this.ngayNhap = ngayNhap;
    }

    // Getters and Setters
    public String getMaPNVTPT() {
        return maPNVTPT;
    }

    public void setMaPNVTPT(String maPNVTPT) {
        this.maPNVTPT = maPNVTPT;
    }

    public double getThanhTienNhap() {
        return thanhTienNhap;
    }

    public void setThanhTienNhap(double thanhTienNhap) {
        this.thanhTienNhap = thanhTienNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
