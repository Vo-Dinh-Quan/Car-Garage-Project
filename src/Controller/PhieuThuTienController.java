package Controller;

import Models.dao.KhachHangDAO;
import Models.dao.PhieuThuTienDAO;
import Models.dao.XeDAO;
import Models.entity.KhachHang;
import Models.entity.PhieuThuTien;
import Models.entity.Xe;

import java.util.List;

public class PhieuThuTienController {
    private XeDAO xeDAO;
    private KhachHangDAO khachHangDAO;
    private PhieuThuTienDAO phieuThuTienDAO;

    public PhieuThuTienController() {
        xeDAO = new XeDAO();
        khachHangDAO = new KhachHangDAO();
        phieuThuTienDAO = new PhieuThuTienDAO();
    }

    public List<Xe> getAllXe() {
        return xeDAO.getAllXe();
    }

    public Xe getXeByBienSo(String bienSo) {
        return xeDAO.getXeByBienSo(bienSo);
    }

    public KhachHang getKhachHangByMaKH(String maKH) {
        return khachHangDAO.getKhachHangById(maKH);
    }

    public void savePhieuThuTien(PhieuThuTien phieuThuTien) {
        phieuThuTienDAO.savePhieuThuTien(phieuThuTien);
    }

    public String generateMaPhieuThuTien() {
        return phieuThuTienDAO.generateMaPhieuThuTien();
    }

    public List<PhieuThuTien> getAllPhieuThuTien() {
        return phieuThuTienDAO.getAllPhieuThuTien();
    }
}
