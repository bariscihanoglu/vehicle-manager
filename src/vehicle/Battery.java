package vehicle;

public class Battery {
	private int id;
	private static int lastBatteryId = 0;
	private String name;
	private double batteryCapacity;
	private double chargingSpeed;
	
	public Battery() {
		lastBatteryId++;
		id = lastBatteryId;
	}
	
	public Battery(String name, double batteryCapacity, double chargingSpeed) {
		this.name = name;
		this.batteryCapacity = batteryCapacity;
		this.chargingSpeed = chargingSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getChargingSpeed() {
		return chargingSpeed;
	}

	public void setChargingSpeed(int chargingSpeed) {
		this.chargingSpeed = chargingSpeed;
	}
	
	public boolean checkId(int id) {
		return this.id == id ? true : false;
	}
	
}
