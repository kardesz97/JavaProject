package hu.ak_akademia.postmodernwashingmachine;

public class Clothes implements Washable {
	private int dirty;
	private String color;
	private String name;
	private int durability;
	private boolean isIroned;
	private boolean isRaunchy;
	private int wet;

	public Clothes(String name, String color, int dirty) {
		this.name = name;
		this.color = color;
		this.dirty = dirty;
		isIroned = false;
		isRaunchy = false;
		this.durability = 100;
		this.wet = 0;
	}

	public void setWet(int wet) {
		this.wet = wet;
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = dirty;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public int getDurability() {
		return durability;
	}

	public boolean isIroned() {
		return isIroned;
	}

	public boolean isRaunchy() {
		return isRaunchy;
	}

	public int getWet() {
		return wet;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	@Override
	public void clean() {
		System.out.println(getName() + " mosása....");
		setDirty(getDirty() - 1);
		setDurability(getDurability() - 1);
		setWet(30);
		System.out.println("A " + getName() + " koszossága " + getDirty() + " értékre csökkent.");
		System.out.println("A " + getName() + " tartóssága " + getDurability() + " értékre csökkent.");
		if (getDurability() <= 0) {
			System.out.println("A " + getName() + " tartóssága " + getDurability() + " értékre csökkent.");
			setDurability(0);
			isRaunchy = true;
			System.out.println("A " + getName() + " elszakadt.");
		}
		if (getDirty() <= 0) {
			setDirty(0);
		}
	}

	@Override
	public void dry() {
		System.out.println(getName() + " szárítása.... " + getWet());
		do {
			setWet(getWet() - 1);
			System.out.println(getName() + " szárítása.... " + getWet());
		} while (getWet() != 0);
		System.out.println("A " + getName() + " teljesen megszáradt.");
	}

	@Override
	public void iron() {
		isIroned = true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Neve: " + getName());
		sb.append(" " + color);
		sb.append(", piszkossága: " + getDirty());
		sb.append(", tartóssága: " + getDurability());
		sb.append(", Nedvessége: " + getWet());
		sb.append(isRaunchy ? " elszakadt " : "");
		sb.append(isIroned ? " vasalt \n" : " vasalatlan \n");
		return sb.toString();
	}
}
