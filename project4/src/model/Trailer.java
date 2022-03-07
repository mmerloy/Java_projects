package model;

import java.io.*;

//������
public class Trailer extends Transport implements Serializable
{
	private static final long serialVersionUID = 1L;

	// �������� ����������� ������������� ������
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
	protected double heightload;//������ �����
	
	public double GetMastrailer()	{ return mastrailer;}
	public double GetHeightload()	{ return heightload;}
	
	public void SetMastrailer(double mastrailer)	{this.mastrailer = mastrailer;}
	public void SetHeightload(double heightload)	{this.heightload = heightload;}

	 /**
     * ����� toString -������� ������ � ���� ���� = ��������
     * @return  ���������� ����� �������� ����� �������
     */
public String toString() 
	{
		//�������� ���������� ������������� ������
	return "����� ������� ����� ��������� �������� \n\n" +
	"�����"+ "\t\t" + "������" + "\t\t" +"���������"+ "\t" + "����������"+ "\t" + "������������"
	+ "\t"+ "�������������" + "\t" + "�����������\n"  +super.toString() + "\t" + mastrailer + "\t" + heightload + "\n" ;
	}

}

