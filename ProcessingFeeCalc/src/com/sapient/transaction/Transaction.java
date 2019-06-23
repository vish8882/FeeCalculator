package com.sapient.transaction;

public class Transaction {
	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private Double marketValue;
	private boolean priorityFlag;
	private int processingFee;
	
	public static class TransactionKey {
		private final String clientId;
		private final String securityId;
		private final String transactionDate;
		public TransactionKey(Transaction transaction) {
			this.clientId = transaction.getClientId();
			this.securityId = transaction.getSecurityId();
			this.transactionDate = transaction.getTransactionDate();
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
			result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
			result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof TransactionKey))
				return false;
			TransactionKey transaction = (TransactionKey) obj;
			if (clientId == null) {
				if (transaction.clientId != null)
					return false;
			} else if (!clientId.equals(transaction.clientId))
				return false;
			if (securityId == null) {
				if (transaction.securityId != null)
					return false;
			} else if (!securityId.equals(transaction.securityId))
				return false;
			if (transactionDate == null) {
				if (transaction.transactionDate != null)
					return false;
			} else if (!transactionDate.equals(transaction.transactionDate))
				return false;
			return true;
		}
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	public boolean isPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(boolean priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}
}
