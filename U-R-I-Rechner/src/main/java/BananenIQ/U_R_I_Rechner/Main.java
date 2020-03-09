package BananenIQ.U_R_I_Rechner;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Frame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
