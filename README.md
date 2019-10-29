# Programmation objet avancée 
# TP2-MultiThreading

__Interface Displayable:
	Cette interface est implémentée par les classes Bird et Meat, elle permet d'accéder à leur methode getPoint();

__Class Bird:
	Il s'agit d'une classe qui hérite de la classe Thread, et qui gére le comportement des pigeons. Elle boucle sur un ensemble d'instruction simple. 	
	Le thread cherche à manger:
		- Si il trouve il se dirige vers la nourriture et la mange en cas de contact;
		- En l'absence de nourriture, le pigeon s'endort;
		- Lors de l'événement de fuite des pigeons, le pigeon a peur et se dirige alors vers un point aléatoire de la zone de jeu;

__Class Meat:
	La classe Meat définit la nourriture, elle implémente toutes les fonctions qui permettent de récupérer le temps depuis lequel elle a été implémentée, de reset ce dernier, ou encore de changer son état (fraiche ou non).

__Class Constants:
	Cette classe permet de centraliser un ensemble de constantes utilisées à travers le programme. Elle permet donc d'accéder facilement aux paramètres de lancement du programme (nombre de pigeons , taille de la fenêtre, etc...), et de pouvoir les changer rapidement, sans avoir à parcourir tous les scripts.

__Class Fenetre
	Cette classe définit la fenêtre d'affichage. Elle permet donc de modifier sa taille ainsi que son comportement.

__Class DrawPanel
	La classe DrawPanel définit la zone de jeu. Elle contient une liste de nourriture et une liste de pigeons, de plus elle crée un thread qui gére la couleur des "Meat" en fonction de leur état de fraicheur, ainsi que leur destruction quand celles-ci sont périmés depuis un certain temps. Elle gére aussi l'événement qui fait entrer les pigeons dans leur état de fuite.

__Class Point
	Cette classe définit un point, elle contient donc sa position, sa taille, ainsi que sa couleur, et permet de récupérer et de setter ces derniers.