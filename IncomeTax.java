package JAC444_CameronMah_Final;
//Cameron Mah
public class IncomeTax {

	private int filingStatus;   //var for filing status
	public int SINGLE_FILER;
	public int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW;
	public int MARRIED_SEPERATELY;
	public int HEAD_OF_HOUSEHOLD;
	
	int[] intervals2009 = new int[5];		//intervals for 2009
	int[] intervals2001 = new int[4];		//intervals for 2009
	double[] rates2009 = new double[6];	//rates for 2009
	double[] rates2001 = new double[5];	//rates for 2001
	double taxableIncome; //member var to track the user taxable income
	
	
	//member variables used in printing the tax tables, will be taken as a parameter in constructor
	double amountF, amountT;
	
	double incomeTax;	//member var for user income tax
	
	//no arg constructor
	public IncomeTax() {
		incomeTax = 0;
		filingStatus = 0;
		taxableIncome = 0;
		amountF = 0;
		amountT = 0;
		for(int i = 0; i < 5; i++) {
			intervals2009[i] = 0;
		}
		for(int i = 0; i < 4; i++) {
			intervals2001[i] = 0;
		}
		for(int j = 0; j < 6; j++) {
			rates2009[j] = 0;
		}
		for(int j = 0; j < 5; j++) {
			rates2001[j] = 0;
		}
	}
	
	/*overloaded constructor where I take filing status, taxable income, amount from and amount to
	 * as parameters, when selecting option 1 parameters af and at will initially have placeholder values of 0.
	 * when selection option 2 filingStatus and taxableIncome will initially have placeholder values of 0
	 */
	public IncomeTax(int x, double y, double af, double at) {
		amountF = af;
		amountT = at;
		filingStatus = x;
		taxableIncome = y;
		if(filingStatus == 0) {
			intervals2009[0] = 8350;
			intervals2009[1] = 33950;
			intervals2009[2] = 82250;
			intervals2009[3] = 171550;
			intervals2009[4] = 372950;
			
			intervals2001[0] = 27050;
			intervals2001[1] = 65550;
			intervals2001[2] = 136750;
			intervals2001[3] = 297350;
			
		}
		else if(filingStatus == 1) {
			intervals2009[0] = 16700;
			intervals2009[1] = 67900;
			intervals2009[2] = 137050;
			intervals2009[3] = 208850;
			intervals2009[4] = 372950;
			
			intervals2001[0] = 45200;
			intervals2001[1] = 109250;
			intervals2001[2] = 166500;
			intervals2001[3] = 297350;
		}
		else if(filingStatus == 2) {
			intervals2009[0] = 8350;
			intervals2009[1] = 33950;
			intervals2009[2] = 68525;
			intervals2009[3] = 104425;
			intervals2009[4] = 186475;
			
			intervals2001[0] = 22600;
			intervals2001[1] = 54625;
			intervals2001[2] = 83250;
			intervals2001[3] = 148675;
		}
		else if(filingStatus == 3) {
			intervals2009[0] = 11950;
			intervals2009[1] = 45500;
			intervals2009[2] = 117450;
			intervals2009[3] = 190200;
			intervals2009[4] = 372950;
			
			intervals2001[0] = 36250;
			intervals2001[1] = 93650;
			intervals2001[2] = 151650;
			intervals2001[3] = 297350;
		}
		rates2009[0] = 0.1;
		rates2009[1] = 0.15;
		rates2009[2] = 0.25;
		rates2009[3] = 0.28;
		rates2009[4] = 0.33;
		rates2009[5] = 0.35;
		
		rates2001[0] = 0.15;
		rates2001[1] = 0.275;
		rates2001[2] = 0.305;
		rates2001[3] = 0.355;
		rates2001[4] = 0.391;
		
	}
	//getters and setters for member variables
	int getFilingStatus() {
		return filingStatus;
	}
	void setFilingStatus(int x) {
		filingStatus = x;
	}
	
	double getTaxableIncome() {
		return taxableIncome;
	}
	void setTaxableIncome(double x) {
		taxableIncome = x;
	}
	

	
	
	
	
