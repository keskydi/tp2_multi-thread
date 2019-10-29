# Programmation objet avanc�e 
# TP2-MultiThreading

__Interface Displayable:
	Cette interface est impl�ment�e par les classes Bird et Meat, elle permet d'acc�der � leur methode getPoint();

__Class Bird:
	Il s'agit d'une classe qui h�rite de la classe Thread, et qui g�re le comportement des pigeons. Elle boucle sur un ensemble d'instruction simple. 	
	Le thread cherche � manger:
		- Si il trouve il se dirige vers la nourriture et la mange en cas de contact;
		- En l'absence de nourriture, le pigeon s'endort;
		- Lors de l'�v�nement de fuite des pigeons, le pigeon a peur et se dirige alors vers un point al�atoire de la zone de jeu;

__Class Meat:
	La classe Meat d�finit la nourriture, elle impl�mente toutes les fonctions qui permettent de r�cup�rer le temps depuis lequel elle a �t� impl�ment�e, de reset ce dernier, ou encore de changer son �tat (fraiche ou non).

__Class Constants:
	Cette classe permet de centraliser un ensemble de constantes utilis�es � travers le programme. Elle permet donc d'acc�der facilement aux param�tres de lancement du programme (nombre de pigeons , taille de la fen�tre, etc...), et de pouvoir les changer rapidement, sans avoir � parcourir tous les scripts.

__Class Fenetre
	Cette classe d�finit la fen�tre d'affichage. Elle permet donc de modifier sa taille ainsi que son comportement.

__Class DrawPanel
	La classe DrawPanel d�finit la zone de jeu. Elle contient une liste de nourriture et une liste de pigeons, de plus elle cr�e un thread qui g�re la couleur des "Meat" en fonction de leur �tat de fraicheur, ainsi que leur destruction quand celles-ci sont p�rim�s depuis un certain temps. Elle g�re aussi l'�v�nement qui fait entrer les pigeons dans leur �tat de fuite.

__Class Point
	Cette classe d�finit un point, elle contient donc sa position, sa taille, ainsi que sa couleur, et permet de r�cup�rer et de setter ces derniers.