package model;


import java.util.*;
import java.util.logging.*;


/** 
 * сохранения каждого исключения и их подсчет
 * Loggin at file
 * @param errCount - номер ошибки
 * @param errList - лист исключений
 * @param logFile - строка с именем log file
 * 
*/
public class MyLogger 
{
	
    int errCount = 0;
    ArrayList<Exception> errList= new ArrayList<Exception>();
    String logFile = "MyLogFile.log";
    public Logger LOGGER = Logger.getLogger(MyLogger.class.getName());/** logger для записи в  log*/
    public Scanner sc = new Scanner(System.in); /** scanner для чтения из консоли*/
    public FileHandler fh;  /** fileHandler для записи в файл */


    /**
     * method for logging to file
     * @param msg - строка с сообщением о событии или ошибке
     * @param level - уровень of log (Warning, Error, Info)
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
     * метод  для logging  в файл
     * @param msg - строка с сообщением о событии или ошибке
     * @param level - уровень of log (Warning, Error, Info)
     * @param outLogFile - строка с именем log file
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
     * Метод добавления нового исключения
     * @param e - Исключение
     * @param msg - строка с сообщением об исключении
     * @param level -  уровень исключения
     */
    public void NewException(Exception e, String msg, Level level)
    {
        errList.add(e);
        errCount++;
        System.out.println(e.getMessage());
        Log(e.getMessage(),level);
    }

}
