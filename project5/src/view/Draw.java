package view;

import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Field;

@SuppressWarnings("serial")

public class Draw extends JPanel
{
	
	private long[][] myY = new long[2][5] ; //������ ��������
	//public long[][] getMyY;
	//public Draw() {};
	
//	public:���� � ������, ����������� � ������������� public, ����� ������ ������� �� �������� ������ � �� ������� �������.
//	private: �������� ����� ��� ���� ������ �������� ������ �� ���� � ��� �� ������.
//	protected: ����� ����� ��� ���� ������ �������� �� ������ ����� � ������� ������ ��� ������ ��� � ����������� �������, ���� ���� ��� ��������� � ������ �������
//	����������� �� ���������. ����� ���� ��� ������ ����� ���� ������� � ������� ������.
//	���� ����� ������ ��� static � ��� ��������, ��� �� ����� �������������� ��� ������ �� ���������� ������ ������. 
//���� �� ���� ����� �� ��� ����������� � �� ��� ��� ������������� ��� ������������ �� ������ ������� ������.
	
	//��������� - public long[][] getMyY()
    //����������� �������, ��� ������������� ��������, ��� ������(������ ����������) {}
	//����� ��� ��������� �������� ����
	public long[][] getMyY()
	{
		return myY; //���� ������
	}
//����� ������ �� ���������� - �������� ����� void
	//����� ��� ��������� �������� ����
	public void setMyY(long[][] myY)
	{
		this.myY = myY;
	}
	
	
	@Override
    protected void paintComponent(Graphics gh) 
    {

        // ������� ������ g2 ��� ���������� ��������� �� ������� g
        Graphics2D drp = (Graphics2D) gh;
        long max = myY[0][0];
        
        
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 5; j++)
                if (myY[i][j] > max)
                	max = myY[i][j];
        
        long dy = max / 9;
        // max - ������������ �����
        // dy - ��������� ����� ��������

        //�������������� ����� � �����������
        for (int i = 2; i < 11; i++) 
        {
            drp.drawLine(75, 50 + 44 * i, 550, 50 + 44 * i); // ���������� �����
            long vs = max - (i - 2) * dy; // �������� ����� �� y
            drp.drawString(vs + "", 10, 50 + 44 * i); // ��������� ����� �� y
        }
        drp.drawLine(75, 50 + 44 * 11, 550, 50 + 44 * 11);  // ������ ������ �����
        drp.drawString(0 + "", 10, 50 + 44 * 11); // ��������� ����� �� y

        drp.drawString("ArrayList", 100, 40);
        drp.drawString("HashMap", 100, 60);

        drp.drawString("10", 70, 550);// ��������, ���������� �, ���������� �
        drp.drawString("100", 170, 550);
        drp.drawString("1000", 270, 550);
        drp.drawString("10000", 370, 550);
        drp.drawString("100000", 470, 550);

        // ���� ��� ����������� ����� � Array � Hash
        drp.setColor(Color.BLUE);
        drp.fillRect(80, 30, 10, 10);// ��� ��������� ���������������
        drp.setColor(Color.RED);
        drp.fillRect(80, 50, 10, 10);

        for (int i = 0; i < 5; i++) // ��������� �� 10/100/1000...
        { 
            //������ ���� �����������
            //��������� ���� ��� ������� �������1
            Color color = Color.RED;
            for (int j = 0; j < 2; j++) 
            { // ��������� �� ���������� ������
                try 
                {
                    Field field = Class.forName("java.awt.Color").getField(controller.Controller.Main.col[j].toLowerCase()); // �������� �����
                    color = (Color) field.get(null);
                }
                catch (Exception e) { }
                drp.setColor(color);

                //��������� ���������� ������ � �������� ����������
                int realY = (int) (534 - 44 * myY[j][i] / dy); // ��������� ����������
                int realHight = (int) (myY[j][i] * 44 / dy);
                drp.fillRect(75 + 20 * j + 100 * i, realY, 20, realHight);
            }
        }
    }
}