package vehicle;

public abstract class Vehicle {
	protected int id;
	protected static int lastUsedVehicleId = 0;
	protected String modelName;
	protected String type;
	protected int modelYear;

	protected double kilometers;
	protected double price;
	protected boolean isFirstOwner;
	
	public Vehicle() {
		lastUsedVehicleId++;
		id = lastUsedVehicleId;
	}

	public Vehicle (String modelName, String type, int modelYear, double kilometers, double price, boolean isFirstOwner) {
		this();
		this.modelName = modelName;
		this.type = type;
		this.modelYear = modelYear;
		this.kilometers = kilometers;
		this.price = price;
		this.isFirstOwner = isFirstOwner;
	}
	
	public int getId() {
		return id;
	}

	public String getModelName() {
		return modelName;
	}

	public String getType() {
		return type;
	}

	public int getModelYear() {
		return modelYear;
	}

	public double getKilometers() {
		return kilometers;
	}

	public double getPrice() {
		return price;
	}

	public boolean isFirstOwner() {
		return isFirstOwner;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setFirstOwner(boolean isFirstOwner) {
		this.isFirstOwner = isFirstOwner;
	}
	
	public abstract String honk();
	
	public abstract String toString();
}
