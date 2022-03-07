package view;

import java.util.*;


public class View 
{
	public static final String Error = "Error: ";
	public static final String LoginError = "Login Error: ";
	 
	/**
	 * ����� print - ������� �� ���������� ������ �������� �������� ��� ������
	 * @param message �������� ���� ��� ����������� �������� �������� ��� ������ ��� ������
	 */

	
	public static void print(String message)
	{
	    System.out.println( message +"\n");
	}
	
//---------------------------------------------------------------------------------
	/**
	 * printError - ������� �� ���������� ������ ��������� �� ������
	 * @param message �������� ���� ��� ����������� �������� �������� ��� ������ ��� ������
	 */

	public static void printError(String message)
	{
        print(Error + message);
    }
//----------------------------------------------------------------------------------
	/**
	 * userMenu()- ������� ���� ������������, ����� ������� ����� � ������ ������������
	 */

	public static void userMenu()
	{
		System.out.println("-------���� ������������-------\n");
	    System.out.println("1 - ���������������� ���� ������ \n");
	    System.out.println("2 - ��������� ���� ������ � ����� \n");
	    System.out.println("3 - �������� ���� ������ � ���� \n");
	    System.out.println("4 - �������� ������� � ���� ������ \n ");
	    System.out.println("5 - ������� ������� �� ���� ������(�� ID) \n");
	    System.out.println("6 - �������� ������� � ���� ������(�� ID) \n");
	    System.out.println("7 - ������� ���� ������ �� �����.\n ");
	    System.out.println("8 - ����� \n");
	    System.out.println("\n-------------------------------\n");
	}
//----------------------------------------------------------------------------------
	/**
	 * rootMenu()- ����� ���� ������������
	 */

	public static void rootMenu()
	{
		System.out.println("-------���� ������������-------\n");
	    System.out.println("1 - ���������������� ���� ������ \n");
	    System.out.println("2 - ��������� ���� ������ � ����� \n");
	    System.out.println("3 - �������� ���� ������ � ���� \n");
	    System.out.println("4 - �������� ������� � ���� ������ \n ");
	    System.out.println("5 - ������� ������� �� ���� ������(�� ID) \n");
	    System.out.println("6 - �������� ������� � ���� ������(�� ID) \n");
	    System.out.println("7 - ������� ���� ������ �� �����.\n ");
	    System.out.println("8 - ����� \n");
	    System.out.println("9 - ����� ������ \n");
	    System.out.println("10 - ����� ���������� \n");
	    System.out.println("\n-------------------------------\n");
	}


//--------------------------------Login View --------------------------------------------------------

	 	/**
		 * displayGreeting- ����������� ��� ������������  ��� ������������
		 *@param userName- ��� ������������ �� ����� ��������
		 *@param role - ������ ������������( ����������� ��� ������� ������������)
		 */ 
	    public static void displayGreeting(String userName, String role) 
	    {
	        print("Hello, " + userName + "\t(" + role + ')');
	    }
	    
//------------------------------------------------------------------------------------------------------
	    /**
		 * getPassword() - ��������� ��������� ������
		 * getLogin() - ��������� ��������� ����� 
		 */  
	    public static String getPassword() 
	    {
	        print("������� ������:");
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
	      
	    }
	    public static String getLogin() 
	    {
	        print("������� �����: ");
	        @SuppressWarnings("resource")
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
			
	    }
//------------------------------------------------------------------------------------------------------
	    /**
		 * printLoginError - ������� �� ���������� ������ ��������� �� ������ ��� ����� ������
		 * @param message �������� ���� ��� ����������� �������� �������� ��� ������ ��� ������
		 */    
	    public static void printLoginError(String message)
	    {
	        print(LoginError + message);
	    }
	 
}
