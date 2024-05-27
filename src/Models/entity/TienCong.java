package Models.entity;

public class TienCong {
    private String maTC;
    private String tenTC;
    private double chiPhiTC;

    public TienCong() {
    }

    public TienCong(String maTC, String tenTC, double chiPhiTC) {
        this.maTC = maTC;
        this.tenTC = tenTC;
        this.chiPhiTC = chiPhiTC;
    }

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

    @Override
    public String toString() {
        return "TienCong{" +
                "maTC='" + maTC + '\'' +
                ", tenTC='" + tenTC + '\'' +
                ", chiPhiTC=" + chiPhiTC +
                '}';
    }
    // Getters và Setters
    // Constructor không đối số và có đối số
    // Phương thức toString()
}
