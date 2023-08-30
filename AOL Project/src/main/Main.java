package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	ArrayList<Customer> msCustomer = new ArrayList<>();
	ArrayList<Room> msRoom = new ArrayList<>();
	ArrayList<Transaction> msTransaction = new ArrayList<>();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		insertDummyData();
		preMenu();
	}
	
	private void insertDummyData() {
		msRoom.add(new Room(1, 101 ,true));
		msRoom.add(new Room(1, 102, false));
		msRoom.add(new Room(1, 103, false));
		msRoom.add(new Room(2, 104, true));
		msRoom.add(new Room(3, 105, true));
		msRoom.add(new Room(1, 201, false));
		msRoom.add(new Room(1, 202, false));
		msRoom.add(new Room(1, 203, false));
		msRoom.add(new Room(2, 204, true));
		msRoom.add(new Room(3, 205, false));
		msRoom.add(new Room(1, 301, true));
		msRoom.add(new Room(1, 302, false));
		msRoom.add(new Room(1, 303, false));
		msRoom.add(new Room(2, 304, false));
		msRoom.add(new Room(3, 305, false));
		
		msCustomer.add(new Customer(1,"Averina",101, 3, "ave@gmail.com" , "081111111111", 0));
		msCustomer.add(new Customer(2,"Gabriel",104, 2, "gab@gmail.com" , "082222222222", 0));
		msCustomer.add(new Customer(3,"Gavriel",105, 1, "gav@gmail.com" , "083333333333", 0));
		msCustomer.add(new Customer(4,"Karen",204, 2, "kar@gmail.com" , "0844444444444", 0));
		msCustomer.add(new Customer(5,"Roland",301, 5, "rol@gmail.com" , "0855555555555", 0));
		
		msTransaction.add(new Transaction(1, 1, 101, 3, "", false));
		msTransaction.add(new Transaction(2, 2, 104, 2, "", false));
		msTransaction.add(new Transaction(3, 3, 105, 1, "", false));
		msTransaction.add(new Transaction(4, 4, 204, 2, "", false));
		msTransaction.add(new Transaction(5, 5, 301, 5, "", false));
	}
	
	private void startView() {
		Delay th = new Delay();
		th.run(750);
		System.out.println("  _______________________________________________________________________________");
		th.run(750);
		System.out.println(" / \\                                                                             \\*");
		th.run(750);
		System.out.println(" \\__| Hotel Reservation System_                                                  |*");
		th.run(750);
		System.out.println("    |   ___     ___    ____  \\ \\ ______    __  __   ___  _______  _____   _      |*");
		th.run(750);
		System.out.println("    |  / _ \\   / _ \\  |  _ \\ | ||  ___|   | | | |  / _ \\ |_   _| |  ___| | |     |*");
		th.run(750);
		System.out.println("    | | | | | | | | | | |_| |/_/| |___    | |_| | | | | |  | |   | |___  | |     |*");
		th.run(750);
		System.out.println("    | | | | | | | | | | ___/    |____ |   |  _  | | | | |  | |   |  ___| | |     |*");
		th.run(750);
		System.out.println("    | | |_| | | |_| | | |        ___| |   | | | | | |_| |  | |   | |___  | |___  |*");
		th.run(750);
		System.out.println("    |  \\___/   \\___/  |_|       |_____|   |_| |_|  \\___/   |_|   |_____| |_____| |*");
		th.run(750);
		System.out.println("    |                                                                            |*");
		th.run(750);
		System.out.println("    \\_/_________________________________________________________________________/*");
		th.run(750);
		System.out.println("       Oleh: Kelompok 2 LF01\n");
		th.run(750);
	}
	
	private void startViewInstant() {
		System.out.println("  _______________________________________________________________________________");
		System.out.println(" / \\                                                                             \\*");
		System.out.println(" \\__| Hotel Reservation System_                                                  |*");
		System.out.println("    |   ___     ___    ____  \\ \\ ______    __  __   ___  _______  _____   _      |*");
		System.out.println("    |  / _ \\   / _ \\  |  _ \\ | ||  ___|   | | | |  / _ \\ |_   _| |  ___| | |     |*");
		System.out.println("    | | | | | | | | | | |_| |/_/| |___    | |_| | | | | |  | |   | |___  | |     |*");
		System.out.println("    | | | | | | | | | | ___/    |____ |   |  _  | | | | |  | |   |  ___| | |     |*");
		System.out.println("    | | |_| | | |_| | | |        ___| |   | | | | | |_| |  | |   | |___  | |___  |*");
		System.out.println("    |  \\___/   \\___/  |_|       |_____|   |_| |_|  \\___/   |_|   |_____| |_____| |*");
		System.out.println("    |                                                                            |*");
		System.out.println("    \\_/_________________________________________________________________________/*");
		System.out.println("       Oleh: Kelompok 2 LF01\n");
	}
	
	private void preMenu() {
		startView();
		int input = -1;
		do {
			System.out.println("       1. Mulai");
			System.out.println("       2. Keluar");
			System.out.print("       Pilih: ");
			try {
				input = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
			switch (input) {
			case 1:
				enter();
				mainMenu();
				closingMenu();
				return;
			case 2:
				enter();
				closingMenu();
				return;
			default:
				enter();
				startViewInstant();
				System.out.println("       (Input harus berupa angka 1 atau 2!)");
				input = -1;
				break;
			}
			
		} while (input != 2);
	}
	
	private void mainMenu() {
		int input = -1;
		do{
			enter();
			System.out.println("***********");
			System.out.println("*MAIN MENU*");
			System.out.println("***********");
			System.out.println("1. Check In Pelanggan");
			System.out.println("2. Lihat Daftar Ruangan");
			System.out.println("3. Lihat Daftar Pelanggan");
			System.out.println("4. Check Out Pelanggan");
			System.out.println("5. Riwayat Transaksi");
			System.out.println("6. Keluar");
			System.out.print("\nPilih: ");
			try {
				input = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
			switch (input) {
			case 1:
				enter();
				checkInMenu();
				input = -1;
				break;
			case 2:
				daftarRuangan();
				input = -1;
				break;
			case 3:
				daftarPelanggan();
				System.out.print("Press Enter to continue..."); scan.nextLine();
				input = -1;
				break;
			case 4:
				enter();
				checkOutMenu();
				input = -1;
				break;
			case 5:
				enter();
				historyList();
				input = -1;
				break;
			}
			
		} while (input != 6);
	}
	
	private void checkInMenu() {
		Delay th = new Delay();
		int penuh = 0;
		for (Room room : msRoom) {
			if (!room.isfilled()) {
				penuh = 1;
			}
		}
		if (penuh == 0) {
			System.out.println("Please wait...");
			System.out.print("Loading ");		
			for(int i=0; i<3; i++) {
				th.run(750);
				System.out.print("*");
			} System.out.println(); th.run(750);
			enter();
			System.out.println("===================================================");
			System.out.println("||             Semua ruangan penuh!              ||");
			System.out.println("===================================================");
			System.out.println("Tidak dapat menerima pelanggan selama ruangan penuh!");
			System.out.print("Press Enter to continue...");
			scan.nextLine(); return;
		}
		System.out.println("====================================================");
		String nama;
		int cek = 1;
		do {
			if (cek == 0) {
				System.out.println("Input harus berupa alfabet!");
			} else if (cek == 2) {
				System.out.println("Input tidak boleh hanya berupa spasi saja!");
			} else if (cek == 3) {
				System.out.println("Input tidak boleh kosong!");
			} else if (cek == 4) {
				System.out.println("Input tidak boleh diawali dengan spasi!");
			}
			System.out.print("Masukkan nama pelanggan [Harus berupa alfabet] [tekan 0 untuk cancel]: ");
			nama = scan.nextLine();
			
			if (nama.charAt(0) == '0') {
				System.out.println("Check In dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			cek = checkAlfabetNama(nama);
		} while (cek != 1);
		
		String email;
		do {
			System.out.print("Masukkan email pelanggan [Harus berupa email format] [tekan 0 untuk cancel]: ");
			email = scan.nextLine();
			
			if (email.charAt(0) == '0') {
				System.out.println("Check In dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			cek = checkEmailFormat(email);
			
			if (cek == 2) {
				System.out.println("Email harus berisi @!");
			} else if (cek == 3) {
				System.out.println("Email harus berisi .com!");
			}
		} while (cek != 1);
		
		String phoneNumber;
		do {
			System.out.print("Masukkan nomor HP pelanggan [Harus berupa angka] [tekan 0 untuk cancel]: ");
			phoneNumber = scan.nextLine();
			
			if (phoneNumber.charAt(0) == '0' && phoneNumber.length() == 1) {
				System.out.println("Check In dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			cek = checkPhoneFormat(phoneNumber);
			
			if (cek == 0) {
				System.out.println("Input harus berupa angka!");
			} else if (cek == 2) {
				System.out.println("Input tidak boleh berisi spasi!");
			} else if (cek == 3) {
				System.out.println("Input tidak boleh kosong!");
			} else if (cek == 4) {
				System.out.println("Input tidak boleh diawali dengan spasi!");
			}
		} while (cek != 1);
		
		int nomorRuangan = -1;
		viewRuanganKosong("All");
		do {
			if (cek == 0) {
				System.out.println("Input harus sesuai dengan tabel yang diberikan di atas!");
			} else if (cek == 2){
				System.out.println("Ruangan nomor "+nomorRuangan + " penuh, pilihlah ruangan lain");
			}
			System.out.print("Input nomor ruangan yang hendak dipilih [tekan 0 untuk cancel]: ");
			try {
				nomorRuangan = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Input harus berupa angka!");
			}
			if (nomorRuangan == 0) {
				System.out.println("Check In dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			cek = checkNomorRuangan(nomorRuangan);
		} while (cek != 1);
		
		int lamaInap = -1;
		do {
			System.out.print("Input durasi inap (hari) [tekan 0 untuk cancel]: ");
			try {
				lamaInap = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Input harus berupa angka!");
				cek = 0;
			}
			if (nomorRuangan == 0) {
				System.out.println("Check In dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			if (lamaInap < 0) {
				cek = 0;
				System.out.println("Input harus berupa angka positif!");
			} else if (lamaInap > 10) {
				cek = 0;
				System.out.println("Maksimal durasi inap adalah 10 hari!");
			} else {
				cek = 1;
			}
		} while (cek != 1);	
		
		int curr = 0;
		for (Customer customer : msCustomer) {
			curr = customer.getCustomerId();
		}
		
		msCustomer.add(new Customer(curr+1, nama, nomorRuangan, lamaInap, email, phoneNumber, 0));
		for (Room room : msRoom) {
			if(room.getRoomNumber() == nomorRuangan) {
				room.setfilled(true);
			}
		}
		msTransaction.add(new Transaction(curr+1, curr+1, nomorRuangan, lamaInap, " ", false));
		
		System.out.println("Check In sukses! Silahkan berikan kunci kamar kepada pelanggan!");
		System.out.print("Press Enter to continue..."); scan.nextLine();
	}
	
	private int checkPhoneFormat(String phoneNumber) {
		int spasi = 2;
		int num = 0;
		
		if (phoneNumber.isEmpty()) {
			return 3;
		} else if (phoneNumber.charAt(0) == ' ') {
			return 4;
		}
		for (int i=0; i<phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) == ' ') {
				spasi = 2;
			}
			else if(!(phoneNumber.charAt(i) >='0'&&phoneNumber.charAt(i) <='9')) {
				return 0;
			}
			else {
				num = 1;
				spasi = 0;
			}
		}
		if (spasi == 2) {
			return spasi;
		} else {
			return num;
		}
	}
	
	private int checkEmailFormat(String email) {
		if (email.contains("@") && email.contains(".com")) {
			return 1;
		} else if (!email.contains("@")){
			return 2;
		} else if (!email.contains(".com")) { 
			return 3;
		} else {
			return 0;
		}
	}
	
	private int checkNomorRuangan(int nomorRuangan) {
		for (Room room : msRoom) {
			if (room.getRoomNumber() == nomorRuangan) {
				if (room.isfilled()) {
					return 2;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}
	
	private int checkAlfabetNama(String nama) {
		int spasi = 2;
		int num = 0;
		
		if (nama.isEmpty()) {
			return 3;
		} else if (nama.charAt(0) == ' ') {
			return 4;
		}
		for (int i=0; i<nama.length(); i++) {
			if (nama.charAt(i) == ' ') {
				spasi = 2;
			}
			else if(!(nama.charAt(i) >='a'&&nama.charAt(i) <='z') && !(nama.charAt(i) >='A'&&nama.charAt(i) <='Z')) {
				return 0;
			}
			else {
				spasi = 0;
				num = 1;
			}
		}
		if (spasi == 2) {
			return spasi;
		} else {
			return num;
		}
		
	}

	private void daftarRuangan() {
		int input = -1;
		int input2 = -1;
		String type = null;
		viewDaftarRuangan("All");
		do {
			enter();
			System.out.println("Pilih Tipe ruangan yang ingin dilihat:");
			System.out.println("1. Semua Ruangan");
			System.out.println("2. Tipe VIP");
			System.out.println("3. Tipe Personal");
			System.out.println("4. Tipe Family");
			System.out.println("5. Keluar");
			System.out.print("Pilih: ");
			try {
				input2 = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			switch (input2) {
			case 1:
				input2 = -1;
				type = "All";
				break;
			case 2:
				input2 = -1;
				type = "VIP";
				break;
			case 3:
				input2 = -1;
				type = "Personal";
				break;
			case 4:
				input2 = -1;
				type = "Family";
				break;
			}
			
			if(input2!=5) {
				enter();
				do {	
				System.out.println("Pilih:");
				System.out.println("1. Urutkan berdasarkan nomor ruangan");
				System.out.println("2. Tampilkan hanya ruangan yang kosong");
				System.out.println("3. Tampilkan hanya ruangan yang penuh");
				System.out.println("4. Keluar");
				System.out.print("Pilih: ");
				try {
					input = scan.nextInt(); scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
				switch (input) {
				case 1:
					viewDaftarRuangan(type);
					input = -1;
					break;
				case 2:
					viewRuanganKosong(type);
					input = -1;
					break;
				case 3:
					viewRuanganPenuh(type);
					input = -1;
					break;
				}
			} while(input != 4);}
			
			
		} while(input2 != 5);
		
	}

	private void viewDaftarRuangan(String type) {
		Delay th = new Delay();
		System.out.println("Please wait...");
		System.out.print("Loading ");		
		for(int i=0; i<3; i++) {
			th.run(750);
			System.out.print("*");
		} System.out.println(); th.run(750);
		enter();
		System.out.println("Daftar ruangan diurutkan berdasarkan nomor ruangan");
		int i=1;
		System.out.println("====================================================");
		System.out.printf("|| %-2s || %-11s || %-9s || %-12s ||\n", "No", "Room Number", "Room Type", "Availability");
		System.out.println("====================================================");
		if((type.equals("All"))) {
			for (Room room : msRoom) {
				if (room.isfilled()) {
					System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Penuh");
				} else {
					System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Kosong");
				}
			}
		}else {
			for (Room room : msRoom) {
				if(type.equals(room.getRoomType())) {
					if (room.isfilled()) {
						System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Penuh");
					} else {
						System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Kosong");
					}	
				}
				
			}	
		}
		
		System.out.println("====================================================");
	}
	
	private void viewRuanganKosong(String type) {
		Delay th = new Delay();
		System.out.println("Please wait...");
		System.out.print("Loading ");
		for(int i=0; i<3; i++) {
			th.run(750);
			System.out.print("*");
		} System.out.println(); th.run(750);
		enter();
		int i=1;
		int cek = 0;
		System.out.println("Daftar ruangan yang kosong");
		System.out.println("====================================================");
		System.out.printf("|| %-2s || %-11s || %-9s || %-12s ||\n", "No", "Room Number", "Room Type", "Availability");
		System.out.println("====================================================");
		if(type.equals("All")){
			for (Room room : msRoom) {
				if (!room.isfilled()) {
					cek = 1;
					System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Kosong");
				}
			}
		}else{
			for (Room room : msRoom) {
				if (!room.isfilled() && type.equals(room.getRoomType())) {
					cek = 1;
					System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Kosong");
				}
		}
		}
		if (cek == 0) {
			System.out.println("||              Semua ruangan penuh!              ||");
		}
		System.out.println("====================================================");
	}
	
	private void viewRuanganPenuh(String type) {
		Delay th = new Delay();
		System.out.println("Please wait...");
		System.out.print("Loading ");
		for(int i=0; i<3; i++) {
			th.run(750);
			System.out.print("*");
		} System.out.println(); th.run(750);
		enter();
		int i=1;
		int cek = 0;
		System.out.println("Daftar ruangan yang penuh");
		System.out.println("====================================================");
		System.out.printf("|| %-2s || %-11s || %-9s || %-12s ||\n", "No", "Room Number", "Room Type", "Availability");
		System.out.println("====================================================");
		if(type.equals("All")){
		for (Room room : msRoom) {
			if (room.isfilled()) {
				cek = 1;
				System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Penuh");
			}
		}
		}else {
			for (Room room : msRoom) {
				if (room.isfilled() && type.equals(room.getRoomType())) {
					cek = 1;
					System.out.printf("|| %-2d ||     %-7d ||  %-8s ||    %-9s ||\n", i++, room.getRoomNumber(), room.getRoomType(), "Penuh");
				}
			}
		}
		if (cek == 0) {
			System.out.println("||             Semua ruangan kosong!              ||");
		}
		System.out.println("====================================================");
	}

	private void daftarPelanggan() {
		Delay th = new Delay();
		System.out.println("Please wait...");
		System.out.print("Loading ");
		for(int i=0; i<3; i++) {
			th.run(750);
			System.out.print("*");
		} System.out.println(); th.run(750);
		enter();
		int i=1;
		System.out.println("Daftar pelanggan yang sedang menginap");
		System.out.println("================================================================================================");
		System.out.printf("|| %-2s || %-15s || %-11s || %-14s || %-14s || %-14s ||\n", "No", "Customer", "Room Number", "Length of stay", "Email", "Phone Number");
		System.out.println("================================================================================================");
		for (Customer customer : msCustomer) {
			if (customer.getOut() == 0) {
				System.out.printf("|| %-2d || %-15s ||     %-7d ||    %2d day(s)   || %-14s || %-14s ||\n", i++, customer.getName(), customer.getRoomNumber(),customer.getLengthOfStay(), customer.getEmail(), customer.getPhoneNumber());
			}
		}
		System.out.println("================================================================================================");
	}
	
	private void checkOutMenu() {
		daftarPelanggan();
		int input = -1;
		int cek = 1;
		do {
			System.out.print("Input nomor ruangan untuk Check Out [tekan 0 untuk cancel]: ");
			try {
				input = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Input harus berupa angka!");
			}
			
			if (input == 0) {
				System.out.println("Check Out dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			cek = checkOutCheck(input);
			if(cek == 0) {
				System.out.println("Input harus sesuai dengan tabel yang diberikan di atas!");
			}
		} while (cek != 1);
		
		for (Customer customer : msCustomer) {
			if (customer.getRoomNumber() == input) {
				System.out.println("Pelanggan menginap selama " + customer.getLengthOfStay()+" hari");
				for (Room room : msRoom) {
					if (room.getRoomNumber() == input) {
						System.out.println("Tipe kamar yang dipilih adalah: " + room.getRoomType());
						System.out.println("Total tagihannya adalah: Rp. " + customer.getLengthOfStay()*room.getRoomPricePerNight());
						System.out.println();
					}
				}
				break;
			}
		}
		
		String pembayaran;
		do {
			System.out.print("Pilih metode pembayaran [Gopay | ShopeePay | Cash] (case insensitive) [tekan 0 untuk cancel]: ");
			pembayaran = scan.nextLine();
			
			if (pembayaran.charAt(0) == '0') {
				System.out.println("Check Out dibatalkan");
				System.out.print("Press Enter to continue..."); scan.nextLine();
				return;
			}
			
			cek = checkPembayaran(pembayaran);
			if (cek == 0) {
				System.out.println("Periksa lagi input yang dipaparkan!");
			}
		} while (cek != 1);
		
		for (Customer customer : msCustomer) {
			if (customer.getRoomNumber() == input) {
				for (Transaction transaction : msTransaction) {
					if (transaction.getCustomerId() == customer.getCustomerId() && customer.getOut() == 0) {
						transaction.setPaymentMethod(pembayaran);
						transaction.setPaid(true);
						break;
					}
				}
				customer.setOut(1);
				break;
			}
		}
		
		for (Room room : msRoom) {
			if(room.getRoomNumber() == input) {
				room.setfilled(false);
			}
		}
		
		
		
		System.out.println("Check Out dan pembayaran berhasil!");
		System.out.println("Press Enter to continue..."); scan.nextLine();
	}
	
	private int checkPembayaran(String pembayaran) {
		if (pembayaran.compareToIgnoreCase("Gopay") == 0 || pembayaran.compareToIgnoreCase("ShopeePay") == 0 || pembayaran.compareToIgnoreCase("Cash") == 0 ) {
			return 1;
		}
		return 0;
	}
	
	private int checkOutCheck(int input) {
		for (Customer customer : msCustomer) {
			if (customer.getRoomNumber() == input) {
				return 1;
			}
		}
		return 0;
	}
	
	private void historyList() {
		Delay th = new Delay();
		if (msTransaction.isEmpty()) {
			System.out.println("Please wait...");
			System.out.print("Loading ");		
			for(int i=0; i<3; i++) {
				th.run(750);
				System.out.print("*");
			} System.out.println(); th.run(750);
			enter();
			System.out.println("===================================================");
			System.out.println("||         Riwayat Transaksi Kosong!             ||");
			System.out.println("===================================================");
			System.out.print("Press Enter to continue...");
			scan.nextLine(); return;
		}
		System.out.println("Please wait...");
		System.out.print("Loading ");		
		for(int i=0; i<3; i++) {
			th.run(750);
			System.out.print("*");
		} System.out.println(); th.run(750);
		enter();
		System.out.println("Riwayat Transaksi Hotel OOP");
		int i=1;
		System.out.println("==================================================================================================================================");
		System.out.printf("|| %-2s || %-18s  || %-13s|| %-13s || %-10s || %-10s || %-10s || %-15s||\n", "No", "Tanggal:Waktu Inap", "ID Pelanggan","Nama Pelanggan","Nomor Ruangan","Lama Inap",  "Tipe Ruangan", "Total Harga", "Metode Pembayaran");
		System.out.println("==================================================================================================================================");
		
		for (Transaction trans : msTransaction) {
			System.out.printf("|| %-2d || %-18s ||  CU%-9d || ", i++, trans.getFormattedDate(), trans.getCustomerId());
			for (Customer customer : msCustomer) {
				if (customer.getCustomerId() == trans.getCustomerId()) {
					System.out.printf("%-14s || %-10d    || %-10d ||", customer.getName(), customer.getRoomNumber(), customer.getLengthOfStay());
					for (Room room : msRoom) {
						if(room.getRoomNumber() == customer.getRoomNumber()) {
							System.out.printf(" %-12s || Rp. %-10d || \n", room.getRoomType(), room.getRoomPricePerNight() * customer.getLengthOfStay());
						}
					}
				}
				
			}
		System.out.println("==================================================================================================================================");
		
		}
		System.out.print("Press Enter to continue..."); scan.nextLine();
	}
	
	private void closingMenu() {
		Delay th = new Delay();
		th.run(750);
		System.out.println(" ________   __    __       ___       __   __   __    __   __    __   ____    __    __");
		th.run(750);
		System.out.println("|__    __| |  |  |  |     / _ \\     |  \\ |  | |  |  / /   \\ \\  / /  / __ \\  |  |  |  |");
		th.run(750);
		System.out.println("   |  |    |  |__|  |    / /_\\ \\    |   \\|  | |  |_/ /     \\ \\/ /  | |  | | |  |  |  |");
		th.run(750);
		System.out.println("   |  |    |   __   |   /  ___  \\   |       | |   _  \\      |  |   | |  | | |  |  |  |");
		th.run(750);
		System.out.println("   |  |    |  |  |  |  /  /   \\  \\  |  |\\   | |  | \\  \\     |  |   | |__| | |  \\__/  |");
		th.run(750);
		System.out.println("   |__|    |__|  |__| /__/     \\__\\ |__| \\__| |__|  \\__\\    |__|    \\____/   \\______/ ");

	}
	
	private void enter() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}
}