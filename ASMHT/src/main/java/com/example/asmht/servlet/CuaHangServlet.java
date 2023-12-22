package com.example.asmht.servlet;

import com.example.asmht.entity.CuaHang;
import com.example.asmht.service.CuaHangService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CuaHangServlet", value = {"/hienThi/cuaHang","/detail/cuaHang","/add/cuaHang","/update/cuaHang","/delete/cuaHang"})
public class CuaHangServlet extends HttpServlet {
    CuaHangService cuaHangService=new CuaHangService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/cuaHang")){
            this.hienThiCuaHang(request,response);
        }else if(uri.contains("/detail/cuaHang")){
            this.detaiCuaHang(request,response);
        }else if(uri.contains("/delete/cuaHang")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        CuaHang cuaHang=cuaHangService.getById(id);
        cuaHangService.delete(cuaHang);
        response.sendRedirect("/hienThi/cuaHang");
    }

    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CuaHang> lstCH = cuaHangService.getList();
        request.setAttribute("lstCH", lstCH);
        request.getRequestDispatcher("/cua-hang-hien-thi.jsp").forward(request, response);
    }

    private void detaiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<CuaHang> lstCH = cuaHangService.getList();
        request.setAttribute("lstCH", lstCH);
        CuaHang cuaHangDetail = cuaHangService.getById(id);
        request.setAttribute("cuaHangDetail", cuaHangDetail);
        request.getRequestDispatcher("/cua-hang-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/cuaHang")){
            this.addCuaHang(request,response);
        }else if(uri.contains("/update/cuaHang")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
        cuaHangService.update(ch);
        response.sendRedirect("/hienThi/cuaHang");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang ch = new CuaHang("", ma, ten, diaChi, thanhPho, quocGia);
        cuaHangService.addNew(ch);
        response.sendRedirect("/hienThi/cuaHang");
    }
}
