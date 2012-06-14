package com.scarytom;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;
import nu.xom.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ParseTest {

    @Test
    public void parse() throws IOException, ParsingException {
        File file = new File("src/main/resources/ProNet.xml");

        NetworkBuilder networkBuilder = new NetworkBuilder();
        Builder parser = new Builder();
        Document doc = parser.build(file);

        Element rootElement = doc.getRootElement();
        Elements programmers = rootElement.getChildElements();
        for (int i = 0; i < programmers.size(); i++) {
            Programmer programmer = new Programmer(programmers.get(i).getAttribute("name").getValue(), Sets.<String>newHashSet());
            networkBuilder.withProgrammer(programmer);
        }

        System.out.println(networkBuilder.build().printout());
    }
}
