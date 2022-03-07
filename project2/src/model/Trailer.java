package model;
//������
public class Trailer extends Transport
{
	// �������� ����������� ������������� ������
	public Trailer(String mark, String model, double maxmas, int kol, double maxspeed, double mastrailer, double heightload)
	{
		super(mark, model, maxmas, kol, maxspeed);
		this.mastrailer = mastrailer;
		this.heightload =heightload;
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

