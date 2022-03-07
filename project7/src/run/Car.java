package run;

import javax.swing.JButton;
import java.util.*;

public class Car extends Thread
{
    SimpleFrame frame;
    static boolean isFinished;
    public int speed;
    JButton car;
    public Car(SimpleFrame f, JButton c)
    {
        car = c;
        isFinished = false;
        frame = f;
        Random r = new Random();
        speed = 1 + r.nextInt(15);
    }
    public void run()
    {
        try
        {
            while(!isFinished)
            {
                try
                {
                    isFinished = frame.moveButton(speed, car);
                    Thread.sleep(10);
                }
                catch(InterruptedException e)
                {
                    System.out.println("No answer: interrupted");
                }
            }
            isFinished = true;
            Thread.sleep(10);
            if (isFinished)
            	this.join();//���� ����� ������������ ���������� �������� ������
            				//�� ��� ���, ���� ������ ����� �� �������� ���� ����������. 
        }
        catch(InterruptedException e)
        {
            System.out.println("No answer: interrupted");
        }
    }
}
