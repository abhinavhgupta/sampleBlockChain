package com.sample.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Main {

	List<Block> blockChains = new ArrayList<Block>();

	public static void main(String[] args) {
		String[] transaction1 = { "test 1 Block Chain", "chains", "bitcoins" };
		Block genesisBlock = new Block(0, transaction1);
		
		
		String[] transaction2 = { "test Block Chain", "chains", "bitcoins" };
		Block block2 = new Block(genesisBlock.getBlockHash(), transaction2);
		
		
		String[] transaction3 = { "test Block Chain", "chains", "bitcoins" };
		Block block3 = new Block(block2.getBlockHash(), transaction3);
		
		System.out.println("Genesis Block -> "+genesisBlock.getBlockHash());
		System.out.println("block2 -> "+block2.getBlockHash());
		System.out.println("block3 -> "+block3.getBlockHash());
	}

}
