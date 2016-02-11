import java.math.BigDecimal;

public class invoice {
	int idx;
	String name;
	BigDecimal quantity;
	public invoice(int idx, String name, BigDecimal quantity) {
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
}
