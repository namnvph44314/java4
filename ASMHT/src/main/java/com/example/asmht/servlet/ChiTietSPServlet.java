package com.example.asmht.servlet;

import com.example.asmht.entity.*;
import com.example.asmht.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "ChiTietSPServlet", value = {"/hienThi/chiTietSP","/detail/chiTietSP","/add/chiTietSP","/update/chiTietSP","/delete/chiTietSP"})
public class ChiTietSPServlet extends HttpServlet {
    ChiTietSPService chiTietSPService=new ChiTietSPService();
    DongSPService dongSPService=new DongSPService();
    MauSacService mauSacService=new MauSacService();
    NXSService nxsService=new NXSService();
    SanPhamService sanPhamService=new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/chiTietSP")){
            this.hienThi(request,response);
        }else if(uri.contains("/detail/chiTietSP")){
            this.detail(request,response);
        }else if(uri.contains("/delete/chiTietSP")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        ChiTietSanPham chiTietSanPham=chiTietSPService.getById(id);
        chiTietSPService.delete(chiTietSanPham);
        response.sendRedirect("/hienThi/chiTietSP");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstSP",sanPhamService.getList());
        request.setAttribute("lstDSP",dongSPService.getList());
        request.setAttribute("lstMS",mauSacService.getList());
        request.setAttribute("lstNSX",nxsService.getList());
        String id=request.getParameter("id");
        ChiTietSanPham ctsp=chiTietSPService.getById(id);
        request.setAttribute("ctsp",ctsp);
        request.getRequestDispatcher("/chi-tiet-sp-detail.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstSP",sanPhamService.getList());
        request.setAttribute("lstDSP",dongSPService.getList());
        request.setAttribute("lstMS",mauSacService.getList());
        request.setAttribute("lstNSX",nxsService.getList());
        request.setAttribute("lstCTSP",chiTietSPService.getList());
        request.getRequestDispatcher("/chi-tiet-sp-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/chiTietSP")){
            this.add(request,response);
        }else if(uri.contains("/update/chiTietSP")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String idSP=request.getParameter("idSP");
        String idNSX=request.getParameter("idNSX");
        String idDSP=request.getParameter("idDSP");
        String idMS=request.getParameter("idMS");
        Integer namBaoHanh=Integer.parseInt(request.getParameter("namBaoHanh"));
        String moTa=request.getParameter("moTa");
        Integer soLuongTon=Integer.parseInt(request.getParameter("soLuongTon"));
        BigDecimal giaNhap= new BigDecimal(request.getParameter("giaNhap"));
        BigDecimal giaBan=new BigDecimal(request.getParameter("giaBan"));

        SanPham sanPham=new SanPham();
        sanPham.setId(idSP);
        NXS nsx=new NXS();
        nsx.setId(idNSX);
        DongSP dsp=new DongSP();
        dsp.setId(idDSP);
        MauSac ms=new MauSac();
        ms.setId(idMS);

        ChiTietSanPham ctsp=new ChiTietSanPham(id,sanPham,nsx,dsp,ms,namBaoHanh,moTa,soLuongTon,giaNhap,giaBan);
        chiTietSPService.update(ctsp);
        response.sendRedirect("/hienThi/chiTietSP");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSP=request.getParameter("idSP");
        String idNSX=request.getParameter("idNSX");
        String idDSP=request.getParameter("idDSP");
        String idMS=request.getParameter("idMS");
        Integer namBaoHanh=Integer.parseInt(request.getParameter("namBaoHanh"));
        String moTa=request.getParameter("moTa");
        Integer soLuongTon=Integer.parseInt(request.getParameter("soLuongTon"));
        BigDecimal giaNhap= new BigDecimal(request.getParameter("giaNhap"));
        BigDecimal giaBan=new BigDecimal(request.getParameter("giaBan"));

        SanPham sanPham=new SanPham();
        sanPham.setId(idSP);
        NXS nsx=new NXS();
        nsx.setId(idNSX);
        DongSP dsp=new DongSP();
        dsp.setId(idDSP);
        MauSac ms=new MauSac();
        ms.setId(idMS);

        ChiTietSanPham ctsp=new ChiTietSanPham("",sanPham,nsx,dsp,ms,namBaoHanh,moTa,soLuongTon,giaNhap,giaBan);
        chiTietSPService.add(ctsp);
        response.sendRedirect("/hienThi/chiTietSP");
    }
}
