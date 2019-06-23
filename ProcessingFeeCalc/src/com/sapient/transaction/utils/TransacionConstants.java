package com.sapient.transaction.utils;


public class TransacionConstants {
	public static enum transactionType{
		Buy{
			public String toString(){
				return "BUY";
			}
		}, Sell{
			public String toString(){
				return "SELL";
			}
		}, Deposit{
			public String toString(){
				return "DEPOSIT";
			}
		}, Withdraw{
			public String toString(){
				return "WITHDRAW";
			}
		};		
	}
	
	public enum PROCESSING_FEE {
		FIVEHUNDREAD(500), HUNDREAD(100), FIFTY(50), TEN(10);
		private int processingFee;

		PROCESSING_FEE(int processingFee) {
			this.processingFee = processingFee;
		}

		public int getFee() {
			return processingFee;
		}
	}
}
