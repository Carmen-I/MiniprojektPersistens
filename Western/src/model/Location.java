package model;

public class Location {

	private int locationId;
	private int currentStock;
	private int minStock;
	private int maxStock;

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

}
