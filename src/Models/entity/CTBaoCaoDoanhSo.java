package Models.entity;

public class CTBaoCaoDoanhSo {
    private String maBCDS;
    private String maHX;
    private int soLuotSua;
    private double thanhTien;
    private double tiLe;

    public CTBaoCaoDoanhSo(String maBCDS, String maHX, int soLuotSua, double tiLe, double thanhTien) {
        this.maBCDS = maBCDS;
        this.maHX = maHX;
        this.soLuotSua = soLuotSua;
        this.tiLe = tiLe;
        this.thanhTien = thanhTien;
    }

    public CTBaoCaoDoanhSo() {
    }

    public String getMaBCDS() {
        return maBCDS;
    }

    public void setMaBCDS(String maBCDS) {
        this.maBCDS = maBCDS;
    }

    public String getMaHX() {
        return maHX;
    }

    public void setMaHX(String maHX) {
        this.maHX = maHX;
    }

    public int getSoLuotSua() {
        return soLuotSua;
    }

    public void setSoLuotSua(int soLuotSua) {
        this.soLuotSua = soLuotSua;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTiLe() {
        return tiLe;
    }

    public void setTiLe(double tiLe) {
        this.tiLe = tiLe;
    }

    @Override
    public String toString() {
        return "CTBaoCaoDoanhSo{" +
                "maBCDS='" + maBCDS + '\'' +
                ", maHX='" + maHX + '\'' +
                ", soLuotSua=" + soLuotSua +
                ", thanhTien=" + thanhTien +
                ", tiLe=" + tiLe +
                '}';
    }
}
