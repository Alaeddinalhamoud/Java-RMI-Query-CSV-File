package model;

import java.io.Serializable;

public class CarFuel implements Serializable  {
	//this class to set and get the Carfuel data and print it.
	//its Serializable coz of shared with the Interfaces.. at same time saver need it to pass the data using this class
	private static final long serialVersionUID = 1L;
	

	private String Year;
	private Double PumpPricePetrol;
	private Double PumpPriceDiesel;
	private Double DutyRatePetrol;
	private Double DutyRateDiesel;
	private Double VATRatePetrol;
	private Double VATRateDiesel;

	
	public CarFuel() {};
	public CarFuel(String year) {
		this.Year=year;
	};
	
	public CarFuel(String year,Double price) {
		this.Year=year;
		this.PumpPricePetrol=price;
	};
	
	
	public CarFuel(String year, Double PumpPricePetrol, Double PumpPriceDiesel, Double DutyRatePetrol,
			Double DutyRateDiesel, Double VATRatePetrol, Double VATRateDiesel) {
		this.Year = year;
		this.PumpPricePetrol = PumpPricePetrol;
		this.PumpPriceDiesel = PumpPriceDiesel;
		this.DutyRatePetrol = DutyRatePetrol;
		this.DutyRateDiesel = DutyRateDiesel;
		this.VATRatePetrol = VATRatePetrol;
		this.VATRateDiesel = VATRateDiesel;

	}

	public String getyear() {
		return Year;
	}

	public void setyear(String year) {
		this.Year = year;
	}

	public Double getPumpPricePetrol() {
		return PumpPricePetrol;
	}

	public void setPumpPricePetrol(Double pumpPricePetrol) {
		PumpPricePetrol = pumpPricePetrol;
	}

	public Double getPumpPriceDiesel() {
		return PumpPriceDiesel;
	}

	public void setPumpPriceDiesel(Double pumpPriceDiesel) {
		PumpPriceDiesel = pumpPriceDiesel;
	}

	public Double getDutyRatePetrol() {
		return DutyRatePetrol;
	}

	public void setDutyRatePetrol(Double dutyRatePetrol) {
		DutyRatePetrol = dutyRatePetrol;
	}

	public Double getDutyRateDiesel() {
		return DutyRateDiesel;
	}

	public void setDutyRateDiesel(Double dutyRateDiesel) {
		DutyRateDiesel = dutyRateDiesel;
	}

	public Double getVATRatePetrol() {
		return VATRatePetrol;
	}

	public void setVATRatePetrol(Double vATRatePetrol) {
		VATRatePetrol = vATRatePetrol;
	}

	public Double getVATRateDiesel() {
		return VATRateDiesel;
	}

	public void setVATRateDiesel(Double vATRateDiesel) {
		VATRateDiesel = vATRateDiesel;
	}

	@Override
	public String toString() {
		return "Car Fuel [Year: " + Year + ", Pump Price Petrol: " + PumpPricePetrol + ", Pump Price Diesel: "
				+ PumpPriceDiesel + ", Duty Rate Petrol: " + DutyRatePetrol + ", Duty Rate Diesel: " + DutyRateDiesel
				+ ", VAT Rate Petrol: " + VATRatePetrol + ", VAT Rate Diesel: " + VATRateDiesel + "]";
	}
}