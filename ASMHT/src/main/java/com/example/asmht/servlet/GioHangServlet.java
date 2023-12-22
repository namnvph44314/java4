package com.example.asmht.servlet;

import com.example.asmht.entity.GioHang;
import com.example.asmht.entity.KhachHang;
import com.example.asmht.entity.NhanVien;
import com.example.asmht.service.GioHangService;
import com.example.asmht.service.KhachHangService;
import com.example.asmht.service.NhanVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.UUID;

@WebServlet(name = "GoHangServlet", value = {"/hienThi/gioHang","/add/gioHang","/detail/gioHang","/update/gioHang"})
public class GioHangServlet extends HttpServlet {
    GioHangService gioHangService=new GioHangService();
    KhachHangService khachHangService=new KhachHangService();
    NhanVienService nhanVienService=new NhanVienService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/gioHang")){
            this.hienThiGioHang(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void detailGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void hienThiGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<GioHang> lstGH=gioHangService.getList();
//        ArrayList<KhachHang> lstKH=khachHangService.getList();
//        ArrayList<NhanVien> lstNV=nhanVienService.getList();
//
//        request.setAttribute("lstKH",lstKH);
//        request.setAttribute("lstNV",lstNV);
//        request.setAttribute("lstGH",lstGH);

        request.getRequestDispatcher("/gio-hang-hien-thi.jsp").forward(request,response);
    }


    private void addGioHang(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
