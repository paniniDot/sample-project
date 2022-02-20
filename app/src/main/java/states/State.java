package states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class State {
	
	private final OrthographicCamera cam;
	private Vector2 mouse;
	private final GameStateManager gsm;
	
	protected State(GameStateManager gsm) {
		this.gsm = gsm;
		this.cam = new OrthographicCamera();
		this.mouse = new Vector2();
	}
	
	public GameStateManager getGameStateManager() {
		return this.gsm;
	}
	
	protected abstract void handleInput();
	
	/*
	 * Aggiorna la logica e tutto il resto tra un delta time e l'altro: tra un 
	 * frame e l'altro
	 */
	public abstract void update(double dt);
	
	/* 
	 * sprite batch: contenitore per tutti gli oggetti che vogliamo caricare 
	 * il metodo render non fa altro che mostrare a video tutto cio' che
	 * correntemente e' salvato nello SpriteBatch
	 * */
	public abstract void render(SpriteBatch sb);
	
	/* Serve per smantellare una texture una volta usata evitando problemi con la memoria */
	public abstract void dispose();
	
}
