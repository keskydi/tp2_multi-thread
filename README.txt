Programmation objet avanc�e 
TP2-MultiThreading

__Interface Displayable:
	Interface impl�ment� par Bird et Meat qui impl�mente la m�thode getPoint()

__Class Bird:
	Il s'agit de la classe qui �tend Thread et qui g�re le comportement des pigeons. Elle boucle sur un 	ensemble d'instruction simple. 	
	Le thread cherche a mang�:
		- si il trouve il se dirige vers la nourriture et la mange en cas de contact.
		- en l'absence de nourriture le pigeon s'endort.
		- de temps en temps le pigeon a peur et se dirige alors vers un point al�atoire.

__Class Meat:
	D�finit une nouritture.

__Class Constants:
	Cette classe regroupe un ensemble de constante utile dans le programme se qui permet de facilement changer 		les param�tres de lancement du programme (nombre de pigeon , taille de la fen�tre, etc...).

__Class Fenetre
	D�finit la fen�tre d'affichage, sa taille et ces �l�ments.

__Class DrawPanel
	D�finit la zone d'action. Elle contient une liste de nouriture et une liste de pigeon, de plus elle cr�e un 	thread qui g�re la couleur des Meat et leur destruction quand celle-ci sont p�rim�s. Elle g�re aussi 	l'�v�nement qui fait fuir le pigeon.

__Class Point
	D�finit un la position d'un point, sa taille et sa couleur.