package utilities;

import java.util.Timer;
import java.util.TimerTask;

public class Elisir {
	Timer timer;
	int elisir;

	public Elisir() {
		elisir = 0;
		timer = new Timer();
		timer.schedule(new ScriviDurata(), 0, 1000);
	}

	class ScriviDurata extends TimerTask {

		public void run() {
			System.out.println("elisir " + elisir);
			if (elisir < 10) {
				elisir++;
			}
		}
	}

	public int getelisir() {
		return elisir;
	}

	public void setelisir() {
		elisir = 0;
	}

	public void decrementelisir(int n) {
		elisir = elisir - n;
	}

	public void main(String args) {
		System.out.println("INIZIA il conto:");
		new Elisir();
	}
}