	//function to return income tax
	double getIncomeTax() {
		incomeTax = 0.0;
		double tempNum = taxableIncome;
		int bracket = 0;
		//for loop to determine what tax bracket income goes up to
		for(int i = 0; i < 5; i++) {
			if(taxableIncome >= intervals2009[i]) {
				bracket++;
			}
		}
		
		//for loop to determine income tax, iterates to bracket
		for(int j = 0; j <= bracket; j++) {
			if(tempNum >= intervals2009[j] && j == 0) {
				tempNum -= intervals2009[j];
				incomeTax += (intervals2009[j]*rates2009[j]);	
			}
			else if(tempNum < intervals2009[j] && j == 0) {
				incomeTax += (tempNum*rates2009[j]);
			}
			else if(tempNum >= intervals2009[j]-intervals2009[j-1]) {
				tempNum -= (intervals2009[j]-intervals2009[j-1]);
				incomeTax += ((intervals2009[j]-intervals2009[j-1])*rates2009[j]);
				
			}
			else if(tempNum < intervals2009[j]-intervals2009[j-1]) {
				incomeTax += (tempNum*rates2009[j]);
			}
			else if(bracket==5) {
				incomeTax += tempNum*rates2009[5];
			}
		}
		return incomeTax;
	}
	
	/*Similar function as my getIncomeTax except instead of using the member var taxableIncome I take taxableIncome as a 
	parameter and filing status as a parameter for 2009
	*/
	double getIncomeTaxForPrint2009(double x, int fStatus) {
		int status = fStatus;
		double incT = 0.0;
		double tempNum = x;
		int bracket = 0;
		
		if(fStatus == 0) {
			intervals2009[0] = 8350;
			intervals2009[1] = 33950;
			intervals2009[2] = 82250;
			intervals2009[3] = 171550;
			intervals2009[4] = 372950;
			
		}
		else if(fStatus == 1) {
			intervals2009[0] = 16700;
			intervals2009[1] = 67900;
			intervals2009[2] = 137050;
			intervals2009[3] = 208850;
			intervals2009[4] = 372950;
			
		}
		else if(fStatus == 2) {
			intervals2009[0] = 8350;
			intervals2009[1] = 33950;
			intervals2009[2] = 68525;
			intervals2009[3] = 104425;
			intervals2009[4] = 186475;
			
		}
		else if(fStatus == 3) {
			intervals2009[0] = 11950;
			intervals2009[1] = 45500;
			intervals2009[2] = 117450;
			intervals2009[3] = 190200;
			intervals2009[4] = 372950;
			
		}
		rates2009[0] = 0.1;
		rates2009[1] = 0.15;
		rates2009[2] = 0.25;
		rates2009[3] = 0.28;
		rates2009[4] = 0.33;
		rates2009[5] = 0.35;
		
		
		//for loop to determine what tax bracket income goes up to
		for(int i = 0; i < 5; i++) {
			if(x >= intervals2009[i]) {
				bracket++;
			}
		}
		
		//for loop to determine income tax, iterates to bracket
		for(int j = 0; j <= bracket; j++) {
			if(tempNum >= intervals2009[j] && j == 0) {
				tempNum -= intervals2009[j];
				incT += (intervals2009[j]*rates2009[j]);	
			}
			else if(tempNum < intervals2009[j] && j == 0) {
				incT += (tempNum*rates2009[j]);
			}
			else if(tempNum >= intervals2009[j]-intervals2009[j-1]) {
				tempNum -= (intervals2009[j]-intervals2009[j-1]);
				incT += ((intervals2009[j]-intervals2009[j-1])*rates2009[j]);
				
			}
			else if(tempNum < intervals2009[j]-intervals2009[j-1]) {
				incT += (tempNum*rates2009[j]);
			}
			else if(bracket==5) {
				incT += tempNum*rates2009[5];
			}
		}
		return incT;
	}
	
	
	/*Similar function as my getIncomeTax except instead of using the member var taxableIncome I take taxableIncome as a 
	parameter and filing status as a parameter for 2001
	*/
	double getIncomeTaxForPrint2001(double x, int fStatus) {
		int status = fStatus;
		double incT = 0.0;
		double tempNum = x;
		int bracket = 0;
		
		if(fStatus == 0) {
			intervals2001[0] = 27050;
			intervals2001[1] = 65550;
			intervals2001[2] = 136750;
			intervals2001[3] = 297350;
			
		}
		else if(fStatus == 1) {
			intervals2001[0] = 45200;
			intervals2001[1] = 109250;
			intervals2001[2] = 166500;
			intervals2001[3] = 297350;
			
		}
		else if(fStatus == 2) {
			intervals2001[0] = 22600;
			intervals2001[1] = 54625;
			intervals2001[2] = 83250;
			intervals2001[3] = 148675;
			
		}
		else if(fStatus == 3) {
			intervals2001[0] = 36250;
			intervals2001[1] = 93650;
			intervals2001[2] = 151650;
			intervals2001[3] = 297350;
			
		}
		rates2001[0] = 0.15;
		rates2001[1] = 0.275;
		rates2001[2] = 0.305;
		rates2001[3] = 0.355;
		rates2001[4] = 0.391;
		
		
		//for loop to determine what tax bracket income goes up to
		for(int i = 0; i < 4; i++) {
			if(x >= intervals2001[i]) {
				bracket++;
			}
		}
		
		//for loop to determine income tax, iterates to bracket
		for(int j = 0; j <= bracket; j++) {
			if(tempNum >= intervals2001[j] && j == 0) {
				tempNum -= intervals2001[j];
				incT += (intervals2001[j]*rates2001[j]);	
			}
			else if(tempNum < intervals2001[j] && j == 0) {
				incT += (tempNum*rates2001[j]);
			}
			else if(tempNum >= intervals2001[j]-intervals2001[j-1]) {
				tempNum -= (intervals2001[j]-intervals2001[j-1]);
				incT += ((intervals2001[j]-intervals2001[j-1])*rates2001[j]);
				
			}
			else if(tempNum < intervals2001[j]-intervals2001[j-1]) {
				incT += (tempNum*rates2001[j]);
			}
			else if(bracket==4) {
				incT += tempNum*rates2001[5];
			}
		}
		return incT;
	}
	
	
	//function to print the 2001 and 2009 tax tables
	void printTaxTables() {
		
		//Determining how many rows are in table(s)
		double rows = (amountT-amountF)/1000;
		int r = (int) rows; //Casting to int
		
		int tempNum = (int)amountF;
		//Displaying 2001 table
		System.out.println("2001 tax tables for taxable income from $"+amountF+" to $"+amountT);
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Taxable\t\tSingle\t\tMarried Joint\t\tMarried\t\tHead of");
		System.out.println("Income\t\t \t\tor Qualifying\t\tSeperate\ta House");
		System.out.println("\t\t\t\tWidow(er)");
		for(int i = 0; i < rows+1; i++) {
				System.out.println(tempNum+"\t\t"+getIncomeTaxForPrint2001(tempNum, 0)+"\t\t"+getIncomeTaxForPrint2001(tempNum, 1)+"\t\t\t"+getIncomeTaxForPrint2001(tempNum, 2)+"\t\t"+getIncomeTaxForPrint2001(tempNum, 3));
				tempNum += 1000;
		}
		System.out.println("\n\n");
		
		tempNum = (int)amountF;
		//Displaying 2009 table
		System.out.println("2009 tax tables for taxable income from $"+amountF+" to $"+amountT);
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Taxable\t\tSingle\t\tMarried Joint\t\tMarried\t\tHead of");
		System.out.println("Income\t\t \t\tor Qualifying\t\tSeperate\ta House");
		System.out.println("\t\t\t\tWidow(er)");
		for(int i = 0; i < rows+1; i++) {
			System.out.println(tempNum+"\t\t"+getIncomeTaxForPrint2009(tempNum, 0)+"\t\t"+getIncomeTaxForPrint2009(tempNum, 1)+"\t\t\t"+getIncomeTaxForPrint2009(tempNum, 2)+"\t\t"+getIncomeTaxForPrint2009(tempNum, 3));
			tempNum += 1000;
		}
	}

}
