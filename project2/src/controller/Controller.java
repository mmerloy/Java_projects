package controller;
import model.Automobil;
import model.Bus;
import model.Motorcycle;
import model.Trailer;
import model.Truck;
import view.View;


/**
 *
 * @author mmerloy
 * @version 0.0.1 
 * @since 5.10.2021 20:09
 * 
 */
public class Controller 
{
	   /**
     * ����� scenario() - ������� ���������� ������ � ������� ��
     * 
     */

public static void scenario()
{
	View v = new View();
	Automobil tr1 = new Automobil("�����1", "������1",44.7, 5, 90.5, null);
	Bus tr2		  = new Bus("�����2", "������2", 66.3, 3, 40);
	Trailer tr3   = new Trailer("�����3", "������3",66.3, 3, 40, 34.5, 34.5);
	Truck tr4	  = new Truck("�����4", "������4",66.3, 3, 40, null, 4, 34.5, 34.5);
	Automobil tr5 = new Automobil("�����1", "������1",44.7, 5, 90.5,tr3);
	Motorcycle tr6= new Motorcycle("�����5", "������5",44.7, 5, 90.5,false,"����");
	
	v.print(tr1.toString());
	v.print(tr2.toString());
	v.print(tr3.toString());
	v.print(tr4.toString());
	v.print(tr5.toString());
	v.print(tr6.toString());
}
	
/**
 * 
 * C ������ main ���������� ���������� ���������
 * 				� �� ��������� ����� scenario
 * 
 * @param args ��������� ��������� �����
 * 
 */

public static void main(String[] args) 
	{
	scenario();
	}

}