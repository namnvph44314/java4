package com.example.asmht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {
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

    @Column(name = "IdNV")
    private String idNV;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sDT;
    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @Override
    public String toString() {
        return "GioHang{" +
                "id='" + id + '\'' +
                ", khachHang=" + khachHang +
                ", idNV=" + idNV +
                ", ma='" + ma + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngayThanhToan=" + ngayThanhToan +
                ", tenNguoiNhan='" + tenNguoiNhan + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sDT='" + sDT + '\'' +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
