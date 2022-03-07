package controller;

import model.*;
import view.*;

import java.util.logging.*;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import java.time.LocalTime;

/**
 * @author mmerloy
 * @version 0.1.0
 * @since 30.11.2021 22:50
 * 
 */
public class Controller 
{
	public final static Logger Log = Logger.getLogger(Main.class.getName());
    public static final String PATH_TO_MAIN_DIR = "H://8191102//java//project5//src//";

	@SuppressWarnings("serial")
	 public static class Main extends JFrame
	 {
	     //public static long y[][] = new long[2][5]; //массив значений
	     public static String col[] = {"BLUE", "RED"};//массив цветов
	     Draw draw_y = new Draw();
	        
	     public  Main(String name, boolean add_or_remove,boolean all_or_medium ) 
	     {
	         super(name);
	         
	         if(add_or_remove)//true = add
	         {
	        	 if(all_or_medium)//true = all
	        		 
	        		 draw_y.setMyY(MyCollection.YsAddAll) ;
	        	 	
	        	 else
	        		 draw_y.setMyY(MyCollection.YsAddMedium );
	         }
	         else
	         {
	        	 if(all_or_medium)//true = all
	        		 draw_y.setMyY(MyCollection.YsRemAll);
	        	 else
	        		 draw_y.setMyY(MyCollection.YsRemAll);
	         }
	         //repaint();
	         JPanel jcp = new JPanel();
	         jcp.setLayout(new BorderLayout());
	         setContentPane(jcp);
	         jcp.add(draw_y, BorderLayout.CENTER); // содержимое растягивается по центру, в зависимости от размеров окна
	         jcp.setBackground(Color.gray);
	         setSize(600, 650);
	         setLocationRelativeTo(null);
	     }
	     
	    
	 }


	/**
	 * main
	 * @param args - аргументы
	 * @throws IOException 
	 */
 public static void main(String[] args) throws IOException
	{	
	 MyCollection myCollection = new MyCollection();
	 
	 myCollection.TransportHash(10);
	 myCollection.TransportHash(100);
	 myCollection.TransportHash(1000);
	 myCollection.TransportHash(10000);
	 myCollection.TransportHash(100000);
	
	 
 	
	 do
     {
	    View.Menu();
		int case_number = Check.intCheck();
			
         switch(case_number)
         {
             case 0:
                 Log.log(Level.INFO, "Завершение программы в {0}",LocalTime.now());
                 return;
             case 1:
                 new Main("График добавления элементов(среднее время)",true,false).setVisible(true);
                 break;
             case 2:
                 new Main("График удаления элементов(среднее время)", false, false).setVisible(true);
                 break;
             case 3:
                 new Main("График добавления элементов(общее время)",true, true).setVisible(true);
                 break;
             case 4:
                 new Main("График удаления элементов(общее время)", false, true).setVisible(true);
                 break;
         }
     }while (true);

	}
}



