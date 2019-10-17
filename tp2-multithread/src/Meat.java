import java.util.concurrent.Semaphore;

public class Meat implements Displayable  {
 Semaphore sem;
 Point point;
 Meat(Point point){
	this.point = point; 
 }
 
 public Point getPoint() {
	 return this.point;
 }
}
