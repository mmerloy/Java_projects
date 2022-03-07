package model;

import java.io.*;

public abstract class TransportTrailer extends Transport implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Trailer trailer;

	public TransportTrailer(int ID, String mark, String model, double maxmas, int kol, double maxspeed,Trailer trailer)
	{
		super(ID, mark, model, maxmas, kol, maxspeed);
		this.trailer = trailer;
		
	}
	
	 /**
     * Метод GetMaxspeed() -выводит данные с виде поле = значение
     * @return  максимальную разрешенную скорость  ,которая у ТС с прицепом на 20км/ч чем без него
     */
	public double GetMaxspeed() 	
	{
		double result = maxspeed;
		if (trailer != null)
			result -= 20;

		return result;
	}
	
	 /**
     * Метод GetControlMas() -выводит данные с виде поле = значение 
     * @return  возвращает измененную массу , которая состоит из суммы значений буксирующего ТС и прицепа.
     */
	public double GetControlMas() 		
	{ 
		double  result = maxmas;
		if (trailer != null) 
			result += trailer.mastrailer;
		return result;
	}
	//----------------------------------------------------------------
	
	 /**
     * Метод toString -выводит данные с виде поле = значение
     * @return  возвращает какие свойства имеет транспорт с трейлером
     */
	public String toString() 
	{
		return super.toString() + "\t" + this.GetMaxspeed() + "\t" + GetControlMas() + "\t";
	}
}

