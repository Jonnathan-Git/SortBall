package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;

public class GUIGame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel pnlOne;
	private JPanel pnlTwo;
	private JLabel lblNewLabel;
	private JMenu mnNewMenu;
	private JMenuItem mntnRestart;

	public GUIGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 696);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		contentPane.add(getPnlOne());
		contentPane.add(getPnlTwo());

		contentPane.add(getLblNewLabel());
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);

	}
	
	public JPanel getContent() {
		if (contentPane == null) {
			contentPane = new JPanel();
		}
		return contentPane;
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}

	public JPanel getPnlOne() {
		if (pnlOne == null) {
			pnlOne = new JPanel();
			pnlOne.setOpaque(false);
			pnlOne.setBounds(55, 74, 523, 225);
			pnlOne.setLayout(new GridLayout(4, 7, 20, 3));
		}
		return pnlOne;
	}

	public JPanel getPnlTwo() {
		if (pnlTwo == null) {
			pnlTwo = new JPanel();
			pnlTwo.setOpaque(false);
			pnlTwo.setBounds(55, 331, 523, 225);
			pnlTwo.setLayout(new GridLayout(4, 7, 20, 3));
		}
		return pnlTwo;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(GUIGame.class.getResource("/img/fondo.jpg")));
			lblNewLabel.setBounds(0, 0, 641, 630);
		}
		return lblNewLabel;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Menu");
			mnNewMenu.add(getMntnRestart());
		}
		return mnNewMenu;
	}
	public JMenuItem getMntnRestart() {
		if (mntnRestart == null) {
			mntnRestart = new JMenuItem("REINICIAR");
		}
		return mntnRestart;
	}
}
