package com.scarytom;

import nu.xom.*;
import org.junit.Test;

import java.io.IOException;

public class ParseTest {

    @Test
    public void canParse() throws IOException, ParsingException {
        NetworkBuilder networkBuilder = NetworkBuilder.buildNetwork("src/main/resources/ProNet.xml");
        System.out.println(networkBuilder.build().printout());
    }

}
