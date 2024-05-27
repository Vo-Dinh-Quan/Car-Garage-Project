package Models.entity;

public class BaoCaoTon {
    private String maVTPT;
    private int thang;
    private int nam;
    private int tonDau;
    private int tonCuoi;
    private int phatSinh;

    public BaoCaoTon() {
    }

    public BaoCaoTon(String maVTPT, int nam, int thang, int tonDau, int tonCuoi, int phatSinh) {
        this.maVTPT = maVTPT;
        this.nam = nam;
        this.thang = thang;
        this.tonDau = tonDau;
        this.tonCuoi = tonCuoi;
        this.phatSinh = phatSinh;
    }

    public String getMaVTPT() {
        return maVTPT;
    }

    public void setMaVTPT(String maVTPT) {
        this.maVTPT = maVTPT;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getTonDau() {
        return tonDau;
    }

    public void setTonDau(int tonDau) {
        this.tonDau = tonDau;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTonCuoi() {
        return tonCuoi;
    }

    public void setTonCuoi(int tonCuoi) {
        this.tonCuoi = tonCuoi;
    }

    public int getPhatSinh() {
        return phatSinh;
    }

    public void setPhatSinh(int phatSinh) {
        this.phatSinh = phatSinh;
    }
}
