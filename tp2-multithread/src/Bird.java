
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
	LocalTime test;

	public Bird(Point p, Semaphore sem) {
		this.sem = sem;
		this.p = p;
	}

	public Bird(Point p, Semaphore sem, DrawPanel f) {
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

	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			int min = 0;
			int max = 5000;
			Meat freshestFood;
			while (true) {
				Thread.sleep(10);
				freshestFood = getFreshestFood();
				if (freshestFood != null) {
					if (freshestFood.isFresh()) {
						moveTo(freshestFood.getPoint(), 1);
					}
					if (this.p.intersect(freshestFood.getPoint())) {
						eat(freshestFood);
					}
				}

				// System.out.println ("Actions: Thread " +
				// Thread.currentThread().getId() +
				// " is running");
			}
			/*
			 * Thread.sleep(5000); try{ if(this.sem.tryAcquire()) {
			 * System.out.println("sem get"); } }catch(NullPointerException e) {
			 * System.out.println("object has been deleted"); }
			 */

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");

			e.printStackTrace();
		}
	}

	private Meat getFreshestFood() {
		Meat freshestFood;
		if (f.getPoints().size() > 0) {
			freshestFood = f.getPoints().get(f.getPoints().size() - 1);
		} else {
			freshestFood = null;
		}
		return freshestFood;
	}

	private void move() {
		this.p.setX(this.p.getX() + (ThreadLocalRandom.current().nextInt(0, 3) - 1));
		this.p.setY(this.p.getY() + (ThreadLocalRandom.current().nextInt(0, 3) - 1));
		// repaint();
		f.repaint();
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

	private void flee(Point destPos, double speed) {
		double vectX = this.p.getX() - destPos.getX();
		double vectY = this.p.getY() - destPos.getY();
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
			if (meat.getTime() < 3) {
				f.getPoints().remove(f.getPoints().size() - 1);
			} else {
				f.addNonFreshPoints(meat);
				f.getPoints().remove(f.getPoints().size() - 1);
				meat.getPoint().setColor(Color.yellow);
				meat.setFresh(false);
			}
			meat.sem.release();
		}
	}
}
