package com.scarytom;

import java.util.HashSet;
import java.util.Set;

import com.scarytom.pronet.Programmer;

public class NetworkBuilder {
	private final Set<Programmer> _programmer = new HashSet<Programmer>();

	public Network build() {
		Network network = new Network(_programmer);
		return network;

	}

	public NetworkBuilder withProgrammer(final Programmer programmer) {
		_programmer.add(programmer);
		return this;
	}
}
