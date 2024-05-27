package Models.entity;

import java.util.Date;

public class PhieuNhapVTPT {
    private String maPNVTPT;
    private double thanhTienNhap;
    private Date ngayNhap;

    public PhieuNhapVTPT(Date ngayNhap, double thanhTienNhap, String maPNVTPT) {
        this.ngayNhap = ngayNhap;
        this.thanhTienNhap = thanhTienNhap;
        this.maPNVTPT = maPNVTPT;
    }

    public PhieuNhapVTPT() {
    }

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

    @Override
    public String toString() {
        return "PhieuNhapVTPT{" +
                "maPNVTPT='" + maPNVTPT + '\'' +
                ", thanhTienNhap=" + thanhTienNhap +
                ", ngayNhap=" + ngayNhap +
                '}';
    }
}
