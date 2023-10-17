package logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import data.DataLevel;
import domain.Ball;
import domain.Cilinder;
import gui.GUIGame;

public class ControllerGame implements ActionListener {

	private GUIGame game;
	private Logic log;
	private JButton matrix[][];
	private ArrayList<Cilinder> cilinders;
	private ArrayList<Ball> balls;

	private ArrayList<Integer> moves;
	private static int level = 5;
	private static int NumOfCilinder = 0;
	private static int NumOfBalls = 0;
	private int actualLevel;

	public ControllerGame(Logic log, int actualLevel) {
		game = new GUIGame();
		this.log = log;
		cilinders = new ArrayList<>();
		balls = new ArrayList<>();
		moves = new ArrayList<>();
		this.actualLevel = actualLevel;

		initializer();

	}

	private void initializer() {

		game.getLblNewLabel().setVisible(false);
		game.getMntnRestart().addActionListener(this);

		// -------------------------------------------------------------------
		level = actualLevel;
		initializeLevel();
		matrix = new JButton[4][NumOfCilinder];
		log.createAllCilinders(cilinders, NumOfCilinder);
		log.createAllBall(balls, NumOfBalls);
		log.fillAllCiliders(cilinders, balls);

		if (matrix[0].length > 7) {
			log.createButtonMatrix(matrix, game.getContent(), 0, 7, 70, 50);
			log.createButtonMatrix(matrix, game.getContent(), 7, matrix[0].length, 70, 340);
		} else {
			log.createButtonMatrix(matrix, game.getContent(), 0, matrix[0].length, 70, 50);
		}
		log.fillMatrix(cilinders, matrix);
		// -------------------------------------------------------------------

		actionButton(matrix);
		game.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		event(e, matrix);

		if (e.getSource() == game.getMntnRestart()) {
			resetCilinders();
			resetBalls();
			log.clearMatrix(matrix);
			log.fillAllCiliders(cilinders, balls);
			log.fillMatrix(cilinders, matrix);
		}

	}

	public void event(ActionEvent e, JButton matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (e.getSource() == matrix[i][j]) {
					moves.add(j);
					log.printCilinder(moves.get(0), matrix, Color.green);
					if (moves.size() == 2) {

						log.printCilinder(moves.get(0), matrix, Color.lightGray);

						log.clearMatrix(matrix);
						log.move(moves, cilinders);
						log.fillMatrix(cilinders, matrix);

						if (log.verifyWin(cilinders, balls)) {
							JOptionPane.showMessageDialog(null, "Has pasado el nivel");
							if (ControllerLevels.nextLevel) {
								DataLevel.writer((level + 1) + "", "Level.txt");
							}
							game.setVisible(false);
							game.dispose();

							new ControllerLevels();
						}
					}
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

	public void resetCilinders() {

		for (int i = 0; i < cilinders.size(); i++) {
			cilinders.get(i).getBall().clear();
		}

	}

	public void resetBalls() {

		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).setNum(4);
		}

	}

	public void initializeLevel() {
		if (level >= 1 && level <= 3) {
			NumOfBalls = 3;
			NumOfCilinder = 5;

		} else if (level == 4 || level == 5) {
			NumOfBalls = 5;
			NumOfCilinder = 7;

		} else if (level == 6 || level == 7) {
			NumOfBalls = 7;
			NumOfCilinder = 9;

		} else if (level >= 8 && level <= 10) {
			NumOfBalls = 9;
			NumOfCilinder = 11;

		} else if (level >= 11 && level <= 13) {
			NumOfBalls = 11;
			NumOfCilinder = 13;

		} else if (level >= 14 && level <= 16) {
			NumOfBalls = 12;
			NumOfCilinder = 14;

		}

	}

}
