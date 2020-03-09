package BananenIQ.U_R_I_Rechner;

public class Algorithm {

	public double[] units = new double[] { 0.000000001D, 0.000001D, 0.001D, 1D, 1000D, 1000000D, 1000000000D };

	public Algorithm() {

	}

	public double[] calculator(double a, double b, int tfI, int tfb, int cbI, int cbb) {
		double[] solution = new double[7];
		switch (cbI) {
		case 1:
			a = a * units[Frame.cbU.getSelectedIndex()];
			break;
		case 2:
			a = a * units[Frame.cbI.getSelectedIndex()];
			break;
		case 3:
			a = a * units[Frame.cbR.getSelectedIndex()];
			break;
		}
		switch (cbb) {
		case 2:
			b = b * units[Frame.cbI.getSelectedIndex()];
			break;
		case 3:
			b = b * units[Frame.cbR.getSelectedIndex()];
			break;
		case 4:
			b = b * units[Frame.cbP.getSelectedIndex()];
			break;

		}

		if ((tfI + tfb) == 3) {
			solution[0] = a;
			solution[1] = b;
			solution[2] = a / b;
			solution[3] = a * b;
			solution[4] = units[Frame.cbU.getSelectedIndex()];
			solution[5] = units[Frame.cbI.getSelectedIndex()];
			solution[6] = 0;
		}

		if ((tfI + tfb) == 4) {
			solution[0] = a;
			solution[1] = a / b;
			solution[2] = b;
			solution[3] = Math.pow(a, 2) / b;
			solution[4] = units[Frame.cbU.getSelectedIndex()];
			solution[5] = units[Frame.cbR.getSelectedIndex()];
			solution[6] = 1;
		}

		if (((tfI + tfb) == 5) && tfI == 1) {
			solution[0] = a;
			solution[1] = b / a;
			solution[2] = (Math.pow(a, 2) / b);
			solution[3] = b;
			solution[4] = units[Frame.cbU.getSelectedIndex()];
			solution[5] = units[Frame.cbP.getSelectedIndex()];
			solution[6] = 2;
		}

		if (((tfI + tfb) == 5) && tfI == 2) {
			solution[0] = a * b;
			solution[1] = a;
			solution[2] = b;
			solution[3] = Math.pow(a, 2) * b;
			solution[4] = units[Frame.cbI.getSelectedIndex()];
			solution[5] = units[Frame.cbR.getSelectedIndex()];
			solution[6] = 3;
		}

		if ((tfI + tfb) == 6) {
			solution[0] = b / a;
			solution[1] = a;
			solution[2] = b / Math.pow(a, 2);
			solution[3] = b;
			solution[4] = units[Frame.cbI.getSelectedIndex()];
			solution[5] = units[Frame.cbP.getSelectedIndex()];
			solution[6] = 4;
		}

		if ((tfI + tfb) == 7) {
			solution[0] = Math.sqrt((b * a));
			solution[1] = Math.sqrt((b / a));
			solution[2] = a;
			solution[3] = b;
			solution[4] = units[Frame.cbR.getSelectedIndex()];
			solution[5] = units[Frame.cbP.getSelectedIndex()];
			solution[6] = 5;
		}

		return solution;
	}

	public void switchCB(double[] solution) {
		double[] shortedSolv = new double[4];
		int id = (int) solution[6];

		double a;
		double b;
		switch (id) {

//		R and P
		case 0:
			a = solution[4] / solution[5];
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[2] = solution[2] / a;
					Frame.cbR.setSelectedIndex(i);
					break;
				}
			}

			b = solution[4] * solution[5];
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[3] = solution[3] / b;
					Frame.cbP.setSelectedIndex(i);
					break;
				}
				shortedSolv[0] = solution[0] / solution[4];
				shortedSolv[1] = solution[1] / solution[5];
			}
			break;

//		I and P	
		case 1:

			a = solution[4] / solution[5];
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[1] = solution[1] / a;
					Frame.cbI.setSelectedIndex(i);
					break;
				}
			}
			b = Math.pow(solution[4], 2) / solution[5];
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[3] = solution[3] / b;
					Frame.cbP.setSelectedIndex(i);
					break;
				}
			}
			shortedSolv[0] = solution[0] / solution[4];
			shortedSolv[2] = solution[2] / solution[5];

			break;

//		I and R	
		case 2:

			a = solution[5] / solution[4];
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[1] = solution[1] / a;
					Frame.cbI.setSelectedIndex(i);
					break;
				}
			}
			b = (Math.pow(solution[4], 2) / solution[5]);
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[2] = solution[2] / b;
					Frame.cbR.setSelectedIndex(i);
					break;
				}
			}

			shortedSolv[0] = solution[0] / solution[4];
			shortedSolv[3] = solution[3] / solution[5];

			break;

//		U and P	
		case 3:

			a = solution[4] * solution[5];
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[0] = solution[0] / a;
					Frame.cbU.setSelectedIndex(i);
					break;
				}
			}
			b = Math.pow(solution[4], 2) * solution[5];
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[3] = solution[3] / b;
					Frame.cbP.setSelectedIndex(i);
					break;
				}
			}

			shortedSolv[1] = solution[1] / solution[4];
			shortedSolv[2] = solution[2] / solution[5];

			break;

//		U and R
		case 4:

			a = solution[5] / solution[4];
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[0] = solution[0] / a;
					Frame.cbU.setSelectedIndex(i);
					break;
				}
			}
			b = solution[5] / Math.pow(solution[4], 2);
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[2] = solution[2] / b;
					Frame.cbR.setSelectedIndex(i);
					break;
				}
			}

			shortedSolv[1] = solution[1] / solution[4];
			shortedSolv[3] = solution[3] / solution[5];

			break;

//		U and I	
		case 5:
			a = Math.sqrt((solution[5] * solution[4]));
			for (int i = 0; i < 7; i++) {
				if (a == units[i]) {
					shortedSolv[0] = solution[0] / a;
					Frame.cbU.setSelectedIndex(i);
					break;
				}
			}
			b = Math.sqrt((solution[5] / solution[4]));
			for (int i = 0; i < 7; i++) {
				if (b == units[i]) {
					shortedSolv[1] = solution[1] / b;
					Frame.cbI.setSelectedIndex(i);
					break;
				}
			}

			shortedSolv[2] = solution[2] / solution[4];
			shortedSolv[3] = solution[3] / solution[5];

			break;
		}
		if (Frame.chRound.isSelected()) {
			Frame.tfU.setText(Math.round(shortedSolv[0]) + "");
			Frame.tfI.setText(Math.round(shortedSolv[1]) + "");
			Frame.tfR.setText(Math.round(shortedSolv[2]) + "");
			Frame.tfP.setText(Math.round(shortedSolv[3]) + "");
		} else {
			Frame.tfU.setText(shortedSolv[0] + "");
			Frame.tfI.setText(shortedSolv[1] + "");
			Frame.tfR.setText(shortedSolv[2] + "");
			Frame.tfP.setText(shortedSolv[3] + "");
		}
	}

}
