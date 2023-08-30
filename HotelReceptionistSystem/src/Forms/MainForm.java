package Forms;

import javax.swing.*;

import Program.AppSettings;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

public class MainForm {

	private JFrame frmMainForm;
	private JPanel panelTop;
	private JLabel lblHeader;
	private JPanel panelContent;
	private JButton btnCekInPelanggan;
	private JLabel lblMenuList;
	private JButton btnLihatDaftarKamar;
	private JButton btnLihatDaftarPelanggan;
	private JButton btnCekOutPelanggan;
	private JButton btnLihatRiwayatTransaksi;
	
	private JLabel lblAnggota1Icon;
	private JLabel lblAnggota1Nama;
	private JLabel lblAnggota1NIM;
	private JLabel lblAnggota2Icon;
	private JLabel lblAnggota2Nama;
	private JLabel lblAnggota2NIM;
	private JLabel lblAnggota3Icon;
	private JLabel lblAnggota3Nama;
	private JLabel lblAnggota3NIM;
	private JLabel lblAnggota4Icon;
	private JLabel lblAnggota4Nama;
	private JLabel lblAnggota4NIM;
	private JLabel lblAnggota5Icon;
	private JLabel lblAnggota5Nama;
	private JLabel lblAnggota5NIM;
	
	public MainForm() {
		Initialize();
	}
	
	public void Show() {
		frmMainForm.setVisible(true);
	}
	
	public void Hide() {
		frmMainForm.setVisible(false);
	}

