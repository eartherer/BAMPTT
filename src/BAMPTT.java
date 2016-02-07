import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.RowSetInternal;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class BAMPTT extends JFrame{

	public BAMPTT(){
//		initUI();
	}
	static ArrayList<sellDetail> sellInter = new ArrayList<>();
	static ArrayList<sellDetail> sellLocal = new ArrayList<>();
	static ArrayList<sellDetail> sum_sellLocal = new ArrayList<>();
	
	private void initVariable(){
		sellInter = new ArrayList<>();
		sellLocal = new ArrayList<>();
		sum_sellLocal = new ArrayList<>();
	}
	
	public static void main(String[] args) throws NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		
		BAMPTT main1 = new BAMPTT();
		main1.initUI();
		main1.setVisible(true);
//		main1.readCVS("/Users/Earther/Desktop/inter.csv",sellInter,1);
//		main1.readCVS("/Users/Earther/Desktop/local.csv",sellLocal,0);
//		main1.sumSellLocal();
//		main1.processOutput("/Users/Earther/Desktop/output.csv");
//		System.out.println("End program");
	}

	private void createLayout(JComponent... arg) {
        
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
        pane.setToolTipText("Content pane");        
        
        
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(200)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(120)
        );
        
        pack();        
    }
	
	private void initUI() {
        
				// Create Form Frame
				setSize(500, 500);
				setLocation(500, 280);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				getContentPane().setLayout(null);
				
				// Label Result
				final JLabel lblResult = new JLabel("Internation File Path",JLabel.LEFT);
				lblResult.setBounds(25,0,300,25);
				getContentPane().add(lblResult);
				
				final JTextField InterFilePath = new JTextField("Select File Path");
				InterFilePath.setBounds(25, 25, 400, 25);
				InterFilePath.setText("/Users/Earther/Desktop/interkabi.csv");
				getContentPane().add(InterFilePath);
				
				// Create Button Open JFileChooser
				JButton btnButton = new JButton("Browse");
				btnButton.setBounds(25, 55, 121, 30);
				btnButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JFileChooser fileopen = new JFileChooser();
		                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");
		                fileopen.addChoosableFileFilter(filter);

		                int ret = fileopen.showDialog(null, "Choose file");

		                if (ret == JFileChooser.APPROVE_OPTION) {
		                	InterFilePath.setText(fileopen.getSelectedFile().toString());
		                	repaint();
		                }

					}
				});
				getContentPane().add(btnButton);
				
				// Label Result
				final JLabel lblResult2 = new JLabel("Local File Path",JLabel.LEFT);
				lblResult2.setBounds(25,100,300,25);
				getContentPane().add(lblResult2);
				
				final JTextField InterFilePath2 = new JTextField("Select File Path");
				InterFilePath2.setBounds(25, 125, 400, 25);
				InterFilePath2.setText("/Users/Earther/Desktop/localkabi.csv");
				getContentPane().add(InterFilePath2);
				
				// Create Button Open JFileChooser
				JButton btnButton2 = new JButton("Browse");
				btnButton2.setBounds(25, 155, 121, 30);
				btnButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JFileChooser fileopen = new JFileChooser();
		                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");
		                fileopen.addChoosableFileFilter(filter);

		                int ret = fileopen.showDialog(null, "Choose file");

		                if (ret == JFileChooser.APPROVE_OPTION) {
		                	InterFilePath2.setText(fileopen.getSelectedFile().toString());
		                	repaint();
		                }

					}
				});
				getContentPane().add(btnButton2);
				
				// Label Result
				final JLabel lblResult3 = new JLabel("Output File Path",JLabel.LEFT);
				lblResult3.setBounds(25,190,300,25);
				getContentPane().add(lblResult3);
				
				final JTextField InterFilePath3 = new JTextField("Select File Path");
				InterFilePath3.setBounds(25, 215, 400, 25);
				InterFilePath3.setText("/Users/Earther/Desktop/output.csv");
				getContentPane().add(InterFilePath3);
				
				// Create Button Open JFileChooser
				JButton btnButton3 = new JButton("Browse");
				btnButton3.setBounds(25, 250, 121, 30);
				btnButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JFileChooser fileopen = new JFileChooser();
		                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");
		                fileopen.addChoosableFileFilter(filter);

		                int ret = fileopen.showDialog(null, "Save file");

		                if (ret == JFileChooser.APPROVE_OPTION) {
		                	InterFilePath3.setText(fileopen.getSelectedFile().toString()+".csv");
		                	repaint();
		                }

					}
				});
				getContentPane().add(btnButton3);
	
				JButton btnRun = new JButton("Run");
				btnRun.setBounds(25, 300, 121, 30);
				btnRun.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String interPathfileStr = InterFilePath.getText();
						String localPathfileStr = InterFilePath2.getText();
						String outputPathfileStr = InterFilePath3.getText();
						System.out.println(interPathfileStr);
						System.out.println(localPathfileStr);
						System.out.println(outputPathfileStr);
						
						BAMPTT m1 = new BAMPTT();
						try{
							System.out.println(">>>Start Process......");
							m1.initVariable();
							m1.readCVS(interPathfileStr,sellInter,1);
							m1.readCVS(localPathfileStr,sellLocal,0);
							m1.sumSellLocal();
							m1.processOutput(outputPathfileStr);
							System.out.println(">>>End Process......");
						}catch(Exception e1){
							
						}
						
					}
				});
				getContentPane().add(btnRun);
				
				JButton btnRun2 = new JButton("RunFIFO Invoice");
				btnRun2.setBounds(155, 300, 150, 30);
				btnRun2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String interPathfileStr = InterFilePath.getText();
						String localPathfileStr = InterFilePath2.getText();
						String outputPathfileStr = InterFilePath3.getText();
						System.out.println(interPathfileStr);
						System.out.println(localPathfileStr);
						System.out.println(outputPathfileStr);
						
						BAMPTT m1 = new BAMPTT();
						try{
							System.out.println(">>>Start Process......");
							m1.initVariable();
							m1.readCVS(interPathfileStr,sellInter,1);
							m1.readCVS(localPathfileStr,sellLocal,0);
							m1.sumSellLocal();
							m1.processFifo2();
							//m1.processOutput(outputPathfileStr);
							System.out.println(">>>End Process......");
						}catch(Exception e1){
							
						}
						
					}
				});
				getContentPane().add(btnRun2);
	}
	
	private void processFifo2(){
		ArrayList<invoice> invoiceList = new ArrayList<invoice>();
		readCSV_Oil_Input("/Users/Earther/Desktop/lotInput.csv", invoiceList);
		
		ArrayList<sellDetail> sum_allData = new ArrayList<>();
		sum_allData.addAll(sellInter);
		sum_allData.addAll(sum_sellLocal);
		Collections.sort(sum_allData);
		
		ArrayList<FifoRowDetail> fifoRowDetailsList = new ArrayList<FifoRowDetail>();
		sellDetail prevRecord = null;
		Date prevDate = null;
		FifoRowDetail rowTMP,prevROW = null;
		
		/*
		 * Build Row for prepare FIFO
		 */
		
		
		for (sellDetail recordDetail : sum_allData) {
			if(prevDate==null || recordDetail.getSellDate().compareTo(prevDate)!=0? true:false){
				//New Date
				prevRecord = recordDetail;
				prevDate	=	recordDetail.getSellDate();
				rowTMP = new FifoRowDetail();
				if(recordDetail.getRegionFlg()==0){ //Local Case
					rowTMP.setDateRecord(prevDate);
					rowTMP.setLocalQuantity(recordDetail.getQuantityF());
				}else if(recordDetail.getRegionFlg()==1){ //Inter Case
					rowTMP.setDateRecord(prevDate);
					rowTMP.setInterQuantity(recordDetail.getQuantityF());
				}
				prevROW = rowTMP;
				fifoRowDetailsList.add(rowTMP);
				rowTMP = new FifoRowDetail();
			}else{//Same prev Date
				if(recordDetail.getRegionFlg()==0){ //Local Case
					if(prevROW.getLocalQuantity()==-1){//prevROW local is empty so put it...
						prevROW.setLocalQuantity(recordDetail.getQuantityF());
					}else{ //prevROW local is full so new object
						rowTMP = new FifoRowDetail();
						rowTMP.setDateRecord(prevDate);//Set date to same prev row
						rowTMP.setLocalQuantity(recordDetail.getQuantityF());
						prevROW = rowTMP;
						fifoRowDetailsList.add(rowTMP);
						rowTMP = new FifoRowDetail();
					}
				}else if(recordDetail.getRegionFlg()==1){ //Inter Case
					if(prevROW.getInterQuantity()==-1){//prevROW inter is empty so put it...
						prevROW.setInterQuantity(recordDetail.getQuantityF());
					}else{ //prevROW local is full so new object
						rowTMP = new FifoRowDetail();
						rowTMP.setDateRecord(prevDate);//Set date to same prev row
						rowTMP.setInterQuantity(recordDetail.getQuantityF());
						prevROW = rowTMP;
						fifoRowDetailsList.add(rowTMP);
						rowTMP = new FifoRowDetail();
					}
				}
			}	
		}
		/*
		 * FIFO Lot
		 */
		
		
		int invoiceIndex=0;
		ArrayList<FifoRowDetail> FIFO_ROW_List = new ArrayList<FifoRowDetail>();
		invoice currentLot = invoiceList.get(invoiceIndex++);//Load Lot
		
		for (FifoRowDetail fifoRowDetail : fifoRowDetailsList) {
//			if(FIFO_ROW_List.size()==10) break;
			if(fifoRowDetail.getLocalQuantity()!=-1){ //There is local 
				while(currentLot.getQuantity()<fifoRowDetail.getLocalQuantity()){//Lot not enough so insert new row
					FifoRowDetail insertROW = new FifoRowDetail();
					insertROW.setDateRecord(fifoRowDetail.getDateRecord());
					insertROW.setLocalQuantity(currentLot.getQuantity());
					insertROW.setLocalInvoiceName(currentLot.getName());
					insertROW.setInterQuantity((double) -1);
					insertROW.setInterInvoiceName(null);
					insertROW.setInvoiceBalance((double) 0);
					FIFO_ROW_List.add(insertROW);
					fifoRowDetail.setLocalQuantity(fifoRowDetail.getLocalQuantity()-currentLot.getQuantity());
					currentLot.setQuantity(0.0);
					if(currentLot.getQuantity()<=0)//Invoice empty load new invoice
						if(invoiceIndex == invoiceList.size()) //Invoice empty
							break; //Go out loop
						else
							currentLot = invoiceList.get(invoiceIndex++); // Load new invoice
				}
				//when not need to insert
				currentLot.setQuantity(currentLot.getQuantity() - fifoRowDetail.getLocalQuantity());
				fifoRowDetail.setLocalInvoiceName(currentLot.getName());
				fifoRowDetail.setInvoiceBalance(currentLot.getQuantity());
				if(currentLot.getQuantity()<=0)//Invoice empty load new invoice
					if(invoiceIndex == invoiceList.size()) //Invoice empty
						break; //Go out loop
					else
						currentLot = invoiceList.get(invoiceIndex++); // Load new invoice
			}
			if(fifoRowDetail.getInterQuantity()!=-1){ //There is inter
				while(currentLot.getQuantity()<fifoRowDetail.getInterQuantity()){//Lot not enough so insert new row
					FifoRowDetail insertROW = new FifoRowDetail();
					insertROW.setDateRecord(fifoRowDetail.getDateRecord());
					insertROW.setLocalQuantity((double) -1);
					insertROW.setLocalInvoiceName(null);
					insertROW.setInterQuantity(currentLot.getQuantity());
					insertROW.setInterInvoiceName(currentLot.getName());
					insertROW.setInvoiceBalance((double) 0);
					FIFO_ROW_List.add(insertROW);
					fifoRowDetail.setInterQuantity(fifoRowDetail.getInterQuantity()-currentLot.getQuantity());
					currentLot.setQuantity(0.0);
					if(currentLot.getQuantity()<=0)//Invoice empty load new invoice
						if(invoiceIndex == invoiceList.size()) //Invoice empty
							break; //Go out loop
						else
							currentLot = invoiceList.get(invoiceIndex++); // Load new invoice
				}
				//when not need to insert
				currentLot.setQuantity(currentLot.getQuantity() - fifoRowDetail.getInterQuantity());
				fifoRowDetail.setInterInvoiceName(currentLot.getName());
				fifoRowDetail.setInvoiceBalance(currentLot.getQuantity());
				if(currentLot.getQuantity()<=0)//Invoice empty load new invoice
					if(invoiceIndex == invoiceList.size()) //Invoice empty
						break; //Go out loop
					else
						currentLot = invoiceList.get(invoiceIndex++); // Load new invoice
			}
			//Add row to list
			FIFO_ROW_List.add(fifoRowDetail);
//			fifoRowDetail = new FifoRowDetail();
		}
		
		
		System.out.println("idx,Date,local_Quantity,Local_Lot,Inter_Quantity,Inter_Lot,Balance Lot");
		int idx=1;
		for (FifoRowDetail fifoRowDetail : FIFO_ROW_List) {
			System.out.println((idx++)+","+fifoRowDetail.toString());
		}
	}
	
 	private void processFifo(){
//		List<invoice> invoiceList = new ArrayList<invoice>();
//		invoiceList.add(new invoice(1, "TOP 161115", (double) 122093.5913620120000000));
//		invoiceList.add(new invoice(2, "GC 161115", (double) 219710.8170000000000000));
//		invoiceList.add(new invoice(2, "TOP 181115", (double) 131852.2850000000000000));
//		invoiceList.add(new invoice(2, "GC 201115", (double) 175774.0110000000000000));
//		invoiceList.add(new invoice(2, "TOP 211115", (double) 80184.8730000001000000));
//		invoiceList.add(new invoice(2, "TOP 231115", (double) 490653.3610000000000000));
//		invoiceList.add(new invoice(2, "TOP 251115", (double) 175531.1150000000000000));
//		invoiceList.add(new invoice(2, "GC 251115", (double) 263830.6820000000000000));
//		invoiceList.add(new invoice(2, "TOP 281115", (double) 131766.9860000000000000));
		ArrayList<invoice> invoiceList = new ArrayList<invoice>();
		readCSV_Oil_Input("/Users/Earther/Desktop/lotInput.csv", invoiceList);
		
		ArrayList<sellDetail> sum_allData = new ArrayList<>();
		sum_allData.addAll(sellInter);
		sum_allData.addAll(sum_sellLocal);
		Collections.sort(sum_allData);
		
		int invoiceIndex = 0;
//		int expenseIndex = 0;
		sellDetail prevRecord = null;
		Date prevDate = null;
		
		ArrayList<FifoRowDetail> fifoRowDetailsList = new ArrayList<FifoRowDetail>();
		invoice invoiceForFIFO = invoiceList.get(invoiceIndex++);
		FifoRowDetail rowFIFO = new FifoRowDetail();
		for (sellDetail recordDetail : sum_allData) {
			if(prevDate==null || recordDetail.getSellDate().compareTo(prevDate)!=0? true:false){
				//New Date
				prevRecord = recordDetail;
				prevDate	=	recordDetail.getSellDate();
				
			}
				//Same Date
				if(recordDetail.getRegionFlg()==0){ //IF load local data then skip loop and load inter too
					rowFIFO.setLocalQuantity(recordDetail.getQuantityF());
					continue;//skip to load inter
				}else if(recordDetail.getRegionFlg()==1){
					rowFIFO.setInterQuantity(recordDetail.getQuantityF());
				}
				//Load date to row
				rowFIFO.setDateRecord(prevDate);
				//After load local and inter to set invoice quantity 
				rowFIFO.setInvoiceQuantity(invoiceForFIFO.getQuantity());
				
				if(rowFIFO.getLocalQuantity() != -1 && invoiceForFIFO.getQuantity()>0){ 
					while(invoiceForFIFO.getQuantity() <= rowFIFO.getLocalQuantity()){
						FifoRowDetail tmp = new FifoRowDetail();
						tmp.setDateRecord(rowFIFO.getDateRecord());
						tmp.setInterQuantity(0.0);
						tmp.setLocalQuantity(invoiceForFIFO.getQuantity());
						tmp.setInvoiceBalance((double) 0);
						tmp.setInvoiceName(invoiceForFIFO.getName());
						fifoRowDetailsList.add(tmp);
						rowFIFO.setLocalQuantity(rowFIFO.getLocalQuantity() - invoiceForFIFO.getQuantity());
						invoiceForFIFO.setQuantity(0.0);
						if(invoiceForFIFO.getQuantity()<=0)//Invoice empty load new invoice
							if(invoiceIndex == invoiceList.size()) //Invoice empty
								break; //Go out loop
							else
								invoiceForFIFO = invoiceList.get(invoiceIndex++); // Load new invoice							
					}
					invoiceForFIFO.setQuantity(invoiceForFIFO.getQuantity()-rowFIFO.getLocalQuantity());
//					if(rowFIFO.getInterQuantity()==0 || rowFIFO.getLocalQuantity()==0){
//						rowFIFO = new FifoRowDetail();
//						continue;
//					}
				}
				
//				if(rowFIFO.getLocalQuantity() != -1 && invoiceForFIFO.getQuantity()>0){ 
//					if(invoiceForFIFO.getQuantity() < rowFIFO.getLocalQuantity()){
//						FifoRowDetail tmp = new FifoRowDetail();
//						tmp.setDateRecord(rowFIFO.getDateRecord());
//						tmp.setInterQuantity(rowFIFO.getInterQuantity());
//						tmp.setLocalQuantity(rowFIFO.getLocalQuantity());
//						tmp.setInvoiceBalance((double) 0);
//						tmp.setInvoiceName(invoiceForFIFO.getName());
//						fifoRowDetailsList.add(tmp);
//						if(invoiceForFIFO.getQuantity()<=0)//Invoice empty load new invoice
//							if(invoiceIndex == invoiceList.size()) //Invoice empty
//								break; //Go out loop
//							else
//								invoiceForFIFO = invoiceList.get(invoiceIndex++); // Load new invoice							
//					}
//					invoiceForFIFO.setQuantity(invoiceForFIFO.getQuantity()-rowFIFO.getLocalQuantity());
//				}
				
				if(rowFIFO.getInterQuantity() != -1 && invoiceForFIFO.getQuantity()>0){ 
					while(invoiceForFIFO.getQuantity() <= rowFIFO.getInterQuantity()){
						FifoRowDetail tmp = new FifoRowDetail();
						tmp.setDateRecord(rowFIFO.getDateRecord());
						tmp.setInterQuantity(invoiceForFIFO.getQuantity());
						tmp.setLocalQuantity(rowFIFO.getLocalQuantity());
						tmp.setInvoiceBalance((double) 0);
						tmp.setInvoiceName(invoiceForFIFO.getName());
						fifoRowDetailsList.add(tmp);
						rowFIFO.setInterQuantity(rowFIFO.getInterQuantity() - invoiceForFIFO.getQuantity());
						invoiceForFIFO.setQuantity(0.0);
						if(invoiceForFIFO.getQuantity()<=0)//Invoice empty load new invoice
							if(invoiceIndex == invoiceList.size()) //Invoice empty
								break; //Go out loop
							else
								invoiceForFIFO = invoiceList.get(invoiceIndex++); // Load new invoice							
					}
					invoiceForFIFO.setQuantity(invoiceForFIFO.getQuantity()-rowFIFO.getInterQuantity());
				}
	
				if(rowFIFO.getInterQuantity()==0)
					continue;
				rowFIFO.setInvoiceBalance(invoiceForFIFO.getQuantity()); //Get invoice balance from Current Invoice
				rowFIFO.setInvoiceName(invoiceForFIFO.getName());
//				if(invoiceForFIFO.getQuantity()<0){
//					if(invoiceIndex == invoiceList.size()) //Invoice empty
//						break; //Go out loop
//					else
//						invoiceForFIFO = invoiceList.get(invoiceIndex++); // Load new invoice
//				}
				fifoRowDetailsList.add(rowFIFO);
				rowFIFO = new FifoRowDetail();
			
		}
		
		for (FifoRowDetail fifoRowDetail : fifoRowDetailsList) {
			System.out.println(fifoRowDetail.toString());
		}
	}

	private double calculateBalanceInvoice(ArrayList<invoice> invoiceList){
		double sumBalance = 0;
		for (invoice invoice : invoiceList) {
			sumBalance += invoice.getQuantity();
		}
		return sumBalance;
	}
	
	private void processOutput(String sFileName){
		ArrayList<sellDetail> sum_allData = new ArrayList<>();
		sum_allData.addAll(sellInter);
		sum_allData.addAll(sum_sellLocal);
		Collections.sort(sum_allData);
//		for (sellDetail sellDetail : sum_allData) {
//			System.out.println(sellDetail);
//		}
		
		// >>>>>> Write File Out put <<<<<<<<<
		
		sellDetail prevRecord = null;
		Date prevDate = null;
		int col3null = 0;
		try
		{
		    FileWriter writer = new FileWriter(sFileName);
		    DateFormat df = new SimpleDateFormat("dd/MM/yy");
		    for (sellDetail recordDetail : sum_allData) {
		    	//Write Column 1
		    	if(prevDate==null || recordDetail.getSellDate().compareTo(prevDate)!=0? true:false){
					prevRecord = recordDetail;
					prevDate	=	recordDetail.getSellDate();
					if(col3null==1){
		    			writer.append("");
		    			writer.append('\n');
		    			col3null=0;
		    		}
//					writer.append('\n');
					writer.append(df.format(recordDetail.getSellDate()));
				    writer.append(',');
				}else{
					if(col3null!=1){
						writer.append(df.format(recordDetail.getSellDate()));
				    	writer.append(',');
					}
				}
		    	//Write Column 2,3
		    	if(recordDetail.getRegionFlg()==0){ // write to column 2
		    		writer.append(recordDetail.getQuantityF().toString());
				    writer.append(',');
				    col3null = 1;
		    	}else if(recordDetail.getRegionFlg()==1){ // write to column 3
		    		if(col3null==0){
		    			writer.append("");
		    			writer.append(',');
		    		}
		    		writer.append(recordDetail.getQuantityF().toString());
		    		col3null=0;
		    	}
		    	if(col3null==0)
		    		writer.append('\n');
			}
				
//		    writer.append("YOUR NAME");
//		    writer.append(',');
//		    writer.append("29");
//		    writer.append('\n');
				
		    //generate whatever data you want
				
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
		
		for (sellDetail sellDetail : sum_allData) {
			System.out.println(sellDetail);
		}
		
		System.out.println("End Process");
	}
	
	private void sumSellLocal(){
		sellDetail prevRecord = null;
		Date prevDate = null;
		for (sellDetail recordDetail : sellLocal) {
			
			//not equal
			if(prevDate==null || recordDetail.getSellDate().compareTo(prevDate)!=0? true:false){
				prevRecord = recordDetail;
				prevDate	=	recordDetail.getSellDate();
				sum_sellLocal.add(prevRecord);
			}else{
				prevRecord.setQuantity(prevRecord.getQuantity()+recordDetail.getQuantity());
				prevRecord.setQuantityF(prevRecord.getQuantityF()+recordDetail.getQuantityF());
			}
		}
	}
	
	public void readCVS(String filepath,ArrayList<sellDetail> dataList,int flg) throws NumberFormatException, ParseException {

//		String csvFile = "/Users/Earther/Desktop/inter.csv";
		String csvFile = filepath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] record = line.split(cvsSplitBy);
				dataList.add(new sellDetail(Integer.parseInt(record[0]), record[1], record[2], record[3], Double.parseDouble(record[4]), Double.parseDouble(record[5]), flg));
//				System.out.print(">");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	  }
	
	private void readCSV_Oil_Input(String filepath,ArrayList<invoice> oilLotList){
		
		String csvFile = filepath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		System.out.println("Start Read Oil Input");
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] record = line.split(cvsSplitBy);
				oilLotList.add(new invoice(Integer.parseInt(record[2]), record[0], Double.parseDouble(record[1])));
//				System.out.print(">");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("End Read Oil Input");
	  
	}
}
