package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private NhanVien tenNV;
	private KhachHang tenKH;
	private LocalDate ngayLapHD;
	private double tongTien;
	public String getMaHD() {
	 	return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getTenNV() {
		return tenNV;
	}
	public void setTenNV(NhanVien tenNV) {
		this.tenNV = tenNV;
	}
	public KhachHang getTenKH() {
		return tenKH;
	}
	public void setTenKH(KhachHang tenKH) {
		this.tenKH = tenKH;
	}
	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", tenNV=" + tenNV + ", tenKH=" + tenKH + ", ngayLapHD=" + ngayLapHD
				+ ", tongTien=" + tongTien + "]";
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, NhanVien tenNV, KhachHang tenKH, LocalDate ngayLapHD, double tongTien) {
		super();
		this.maHD = maHD;
		this.tenNV = tenNV;
		this.tenKH = tenKH;
		this.ngayLapHD = ngayLapHD;
		this.tongTien = tongTien;
	}
	public HoaDon(NhanVien tenNV, KhachHang tenKH, LocalDate ngayLapHD, double tongTien) {
		super();
		this.tenNV = tenNV;
		this.tenKH = tenKH;
		this.ngayLapHD = ngayLapHD;
		this.tongTien = tongTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
	
	
}
