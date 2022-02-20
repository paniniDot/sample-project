package states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/* e' un gestore di stati: ogni stato e' una scena a se (ad esempio 
 * il gioco in se e per se oppure il menu principale ecc.)
 * Il game state manager funziona come uno stack di stati, lui fara' 
 * renderizzare a libGDX solamente lo stato superiore.
 */
public class GameStateManager {
	
	private final Stack<State> states;
	
	public GameStateManager() {
		this.states = new Stack<>();
	}
	
	public void push(final State state) {
		this.states.push(state);
	}
	
	public void pop() {
		this.states.pop().dispose();
	}
	
	public void set(final State state) {
		this.pop();
		this.push(state);
	}
	
	public void update(final double dt) {
		this.states.peek().update(dt);
	}
	
	public void render(final SpriteBatch sb) {
		this.states.peek().render(sb);
	}
}
