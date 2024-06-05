package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_DAO {
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * from HoaDon";
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);
				
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien tenNV = new NhanVien(rs.getString("tenNV"));
				KhachHang tenKH = new KhachHang(rs.getString("tenKhachHang"));
				LocalDate ngayLapHD= rs.getDate("ngayLapHD") != null ? LocalDate.parse(rs.getDate("ngayLapHD").toString()) : null;
				double tongTien = rs.getDouble("tongTien");
				HoaDon hd = new HoaDon(maHD, tenNV, tenKH, ngayLapHD, tongTien);
				dsHoaDon.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHoaDon;
	}
}
