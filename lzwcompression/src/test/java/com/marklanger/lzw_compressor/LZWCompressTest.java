package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;

public class LZWCompressTest {
    private LZWCompress lzwCompress;
    String input;

    @Before
    public void setUp () {
        lzwCompress = new LZWCompress();
        input = "ABABYUHABSLKBHJKHJHIUGGGIUGSIXJISJKMINIONCIONOINNKLNLKNLMLKMIOJISIHCUHIJXNZJ";
    }
    @Test
    public void test() {
        String output = lzwCompress.main(input);
        System.out.print(output + "\n");
        output = output.replaceAll(",", "");
        System.out.print(output + "\n");
        System.out.print(input + "\n");
        boolean correct = output.matches(input);
        System.out.print("Output matches input: " + String.valueOf(correct));
    }
}
