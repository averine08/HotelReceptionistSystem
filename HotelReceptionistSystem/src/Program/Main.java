package Program;

import Data.*;
import Forms.*;

public class Main {
	public static void main(String[] args) {
		new MsCustomer().generateDummyData();
		new MsRoom().generateDummyData();
		new MsRoomType().generateDummyData();
		new MsTransaction().generateDummyData();
		
		MainForm mainForm = new MainForm();
		mainForm.Show();
	}
}