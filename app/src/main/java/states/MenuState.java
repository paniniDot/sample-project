package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import royale.view.Royale;

public class MenuState extends State {
	
	private Texture background;
	private Texture playBtnTexture;
	private Rectangle playBtn;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		this.background = new Texture("Textures/Background.png");
		this.playBtnTexture = new Texture("Textures/Button.png");
		this.playBtn = new Rectangle((Royale.WIDTH / 2) - (this.playBtnTexture.getWidth() / 2), (Royale.HEIGHT / 2) - (this.playBtnTexture.getHeight() / 2), this.playBtnTexture.getWidth(), this.playBtnTexture.getHeight());
	}

	private boolean playButtonTouched() {
		return this.playBtn.contains(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
	}
	
	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()) {
			if(this.playButtonTouched()) {
				super.getGameStateManager().set(new PlayState(super.getGameStateManager()));
			}
		}
	}

	/* fai sempre handle input ad ogni update */
	@Override
	public void update(double dt) {
		this.handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(this.background, 0, 0, Royale.WIDTH, Royale.HEIGHT);
		sb.draw(this.playBtnTexture, (Royale.WIDTH / 2) - (this.playBtnTexture.getWidth() / 2), (Royale.HEIGHT / 2) - (this.playBtnTexture.getHeight() / 2));
		sb.end();
	}

	@Override
	public void dispose() {
		this.background.dispose();
		this.playBtnTexture.dispose();
	}

}
