package model;

import java.io.*;

//прицеп
public class Trailer extends Transport implements Serializable
{
	private static final long serialVersionUID = 1L;

	// вызываем конструктор родительского класса
	public Trailer(int ID, String mark, String model, double maxmas, int kol, double maxspeed, double mastrailer, double heightload)
	{
		super(ID, mark, model, maxmas, kol, maxspeed);
		this.mastrailer = mastrailer;
		this.heightload = heightload;
	} 
	
	public Trailer() 
	{
		super(1, "-1", "-1", 0, 1, 1);
		this.mastrailer = 0;
		this.heightload = 0;
	}

	protected double mastrailer;
	protected double heightload;//высота груза
	
	public double GetMastrailer()	{ return mastrailer;}
	public double GetHeightload()	{ return heightload;}
	
	public void SetMastrailer(double mastrailer)	{this.mastrailer = mastrailer;}
	public void SetHeightload(double heightload)	{this.heightload = heightload;}

	 /**
     * Метод toString -выводит данные с виде поле = значение
     * @return  возвращает какие свойства имеет трейлер
     */
public String toString() 
	{
		//вызываем реализацию родительского класса
	return "Класс трейлер имеет следующие свойства \n\n" +
	"Марка"+ "\t\t" + "Модель" + "\t\t" +"МаксМасса"+ "\t" + "Количество"+ "\t" + "МаксСкорость"
	+ "\t"+ "МассаТрейлера" + "\t" + "ВысотаГруза\n"  +super.toString() + "\t" + mastrailer + "\t" + heightload + "\n" ;
	}

}

