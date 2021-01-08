package hu.ak_akademia.postmodernwashingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostModernWashingMachine {
	private boolean machineOn;
	private boolean openedDoor;
	private State state;
	private List<Clothes> dresses;
	private int dirtySum = 0;

	public PostModernWashingMachine() {
		machineOn = false;
		openedDoor = false;
		state = State.OFF;
		dresses = new ArrayList<>();
	}

	public void switchOn() {
		if (!machineOn) {
			machineOn = true;
			state = State.ON;
			System.out.println("A mosógép bekapcsolódik.");
		} else {
			System.out.println("The waschmashine already switched on. ");
		}
	}

	public void switchOff() {
		machineOn = false;
		state = State.OFF;
		System.out.println("A mosógép kikapcsolódik.");
	}

	public void openDoor() {
		if (machineOn) {
			openedDoor = true;
			System.out.println("A mosógép ajtaja kinyitódik.");
		} else {
			System.out.println("Open the door not allowed, while Cleaning in progress.");
		}
	}

	public void close() {
		if (machineOn) {
			if (openedDoor) {
				openedDoor = false;
				System.out.println("A mosógép ajtaja becsukódik");
			} else {
				System.out.println("Closing the door not allowed, while the machine's door is closed.");
			}
		}
	}

	public void load(Clothes... clothes) {
		if (machineOn) {
			dresses.addAll(Arrays.asList(clothes));
			for (Clothes dirtyCount : clothes) {
				dirtySum += dirtyCount.getDirty();
			}
		}
		System.out.println("A mosógépbe az alábbi ruhák kerülnek betöltésre: \n" + dresses.toString());
		System.out.println("A mosógépbe kerürlt ruhák összkoszossága: " + dirtySum);
	}

	public List<Clothes> unload() {
		List<Clothes> done = null;
		if (machineOn && !dresses.isEmpty()) {
			done = new ArrayList<>(dresses);
			dresses.clear();
			System.out.println("A mosógépből kivéve: \n" + done.toString());
		} else if (machineOn && dresses.isEmpty()) {
			System.out.println("A mosógépben nincs kiszedni való ruha.");
		}
		return done;
	}

	public void iron() {
		if (!dresses.isEmpty()) {
			for (Clothes clothes : dresses) {
				clothes.iron();
				System.out.println(clothes.getName() + " kivasalva.");
			}
		} else {
		}
	}

	public void dry() {
		if (!dresses.isEmpty()) {
			for (Clothes clothes : dresses) {
				clothes.dry();
			}
		} else {
			System.out.println("A mosógépben nincs száritani való ruha.");
		}
	}

	private String check() {
		boolean white = false;
		boolean colorful = false;
		return parameterChecker(white, colorful);
	}

	private String parameterChecker(boolean white, boolean colorful) {
		if (machineOn) {
			for (Clothes clothes : dresses) {
				if (clothes.getColor()
						.equals("fehér")) {
					white = true;
				}
				if (clothes.getColor()
						.equals("szines")) {
					colorful = true;
				}
			}
			if (dresses.isEmpty()) {
				System.out.println("A mosógép üresen nem indítható.");
			}
			if (dirtySum > 800) {
				System.out.println("A program túl koszos ruhákkal nem indítható.");
			} else if (dirtySum < 50) {
				System.out.println("A betöltött ruhák tiszták, a mosógép indítása nem indokolt.");
			} else if (white == colorful) {
				System.out.println("A mosógép vegyes ruhákkal nem indítható.");
			} else {
				return "OK";
			}
		}
		return "Hiba";
	}

	public String startWash() {
		if (check().equals("OK")) {
			state = State.PROGRESS;
			do {
				dirtySum = 0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (Clothes clothes : dresses) {
					clothes.clean();
					dirtySum += clothes.getDirty();
				}
			} while (dirtySum > 30);
			state = State.OFF;
			System.out.println("A ruhák ennyire koszosak:" + dirtySum);
		}
		return "Error";
	}
}