	private void Initialize() {
		frmMainForm = new JFrame();
		frmMainForm.setTitle(AppSettings.appTitle);
		frmMainForm.setBounds(100, 100, 600, 400);
		frmMainForm.setLocationRelativeTo(null);
		frmMainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainForm.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayoutPanelTop = (FlowLayout) panelTop.getLayout();
		flowLayoutPanelTop.setAlignment(FlowLayout.LEFT);
		flowLayoutPanelTop.setVgap(12);
		flowLayoutPanelTop.setHgap(12);
		
		JPanel panelTopContent = new JPanel();
		panelTopContent.setBackground(new Color(255, 255, 255));
		panelTopContent.setLayout(new BoxLayout(panelTopContent, BoxLayout.Y_AXIS));
		
		lblHeader = new JLabel("OOP's Hotel");
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelTopContent.add(lblHeader);
		panelTopContent.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblDesc = new JLabel("Melayani dengan sepenuh hati nurani");
		lblDesc.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		panelTopContent.add(lblDesc);
		
		panelTop.add(panelTopContent);
		
		frmMainForm.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panelContent.setLayout(null);
		
		lblMenuList = new JLabel("Menu :");
		lblMenuList.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblMenuList.setBounds(12, 12, 46, 14);
		panelContent.add(lblMenuList);
		
		btnCekInPelanggan = new JButton("Cek In Pelanggan");
		btnCekInPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCekInPelanggan.addMouseListener(btnCekInPelanggan_Click);
		btnCekInPelanggan.setBounds(12, 34, 220, 30);
		panelContent.add(btnCekInPelanggan);
		
		btnCekOutPelanggan = new JButton("Cek Out Pelanggan");
		btnCekOutPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCekOutPelanggan.addMouseListener(btnCekOutPelanggan_Click);
		btnCekOutPelanggan.setBounds(12, 72, 220, 30);
		panelContent.add(btnCekOutPelanggan);
		
		btnLihatDaftarKamar = new JButton("Lihat Daftar Kamar");
		btnLihatDaftarKamar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLihatDaftarKamar.addMouseListener(btnLihatDaftarKamar_Click);
		btnLihatDaftarKamar.setBounds(12, 110, 220, 30);
		panelContent.add(btnLihatDaftarKamar);
		
		btnLihatDaftarPelanggan = new JButton("Lihat Daftar Pelanggan");
		btnLihatDaftarPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLihatDaftarPelanggan.addMouseListener(btnLihatDaftarPelanggan_Click);
		btnLihatDaftarPelanggan.setBounds(12, 148, 220, 30);
		panelContent.add(btnLihatDaftarPelanggan);
		
		btnLihatRiwayatTransaksi = new JButton("Lihat Riwayat Transaksi");
		btnLihatRiwayatTransaksi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLihatRiwayatTransaksi.addMouseListener(btnLihatRiwayatTransaksi_Click);
		btnLihatRiwayatTransaksi.setBounds(12, 186, 220, 30);
		panelContent.add(btnLihatRiwayatTransaksi);
		
		frmMainForm.getContentPane().add(panelContent, BorderLayout.CENTER);
		
		JLabel lblOlehKelompok = new JLabel("Copyright © 2022 Kelompok 2 LF01");
		lblOlehKelompok.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
		lblOlehKelompok.setBounds(12, 260, 191, 14);
		panelContent.add(lblOlehKelompok);
		
		JLabel lblAnggotaKelompok = new JLabel("Anggota Kelompok :");
		lblAnggotaKelompok.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAnggotaKelompok.setBounds(262, 13, 130, 18);
		panelContent.add(lblAnggotaKelompok);
		
		lblAnggota1Icon = new JLabel("-");
		lblAnggota1Icon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota1Icon.setBounds(262, 34, 10, 18);
		panelContent.add(lblAnggota1Icon);
		
		lblAnggota1Nama = new JLabel("Averina Nurdin");
		lblAnggota1Nama.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota1Nama.setBounds(283, 34, 130, 18);
		panelContent.add(lblAnggota1Nama);
		
		lblAnggota1NIM = new JLabel("(2501981560)");
		lblAnggota1NIM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota1NIM.setBounds(423, 34, 151, 18);
		panelContent.add(lblAnggota1NIM);
		
		lblAnggota2Icon = new JLabel("-");
		lblAnggota2Icon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota2Icon.setBounds(262, 60, 10, 18);
		panelContent.add(lblAnggota2Icon);
		
		lblAnggota2Nama = new JLabel("Gabriel Yohanes");
		lblAnggota2Nama.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota2Nama.setBounds(283, 60, 130, 18);
		panelContent.add(lblAnggota2Nama);
		
		lblAnggota2NIM = new JLabel("(2501979820)");
		lblAnggota2NIM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota2NIM.setBounds(423, 60, 151, 18);
		panelContent.add(lblAnggota2NIM);
		
		lblAnggota3Icon = new JLabel("-");
		lblAnggota3Icon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota3Icon.setBounds(262, 86, 10, 18);
		panelContent.add(lblAnggota3Icon);
		
		lblAnggota3Nama = new JLabel("Gavriel Satrio Widjaya");
		lblAnggota3Nama.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota3Nama.setBounds(283, 86, 130, 18);
		panelContent.add(lblAnggota3Nama);
		
		lblAnggota3NIM = new JLabel("(2501983692)");
		lblAnggota3NIM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota3NIM.setBounds(423, 86, 151, 18);
		panelContent.add(lblAnggota3NIM);
		
		lblAnggota4Icon = new JLabel("-");
		lblAnggota4Icon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota4Icon.setBounds(262, 112, 10, 18);
		panelContent.add(lblAnggota4Icon);
		
		lblAnggota4Nama = new JLabel("Karen Agustine");
		lblAnggota4Nama.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota4Nama.setBounds(283, 112, 130, 18);
		panelContent.add(lblAnggota4Nama);
		
		lblAnggota4NIM = new JLabel("(2501979940)");
		lblAnggota4NIM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota4NIM.setBounds(423, 112, 151, 18);
		panelContent.add(lblAnggota4NIM);
		
		lblAnggota5Icon = new JLabel("-");
		lblAnggota5Icon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota5Icon.setBounds(262, 138, 10, 18);
		panelContent.add(lblAnggota5Icon);
		
		lblAnggota5Nama = new JLabel("Roland Ramadan");
		lblAnggota5Nama.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota5Nama.setBounds(283, 138, 130, 18);
		panelContent.add(lblAnggota5Nama);
		
		lblAnggota5NIM = new JLabel("(2501980633)");
		lblAnggota5NIM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAnggota5NIM.setBounds(423, 138, 151, 18);
		panelContent.add(lblAnggota5NIM);
	}
	
	private MouseAdapter btnCekInPelanggan_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new CekInPelangganForm().Show();
		}
	};
	
	private MouseAdapter btnCekOutPelanggan_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new CekOutPelangganForm().Show();
		}
	};
	
	private MouseAdapter btnLihatDaftarKamar_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new LihatDaftarKamarForm().Show();			
		}
	};
	
	private MouseAdapter btnLihatDaftarPelanggan_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new LihatDaftarPelangganForm().Show();			
		}
	};
	
	private MouseAdapter btnLihatRiwayatTransaksi_Click = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Hide();
			new LihatRiwayatTransaksiForm().Show();
		}
	};
}
