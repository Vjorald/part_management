
public class ReceivingStock extends Stock {
	
	private int minStockItems;
	private int maxStockItems;
	
	
	
	public ReceivingStock(int minStockItems, int maxStockItems) {
		if(minStockItems < 0 || maxStockItems < 0 || minStockItems > maxStockItems)
			throw new IllegalArgumentException("Illegal value!");
		else if(minStockItems >= maxStockItems)
			throw new IllegalArgumentException(" Min Stock greater or equal max stock.");
		
		this.minStockItems = minStockItems;
		this.maxStockItems = maxStockItems;
	}
	
	public int getMinStockItems() {
		return minStockItems;
	}
	
	public int getMaxStockItems() {
		return maxStockItems;
	}
	
	@Override
	public boolean insert(Part part, int amount) {
		if(part.equals(null))
			throw new NullPointerException("Undefined Parameter!");
	    if(amount < 1)
			throw new IllegalArgumentException("Negative amount!");
		
		if(parts.containsKey(part) && (parts.get(part) + amount) <= maxStockItems)
		{
			int k = parts.get(part);
			parts.put(part, k + amount);
			notifyPartCountChanged(part);
			return true;
		}
		else if(parts.containsKey(part) == false &&  amount <= maxStockItems)
		{
			parts.put(part,amount);
			notifyPartCountChanged(part);
			return true;
		}	
		
		return false;
	
	}
	
	@Override
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
		
		return false;
		
	}
}
