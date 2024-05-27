package Models.entity;

public class HieuXe {
    private String maHX;
    private String tenHieuXe;

    // Getters và Setters
    // Constructor không đối số và có đối số
    // Phương thức toString()

    public HieuXe(String tenHieuXe, String maHX) {
        this.tenHieuXe = tenHieuXe;
        this.maHX = maHX;
    }

    public HieuXe() {
    }

    public String getMaHX() {
        return maHX;
    }

    public void setMaHX(String maHX) {
        this.maHX = maHX;
    }

    public String getTenHieuXe() {
        return tenHieuXe;
    }

    public void setTenHieuXe(String tenHieuXe) {
        this.tenHieuXe = tenHieuXe;
    }

    @Override
    public String toString() {
        return "HieuXe{" +
                "maHX='" + maHX + '\'' +
                ", tenHieuXe='" + tenHieuXe + '\'' +
                '}';
    }
}

