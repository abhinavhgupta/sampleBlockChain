package com.sample.blockchain.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private String previousHash;
	private String blockHash;
	private int index;
	private long timestamp;
	private String data;

	public Block(int index, String previousHash, String data) {
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = System.currentTimeMillis();
		this.blockHash = calculateHash();
	}

	public String calculateHash() {
		String text = String.valueOf(index + previousHash + String.valueOf(timestamp) + String.valueOf(data));
		//System.out.println(text);
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte bytes[] = messageDigest.digest(text.getBytes());
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				builder.append('0');
			}
			builder.append(hex);
		}
		return builder.toString();
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
