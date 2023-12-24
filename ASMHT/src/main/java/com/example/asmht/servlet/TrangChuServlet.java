package com.example.asmht.servlet;

import com.example.asmht.entity.*;
import com.example.asmht.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@WebServlet(name = "TrangChuServlet", value ={"/thongTin/sanPham","/trangChu/hienThi"})
public class TrangChuServlet extends HttpServlet {
    ChiTietSPService chiTietSPService=new ChiTietSPService();
    KhachHangService khachHangService=new KhachHangService();
    GioHangService gioHangService=new GioHangService();
    HoaDonService hoaDonService=new HoaDonService();
    public static String idKH=new DangNhapServlet().id;
    public static String idCTSP="";
    public static String idGH="";
    public static String idHD="";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("/thongTin/sanPham")){
            this.thongTin(request,response);
        }else if(uri.contains("/trangChu/hienTh")){
            this.trangChu(request,response);
            System.out.println("nam_code");
            System.out.println("update");
        }
    }
    private void trangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(gioHangService.getGioHangByTrangThai(idKH)==null){
            String ma=String.valueOf(UUID.randomUUID()).substring(0,10);
            KhachHang khachHang=khachHangService.getById(idKH);
            String idNV="27DBC5AE-C0B6-4719-8897-90D40DC4A041";
            KhachHang kh=new KhachHang();
            kh.setId(idKH);
            long millis=System.currentTimeMillis();
            Date ngayTao=new java.sql.Date(millis);
            System.out.println(ngayTao);
            System.out.println("idKH: "+idKH);
            System.out.println("Vào if");
            gioHangService.addnew(new GioHang("",kh,idNV, ma,ngayTao,null,khachHang.getTen(),khachHang.getDiaChi(),khachHang.getSDT(),0));
            idGH=gioHangService.getGioHangByTrangThai(idKH).getId();
        }
        else {
            System.out.println("Vào else");
            idGH=gioHangService.getGioHangByTrangThai(idKH).getId();
        }
        if(hoaDonService.getHoaDonByTrangThai(idKH)==null){
            String idNV="27DBC5AE-C0B6-4719-8897-90D40DC4A041";
            NhanVien nv=new NhanVien();
            nv.setId(idNV);
            KhachHang kh=new KhachHang();
            kh.setId(idKH);
            String ma=String.valueOf(UUID.randomUUID()).substring(0,10);
            long millis=System.currentTimeMillis();
            Date ngayTao=new java.sql.Date(millis);
            long millis2=System.currentTimeMillis();
            Date ngayThanhToan=new java.sql.Date(millis2);
            long millis3=System.currentTimeMillis();
            Date ngayShip=new java.sql.Date(millis3);
            long millis4=System.currentTimeMillis();
            Date ngayNhan=new java.sql.Date(millis4);
            int tinhTrang=0;
            String tenNguoiNhan= khachHangService.getById(idKH).getTen();
            String diaChi=khachHangService.getById(idKH).getDiaChi();
            String sdt=khachHangService.getById(idKH).getSDT();
            HoaDon hoaDon=new HoaDon("",kh,nv,ma,ngayTao,ngayThanhToan,ngayShip,ngayNhan,tinhTrang,tenNguoiNhan,diaChi,sdt);
            hoaDonService.add(hoaDon);
            idHD=hoaDonService.getHoaDonByTrangThai(idKH).getId();
            System.out.println("IDHD: "+idHD);
        }else{
            idHD=hoaDonService.getHoaDonByTrangThai(idKH).getId();
            System.out.println("IDHD: "+idHD);
        }
        System.out.println("Trang chủ:");
        System.out.println("idGH: "+idGH+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("idHD: "+idHD+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        request.setAttribute("kh",khachHangService.getById(idKH));
        request.setAttribute("lstCTSP",chiTietSPService.getList());
        request.getRequestDispatcher("/trang-chu.jsp").forward(request,response);
    }
    private void thongTin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idCTSP=request.getParameter("id");
        System.out.println(idCTSP+"{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{[");
        ChiTietSanPham chiTietSanPham=chiTietSPService.getById(idCTSP);
        request.setAttribute("spct",chiTietSanPham);
        request.getRequestDispatcher("/thong-tin-san-pham.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
