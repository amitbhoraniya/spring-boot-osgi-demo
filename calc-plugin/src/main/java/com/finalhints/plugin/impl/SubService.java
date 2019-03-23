package com.finalhints.plugin.impl;

import com.finalhints.osgi.api.CalculatorService;

public class SubService implements CalculatorService {

	@Override
	public String name() {
		return "Subtraction";
	}

	@Override
	public int execute(int n1, int n2) {
		return n1 - n2;
	}

}
