package view;

import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Field;

@SuppressWarnings("serial")

public class Draw extends JPanel
{
	
	private long[][] myY = new long[2][5] ; //массив значений
	//public long[][] getMyY;
	//public Draw() {};
	
//	public:Поля и методы, объявленные с модификатором public, видны другим классам из текущего пакета и из внешних пакетов.
//	private: Закрытый класс или член класса доступен только из кода в том же классе.
//	protected: такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах, даже если они находятся в других пакетах
//	Модификатор по умолчанию. Такие поля или методы видны всем классам в текущем пакете.
//	Если метод указан как static — это означает, что он может использоваться без ссылки на конкретный объект класса. 
//Если бы этот метод не был статическим — то для его использования нам понадобилось бы сперва создать объект.
	
	//сигнатура - public long[][] getMyY()
    //модификатор доступа, тип возвращаемого значения, имя метода(список параметров) {}
	//метод для получения значения поля
	public long[][] getMyY()
	{
		return myY; //тело метода
	}
//метод ничего не возвращает - ключевое слово void
	//метод для установки значения поля
	public void setMyY(long[][] myY)
	{
		this.myY = myY;
	}
	
	
	@Override
    protected void paintComponent(Graphics gh) 
    {

        // Создаем объект g2 для двумерного рисования из объекта g
        Graphics2D drp = (Graphics2D) gh;
        long max = myY[0][0];
        
        
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 5; j++)
                if (myY[i][j] > max)
                	max = myY[i][j];
        
        long dy = max / 9;
        // max - максимальное время
        // dy - интервалы между строками

        //горизонтальные линии и обозначения
        for (int i = 2; i < 11; i++) 
        {
            drp.drawLine(75, 50 + 44 * i, 550, 50 + 44 * i); // нарисовали линию
            long vs = max - (i - 2) * dy; // получили цифру по y
            drp.drawString(vs + "", 10, 50 + 44 * i); // подписали линию по y
        }
        drp.drawLine(75, 50 + 44 * 11, 550, 50 + 44 * 11);  // рисуем первую линию
        drp.drawString(0 + "", 10, 50 + 44 * 11); // подписали линию по y

        drp.drawString("ArrayList", 100, 40);
        drp.drawString("HashMap", 100, 60);

        drp.drawString("10", 70, 550);// название, координата х, координата у
        drp.drawString("100", 170, 550);
        drp.drawString("1000", 270, 550);
        drp.drawString("10000", 370, 550);
        drp.drawString("100000", 470, 550);

        // цвет для квадратиков рядом с Array и Hash
        drp.setColor(Color.BLUE);
        drp.fillRect(80, 30, 10, 10);// для отрисовки прямоугольников
        drp.setColor(Color.RED);
        drp.fillRect(80, 50, 10, 10);

        for (int i = 0; i < 5; i++) // разбиение по 10/100/1000...
        { 
            //строим саму гистограмму
            //извлекаем цвет для каждого графика1
            Color color = Color.RED;
            for (int j = 0; j < 2; j++) 
            { // разбиваем по количеству цветов
                try 
                {
                    Field field = Class.forName("java.awt.Color").getField(controller.Controller.Main.col[j].toLowerCase()); // получаем цвета
                    color = (Color) field.get(null);
                }
                catch (Exception e) { }
                drp.setColor(color);

                //переводим полученные данные в реальные координаты
                int realY = (int) (534 - 44 * myY[j][i] / dy); // начальные координаты
                int realHight = (int) (myY[j][i] * 44 / dy);
                drp.fillRect(75 + 20 * j + 100 * i, realY, 20, realHight);
            }
        }
    }
}