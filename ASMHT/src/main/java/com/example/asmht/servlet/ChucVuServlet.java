package com.example.asmht.servlet;

import com.example.asmht.entity.ChucVu;
import com.example.asmht.service.ChucVuService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChucVuServlet", value = {"/hienThi/chucVu","/detail/chucVu","/add/chucVu","/update/chucVu","/delete/chucVu"})
public class ChucVuServlet extends HttpServlet {
    ChucVuService chucVuService=new ChucVuService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/chucVu")){
            this.hienThiChucVu(request,response);
        }else if(uri.contains("/detail/chucVu")){
            this.detailChucVu(request,response);
        }else if(uri.contains("/delete/chucVu")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        ChucVu chucVu=chucVuService.getById(id);
        chucVuService.delete(chucVu);
        response.sendRedirect("/hienThi/chucVu");
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        ChucVu chucVuDetail=chucVuService.getById(id);

        System.out.println(chucVuDetail.toString());
        request.setAttribute("chucVuDetail",chucVuDetail);
        request.getRequestDispatcher("/chuc-vu-detail.jsp").forward(request,response);
    }


    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChucVu> lstCV=chucVuService.getList();
        request.setAttribute("lstCV",lstCV);
        request.getRequestDispatcher("/chuc-vu-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/chucVu")){
            this.addChucVu(request,response);
        }else if(uri.contains("/update/chucVu")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        ChucVu cvNew=new ChucVu(id,ma,ten);
        chucVuService.update(cvNew);
        response.sendRedirect("/hienThi/chucVu");
    }


    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        ChucVu cvNew=new ChucVu("",ma,ten);
        chucVuService.addNew(cvNew);
        response.sendRedirect("/hienThi/chucVu");
    }
}
