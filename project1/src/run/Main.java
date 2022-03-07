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
	* C метода main начинается выполнение программы
	* @param args аргументы командной сроки
	* @exception InputMismatchException предусмотрена проверка входных данных.Пользователь не должен «сломать» программу введением символов, кроме чисел.
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
				view("Введите коэффициент а =" );
				a = controller();
				view("Введите коэффициент b =" );
				b = controller();
				view("Введите коэффициент с =" );
				c = controller();
				
				D = b*b - 4*a*c;
				if (D == 0)
					view("Корень уравнения = " + (-b/(2*a)));
				
				if (D < 0)
					view("Система не имеет действительных корней");
				
				if (D > 0)
				{
					view("Первый корень уравнения = " + ((-b + Math.sqrt(D))/(2*a)));
					view("Второй корень уравнения = " + ((-b - Math.sqrt(D))/(2*a)));
				}			
			}
			catch(InputMismatchException ex)
			{
			    view("Sorry, try entering another value\n");
			}
			
			view("Программа завершила свою работу\n");
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