package com.ice.meenal;

import java.math.BigDecimal;

public class TradeParser {
	
	/**
	 * Method used for parsing the given message and returning the trade object
	 * @param line
	 * @return Trade object
	 * @throws Exception
	 */
	public static Trade parse(String line) throws Exception {
		Trade trade = new Trade();
		int countP = 0,countT = 0,countI = 0;
		int totalCount =0;
		String[] fields = line.split(";");
		for(String field:fields) {
			if(field.toLowerCase().startsWith("i")) {
				countI++;
				trade.setIsin(field.substring(1, field.length()));
			}
			else if(field.toLowerCase().startsWith("p")) {
				countP++;
				trade.setPrice(new BigDecimal(field.substring(1, field.length())));
			}
			else if(field.toLowerCase().startsWith("t")) {
				countT++;
				trade.setType(Integer.parseInt(field.substring(1, field.length())));
			}

		}

		totalCount = countI+countP+countT;
		if(totalCount != 3) {
			throw new Exception("Incorrect fields are provided!");
		}

		return trade;
	}
}
