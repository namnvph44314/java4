package com.example.asmht.servlet;

import com.example.asmht.service.HoaDonService;
import com.example.asmht.service.KhachHangService;
import com.example.asmht.service.NhanVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HoaDonServlet", value = {"/hienThi/hoaDon","/detail/hoaDon","/add/hoaDon","/update/hoaDon","/delete/hoaDon"})
public class HoaDonServlet extends HttpServlet {
    HoaDonService hoaDonService=new HoaDonService();
    KhachHangService khachHangService=new KhachHangService();
    NhanVienService nhanVienService=new NhanVienService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/hoaDon")){
            this.hienThi(request,response);
        }else if(uri.contains("/detail/hoaDon")){
            this.detail(request,response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        request.setAttribute("lstKH",khachHangService.getList());
        request.setAttribute("lstNV",nhanVienService.getList());
        request.setAttribute("hd",hoaDonService.getById(id));
        request.getRequestDispatcher("/hoa-don-detail.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstKH",khachHangService.getList());
        request.setAttribute("lstNV",nhanVienService.getList());
        request.setAttribute("lstHD",hoaDonService.getList());
        request.getRequestDispatcher("/hoa-don-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
