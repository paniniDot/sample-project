/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package royale.emulator;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import royale.view.Royale;

public class App {

    public static void main(String[] args) {
    	Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    	config.setTitle(Royale.TITLE);
		config.setWindowedMode(Royale.WIDTH, Royale.HEIGHT);
		config.setForegroundFPS(60);
    	new Lwjgl3Application(new Royale(), config);
    }
}