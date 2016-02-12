import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class invoice {
	int idx;
	Date lotDate;
	String name;
	BigDecimal quantity;
	
	public invoice(int idx, String lotDate, String name, BigDecimal quantity) throws ParseException {
		super();
		this.idx = idx;
		this.setLotDate(lotDate);
		this.name = name;
		this.quantity = quantity;
	}
		
	public Date getLotDate() {
		return lotDate;
	}

	public void setLotDate(String lotDate) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		this.lotDate = df.parse(lotDate);
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
