package model;
//грузовик
public class Truck extends TransportTrailer
{
	// вызываем конструктор родительского класса
	public Truck(String mark, String model, double maxmas, int kol, double maxspeed,Trailer trailer,
			int kolwheels,double heightload, double lengthload)
	{
		super(mark, model, maxmas, kol, maxspeed, trailer);
		this.kolwheels = kolwheels;
		this.heightload = heightload;
		this.lengthload = lengthload;
	}
	protected int kolwheels;//количество колес
	protected double heightload;
	protected double lengthload;
	
	public int GetKolwheels()		{ return kolwheels;}
	public double GetHeightload()	{ return heightload;}
	public double GetLengthload()	{ return lengthload;}
	
	public void SetKolwheels(int kolwheels)			{this.kolwheels = kolwheels;}
	public void SetHeightload(double heightload)	{this.heightload = heightload;}
	public void SetLengthload(double lengthload)	{this.lengthload = lengthload;}

public String toString() 
	{
		//вызываем реализацию родительского класса
	return "Класс грузовик имеет следующие свойства\n\n "+
	"Марка"+ "\t\t" + "Модель" + "\t\t" +"МаксМасса"+ "\t" + "Количество"+ "\t" + "МаксСкорость"
	+ "\t"+ "||\tТрейлер\t\t||" + "\t" + "КолКолес" + "\t" + "ВесГруза" + "\t" + "ВысотаГруза\n" +
	super.toString() + "\t" + kolwheels + "\t\t"
			+heightload + "\t\t" + lengthload  + "\n";
	}


}

