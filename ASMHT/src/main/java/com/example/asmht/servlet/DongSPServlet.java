package com.example.asmht.servlet;

import com.example.asmht.entity.*;
import com.example.asmht.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", value = {
        "/hienThi/dongSP",
        "/detail/dongSP",
        "/add/dongSP",
        "/update/dongSP",
        "/delete/dongSP"
})
public class DongSPServlet extends HttpServlet {
    DongSPService dongSPService = new DongSPService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hienThi/dongSP")) {
            this.hienThiDongSP(request, response);
        } else if (uri.contains("/detail/dongSP")) {
            this.detailDongSP(request, response);
        }else if(uri.contains("/delete/dongSP")){
            this.delete(request,response);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        DongSP dongSP=dongSPService.getById(id);
        dongSPService.delete(dongSP);
        response.sendRedirect("/hienThi/dongSP");
    }


    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<DongSP> lstDSP = dongSPService.getList();
        request.setAttribute("lstDSP", lstDSP);
        DongSP dspDetail = dongSPService.getById(id);
        request.setAttribute("dspDetail", dspDetail);
        request.getRequestDispatcher("/dongSP-detail.jsp").forward(request, response);
    }

    private void hienThiDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DongSP> lstDSP = dongSPService.getList();
        request.setAttribute("lstDSP", lstDSP);
        request.getRequestDispatcher("/dongSP-hien-thi.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add/dongSP")) {
            this.addDongSP(request, response);
        }else if(uri.contains("/update/dongSP")){
            this.update(request,response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSP dsp = new DongSP(id, ma, ten);
        dongSPService.update(dsp);
        response.sendRedirect("/hienThi/dongSP");
    }


    private void addDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSP dsp = new DongSP("", ma, ten);
        dongSPService.addNew(dsp);
        response.sendRedirect("/hienThi/dongSP");
    }


}
