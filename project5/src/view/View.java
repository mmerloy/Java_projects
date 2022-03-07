package view;

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
//--------------------------------------------------------------------------------
	/**
	 * rootMenu()- ����� ���� ������������
	 */

	public static  void Menu()
	{
		
	    System.out.println("0 - ���������� ��������� \n");
	    System.out.println("1 - ������ ���������� ���������(������� �����) \n");
	    System.out.println("2 - ������ �������� ���������(������� �����) \n");
	    System.out.println("3 - ������ ���������� ���������(����� �����) \n");
	    System.out.println("4 - ������ �������� ���������(����� �����) \n");
	    System.out.println("\n-------------------------------\n");
	}

}


