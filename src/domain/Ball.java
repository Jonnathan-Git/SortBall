package domain;

import javax.swing.ImageIcon;

public class Ball {
	
	private int id;
	private int num;
	private ImageIcon img;
	
	public Ball() {
		
	}

	public Ball(int id, int num, ImageIcon img) {
		super();
		this.id = id;
		this.num = num;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Ball [id=" + id + ", num=" + num + ", img=" + img + "]";
	}

	
}
