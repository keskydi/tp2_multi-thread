import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Semaphore;

public class Meat implements Displayable {
	Semaphore sem;
	Point point;
	LocalTime time;
	boolean fresh;

	Meat(Point point) {
		this.point = point;
		this.time = LocalTime.now();
		this.fresh = true;
		this.sem = new Semaphore(1);
	}

	public Point getPoint() {
		return this.point;
	}

	public long getTime() {
		return ChronoUnit.SECONDS.between(time, LocalTime.now());
	}

	public boolean isFresh() {
		return this.fresh;
	}

	public void setFresh(boolean state) {
		this.fresh = state;
	}
	
	public void resetTime() {
		this.time = LocalTime.now();
	}
}
