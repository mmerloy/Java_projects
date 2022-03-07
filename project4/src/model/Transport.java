package model;

import java.io.*;


/*
 * Разработать иерархию классов – транспортных средств: мотоцикл, автомобиль,
грузовик, автобус, прицеп. У объектов – ТС имеются следующие свойства:
марка, модель, максимальная допустимая масса перевозимого груза, кол-во
пассажиров, максимальная скорость.
 */
public abstract class Transport implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String mark;
	protected String model;
	protected double maxmas;
	protected int kol;
	protected double maxspeed;
	protected int ID;
	
	public String getMark()			{ return mark; }
	public String getModel()		{ return model; }
	public double getMaxmas() 		{ return maxmas;}
	public int getKol() 			{return kol;}
	public int getID() 			{return ID;}
	public double getMaxspeed() 	{return maxspeed;}
	
	
	public void setMark(String mark) 				{this.mark = mark;}
	public void setModel(String model) 				{this.model = model;}
	public void setMaxmas(double maxmas) 			{this.maxmas = maxmas;}
	public void setKol(int kol)						{this.kol = kol;}
	public void setMaxspeed(double maxspeed) 		{this.maxspeed = maxspeed;}
	public void setID(int ID)						{this.ID = ID;}
	
public Transport(int ID, String mark, String model, double maxmas, int kol, double maxspeed) 
{
	this.ID = ID;
	this.mark = mark;
	this.model = model;
	this.maxmas = maxmas;
	this.kol = kol;
	this.maxspeed = maxspeed;
	
}



/**
 * Метод toString -выводит данные с виде поле = значение
 * @return  возвращает какие свойства имеет каждый транспорт
 */
//переопределим метод toString
public String toString() 
	{
		return  ID + "\t"+ mark + "\t\t" + model + "\t\t" + maxmas + "\t\t\t" + kol + "\t" + maxspeed +"\t\t";
	}


}

