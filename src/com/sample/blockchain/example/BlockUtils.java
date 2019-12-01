package com.sample.blockchain.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlockUtils {
	private List<Block> blockChain = new ArrayList<Block>();

	public List<Block> getBlockChain() {
		return blockChain;
	}

	public void setBlockChain(List<Block> blockChain) {

		this.blockChain = blockChain;
	}

	public boolean isChainValid() {
		for (int index = 1; index < blockChain.size(); index++) {
			Block currentBlock = blockChain.get(index);
			Block previousBlock = blockChain.get(index - 1);
			if (!currentBlock.getBlockHash().equals(currentBlock.calculateHash())) {
				return false;
			}
			if (!currentBlock.getPreviousHash().equals(previousBlock.getBlockHash())) {
				return false;
			}
		}
		return true;
	}

	public void addBlock(String data) {
		Block previousBlock = getLatestBlock();
		Block newBlock = new Block(previousBlock.getIndex()+1, previousBlock.getBlockHash(), data);
		blockChain.add(newBlock);
	}

	private Block getLatestBlock() {
		if (blockChain.isEmpty()) {
			createGenesisBlock();
		}
		return blockChain.get(blockChain.size() - 1);
	}

	private void createGenesisBlock() {
		blockChain.add(new Block(0, "Hello", "0"));
	}

}
