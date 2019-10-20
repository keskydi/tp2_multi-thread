
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

//CTRL + SHIFT + O pour générer les imports 
public class DrawPanel extends JPanel {
	
	private Color pointerColor = Color.red;

	private ArrayList<Meat> points = new ArrayList<Meat>();
	private ArrayList<Bird> bird = new ArrayList<Bird>();
	private ArrayList<Meat> nonFreshPoints = new ArrayList<Meat>();

	public DrawPanel() {

		for (int i = 0; i < 8; i++) {
			Point point = new Point(ThreadLocalRandom.current().nextInt(0, Constants.WINDOWS_WITDH - Constants.BIRD_SIZE),
					ThreadLocalRandom.current().nextInt(0, Constants.WINDOW_HEIGHT - Constants.BIRD_SIZE),
					Constants.BIRD_SIZE,
					Constants.COULEUR_BIRD);
			Bird object = new Bird(point, null, this);
			object.start();
			// object.sem = null;
			bird.add(object);
		}

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Meat object = new Meat(new Point(e.getX() - (Constants.MEAT_SIZE / 2), e.getY() - (Constants.MEAT_SIZE / 2),
						Constants.MEAT_SIZE, Constants.COULEUR_MEAT));
				// object.start();
				points.add(object);
				// DrawPanel t = DrawPanel.this;
				// points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize /
				// 2), pointerSize, pointerColor, pointerType));
				repaint();
			}
		});

	}

// Vous la connaissez maintenant, celle-là
	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// On parcourt notre collection de points
			// for(Point p : this.points)
			for (Bird m : this.bird) {
				Point p = m.getPoint();
				// On récupère la couleur
				g.setColor(p.getColor());

				// Selon le type de point
				g.fillRect((int) p.getX(), (int) p.getY(), p.getSize(), p.getSize());
				// g.drawRect(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
			for (Meat m : this.points) {
				Point p = m.getPoint();
				// On récupère la couleur
				g.setColor(p.getColor());

				// Selon le type de point
				g.fillRect((int) p.getX(), (int) p.getY(), p.getSize(), p.getSize());
				// g.drawRect(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
			for (Meat m : this.nonFreshPoints) {
				Point p = m.getPoint();
				// On récupère la couleur
				g.setColor(p.getColor());

				// Selon le type de point
				g.fillRect((int) p.getX(), (int) p.getY(), p.getSize(), p.getSize());
				// g.drawRect(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
		
	}


//Définit la couleur du pointeur
	public void setPointerColor(Color c) {
		this.pointerColor = c;
	}


	public ArrayList<Meat> getPoints() {
		return this.points;
	}

	public void addNonFreshPoints(Meat nonFreshMeat) {
		nonFreshPoints.add(nonFreshMeat);
	}

	public Meat getLastMeat() {
		return this.points.get(this.points.size() - 1);
	}
}