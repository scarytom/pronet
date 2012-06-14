package com.scarytom;

import com.scarytom.pronet.Programmer;

public class NetworkBuilder {
	private Programmer _programmer;

	public Network build() {
		Network network = new Network(_programmer);
		return network;

	}

	public NetworkBuilder withProgrammer(final Programmer programmer) {
		_programmer = programmer;
		return this;
	}
}
