package model;

public class Motorcycle extends Transport
{
	// вызываем конструктор родительского класса
	public Motorcycle(String mark, String model, double maxmas, int kol, double maxspeed, boolean carriage,String type)
	{
		super(mark, model, maxmas, kol, maxspeed);
		this.carriage = carriage;
		this.type = type;
	}
	
	protected boolean carriage;//коляска
	protected String type;// scooter, bike, samokat

	public boolean GetCarriage()	{ return carriage;}
	public String GetType()			{ return type;}
	
	public void SetCarriage(boolean carriage)		{ this.carriage = carriage;}
	public void SetType(String type)				{ this.type = type;}
	
	
	 /**
     * Метод toString -выводит данные с виде поле = значение
     * @return  возвращает какие свойства имеет мотоцикл
     */
public String toString() 
	{
		//вызываем реализацию родительского класса
	return "Класс мотоцикл имеет следующие свойства\n\n"+
	"Марка"+ "\t\t" + "Модель" + "\t\t" +"МаксМасса"+ "\t" + "Количество"+ "\t" + "МаксСкорость"
	+ "\t\t"+"Коляска" +"\t\t" + "Тип\n"+super.toString() + "\t" + carriage + "\t\t" + type + "\n" ;
	}

}

