package Models.entity;

public class KhachHang {
    private String maKH;
    private String hoTenKH;
    private String dienThoai;
    private String email;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTenKH, String dienThoai,  String email) {
        this.maKH = maKH;
        this.dienThoai = dienThoai;
        this.hoTenKH = hoTenKH;
        this.email = email;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
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

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", hoTenKH='" + hoTenKH + '\'' +
                ", dienThoai=" + dienThoai +
                ", email='" + email + '\'' +
                '}';
    }
}
