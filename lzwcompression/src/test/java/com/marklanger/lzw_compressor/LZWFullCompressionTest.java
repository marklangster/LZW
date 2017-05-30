package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LZWFullCompressionTest {
    LZWCompress lzwCompress;
    LZWDecompress lzwDecompress;
    String input;

    @Before
    public void setUp () {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        input = "ABABYUHABSLKBHJKHJHIUGGGIUGSIXJISJKMINIONCIONOINNKLNLKNLMLKMIOJISIHCUHIJXNZJ";
    }
    @Test
    public void test() {
        System.out.print(input + "\n");
        String compressedOutput = lzwCompress.main(input);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        boolean correct = decompressedOutput.matches(input);
        System.out.print("Output matches input: " + String.valueOf(correct));
        assertEquals(input, lzwDecompress.main(compressedOutput));
    }

}
