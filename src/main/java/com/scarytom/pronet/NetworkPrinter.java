package com.scarytom.pronet;

import com.scarytom.NetworkBuilder;
import nu.xom.ParsingException;

import java.io.IOException;

public class NetworkPrinter {

    public static void main(String[] args) throws IOException, ParsingException {
        System.out.println(NetworkBuilder.buildNetwork(args[0]).build().printout());
    }
}
