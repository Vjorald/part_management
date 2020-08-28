import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Stock {
	
	public Map<Part, Integer> parts = new HashMap <Part,Integer>();
    public List <StockObserver> observers = new ArrayList<StockObserver>();
    public Iterator <StockObserver> iterator;
	
	public int getCount(Part part) {
		if(part.equals(null))
			throw new NullPointerException("Undefined Parameter!");
		
		if(parts.containsKey(part) != true)
			return -1;
		
		return parts.get(part);
		
		
	}
	
	public boolean insert(Part part, int amount) {
		if(part.equals(null))
			throw new NullPointerException("Undefined Parameter!");
		else if(amount < 1)
			throw new IllegalArgumentException("Negative amount!");
		
		if(parts.containsKey(part))
		{
			int k = parts.get(part);
			parts.put(part, k + amount);
			notifyPartCountChanged(part);
		}
		else
			parts.put(part,amount);
		notifyPartCountChanged(part);
		return true;
		
	}
	
	public boolean remove(Part part, int amount) {
		if(part.equals(null))
			throw new NullPointerException("Undefined Parameter!");
		else if(amount < 1)
			throw new IllegalArgumentException("Negative amount!");
		
		if(parts.containsKey(part) && parts.get(part) >= amount)
		{
			parts.put(part, parts.get(part) - amount);
			notifyPartCountChanged(part);
			return true;
		}
		notifyPartCountChanged(part);
		return false;
		
	}
	
	
	public void addObserver(StockObserver observer) {
		if(observer.equals(null))
			throw new NullPointerException("Undefined parameter!");
		observers.add(observer);
	}
	

	
	public void notifyPartCountChanged(Part part) {
		if(part.equals(null))
			throw new NullPointerException("Undefined Parameter!");
		
		for(StockObserver observer : observers)
			observer.onPartCountChanged(part, getCount(part));
				
			}
		
		
	}


