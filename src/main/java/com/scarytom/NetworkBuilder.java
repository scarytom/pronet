package com.scarytom;

import java.util.Collections;

import com.scarytom.pronet.Programmer;

public class NetworkBuilder {
	private Programmer _programmer;

	public Network build() {
		Network network = new Network(_programmer);
		return network;

	}

	public NetworkBuilder withProgrammer() {
		_programmer = new Programmer("Bill", Collections.EMPTY_SET);
		return this;
	}
}
