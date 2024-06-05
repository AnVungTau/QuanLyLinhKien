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
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVienDAO;
import dao.KhachHangDAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import dao.HoaDon_DAO;

public class GD_HoaDon extends JPanel implements ActionListener, MouseListener, PropertyChangeListener, ChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new GD_HoaDon().setVisible(true);
	}

	private JTextField txtMaHD;
	private DefaultTableModel modelTableHoaDon;
	private JTable tableHoaDon;
	private JButton btnXoaRong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXemChiTietHD;
	private JComboBox<String>  cbKhachHang_HoaDon;
	private JDateChooser JdateNgayLapHD;
	private JTextField txtNgaySX;
	private JTextField txtTongTien;
	private JPanel pnCenter;
	private JButton btnCapNhat;
	private JComboBox<String> cbNhanVien_HoaDon;
	private HoaDon_DAO hdDAO = new HoaDon_DAO();
	private ArrayList<HoaDon> listHD = hdDAO.getAllHoaDon();
	
	public GD_HoaDon() {
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
		
		JLabel lblHoaDon = new JLabel("HÓA ĐƠN");
		lblHoaDon.setBackground(new Color(164, 184, 204));
		lblHoaDon.setBounds(450, 5, 200, 26);
		
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setForeground(Color.BLACK);
		lblHoaDon.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnTitle.add(lblHoaDon);
		
		pnCenter.add(pnTitle);
		
		/* -------------Content------------------ */
		JPanel pnContent = new JPanel();
		pnContent.setBackground(SystemColor.controlHighlight);
		pnContent.setLayout(null);
		pnContent.setBounds(0, 40, 1104, 575);
		
		pnCenter.add(pnContent);

		
		JLabel lblMaHD = new JLabel("Mã hóa đơn: ");
		lblMaHD.setBounds(10, 13, 86, 22);
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnContent.add(lblMaHD);
		txtMaHD = new JTextField();
		txtMaHD.setBounds(103, 14, 174, 22);
		pnContent.add(txtMaHD);
		txtMaHD.setColumns(10);
		txtMaHD.setEditable(false);
		
		JLabel lblNhanVien_HoaDon = new JLabel("Nhân viên: ");
		lblNhanVien_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhanVien_HoaDon.setBounds(350, 13, 86, 22);
		pnContent.add(lblNhanVien_HoaDon);
		
		cbNhanVien_HoaDon = new JComboBox ();
		cbNhanVien_HoaDon.setBounds(430, 14, 190, 22);
		pnContent.add(cbNhanVien_HoaDon);
		
		JLabel lblNgaySX = new JLabel("Ngày sản xuất: ");
		lblNgaySX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgaySX.setBounds(10, 46, 95, 22);
		pnContent.add(lblNgaySX);
		
		JdateNgayLapHD = new JDateChooser();
		JdateNgayLapHD.setBounds(254, 46, 23, 22);
		JdateNgayLapHD.setDate(new java.util.Date());
		pnContent.add(JdateNgayLapHD);
		
		txtNgaySX= new JTextField();
		txtNgaySX.setEditable(false);
		txtNgaySX.setBounds(103, 46, 152, 22);
		pnContent.add(txtNgaySX);
		
		JLabel lblKhachHang_HoaDon = new JLabel("Khách hàng: ");
		lblKhachHang_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKhachHang_HoaDon.setBounds(350, 46, 86, 22);
		pnContent.add(lblKhachHang_HoaDon);
		
		cbKhachHang_HoaDon = new JComboBox <String>();
		cbKhachHang_HoaDon.setBounds(430, 47, 190, 22);
		cbKhachHang_HoaDon.setEditable(false);
		pnContent.add(cbKhachHang_HoaDon);
		
		JLabel TongTien = new JLabel("Tổng tiền: ");
		TongTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TongTien.setBounds(700, 13, 86, 22);
		pnContent.add(TongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setBounds(770, 14, 174, 22);
		pnContent.add(txtTongTien);
		txtTongTien.setColumns(10);
		txtTongTien.setEditable(false);
		
		btnXemChiTietHD = new JButton("Xem Chi Tiết HD");
		btnXemChiTietHD.setBounds(700, 46, 244, 22);
		pnContent.add(btnXemChiTietHD);
		
		JPanel pnRight = new JPanel();
		pnRight.setBounds(10, 528, 1095, 35);
		pnContent.add(pnRight);
		
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
		
		
		String header[] = { "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng",  "Ngày lập", "Tổng"};
		modelTableHoaDon = new DefaultTableModel(header,0);
		tableHoaDon = new JTable(modelTableHoaDon);
		tableHoaDon.setRowHeight(35);
		tableHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane;
		pnContent.add(scrollPane = new JScrollPane(tableHoaDon));
		scrollPane.setBounds(10, 77, 1085, 440);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnCapNhat.addActionListener(this);
		JdateNgayLapHD.addPropertyChangeListener(this);
		tableHoaDon.addMouseListener(this);
//		loadDataToTable();
		loadDataToCBTenNV();
		loadDataToCBTenKH();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableHoaDon.getSelectedRow();
		HoaDon hd = listHD.get(row);
		
		txtMaHD.setText(hd.getMaHD());
		JdateNgayLapHD.setDate(hd.getNgayLapHD()!=null? java.sql.Date.valueOf(hd.getNgayLapHD()):null);
		cbKhachHang_HoaDon.setSelectedItem(hd.getTenKH().getTenKH());
		cbNhanVien_HoaDon.setSelectedItem(hd.getTenNV().getTenNV());
		txtTongTien.setText(String.valueOf(hd.getTongTien()));;
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
		if(o.equals(JdateNgayLapHD) && JdateNgayLapHD.getDate()!=null) 
			txtNgaySX.setText(new SimpleDateFormat("dd/MM/yyyy").format(JdateNgayLapHD.getDate()) );
		
	}

	public void xoaRong() {
		
	}
	
	private boolean checkInput() {
		return true;
	}
	
	public void loadDataToTable() {

	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void loadDataToCBTenNV() {
		NhanVienDAO nvDAO = new NhanVienDAO();
		ArrayList<NhanVien> listNV = nvDAO.getalltbNhanVien();
		for (NhanVien nv : listNV) {
			cbNhanVien_HoaDon.addItem(nv.getTenNV());
		}
	}
	private void loadDataToCBTenKH() {
		KhachHangDAO khDAO = new KhachHangDAO();
		ArrayList<KhachHang> listKH = khDAO.getDanhSachKhachHang();
		for (KhachHang kh : listKH) {
			cbKhachHang_HoaDon.addItem(kh.getTenKH());
		}
	}
}
