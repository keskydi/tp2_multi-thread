import java.awt.Color;

public final class Constants {
	
	private Constants() {
	        // restrict instantiation
	}

	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOWS_WITDH = 700;
	public static final int BIRD_NB = 8;
	public static final int BIRD_SIZE = 20;
	public static final int MEAT_SIZE = 20;
	
	public static final Color COULEUR_BIRD = Color.red;
	public static final Color COULEUR_SLEEP_BIRD = Color.darkGray;
	public static final Color COULEUR_SCARED_BIRD = Color.orange;
	
	public static final Color COULEUR_MEAT = Color.blue;
	public static final Color COULEUR_ROTTEN_MEAT = Color.green;
	
	public static final int FRESH_TIME = 2;//seconde
	public static final int DEATH_TIME = 2;//seconde
}
