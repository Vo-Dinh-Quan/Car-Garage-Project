package Controller;

import Models.service.TaiKhoanService;

public class TaiKhoanController {
    private TaiKhoanService taiKhoanService;

    public TaiKhoanController() {
        this.taiKhoanService = new TaiKhoanService();
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) {
        return taiKhoanService.changePassword(username, currentPassword, newPassword);
    }
}
