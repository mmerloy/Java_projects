package model;

public abstract class TransportTrailer extends Transport
{
	protected Trailer trailer;

	public TransportTrailer(String mark, String model, double maxmas, int kol, double maxspeed,Trailer trailer)
	{
		super(mark, model, maxmas, kol, maxspeed);
		this.trailer = trailer;
		
	}
	
	 /**
     * ����� GetMaxspeed() -������� ������ � ���� ���� = ��������
     * @return  ������������ ����������� ��������  ,������� � �� � �������� �� 20��/� ��� ��� ����
     */
	public double GetMaxspeed() 	
	{
		double result = maxspeed;
		if (trailer != null)
			result -= 20;

		return result;
	}
	
	 /**
     * ����� GetControlMas() -������� ������ � ���� ���� = �������� 
     * @return  ���������� ���������� ����� , ������� ������� �� ����� �������� ������������ �� � �������.
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
     * ����� toString -������� ������ � ���� ���� = ��������
     * @return  ���������� ����� �������� ����� ��������� � ���������
     */
	public String toString() 
	{
		return super.toString() + "\t" + this.GetMaxspeed() + "\t" +GetControlMas()+"\t";
	}
}

