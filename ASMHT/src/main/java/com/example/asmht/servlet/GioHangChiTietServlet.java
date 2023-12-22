package com.example.asmht.servlet;

import com.example.asmht.entity.*;
import com.example.asmht.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@WebServlet(name = "GioHangChiTietServlet", value = {"/hienThi/gioHangChiTiet", "/add/gioHangChiTiet", "/delete/gioHangChiTiet", "/thanhToan"})
public class GioHangChiTietServlet extends HttpServlet {
    GioHangChiTietService gioHangChiTietService = new GioHangChiTietService();
    ChiTietSPService chiTietSPService = new ChiTietSPService();
    KhachHangService khachHangService = new KhachHangService();
    GioHangService gioHangService = new GioHangService();
    HoaDonService hoaDonService = new HoaDonService();
    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    //    String idGH = new TrangChuServlet().idGH;
//    String idCTSP = new TrangChuServlet().idCTSP;
    String idKH = new TrangChuServlet().idKH;
//    String idHD=new TrangChuServlet().idHD;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hienThi/gioHangChiTiet")) {
            this.hienThiGHCT(request, response);
        } else if (uri.contains("/delete/gioHangChiTiet")) {
            this.delete(request, response);
        } else if (uri.contains("/thanhToan")) {
            this.thanhToan(request, response);
        }
    }

    private void thanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idGH = new TrangChuServlet().idGH;
        for (int i = 0; i < gioHangChiTietService.getByGioHang(idGH).size(); i++) {
            String idCTSP = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getId();
            String idSP = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getSanPham().getId();
            String idNSX = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getNSX().getId();
            String idMS = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getMauSac().getId();
            String idDSP = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getDongSP().getId();
            int namBH = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getNamBaoHanh();
            String moTa = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getMoTa();
            int soLuongTon = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getSoLuongTon() - gioHangChiTietService.getByGioHang(idGH).get(i).getSoLuong();
            BigDecimal giaNhap = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getGiaNhap();
            BigDecimal giaBan = gioHangChiTietService.getByGioHang(idGH).get(i).getChiTietSanPham().getGiaBan();

            SanPham sanPham = new SanPham();
            sanPham.setId(idSP);
            NXS nxs = new NXS();
            nxs.setId(idNSX);
            MauSac mauSac = new MauSac();
            mauSac.setId(idMS);
            DongSP dongSP = new DongSP();
            dongSP.setId(idDSP);

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idCTSP, sanPham, nxs, dongSP, mauSac, namBH, moTa, soLuongTon, giaNhap, giaBan);
            chiTietSPService.update(chiTietSanPham);
        }
        GioHang gioHang = gioHangService.getById(idGH);
        KhachHang kh = new KhachHang();
        kh.setId(idKH);
        String idNV = "27DBC5AE-C0B6-4719-8897-90D40DC4A041";
        GioHang gioHangUpdate = new GioHang(idGH, kh, idNV, gioHang.getMa(), gioHang.getNgayTao(), gioHang.getNgayThanhToan(), gioHang.getTenNguoiNhan(), gioHang.getDiaChi(), gioHang.getSDT(), 1);
        gioHangService.update(gioHangUpdate);

        String idHD = new TrangChuServlet().idHD;
        HoaDon hoaDon = hoaDonService.getById(idHD);
        KhachHang khachHang = new KhachHang();
        khachHang.setId(idKH);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(idNV);
        HoaDon hoaDonUpdate = new HoaDon(idHD, khachHang, nhanVien, hoaDon.getMa(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getNgayShip(), hoaDon.getNgayNhan(), 1, hoaDon.getTenNguoiNhan(), hoaDon.getDiaChi(), hoaDon.getSDT());
        hoaDonService.update(hoaDonUpdate);


        response.sendRedirect("/trangChu/hienThi");
    }

    private void hienThiGHCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idGH = new TrangChuServlet().idGH;
        request.setAttribute("lstGHCT", gioHangChiTietService.getGioHangChiTiet(idGH));
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTietService.getGioHangChiTiet(idGH)) {
            System.out.println(gioHangChiTiet.toString());
        }
        request.getRequestDispatcher("/gio-hang-hien-thi.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add/gioHangChiTiet")) {
            this.addSanPham(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idHD = new TrangChuServlet().idHD;
        String idGH = new TrangChuServlet().idGH;
        String idCTSP = request.getParameter("idCTSP");
        hoaDonChiTietService.delete(hoaDonChiTietService.getById(idHD, idCTSP));
        gioHangChiTietService.delete(gioHangChiTietService.getById(idGH, idCTSP));
        response.sendRedirect("/hienThi/gioHangChiTiet");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idCTSP = new TrangChuServlet().idCTSP;
        String idGH = new TrangChuServlet().idGH;
        String idHD = new TrangChuServlet().idHD;

        boolean flag = true;
        if (request.getParameter("soLuong").trim().isEmpty()) {
            request.setAttribute("check", "Vui lòng nhập số lượng");
            flag = false;
            request.setAttribute("flag",flag);
            idCTSP = new TrangChuServlet().idCTSP;
            ChiTietSanPham chiTietSanPham = chiTietSPService.getById(idCTSP);
            request.setAttribute("spct", chiTietSanPham);
            request.getRequestDispatcher("/thong-tin-san-pham.jsp").forward(request, response);
        }

        if (Integer.parseInt(request.getParameter("soLuong"))<1) {
            request.setAttribute("check", "Vui lòng nhập số lượng > 0");
            flag = false;
            request.setAttribute("flag",flag);
            idCTSP = new TrangChuServlet().idCTSP;
            ChiTietSanPham chiTietSanPham = chiTietSPService.getById(idCTSP);
            request.setAttribute("spct", chiTietSanPham);
            request.getRequestDispatcher("/thong-tin-san-pham.jsp").forward(request, response);
        }

        if (flag) {
            if (gioHangChiTietService.getById(idGH, idCTSP) != null) {
                GioHang gioHang = new GioHang();
                gioHang.setId(idGH);
                System.out.println(idGH + "++++++++++++++++++++++++++++++++++++++++");
                ChiTietSanPham chiTietSanPham2 = new ChiTietSanPham();
                chiTietSanPham2.setId(idCTSP);
                System.out.println(idCTSP + "++++++++++++++++++++++++++++++++++++++++");
                ChiTietSanPham chiTietSanPham = chiTietSPService.getById(idCTSP);
                Integer soLuong = Integer.parseInt(request.getParameter("soLuong")) + gioHangChiTietService.getById(idGH, idCTSP).getSoLuong();
                System.out.println("Số lượng: "+Integer.parseInt(request.getParameter("soLuong")));
                BigDecimal donGia = new BigDecimal(chiTietSanPham.getGiaBan() + "").multiply(new BigDecimal(request.getParameter("soLuong")));
                System.out.println("Đơn giá: " + donGia);
                BigDecimal donGiaKhiGiam = donGia;
                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet(gioHang, chiTietSanPham2, soLuong, donGia, donGiaKhiGiam);
                gioHangChiTietService.update(gioHangChiTiet);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHD);
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, chiTietSanPham2, soLuong, donGia);
                hoaDonChiTietService.update(hoaDonChiTiet);
                System.out.println("Vào if %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            } else {
                System.out.println("Vào else %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                GioHang gioHang = new GioHang();
                gioHang.setId(idGH);
                System.out.println(idGH + "++++++++++++++++++++++++++++++++++++++++");
                ChiTietSanPham chiTietSanPham2 = new ChiTietSanPham();
                chiTietSanPham2.setId(idCTSP);
                System.out.println(idCTSP + "++++++++++++++++++++++++++++++++++++++++");
                ChiTietSanPham chiTietSanPham = chiTietSPService.getById(idCTSP);
                Integer soLuong = Integer.parseInt(request.getParameter("soLuong"));
                BigDecimal donGia = new BigDecimal(chiTietSanPham.getGiaBan() + "").multiply(new BigDecimal(request.getParameter("soLuong")));
                System.out.println("Đơn giá: " + donGia);
                BigDecimal donGiaKhiGiam = donGia;
                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet(gioHang, chiTietSanPham2, soLuong, donGia, donGiaKhiGiam);
                gioHangChiTietService.add(gioHangChiTiet);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHD);
                System.out.println(idHD + "++++++++++++++++++++++++++++++++++++++++");
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, chiTietSanPham2, soLuong, donGia);
                hoaDonChiTietService.add(hoaDonChiTiet);
            }
            response.sendRedirect("/hienThi/gioHangChiTiet");
        }

    }

}

