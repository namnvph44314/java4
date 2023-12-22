package com.example.asmht.servlet;

import com.example.asmht.entity.*;
import com.example.asmht.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet(name = "NhanVienServlet", value = {"/hienThi/nhanVien","/detail/nhanVien","/add/nhanVien","/update/nhanVien","/delete/nhanVien"})
public class NhanVienServlet extends HttpServlet {
    NhanVienService nhanVienService=new NhanVienService();
    CuaHangService cuaHangService=new CuaHangService();
    ChucVuService chucVuService=new ChucVuService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/hienThi/nhanVien")){
            this.hienThi(request,response);
        }else if(uri.contains("/detail/nhanVien")){
            this.detail(request,response);
        }else if(uri.contains("/delete/nhanVien")){
            this.delete(request,response);
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        System.out.println("id___________________"+id);
        NhanVien nhanVien=nhanVienService.getById(id);
        System.out.println("=================================");

        nhanVienService.delete(nhanVien);
        response.sendRedirect("/hienThi/nhanVien");
    }
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstCH",cuaHangService.getList());
        request.setAttribute("lstCV",chucVuService.getList());
        request.setAttribute("lstGuiBC",nhanVienService.getList());
        String id=request.getParameter("id");
        NhanVien nv=nhanVienService.getById(id);
        System.out.println(nv.getNgaySinh()+"------------------------------------------------------");
        request.setAttribute("nv",nv);
        request.getRequestDispatcher("/nhan-vien-detail.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstCH",cuaHangService.getList());
        request.setAttribute("lstCV",chucVuService.getList());
        request.setAttribute("lstNV",nhanVienService.getList());
        request.getRequestDispatcher("/nhan-vien-hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/add/nhanVien")){
            this.add(request,response);
        }else if(uri.contains("/update/nhanVien")){
            this.update(request,response);
        }
    }



    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String tenDem=request.getParameter("tendem");
        String ho=request.getParameter("ho");
        String gioiTinh=request.getParameter("gioiTinh");
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh= null;
        try {
            ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String diaChi=request.getParameter("diaChi");
        String sdt=request.getParameter("sdt");
        String matKhau=request.getParameter("matKhau");
        String idCH=request.getParameter("idCH");
        String idCV=request.getParameter("idCV");
        String idGuiBC=request.getParameter("idGuiBC");
        Integer trangThai=Integer.parseInt(request.getParameter("trangThai"));

        CuaHang cuaHang=new CuaHang();
        cuaHang.setId(idCH);
        ChucVu chucVu=new ChucVu();
        chucVu.setId(idCV);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(idGuiBC);

        NhanVien nv=new NhanVien(id,ma,ten,tenDem,ho,gioiTinh,ngaySinh,diaChi,sdt,matKhau,cuaHang,chucVu,nhanVien,trangThai);
        nhanVienService.update(nv);
        response.sendRedirect("/hienThi/nhanVien");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String tenDem=request.getParameter("tenDem");
        String ho=request.getParameter("ho");
        String gioiTinh=request.getParameter("gioiTinh");
//        SimpleDateFormat date=new SimpleDateFormat("mm-dd-yyyy");
        Date ngaySinh= null;
        try {
            ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String diaChi=request.getParameter("diaChi");
        String sdt=request.getParameter("sdt");
        String matKhau=request.getParameter("matKhau");
        String idCH=request.getParameter("idCH");
        String idCV=request.getParameter("idCV");
        String idGuiBC=request.getParameter("idGuiBC");
        Integer trangThai=Integer.parseInt(request.getParameter("trangThai"));

        CuaHang cuaHang=new CuaHang();
        cuaHang.setId(idCH);
        ChucVu chucVu=new ChucVu();
        chucVu.setId(idCV);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(idGuiBC);
        NhanVien nv=new NhanVien("",ma,ten,tenDem,ho,gioiTinh,ngaySinh,diaChi,sdt,matKhau,cuaHang,chucVu,nhanVien,trangThai);
        System.out.println(nv.toString());
        nhanVienService.add(nv);
        response.sendRedirect("/hienThi/nhanVien");
    }
}
