package Models.entity;

public class TaiKhoan {
    private String chucVu;
    private String tenDangNhap;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String chucVu, String tenDangNhap, String matKhau) {
        this.chucVu = chucVu;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "chucVu='" + chucVu + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
