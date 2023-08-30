package Forms;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Program.AppSettings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Data.MsRoom;
import Data.MsTransaction;
import Helper.DateHelper;
import Helper.NumberHelper;
import Model.Transaction;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CekOutPelangganForm {

	private JFrame frmCheckOutPelangganForm;
	private JTable tableDaftarKamarYangDitempati;
	private JPanel panelContent;
	
	private JLabel lblPlaceholderCariData;
	private JTextField txtCari;
	private JButton btnCari;
	private JLabel lblNomorKamarValue;
	private JLabel lblTipeKamarValue;
	private JLabel lblNamaPelangganValue;
	private JLabel lblTanggalCekInValue;
	private JLabel lblLamaMenginapValue;
	private JLabel lblTotalTagihanValue;
	private JComboBox<Object> comboMetodePembayaran;
	
	private DefaultTableModel tableModel;
	private Transaction selectedTransaction = null;

	private MsRoom msRoom = new MsRoom();
	private MsTransaction msTransaction = new MsTransaction();

	public CekOutPelangganForm() {
		Initialize();
	}
	
	public void Show() {
		frmCheckOutPelangganForm.setVisible(true);
	}
	
	public void Hide() {
		frmCheckOutPelangganForm.setVisible(false);
	}

	private void Initialize() {
		frmCheckOutPelangganForm = new JFrame();
		frmCheckOutPelangganForm.getContentPane().setBackground(new Color(255, 255, 255));
		frmCheckOutPelangganForm.setBackground(new Color(255, 255, 255));
		frmCheckOutPelangganForm.setBounds(100, 100, 600, 640);
		frmCheckOutPelangganForm.setLocationRelativeTo(null);
		frmCheckOutPelangganForm.setTitle(AppSettings.appTitle);
		frmCheckOutPelangganForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayoutPanelTop = (FlowLayout) panelTop.getLayout();
		flowLayoutPanelTop.setAlignment(FlowLayout.LEFT);
		flowLayoutPanelTop.setVgap(12);
		flowLayoutPanelTop.setHgap(12);
		
		JPanel panelTopContent = new JPanel();
		panelTopContent.setBackground(new Color(255, 255, 255));
		panelTop.add(panelTopContent);
		panelTopContent.setLayout(new BoxLayout(panelTopContent, BoxLayout.Y_AXIS));
		
		JLabel lblHeader = new JLabel("Cek Out Pelanggan");
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelTopContent.add(lblHeader);
		
		panelTopContent.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblDesc = new JLabel("Cek out untuk pelanggan yang sudah selesai menginap");
		lblDesc.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		panelTopContent.add(lblDesc);
		
		frmCheckOutPelangganForm.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panelContent.setLayout(null);
		
		frmCheckOutPelangganForm.getContentPane().add(panelContent, BorderLayout.CENTER);
		
		lblPlaceholderCariData = new JLabel("berdasarkan nama pelanggan atau nomor kamar");
		lblPlaceholderCariData.setForeground(new Color(150, 150, 150));
		lblPlaceholderCariData.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPlaceholderCariData.setBounds(98, 43, 300, 16);
		panelContent.add(lblPlaceholderCariData);
		
		JLabel lblDaftarKamarYangDitempati = new JLabel("Daftar kamar yang ditempati");
		lblDaftarKamarYangDitempati.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDaftarKamarYangDitempati.setBounds(12, 12, 560, 16);
		panelContent.add(lblDaftarKamarYangDitempati);
		
		JLabel lblCariData = new JLabel("Cari data :");
		lblCariData.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCariData.setBounds(12, 43, 70, 16);
		panelContent.add(lblCariData);
		
		txtCari = new JTextField();
		txtCari.setBounds(92, 42, 400, 20);
		txtCari.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblCariData.setVisible(true);
				lblPlaceholderCariData.setVisible(false);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCari.getText().toString().trim().equals("")) {
					lblCariData.setVisible(true);
					lblPlaceholderCariData.setVisible(true);
				} else {
					lblCariData.setVisible(true);
					lblPlaceholderCariData.setVisible(false);
				}
			}
		});
		txtCari.setColumns(10);
		panelContent.add(txtCari);
		
		btnCari = new JButton("Cari");
		btnCari.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCari.setBounds(502, 40, 70, 24);
		btnCari.addMouseListener(btnCari_Click);
		panelContent.add(btnCari);
		
		JLabel lblDataYangDipilih = new JLabel("Data yang dipilih");
		lblDataYangDipilih.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDataYangDipilih.setBounds(12, 258, 150, 20);
		panelContent.add(lblDataYangDipilih);
		
		JLabel lblNomorKamar = new JLabel("Nomor kamar");
		lblNomorKamar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNomorKamar.setBounds(12, 286, 130, 16);
		panelContent.add(lblNomorKamar);
		
		JLabel lblTipeKamar = new JLabel("Tipe kamar");
		lblTipeKamar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTipeKamar.setBounds(12, 310, 130, 16);
		panelContent.add(lblTipeKamar);
		
		JLabel lblNamaPelanggan = new JLabel("Nama pelanggan");
		lblNamaPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNamaPelanggan.setBounds(12, 334, 130, 16);
		panelContent.add(lblNamaPelanggan);
		
		JLabel lblTanggalCekIn = new JLabel("Tanggal cek in");
		lblTanggalCekIn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTanggalCekIn.setBounds(12, 358, 130, 16);
		panelContent.add(lblTanggalCekIn);
		
		JLabel lblLamaMenginap = new JLabel("Lama menginap (hari)");
		lblLamaMenginap.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblLamaMenginap.setBounds(12, 382, 130, 16);
		panelContent.add(lblLamaMenginap);
		
		JLabel lblTitikDuaNomorKamar = new JLabel(":");
		lblTitikDuaNomorKamar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikDuaNomorKamar.setBounds(152, 286, 8, 16);
		panelContent.add(lblTitikDuaNomorKamar);
		
		JLabel lblTitikTipeKamar = new JLabel(":");
		lblTitikTipeKamar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikTipeKamar.setBounds(152, 310, 8, 16);
		panelContent.add(lblTitikTipeKamar);
		
		JLabel lblTitikDuaNamaPelanggan = new JLabel(":");
		lblTitikDuaNamaPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikDuaNamaPelanggan.setBounds(152, 334, 8, 16);
		panelContent.add(lblTitikDuaNamaPelanggan);
		
		JLabel lblTitikDuaTanggalCekIn = new JLabel(":");
		lblTitikDuaTanggalCekIn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikDuaTanggalCekIn.setBounds(152, 358, 8, 16);
		panelContent.add(lblTitikDuaTanggalCekIn);
		
		JLabel lblTitikDuaLamaMenginap = new JLabel(":");
		lblTitikDuaLamaMenginap.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikDuaLamaMenginap.setBounds(152, 382, 8, 16);
		panelContent.add(lblTitikDuaLamaMenginap);
		
		lblNomorKamarValue = new JLabel("-");
		lblNomorKamarValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNomorKamarValue.setBounds(164, 286, 130, 16);
		panelContent.add(lblNomorKamarValue);
		
		lblTipeKamarValue = new JLabel("-");
		lblTipeKamarValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTipeKamarValue.setBounds(164, 310, 130, 16);
		panelContent.add(lblTipeKamarValue);
		
		lblNamaPelangganValue = new JLabel("-");
		lblNamaPelangganValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNamaPelangganValue.setBounds(164, 334, 130, 16);
		panelContent.add(lblNamaPelangganValue);
		
		lblTanggalCekInValue = new JLabel("-");
		lblTanggalCekInValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTanggalCekInValue.setBounds(164, 358, 130, 16);
		panelContent.add(lblTanggalCekInValue);
		
		lblLamaMenginapValue = new JLabel("-");
		lblLamaMenginapValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblLamaMenginapValue.setBounds(164, 382, 130, 16);
		panelContent.add(lblLamaMenginapValue);
		
		JLabel lblTotalTagihan = new JLabel("Total tagihan yang harus dibayar :");
		lblTotalTagihan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalTagihan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTotalTagihan.setBounds(332, 286, 240, 16);
		panelContent.add(lblTotalTagihan);
		
		lblTotalTagihanValue = new JLabel("Rp 0");
		lblTotalTagihanValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalTagihanValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTotalTagihanValue.setBounds(302, 310, 270, 28);
		panelContent.add(lblTotalTagihanValue);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPembayaran.setBounds(12, 414, 150, 20);
		panelContent.add(lblPembayaran);
		
		comboMetodePembayaran = new JComboBox<Object>(new Object[] { "GoPay", "ShoppePay", "Cash" });
		comboMetodePembayaran.setBounds(164, 442, 130, 22);
		panelContent.add(comboMetodePembayaran);
		
		JLabel lblMetodePembayaran = new JLabel("Metode pembayaran");
		lblMetodePembayaran.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMetodePembayaran.setBounds(12, 444, 130, 16);
		panelContent.add(lblMetodePembayaran);
		
		JLabel lblTitikDuaMetodePembayaran = new JLabel(":");
		lblTitikDuaMetodePembayaran.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTitikDuaMetodePembayaran.setBounds(152, 444, 8, 16);
		panelContent.add(lblTitikDuaMetodePembayaran);
		
		JButton btnCekOut = new JButton("Cek Out");
		btnCekOut.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCekOut.setBounds(474, 484, 100, 30);
		btnCekOut.addMouseListener(btnCekOut_Click);
		panelContent.add(btnCekOut);
		
		JButton btnKembali = new JButton("Kembali");
		btnKembali.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnKembali.setBounds(364, 484, 100, 30);
		btnKembali.addMouseListener(btnKembali_Click);
		panelContent.add(btnKembali);
		
		frmCheckOutPelangganForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Hide();
				new MainForm().Show();
			}
		});
		
		SetupTableDaftarKamarYangDitempati();
		LoadDataTableDaftarKamarYangDitempati();
	}
	
	private void SetupTableDaftarKamarYangDitempati() {
		String[] columnNames = new String[] { "No", "ID Transaksi", "Nomor Kamar", "Pelanggan", "Tanggal Cek In", "Lama Menginap" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tableDaftarKamarYangDitempati = new JTable(tableModel);
		
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(1).setWidth(0);
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(1).setMinWidth(0);
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(1).setMaxWidth(0);
		
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(0).setWidth(40);
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(0).setMinWidth(40);
		tableDaftarKamarYangDitempati.getColumnModel().getColumn(0).setMaxWidth(40);
		
		tableDaftarKamarYangDitempati.setFillsViewportHeight(true);
		tableDaftarKamarYangDitempati.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableDaftarKamarYangDitempati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDaftarKamarYangDitempati.setRowHeight(24);
		tableDaftarKamarYangDitempati.setAutoCreateRowSorter(true);
		
		tableDaftarKamarYangDitempati.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					LoadDataDetail();
				}
			}
		});
		
		JScrollPane scrollTableDaftarPelanggan = new JScrollPane(tableDaftarKamarYangDitempati);
		scrollTableDaftarPelanggan.setBounds(12, 75, 560, 167);
		
		panelContent.add(scrollTableDaftarPelanggan);
	}
	
	private void LoadDataTableDaftarKamarYangDitempati() {
		tableModel.setRowCount(0);
		
		ArrayList<Transaction> unpaidTransactionsList = (ArrayList<Transaction>) msTransaction.getAllTransactionList()
				.stream()
				.filter(transaction -> transaction.isPaid() == false)
				.collect(Collectors.toList());
		
		ArrayList<Transaction> transactionsList = new ArrayList<>();
		
		Calendar calendarNow = Calendar.getInstance();
		
		for (Transaction transaction : unpaidTransactionsList) {
			Calendar calendarExpectedCheckOut = Calendar.getInstance();
			calendarExpectedCheckOut.setTime(transaction.getCheckInDate());
			calendarExpectedCheckOut.add(Calendar.DAY_OF_MONTH, transaction.getLengthOfStay());
			calendarExpectedCheckOut.set(Calendar.HOUR_OF_DAY, 12);
			calendarExpectedCheckOut.set(Calendar.MINUTE, 0);
			calendarExpectedCheckOut.set(Calendar.SECOND, 0);
			
			if(calendarNow.after(calendarExpectedCheckOut)) {
				transactionsList.add(transaction);
			}
		}
		
		if(!txtCari.getText().toString().trim().equals("")) {
			String searchedText = txtCari.getText().toString().trim().toLowerCase();
			
			transactionsList = (ArrayList<Transaction>) transactionsList
					.stream()
					.filter(transaction -> transaction.getCustomer().getName().toLowerCase().contains(searchedText) || String.valueOf(transaction.getRoomNumber()).startsWith(searchedText))
					.collect(Collectors.toList());
		}
		
		int number = 1;
		for (Transaction transaction : transactionsList) {
			tableModel.addRow(new Object[] { number, transaction.getTransactionId(), transaction.getRoomNumber(), transaction.getCustomer().getName(), DateHelper.formatDate(transaction.getCheckInDate(), "dd-MM-yyyy HH:mm:ss"), transaction.getLengthOfStay() + " hari" });
			number++;
		}
		
		tableModel.fireTableDataChanged();
		ClearSelectedData();
	}
	
	private void LoadDataDetail() {
		int selectedRowIndex = tableDaftarKamarYangDitempati.getSelectedRow();
		
		if(selectedRowIndex == -1) {
			return;
		}
		
		int selectedTransactionID = Integer.parseInt(tableDaftarKamarYangDitempati.getValueAt(selectedRowIndex, 1).toString());
		selectedTransaction = msTransaction.getTransactionById(selectedTransactionID);
		
		lblNomorKamarValue.setText(String.valueOf(selectedTransaction.getRoomNumber()));
		lblTipeKamarValue.setText(selectedTransaction.getRoom().getRoomType().getName());
		lblNamaPelangganValue.setText(selectedTransaction.getCustomer().getName());
		lblTanggalCekInValue.setText(DateHelper.formatDate(selectedTransaction.getCheckInDate(), "dd-MM-yyyy HH:mm:ss"));
		lblLamaMenginapValue.setText(selectedTransaction.getLengthOfStay() + " hari");
		
		int totalTagihan = selectedTransaction.getLengthOfStay() * selectedTransaction.getRoom().getRoomType().getPricePerNight();
		lblTotalTagihanValue.setText(NumberHelper.formatMoneyRupiah(totalTagihan));
	}
	
	private void ClearSelectedData() {
		selectedTransaction = null;
		
		lblNomorKamarValue.setText("-");
		lblTipeKamarValue.setText("-");
		lblNamaPelangganValue.setText("-");
		lblTanggalCekInValue.setText("-");
		lblLamaMenginapValue.setText("-");
		lblTotalTagihanValue.setText(NumberHelper.formatMoneyRupiah(0));
	}
	
	private MouseAdapter btnCari_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			LoadDataTableDaftarKamarYangDitempati();
		}
	};
	
	private MouseAdapter btnCekOut_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(selectedTransaction == null) {
				JOptionPane.showMessageDialog(frmCheckOutPelangganForm, "Pilih data transaksi yang ingin cek out");
				return;
			}
			
			msRoom.checkOutFromRoom(selectedTransaction.getRoomNumber());
			msTransaction.payTransaction(selectedTransaction, comboMetodePembayaran.getSelectedItem().toString());
			
			JOptionPane.showMessageDialog(frmCheckOutPelangganForm, "Cek out sukses");
			ClearSelectedData();
			LoadDataTableDaftarKamarYangDitempati();
		}
	};
	
	private MouseAdapter btnKembali_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new MainForm().Show();
		}
	};
}
