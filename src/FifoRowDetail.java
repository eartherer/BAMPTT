import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FifoRowDetail {
	Date	dateRecord;
	BigDecimal localQuantity;
	String localInvoiceName;
	

	BigDecimal invoiceQuantity;
	BigDecimal interQuantity;
	BigDecimal invoiceBalance;
	String interInvoiceName;
	

	BigDecimal sumInvoiceBalance;
	
	public FifoRowDetail(BigDecimal localQuantity, BigDecimal invoiceQuantity, BigDecimal interQuantity, BigDecimal invoiceBalance) {
		super();
		this.localQuantity = localQuantity;
		this.invoiceQuantity = invoiceQuantity;
		this.interQuantity = interQuantity;
		this.invoiceBalance = invoiceBalance;
	}

	public FifoRowDetail() {
		this.localQuantity = this.interQuantity = this.interQuantity = this.invoiceBalance = new BigDecimal(-1);
		// TODO Auto-generated constructor stub
	}

	

	public Date getDateRecord() {
		return dateRecord;
	}

	public void setDateRecord(Date dateRecord) {
		this.dateRecord = dateRecord;
	}

	public BigDecimal getLocalQuantity() {
		return localQuantity;
	}

	public void setLocalQuantity(BigDecimal localQuantity) {
		this.localQuantity = localQuantity;
	}

	public String getLocalInvoiceName() {
		return localInvoiceName;
	}

	public void setLocalInvoiceName(String localInvoiceName) {
		this.localInvoiceName = localInvoiceName;
	}

	public BigDecimal getInvoiceQuantity() {
		return invoiceQuantity;
	}

	public void setInvoiceQuantity(BigDecimal invoiceQuantity) {
		this.invoiceQuantity = invoiceQuantity;
	}

	public BigDecimal getInterQuantity() {
		return interQuantity;
	}

	public void setInterQuantity(BigDecimal interQuantity) {
		this.interQuantity = interQuantity;
	}

	public BigDecimal getInvoiceBalance() {
		return invoiceBalance;
	}

	public void setInvoiceBalance(BigDecimal invoiceBalance) {
		this.invoiceBalance = invoiceBalance;
	}

	public String getInterInvoiceName() {
		return interInvoiceName;
	}

	public void setInterInvoiceName(String interInvoiceName) {
		this.interInvoiceName = interInvoiceName;
	}

	public BigDecimal getSumInvoiceBalance() {
		return sumInvoiceBalance;
	}

	public void setSumInvoiceBalance(BigDecimal sumInvoiceBalance) {
		this.sumInvoiceBalance = sumInvoiceBalance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		String local_Q="";
		if(!getLocalQuantity().equals(new BigDecimal(-1))) local_Q=getLocalQuantity().toString();
		String inter_Q="";
		if(!getInterQuantity().equals(new BigDecimal(-1))) inter_Q=getInterQuantity().toString();
		String localIVN=getLocalInvoiceName();
		if(getLocalInvoiceName()==null) localIVN="";
		
		return df.format(dateRecord) + ","
				+local_Q + "," 
				+localIVN+","
//				+invoiceQuantity.toString() + " "
				+inter_Q + ","
				+getInterInvoiceName()+ ","
				+getInvoiceBalance().toString();//å+ ","
				//+interInvoiceName
				//;
	}
	
}
