import java.awt.Color;

public class Point {

	private Color color = Color.red;
	private int size;
	private double x;
	private double y;

	public Point() {
	}
	
	public Point(int x,int y) {
		this.x = x;
		this.y =y;
	}

	public Point(int x, int y, int size, Color color) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public boolean intersect(Point b) {
		if ((this.x > (b.getX() - this.size)) && (this.x < (b.getX() + b.getSize()))
				&& (this.y > (b.getY() - this.size)) && (this.y < (b.getY() + b.getSize()))) {
			return true;
		} else {
			return false;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		// y +=5;
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}