import java.util.concurrent.Semaphore;
import java.awt.Color;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class Bird extends Thread implements Displayable{
 Semaphore sem;
 Point p;
 DrawPanel f;
 
 public Bird(Point p,Semaphore sem) {
		this.sem = sem;
		this.p = p;
	}
public Bird(Point p,Semaphore sem,DrawPanel f) {
	this.sem = sem;
	this.p = p;
	this.f = f;
}
@Override
public Point getPoint() {
	// TODO Auto-generated method stub
	return this.p;
}

public void run() 
{ 
	try
	{ 
		// Displaying the thread that is running 
		System.out.println ("Thread " + 
			Thread.currentThread().getId() + 
			" is running"); 
		int min = 0;
		int max = 5000;
		Point freshestFood;
		while(true) {
			Thread.sleep(10);
			freshestFood = new Point(0, 0, 0, Color.black, "NON");//getFreshestFood();
			moveTo(freshestFood, 1);
			//System.out.println ("Actions: Thread " + 
				//	Thread.currentThread().getId() + 
					//" is running"); 
		}
		/*Thread.sleep(5000);
		try{
			if(this.sem.tryAcquire()) {
				System.out.println("sem get");
			}
		}catch(NullPointerException e) {
			System.out.println("object has been deleted");
		}*/

	} 
	catch (Exception e) 
	{ 
		// Throwing an exception 
		System.out.println ("Exception is caught"); 
		
		e.printStackTrace();
	} 
}

//Return the nearest food position if existing, else return the curent position
//private Point getFreshestFood() {
//	Point freshestFood;
//	return freshestFood;
//}

private void move() {
	this.p.setX(this.p.getX() + (ThreadLocalRandom.current().nextInt(0, 3)-1));
	this.p.setY(this.p.getY() + (ThreadLocalRandom.current().nextInt(0, 3)-1));
	//repaint();
	f.repaint();
}

private void moveTo(Point destPos, double speed) {
	double vectX =destPos.getX() - this.p.getX();
	double vectY =destPos.getY() - this.p.getY();
	double norm = Math.sqrt(vectX * vectX + vectY * vectY);
	
	if(norm * speed != 0) {
		this.p.setX(this.p.getX() + (vectX / norm) * speed);
		System.out.println((vectX / norm) * speed);
		this.p.setY(this.p.getY() +(vectY / norm) * speed);
	}

	//repaint();
	f.repaint();
}
}






