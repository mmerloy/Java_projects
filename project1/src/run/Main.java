package run;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
*
* @author mmerloy
* @version 0.0.2
* 
*/
public class Main 
{
	/**
	 * 
	* C ������ main ���������� ���������� ���������
	* @param args ��������� ��������� �����
	* @exception InputMismatchException ������������� �������� ������� ������.������������ �� ������ ��������� ��������� ��������� ��������, ����� �����.
	*/
	 static void view(String key)
	 {
	        System.out.println(key);
	 }
	 
	 static void model()
	 {
		 double a = 0 , b=0, c=0, D = 0;
		 
		 try
			{
				view("������� ����������� � =" );
				a = controller();
				view("������� ����������� b =" );
				b = controller();
				view("������� ����������� � =" );
				c = controller();
				
				D = b*b - 4*a*c;
				if (D == 0)
					view("������ ��������� = " + (-b/(2*a)));
				
				if (D < 0)
					view("������� �� ����� �������������� ������");
				
				if (D > 0)
				{
					view("������ ������ ��������� = " + ((-b + Math.sqrt(D))/(2*a)));
					view("������ ������ ��������� = " + ((-b - Math.sqrt(D))/(2*a)));
				}			
			}
			catch(InputMismatchException ex)
			{
			    view("Sorry, try entering another value\n");
			}
			
			view("��������� ��������� ���� ������\n");
			//in.close();
		}

	 
	static double controller()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		return in.nextDouble();
	}


public static void main(String[] args) 
{
	Main.model();
}

}