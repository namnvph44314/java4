package com.example.asmht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "NgayShip")
    private Date ngayShip;
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    @Column(name = "TinhTrang")
    private Integer tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sDT;

    public String getTinhTrang(int tinhTrang){
        if(tinhTrang == 3){
            return "Đã hủy";
        }else if(tinhTrang==0){
            return "Chờ thanh toán";
        }else if(tinhTrang==1){
            return "Đang giao hàng";
        }else{
            return "Đã thanh toán";
        }
    }
}
