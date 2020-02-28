package com.ljw.leetcode;

public class l链表中找单词 {
	public static void main(String[] args) {

		/**
		 * [["a","b"],["c","d"]]
		 * "abcd"
		 */
		char[][] board =
				{{'a','b'},
						{'c','d'},
						};
		String word = "abcd";
		System.out.println(new l链表中找单词().exist(board,word));
	}




	static char[][] copy;
	static char[] target;

	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0){
			return false;
		}
		if(word == null || word.equals("")){
			return false;
		}


		copy = new char[board.length][board[0].length];
		target = new char[word.length()];
		for(int i = 0; i < word.length(); i++){
			target[i] = word.charAt(i);
		}

		int startX  = 0;
		int startY = 0;
		boolean needGo = true;
		for(int i =0; i < board.length && needGo; i++){
			for(int j = 0; j < board[0].length; j++ ){
				if(board[i][j] == target[0]){
					startX = i;
					startY = j;
					copy[startX][startY] = 1;
					needGo = false;
					break;
				}
			}
		}
		if(needGo){
			return false;
		}

		return backTrack(board, startX, startY, 1, target);
	}

	boolean backTrack(char[][] board, int x, int y, int index, char[] target){
		if(index == target.length){
			return true;
		}
		int[] xShift = {1,0,-1, 0};
		int[] yShift = {0,-1,0, 1};

		for(int i = 0; i < xShift.length; i++){
			for(int j = 0; j < yShift.length; j++){
				int xTemp = x + xShift[i];
				int yTemp = y + yShift[j];


				if((0 <= xTemp && xTemp < board.length && 0 <= yTemp && yTemp < board[0].length) && (copy[xTemp][yTemp] != 1)){

					if(board[xTemp][yTemp] == target[index]){
						copy[xTemp][yTemp]  = 1;
						if(backTrack(board, xTemp, yTemp, index + 1, target)){
							return true;
						}else{
							copy[xTemp][yTemp]  = 0;
							continue;
						}
					}

				}
			}
		}
		return false;

	}
}
