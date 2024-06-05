package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class TaiKhoanGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoanGUI frame = new TaiKhoanGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaiKhoanGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(142, 61, 192, 20);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		lblTaiKhoan.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblTaiKhoan.setBounds(60, 61, 66, 20);
		contentPane.add(lblTaiKhoan);
		
		JLabel lblMK =new JLabel("Mật khẩu");
		lblMK.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblMK.setBounds(60, 105, 66, 20);
		contentPane.add(lblMK);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(142, 105, 192, 20);
		contentPane.add(txtMatKhau);
		
		JButton btnTao = new JButton("Tạo");
		btnTao.setBounds(245, 165, 89, 23);
		contentPane.add(btnTao);
		
		JButton btnNhap = new JButton("Nhập lại");
		btnNhap.setBounds(146, 165, 89, 23);
		contentPane.add(btnNhap);
		
		JLabel lblNewLabel = new JLabel("Tạo tài khoản");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel.setBounds(166, 11, 140, 20);
		contentPane.add(lblNewLabel);
	}
}
