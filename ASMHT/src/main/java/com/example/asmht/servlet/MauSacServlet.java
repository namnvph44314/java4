package com.example.asmht.servlet;

import com.example.asmht.entity.MauSac;
import com.example.asmht.entity.NXS;
import com.example.asmht.service.MauSacService;
import com.example.asmht.service.NXSService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {"/hienThi/mauSac","/detail/mauSac","/add/mauSac","/update/mauSac","/delete/mauSac"})
public class MauSacServlet extends HttpServlet {
    MauSacService mauSacService=new MauSacService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/mauSac")){
            this.hienThiChucVu(request,response);
        }else if(uri.contains("/detail/mauSac")){
            this.detailChucVu(request,response);
        }else if(uri.contains("/delete/mauSac")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        MauSac mauSac=mauSacService.getById(id);
        mauSacService.delete(mauSac);
        response.sendRedirect("/hienThi/mauSac");
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        MauSac ms =mauSacService.getById(id);
        request.setAttribute("ms",ms);
        request.getRequestDispatcher("/mau-sac-detail.jsp").forward(request,response);
    }


    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MauSac> lstMS=mauSacService.getList();
        request.setAttribute("lstMS",lstMS);
        request.getRequestDispatcher("/mau-sac-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/mauSac")){
            this.addChucVu(request,response);
        }else if(uri.contains("/update/mauSac")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        MauSac ms=new MauSac(id,ma,ten);
        mauSacService.update(ms);
        response.sendRedirect("/hienThi/mauSac");
    }


    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        MauSac ms=new MauSac("",ma,ten);
        mauSacService.add(ms);
        response.sendRedirect("/hienThi/mauSac");
    }
}
