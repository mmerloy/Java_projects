package model;

import java.io.*;

//�������
public class Bus extends Transport implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// �������� ����������� ������������� ������
	public Bus( int ID, String mark, String model, double maxmas, int kol, double maxspeed, int kolfloor,double height)
	{
		super(ID, mark, model, maxmas, kol, maxspeed);
		this.kolfloor = kolfloor;
		this.height = height;
	}
	protected int kolfloor;//���������� ������
	protected double height;
	//protected int addmirror;?
	
	public int GetKolfloor()	{ return kolfloor;}
	public double GetHeight()	{ return height;}
	
	public void SetKolfloor(int kolfloor)	{this.kolfloor = kolfloor;}
	public void SetHeight(double height)	{this.height = height;}

	 /**
     * ����� toString -������� ������ � ���� ���� = ��������
     * @return  ���������� ����� �������� ����� �������
     */
public String toString() 
	{
		//�������� ���������� ������������� ������
	return "����� ������� ����� ��������� ��������:\n\n " +
				"�����" + "\t\t" + "������" + "\t\t" + "���������" + "     \t" + "��������"+ "\t" + "������������"
				+ "\t\t" + "���������"+"\t" + "��������" + "\t\n" + 
				super.toString() + "\t" + kolfloor + "\t\t" + height + "\n";
	}


}
