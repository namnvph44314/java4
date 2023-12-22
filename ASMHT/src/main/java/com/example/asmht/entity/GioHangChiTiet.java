package com.example.asmht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;
    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham chiTietSanPham;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    @Override
    public String toString() {
        return "GioHangChiTiet{" +
                "gioHang=" + gioHang.getId() +
                ", chiTietSanPham=" + chiTietSanPham.getId() +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donGiaKhiGiam=" + donGiaKhiGiam +
                '}';
    }
}
