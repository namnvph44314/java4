package com.example.asmht.servlet;

import com.example.asmht.entity.KhachHang;
import com.example.asmht.service.KhachHangService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "KhachHangServlet", value ={"/hienThi/khachHang","/detail/khachHang","/add/khachHang","/update/khachHang","/delete/khachHang"})
public class KhachHangServlet extends HttpServlet {
    KhachHangService khachHangService=new KhachHangService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/khachHang")){
            this.hienThi(request,response);
        }else if(uri.contains("/detail/khachHang")){
            this.detail(request,response);
        }else if(uri.contains("/delete/khachHang")){
            this.delete(request,response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        KhachHang kh=khachHangService.getById(id);
        request.setAttribute("kh",kh);
        request.getRequestDispatcher("/khach-hang-detail.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstKH",khachHangService.getList());
        request.getRequestDispatcher("/khach-hang-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/khachHang")){
            this.add(request,response);
        }else if(uri.contains("/update/khachHang")){
            this.update(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        System.out.println("========================="+id);
        KhachHang kh=khachHangService.getById(id);
        khachHangService.delete(kh);
        response.sendRedirect("/hienThi/khachHang");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String tenDem=request.getParameter("tenDem");
        String ho=request.getParameter("ho");
        Date ngaySinh=null;
        try {
            ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
        }catch (Exception e){
            e.printStackTrace();
        }
        String sdt=request.getParameter("sdt");
        String diaChi=request.getParameter("diaChi");
        String thanhPho=request.getParameter("thanhPho");
        String quocGia=request.getParameter("quocGia");
        String matKhau=request.getParameter("matKhau");
        KhachHang kh=new KhachHang(id,ma,ten,tenDem,ho,ngaySinh,sdt,diaChi,thanhPho,quocGia,matKhau);
        khachHangService.update(kh);
        response.sendRedirect("/hienThi/khachHang");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String tenDem=request.getParameter("tenDem");
        String ho=request.getParameter("ho");
        Date ngaySinh=null;
        try {
            ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
        }catch (Exception e){
            e.printStackTrace();
        }
        String sdt=request.getParameter("sdt");
        String diaChi=request.getParameter("diaChi");
        String thanhPho=request.getParameter("thanhPho");
        String quocGia=request.getParameter("quocGia");
        String matKhau=request.getParameter("matKhau");
        KhachHang kh=new KhachHang("",ma,ten,tenDem,ho,ngaySinh,sdt,diaChi,thanhPho,quocGia,matKhau);
        khachHangService.add(kh);
        response.sendRedirect("/hienThi/khachHang");
    }
}
