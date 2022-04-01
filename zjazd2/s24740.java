package gamers;

import main.Config;
import main.Pair;
import main.Unit;

import java.util.Random;

@SuppressWarnings("serial")
public class s24740 extends Unit {

	public s24740(final String id, final Pair<Double, Double> position, final double r,
                  final CollisionModel model) {
		super(id, position, r, model);

	}

	@Override
	public void run() {
		final Random rand = new Random();
		this.enableMovement();
		this.enableStopOnWall();

		while (true) {


			atakujJesliMozesz();
//			this.nearestCollision()
			while (this.whatIsInRange() == 0) {
				this.forward();
//				System.out.println("aktualny speed: " + this.getActualRotateSpeed());
//				this.setRotateSpeed(100);
				int RandomowaLiczba = rand.nextInt(100000);

//				System.out.println("Lewo" + RandomowaLiczba);
				if(RandomowaLiczba == 1){
					this.rotateBy(rand.nextInt(180));
//					System.out.println("Lewo" + RandomowaLiczba);
				}
				if(RandomowaLiczba == 9999){
					this.rotateBy(rand.nextInt(180)*-1);
//					System.out.println("Prawo" + RandomowaLiczba);
				}
			}
			while (this.whatIsInRange() == 1) {
				przeszkoda(90);
			}
			while (this.whatIsInRange() == 2) {
				przeszkoda(90);
			}


		}
	}

	void atakujJesliMozesz() {
		while (this.whatIsInRange() == 3)
			this.attackInNextMove();
	}
	void przeszkoda(int deg) {
		this.backward();
		this.rotateBy(deg);
		if(isRotating()){
			System.out.println("Obracam sie");
		}else{
//			this.forward();
		}
	}

	void sleepWakedUped(final long ms) {
		this.stop();
		final long time = System.currentTimeMillis() + ms;
		while (this.whatIsInRange() != 3 && System.currentTimeMillis() < time)
			;
	}
}
