package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.LinhKien_DAO;
import dao.LoaiLinhKien_DAO;
import dao.NhaCungCap_DAO;

import entity.LinhKien;
import entity.LoaiLinhKien;
import entity.NhaCungCap;

public class GD_LinhKien extends JPanel implements ActionListener, MouseListener, PropertyChangeListener, ChangeListener{

	public static void main(String[] args) {
		new GD_LinhKien().setVisible(true);
	}

	private JTextField txtTenLK;
	private JTextField txtNsx;
	private JTextField txtGia;
	private JTextField txtTimLinhKien;
	private DefaultTableModel modelTableLinhKien;
	private JTable tableLinhKien;
	private JComboBox cbLocLinhKien;
	private JButton btnTimKiem;
	private JButton btnXoaRong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JComboBox  cbLoaiLK;
	private JComboBox<String> cbNsx;
	private JDateChooser JdateNgaySX;
	private LinhKien_DAO daoLinhKien= new LinhKien_DAO();
	private LoaiLinhKien_DAO daoLoaiLk = new LoaiLinhKien_DAO();
	private NhaCungCap_DAO daoNcc = new NhaCungCap_DAO();
	private ArrayList<LinhKien> listLinhKien = daoLinhKien.getAllLinhKien();
	private JTextField txtChiTiet;
	private JTextField txtNgaySX;
	private JTextField txtSoLuong;
	private JPanel pnCenter;
	private JButton btnLoc;
	private JButton btnCapNhat;
	
	public GD_LinhKien() {
		setBorder(null);
		
		this.setPreferredSize(new Dimension(1110, 612));
		setLayout(null);
		
		pnCenter = new JPanel();
		pnCenter.setBounds(1, 0, 1104, 611);
		add(pnCenter);
		pnCenter.setLayout(null);
		
		//----------title -------------//
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(220, 232, 243));
		pnTitle.setBounds(0, 0, 1104, 39);
		pnTitle.setLayout(null);
		
		JLabel lblLK = new JLabel("LINH KIỆN");
		lblLK.setBackground(new Color(164, 184, 204));
		lblLK.setBounds(450, 5, 200, 26);
		
		lblLK.setHorizontalAlignment(SwingConstants.CENTER);
		lblLK.setForeground(Color.BLACK);
		lblLK.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnTitle.add(lblLK);
		
		pnCenter.add(pnTitle);
		
		btnLoc = new JButton("Lọc: ");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoc.setBounds(886, 6, 87, 26);
		pnTitle.add(btnLoc);
		
		cbLocLinhKien = new JComboBox();
		cbLocLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbLocLinhKien.setModel(new DefaultComboBoxModel(new String[] {"Linh kiện", "Loại linh kiện", "Nhà cung cấp"}));
		cbLocLinhKien.setBounds(983, 6, 105, 26);
		pnTitle.add(cbLocLinhKien);
		
		/* -------------Content------------------ */
		JPanel pnContent = new JPanel();
		pnContent.setBackground(SystemColor.controlHighlight);
		pnContent.setLayout(null);
		pnContent.setBounds(0, 40, 1104, 575);
		
		pnCenter.add(pnContent);

		
		JLabel lblTenLK = new JLabel("Tên linh kiện: ");
		lblTenLK.setBounds(10, 13, 86, 22);
		lblTenLK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnContent.add(lblTenLK);
		txtTenLK = new JTextField();
		txtTenLK.setBounds(103, 14, 174, 22);
		pnContent.add(txtTenLK);
		txtTenLK.setColumns(10);
		
		JLabel lblLoaiLK = new JLabel("Loại linh kiện: ");
		lblLoaiLK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoaiLK.setBounds(287, 13, 86, 22);
		pnContent.add(lblLoaiLK);
		
		cbLoaiLK = new JComboBox ();
		cbLoaiLK.setBounds(381, 14, 181, 22);
		pnContent.add(cbLoaiLK);
		
