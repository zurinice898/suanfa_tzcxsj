package com.ljw.第二章;

public class p80_二叉搜索树 {


	node insert(node root, int x){

		if(root.val == x){
			return root;
		}else if(root.val > x){
			if(root.right == null){
				root.setRight(new node(x, null, null));
				return root.right;
			}else{
				return insert(root.right, x);
			}
		}else{
			if(root.left == null){
				root.setLeft(new node(x, null, null));
				return root.left;
			}
			return insert(root.left, x);
		}
	}

	boolean find(node root, int x){
		if(root == null){
			return false;
		}
		if(root.val == x){
			return true;
		}else if(root.val < x){
			return find(root.left, x);
		}else{
			return find(root.right, x);
		}
	}

	node remove(node root, int x){
		if(root == null){
			return null;
		}

		if(root.val == x){
			node temp = new node(root.val, root.left, root.right);
			if(root.left == null){
				if(root.right == null){
					root = null;
					return null;
				}else{
					root.val = root.right.val;
				}
			}
			else if(root.left != null){
				if(root.left.right == null){
					root.val = root.left.val;
					root.left = root.left.left;
				}else{
					node max = root.left.right;
					while(max.right != null){
						max = max.right;
					}
					root.val = max.val;
					max = null;
				}
			}
			return temp;
		}else if(root.val  > x){
			return remove(root.left, x);
		}else{
			return remove(root.right, x);
		}
	}

	public static class node{
		int val;
		node left, right;

		public node(int val, node left, node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public node() {
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public node getLeft() {
			return left;
		}

		public void setLeft(node left) {
			this.left = left;
		}

		public node getRight() {
			return right;
		}

		public void setRight(node right) {
			this.right = right;
		}
	}
}
