package Forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Data.*;
import Model.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class CekInPelangganForm {

	private JFrame frmCekInPelangganForm;
	private JTextField txtNamaPelanggan;
	private JTextField txtEmailPelanggan;
	private JTextField txtNoHPPelanggan;
	private JTextField txtDurasiMenginap;
	private JTable tableKamarYangTersedia;
	private JPanel panelContent;
	
	private DefaultTableModel tableModel;
	
	private MsCustomer msCustomer = new MsCustomer();
	private MsRoom msRoom = new MsRoom();
	private MsTransaction msTransaction = new MsTransaction();

	public CekInPelangganForm() {
		Initialize();
	}
	
	public void Show() {
		frmCekInPelangganForm.setVisible(true);
	}
	
	public void Hide() {
		frmCekInPelangganForm.setVisible(false);
	}
	
	private void Initialize() {
		frmCekInPelangganForm = new JFrame();
		frmCekInPelangganForm.getContentPane().setBackground(new Color(255, 255, 255));
		frmCekInPelangganForm.setTitle("Hotel Room Reservation System");
		frmCekInPelangganForm.setBounds(100, 100, 650, 400);
		frmCekInPelangganForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmCekInPelangganForm.setLocationRelativeTo(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayoutPanelTop = (FlowLayout) panelTop.getLayout();
		flowLayoutPanelTop.setAlignment(FlowLayout.LEFT);
		flowLayoutPanelTop.setVgap(12);
		flowLayoutPanelTop.setHgap(12);
		
		JPanel panelTopContent = new JPanel();
		panelTopContent.setBackground(new Color(255, 255, 255));
		panelTopContent.setLayout(new BoxLayout(panelTopContent, BoxLayout.Y_AXIS));
		
		JLabel lblHeader = new JLabel("Cek In Pelanggan");
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelTopContent.add(lblHeader);
		
		panelTopContent.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblDesc = new JLabel("Cek in untuk pelanggan yang ingin menempati hotel");
		lblDesc.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		panelTopContent.add(lblDesc);
		
		panelTop.add(panelTopContent);
		frmCekInPelangganForm.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		frmCekInPelangganForm.getContentPane().add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		JLabel lblNamaPelanggan = new JLabel("Nama Pelanggan :");
		lblNamaPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNamaPelanggan.setBounds(12, 12, 230, 20);
		panelContent.add(lblNamaPelanggan);
		
		txtNamaPelanggan = new JTextField();
		txtNamaPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNamaPelanggan.setBounds(12, 34, 230, 20);
		panelContent.add(txtNamaPelanggan);
		txtNamaPelanggan.setColumns(10);
		
		JLabel lblEmailPelanggan = new JLabel("Email Pelanggan :");
		lblEmailPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmailPelanggan.setBounds(12, 66, 230, 20);
		panelContent.add(lblEmailPelanggan);
		
		txtEmailPelanggan = new JTextField();
		txtEmailPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtEmailPelanggan.setColumns(10);
		txtEmailPelanggan.setBounds(12, 88, 230, 20);
		panelContent.add(txtEmailPelanggan);
		
		JLabel lblNoHPPelanggan = new JLabel("No HP Pelanggan :");
		lblNoHPPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNoHPPelanggan.setBounds(12, 120, 230, 20);
		panelContent.add(lblNoHPPelanggan);
		
		txtNoHPPelanggan = new JTextField();
		txtNoHPPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNoHPPelanggan.setColumns(10);
		txtNoHPPelanggan.setBounds(12, 142, 230, 20);
		panelContent.add(txtNoHPPelanggan);
		
		JLabel lblDurasiMenginap = new JLabel("Durasi menginap (hari) :");
		lblDurasiMenginap.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDurasiMenginap.setBounds(12, 177, 230, 20);
		panelContent.add(lblDurasiMenginap);
		
		txtDurasiMenginap = new JTextField();
		txtDurasiMenginap.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDurasiMenginap.setColumns(10);
		txtDurasiMenginap.setBounds(12, 199, 230, 20);
		panelContent.add(txtDurasiMenginap);
		
		JLabel lblPilihKamar = new JLabel("Pilih kamar :");
		lblPilihKamar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPilihKamar.setBounds(265, 12, 309, 20);
		panelContent.add(lblPilihKamar);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnSimpan.addMouseListener(btnSimpan_Click);
		btnSimpan.setBounds(522, 244, 100, 30);
		panelContent.add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnBatal.addMouseListener(btnBatal_Click);
		btnBatal.setBounds(412, 244, 100, 30);
		panelContent.add(btnBatal);
		
		frmCekInPelangganForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Hide();
				new MainForm().Show();
			}
		});
		
		SetupTableDataKamarYangTersedia();
		LoadDataKamarYangTersedia();
	}
	
	private void SetupTableDataKamarYangTersedia() {
		JPanel panelTableContent = new JPanel();
		panelTableContent.setLayout(new BorderLayout(0, 0));
		panelTableContent.setBackground(new Color(255, 255, 255));
		
		String[] columnNames = new String[] { "Nomor Kamar", "Tipe Kamar", "Harga per Malam" };
		
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tableKamarYangTersedia = new JTable(tableModel);
		tableKamarYangTersedia.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableKamarYangTersedia.setRowHeight(24);
		tableKamarYangTersedia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKamarYangTersedia.setFillsViewportHeight(true);
		tableKamarYangTersedia.setAutoCreateRowSorter(true);
		
		JScrollPane scrollTableKamar = new JScrollPane(tableKamarYangTersedia);
		scrollTableKamar.setBounds(265, 34, 357, 199);
		scrollTableKamar.setViewportView(tableKamarYangTersedia);
		
		panelContent.add(scrollTableKamar);
	}
	
	private void LoadDataKamarYangTersedia() {
		tableModel.setRowCount(0);
		
		ArrayList<Room> availableRoomsData = (ArrayList<Room>) msRoom.getAllRoomList()
				.stream()
				.filter(x -> x.isFilled() == false)
				.collect(Collectors.toList());
		
		for(Room room : availableRoomsData) {
			tableModel.addRow(new Object[] { room.getRoomNumber(), room.getRoomType().getName(), room.getRoomType().getPricePerNight() });
		}
		
		tableModel.fireTableDataChanged();
	}
	
	private MouseAdapter btnSimpan_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			// Validasi nama pelanggan
			String namaPelanggan = txtNamaPelanggan.getText().toString();
			if(namaPelanggan.trim().equals("")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Nama pelanggan tidak boleh kosong");
				return;
			}
			
			if(namaPelanggan.startsWith(" ")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Nama pelanggan tidak boleh diawali dengan spasi");
				return;
			}
			
			if(!namaPelanggan.chars().allMatch(x -> (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || x == ' ')) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Nama pelanggan harus berupa alfabet");
				return;
			}
			
			
			// Validasi email pelanggan
			String emailPelanggan = txtEmailPelanggan.getText().toString();
			if(emailPelanggan.trim().equals("")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Email pelanggan tidak boleh kosong");
				return;
			}
			
			if(emailPelanggan.startsWith(" ")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Email pelanggan tidak boleh diawali dengan spasi");
				return;
			}
			
			if(!emailPelanggan.contains("@") || !emailPelanggan.contains(".com")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Email pelanggan tidak valid");
				return;
			}
			
			
			// Validasi nomor hp pelanggan
			String noHPPelanggan = txtNoHPPelanggan.getText().toString();
			if(noHPPelanggan.trim().equals("")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "No HP pelanggan tidak boleh kosong");
				return;
			}
			
			if(noHPPelanggan.startsWith(" ")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "No HP pelanggan tidak boleh diawali dengan spasi");
				return;
			}
			
			if(!noHPPelanggan.chars().allMatch(x -> x >= '0' && x <= '9')) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "No HP pelanggan harus berupa angka");
				return;
			}
			
			if(!noHPPelanggan.startsWith("08")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "No HP pelanggan harus diawali dengan 08");
				return;
			}
			
			if(noHPPelanggan.length() < 10 || noHPPelanggan.length() > 13) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "No HP pelanggan harus 10-13 digit");
				return;
			}
			
			
			// Validasi durasi menginap
			String durasiMenginap = txtDurasiMenginap.getText().toString();
			if(durasiMenginap.trim().equals("")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Durasi menginap tidak boleh kosong");
				return;
			}
			
			if(durasiMenginap.startsWith(" ")) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Durasi menginap tidak boleh diawali dengan spasi");
				return;
			}
			
			if(!durasiMenginap.chars().allMatch(x -> x >= '0' && x <= '9')) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Durasi menginap harus berupa angka");
				return;
			}
			
			int durasiMenginapValue = Integer.parseInt(durasiMenginap);
			if(durasiMenginapValue > 10 || durasiMenginapValue < 1) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Durasi menginap harus di antara 1-10 hari");
				return;
			}
			
			
			// Validasi ruangan
			if(tableKamarYangTersedia.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(frmCekInPelangganForm, "Pilih ruangan yang ingin ditempati");
				return;
			}
			
			
			// Simpan data
			int newCustomerID = msCustomer.addNewCustomer(namaPelanggan, emailPelanggan, noHPPelanggan);
			
			int selectedRoomNumber = Integer.parseInt(tableKamarYangTersedia.getValueAt(tableKamarYangTersedia.getSelectedRow(), 0).toString());
			msRoom.checkInToRoom(selectedRoomNumber);
			
			msTransaction.addNewTransaction(newCustomerID, selectedRoomNumber, durasiMenginapValue);
			
			JOptionPane.showMessageDialog(frmCekInPelangganForm, "Success check in");
			
			Hide();
			new MainForm().Show();
		}
	};
	
	private MouseAdapter btnBatal_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {						
			Hide();
			new MainForm().Show();
		}
	};
}
