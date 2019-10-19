

import java.awt.Color;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Bird extends Thread implements Displayable{
 Semaphore sem;
 Point p;
 DrawPanel f;
 LocalTime test;
 
 public Bird(Point p,Semaphore sem) {
		this.sem = sem;
		this.p = p;
	}
public Bird(Point p,Semaphore sem,DrawPanel f) {
	this.sem = sem;
	this.p = p;
	this.f = f;
	this.test = LocalTime.now();
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
		while(true) {
			Thread.sleep(1000);
			//System.out.println(Duration.between(test, LocalTime.now()));
			System.out.println(ChronoUnit.SECONDS.between(test, LocalTime.now()));
			move();
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

private void move() {
	this.p.setX(this.p.getX() + (ThreadLocalRandom.current().nextInt(0, 3)-1)*10);
	this.p.setY(this.p.getY() + (ThreadLocalRandom.current().nextInt(0, 3)-1)*10);
	//repaint();
	f.repaint();
}

private void eat(Meat meat) {
	if(meat.sem.tryAcquire()) {
		//number of second
		if(meat.getTime() < 100) {
			f.getPoints().remove(f.getPoints().size() -1);
		}else {
			meat.getPoint().setColor(Color.yellow);
			
		}
		
		meat.sem.release();
	}
}

}






