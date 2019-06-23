package com.sapient.reader;

public class TransactionReaderFactory {

	/**
	 * factory method that takes name of fileFormat as input and returns the corresponding fileReader object
	 * @param fileFormat
	 * @return TransactionReaderI
	 */
	public static TransactionReaderI getTransactionReaderInstance(String fileFormat) {
		synchronized (TransactionReaderFactory.class) {
			if (fileFormat.equalsIgnoreCase("CSV")) {
					return new CSVReader();
			} else if (fileFormat.equalsIgnoreCase("Excel")) {
				return new ExcelReader();
			} else if (fileFormat.equals("XML")) {
				return new XMLReader();
			} else {
				return null;
			}
		}
	}
}
