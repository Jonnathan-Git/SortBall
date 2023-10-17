package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import data.DataLevel;
import gui.GUILevels;

public class ControllerLevels implements ActionListener{

	private GUILevels levels;
	private JButton Matrix [][];
	private Logic log;
	private int levelTop = 0;
	public static boolean nextLevel = false;
	
	public ControllerLevels() {
		levels = new GUILevels();
		Matrix = new JButton[4][4];
		log = new Logic();
		initializer();
	}
	
	private void initializer() {
		levelTop = Integer.parseInt(DataLevel.read("Level.txt"));
		
		log.createMatrix(Matrix, levels.getPanel());
		log.blockLevels(Matrix, levelTop);
		actionButton(Matrix);
		
		levels.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		event(e, Matrix);
		
	}
	
	public void event(ActionEvent e, JButton matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (e.getSource() == matrix[i][j]) {
					if(Integer.parseInt(matrix[i][j].getText()) > levelTop) {
					DataLevel.writer(matrix[i][j].getText(), "Level.txt");
					}
					
					if(levelTop == Integer.parseInt(matrix[i][j].getText())) {
						nextLevel = true;
					}
					
					levels.setVisible(false);
					levels.dispose();
					new ControllerGame(log,Integer.parseInt(matrix[i][j].getText()));
				}
			}
		}

	}

	public void actionButton(JButton matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j].addActionListener(this);
			}
		}
	}

}
