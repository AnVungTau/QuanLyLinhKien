package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

public class DoanhThu_DAO {
	public void luuDoanhThu(int thanhtoan)
	{
		LocalDate i = java.time.LocalDate.now();
		
		try{
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			Statement st = con.createStatement();
		int k = st.executeUpdate("insert into tb_doanhthu values ("+thanhtoan+",'"+i+"')");	 
		if(k>0) JOptionPane.showMessageDialog(null, "Đã thêm doanh thu");
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Lỗi khi thêm doanh thu!" + ex.toString());
		}
	}
	public DefaultTableModel loadDt(String time)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select thoi_gian, SUM(tong_tien) as doanhthu from tb_doanhthu where thoi_gian='"+time+"' group by thoi_gian");
			String[] tieudecot = {"Thời gian","Doanh thu"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("thoi_gian");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
	
	
	public DefaultTableModel loadDtFor(String chonHt)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		if(chonHt=="1")
		{
			ResultSet rs = st.executeQuery("select thoi_gian, SUM(tong_tien) as doanhthu from tb_doanhthu group by thoi_gian");
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("thoi_gian");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Thời gian","Doanh thu"};
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
		else if(chonHt == "2")
		{
			ResultSet rs = st.executeQuery("select year(thoi_gian) as nam, month(thoi_gian) as thang, sum(tong_tien) as doanhthu from tb_doanhthu group by year(thoi_gian),month(thoi_gian)");
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("nam");
				dong[1] = rs.getString("thang");
				dong[2] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Năm", "Tháng", "Doanh thu"};
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
		else
		{
			ResultSet rs = st.executeQuery("select year(thoi_gian)as nam, sum(tong_tien) as doanhthu from tb_doanhthu group by year(thoi_gian)");
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("nam");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Năm","Doanh thu"};
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
}
