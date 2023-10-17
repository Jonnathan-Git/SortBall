package logic;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import domain.Ball;
import domain.Cilinder;

public class Logic {

	public void createButtonMatrix(JButton[][] matrix, JPanel panel, int range1, int limit1, int x, int y) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = range1; j < limit1; j++) {
				matrix[i][j] = new JButton();
				matrix[i][j].setFocusPainted(false);
				matrix[i][j].setContentAreaFilled(false);
				matrix[i][j].setBounds(x, y, 50, 50);
				Border border = BorderFactory.createLineBorder(Color.lightGray, 2);
			    matrix[i][j].setBorder(border);
				x += 75;
				panel.add(matrix[i][j]);
			}
			y += 62;
			x = 70;
		}
	}

	public void createMatrix(JButton[][] matrix, JPanel panel) {
		int count = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = new JButton();
				matrix[i][j].setText(count + "");
				matrix[i][j].setFont(new Font("Arial", Font.BOLD, 30));
				panel.add(matrix[i][j]);
				count++;
			}
		}
	}

	public void blockLevels(JButton[][] matrix, int limit) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (count < limit) {
					matrix[i][j].setEnabled(true);
				} else {
					matrix[i][j].setEnabled(false);
				}
				count++;
			}
		}
	}

	public void createAllBall(ArrayList<Ball> balls, int level) {

		for (int i = 1; i <= level; i++) {

			balls.add(new Ball(i, 4, new ImageIcon("src/img/ball(" + i + ").png")));
		}

	}

	public void createAllCilinders(ArrayList<Cilinder> cilinders, int level) {

		for (int i = 0; i < level; i++) {

			cilinders.add(new Cilinder(i, new Stack<Ball>()));
		}

	}

	public int verifyCilinders(Cilinder cilinder, int id) {

		int count = 0;
		if (!cilinder.getBall().isEmpty()) {

			for (int i = 0; i < cilinder.getBall().size(); i++) {
				if (cilinder.getBall().get(i).getId() == id) {
					count++;
				}

			}

		}
		return count;
	}

	public void fillAllCiliders(ArrayList<Cilinder> cilinders, ArrayList<Ball> balls) {
		for (int x = 0; x < 4; x++) {
			for (int i = 0; i < cilinders.size() - 2; i++) {

				if (cilinders.get(i).getBall().size() < 4) {

					int rand = ThreadLocalRandom.current().nextInt(0, balls.size());
					if (verifyCilinders(cilinders.get(i), balls.get(rand).getId()) <= 3
							&& balls.get(rand).getNum() > 0) {
						cilinders.get(i).getBall().add(balls.get(rand));
						balls.get(rand).setNum(balls.get(rand).getNum() - 1);
					} else {
						i--;
					}
				}
			}
		}
	}

	public void fillMatrix(ArrayList<Cilinder> cilinders, JButton[][] matrix) {

		for (int i = 0; i < matrix[0].length; i++) {
			int temp = 0;
			for (int j = matrix.length - 1; j >= 0; j--) {
				if (!cilinders.get(i).getBall().isEmpty() && cilinders.get(i).getBall().size() > temp) {
					matrix[j][i].setIcon(cilinders.get(i).getBall().get(temp).getImg());
					temp++;
				}
			}
		}

	}

	public void clearMatrix(JButton[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j].setIcon(null);
			}
		}

	}

	public void move(ArrayList<Integer> move, ArrayList<Cilinder> cilinders) {

		Ball temp = null;
		if (!verifyOriginCilinder(cilinders, move.get(0))) {
			if (!verifyCilinderFull(cilinders, move.get(1)) & verifyColorOfBall(move, cilinders)) {
				temp = cilinders.get(move.get(0)).getBall().pop();
				cilinders.get(move.get(1)).getBall().push(temp);
			} else {
				System.out.println("MOVIMIENTO INVÁLIDO");
			}
		} else {
			System.out.println("MOVIMIENTO INVÁLIDO");
		}
		move.clear();
	}

	public boolean verifyColorOfBall(ArrayList<Integer> move, ArrayList<Cilinder> cilinders) {
		boolean flag = false;
		if (!cilinders.get(move.get(1)).getBall().isEmpty()) {
			if (cilinders.get(move.get(0)).getBall().peek().getId() == cilinders.get(move.get(1)).getBall().peek()
					.getId()) {
				flag = true;
			}
		} else {
			flag = true;
		}
		return flag;
	}

	public boolean verifyCilinderFull(ArrayList<Cilinder> cilinders, int position) {

		boolean flag = false;
		if (cilinders.get(position).getBall().size() == 4) {
			flag = true;
		}
		return flag;
	}

	public boolean verifyOriginCilinder(ArrayList<Cilinder> cilinders, int position) {

		boolean flag = false;
		if (cilinders.get(position).getBall().isEmpty()) {
			flag = true;
		}
		return flag;
	}

	public boolean verifyWin(ArrayList<Cilinder> cilinders, ArrayList<Ball> balls) {
		int count = 0;
		for (Ball ball : balls) {
			for (Cilinder cilinder : cilinders) {
				if (!cilinder.getBall().isEmpty()) {
					if (verifyAllCilinder(cilinder, ball.getId())) {
						count++;
					}
				}
			}
		}
		return count == (cilinders.size() - 2) ? true : false;
	}

	public boolean verifyAllCilinder(Cilinder cilinder, int id) {
		int count = 0;
		for (Ball ball : cilinder.getBall()) {
			if (ball.getId() == id) {
				count++;
			}
		}
		return count == 4 ? true : false;
	}

	public String getPath() {

		String path = System.getProperty("user.dir");

		return path;
	}

	public void printCilinder(int j,JButton matrix [][],Color color) {
		for (int i = 0; i < matrix.length; i++) {
			Border border = BorderFactory.createLineBorder(color, 2);
			matrix[i][j].setBorder(border);
		}
	}

}
