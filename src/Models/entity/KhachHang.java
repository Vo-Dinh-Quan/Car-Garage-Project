package Models.entity;

public class KhachHang {
    private String maKH;
    private String hoTenKH;
    private long dienThoai;
    private String email;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH, long dienThoai, String hoTenKH, String email, String diaChi) {
        this.maKH = maKH;
        this.dienThoai = dienThoai;
        this.hoTenKH = hoTenKH;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public long getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(long dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", hoTenKH='" + hoTenKH + '\'' +
                ", dienThoai=" + dienThoai +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
