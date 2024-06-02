package Models.entity;

public class TienCong {
    private String maTC;
    private String tenTC;
    private double chiPhiTC;

    // Constructors
    public TienCong() {}

    public TienCong(String maTC, String tenTC, double chiPhiTC) {
        this.maTC = maTC;
        this.tenTC = tenTC;
        this.chiPhiTC = chiPhiTC;
    }

    // Getters and Setters
    public String getMaTC() {
        return maTC;
    }

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public double getChiPhiTC() {
        return chiPhiTC;
    }

    public void setChiPhiTC(double chiPhiTC) {
        this.chiPhiTC = chiPhiTC;
    }
}
