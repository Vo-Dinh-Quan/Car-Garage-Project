package Models.service;


import Models.entity.TaiKhoan;
import Models.dao.TaiKhoanDAO;

public class TaiKhoanService {

    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanService() {
        taiKhoanDAO = new TaiKhoanDAO();
    }

    public boolean login(String tenDangNhap, String matKhau) {
        TaiKhoan taiKhoan = taiKhoanDAO.getTaiKhoanByUsername(tenDangNhap);
        if (taiKhoan != null && taiKhoan.getMatKhau().equals(matKhau)) {
            return true;
        } else {
            return false;
        }
    }
}
