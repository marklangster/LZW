package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;

public class LZWDecompressTest {
    private LZWDecompress lzwDecompress;
    String input;

    @Before
    public void setUp () {
        lzwDecompress = new LZWDecompress();
        input = "0,1,11010,11000,10100,111,11010,10010,1011,1010,1,111,1001,1010,100101,111,1000,10100,110,101100," +
                "101010,110,10010,1000,10111,1001,1000,10010,100110,1100,1000,1101,1000,1110,1101,10,111010,1101,1110," +
                "111000,1101,1010,1011,1101,100010,1000101,1100,100010,110111,1110,110011,110000,111,10,11110,1000,1001," +
                "10111,1101,11001,1001";
    }
    @Test
    public void test() {
        System.out.print(lzwDecompress.main(input));
    }
}
