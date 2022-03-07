package model;

import java.io.Serializable;
import java.util.Random;

/**
 * расширение класса транспорт , чтобы можно было добавить рандом
 */
public class TransportExtension extends TransportTrailer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public TransportExtension(int ID, String mark, String model, double maxmas, int kol, double maxspeed,
			Trailer trailer) {
		super(ID, mark, model, maxmas, kol, maxspeed, trailer);
		
	}
	public TransportExtension() 
	{
		super(1, "", "", 1,1,1,null);//заполнить
		
	}


	protected String mark;
	protected String model;
	protected double maxmas;
	protected int kol;
	protected double maxspeed;
	protected int ID;
	
	public String getMark()			{ return mark; }
	public String getModel()		{ return model; }
	public double getMaxmas() 		{ return maxmas;}
	public int getKol() 			{ return kol;}
	public int getID() 				{ return ID;}
	public double getMaxspeed() 	{ return maxspeed;}
	
	
	public void setMark(String mark) 				{this.mark = mark;}
	public void setModel(String model) 				{this.model = model;}
	public void setMaxmas(double maxmas) 			{this.maxmas = maxmas;}
	public void setKol(int kol)						{this.kol = kol;}
	public void setMaxspeed(double maxspeed) 		{this.maxspeed = maxspeed;}
	public void setID(int ID)						{this.ID = ID;}
	
		
		/** method that print car*/
	public String ToString()
		{
	        return  ID + "\t" + mark + "\t" + model + "\t" + maxmas + "\t" + kol + "\t" +maxspeed;
	    }
	

/** constructor that generate random transport 
 * @return */
	public TransportExtension randomTransport()
	{
		Random r = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz";
		//int length = r.nextInt(10) + 1;
		char[] text = new char[10];
		for (int i = 0; i < 10; i++)
			{
				text[i] = characters.charAt(r.nextInt(characters.length()));
			}
		this.mark = new String(text);
		/*this.mark = new String(text);
		this.model = new String(text);
		this.maxspeed = r.nextDouble();
		this.maxmas = r.nextDouble();
		this.kol = r.nextInt(40) + 1;*/
		TransportExtension t = new TransportExtension(ID, mark, model, maxmas, kol, maxspeed, trailer );
		ID++;
		return t;
    }

	
	
	
	
}
