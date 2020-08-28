
public class Factory{
	
	private ReceivingStock receivingStock;
	private Purchasing purchasing;
	private static Part part;
	
	
	public Factory(Purchasing purchasing, ReceivingStock receivingStock) {
		if(purchasing.equals(null) || receivingStock.equals(null))
			throw new NullPointerException("Null Argument!");
		
		this.purchasing = purchasing;
		this.receivingStock = receivingStock;
	}
	
	public Purchasing getPurchasing() {
		return purchasing;
	}
	
	public ReceivingStock getReceivingStock() {
		return receivingStock;
	}
	
	public static Part createPart(PartType partType, String id, String name) {
		if(id == null || name == null || partType == null)
			throw new NullPointerException("Undefined argument!");
		
		if(partType == PartType.COMPONENTS)
			part = new Components(id,name);
		else if(partType == PartType.RESOURCE)
			part = new Resource(id,name);
		else if (partType == PartType.SINGLE_COMPONENT)
			part = new SingleComponent(id,name);
		   
		return part;
	}
	

}
