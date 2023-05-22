package ceStock;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * Outputs to the console csv data that was parsed into a symbol table
 * 
 * @author CSIS2420 + mark gowarty-weinstock
 *
 */
public class StockApp {

	/**
	 * parses the string into a date
	 * 
	 * @param dateString - unformatted date string
	 * @return Date
	 */
	private static Date getDate(String dateString) {
		String[] dateItems = dateString.split("-");
		return new Date(Integer.parseInt(dateItems[1]), Integer.parseInt(dateItems[2]), Integer.parseInt(dateItems[0]));
	}

	/**
	 * inputs csv data into the symbol table
	 * 
	 * @param fileName - file to read from
	 * @param keyField - key for symbol table
	 * @param valField - value for symbol table
	 * @return
	 */
	private static ST<Date, Double> readCsv(String fileName, int keyField, int valField) {
		// symbol table
		ST<Date, Double> st = new ST<Date, Double>();
		In in = new In(fileName);

		// read in the data from csv file
		in.readLine(); // remove header

		while (in.hasNextLine()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			Date key = getDate(tokens[keyField]);
			Double val = Double.parseDouble(tokens[valField]);
			st.put(key, val);
		}

		return st;
	}

	// ----- Test Client ------
	public static void main(String[] args) {
		ST<Date, Double> st = readCsv("src/ceStock/Resources/AMZN.csv", 0, 4);

		System.out.println("Number of elements: " + st.size());
		System.out.println();

		Date oldestDate = st.min();
		System.out.format("A) Oldest closing price: " + oldestDate + " $%.2f", st.get(oldestDate));
		System.out.println();

		Date newestDate = st.max();
		System.out.format("B) Newest closing price: " + newestDate + " $%.2f", st.get(newestDate));
		System.out.println();

		System.out.format(
				"C) The closing price "
						+ (st.get(newestDate) - st.get(oldestDate) < 0 ? "decreased by" : "increased by") + " $%.2f",
				Math.abs(st.get(newestDate) - st.get(oldestDate)));
		System.out.println();

		Date date1 = new Date("08/31/2018");
		System.out.println();
		System.out.format("D) Closing price from " + date1 + ": $%.2f", st.get(date1));
		System.out.println();

		Date date2 = new Date("03/10/2020");
		System.out.format("E) Closing price from " + date2 + ": $%.2f", st.get(date2));
		System.out.println();

		System.out.format(
				"F) The price " + (st.get(date2) - st.get(date1) < 0 ? "decreased by" : "increased by") + " $%.2f",
				Math.abs(st.get(date2) - st.get(date1)));
		System.out.println();

		System.out.println();
		Date firstDayIn2019 = new Date("01/01/2019");
		System.out.format("G) First available closing price in 2019: " + st.ceiling(firstDayIn2019) + " $%.2f",
				st.get(st.ceiling(firstDayIn2019)));
		System.out.println();

		Date lastDayIn2020 = new Date("12/31/2020");
		System.out.format("H) Last available closing price in 2020: " + st.floor(lastDayIn2020) + " $%.2f",
				st.get(st.floor(lastDayIn2020)));
		System.out.println();
	}

}
