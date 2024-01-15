package vehicle;

public class Engine {
	private int id;
	private static int lastEngineId = 0;
	private String name;
	private double consumption;
	private int horsePower;
	private boolean status = false;
	
	public Engine() {
		lastEngineId++;
		id = lastEngineId;
	}
	
	public Engine(String name, double consumption, int horsePower) {
		this();
		this.name = name;
		this.consumption = consumption;
		this.horsePower = horsePower;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public boolean checkId(int id) {
		return this.id == id ? true : false;
	}

	public boolean status() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", name=" + name + ", consumption=" + consumption
				+ ", horsePower=" + horsePower + "]";
	}
}
