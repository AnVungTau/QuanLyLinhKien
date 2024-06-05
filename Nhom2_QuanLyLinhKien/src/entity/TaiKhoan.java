package entity;

import java.io.Serializable;
import java.util.Objects;

public class TaiKhoan  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String taiKhoan;
	private String matKhau;
	private String maNV;
	private String chucVu;
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TaiKhoan(String taiKhoan, String matKhau, String maNV, String chucVu) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
		this.chucVu = chucVu;
	}
	public TaiKhoan(String taiKhoan) {
		super();
		this.taiKhoan = taiKhoan;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", maNV=" + maNV + ", chucVu=" + chucVu
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maNV, other.maNV);
	} 
	
}
