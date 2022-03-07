package controller;

import view.View;

import model.ContainerTransport;
import model.Motorcycle;
import model.Trailer;
import model.Truck;
import model.Automobil;
import model.Bus;
import model.Check;

import java.io.*;
import java.util.*;
import java.util.logging.*;



/**
 * @author mmerloy
 * @version 0.0.7
 * @since 16.11.2021 1:30
 * 
 */
public class Controller 
{
	
	public static final String PATH_TO_FILE = "H://8191102//java//project3//src//";

	
	public static void scenario() throws IOException 
	    {
		Logger logger = Logger.getLogger("project3"); 
		FileHandler handler; 
		ContainerTransport container = new ContainerTransport();
		boolean debug;
		boolean autotest;
	        try 
	        {   
	            boolean append = false;
	            handler = new FileHandler(PATH_TO_FILE + "MyLogFile.log", append);  
	            logger.addHandler(handler);
	            SimpleFormatter formatter = new SimpleFormatter();  
	            handler.setFormatter(formatter);  
	        } 
	        catch (SecurityException | IOException e)
	        {  
	            e.getMessage();  
	        }
	        
	        FileInputStream fileInputStream;
	        Properties prop = new Properties();
	        
	        try 
	        {
	            fileInputStream = new FileInputStream(PATH_TO_FILE + "config.properties" );
	            prop.load(fileInputStream);
	 
	            String login = prop.getProperty("Login");
	            String password = prop.getProperty("Password");
	            String userGroup = prop.getProperty("UserGroup");
	            String debugMode = prop.getProperty("DebugMode");
	            String autotestMode = prop.getProperty("AutotestMode");
	            
	          
	            

	            View.print("User: " + login + '\n' + "Password: " + password + '\n' + "UserGroup: " + userGroup + '\n' + "DebugMode: " + debugMode + '\n' + "AutotestMode: " + autotestMode + '\n');
	       
	            
	            if (prop.getProperty("DebugMode").equals("true"))
	            {
	                View.print("\n");
	                logger.info("-------Start of Log-----");
	                View.print("\n");
	                logger.config("Read config file");
	                View.print("\n");
	                logger.log(Level.INFO, "Programm start by user: {0}", login);
	                View.print("\n");
	            }
	        } 
	        catch (IOException e) 
	        {
	            View.print("Ошибка в программе: файл " + PATH_TO_FILE + "config.properties" + " не обнаружено");
	            e.getMessage();
	            
	            if (prop.getProperty("DebugMode").equals("true"))   
	            {
	            	View.print("\n");
	                logger.log(Level.SEVERE, "Exception{0}", e.getMessage());
	                View.print("\n");
	            }
	        }
	        
	    
	        Scanner in = new Scanner(System.in);
	        String login = prop.getProperty("Login");
            String group = prop.getProperty("UserGroup");
            if (logger != null)
            	logger.info("Попытка войти в аккаунт "); 
            int cnt = 3;
            while (cnt-- != 0)
            {
            	login = View.getLogin();
                var password = View.getPassword();
                if (logger != null)
                    logger.info("Попытка #" + (3 - cnt) + " pass: "+ prop.getProperty("Password") + ", login: "+prop.getProperty("Login"));
                if (password.equals(prop.getProperty("Password"))&login.equals(prop.getProperty("Login")))
                	break;
                	
            }
            if (cnt == -1) 
            {
                if (logger != null)
                    logger.info("Неудачный вход. Прекращение действия программы");
                	View.printLoginError("В доступе отказано. Прекращение...");
                System.exit(-3);
            }
            if (logger != null)
                logger.info("Успешный вход в систему");
            View.displayGreeting(login, group);
            
	        do
	        {

		        	if (prop.getProperty("UserGroup").equals ( "root"))
		        		View.rootMenu();	
		        	else if (prop.getProperty("UserGroup").equals ( "user"))
		        		View.userMenu();
	        	
				int case_number;
				
				case_number = Check.intCheck();
				
				
			    debug = prop.getProperty("DebugMode").equals("true");
			    new Automobil(1, "марка2", "модель2", 34.7, 7, 70.5, null, false);
		        new Bus(6, "марка3", "модель3", 36.3, 4, 90, 2, 5.5);
		        
			    autotest = prop.getProperty("AutotestMode").equals("true");
				
	            
	            switch(case_number)
	            {  
	          
	                case 1:
						if (debug)
	                    {
							View.print("\n");
	                        logger.info("Инициализация базы данных из системы");
	                        View.print("\n");
	                    }
						container.defaultInit();
						break;
	                case 2:
						if (!(container.transports.isEmpty())) 
						{
							View.print("Вы точно хотите загрузить новые данные? Предыдущие данные будут потеряны.");
							View.print("1 - нет. 2 - да.");
							
							int ans = Check.intCheck();
							if (ans == 2) 
							{
								if (debug)
			                    {
									View.print("\n");
			                        logger.info("Загрузка базы данных из файла.");
			                        View.print("\n");
			                    }
								View.print("Введите название файла: ");
								String inputFileName = in.nextLine();
								container.fromFile(inputFileName);
								break;
							}
							else
								break;
						}
						else
						{
							if (debug)
		                    {
								View.print("\n");
		                        logger.info("Загрузка базы данных из файла.");
		                        View.print("\n");
		                    }
							View.print("Введите название файла: ");
							String inputFileName = in.nextLine();
							container.fromFile(inputFileName);
							break;
						}
					case 3:
						if (debug)
	                    {
							View.print("\n");
	                        logger.info("Запись данных в файл.");
	                        View.print("\n");
	                    }
						View.print("Введите название файла: ");
						String outputFileName = in.nextLine();
						container.toFile(outputFileName);
						break;
					
					case 4:
						
						View.print("Кого вы хотите добавить в базу данных?");
						View.print("1 - создать объект класса Автомобиль.\r\n ");
						View.print("2 - создать объект класса Автобус.\r\n ");
						View.print("3 - создать объект класса Грузовик.\r\n ");
						View.print("4 - создать объект класса Трейлер.\r\n ");
						View.print("5 - создать объект класса Мотоцикл.\r\n ");
						int caseNum1 = Check.intCheck();
						
						View.print("Сколько объектов данного класса вы хотите добавить?");
						int k = Check.intCheck();
						
						String model = "", mark= "";
						int kol = 0,ID = 0;
						double maxmas = 0, maxspeed = 0;
						
						while ( k-- !=0)
						{
							
							//View.print("Введите ID: ");
							//ID = Integer.parseInt((in.nextLine()));
							View.print("Введите марку: ");
							mark = Check.stringCheck();
							View.print("Введите модель: ");
							model = Check.stringCheck();
							View.print("Введите количество пассажиров: ");
							kol = Check.intCheck();
							View.print("Введите  максимальную скороть: ");
							maxspeed = Check.doubleCheck();
							View.print("Введите максимальную массу: ");
							maxmas = Check.doubleCheck();
						
							switch (caseNum1) 
							{
								case 1: 
									Trailer trailerR = new Trailer();
									if (debug)
									{
										View.print("\n");
										logger.info("Добавление автомобиля в базу данных.");
										View.print("\n");
									}
									boolean insurance;
									View.print("Укажите наличие страховки(false-отсутствие, true-наличие): ");
									insurance = Boolean.parseBoolean((in.nextLine()));
									Automobil auto = new Automobil(ID, mark, model, maxmas, kol, maxspeed, trailerR, insurance); 
							
									container.baseAdd(auto);
									break;
								case 2:
									if (debug)
									{
										View.print("\n");
										logger.info("Добавление автобуса в базу данных.");
										View.print("\n");
									}
									double height;
									int kolfloor;
									
									View.print("Укажите вес груза: ");
									height = Check.doubleCheck();
									View.print("Укажите количество этажей: ");  
									kolfloor = Check.intCheck();
									Bus bus = new Bus(ID, mark, model, maxmas, kol, maxspeed, kolfloor, height);
							
									container.baseAdd(bus);
									break;
								case 3:
									Trailer trailerRR = new Trailer();
									if (debug)
									{
										View.print("\n");
										logger.info("Добавление грузовика в базу данных.");
										View.print("\n");
									}
									int kolwheels;
									double heightload , lengthload;
									View.print("Укажите количество колес: ");
									kolwheels = Check.intCheck();
									View.print("Укажите вес груза: ");
									heightload = Check.doubleCheck();
									View.print("Укажите высоту груза: ");
									lengthload = Check.doubleCheck();
							
									Truck truck = new Truck(ID, mark, model, maxmas, kol, maxspeed, trailerRR,
											kolwheels, heightload, lengthload);
									container.baseAdd(truck);
									break;
								case 4:
									if (debug)
									{
										View.print("\n");
										logger.info("Добавление трейлера в базу данных.");
										View.print("\n");
									}
									double heightload1,mastrailer;
									
									View.print("Укажите вес груза: ");
									heightload1 = Check.doubleCheck();
									View.print("Укажите высоту груза: ");
									mastrailer = Check.doubleCheck();
						
									Trailer trailer = new Trailer(ID, mark, model, maxmas, kol, maxspeed, mastrailer, heightload1);
									container.baseAdd(trailer);
									break;
								case 5:
									if (debug)
									{
										View.print("\n");
										logger.info("Добавление мотоцикла в базу данных.");
										View.print("\n");
									}
									boolean carriage;
									String type = "";
									
									View.print("Укажите наличие коляски(false-отсутствие, true-наличие): ");
									carriage = Boolean.parseBoolean((in.nextLine()));
									View.print("Укажите тип мотоцикла( scooter, bike, samokat): ");
									type = Check.stringCheck();
						
									Motorcycle moto = new Motorcycle(ID, mark, model, maxmas, kol, maxspeed, carriage, type);
									container.baseAdd(moto);
									break;
							}
						}
						break;
						
					case 5:
					{
							View.print("Введите ID транспорта для удаления:");
							ID = Check.intCheck();
							container.baseRemove(ID);
							if (debug)
		                    {
								View.print("\n");
		                        logger.info("Удаление элемента из базы данных. ID = " + ID);
		                        View.print("\n");
		                    }
					}
							break;
						
					case 6:
						View.print("Введите ID транспорта для изменения:");
						ID = Check.intCheck();
						container.baseChange(ID);
						if (debug)
	                    {
							View.print("\n");
	                        logger.info("Изменение элемента в базе данных. ID = " + ID);
	                        View.print("\n");
	                    }
						break;
					
					case 7:
						container.printBase();
						break;
					case 8: 
						in.close();
						if (debug)
	                    {
							View.print("\n");
	                        logger.info("Запись данных в файл.");
	                        View.print("\n");
	                    }
						container.toFile("save.bin");
						System.exit(0);
						break;
					case 9:
					{ 
	                    debug = !debug;
	                    System.out.println("Debug ->" + debug + '\n');
	                    
	                    if (debug)
	                    {
	                        System.out.println('\n');
	                        logger.log(Level.INFO, "DebugMode changed to {0}", debug);
	                        System.out.println('\n');
	                    }
	                    
	                    break;
	                }
					case 10:
					{
	                    autotest = !autotest;
	                    System.out.println("Autotest ->" + debug + '\n');
	                    
	                    if (debug)
	                    {
	                        System.out.println('\n');
	                        logger.info("AutotestMode changed to " + debug);
	                        System.out.println('\n');
	                    } 
	                    
	                    break;
	                }
					default:
						View.print("Введите еще раз. ");
						break;
				}
			
	        } while (true);
	        

	    }	

	/**
	 * main
	 * @param args - аргументы
	 * @throws IOException 
	 */
 public static void main(String[] args) throws IOException
	{	
		scenario();
		
	}
}



