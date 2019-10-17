

import java.util.concurrent.Semaphore;
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
		while(true) {
			Thread.sleep(100);
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

}






