package model;
//прицеп
public class Trailer extends Transport
{
	// вызываем конструктор родительского класса
	public Trailer(String mark, String model, double maxmas, int kol, double maxspeed, double mastrailer, double heightload)
	{
		super(mark, model, maxmas, kol, maxspeed);
		this.mastrailer = mastrailer;
		this.heightload =heightload;
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

