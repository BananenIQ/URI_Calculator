package BananenIQ.U_R_I_Rechner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("rawtypes")
public class Frame {

	private JFrame frmUriRechner;
	public static JTextField tfU;
	public static JTextField tfI;
	public static JTextField tfR;
	public static JTextField tfP;
	public static JComboBox cbU;
	public static JComboBox cbI;
	public static JComboBox cbR;
	public static JComboBox cbP;
	public static JLabel lblMessage;
	public static JCheckBox chRound;

//	-9 = 10^-9
//	-6 = 10^-6
//	-3 = 10^-3
//	0 = 10^0
//	3 = 10^3
//	6 = 10^6
//	9 = 10^9

// tf1 = Voltage
// tf2 = Ampere
// tf3 = Omega
// tf3 = Watt

	public Frame() {
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
		frmUriRechner = new JFrame();
		frmUriRechner.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/FrameIcon.png"));
		frmUriRechner.setTitle("URI Rechner");
		frmUriRechner.setBounds(100, 100, 340, 235);
		frmUriRechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frmUriRechner.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnRechne = new JButton("Calculate");
		btnRechne.setBounds(225, 22, 89, 23);
		panel.add(btnRechne);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(225, 56, 89, 23);
		panel.add(btnClear);

		chRound = new JCheckBox("Round");
		chRound.setHorizontalAlignment(SwingConstants.CENTER);
		chRound.setBounds(225, 86, 89, 23);
		panel.add(chRound);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(225, 121, 89, 23);
		panel.add(btnExit);

		tfU = new JTextField();
		tfU.setToolTipText("Voltage");
		tfU.setBounds(24, 23, 120, 20);
		panel.add(tfU);
		tfU.setColumns(10);

		tfI = new JTextField();
		tfI.setToolTipText("Current");
		tfI.setColumns(10);
		tfI.setBounds(24, 57, 120, 20);
		panel.add(tfI);

		tfR = new JTextField();
		tfR.setToolTipText("Resistance");
		tfR.setColumns(10);
		tfR.setBounds(24, 91, 120, 20);
		panel.add(tfR);

		tfP = new JTextField();
		tfP.setToolTipText("Power");
		tfP.setColumns(10);
		tfP.setBounds(24, 122, 120, 20);
		panel.add(tfP);

		lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMessage.setBounds(24, 155, 290, 33);
		panel.add(lblMessage);

		cbU = new JComboBox();
		cbU.setBounds(154, 23, 61, 20);
		cbU.addItem("nV");
		cbU.addItem("µV");
		cbU.addItem("mV");
		cbU.addItem("V");
		cbU.addItem("kV");
		cbU.addItem("MV");
		cbU.addItem("GV");
		cbU.setSelectedItem("V");
		panel.add(cbU);

		cbI = new JComboBox();
		cbI.setBounds(154, 57, 61, 20);
		cbI.addItem("nA");
		cbI.addItem("µA");
		cbI.addItem("mA");
		cbI.addItem("A");
		cbI.addItem("kA");
		cbI.addItem("MA");
		cbI.addItem("GA");
		cbI.setSelectedItem("A");
		panel.add(cbI);

		cbR = new JComboBox();
		cbR.setBounds(154, 91, 61, 20);
		cbR.addItem("n\u03A9");
		cbR.addItem("µ\u03A9");
		cbR.addItem("m\u03A9");
		cbR.addItem("\u03A9");
		cbR.addItem("k\u03A9");
		cbR.addItem("M\u03A9");
		cbR.addItem("G\u03A9");
		cbR.setSelectedItem("\u03A9");
		panel.add(cbR);

		cbP = new JComboBox();
		cbP.setBounds(154, 122, 61, 20);
		cbP.addItem("nW");
		cbP.addItem("µW");
		cbP.addItem("mW");
		cbP.addItem("W");
		cbP.addItem("kW");
		cbP.addItem("MW");
		cbP.addItem("GW");
		cbP.setSelectedItem("W");
		panel.add(cbP);
		
		btnRechne.setMnemonic(KeyEvent.VK_A);
		btnClear.setMnemonic(KeyEvent.VK_C);
		chRound.setMnemonic(KeyEvent.VK_R);
		btnExit.setMnemonic(KeyEvent.VK_E);
		
		frmUriRechner.setVisible(true);

		btnRechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Curi(tfU, tfI, tfR, tfP);
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfU.setText("");
				tfI.setText("");
				tfR.setText("");
				tfP.setText("");
				lblMessage.setText("");
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

	}
}
