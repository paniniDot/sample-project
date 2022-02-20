package animations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
	private List<TextureRegion> frames;
	private double maxFrameTime;
	private double currentFrameTime;
	private int frameCount;
	private int frame;
	
	public Animation(TextureRegion region, int frameCount, double cycleTime) {
		int frameWidth = region.getRegionWidth() / frameCount;
		this.frames = IntStream.range(0, frameCount)
				.mapToObj(i -> new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()))
				.collect(Collectors.toList());
		this.maxFrameTime = cycleTime / frameCount;
		this.frameCount = frameCount;
		this.frame = 0;
	}
	
	public void update(double dt) {
		this.currentFrameTime += dt;
		if(this.currentFrameTime > this.maxFrameTime) {
			this.frame++;
			this.currentFrameTime = 0;
		}
		if(this.frame >= this.frameCount) {
			this.frame = 0;
		}
	}
	
	public TextureRegion getFrame() {
		return this.frames.get(this.frame);
	}
	
}
