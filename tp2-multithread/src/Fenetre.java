
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

//CTRL + SHIFT + O pour générer les imports 
public class Fenetre extends JFrame {


private DrawPanel drawPanel = new DrawPanel();

public Fenetre(){
  this.setSize(700, 500);
  this.setResizable(false);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  drawPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
  this.getContentPane().add(drawPanel, BorderLayout.CENTER);
  this.setVisible(true);    
}
   


public static void main(String[] args){
  Fenetre fen = new Fenetre();
}    
}