import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FifoRowDetail {
	Date	dateRecord;
	Double localQuantity;
	String localInvoiceName;
	

	Double invoiceQuantity;
	Double interQuantity;
	Double invoiceBalance;
	String interInvoiceName;
	

	Double sumInvoiceBalance;
	
	public FifoRowDetail(Double localQuantity, Double invoiceQuantity, Double interQuantity, Double invoiceBalance) {
		super();
		this.localQuantity = localQuantity;
		this.invoiceQuantity = invoiceQuantity;
		this.interQuantity = interQuantity;
		this.invoiceBalance = invoiceBalance;
	}

	public FifoRowDetail() {
		this.localQuantity = this.interQuantity = this.interQuantity = this.invoiceBalance = (double) -1;
		// TODO Auto-generated constructor stub
	}

	public String getInterInvoiceName() {
		return interInvoiceName;
	}

	public void setInterInvoiceName(String interInvoiceName) {
		this.interInvoiceName = interInvoiceName;
	}
	
	public String getLocalInvoiceName() {
		return localInvoiceName;
	}

	public void setLocalInvoiceName(String localInvoiceName) {
		this.localInvoiceName = localInvoiceName;
	}
	
	public Double getLocalQuantity() {
		return localQuantity;
	}

	public void setLocalQuantity(Double localQuantity) {
		this.localQuantity = localQuantity;
	}

	public Double getInvoiceQuantity() {
		return invoiceQuantity;
	}

	public void setInvoiceQuantity(Double invoiceQuantity) {
		this.invoiceQuantity = invoiceQuantity;
	}

	public Double getInterQuantity() {
		return interQuantity;
	}

	public void setInterQuantity(Double interQuantity) {
		this.interQuantity = interQuantity;
	}

	public Double getInvoiceBalance() {
		return invoiceBalance;
	}

	public void setInvoiceBalance(Double invoiceBalance) {
		this.invoiceBalance = invoiceBalance;
	}
	
	
	public Date getDateRecord() {
		return dateRecord;
	}

	public void setDateRecord(Date dateRecord) {
		this.dateRecord = dateRecord;
	}

	public String getInvoiceName() {
		return interInvoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.interInvoiceName = invoiceName;
	}

	
	public Double getSumInvoiceBalance() {
		return sumInvoiceBalance;
	}

	public void setSumInvoiceBalance(Double sumInvoiceBalance) {
		this.sumInvoiceBalance = sumInvoiceBalance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		String local_Q="";
		if(getLocalQuantity()!=-1.0) local_Q=getLocalQuantity().toString();
		String inter_Q="";
		if(getInterQuantity()!=-1.0) inter_Q=getInterQuantity().toString();
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
