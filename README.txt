Programmation objet avancée 
TP2-MultiThreading

__Interface Displayable:
	Interface implémenté par Bird et Meat qui implémente la méthode getPoint()

__Class Bird:
	Il s'agit de la classe qui étend Thread et qui gére le comportement des pigeons. Elle boucle sur un 	ensemble d'instruction simple. 	
	Le thread cherche a mangé:
		- si il trouve il se dirige vers la nourriture et la mange en cas de contact.
		- en l'absence de nourriture le pigeon s'endort.
		- de temps en temps le pigeon a peur et se dirige alors vers un point aléatoire.

__Class Meat:
	Définit une nouritture.

__Class Constants:
	Cette classe regroupe un ensemble de constante utile dans le programme se qui permet de facilement changer 		les paramètres de lancement du programme (nombre de pigeon , taille de la fenêtre, etc...).

__Class Fenetre
	Définit la fenêtre d'affichage, sa taille et ces éléments.

__Class DrawPanel
	Définit la zone d'action. Elle contient une liste de nouriture et une liste de pigeon, de plus elle crée un 	thread qui gére la couleur des Meat et leur destruction quand celle-ci sont périmés. Elle gére aussi 	l'événement qui fait fuir le pigeon.

__Class Point
	Définit un la position d'un point, sa taille et sa couleur.