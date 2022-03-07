package model;

import java.io.*;
import java.util.*;
import view.View;

public class ContainerTransport implements Serializable 
{
	String fileName = "file.bin";
	public List<Transport> transports = new ArrayList<Transport>();
	
	static View view = new View();
	private static final long serialVersionUID = 1L;
	public static final String PATH_TO_FILE1 = "H://8191102//java//project3//src//";

	/**
	 * 
	 */

	public void defaultInit() 
	{
		Automobil auto1 = new Automobil(0, "марка1", "модель1", 44.7, 5, 90.5, null, true);
		Automobil auto2 = new Automobil(1, "марка2", "модель2", 34.7, 7, 70.5, null, false);
		Automobil auto3 = new Automobil(2, "марка3", "модель3", 24.7, 3, 60.5, null, true);
		Automobil auto4 = new Automobil(3, "марка4", "модель4", 44.7, 5, 90.5, null, false);

		Bus bus1 = new Bus(4, "марка1", "модель1", 30.3, 3, 50, 4, 4.5);
		Bus bus2 = new Bus(5, "марка2", "модель2", 26.3, 6, 40, 4, 2.5);
		Bus bus3 = new Bus(6, "марка3", "модель3", 36.3, 4, 90, 2, 5.5);
		Bus bus4 = new Bus(7, "марка4", "модель4", 46.3, 2, 35, 3, 8.5);
		Bus bus5 = new Bus(8, "марка5", "модель5", 56.3, 3, 40, 4, 4.5);

		Trailer tr1 = new Trailer(9, "марка3", "модель3", 66.3, 3, 40, 34.5, 34.5);
		Trailer tr2 = new Trailer(10, "марка3", "модель3", 66.3, 3, 40, 34.5, 34.5);
		Trailer tr3 = new Trailer(11, "марка3", "модель3", 1066.3, 3, 40, 34.5, 34.5);

		Truck truck1 = new Truck(12, "марка4", "модель4", 66.3, 3, 40, null, 4, 34.5, 20.5);
		Truck truck2 = new Truck(13, "марка4", "модель4", 36.3, 5, 50, null, 4, 34.5, 34.5);
		Truck truck3 = new Truck(14, "марка4", "модель4", 46.3, 3, 60, null, 3, 20.5, 34.5);
		
		Motorcycle moto1 = new Motorcycle(15, "марка5", "модель5", 44.7, 5, 90.5, false, "scooter");
		Motorcycle moto2 = new Motorcycle(16, "марка5", "модель5", 20.7, 5, 70.5, true, "bike");// scooter, bike, samokat
		Motorcycle moto3 = new Motorcycle(17, "марка5", "модель5", 34.7, 5, 50.5, false, "samokat");

		transports.add(auto1);
		transports.add(auto2);
		transports.add(auto3);
		transports.add(auto4);

		transports.add(bus1);
		transports.add(bus2);
		transports.add(bus3);
		transports.add(bus4);
		transports.add(bus5);

		transports.add(tr1);
		transports.add(tr2);
		transports.add(tr3);

		transports.add(truck1);
		transports.add(truck2);
		transports.add(truck3);

		transports.add(moto1);
		transports.add(moto2);
		transports.add(moto3);
	}

//---------------------from File-----------------------
	/**
	 * fromFile чтение базы данных из файла
	 * 
	 * @param fileName - название файла из которого читаем
	 * @param PATH_TO_FILE1-правильный путь до места , где лежит файл
	 */

	public void fromFile(String fileName) 
	{

		try 
		{
			FileOutputStream fos = new FileOutputStream(new File(PATH_TO_FILE1 + fileName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this.transports);
			System.out.println("”спешное чтение из файла");
			oos.close();
			fos.close();
		} catch (IOException exc) 
		{
			View.print(exc.getMessage());

		}
	}

//---------------------to File-------------------------------
	/**
	 * toFile загрузка базы данных в файл
	 * 
	 * @param fileName- название файла в который записываем
	 * @param PATH_TO_FILE1-правильный путь до места , где лежит файл
	 */
	@SuppressWarnings("unchecked")
	public void toFile(String fileName) 
	{
		this.transports = new ArrayList<Transport>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PATH_TO_FILE1 + fileName));
			ObjectInputStream ois = new ObjectInputStream(fis);

			transports = (List<Transport>) ois.readObject();
			System.out.println("”спешна€ запись в файл");
			fis.close();
			ois.close();
		}

		catch (IOException | ClassNotFoundException exc) 
		{
			View.print(exc.getMessage());

		}
	}

//---------------print Base-----------------------------
	/**
	 * printBase вывод базы данных на экран
	 */
	public void printBase() 
	{
		for (Transport transport : this.transports) 
		{
			View.print(transport.toString() + "\r\n");
		}

	}
