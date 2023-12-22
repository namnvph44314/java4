package com.example.asmht.servlet;

import com.example.asmht.entity.ChucVu;
import com.example.asmht.entity.SanPham;
import com.example.asmht.service.ChucVuService;
import com.example.asmht.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = {"/hienThi/sanPham","/detail/sanPham","/add/sanPham","/update/sanPham","/delete/sanPham"})
public class SanPhamServlet extends HttpServlet {
    SanPhamService sanPhamService=new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/sanPham")){
            this.hienThi(request,response);
        }else if(uri.contains("/detail/sanPham")){
            this.detail(request,response);
        }else if(uri.contains("/delete/sanPham")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        SanPham sanPham=sanPhamService.getById(id);
        sanPhamService.delete(sanPham);
        response.sendRedirect("/hienThi/sanPham");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        SanPham sp =sanPhamService.getById(id);

        request.setAttribute("sp",sp);
        request.getRequestDispatcher("/san-pham-detail.jsp").forward(request,response);
    }


    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SanPham> lstSP=sanPhamService.getList();
        request.setAttribute("lstSP",lstSP);
        request.getRequestDispatcher("/san-pham-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/sanPham")){
            this.addChucVu(request,response);
        }else if(uri.contains("/update/sanPham")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        SanPham sp=new SanPham(id,ma,ten);
        sanPhamService.update(sp);
        response.sendRedirect("/hienThi/sanPham");
    }


    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        SanPham sp=new SanPham("",ma,ten);
        sanPhamService.add(sp);
        response.sendRedirect("/hienThi/sanPham");
    }
}
