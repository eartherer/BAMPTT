import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class sellDetail implements Comparable<sellDetail>{
	private int idx;
	private Date sellDate;
	private String productName;
	private String sellNumber;
	private BigDecimal Quantity;
	private BigDecimal QuantityF;
	private int regionFlg;
	
	public sellDetail(int idx, String sellDate, String productName,
			String sellNumber, BigDecimal quantity, BigDecimal quantityF, int flg) throws ParseException {
		super();
		this.idx = idx;
		this.setSellDate(sellDate);
		this.productName = productName;
		this.sellNumber = sellNumber;
		Quantity = quantity;
		QuantityF = quantityF;
		regionFlg = flg; //0=local , 1=inter
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) throws ParseException {
		 DateFormat df = new SimpleDateFormat("dd/MM/yy"); 
		this.sellDate = df.parse(sellDate);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSellNumber() {
		return sellNumber;
	}
	public void setSellNumber(String sellNumber) {
		this.sellNumber = sellNumber;
	}
	public BigDecimal getQuantity() {
		return Quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		Quantity = quantity;
	}
	public BigDecimal getQuantityF() {
		return QuantityF;
	}
	public void setQuantityF(BigDecimal quantityF) {
		QuantityF = quantityF;
	}
	public int getRegionFlg() {
		return regionFlg;
	}
	public void setRegionFlg(int regionFlg) {
		this.regionFlg = regionFlg;
	}
	@Override
	public int compareTo(sellDetail o) {
		int compareDate = this.sellDate.compareTo(o.getSellDate());
		if(compareDate==0){
			return this.regionFlg - o.getRegionFlg();
		}
		// TODO Auto-generated method stub
		return compareDate;
	}
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// TODO Auto-generated method stub
		return df.format(sellDate)+" "+Quantity+" "+QuantityF;
	}
}
