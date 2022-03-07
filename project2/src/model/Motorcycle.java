package model;

public class Motorcycle extends Transport
{
	// �������� ����������� ������������� ������
	public Motorcycle(String mark, String model, double maxmas, int kol, double maxspeed, boolean carriage,String type)
	{
		super(mark, model, maxmas, kol, maxspeed);
		this.carriage = carriage;
		this.type = type;
	}
	
	protected boolean carriage;//�������
	protected String type;// scooter, bike, samokat

	public boolean GetCarriage()	{ return carriage;}
	public String GetType()			{ return type;}
	
	public void SetCarriage(boolean carriage)		{ this.carriage = carriage;}
	public void SetType(String type)				{ this.type = type;}
	
	
	 /**
     * ����� toString -������� ������ � ���� ���� = ��������
     * @return  ���������� ����� �������� ����� ��������
     */
public String toString() 
	{
		//�������� ���������� ������������� ������
	return "����� �������� ����� ��������� ��������\n\n"+
	"�����"+ "\t\t" + "������" + "\t\t" +"���������"+ "\t" + "����������"+ "\t" + "������������"
	+ "\t\t"+"�������" +"\t\t" + "���\n"+super.toString() + "\t" + carriage + "\t\t" + type + "\n" ;
	}

}

