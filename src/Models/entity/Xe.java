package Models.entity;

import java.sql.Date;

public class Xe {
    private String bienSo;
    private String maKH;
    private String tenHX;
    private double tienNo;
    private Date ngayTiepNhan;

    // Constructors
    public Xe() {}

    public Xe(String bienSo, String maKH, String tenHX, double tienNo, Date ngayTiepNhan) {
        this.bienSo = bienSo;
        this.maKH = maKH;
        this.tenHX = tenHX;
        this.tienNo = tienNo;
        this.ngayTiepNhan = ngayTiepNhan;
    }

    // Getters and Setters
    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenHX() {
        return tenHX;
    }

    public void setTenHX(String tenHX) {
        this.tenHX = tenHX;
    }

    public double getTienNo() {
        return tienNo;
    }

    public void setTienNo(double tienNo) {
        this.tienNo = tienNo;
    }

    public Date getNgayTiepNhan() {
        return ngayTiepNhan;
    }

    public void setNgayTiepNhan(Date ngayTiepNhan) {
        this.ngayTiepNhan = ngayTiepNhan;
    }
}