		try {
			cbLoaiLK.setModel(new DefaultComboBoxModel(getListLoaiLk()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNgaySX = new JLabel("Ngày sản xuất: ");
		lblNgaySX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgaySX.setBounds(10, 46, 95, 22);
		pnContent.add(lblNgaySX);
		
		JdateNgaySX = new JDateChooser();
		JdateNgaySX.setBounds(254, 46, 23, 22);
		JdateNgaySX.setDate(new java.util.Date());
		pnContent.add(JdateNgaySX);
		
		txtNgaySX= new JTextField();
		txtNgaySX.setEditable(false);
		txtNgaySX.setBounds(103, 46, 152, 22);
		pnContent.add(txtNgaySX);
		
		JLabel lblNhaSX = new JLabel("Nhà sản xuất: ");
		lblNhaSX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhaSX.setBounds(464, 46, 86, 22);
		pnContent.add(lblNhaSX);
		
		cbNsx = new JComboBox <String>();
		cbNsx.setBounds(560, 47, 190, 22);
		cbNsx.setEditable(true);
		pnContent.add(cbNsx);
		
		try {
			cbNsx.setModel(new DefaultComboBoxModel(getListNcc()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblGia = new JLabel("Giá: ");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGia.setBounds(287, 46, 33, 22);
		pnContent.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(315, 46, 139, 22);
		pnContent.add(txtGia);
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong.setBounds(572, 13, 70, 22);
		pnContent.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(634, 13, 86, 22);
		pnContent.add(txtSoLuong);
		
		
		JSplitPane splitPaneBtn = new JSplitPane();
		splitPaneBtn.setBounds(10, 528, 1095, 35);
		pnContent.add(splitPaneBtn);
		
		JPanel pnLeft = new JPanel();
		splitPaneBtn.setLeftComponent(pnLeft);
		
		JLabel lblTimKiem = new JLabel("Nhập thông tin cần tìm: ");
		pnLeft.add(lblTimKiem);
		
		txtTimLinhKien = new JTextField();
		pnLeft.add(txtTimLinhKien);
		txtTimLinhKien.setColumns(30);
		
		btnTimKiem = new JButton("Tìm kiếm");
		pnLeft.add(btnTimKiem);
		
		Box horizontalBox = Box.createHorizontalBox();
		pnLeft.add(horizontalBox);
		
		JPanel pnRight = new JPanel();
		splitPaneBtn.setRightComponent(pnRight);
		btnThem = new JButton("   Thêm   ");
		pnRight.add(btnThem);
		btnXoa = new JButton("   Xóa   ");
		pnRight.add(btnXoa);
		btnSua = new JButton("   Sửa   ");
		pnRight.add(btnSua);
		btnXoaRong = new JButton("Xóa rỗng");
		pnRight.add(btnXoaRong);
		btnCapNhat = new JButton("Cập nhật");
		pnRight.add(btnCapNhat);
		
		
		String header[] = { "Mã linh kiện", "Tên linh kiện", "Số lượng", "Ngày sản xuất", "Giá", "Chi tiết linh kiện" , "Nhà cung cấp", "Loại linh kiện"};
		modelTableLinhKien = new DefaultTableModel(header,0);
		tableLinhKien = new JTable(modelTableLinhKien);
		tableLinhKien.setRowHeight(35);
		tableLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane;
		pnContent.add(scrollPane = new JScrollPane(tableLinhKien));
		
		JLabel lblChiTiet = new JLabel("Chi tiết:");
		lblChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChiTiet.setBounds(737, 13, 70, 22);
		pnContent.add(lblChiTiet);
		
		txtChiTiet = new JTextField();
		txtChiTiet.setColumns(10);
		txtChiTiet.setBounds(788, 13, 306, 55);
		pnContent.add(txtChiTiet);
		scrollPane.setBounds(10, 77, 1085, 440);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnCapNhat.addActionListener(this);
		cbLocLinhKien.addActionListener(this);
		cbLoaiLK.addActionListener(this);
		cbNsx.addActionListener(this);
		JdateNgaySX.addPropertyChangeListener(this);
		tableLinhKien.addMouseListener(this);
		btnLoc.addActionListener(this);
		loadDataToTable();
	}
	
	private Object[] getListNcc() throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		daoNcc.getAllNhaCungCap().forEach(i-> list.add(i.getMaNhaCungCap()));
		return list.toArray();
	}

	private Object[] getListLoaiLk() throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		daoLoaiLk.getAllLoaiLinhKien().forEach(i-> list.add(i.getMaLoai()));
		return list.toArray();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			int row = tableLinhKien.getSelectedRow();
			LinhKien lk = listLinhKien.get(row);
			
			txtTenLK.setText(lk.getTenLk());
			txtSoLuong.setText(lk.getSoLuong()+"");
			JdateNgaySX.setDate(lk.getNgaySx()!=null? java.sql.Date.valueOf(lk.getNgaySx()):null);
			txtGia.setText(lk.getGia()+"");
			txtChiTiet.setText(lk.getChiTietLk());
			cbNsx.setSelectedItem(lk.getMaNhaCungCap().getMaNhaCungCap());
			cbLoaiLK.setSelectedItem(lk.getMaLoai().getMaLoai());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			
			if(checkInput()) {
				LinhKien lk =createLinhkien();
				if (daoLinhKien.addLinhKien(lk)) {
					JOptionPane.showMessageDialog(this,"Thêm thành công.");	
					modelTableLinhKien.setRowCount(0);
					listLinhKien= daoLinhKien.getAllLinhKien();
					loadDataToTable();
					xoaRong();
				}else {
					JOptionPane.showMessageDialog(null, "Thêm không Thành Công");
				}
			}
		}
		if(o.equals(btnXoa)) {
			int index = tableLinhKien.getSelectedRow();
			if(index<0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn linh kiện!", "Quản lý linh kiện", 2);
				return;
			}
			
			int i = JOptionPane.showConfirmDialog(
					this, "Bạn có muốn xóa linh kiện có mã \""
							+ listLinhKien.get(index).getMaLk() + "\" không?",
					"Quản lý linh kiện", 2);
			if (i == 0) {
				try {
					daoLinhKien.deleteLinhKien(listLinhKien.get(index).getMaLk());
					modelTableLinhKien.setRowCount(0);
					listLinhKien = daoLinhKien.getAllLinhKien();
//					tableLinhKien.updateUI();
					xoaRong();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản lý linh kiện", 1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Quản lý linh kiện", 2);
				}
			} else
				return;
		}
		if(o.equals(btnXoaRong)) {
			xoaRong();
		}
		if(o.equals(btnSua)) {
			int index = tableLinhKien.getSelectedRow();
			if(index<0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn linh kiện!", "Quản lý linh kiện", 2);
				return;
			}
			if(checkInput()) {
				LinhKien lk =createLinhkien();
				LinhKien lkCu = listLinhKien.get(index);
				lk.setMaLk(lkCu.getMaLk());
				if (daoLinhKien.updateLinhKien(lk)) {
					JOptionPane.showMessageDialog(this,"Chỉnh sửa thành công.");	
					modelTableLinhKien.setRowCount(0);
					listLinhKien= daoLinhKien.getAllLinhKien();
					loadDataToTable();
					xoaRong();
				}else {
					JOptionPane.showMessageDialog(null, "Chỉnh sửa không Thành Công");
				}
			}
			
		}
		if(o.equals(btnCapNhat)) {
			xoaRong();
			modelTableLinhKien.setRowCount(0);
			modelTableLinhKien.removeTableModelListener(tableLinhKien);
			loadDataToTable();
		}
		if (o.equals(btnLoc)) {
			if (cbLocLinhKien.getSelectedItem().toString().equals("Linh kiện")) {
//				this.setVisible(false);
				new GD_LinhKien().setVisible(true);
				
			}
			if (cbLocLinhKien.getSelectedItem().toString().equals("Loại linh kiện")) {
//				this.setVisible(false);
				setPanel(new GD_LoaiLinhKien());
				
			}
		}
		
	}
	public void setPanel(JPanel pn) {
		pnCenter.removeAll();
		pnCenter.add(pn);
		pnCenter.repaint();
		pnCenter.revalidate();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		Object o = evt.getSource();
		if(o.equals(JdateNgaySX) && JdateNgaySX.getDate()!=null) 
			txtNgaySX.setText(new SimpleDateFormat("dd/MM/yyyy").format(JdateNgaySX.getDate()) );
		
	}

	public void xoaRong() {
		txtTenLK.setText("");
		txtSoLuong.setText("");
		txtChiTiet.setText("");
		JdateNgaySX.setDate(null);
		cbLoaiLK.setSelectedIndex(0);
		cbNsx.setSelectedIndex(0);
		txtTimLinhKien.setText("");
	}
	
	private boolean checkInput() {
		return true;
	}
	
	private LinhKien createLinhkien() {
		String tenLK= txtTenLK.getText().trim();
		Integer soLuong = Integer.parseInt(txtSoLuong.getText().trim());
		LocalDate ngaySx= JdateNgaySX.getDate()!=null?LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(JdateNgaySX.getDate())):null;
		Double gia = Double.parseDouble(txtGia.getText().trim()); 
		String chiTiet = txtChiTiet.getText().trim();
		NhaCungCap ncc = new NhaCungCap(cbNsx.getSelectedItem().toString());
		LoaiLinhKien llk = new LoaiLinhKien(cbLoaiLK.getSelectedItem().toString());
		
		LinhKien lk= new LinhKien(tenLK, soLuong, ngaySx, gia, chiTiet, ncc, llk);
		return lk;
	}
	
	public void loadDataToTable() {
		try {
			for (LinhKien lk : listLinhKien) {
				modelTableLinhKien.addRow(new Object[] { lk.getMaLk(), lk.getTenLk(), lk.getSoLuong(),
						lk.getNgaySx(), lk.getGia(), lk.getChiTietLk(), lk.getMaLoai().getMaLoai(), lk.getMaNhaCungCap().getMaNhaCungCap()});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
