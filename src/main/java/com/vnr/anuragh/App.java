package com.vnr.anuragh;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vnr.anuragh.customlist.MyList;
/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger logger=LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
     MyList<String> list=new MyList<String>();
     list.add("Epam");
     list.set(1, "Java");
     list.add("JavaScript");
     logger.info(list.toString());
     
     list.set(1, "Core Java");
     logger.info(list.toString());
     
     logger.info("The value at position 2 "+list.get(2));
     
     list.remove(1);
     logger.info(list.toString());
    }
}
