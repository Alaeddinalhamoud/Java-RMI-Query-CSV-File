package model;

import java.io.Serializable;

public class HousesPrices implements Serializable {

	//this class to set and get the HousePrice data and print it.
		//its Serializable coz of shared with the Interfaces.. at same time saver need it to pass the data using this class
	private static final long serialVersionUID = 1L;
	
	private int PRICE;
	private String  YEAR;
	private String POSTCODE;
	
	public HousesPrices() {
		
	}
	public HousesPrices(int Price,String Year,String PostCode) {
		this.PRICE=Price;
		this.YEAR=Year;
		this.POSTCODE=PostCode;
	}

	@Override
	public String toString() {
		return "House Price [Price: " + PRICE + ", Year: " + YEAR + ", PostCode: "
				+ POSTCODE +"]";
	}
	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getYEAR() {
		return YEAR;
	}

	public void setYEAR(String year) {
		YEAR = year;
	}

	public String getPOSTCODE() {
		return POSTCODE;
	}

	public void setPOSTCODE(String pOSTCODE) {
		POSTCODE = pOSTCODE;
	}



	
}
