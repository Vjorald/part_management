
public class Purchasing implements StockObserver {
	
	public ReceivingStock receivingStock;
	
	public Purchasing(ReceivingStock receivingStock) {
		if(receivingStock.equals(null))
			throw new NullPointerException("Undefined Argument!");
		
		this.receivingStock = receivingStock;
	}
	
	public void buy(Part part, int count) {
		if(part.equals(null))
			throw new NullPointerException("Undefined argument!");
		if(count <= 0)
			throw new IllegalArgumentException("Negative count!");
		
		
		if(receivingStock.parts.containsKey(part))
			receivingStock.parts.put(part, receivingStock.parts.get(part) + count );
		else if(receivingStock.parts.containsKey(part) != true)
			receivingStock.parts.put(part, count);
	}
	
	public ReceivingStock getStock() {
		return receivingStock;
	}

	@Override
	public void onPartCountChanged(Part part, int count) {
	     if(part.equals(null))
	    	 throw new NullPointerException("Undefined argument!");
	     if(count < 0)
	    	 throw new IllegalArgumentException("Negative count!");
	     
	     if(receivingStock.parts.containsKey(part) && count < receivingStock.getMinStockItems())
	    	 buy(part,receivingStock.getMaxStockItems() - count);
	     else if(receivingStock.parts.containsKey(part) != true && count < receivingStock.getMinStockItems())
	    	 buy(part, 100);
	     else if(receivingStock.parts.containsKey(part) != true && count <= receivingStock.getMaxStockItems() && count >= receivingStock.getMinStockItems())
	    	 buy(part, 100);
	}

}
