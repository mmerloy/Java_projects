package view;

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
//--------------------------------------------------------------------------------
	/**
	 * rootMenu()- вывод меню разработчика
	 */

	public static  void Menu()
	{
		
	    System.out.println("0 - Завершение программы \n");
	    System.out.println("1 - График добавления элементов(среднее время) \n");
	    System.out.println("2 - График удаления элементов(среднее время) \n");
	    System.out.println("3 - График добавления элементов(общее время) \n");
	    System.out.println("4 - График удаления элементов(общее время) \n");
	    System.out.println("\n-------------------------------\n");
	}

}


