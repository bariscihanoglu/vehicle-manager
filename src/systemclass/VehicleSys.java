package systemclass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import vehicle.Battery;
import vehicle.ElectricVehicle;
import vehicle.Engine;
import vehicle.MotorVehicle;
import vehicle.Vehicle;

public final class VehicleSys {
	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static ArrayList<Engine> engines = new ArrayList<Engine>();
	private static ArrayList<Battery> batteries = new ArrayList<Battery>();
	public static final double GASOLINEPRICE = 28.6;
	public static final double ELECTRICPRICE = 2.22;
	
	public static void readFromFile() {
		File file = new File("engines.txt");
		String line;
		String parameters[];
		
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				parameters = line.split("%");
				engines.add(new Engine(parameters[0], Double.parseDouble(parameters[1]), Integer.parseInt(parameters[2])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File 'engines.txt' not found!");
			e.printStackTrace();
		}
		
		file = new File("batteries.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				parameters = line.split("%");
				batteries.add(new Battery(parameters[0], Double.parseDouble(parameters[1]), Double.parseDouble(parameters[2])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file = new File("vehicles.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				parameters = line.split("%");
				if(parameters[0].equals("Electric"))
				{
					boolean isFirst = parameters[6].equals("true") ? true : false;
					boolean regenBreak = parameters[7].equals("true") ? true : false;
					vehicles.add(
						new ElectricVehicle(parameters[1], parameters[2], Integer.parseInt(parameters[3]),
							Double.parseDouble(parameters[4]), Double.parseDouble(parameters[5]), isFirst,
							regenBreak, searchEngine(Integer.parseInt(parameters[8])), 
							searchBattery(Integer.parseInt(parameters[9])
							)
						)
					);
				}
				else if (parameters[0].equals("Motor"))
				{
					boolean isFirst = parameters[6].equals("true") ? true : false;
					vehicles.add(
						new MotorVehicle(parameters[1], parameters[2], Integer.parseInt(parameters[3]),
							Double.parseDouble(parameters[4]), Double.parseDouble(parameters[5]), isFirst,
							Double.parseDouble(parameters[7]), parameters[8], searchEngine(Integer.parseInt(parameters[9])
							)
						)
					);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public static Vehicle searchVehicle(int id) {
		if(id > vehicles.size())
			return null;
		return vehicles.get(id - 1);
	}
	
	public static String displayVehicle(int id)
	{
		Vehicle selectedVehicle = vehicles.get(id - 1);
		if(selectedVehicle instanceof MotorVehicle)
			return ((MotorVehicle)selectedVehicle).toString();
		else
			return ((ElectricVehicle)selectedVehicle).toString();
	}
	
	public static String[] getVehicleNames()
	{
		String[] result = new String[vehicles.size()];
		for(int i = 0; i < vehicles.size(); i++) {
			result[i] = vehicles.get(i).getModelName();
		}
		return result;
	}
	
	public static Engine searchEngine(int id) {
		return engines.get(id - 1);
	}
	
	public static String[] getEngineNames()
	{
		String[] result = new String[engines.size()];
		for(int i = 0; i < engines.size(); i++) {
			result[i] = engines.get(i).getName();
		}
		return result;
	}
	
	public static Battery searchBattery(int id) {
		return batteries.get(id - 1);
	}
	
	public static String[] getBatteryNames()
	{
		String[] result = new String[batteries.size()];
		for(int i = 0; i < batteries.size(); i++) {
			result[i] = batteries.get(i).getName();
		}
		return result;
	}
}
