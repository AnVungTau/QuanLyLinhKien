package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.NhanVien;
public class NhanVienGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenNv;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtTim;
	private JTable tblNhanVien;
	private DefaultTableModel modelNhanVien;
	private JButton btnTim, btnThem, btnXoa,btnSua, btnXoaTrang, btnLuu;
	private JComboBox<Object> cbbGioiTinh, cbbChucVu;
	private JDateChooser ngaySinh;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGUI frame = new NhanVienGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public NhanVienGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1311, 698);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(0, 0, 1311, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblXinChao = new JLabel("<USERNAME>");
		lblXinChao.setBackground(new Color(238, 238, 238));
		lblXinChao.setBounds(0, 0, 203, 49);
		lblXinChao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblXinChao);
		lblXinChao.setForeground(new Color(121, 138, 153));
		lblXinChao.setFont(new Font("SansSerif", Font.BOLD, 25));
		
		JPanel pnMenu = new JPanel();
		pnMenu.setLayout(null);
		pnMenu.setBackground(new Color(238, 238, 238));
		pnMenu.setBounds(0, 48, 201, 611);
		contentPane.add(pnMenu);
		
		JPanel navQLLK = new JPanel();
		navQLLK.setLayout(null);
		navQLLK.setBackground(new Color(205, 221, 237));
		navQLLK.setBounds(0, 76, 202, 65);
		pnMenu.add(navQLLK);
		
		JLabel lblLK = new JLabel("LINH KIỆN");
		lblLK.setBounds(0, 0, 202, 65);
		navQLLK.add(lblLK);
		lblLK.setHorizontalAlignment(SwingConstants.CENTER);
		lblLK.setForeground(Color.BLACK);
		lblLK.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JPanel navNV = new JPanel();
		navNV.setLayout(null);
		navNV.setBackground(new Color(164, 184, 204));
		navNV.setBounds(0, 152, 202, 65);
		pnMenu.add(navNV);
		
		JLabel lblQLNV = new JLabel("NHÂN VIÊN");
		lblQLNV.setBackground(new Color(164, 184, 204));
		lblQLNV.setBounds(0, 0, 202, 65);
		navNV.add(lblQLNV);
		lblQLNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLNV.setForeground(Color.BLACK);
		lblQLNV.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JPanel navKH = new JPanel();
		navKH.setLayout(null);
		navKH.setBackground(new Color(205, 221, 237));
		navKH.setBounds(0, 228, 202, 65);
		pnMenu.add(navKH);
		
		JLabel lblQuanLyDonHang = new JLabel("KHÁCH HÀNG");
		lblQuanLyDonHang.setBounds(0, 0, 202, 65);
		navKH.add(lblQuanLyDonHang);
		lblQuanLyDonHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyDonHang.setForeground(Color.BLACK);
		lblQuanLyDonHang.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JPanel navDangXuat = new JPanel();
		navDangXuat.setLayout(null);
		navDangXuat.setBackground(new Color(205, 221, 237));
		navDangXuat.setBounds(0, 546, 202, 65);
		pnMenu.add(navDangXuat);
		
		JLabel lblngXut = new JLabel("ĐĂNG XUẤT");
		lblngXut.setBounds(0, 0, 202, 65);
		navDangXuat.add(lblngXut);
		lblngXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblngXut.setForeground(Color.BLACK);
		lblngXut.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		
		JPanel navHD = new JPanel();
		navHD.setLayout(null);
		navHD.setBackground(new Color(205, 221, 237));
		navHD.setBounds(0, 304, 202, 65);
		pnMenu.add(navHD);
		
		JLabel lblphanhoi = new JLabel("HOÁ ĐƠN");
		lblphanhoi.setBounds(0, 0, 202, 65);
		navHD.add(lblphanhoi);
		lblphanhoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblphanhoi.setForeground(Color.BLACK);
		lblphanhoi.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JPanel navTrangChu = new JPanel();
		navTrangChu.setBounds(0, 0, 202, 65);
		pnMenu.add(navTrangChu);
		navTrangChu.setLayout(null);
		navTrangChu.setBackground(new Color(205, 221, 237));
		
		JLabel lblTrangChu = new JLabel("TRANG CHỦ");
		lblTrangChu.setBackground(new Color(205, 221, 237));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setForeground(Color.BLACK);
		lblTrangChu.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTrangChu.setBounds(0, 0, 202, 65);
		navTrangChu.add(lblTrangChu);
		
		JPanel navTK = new JPanel();
		navTK.setLayout(null);
		navTK.setBackground(new Color(205, 221, 237));
		navTK.setBounds(0, 380, 202, 65);
		pnMenu.add(navTK);
		
		JLabel lblThngK = new JLabel("THỐNG KÊ");
		lblThngK.setBackground(new Color(220, 232, 243));
		lblThngK.setBounds(0, 0, 202, 65);
		navTK.add(lblThngK);
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setForeground(Color.BLACK);
		lblThngK.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JPanel pnContent = new JPanel();
		pnContent.setBackground(SystemColor.controlHighlight);
		pnContent.setLayout(null);
		pnContent.setBounds(201, 85, 1109, 574);
		contentPane.add(pnContent);
		
		JLabel lblTenNv = new JLabel("Tên nhân viên:");
		lblTenNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNv.setBounds(10, 11, 86, 22);
		pnContent.add(lblTenNv);
		
		txtTenNv = new JTextField();
		txtTenNv.setColumns(10);
		txtTenNv.setBounds(115, 13, 254, 20);
		pnContent.add(txtTenNv);
		
		JLabel lblSdt = new JLabel("Số điện thoại: ");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSdt.setBounds(393, 11, 86, 22);
		pnContent.add(lblSdt);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(684, 11, 86, 22);
		pnContent.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(10, 44, 86, 22);
		pnContent.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(115, 46, 254, 20);
		pnContent.add(txtDiaChi);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChucVu.setBounds(682, 44, 70, 22);
		pnContent.add(lblChucVu);
		
		JSplitPane splitPaneBtn = new JSplitPane();
		splitPaneBtn.setBounds(10, 528, 1075, 35);
		pnContent.add(splitPaneBtn);
		
		JPanel pnLeft = new JPanel();
		splitPaneBtn.setLeftComponent(pnLeft);
		
		JLabel lblTimKiem = new JLabel("Tìm theo mã:");
		pnLeft.add(lblTimKiem);
		
		txtTim = new JTextField();
		txtTim.setColumns(20);
		pnLeft.add(txtTim);
		
		JButton btnTim = new JButton("Tìm kiếm");
		pnLeft.add(btnTim);
		
		Box horizontalBox = Box.createHorizontalBox();
		pnLeft.add(horizontalBox);
		
		JPanel pnRight = new JPanel();
		splitPaneBtn.setRightComponent(pnRight);
		pnRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnThem = new JButton("Thêm");
		pnRight.add(btnThem);
		
		JButton btnXoa = new JButton("Xoá");
		pnRight.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		pnRight.add(btnSua);
		
		JButton btnXoaRong = new JButton("Xoá rỗng");
		pnRight.add(btnXoaRong);
		
		JButton btnLuu = new JButton("Lưu");
		pnRight.add(btnLuu);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(499, 13, 156, 20);
		pnContent.add(txtSdt);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(752, 13, 333, 20);
		pnContent.add(txtEmail);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(917, 47, 63, 16);
		pnContent.add(lblGioiTinh);
		
		JComboBox<Object> cbbGioiTinh = new JComboBox<Object>();
		cbbGioiTinh.setBounds(990, 45, 95, 22);
		pnContent.add(cbbGioiTinh);
		
		JLabel lblBirthDate = new JLabel("Ngày sinh:");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBirthDate.setBounds(393, 44, 70, 22);
		pnContent.add(lblBirthDate);
		
		 ngaySinh = new JDateChooser();
		 ngaySinh.setBounds(499, 46, 156, 20);
		pnContent.add(ngaySinh);
		
		JComboBox<Object> cbbChucVu = new JComboBox<Object>();
		cbbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbChucVu.setBounds(752, 45, 137, 22);
		pnContent.add(cbbChucVu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 77, 1075, 442);
		pnContent.add(scrollPane_1);
		
		tblNhanVien = new JTable();
		scrollPane_1.setViewportView(tblNhanVien);
		tblNhanVien.setToolTipText("");
		tblNhanVien.setModel(modelNhanVien = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Email", "Ch\u1EE9c v\u1EE5"
			}
		));
		tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(15);
		tblNhanVien.getColumnModel().getColumn(2).setMinWidth(5);
		tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(40);
		tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(70);
		tblNhanVien.getColumnModel().getColumn(5).setResizable(false);
		tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblNhanVien.getColumnModel().getColumn(7).setPreferredWidth(40);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(220, 232, 243));
		pnTitle.setBounds(201, 48, 1109, 39);
		contentPane.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblQLNV1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQLNV1.setBackground(new Color(164, 184, 204));
		lblQLNV1.setBounds(0, 0, 1109, 39);
		lblQLNV1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLNV1.setForeground(Color.BLACK);
		lblQLNV1.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnTitle.add(lblQLNV1);
	}
	private void xoatrang() {
		txtTenNv.setText("");
		txtSdt.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtTenNv.requestFocus();
	}
	private void addNVvaoTextField() {
		int row = tblNhanVien.getSelectedRow();
		if (row >= 0) {
			txtTenNv.setText(modelNhanVien.getValueAt(row, 1).toString());
			cbbGioiTinh.setSelectedItem(modelNhanVien.getValueAt(row, 2));
			txtSdt.setText(modelNhanVien.getValueAt(row, 4).toString());
			txtDiaChi.setText(modelNhanVien.getValueAt(row, 5).toString());
			txtEmail.setText(modelNhanVien.getValueAt(row, 6).toString());
			cbbChucVu.setSelectedItem(modelNhanVien.getValueAt(row, 7).toString());
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		  if (o.equals(btnThem)) {
			//  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String TenNV = txtTenNv.getText();
				Date ngaysinh = ngaySinh.getDate();
				boolean gioiTinh = Boolean.parseBoolean((String) (cbbGioiTinh.getSelectedItem()));
				int sdt = Integer.parseInt(txtSdt.getText());
				String diachi  = txtDiaChi.getText();
				String email = txtEmail.getText();
				String chucVu = (String) cbbChucVu.getSelectedItem();
				NhanVien nv = new NhanVien(TenNV, gioiTinh, ngaysinh, sdt, diachi, email, chucVu);
				modelNhanVien.addRow(new Object[] { nv.getTenNV(),nv.getNgaySinh(), nv.isGioiTinh(),nv.getSdt(),nv.getDiaChi(),nv.getEmail(),nv.getChucVu()});
				JOptionPane.showMessageDialog(this, "Thêm thành công");		
		  }
	 	if (o.equals(btnLuu)) {	
	 		
		}
//		
//		if (o.equals(btnSua)) {
//			String maNV = txtMaNV.getText();
//		String TenNV = txtTenNV.getText();
//		boolean gioiTinh = Boolean.parseBoolean((String) (cbbGioiTinh.getSelectedItem()));
//		//int tuoi;
//		int sdt = Integer.parseInt(txtSdt.getText());
//		String diachi  = txtDiaChi.getText();
//		String email = txtEmail.getText();
//		String chucVu = (String) cbbChucVu.getSelectedItem();
//		NhanVien nv = new NhanVien(maNV,TenNV,gioiTinh,sdt,diachi,email,chucVu);
//		modelNhanVien.addRow(new Object[] {nv.getMaNV(), nv.getTenNV(),nv.isGioiTinh(),nv.getSdt(),nv.getDiaChi(),nv.getEmail(),nv.getChucVu()});
//		}
//		
		if (o.equals(btnXoa)) {
			int r = tblNhanVien.getSelectedRow();
			if(r != -1) {
				int id = Integer.parseInt((String) tblNhanVien.getModel().getValueAt(r, 0));
				int x = JOptionPane.showConfirmDialog(null,"Xác nhận xoá?","Delete",JOptionPane.YES_NO_CANCEL_OPTION);
				if(x == JOptionPane.YES_OPTION) {
					modelNhanVien.removeRow(r);
					xoatrang();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Chọn dòng để xoá");
			}
			}

		if (o.equals(btnXoaTrang)) {
			xoatrang();
		} 
		if (o.equals(btnTim)) {
			String maNV = txtTim.getText();
			int totalRow, timThay = 0;
			if (!maNV.equals("")) {
				totalRow = tblNhanVien.getRowCount() - 1;
				for (int i = totalRow; i >= 0; i--) {
					if (maNV.equalsIgnoreCase((String) tblNhanVien.getValueAt(i, 0))) {
						tblNhanVien.setRowSelectionInterval(i, i);
						addNVvaoTextField();
						timThay = 1;
						break;
					}
				}
				if (timThay == 0) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm");
			}

			
		}
		
	}
}
