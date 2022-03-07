package view;

import java.util.*;


public class View 
{
	public static final String Error = "Error: ";
	public static final String LoginError = "Login Error: ";
	 
	/**
	 * Метод print - выводит на устройство вывода значение свойства или строку
	 * @param message передаем ключ для отображения значения свойства или строку для печати
	 */

	
	public static void print(String message)
	{
	    System.out.println( message +"\n");
	}
	
//---------------------------------------------------------------------------------
	/**
	 * printError - выводит на устройство вывода сообщение об ошибке
	 * @param message передаем ключ для отображения значения свойства или строку для печати
	 */

	public static void printError(String message)
	{
        print(Error + message);
    }
//----------------------------------------------------------------------------------
	/**
	 * userMenu()- выводит меню пользователя, когда введены логин и пароль пользователя
	 */

	public static void userMenu()
	{
		System.out.println("-------Меню Пользователя-------\n");
	    System.out.println("1 - инициализировать базу данных \n");
	    System.out.println("2 - прочитать базу данных с файла \n");
	    System.out.println("3 - записать базу данных в файл \n");
	    System.out.println("4 - добавить элемент в базу данных \n ");
	    System.out.println("5 - удалить элемент из базы данных(по ID) \n");
	    System.out.println("6 - изменить элемент в базе данных(по ID) \n");
	    System.out.println("7 - вывести базу данных на экран.\n ");
	    System.out.println("8 - Выход \n");
	    System.out.println("\n-------------------------------\n");
	}
//----------------------------------------------------------------------------------
	/**
	 * rootMenu()- вывод меню разработчика
	 */

	public static void rootMenu()
	{
		System.out.println("-------Меню Разработчика-------\n");
	    System.out.println("1 - инициализировать базу данных \n");
	    System.out.println("2 - прочитать базу данных с файла \n");
	    System.out.println("3 - записать базу данных в файл \n");
	    System.out.println("4 - добавить элемент в базу данных \n ");
	    System.out.println("5 - удалить элемент из базы данных(по ID) \n");
	    System.out.println("6 - изменить элемент в базе данных(по ID) \n");
	    System.out.println("7 - вывести базу данных на экран.\n ");
	    System.out.println("8 - Выход \n");
	    System.out.println("9 - Режим дебага \n");
	    System.out.println("10 - Режим автотестов \n");
	    System.out.println("\n-------------------------------\n");
	}


//--------------------------------Login View --------------------------------------------------------

	 	/**
		 * displayGreeting- приветствие для пользователя  или разработчика
		 *@param userName- имя пользователя из файла настроек
		 *@param role - статус пользователя( разработчик или обычный пользователь)
		 */ 
	    public static void displayGreeting(String userName, String role) 
	    {
	        print("Hello, " + userName + "\t(" + role + ')');
	    }
	    
//------------------------------------------------------------------------------------------------------
	    /**
		 * getPassword() - считывает введенный пароль
		 * getLogin() - считывает введенный логин 
		 */  
	    public static String getPassword() 
	    {
	        print("Введите пароль:");
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
	      
	    }
	    public static String getLogin() 
	    {
	        print("Введите логин: ");
	        @SuppressWarnings("resource")
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
			
	    }
//------------------------------------------------------------------------------------------------------
	    /**
		 * printLoginError - выводит на устройство вывода сообщение об ошибке при вводе логина
		 * @param message передаем ключ для отображения значения свойства или строку для печати
		 */    
	    public static void printLoginError(String message)
	    {
	        print(LoginError + message);
	    }
	 
}
