package com.example.asmht.servlet;

import com.example.asmht.entity.ChucVu;
import com.example.asmht.entity.NXS;
import com.example.asmht.service.ChucVuService;
import com.example.asmht.service.NXSService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NSXServlet", value = {"/hienThi/NSX","/detail/NSX","/add/NSX","/update/NSX","/delete/NSX"})
public class NSXServlet extends HttpServlet {
    NXSService nxsService=new NXSService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/NSX")){
            this.hienThiChucVu(request,response);
        }else if(uri.contains("/detail/NSX")){
            this.detailChucVu(request,response);
        }else if(uri.contains("/delete/NSX")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        NXS nxs=nxsService.getById(id);
        nxsService.delete(nxs);
        response.sendRedirect("/hienThi/NSX");
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        NXS nxs=nxsService.getById(id);
        request.setAttribute("NSX",nxs);
        request.getRequestDispatcher("/NSX-detail.jsp").forward(request,response);
    }


    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NXS> lstNSX=nxsService.getList();
        request.setAttribute("lstNSX",lstNSX);
        request.getRequestDispatcher("/NSX-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/NSX")){
            this.addChucVu(request,response);
        }else if(uri.contains("/update/NSX")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NXS nxs=new NXS(id,ma,ten);
        nxsService.update(nxs);
        response.sendRedirect("/hienThi/NSX");
    }


    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NXS nxs=new NXS("",ma,ten);
        nxsService.add(nxs);
        response.sendRedirect("/hienThi/NSX");
    }
}
