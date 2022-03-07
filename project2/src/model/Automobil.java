package model;

public class Automobil extends TransportTrailer
{
	// вызываем конструктор родительского класса
	public Automobil(String mark, String model, double maxmas, int kol, double maxspeed, Trailer trailer)
	{
		super(mark, model, maxmas, kol, maxspeed, trailer);
	}
	
	protected boolean insurance;//страховка
	
	public boolean GetInsurance()				{ return insurance;}
	
	public void SetInsurance(boolean insurance)	{this.insurance = insurance;}

	   /**
     * Метод toString -выводит данные с виде поле = значение
     * @return  возвращает какие свойства имеет автомобиль
     */

public String toString() 
	{
		//вызываем реализацию родительского класса
	return "Класс автомобиль имеет следующие свойства\n\n "+
				"Марка"+ "\t\t" + "Модель" + "\t\t" +"МаксМасса"+ "\t" + "Количество"+ "\t" + "МаксСкорость"
				+ "\t" +"||\tТрейлер"+ "\t\t||" + "\tСтраховка"+ "\t" + "\n" +super.toString() + "\t" + insurance + "\n";
	}
}
