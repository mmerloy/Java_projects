package model;
//автобус
public class Bus extends Transport
{
	// вызываем конструктор родительского класса
	public Bus(String mark, String model, double maxmas, int kol, double maxspeed)
	{
		super(mark, model, maxmas, kol, maxspeed);
	}
	protected int kolfloor;//количество этажей
	protected double height;
	//protected int addmirror;?
	
	public int GetKolfloor()	{ return kolfloor;}
	public double GetHeight()	{ return height;}
	
	public void SetKolfloor(int kolfloor)	{this.kolfloor = kolfloor;}
	public void SetHeight(double height)	{this.height = height;}

	 /**
     * Метод toString -выводит данные с виде поле = значение
     * @return  возвращает какие свойства имеет автобус
     */
public String toString() 
	{
		//вызываем реализацию родительского класса
	return "Класс автобус имеет следующие свойства:\n\n " +
				"Марка" + "\t\t" + "Модель" + "\t\t" + "МаксМасса" + "     \t" + "КолЛюдей"+ "\t" + "МаксСкорость"
				+ "\t\t" + "КолЭтажей"+"\t" + "ВесГруза" + "\t\n" + 
				super.toString() + "\t" + kolfloor + "\t\t" + height + "\n";
	}


}
