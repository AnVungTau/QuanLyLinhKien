package entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	 private String maNV;
	 private String tenNV;
	 private boolean gioiTinh;
	 private Date ngaySinh;
	 private int sdt;
	 private String diaChi;
	 private String email;
	 private String chucVu;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", sdt=" + sdt + ", diaChi=" + diaChi + ", email=" + email + ", chucVu=" + chucVu + "]";
	}
	public NhanVien(String maNV, String tenNV, boolean gioiTinh, Date ngaySinh, int sdt, String diaChi, String email,
			String chucVu) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.chucVu = chucVu;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(tenNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(tenNV, other.tenNV);
	}
	public NhanVien(String tenNV, boolean gioiTinh, Date ngaySinh, int sdt, String diaChi, String email,
			String chucVu) {
		super();
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.chucVu = chucVu;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	
}
