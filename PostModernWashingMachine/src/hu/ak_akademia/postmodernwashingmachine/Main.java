package hu.ak_akademia.postmodernwashingmachine;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try {
			PostModernWashingMachine machine = new PostModernWashingMachine();
			Clothes shirt = new Shirt("Ing", "fehér", 5);
			Clothes pants = new Pants("Farmernadrág", "fehér", 32);
			Clothes socks = new Socks("Zokni", "fehér", 13);
			machine.switchOn();
			machine.openDoor();
			machine.load(shirt, pants, socks);
			machine.close();
			machine.startWash();
			machine.dry();
			machine.iron();
			machine.openDoor();
			machine.unload();
			machine.switchOff();
		} catch (Exception e) {
		}
	}

}
