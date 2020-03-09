package BananenIQ.U_R_I_Rechner;

import javax.swing.JTextField;

public class Curi {

	Algorithm alg = new Algorithm();
	static String[] empty = new String[2];

	public Curi(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
		if (check(tf1, tf2, tf3, tf4)) {
			String[] tf = notEmpty(tf1, tf2, tf3, tf4);
			alg.switchCB(alg.calculator(Double.parseDouble(tf[0]), Double.parseDouble(tf[1]), Integer.parseInt(tf[2]),
					Integer.parseInt(tf[3]), Integer.parseInt(tf[2]), Integer.parseInt(tf[3])));
		}

	}

	public String[] empty(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
		String[] emp = new String[2];
		int i = 0;
		if (tf1.getText().isEmpty()) {
			emp[i] = "0";
			i++;
		}
		if (tf2.getText().isEmpty()) {
			emp[i] = "1";
			i++;

		}
		if (tf3.getText().isEmpty()) {
			emp[i] = "2";
			i++;

		}
		if (tf4.getText().isEmpty()) {
			emp[i] = "3";
			i++;

		}
		return emp;
	}

	public String[] notEmpty(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
		String[] emp = new String[4];

		int i = 0;

		if (!tf1.getText().isEmpty()) {
			emp[i] = tf1.getText();
			i++;
		}
		if (!tf2.getText().isEmpty()) {
			emp[i] = tf2.getText();
			i++;
		}
		if (!tf3.getText().isEmpty()) {
			emp[i] = tf3.getText();
			i++;
		}

		if (!tf4.getText().isEmpty()) {
			emp[i] = tf4.getText();
			i++;
		}

		if (i == 2) {

			if (!tf1.getText().isEmpty()) {
				emp[i] = "1";
				i++;
			}
			if (!tf2.getText().isEmpty()) {
				emp[i] = "2";
				i++;
			}
			if (!tf3.getText().isEmpty()) {
				emp[i] = "3";
				i++;
			}
			if (!tf4.getText().isEmpty()) {
				emp[i] = "4";
				i++;
			}
		}
		empty = empty(tf1, tf2, tf3, tf4);
		return emp;
	}

	public boolean check(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
		int i = 0;
		boolean check = false;
		if (!tf1.getText().isEmpty()) {
			i++;
		}
		if (!tf2.getText().isEmpty()) {
			i++;
		}
		if (!tf3.getText().isEmpty()) {
			i++;
		}
		if (!tf4.getText().isEmpty()) {
			i++;
		}
		if (i < 2) {
			check = false;
			Frame.lblMessage.setText("Zu wenige Felder aufgefüllt!");
		}
		if (i == 2) {
			check = true;
			Frame.lblMessage.setText("Simsalabim!");
		}
		if (i > 2) {
			check = false;
			Frame.lblMessage.setText("Zu viele Felder aufgefüllt!");
		}
		return check;
	}

}
