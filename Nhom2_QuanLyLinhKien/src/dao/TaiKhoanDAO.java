package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;


public class TaiKhoanDAO {
		private Connection con;
		public TaiKhoanDAO() {
			
			try {
				con = ConnectDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public ArrayList<TaiKhoan> getalltbTaiKhoan() {
			TaiKhoan tk = null;
			ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
			try {
				String sql = "select * from TaiKhoan";
				PreparedStatement statement = con.prepareStatement(sql);

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					tk = new TaiKhoan(); 
					tk.setTaiKhoan(rs.getString("tenTK").trim());
					tk.setMatKhau(rs.getString("matKhau").trim());
					tk.setMaNV(rs.getString("maNv").trim());
					tk.setChucVu(rs.getString("chucVu").trim());
					dstk.add(tk);

				}
				

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			return dstk;
		}
		public TaiKhoan gettaiKhoan(String ten) {
			try {
				TaiKhoan tk = new TaiKhoan();
				String sql = "select * from TaiKhoan where tenTk = ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, ten);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					tk.setTaiKhoan(rs.getString("tenTK").trim());
					tk.setMatKhau(rs.getString("matKhau").trim());
					tk.setMaNV(rs.getString("maNv").trim());
					tk.setChucVu(rs.getString("chucVu").trim());
				}
				if(tk.getTaiKhoan() == null) {
					return null;
				}
				return tk;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
	 // xóa & thêm tài khoản
		public boolean createTK(TaiKhoan tk) throws SQLException {
			
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				if(gettaiKhoan(tk.getTaiKhoan()) != null) {
					return false;
				}else {
					stmt = con.prepareStatement("insert into TaiKhoan(tenTk , matKhau , chucVu, maNv) values(? , ? , ?,? )");
					stmt.setString(1, tk.getTaiKhoan());
					stmt.setString(2, tk.getMatKhau());
					stmt.setString(3 ,tk.getChucVu());
					stmt.setString(4 ,tk.getMaNV());

					n = stmt.executeUpdate();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		
		public boolean deleteTK(String maTK) {
		
			
			try {
				Connection con = 	ConnectDB.getInstance().getConnection();
				PreparedStatement stmt = null;
				stmt = con.prepareStatement("delete from TaiKhoan where maNv = ?");
				stmt.setString(1, maTK);
				stmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
