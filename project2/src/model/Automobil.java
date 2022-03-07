package model;

public class Automobil extends TransportTrailer
{
	// �������� ����������� ������������� ������
	public Automobil(String mark, String model, double maxmas, int kol, double maxspeed, Trailer trailer)
	{
		super(mark, model, maxmas, kol, maxspeed, trailer);
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
	return "����� ���������� ����� ��������� ��������\n\n "+
				"�����"+ "\t\t" + "������" + "\t\t" +"���������"+ "\t" + "����������"+ "\t" + "������������"
				+ "\t" +"||\t�������"+ "\t\t||" + "\t���������"+ "\t" + "\n" +super.toString() + "\t" + insurance + "\n";
	}
}
