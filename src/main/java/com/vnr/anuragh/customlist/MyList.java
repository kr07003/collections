package com.vnr.anuragh.customlist;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vnr.anuragh.App;
public class MyList<E> {
	private Object container[];
	private int size=0;
	private static final int DEFAULT_SIZE=10;
	private final static Logger logger=LogManager.getLogger(MyList.class);
	public MyList()
	{
		this.container=new Object[DEFAULT_SIZE];
	}
	public void add(E value)
	{
		if(this.size==this.container.length)
		{
			increaseContainerCapacity();
		}
		logger.info("Added value "+value+" to the list");
		this.container[size++]=value;
		logger.info("Incremented size by one");
	}
	@SuppressWarnings("unchecked")
	public void set(Integer index,E value)
	{
		if(this.size<index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(this.size==index)
			{
				if(this.size==this.container.length)
				{
					increaseContainerCapacity();
				}
				increaseContainerCapacity();
				this.container[size++]=value;
			}
			else
			{
				E valueToBePlaced=value;
				for(Integer traverse=index;traverse<size;traverse++)
				{
					E temp=(E)this.container[traverse];
					this.container[traverse]=valueToBePlaced;
					valueToBePlaced=temp;
				}
				this.add(valueToBePlaced);	
			}
			logger.info("Added value "+value+" to the list at positon "+index);
			logger.info("Incremented size by one");
		}
	}
	private void increaseContainerCapacity()
	{
		logger.info("Increased list capacity by 5 times");
		Integer newSize=this.container.length*5;
		this.container=Arrays.copyOf(this.container, newSize);
	}
	@SuppressWarnings("unchecked")
	public E get(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			logger.info("Retreiving value at index "+index);
			return (E)this.container[index];
		}
	}
	@SuppressWarnings("unchecked")
	public E remove(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			E valueToBeReturned=(E)this.container[index];
			for(Integer traverse=index;traverse<this.size-1;traverse++)
			{
				this.container[traverse]=this.container[traverse+1];
			}				
			this.size--;
			logger.info("Removed value at index "+index);
			logger.info("Decremented size by one");
			return valueToBeReturned;
		}
	}
	public String toString()
	{
		String list="[";
		for(Integer iterator=0;iterator<this.size;iterator++)
		{
			list=list+this.container[iterator].toString();
			if(iterator!=this.size-1)
				list+=",";
		}
		list+="]";
		return list;
	}
}