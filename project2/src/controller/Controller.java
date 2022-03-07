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
     * ћетод scenario() - создает экземпл€ры класса и выводит их
     * 
     */

public static void scenario()
{
	View v = new View();
	Automobil tr1 = new Automobil("марка1", "модель1",44.7, 5, 90.5, null);
	Bus tr2		  = new Bus("марка2", "модель2", 66.3, 3, 40);
	Trailer tr3   = new Trailer("марка3", "модель3",66.3, 3, 40, 34.5, 34.5);
	Truck tr4	  = new Truck("марка4", "модель4",66.3, 3, 40, null, 4, 34.5, 34.5);
	Automobil tr5 = new Automobil("марка1", "модель1",44.7, 5, 90.5,tr3);
	Motorcycle tr6= new Motorcycle("марка5", "модель5",44.7, 5, 90.5,false,"байк");
	
	v.print(tr1.toString());
	v.print(tr2.toString());
	v.print(tr3.toString());
	v.print(tr4.toString());
	v.print(tr5.toString());
	v.print(tr6.toString());
}
	
/**
 * 
 * C метода main начинаетс€ выполнение программы
 * 				и он запускает метод scenario
 * 
 * @param args аргументы командной сроки
 * 
 */

public static void main(String[] args) 
	{
	scenario();
	}

}