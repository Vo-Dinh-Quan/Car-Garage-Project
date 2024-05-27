package Models.entity;

public class CTSuDungVTPT {
    private String maCTPSC;
    private String maVTPT;
    private int soLuongSuDung;
    private double thanhTien;

    public CTSuDungVTPT(String maCTPSC, int soLuongSuDung, String maVTPT, double thanhTien) {
        this.maCTPSC = maCTPSC;
        this.soLuongSuDung = soLuongSuDung;
        this.maVTPT = maVTPT;
        this.thanhTien = thanhTien;
    }

    public CTSuDungVTPT() {
    }

    public String getMaCTPSC() {
        return maCTPSC;
    }

    public void setMaCTPSC(String maCTPSC) {
        this.maCTPSC = maCTPSC;
    }

    public String getMaVTPT() {
        return maVTPT;
    }

    public void setMaVTPT(String maVTPT) {
        this.maVTPT = maVTPT;
    }

    public int getSoLuongSuDung() {
        return soLuongSuDung;
    }

    public void setSoLuongSuDung(int soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "CTSuDungVTPT{" +
                "maCTPSC='" + maCTPSC + '\'' +
                ", maVTPT='" + maVTPT + '\'' +
                ", soLuongSuDung=" + soLuongSuDung +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
