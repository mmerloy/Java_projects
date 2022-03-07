package model;


import java.util.*;
import java.util.logging.*;


/** 
 * ���������� ������� ���������� � �� �������
 * Loggin at file
 * @param errCount - ����� ������
 * @param errList - ���� ����������
 * @param logFile - ������ � ������ log file
 * 
*/
public class MyLogger 
{
	
    int errCount = 0;
    ArrayList<Exception> errList= new ArrayList<Exception>();
    String logFile = "MyLogFile.log";
    public Logger LOGGER = Logger.getLogger(MyLogger.class.getName());/** logger ��� ������ �  log*/
    public Scanner sc = new Scanner(System.in); /** scanner ��� ������ �� �������*/
    public FileHandler fh;  /** fileHandler ��� ������ � ���� */


    /**
     * method for logging to file
     * @param msg - ������ � ���������� � ������� ��� ������
     * @param level - ������� of log (Warning, Error, Info)
     */
    public void Log(String msg, Level level)
    {
        try
        {
            fh = new FileHandler(logFile);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            this.LOGGER.addHandler(fh);
            LOGGER.log(level, msg);
        }
        catch (Exception ignore)
        {
            ignore.printStackTrace();
        }
        finally 
        {
            fh.close();
        }
    }

    /**
     * �����  ��� logging  � ����
     * @param msg - ������ � ���������� � ������� ��� ������
     * @param level - ������� of log (Warning, Error, Info)
     * @param outLogFile - ������ � ������ log file
     */
    public void Log(String msg, Level level,String outLogFile)
    {
        try
        {
            fh = new FileHandler(outLogFile, true);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            this.LOGGER.addHandler(fh);
            LOGGER.log(level, msg);
        }
        catch (Exception ignore)
        {
            ignore.printStackTrace();
        }
        finally 
        {
            fh.close();
        }
    }

    

    /**
     * ����� ���������� ������ ����������
     * @param e - ����������
     * @param msg - ������ � ���������� �� ����������
     * @param level -  ������� ����������
     */
    public void NewException(Exception e, String msg, Level level)
    {
        errList.add(e);
        errCount++;
        System.out.println(e.getMessage());
        Log(e.getMessage(),level);
    }

}
