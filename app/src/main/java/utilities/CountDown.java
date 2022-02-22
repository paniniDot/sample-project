package utilities;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown {

	Timer timer;
	int durata;

	public CountDown() {
		durata = 60;
		timer = new Timer();
		timer.schedule(new ScriviDurata(), 0, 1000);

	}

	class ScriviDurata extends TimerTask {

		public void run() {
			System.out.println("Restano " + durata + " secondi");
			if (durata > 0) {
				durata--;
			} else {
				timer.cancel();
			}
		}
	}

	public int getdurata() {
		return durata;
	}

	public void setdurata() {
		durata = 60;
	}

	public void main(String args) {
		System.out.println("INIZIA il conto alla rovescia:");
		new CountDown();
	}
}