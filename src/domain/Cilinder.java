package domain;
import java.util.Stack;

public class Cilinder {

	private int id;
	private Stack<Ball> ball;
	
	public Cilinder() {
		
	}
	
	public Cilinder(int id, Stack<Ball> ball) {
		super();
		this.id = id;
		this.ball = ball;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stack<Ball> getBall() {
		return ball;
	}

	public void setBall(Stack<Ball> ball) {
		this.ball = ball;
	}

	@Override
	public String toString() {
		return "Cilinder [id=" + id + ", ball=" + ball + "]";
	}
	
	
	
}
