package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHangDAO {
	
	
	public ArrayList<KhachHang> getDanhSachKhachHang() {
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		String sql = "SELECT * FROM KhachHang";

		

		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			
			prepareStatement = con.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();

			while (rs.next()) {
				
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String diaChi = rs.getString(3);
				int SDT = rs.getInt(4);
				String email = rs.getString(5);
				Boolean gioitinh = rs.getBoolean(6);

				KhachHang KhachHang = new KhachHang(maKhachHang,tenKhachHang,diaChi,SDT,email,gioitinh);

				listKhachHang.add(KhachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return listKhachHang;
	}
	
	public boolean addKhachHang(KhachHang KhachHang) {
		String sql = "INSERT INTO [dbo].[KhachHang] ([TenKh], [diaChi] ,[sdt],[email],[gioiTinh])" + " VALUES(?,?,?,?,?)";
		int rs = 0;
		

		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, KhachHang.getTenKH());
			prepareStatement.setString(2, KhachHang.getDiaChi());
			prepareStatement.setInt(3, KhachHang.getSdt());
			prepareStatement.setString(4, KhachHang.getEmail());
			prepareStatement.setBoolean(5, KhachHang.getGioiTinh());
			

			rs = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}

		return rs > 0;
	}
	public boolean checkExist(String sdt) {
		boolean check = false;
		String sql = "select * from KhachHang where sdt = ?";

		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			
			prepareStatement = con.prepareStatement(sql);

			prepareStatement.setString(1, sdt);
			ResultSet rs = prepareStatement.executeQuery();
			check = rs.next();
		} catch (Exception ex) {
			ex.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return check;
	}

	public boolean updateKhachHang(KhachHang KhachHang) {
		String sql = "UPDATE KhachHang SET tenKh=?,sdt=?" + " where maKh = ?";
		int rs = 0;

//		Connection con = connectDB.getJDBCConnection();
//		PreparedStatement prepareStatement = null;

		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			
			prepareStatement = con.prepareStatement(sql);

			prepareStatement.setString(1, KhachHang.getTenKH());
			prepareStatement.setInt(2, KhachHang.getSdt());

			String maKhachHang = KhachHang.getMaKH();
			String stt = maKhachHang.replaceAll("KH", "");
			prepareStatement.setInt(3, Integer.parseInt(stt));

			rs = prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return rs > 0;
	}
	
	public boolean deleteKhachHang(String maKhachHang) {
		String sql = "DELETE FROM KhachHang" + " where maKh= ?";
		int rs = 0;
//		Connection con = connectDB.getJDBCConnection();
//		PreparedStatement prepareStatement = null;

		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement prepareStatement = null;
			prepareStatement = con.prepareStatement(sql);

			prepareStatement.setString(1, maKhachHang);

			rs = prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return rs > 0;
	}
}
