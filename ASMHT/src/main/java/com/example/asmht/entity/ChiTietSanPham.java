package com.example.asmht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne
    @JoinColumn (name = "IdSP")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NXS nSX;
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @Column(name = "namBH")
    private Integer namBaoHanh;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Column(name = "GiaBan")
    private BigDecimal giaBan;

}
