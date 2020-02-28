package com.ljw.第二章;

import java.util.HashMap;
import java.util.Map;

public class p118_素数判断 {

	public static void main(String[] args) {
		int n = 808912345;
		System.out.println(is_prime(n));
		Map<Integer,Integer> result = prime_factor(n);
		System.out.print(n +"= ");
		StringBuilder sb = new StringBuilder();
		for(Integer key : result.keySet()){
			for(int i = 0; i < result.get(key); i++){
				sb.append(key).append(" * ");
			}
		}
		sb.deleteCharAt(sb.length() - 2);
		System.out.print(sb.toString());
		System.out.println();
	}


	//素性测试
	static boolean is_prime(int n){
		for(int i = 2; i * i <= n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return n != 1;
	}

	//整数分解
	static Map<Integer, Integer> prime_factor(int n){
		Map<Integer, Integer> result = new HashMap<>();
		for(int i = 2; i * i <= n; i++){
			while(n % i == 0){
				result.put(i,result.get(i)== null ? 1 : result.get(i) + 1);
				n /= i;
			}
		}

		if(n != 1){
			result.put(n,1);
		}
		return result;
	}
}
