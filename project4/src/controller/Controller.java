package controller;

import model.*;

import java.io.*;

/**
 * @author mmerloy
 * @version 0.1.0
 * @since 17.11.2021 14:50
 * 
 */
public class Controller 
{
	

	/**
	 * main
	 * @param args - аргументы
	 * @throws IOException 
	 */
 public static void main(String[] args) throws IOException
	{	
	 MyCollection myCollection = new MyCollection();
	 
	 myCollection.TransportHash(10);
	 myCollection.resize();
	 myCollection.TransportHash(100);
	 myCollection.resize();
	 myCollection.TransportHash(1000);
	 myCollection.resize();
	 myCollection.TransportHash(10000);
	 myCollection.resize();
	 myCollection.TransportHash(100000);
	
	 myCollection.resize();
		
	}
}



