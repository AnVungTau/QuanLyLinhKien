package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import dao.KhachHangDAO;
import entity.KhachHang;


import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class FrmKhachHang extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	
	private DefaultTableModel dfModel;
	private JTable table;
	
	private JScrollPane scrollPane;
	private JTextField textField;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTim;
	private JButton btnXoaRong;
	private JButton btnLuu;
	
	private JComboBox<String> cbbGioiTinh;
	private JPanel pnCenter;
	
	/**
	 * Create the panel.
	 */
	public FrmKhachHang() {
		setBorder(null);
		
		this.setPreferredSize(new Dimension(1110, 612));
		setLayout(null);
		
		pnCenter = new JPanel();
		pnCenter.setBounds(1, 0, 1104, 611);
		add(pnCenter);
		pnCenter.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setBounds(236, 11, 99, 14);
		pnCenter.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(345, 8, 196, 20);
		pnCenter.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ: ");
		lblDiaChi.setBounds(236, 36, 46, 14);
		pnCenter.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(345, 33, 196, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setBounds(578, 11, 86, 14);
		pnCenter.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(676, 8, 143, 20);
		pnCenter.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(597, 36, 46, 14);
		pnCenter.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(676, 33, 143, 20);
		pnCenter.add(txtEmail);
		txtEmail.setColumns(10);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 614, 1095, 36);
		pnCenter.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JLabel lblTimKH = new JLabel("Tìm theo tên Khách Hàng");
		panel.add(lblTimKH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JButton btnTim = new JButton("Tìm Kiếm");
		panel.add(btnTim);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		btnThem = new JButton("Thêm");
		panel_1.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		panel_1.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		panel_1.add(btnSua);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		panel_1.add(btnXoaRong);
		
		btnLuu = new JButton("Lưu");
		panel_1.add(btnLuu);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(861, 11, 56, 14);
		pnCenter.add(lblGioiTinh);
		
		String[] gt = {
				"Nam","Nữ"
		};
		cbbGioiTinh = new JComboBox(gt);
		cbbGioiTinh.setBounds(917, 7, 68, 22);
		pnCenter.add(cbbGioiTinh);
		
		String[] row = {
				"Tên Khách Hàng","Địa chỉ","Email", "Số Điện Thoại","Giới Tính"
		};
		
		dfModel = new DefaultTableModel(row,0);
		table = new JTable(dfModel);
		table.setBounds(79, 518, 1006, -411);
		pnCenter.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(79, 108, 1006, 412);
		pnCenter.add(scrollPane);
		
		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
	}
	
	
	private void xoaRongTextfieldKH() {
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
	}
	
	public void loadDataToTable() {
		try {
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			List<KhachHang> listKH = khachHangDAO.getDanhSachKhachHang();

			for (KhachHang khachHang : listKH) {
				dfModel.addRow(new Object[] {  khachHang.getTenKH(), khachHang.getDiaChi(),
						khachHang.getSdt(), khachHang.getEmail(), khachHang.getGioiTinh()  });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


		private KhachHang createKhachHang() {
			KhachHang khachHang = new KhachHang();
			khachHang.setTenKH(txtTenKH.getText());
			khachHang.setDiaChi(txtDiaChi.getText());
			int sdt = Integer.parseInt(txtSDT.getText());
			khachHang.setSdt(sdt);
			khachHang.setEmail(txtEmail.getText());
			String gt = cbbGioiTinh.getSelectedItem().toString();
			Boolean tam = null;
			if (gt == "Nam") {
				tam = true;
			}else {
				tam = false;
			}
			khachHang.setGioiTinh(tam);
			return khachHang;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();


			if (o.equals(btnThem)) {
				KhachHang khachHang = createKhachHang();
				KhachHangDAO khachHangDAO = new KhachHangDAO();

				

				if (khachHangDAO.checkExist(txtSDT.getText())) {
					JOptionPane.showMessageDialog(null, "Khách Hàng Đã Tồn Tại");
					return;
				} else {
					if (khachHangDAO.addKhachHang(khachHang)) {
						JOptionPane.showMessageDialog(null, "Thêm Thành Công ");
						dfModel.setRowCount(0);
						loadDataToTable();
						xoaRongTextfieldKH();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi Thêm Không Thành Công");
					}
				}
			}

			// CẬP NHẬT THÔNG TIN KHÁCH HÀNG
			if (o.equals(btnSua)) {
				int row = table.getSelectedRow();
				KhachHang khachHang = createKhachHang();
				int sdt = Integer.parseInt(txtSDT.getText());
				khachHang.setSdt(sdt);
				
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				if (row >= 0) {
					if (khachHangDAO.checkExist(txtSDT.getText())) {
						JOptionPane.showMessageDialog(null, "Cảnh Báo  số điện thoại trùng");
						return;
					} else {
						if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn cập nhật?") == JOptionPane.NO_OPTION) {
							return;
						}
						try {

							if (khachHangDAO.updateKhachHang(khachHang)) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								dfModel.setRowCount(0);
								loadDataToTable();

							} else {
								JOptionPane.showMessageDialog(null,  "Cập nhật không thành công");
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}

				} else {
					JOptionPane.showMessageDialog(null,  "Phải chọn một dòng trong bảng");
				}
				xoaRongTextfieldKH();

			}
			// XÓA KH
			if (o.equals(btnXoa)) {

				int row = table.getSelectedRow();
				KhachHangDAO khDAO = new KhachHangDAO();

				if (row >= 0) {
					String maKH = (String) table.getValueAt(row, 0);
					String stt = maKH.replaceAll("KH", "");
					if (JOptionPane.showConfirmDialog(null, 
							"Bạn có chắc muốn xóa khách hàng này") == JOptionPane.WARNING_MESSAGE) {
						return;
					}

					try {

						if (khDAO.deleteKhachHang(stt)) {
							JOptionPane.showMessageDialog(null,  "Xóa thành công");
							dfModel.setRowCount(0);
							loadDataToTable();

						} else {
							JOptionPane.showMessageDialog(null, "Xóa không thành công");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Phải chọn 1 dòng trong bảng");
				}

			}

		}
	
		public static void main(String[] args) {
			new FrmKhachHang().setVisible(true);
		}
}
