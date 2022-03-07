package model;
/*
 * ����������� �������� ������� � ������������ �������: ��������, ����������,
��������, �������, ������. � �������� � �� ������� ��������� ��������:
�����, ������, ������������ ���������� ����� ������������ �����, ���-��
����������, ������������ ��������.
 */
public abstract class Transport
{
	protected String mark;
	protected String model;
	protected double maxmas;
	protected int kol;
	protected double maxspeed;
	
	public String GetMark()			{ return mark; }
	public String GetModel()		{ return model; }
	public double GetMaxmas() 		{ return maxmas;}
	public int GetKol() 			{return kol;}
	public double GetMaxspeed() 	{return maxspeed;}
	
	
	public void SetMark(String mark) 				{this.mark = mark;}
	public void SetModel(String model) 				{this.model = model;}
	public void SetMaxmas(double maxmas) 			{this.maxmas = maxmas;}
	public void SetKol(int kol)						{this.kol = kol;}
	public void SetMaxspeed(double maxspeed) 		{this.maxspeed = maxspeed;}

public Transport(String mark, String model, double maxmas, int kol, double maxspeed ) 
{
	this.mark = mark;
	this.model = model;
	this.maxmas = maxmas;
	this.kol = kol;
	this.maxspeed = maxspeed;
}

/**
 * ����� toString -������� ������ � ���� ���� = ��������
 * @return  ���������� ����� �������� ����� ������ ���������
 */
//������������� ����� toString
public String toString() 
	{
		return mark + "\t\t" + model + "\t\t" + maxmas + "\t\t\t" + kol + "\t" + maxspeed + "\t\t";
	}

}

