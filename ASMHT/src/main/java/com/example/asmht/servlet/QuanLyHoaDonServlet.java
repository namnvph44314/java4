package com.example.asmht.servlet;

import com.example.asmht.entity.HoaDon;
import com.example.asmht.entity.KhachHang;
import com.example.asmht.entity.NhanVien;
import com.example.asmht.service.HoaDonService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "QuanLyHoaDonServlet", value = {"/hien-thi-tat-ca/hoa-don","/loc/hoa-don","/detail/hoa-don","/update/hoa-don"})
public class QuanLyHoaDonServlet extends HttpServlet {
    HoaDonService hoaDonService=new HoaDonService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hien-thi-tat-ca/hoa-don")){
            this.hienThi(request,response);
        }else if(uri.contains("/loc/hoa-don")){
            this.loc(request,response);
        }else if(uri.contains("/detail/hoa-don")){
            this.detail(request,response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHD=request.getParameter("id");
        request.setAttribute("hd",hoaDonService.getById(idHD));
        request.getRequestDispatcher("/quan-ly-hoa-don-detail.jsp").forward(request,response);
    }

    private void loc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loc=request.getParameter("loc");
        System.out.println(loc+"    Lọc nè");
        if(loc.equals("Tất cả")){
            request.setAttribute("lstHD",hoaDonService.getListHD());
        }else if(loc.equals("1")){
            request.setAttribute("lstHD",hoaDonService.loc(1));
        }else if(loc.equals("2")){
            request.setAttribute("lstHD",hoaDonService.loc(2));
        }else if(loc.equals("3")){
            request.setAttribute("lstHD",hoaDonService.loc(3));
        }
        request.getRequestDispatcher("/quan-ly-hoa-don.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstHD",hoaDonService.getListHD());
        request.getRequestDispatcher("/quan-ly-hoa-don.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/update/hoa-don")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        HoaDon hoaDon=hoaDonService.getById(id);
        String ma=hoaDon.getMa();
        KhachHang khachHang=hoaDon.getKhachHang();
        NhanVien nhanVien=hoaDon.getNhanVien();
        Date ngayTao=hoaDon.getNgayTao();
        Date ngayThanhToan=hoaDon.getNgayThanhToan();
        Date ngayShip=hoaDon.getNgayShip();
        Date ngayNhan=hoaDon.getNgayNhan();
        Integer tinhTrang=Integer.parseInt(request.getParameter("tinhTrang"));
        String tenNguoiNhan=hoaDon.getTenNguoiNhan();
        String diaChi=hoaDon.getDiaChi();
        String sdt=hoaDon.getSDT();
        HoaDon hd=new HoaDon(id,khachHang,nhanVien,ma,ngayTao,ngayThanhToan,ngayShip,ngayNhan,tinhTrang,tenNguoiNhan,diaChi,sdt);
        hoaDonService.update(hd);
        response.sendRedirect("/hien-thi-tat-ca/hoa-don");
    }
}
