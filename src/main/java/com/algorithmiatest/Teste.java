package com.algorithmiatest;

import com.google.gson.Gson;

public class Teste {

	public static void main(String[] args) {

		AlgorithmUtil algorithmUtil = new AlgorithmUtil();
		Gson gson = new Gson();

		Wikipedia w = gson.fromJson(algorithmUtil.getResultString("Teste"), Wikipedia.class);
		System.out.println(w.getTitle());

	}

}
