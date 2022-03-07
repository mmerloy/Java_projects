package model;

import java.io.*;
import java.util.*;
import java.util.logging.*;


import controller.Controller;

public class MyCollection
{
    public Logger Log1 = null;
    public Logger Log2 = null;
    public Logger Log = null;
    public TransportExtension te = new TransportExtension();
    
   
    /**
     * handle - work with a logger
     * 
     */
    private void handle() 
    {
        FileHandler handler1 = null;
        FileHandler handler2 = null;

        try 
        {
            // Инициализируйте FileHandler для записи в указанное имя файла с необязательным добавлением.
            handler1 = new FileHandler("ArrayList" + Quantity + ".log", true);
            handler2 = new FileHandler("HashMap" + Quantity + ".log", true);
        } 
        catch (SecurityException | IOException e) 
        {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();  // форматирование сообщений журнала.
        handler1.setFormatter(formatter);
        handler2.setFormatter(formatter);
        Log1.addHandler(handler1); // Добавляем журнал
        Log2.addHandler(handler2); // Добавляем журнал
    }

//-----------------------------------------------------------------------------------


    public ArrayList<Transport> ArrayListTransports;
    public HashMap<Integer,Transport > HashMapTransports;
    public int Quantity;
    private static int yCount = 0;
    public static long[][] YsAddMedium = new long[2][5];
    public static long[][] YsRemMedium = new long[2][5];
    public static long[][] YsAddAll = new long[2][5];
    public static long[][] YsRemAll = new long[2][5];

    /**
     *
     * @param Quantity amount of elements
     */
    public void TransportHash(int Quantity)
    {
        ArrayListTransports = new ArrayList<Transport>(Quantity);
        HashMapTransports = new HashMap<Integer, Transport>(Quantity);
        Log1 = Logger.getLogger(Controller.class.getName() +1 +Quantity);
        Log2 = Logger.getLogger(Controller.class.getName() +2 +Quantity);
        this.Quantity = Quantity;
        this.handle();
        Log1.log(Level.INFO,"ArrayList");
        Log2.log(Level.INFO,"HashMap");
        add();
        remove();
        yCount++; // разбиение на наши 5 значений (10, 100...)
    }

//---------------------------- Add-------------------------------------

    /**
     * add random transports to the array
     */
    private void add() 
    {
        long time = 0, allTime2 = 0, allTime1 = 0;
        for (int i = 0; i < Quantity; i++) 
        {
            // fill with random transports
        	
        	Transport New = te.randomTransport();

            // measure time for arrayList
            time = System.nanoTime();
            ArrayListTransports.add(New);
            time = System.nanoTime() - time;
            //Log1.log(Level.INFO, "Add, ID={0}, {1}", new Object[] {i, time});
            allTime1 += time;

            // measure time for HashMap
            time = System.nanoTime();
            HashMapTransports.put(i, New); // Добавляет New по ключу i
            time = System.nanoTime() - time;
            allTime2 += time;
            //Log2.log(Level.INFO, "Add, ID={0}, {1}", new Object[] {i, time});
        }
        Log1.log(Level.INFO, "\nAddTotalCount = {0}", Quantity);
        Log1.log(Level.INFO, "AddTotalTime = {0}", allTime1);
        Log1.log(Level.INFO, "AddMedianTime = {0}", allTime1 / Quantity);
        YsAddMedium[0][yCount]=allTime1/Quantity;
        YsAddAll[0][yCount]=allTime1;

        Log2.log(Level.INFO, "\nAddTotalCount = {0}", Quantity);
        Log2.log(Level.INFO, "AddTotalTime = {0}", allTime2);
        Log2.log(Level.INFO, "AddMedianTime = {0}", allTime2 / Quantity);
        YsAddMedium[1][yCount]=allTime2/Quantity;
        YsAddAll[1][yCount]=allTime2;
    }
   
//-------------------------------------------------------------------------------
    /**
     * remove 10% from the whole array
     */
    private void remove() 
    {
        long time = 0, allTime2 = 0, allTime1 = 0;
        int Perc = Quantity / 10;
        int j = (int) (Math.random() * Quantity);
        boolean[] isDeleted = new boolean[Quantity];

        for (int i = 0; i < Perc; i++) 
        {
            while (isDeleted[j]) 
            {
                j = (int) (Math.random() * ArrayListTransports.size());
            }
            isDeleted[j] = true;

            // measure time for arrayList
            time = System.nanoTime();
            ArrayListTransports.remove(j);
            time = System.nanoTime() - time;
            //Log1.log(Level.INFO, "Add, ID={0}, {1}", new Object[] {j, time});
            allTime1 += time;

            // measure time for HashMap
            time = System.nanoTime();
            HashMapTransports.remove(j);
            time = System.nanoTime() - time;
            allTime2 += time;
            //Log2.log(Level.INFO, "Remove, ID={0}, {1}", new Object[] {j, time});
        }
        Log1.log(Level.INFO, "\nRemoveTotalCount = {0}", Perc);
        Log1.log(Level.INFO, "RemoveTotalTime = {0}", allTime1);
        Log1.log(Level.INFO, "RemoveMedianTime = {0}", allTime1 / Perc);
        YsRemMedium[0][yCount]=allTime1/Perc;
        YsRemAll[0][yCount]=allTime1;

        Log2.log(Level.INFO, "\nRemoveTotalCount = {0}", Perc);
        Log2.log(Level.INFO, "RemoveTotalTime = {0}", allTime2);
        Log2.log(Level.INFO, "RemoveMedianTime = {0}", allTime2 / Perc);
        YsRemMedium[1][yCount]=allTime2/Perc;
        YsRemAll[1][yCount]=allTime2;
    }

}