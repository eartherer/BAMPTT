
public class invoice {
	int idx;
	String name;
	Double quantity;
	public invoice(int idx, String name, Double quantity) {
		super();
		this.idx = idx;
		this.name = name;
		this.quantity = quantity;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	
}
