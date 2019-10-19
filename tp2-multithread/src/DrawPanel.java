
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

//CTRL + SHIFT + O pour générer les imports 
public class DrawPanel extends JPanel{

//Couleur du pointeur
private Color pointerColor = Color.red;
//Forme du pointeur
private String pointerType = "CIRCLE";
//Position X du pointeur
//private int posX = -10, oldX = -10;
//Position Y du pointeur
//private int posY = -10, oldY = -10;
//Pour savoir si on doit dessiner ou non
private boolean erasing = true;
//Taille du pointeur
private int pointerSize = 20;//15;
//Collection de points ! 
private ArrayList<Meat> points = new ArrayList<Meat>();  
private ArrayList<Bird> bird = new ArrayList<Bird>();


public DrawPanel(){
	
	for (int i=0; i<1; i++) 
			{ Point point = new Point(ThreadLocalRandom.current().nextInt(0, 680),ThreadLocalRandom.current().nextInt(0, 480),pointerSize,pointerColor,pointerType);
				Bird object = new Bird(point,null,this); 
				object.start(); 
				//object.sem = null;
				bird.add(object);
			} 

 this.addMouseListener(new MouseAdapter(){
   public void mousePressed(MouseEvent e){
	   Meat object = new Meat(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, Color.blue, pointerType));
	   //object.start();
	   points.add(object);
	   //DrawPanel t = DrawPanel.this;
	   //points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
     repaint();
   }
 });



}

// Vous la connaissez maintenant, celle-là
public void paintComponent(Graphics g) {

 g.setColor(Color.white);
 g.fillRect(0, 0, this.getWidth(), this.getHeight());

 //Si on doit effacer, on ne passe pas dans le else => pas de dessin
 if(this.erasing){
   this.erasing = false;
 }
 else{
   //On parcourt notre collection de points
   //for(Point p : this.points)
    for(Bird m : this.bird)
   {
    	Point p = m.getPoint(); 
     //On récupère la couleur
     g.setColor(p.getColor());

     //Selon le type de point
       g.fillRect((int)p.getX(), (int)p.getY(), p.getSize(), p.getSize());
    	//g.drawRect(p.getX(), p.getY(), p.getSize(), p.getSize());
   }
    for(Meat m : this.points)
   {
    	Point p = m.getPoint(); 
     //On récupère la couleur
     g.setColor(p.getColor());

     //Selon le type de point
       g.fillRect((int)p.getX(), (int)p.getY(), p.getSize(), p.getSize());
    	//g.drawRect(p.getX(), p.getY(), p.getSize(), p.getSize());
   }
 }        
}

//Efface le contenu
public void erase(){
 this.erasing = true;
 //this.points = new ArrayList<Point>();
 repaint();
}

//Définit la couleur du pointeur
public void setPointerColor(Color c){
 this.pointerColor = c;
}

//Définit la forme du pointeur
public void setPointerType(String str){
 this.pointerType = str;
}

public ArrayList<Meat> getPoints(){
	return this.points;
}

public Meat getLastMeat() {
	return this.points.get(this.points.size() -1);
}
}