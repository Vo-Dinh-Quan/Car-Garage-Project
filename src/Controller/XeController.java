package Controller;

import Models.dao.KhachHangDAO;
import Models.dao.XeDAO;
import Models.entity.KhachHang;
import Models.entity.Xe;

import java.util.List;

public class XeController {
    private XeDAO xeDAO;

    public XeController() {
        this.xeDAO = new XeDAO();
    }

    public List<Xe> getAllXe() {
        return xeDAO.getAllXe();
    }

    public List<Xe> searchXe(String hieuXe, String bienSo) {
        return xeDAO.searchXe(hieuXe, bienSo);
    }

    public KhachHang getKhachHangById(String maKH) {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        return khachHangDAO.getKhachHangById(maKH);
    }
}
