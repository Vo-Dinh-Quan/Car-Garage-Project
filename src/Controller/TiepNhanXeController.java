package Controller;

import Models.dao.KhachHangDAO;
import Models.dao.XeDAO;
import Models.entity.KhachHang;
import Models.entity.Xe;

import java.util.List;

public class TiepNhanXeController {
    private KhachHangDAO khachHangDAO;
    private XeDAO xeDAO;

    public TiepNhanXeController() {
        khachHangDAO = new KhachHangDAO();
        xeDAO = new XeDAO();
    }

    public String saveKhachHang(KhachHang khachHang) {
        return khachHangDAO.addKhachHang(khachHang);
    }

    public boolean saveXe(Xe xe) {
        return xeDAO.addXe(xe);
    }

    public List<KhachHang> getAllKhachHang() {
        return khachHangDAO.getAllKhachHang();
    }

    public KhachHang getKhachHangByName(String hoTenKH) {
        List<KhachHang> khachHangList = khachHangDAO.getAllKhachHang();
        for (KhachHang kh : khachHangList) {
            if (kh.getHoTenKH().equalsIgnoreCase(hoTenKH)) {
                return kh;
            }
        }
        return null;
    }
    public List<Xe> getAllXe() {
        XeDAO xeDAO = new XeDAO();
        return xeDAO.getAllXe();
    }

    public KhachHang getKhachHangById(String maKH) {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        return khachHangDAO.getKhachHangById(maKH);
    }
    public KhachHang getKhachHangByDetails(String hoTenKH, String dienThoai, String email) {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        return khachHangDAO.getKhachHangByDetails(hoTenKH, dienThoai, email);
    }

    public boolean isLastCarOfCustomer(String maKH) {
        // chỗ này lấy ra tất cả xe của khách hàng đang cos trong hệ thống
        List<Xe> xeList = xeDAO.getAllXeByMaKH(maKH);
        return xeList.size() == 1;
    }

    public boolean deleteXe(String bienSo) {
        return xeDAO.deleteXe(bienSo);
    }

    public boolean deleteKhachHang(String maKH) {
        return khachHangDAO.deleteKhachHang(maKH);
    }

    public Xe getXeByBienSo(String bienSo) {
        return xeDAO.getXeByBienSo(bienSo);
    }
    public boolean updateXe(String oldBienSo, Xe newXe) {
        return xeDAO.updateXe(oldBienSo, newXe);
    }

    public boolean updateKhachHang(KhachHang khachHang) {
        return khachHangDAO.updateKhachHang(khachHang);
    }


}
