package queries;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import commonscsv.org.apache.commons.csv.CSVFormat;
import commonscsv.org.apache.commons.csv.CSVParser;
import commonscsv.org.apache.commons.csv.CSVRecord;
import model.CarFuel;

 
//extent from AbstractQuery to get all the features from it
//implament all the methods from Query and AbstractQuery.
public class CarFuelQuery extends AbstractQuery<CarFuel>  {

	CarFuel carFuel;//to save the data comes from the user
	 
	 
	public CarFuelQuery(String filename, CarFuel obj) {
		super(filename, obj);
		// TODO Auto-generated constructor stub
		 this.carFuel=  obj;
	}


 
	private static final long serialVersionUID = 1L;

	 
 

  //execute the Query and return the data as Object[]
	@Override
	public Object [] execute() {

		List<CarFuel> CarFuelList = new ArrayList<>();
		Object[] ResultCarFuelList = null ;
		//read the data from the csv file.
		CarFuelList = GetDateFromFile(FileName);
		//first query to return the PumpPrice 
		if(carFuel.getPumpPricePetrol() !=null) {	
			ResultCarFuelList = CarFuelList.stream().parallel()
				.filter(p -> p.getPumpPricePetrol().equals(((carFuel.getPumpPricePetrol())))).toArray();
		}else if(carFuel.getyear() !=null) {
			//second query to return data by year
			ResultCarFuelList = CarFuelList.stream().parallel()
					.filter(p -> p.getyear().contains((carFuel.getyear()))).toArray();
		} 
		
		return ResultCarFuelList;
	}
//will return the data from csv file to be filtered in query
	@Override
	public List<CarFuel> GetDateFromFile(String FileName) {
		List<CarFuel> CarFuelList = new ArrayList<>();
		//read the file name 
		File pathToFile = new File(FileName);

		try {
            //read the data from csv file 
			CSVParser parser = CSVParser.parse(pathToFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
			for (CSVRecord csvRecord : parser) {

				String[] attributes = { csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3),
						csvRecord.get(4), csvRecord.get(5), csvRecord.get(6) };
				//store it in Carfuel class
				CarFuel NewCarFuel = create(attributes);
				CarFuelList.add(NewCarFuel);

			}
			parser.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return CarFuelList;
	}
	//Store the data comes form csv file to the CarFuel class
	@Override
	public CarFuel create(String[] data) {

		String Year = data[0];
		Double PumpPricePetrol = Double.parseDouble(data[1]);
		Double PumpPriceDiesel = Double.parseDouble(data[2]);
		Double DutyRatePetrol = Double.parseDouble(data[3]);
		Double DutyRateDiesel = Double.parseDouble(data[4]);
		Double VATRatePetrol = Double.parseDouble(data[5]);
		Double VATRateDiesel = Double.parseDouble(data[6]);

	
		return new CarFuel(Year, PumpPricePetrol, PumpPriceDiesel, DutyRatePetrol, DutyRateDiesel, VATRatePetrol,
				VATRateDiesel);
	}
	//implament print method
	@Override
	public void print(Object[] t) {
		 for(Object ob:t) {
	         	System.out.println(ob.toString());
	         }
		
	}
	 
 

	 

	 

	
	 
	 
	 
	 
}
