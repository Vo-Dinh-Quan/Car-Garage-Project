package Models.entity;

public class CTPhieuSuaChua {
    private String maCTPSC;
    private String maPSC;
    private String maTC;
    private String noiDung;
    private double thanhTienND;

    public CTPhieuSuaChua() {
    }

    public CTPhieuSuaChua(String maCTPSC, String maPSC, String noiDung, String maTC, double thanhTienND) {
        this.maCTPSC = maCTPSC;
        this.maPSC = maPSC;
        this.noiDung = noiDung;
        this.maTC = maTC;
        this.thanhTienND = thanhTienND;
    }

    public String getMaCTPSC() {
        return maCTPSC;
    }

    public void setMaCTPSC(String maCTPSC) {
        this.maCTPSC = maCTPSC;
    }

    public String getMaPSC() {
        return maPSC;
    }

    public void setMaPSC(String maPSC) {
        this.maPSC = maPSC;
    }

    public String getMaTC() {
        return maTC;
    }

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public double getThanhTienND() {
        return thanhTienND;
    }

    public void setThanhTienND(double thanhTienND) {
        this.thanhTienND = thanhTienND;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Override
    public String toString() {
        return "CTPhieuSuaChua{" +
                "maCTPSC='" + maCTPSC + '\'' +
                ", maPSC='" + maPSC + '\'' +
                ", maTC='" + maTC + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", thanhTienND=" + thanhTienND +
                '}';
    }
}
