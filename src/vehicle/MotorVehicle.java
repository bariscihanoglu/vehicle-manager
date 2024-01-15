package vehicle;
import systemclass.VehicleSys;

public class MotorVehicle extends Vehicle implements Movement {
	private double fuelCapacity;
	private double currentFuel;
	private String transmission;
	public Engine engine;
	
	public MotorVehicle() {
		super();
	}
	
	public MotorVehicle(String modelName, String type, int modelYear, double kilometers, double price,
			boolean isFirstOwner, double fuelCapacity, String transmission, Engine engine) {
		super(modelName, type, modelYear, kilometers, price, isFirstOwner);
		this.fuelCapacity = fuelCapacity;
		this.currentFuel = fuelCapacity;
		this.transmission = transmission;
		this.engine = engine;
	}
	
	public double checkFuel() {
		return currentFuel;
	}
	
	public void addFuel(double fuel) {
		currentFuel += fuel;
		if (currentFuel > fuelCapacity) {
			currentFuel = fuelCapacity;
		}
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		engine.setStatus(true);
	}

	@Override
	public String travels(double km) {
		// TODO Auto-generated method stub
		if(engine.status())
		{
			this.kilometers += km;
			double consumpted = (engine.getConsumption() / 100) * km;
			if(currentFuel <= consumpted)
			{
				return "Fuel is not enough!\nYou need " + String.format("%.2f liters more.", (consumpted - currentFuel));
			}
			currentFuel -= consumpted;
			double cost = consumpted * VehicleSys.GASOLINEPRICE;
			return "Travelled: " + km + " kilometers." +
				"\nConsumpted: " + String.format("%.2f KW", consumpted)  +
				"\nTotal cost of the travel: " + String.format("%.2f TL", cost) +
				"\nFuel: " +  String.format("%%%.2f", currentFuel / fuelCapacity * 100);
		}
		else
		{
			return "Engine is not started!";
		}
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		engine.setStatus(false);
	}
	

	@Override
	public String honk() {
		// TODO Auto-generated method stub
		return "Daaaaat!";
	}

	@Override
	public String toString() {
		return "\nElectric Vehicle" + 
			"\nModel Name     : " + modelName + 
			"\nType                 : " + type +
			"\nModel Year       : " + modelYear +
			"\nKilometers        : " + kilometers +
			"\nPrice                : " + price +
			"\nBrand New       : " + isFirstOwner +
			"\nTransmission   : " + transmission +
			"\nEngine             : " + engine.getName() +
			"\n" +
			"\nCurrent Fuel    : " + currentFuel + " LT" +
			"\nFuel Capacity  : " + fuelCapacity + " LT";
	}
}
