package hu.ak_akademia.digitalclock;

public class DigitalClock {
	private int hours;
	private int minutes;
	private int seconds;

	public DigitalClock(int hour, int minute, int second) {
		if (hour > -1 || hour < 24) {
			this.hours = hour;
		}
		if (minute > -1 || minute < 60) {
			this.minutes = minute;
		}
		if (second > -1 || second < 60) {
			this.seconds = second;
		}
	}

	public void tickSecond() {
		seconds = seconds + 1;
		secondChange();
	}

	private void secondChange() {
		if (seconds >= 60) {
			minutes++;
			seconds = 0;
		}
		minuteChange();
	}

	private void hourChange() {
		if (hours >= 24) {
			hours = 0;
		}
	}

	private void minuteChange() {
		if (minutes >= 60) {
			hours++;
			minutes = 0;
		}
		hourChange();
	}

	public void backwardTickSecond() {
		seconds = seconds - 1;
		backSecondChange();
	}

	private void backSecondChange() {
		if (seconds < 0) {
			minutes--;
			seconds = 59;
		}
		backMinuteChange();
	}

	private void backHourChange() {
		if (hours < 0) {
			hours = 23;
		}
	}

	private void backMinuteChange() {
		if (minutes < 0) {
			hours--;
			minutes = 59;
		}
		backHourChange();
	}

	public void tickMinute() {
		minutes = minutes + 1;
		minuteChange();
		hourChange();
	}

	public void backwardTickMinute() {
		minutes = minutes - 1;
		backMinuteChange();
		backHourChange();
	}

	public void tickHour() {
		hours = hours + 1;
		hourChange();
	}

	public void backwardTickHour() {
		hours = hours - 1;
		backHourChange();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The time is -> ");
		builder.append(String.format("%02d", hours));
		builder.append(":");
		builder.append(String.format("%02d", minutes));
		builder.append(":");
		builder.append(String.format("%02d", seconds));
		return builder.toString();
	}

}