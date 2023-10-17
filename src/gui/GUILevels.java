package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUILevels extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;

	public GUILevels() {
		setTitle("Elegir nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		this.setLocationRelativeTo(null);
		
		
		setContentPane(contentPane);
		contentPane.add(getLblNewLabel());

		setVisible(true);
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(49, 39, 379, 351);
			panel.setLayout(new GridLayout(4, 4, 3, 3));
		}
		return panel;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Elija el nivel");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(49, 11, 379, 25);
		}
		return lblNewLabel;
	}
}
