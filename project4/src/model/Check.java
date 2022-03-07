package model;
import java.util.*;

/**
 *
 * @author mmerloy
 */
public class Check 
{
    
    public static int intCheck()
    {
        int number = 0;
        boolean CorrectValues;
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        
        do
        {
            try 
            {
                CorrectValues = true;
                number = in.nextInt();
            }
            catch (InputMismatchException e)
                {
                    CorrectValues = false;
                    System.out.println("\n��� ������ ���� ����� �����. ���������� ��� ���\n");
                    in.nextLine();
                }
        }
        while (!CorrectValues);
        
        return number;
    }
    
    public static double doubleCheck()
    {
        double number = 0;
        boolean CorrectValues;
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        
        do
        {
            try 
            {
                CorrectValues = true;
                number = in.nextDouble();
            }
            catch (InputMismatchException e)
                {
                    CorrectValues = false;
                    System.out.println("\n��� ������ ���� ����� � ��������� ������. ���������� ��� ���\n");
                    in.nextLine();
                }
        }
        while (!CorrectValues);
        
        return number;
    }
    
    public static String stringCheck()
    {
        String s = "";
        boolean CorrectValues;
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        
        do
        {
            try 
            {
                CorrectValues = true;
                s = in.next();
            }
            catch (InputMismatchException e)
                {
                    CorrectValues = false;
                    System.out.println("\n��� ������ ���� ������. ���������� ��� ���\n");
                    in.nextLine();
                }
        }
        while (!CorrectValues);
        
        return s;
        
    }
}