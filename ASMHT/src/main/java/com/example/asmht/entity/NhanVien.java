package com.example.asmht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sDT;
    @Column(name = "MatKhau")
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;
    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;
    @ManyToOne
    @JoinColumn(name = "IdGuiBC")
    private NhanVien nhanVien;
    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "NhanVien{" +
                "id='" + id + '\'' +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", tenDem='" + tenDem + '\'' +
                ", ho='" + ho + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", sDT='" + sDT + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", cuaHang=" + cuaHang +
                ", chucVu=" + chucVu +
                ", nhanVien=" + nhanVien +
                ", trangThai=" + trangThai +
                '}';
    }
}
