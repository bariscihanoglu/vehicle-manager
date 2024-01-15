package vehicle;
import systemclass.VehicleSys;

public class ElectricVehicle extends Vehicle implements Movement {
	private boolean regenerativeBraking;
	private double charge;
	public Engine engine;
	public Battery battery;
	
	public ElectricVehicle() {
		super();
	}
	
	public ElectricVehicle(String modelName, String type, int modelYear, double kilometers, double price,
			boolean isFirstOwner, boolean regenerativeBraking, Engine engine, Battery battery) {
		super(modelName, type, modelYear, kilometers, price, isFirstOwner);
		this.charge = battery.getBatteryCapacity();
		this.regenerativeBraking = regenerativeBraking;
		this.engine = engine;
		this.battery = battery;
	}
	
	public double getCharge() {
		return charge;
	}

	public void charge(double charge) {
		this.charge += charge;
	}

	public boolean isRegenerativeBraking() {
		return regenerativeBraking;
	}

	public void setRegenerativeBraking(boolean regenerativeBraking) {
		this.regenerativeBraking = regenerativeBraking;
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
			if(charge - consumpted <= 0)
			{
				return "Charge is not enough!\nYou need " + String.format("%.2f KWH more.", (consumpted - charge));
			}
			this.charge -= consumpted;
			double cost = consumpted * VehicleSys.ELECTRICPRICE;
			return "Travelled: " + km + " kilometers." +
					"\nConsumpted: " + String.format("%.2f KW", consumpted)  +
					"\nTotal cost of the travel: " + String.format("%.2f TL", cost) +
					"\nCharge: " +  String.format("%%%.2f", charge / battery.getBatteryCapacity() * 100);
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
		return "Beeeeep!";
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
				"\nRegen. Brakes : " + regenerativeBraking +
				"\nEngine             : " + engine.getName() +
				"\nBattery             : " + battery.getName() +
				"\n" +
				"\nCharge            : " + charge + " KWH" +
				"\nCapacity          : " + battery.getBatteryCapacity() + " KWH";
	}
}
