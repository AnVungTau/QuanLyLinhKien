package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVienDAO {
	public ArrayList<NhanVien> getalltbNhanVien() {
		ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM NhanVien";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			
			prepareStatement = con.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			 while (rs.next()) {
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				int sdt = rs.getInt(5);
				String diaChi =rs.getString(6);
				String email = rs.getString(7);
				String chucVu = rs.getString(8);
				NhanVien nv = new NhanVien(maNV,hoTen,gioiTinh,ngaySinh,sdt,diaChi,email,chucVu);
				listNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return listNV;
	}
//	
	public NhanVien thongTinNhanVienTheoMaNhanVien(String maNhanVien) {
		NhanVien nv = new NhanVien(maNhanVien);
		
		String sql = "Select * from NhanVien where maNv = ?";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maNhanVien);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				nv.setMaNV(rs.getString(1));
				nv.setTenNV(rs.getString(2));
				nv.setGioiTinh(rs.getBoolean(3));
				nv.setNgaySinh(rs.getDate(4));
				nv.setSdt(rs.getInt(5));
				nv.setDiaChi(rs.getString(6));
				nv.setEmail(rs.getString(7));
				nv.setChucVu(rs.getString(8));
				return nv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addNhanVien(NhanVien nv) {
		String sql  = "insert into NhanVien(tenNv, gioiTinh,namSinh, sdt, email, diaChi, chucVu) values(?, ?, ?, ?, ?, ?,?)";
		
		
		try {
			ConnectDB.getInstance().connect();;
			Connection conn = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nv.getTenNV());
			stmt.setBoolean(2, nv.isGioiTinh());
			stmt.setString(3, nv.getNgaySinh().toString());
			stmt.setInt(4, nv.getSdt());
			stmt.setString(5, nv.getDiaChi());
			stmt.setString(6, nv.getEmail());
			stmt.setString(7, nv.getChucVu());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateNhanVien(NhanVien nv) {
		String sql = "update NhanVien set tenNv = ?, gioiTinh = ?,namSinh = ?, sdt = ?, email = ?, diaChi = ?, chucVu = ? where maNv = ?";
		
		try {
			ConnectDB.getInstance();
			Connection conn = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nv.getTenNV());
			stmt.setBoolean(2, nv.isGioiTinh());
			stmt.setString(3, nv.getNgaySinh().toString());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getChucVu());
			stmt.setString(7, nv.getMaNV());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteNhanVien(String maNhanVien) {
		String sql = "delete NhanVien where maNv = ?";
		
		try {
			ConnectDB.getInstance();
			Connection conn = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, maNhanVien);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
