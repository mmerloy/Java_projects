
package run;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame  extends JFrame
{
    
	private static final long serialVersionUID = 1L;
	public int W = 850;
    public int H = 510;
    public int width;
    public int height;
    //public boolean isFinished = false;
    public Color[] color = new Color[] {Color.CYAN,Color.BLUE,Color.GREEN,Color.RED};//массив цветов
    public JButton[] cars = new JButton[4];
    public Car[] mashinki = new Car[4];
    public JLabel label  = new JLabel("");
    public Container panel;
    boolean first = true;
    JButton restartBtn = new JButton("Restart");
    JButton startBtn = new JButton("Start");
    public Object obj = new Object();

    public SimpleFrame()
    {
        panel = this.getContentPane();
        panel.setLayout(null);
        label.setBounds(W/2-120, 20, 300, 60);
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        panel.add(label);
        for(int i = 0; i < cars.length; ++i)
        {
            cars[i] = new JButton(""+(i+1));
            cars[i].setBackground(color[i]);
            cars[i].setBounds(20, 40*2*i+80, 120, 60);
            cars[i].setEnabled(false);
            panel.add(cars[i]);
        }
        for(int i = 0; i < mashinki.length; ++i)
        {
            mashinki[i] = new Car(this,cars[i]);
        }
        
        
        startBtn.setBounds(50, 400, 100, 40);
        panel.add(startBtn);
        startBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		startRace();
        	}    	
        });
        
        
        restartBtn.setBounds(250, 400, 100, 40);
        restartBtn.setEnabled(false);
        panel.add(restartBtn);
        restartBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		restartRace();
        	}
        	
        });
        
        setContentPane(panel);
        setSize(W,H);
        setResizable(false);
    }
    public synchronized boolean moveButton(int speed, JButton car)
    {
    	startBtn.setEnabled(false);
        car.setBounds(car.getX() + speed, car.getY(), car.getSize().width, car.getSize().height);
        if((car.getX()+car.getSize().width) >= W)
            {
            	if (first) 
            	{
	                getContentPane().setBackground((car.getBackground()));
	                label.setText("Выиграла "+ car.getText() + " машинка");
	                first = false;
	                restartBtn.setEnabled(true);
                }
 
            return true;
            }
        return false;
    }
    
    public void startRace()
    {
    	for(int i = 0; i < mashinki.length; ++i)
        {
            mashinki[i].start();
        }   	   	
    }
    
    public void restartRace()
    {	
    	restartBtn.setEnabled(false);
    	startBtn.setEnabled(true);
    	for(int i = 0; i < cars.length; ++i)
        {
            //cars[i] = new JButton(""+(i+1));
            //cars[i].setBackground(color[i]);
            cars[i].setBounds(20, 40*2*i+80, 120, 60);
        }
    	getContentPane().setBackground(null);
    	label.setText("");
    	first = true;
    	for(int i = 0; i < mashinki.length; ++i)
        {
            mashinki[i] = new Car(this,cars[i]);
        }
    	
    }

}
