package model;

import java.io.*;

public class Automobil extends TransportTrailer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// вызываем конструктор родительского класса
	public Automobil(int ID, String mark, String model, double maxmas, int kol, double maxspeed, Trailer trailer,boolean insurance )
	{
		super(ID, mark, model, maxmas, kol,  maxspeed, trailer);
		this.insurance = insurance;
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
	return "Автомобиль \n\n "+
				"ID" + "Марка"+ "\t\t" + "Модель" + "\t\t" +"МаксМасса"+ "\t" + "Количество"+ "\t" + "МаксСкорость"
				+ "\t" +"||\tТрейлер"+ "\t\t||" + "\tСтраховка"+ "\t" + "\n" + super.toString() + "\t" + insurance + "\n";
	}
}
