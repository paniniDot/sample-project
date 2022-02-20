package royale.view;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import states.GameStateManager;
import states.MenuState;

public class Royale extends Game {
	
	public static final int WIDTH = 689;
	public static final int HEIGHT = 963;
	public static final String TITLE = "Clash Royale";
		
	private GameStateManager gsm;
	private SpriteBatch batch; 	
	
	@Override 
	public void create() {
		this.gsm = new GameStateManager();
		this.batch = new SpriteBatch();
		this.gsm.push(new MenuState(this.gsm));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.gsm.update(Gdx.graphics.getDeltaTime());
		this.gsm.render(batch);
	}
	
}
