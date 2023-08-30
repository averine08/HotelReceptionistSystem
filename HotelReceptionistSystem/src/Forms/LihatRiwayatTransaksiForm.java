package Forms;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Data.MsTransaction;
import Helper.DateHelper;
import Helper.NumberHelper;
import Model.Transaction;
import Program.AppSettings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class LihatRiwayatTransaksiForm {

	private JFrame frmLihatRiwayatTransaksiForm;
	private JPanel panelTable;
	private JTable tableRiwayatTransaksi;
	
	private DefaultTableModel tableModel;
	private MsTransaction msTransaction = new MsTransaction();
	
	public LihatRiwayatTransaksiForm() {
		Initialize();
	}
	
	public void Show() {
		frmLihatRiwayatTransaksiForm.setVisible(true);
	}
	
	public void Hide() {
		frmLihatRiwayatTransaksiForm.setVisible(false);
	}

	private void Initialize() {
		frmLihatRiwayatTransaksiForm = new JFrame();
		frmLihatRiwayatTransaksiForm.setBackground(new Color(255, 255, 255));
		frmLihatRiwayatTransaksiForm.getContentPane().setBackground(new Color(255, 255, 255));
		frmLihatRiwayatTransaksiForm.setBounds(100, 100, 1200, 400);
		frmLihatRiwayatTransaksiForm.setLocationRelativeTo(null);
		frmLihatRiwayatTransaksiForm.setTitle(AppSettings.appTitle);
		frmLihatRiwayatTransaksiForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		
		JLabel lblHeader = new JLabel("Riwayat Transaksi");
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelTopContent.add(lblHeader);
		
		panelTopContent.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblDesc = new JLabel("Lihat semua riwayat transaksi");
		lblDesc.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		panelTopContent.add(lblDesc);
		
		frmLihatRiwayatTransaksiForm.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		
		panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		
		frmLihatRiwayatTransaksiForm.getContentPane().add(panelTable, BorderLayout.CENTER);
		
		frmLihatRiwayatTransaksiForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Hide();
				new MainForm().Show();
			}
		});
		
		SetupTableRiwayatTransaksi();
		LoadDataTableRiwayatTransaksi();
	}

	private void SetupTableRiwayatTransaksi() {
		String[] columnNames = new String[] { "No", "ID Pelanggan", "Nama Pelanggan", "Nomor Ruangan", "Tipe Ruangan", "Tanggal Cek In", "Lama Inap", "Tanggal Cek Out", "Total Harga", "Metode Pembayaran" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		panelTable.setLayout(null);
		
		tableRiwayatTransaksi = new JTable(tableModel);
		
		tableRiwayatTransaksi.getColumnModel().getColumn(0).setWidth(40);
		tableRiwayatTransaksi.getColumnModel().getColumn(0).setMinWidth(40);
		tableRiwayatTransaksi.getColumnModel().getColumn(0).setMaxWidth(40);
		
		tableRiwayatTransaksi.setFillsViewportHeight(true);
		tableRiwayatTransaksi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableRiwayatTransaksi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRiwayatTransaksi.setRowHeight(24);
		tableRiwayatTransaksi.setAutoCreateRowSorter(true);
		
		JScrollPane scrollTableRiwayatTransaksi = new JScrollPane(tableRiwayatTransaksi);
		scrollTableRiwayatTransaksi.setBounds(12, 12, 1160, 262);
		
		panelTable.add(scrollTableRiwayatTransaksi);
	}
	
	private void LoadDataTableRiwayatTransaksi() {
		tableModel.setRowCount(0);
		
		ArrayList<Transaction> transactionsList = msTransaction.getAllTransactionList();
		
		int number = 1;
		for (Transaction transaction : transactionsList) {
			
			if(transaction.getCheckOutDate() != null) {
				tableModel.addRow(new Object[] {
						number, 
						NumberHelper.formatPadLeftWithPrefix("CU", transaction.getCustomerId(), 3),
						transaction.getCustomer().getName(), 
						transaction.getRoomNumber(), 
						transaction.getRoom().getRoomType().getName(), 
						DateHelper.formatDate(transaction.getCheckInDate(), "dd-MM-yyyy HH:mm:ss"),
						transaction.getLengthOfStay() + " hari", 
						DateHelper.formatDate(transaction.getCheckOutDate(), "dd-MM-yyyy HH:mm:ss"), 
						transaction.getLengthOfStay() * transaction.getRoom().getRoomType().getPricePerNight(), 
						transaction.getPaymentMethod() 
				});
			} else {
				tableModel.addRow(new Object[] {
						number, 
						NumberHelper.formatPadLeftWithPrefix("CU", transaction.getCustomerId(), 3), 
						transaction.getCustomer().getName(), 
						transaction.getRoomNumber(), 
						transaction.getRoom().getRoomType().getName(), 
						DateHelper.formatDate(transaction.getCheckInDate(), "dd-MM-yyyy HH:mm:ss"),
						transaction.getLengthOfStay() + " hari", 
						"Belum cek out", 
						transaction.getLengthOfStay() * transaction.getRoom().getRoomType().getPricePerNight(), 
						"Belum cek out"
				});
			}
			
			number++;
		}
		
		tableModel.fireTableDataChanged();
	}
}
