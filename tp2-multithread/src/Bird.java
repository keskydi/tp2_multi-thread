
import java.awt.Color;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.awt.Color;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class Bird extends Thread implements Displayable {
	Semaphore sem;
	Point p;
	DrawPanel f;
	LocalTime t = LocalTime.now();



	public Bird(Point p, Semaphore sem, DrawPanel f) {
		this.sem = sem;
		this.p = p;
		this.f = f;
	}

	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return this.p;
	}

	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			Meat freshestFood;
			while (true) {
				Thread.sleep(10);
				freshestFood = getFreshestFood();
				
				if (freshestFood != null) {
					t = LocalTime.now();
					this.p.setColor(Constants.COULEUR_BIRD);
					//if (freshestFood.isFresh()) {
						moveTo(freshestFood.getPoint(), 1);
					//}
					if (this.p.intersect(freshestFood.getPoint())) {
						eat(freshestFood);
					}
				}else if(t != null && ChronoUnit.SECONDS.between(t, LocalTime.now())>1){
					this.p.setColor(Constants.COULEUR_SLEEP_BIRD);
					f.repaint();
				}
				if(f.isScary()) {
					this.p.setColor(Constants.COULEUR_BIRD);
					Point scary = new Point(ThreadLocalRandom.current().nextInt(0, Constants.WINDOWS_WITDH - Constants.BIRD_SIZE-15),
							ThreadLocalRandom.current().nextInt(0, Constants.WINDOW_HEIGHT - Constants.BIRD_SIZE-39));
					while(f.isScary()) {
						Thread.sleep(10);
						moveTo(scary,1);
					}

				}

			}

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");

			e.printStackTrace();
		}
	}

	
	//todo sem here
	private Meat getFreshestFood() {
		Meat freshestFood = null;
		
		
		if(f.sem.tryAcquire()) {
			if (f.getPoints().size() > 0) {
				try {
					freshestFood = f.getPoints().get(f.getPoints().size() - 1);
				}catch(IndexOutOfBoundsException e) {
					System.out.println("deux thread on reussi a avoir le semaphores");
				}
				
			}
			f.sem.release();
		}
		 else {
			freshestFood = null;
		}
		return freshestFood;
	}

	private void moveTo(Point destPos, double speed) {
		double vectX = destPos.getX() - this.p.getX();
		double vectY = destPos.getY() - this.p.getY();
		double norm = Math.sqrt(vectX * vectX + vectY * vectY);

		if (norm * speed != 0) {
			this.p.setX(this.p.getX() + (vectX / norm) * speed);
			this.p.setY(this.p.getY() + (vectY / norm) * speed);
		}

		// repaint();
		f.repaint();
	}

	private void eat(Meat meat) {
		if (meat.sem.tryAcquire()) {
			// number of second
			if (meat.getTime() < Constants.FRESH_TIME) {
				if(f.sem.tryAcquire()) {
					//System.out.println("gg");
					try {
						f.getPoints().remove(f.getPoints().size() - 1);
					}catch(IndexOutOfBoundsException e) {
						System.out.println("deux thread on reussi a avoir le semaphores");
					}
				
				
				f.sem.release();}
			} else {
				if(f.sem.tryAcquire()) {
					
					f.addNonFreshPoints(meat);
					try {
						f.getPoints().remove(f.getPoints().size() - 1);
					}catch(IndexOutOfBoundsException e) {
						System.out.println("deux thread on reussi a avoir le semaphores");
					}
					
					meat.getPoint().setColor(Color.green);
					meat.setFresh(false);
					f.sem.release();
				}
				

			}
			meat.sem.release();
			meat.resetTime();
			f.repaint();
		}
	}
}
