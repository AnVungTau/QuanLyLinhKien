package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JButton btnDangNhap;
	private dao.NhanVienDAO getNv = new dao.NhanVienDAO();
	private ArrayList<NhanVien> listNhanVien = getNv.getalltbNhanVien();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DangNhap() throws SQLException {
		ConnectDB.getInstance().getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(174, 76, 160, 20);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		lblTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTaiKhoan.setBounds(68, 76, 83, 17);
		contentPane.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatKhau.setBounds(68, 105, 83, 31);
		contentPane.add(lblMatKhau);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(174, 112, 160, 20);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangNhap.setBounds(230, 155, 103, 23);
		contentPane.add(btnDangNhap);
		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
			if (o.equals(btnDangNhap)) {
				String taiKhoan = txtTaiKhoan.getText();	
				String matKhau = txtMatKhau.getText();
				TaiKhoan tK = new TaiKhoan();
				for(int i = 0; i < listNhanVien.size(); i++) {
					NhanVien x = listNhanVien.get(i);
					if(taiKhoan.trim().equals(tK.getTaiKhoan()) && matKhau.trim().equals(tK.getMatKhau())) {
							JOptionPane.showMessageDialog(btnDangNhap, "Đăng nhập thành công");
							setVisible(false);
							new GD_ManHinhChinh().setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(btnDangNhap, "Đăng nhập thất bại");
					}
				}
			}	
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	}
