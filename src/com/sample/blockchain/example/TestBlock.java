package com.sample.blockchain.example;

public class TestBlock {

	public static void main(String[] args) {
		BlockUtils blockUtils = new BlockUtils();
		blockUtils.addBlock("100");
		blockUtils.addBlock("400");
		blockUtils.addBlock("300");
		blockUtils.addBlock("200");
		System.out.println(blockUtils.isChainValid());
		blockUtils.getBlockChain().get(2).setData("500");
		System.out.println(blockUtils.isChainValid());
	}

}
