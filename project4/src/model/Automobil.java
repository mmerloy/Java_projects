package model;

import java.io.*;

public class Automobil extends TransportTrailer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// �������� ����������� ������������� ������
	public Automobil(int ID, String mark, String model, double maxmas, int kol, double maxspeed, Trailer trailer,boolean insurance )
	{
		super(ID, mark, model, maxmas, kol,  maxspeed, trailer);
		this.insurance = insurance;
	}
	
	protected boolean insurance;//���������
	
	public boolean GetInsurance()				{ return insurance;}
	
	public void SetInsurance(boolean insurance)	{this.insurance = insurance;}

	   /**
     * ����� toString -������� ������ � ���� ���� = ��������
     * @return  ���������� ����� �������� ����� ����������
     */

public String toString() 
	{
		//�������� ���������� ������������� ������
	return "���������� \n\n "+
				"ID" + "�����"+ "\t\t" + "������" + "\t\t" +"���������"+ "\t" + "����������"+ "\t" + "������������"
				+ "\t" +"||\t�������"+ "\t\t||" + "\t���������"+ "\t" + "\n" + super.toString() + "\t" + insurance + "\n";
	}
}
