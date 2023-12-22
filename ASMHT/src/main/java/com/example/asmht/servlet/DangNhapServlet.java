package com.example.asmht.servlet;

import com.example.asmht.entity.KhachHang;
import com.example.asmht.service.ChiTietSPService;
import com.example.asmht.service.KhachHangService;
import com.example.asmht.service.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangNhapServlet", value = {"/dangNhapSeverlet","/dangNhap"})
public class DangNhapServlet extends HttpServlet {
    KhachHangService khachHangService=new KhachHangService();

    public static String id="123";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/dangNhapSeverlet")){
            request.getRequestDispatcher("/dang-nhap.jsp").forward(request,response);
        }else if(uri.contains("/dangNhap")){
            this.dangNhap(request,response);
        }
    }


    private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sdt=request.getParameter("sdt");
        String matKhau=request.getParameter("matKhau");
        if(khachHangService.dangNhap(sdt,matKhau)!=null){
            System.out.println("Đăng nhập thành công");
            KhachHang khachHang=khachHangService.getKH(sdt,matKhau);
            id=khachHang.getId();
            response.sendRedirect("/trangChu/hienThi");
        }else{
            System.out.println("Đăng nhập thất bại");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
