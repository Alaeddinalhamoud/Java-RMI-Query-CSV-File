package queries;

import java.io.File;
import java.io.IOException;
 
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
 
import model.HousesPrices;

public class HousePriceQuery  extends AbstractQuery<HousesPrices> {

	//extent from AbstractQuery to get all the features from it
	//implament all the methods from Query and AbstractQuery.
	private static final long serialVersionUID = 1L;

	HousesPrices houseprice;//to save the data comes from the user
	
	public HousePriceQuery(String filename, HousesPrices obj) {
		super(filename, obj);
		this.houseprice=obj;
	}

	//execute the Query and return the data as Object[]
	@Override
	public Object[] execute() {
		List<HousesPrices> HousesPricesList = null;
		Object[] ResultHousesPricesList = null;

		HousesPricesList = GetDateFromFile(FileName);
	
		if(houseprice.getPRICE() !=0) {
			ResultHousesPricesList = HousesPricesList.stream().parallel()
					.filter(p -> p.getPRICE() == ((houseprice.getPRICE()))).toArray();
		}else if(houseprice.getYEAR() !=null) {
			ResultHousesPricesList = HousesPricesList.stream().parallel()
					.filter(p -> p.getYEAR().contains((houseprice.getYEAR()))).toArray();
		}else if(houseprice.getPOSTCODE() !=null) {
			ResultHousesPricesList = HousesPricesList.stream().parallel()
					.filter(p -> p.getPOSTCODE().contains((houseprice.getPOSTCODE()))).toArray();
		} 
		
			
		return ResultHousesPricesList;
	}

	//will return the data from csv file to be filtered in query
	@Override
	public HousesPrices create(String[] data) {
		
		int PRICE = Integer.parseInt(data[0]);
		String YEAR  = data[1];
		String POSTCODE = data[2];
		return new HousesPrices(PRICE, YEAR, POSTCODE);
	}
	//Store the data comes form csv file to the HousePrice class
	@Override
	public List<HousesPrices> GetDateFromFile(String FileName) {
		List<HousesPrices> CarFuelList = new ArrayList<>();

		File pathToFile = new File(FileName);

		try {

			CSVParser parser = CSVParser.parse(pathToFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
			for (CSVRecord csvRecord : parser) {

				String[] attributes = {  csvRecord.get(1), csvRecord.get(2), csvRecord.get(3)};
				HousesPrices NewHousePrices = create(attributes);
				CarFuelList.add(NewHousePrices);

			}
			parser.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return CarFuelList;
	}
	//implament print method
	@Override
	public void print(Object[] t) {
		 for(Object ob:t) {
	         	System.out.println(ob.toString());
	         }
		
	}

	 
	

}
