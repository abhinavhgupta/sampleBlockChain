package com.sample.blockchain;

import java.util.Arrays;

public class Block {
	private int previousHash;
	private int blockHash;
	private String[] transactions;

	public Block(int previousHash, String[] transactions) {
		this.previousHash = previousHash;
		this.transactions = transactions;

		Object[] content = { Arrays.hashCode(transactions), previousHash };
		this.blockHash = Arrays.hashCode(content);
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public int getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(int blockHash) {
		this.blockHash = blockHash;
	}

	public String[] getTransactions() {
		return transactions;
	}

	public void setTransactions(String[] transactions) {
		this.transactions = transactions;
	}

}