//----------------------Base Remove------------------------------------	

	/**
	 * BaseRemove удаление элемента из базы данных
	 * 
	 * @param mark - марка машины , которую нужно удалить
	 */
	public void baseRemove(int ID) 
	{

		int idx = -1;// индекс под которым расположен элемент
		boolean isRemoved = false;
		for (Transport transport : transports) 
		{
			if (transport.getID() == ID) 
			{
				idx = transports.indexOf(transport);
				isRemoved = true;
				
			}
			
		}
		if (isRemoved)
			transports.remove(idx);
		else
			View.print("“акой марки нет. Ёлемент не удален. ");
	}

//--------------------Base Add-------------------------------------
	/**
	 * BaseAdd добавление элемента в базу данных
	 * 
	 * @param transport
	 */
	public void baseAdd(Transport transport) 
	{
		transports.add(transport);
		System.out.println("јвтомобиль добавлен  в базу данных : "+ transport.toString());
		
		System.out.println(" transports.size() :" + transports.size());
	}
	

//---------------------Base Change-------------------------------------------------
	/**
	 * BaseChange изменение элемента в базе данных
	 * 
	 * @param mark - марка машины , которую нужно изменить
	 * 
	 */
	public void baseChange(int ID) 
	{
		int idx = -1;
		for (Transport transport : transports) 
		{
			if (transport.getID() == ID)
				idx = transports.indexOf(transport);
		}

		Scanner ln = new Scanner(System.in);
		String model = "",mark = "";
		int kol = 0;
		double maxmas = 0, maxspeed = 0;
		
		
		View.print("¬ведите марку: ");
		mark = ln.nextLine();
		View.print("¬ведите модель: ");
		model = ln.nextLine();
		View.print("¬ведите количество пассажиров: ");
		kol = Integer.parseInt((ln.nextLine()));
		View.print("¬ведите  максимальную скороть: ");
		maxspeed = Double.parseDouble((ln.nextLine()));
		View.print("¬ведите максимальную массу: ");
		maxmas = Double.parseDouble((ln.nextLine()));

		if (transports.get(idx) instanceof TransportTrailer)
		{
			Trailer trailerR = new Trailer();

			if (transports.get(idx) instanceof Automobil) 
			{
				boolean insurance;
				View.print("”кажите наличие страховки(false-отсутствие, true-наличие): ");
				insurance = Boolean.parseBoolean((ln.nextLine()));

				Automobil auto = new Automobil(idx, mark, model, maxmas, kol, maxspeed, trailerR,
						insurance);
				transports.set(idx, auto);
			}
			if (transports.get(idx) instanceof Truck)
			{
				int kolwheels;
				double heightload, lengthload;
				View.print("”кажите количество колес: ");
				kolwheels = Integer.parseInt((ln.nextLine()));
				View.print("”кажите вес груза: ");
				heightload = Double.parseDouble((ln.nextLine()));
				View.print("”кажите высоту груза: ");
				lengthload = Double.parseDouble((ln.nextLine()));

				Truck truck = new Truck(idx, mark, model, maxmas, kol, maxspeed, trailerR,
						kolwheels, heightload, lengthload);
				transports.set(idx, truck);
			}

			if (transports.get(idx) instanceof Transport) 
			{
				if (transports.get(idx) instanceof Trailer) 
				{
					double heightload, mastrailer; 
					View.print("”кажите вес груза: ");
					heightload = Double.parseDouble((ln.nextLine()));
					View.print("”кажите высоту груза: ");
					mastrailer = Double.parseDouble((ln.nextLine()));

					Trailer trailer = new Trailer(idx, mark, model, maxmas, kol, maxspeed,
							mastrailer, heightload);
					transports.set(idx, trailer);
				}
				if (transports.get(idx) instanceof Bus) 
				{
					double height;
					int kolfloor;
					View.print("”кажите вес груза: ");
					height = Double.parseDouble((ln.nextLine()));
					View.print("”кажите количество этажей: ");
					kolfloor = Integer.parseInt((ln.nextLine()));

					Bus bus = new Bus(idx, mark, model, maxmas, kol, maxspeed, kolfloor, height);
					transports.set(idx, bus);
				}
				if (transports.get(idx) instanceof Motorcycle) 
				{
					boolean carriage;
					String type = "";
					View.print("”кажите наличие кол€ски(false-отсутствие, true-наличие): ");
					carriage = Boolean.parseBoolean((ln.nextLine()));
					View.print("”кажите тип мотоцикла( scooter, bike, samokat): ");
					type = ln.nextLine();

					Motorcycle moto = new Motorcycle(idx, mark, model, maxmas, kol, maxspeed,
							carriage, type);
					transports.set(idx, moto);
				}
			}

			ln.close();
		}
	}

}
