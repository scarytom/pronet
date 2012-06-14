package com.scarytom;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ParseTest {

    @Test
    public void parse() throws IOException {
        File file = new File("src/main/resources/ProNet.xml");
        FileUtils.readFileToString(file);
        System.out.println(FileUtils.readFileToString(file));
    }
}
