import java.awt.Color;


public class Point {

private Color color = Color.red;
private int size;
private int x;
private int y;
private String type = "ROND";

public Point(){}

public Point(int x, int y, int size, Color color, String type){
 this.size = size;
 this.x = x;
 this.y = y;
 this.color = color;
 this.type = type;
}

public boolean intersect(Point b) {
	if((this.x > (b.getX() -this.size)) &&
		(this.x < (b.getX() + b.getSize())) &&
		(this.y > (b.getY() - this.size)) &&
		(this.y < (b.getY() + b.getSize()))){
						return true;
					}else {return false;}
}

//ACCESSEURS
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
public int getX() {
	//x+=5;
 return x;
}
public void setX(int x) {
 this.x = x;
}
public int getY() {
	//y +=5;
 return y;
}
public void setY(int y) {
 this.y = y;
}
public String getType() {
 return type;
}
public void setType(String type) {
 this.type = type;
}
}