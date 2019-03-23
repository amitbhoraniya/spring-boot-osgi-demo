package com.finalhints.osgi.api.impl;

import com.finalhints.osgi.api.CalculatorService;

public class AddService implements CalculatorService {

	@Override
	public int execute(int n1, int n2) {
		return n1 + n2;
	}

	@Override
	public String name() {
		return "Addition";
	}

}
