package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LZWFullCompressionTest {
    LZWCompress lzwCompress;
    LZWDecompress lzwDecompress;
    String input[];
    String fail[];

    @Before
    public void setUp() {
        input = new String[5];
        input[0] = "ABABYUHABSLKBHJKHJHIUGGGIUGSIXJISJKMINIONCIONOINNKLNLKNLMLKMIOJISIHCUHIJXNZJ";
        input[1] = "THEFLYINGDUTCHMAN";
        input[2] = "MARYPOPPINSANDTHESUPERCALIFRAGILISTEPEALODOCIOUSDAY";
        input[3] = "NOWTHISISASTORYALLABOUTHOWMYLIFEGOTFLIPPEDTURNEDUPSIDEDOWNANDIDLIKETOTAKEAMINUTEJUSTSITRIGHTTHERE" +
                "ILLTELLYOUHOWIBECAMETHEPRINCEOFATOWNCALLEDBELAIR";
        input[4] = "ABABABABAABABAABABABABAB";

        fail = new String[2];
        fail[0] = null;
        fail[1] = "";
    }

    @Test
    public void test() {
        for (String tests : input) {
            lzwCompress = new LZWCompress();
            lzwDecompress = new LZWDecompress();
            System.out.print(tests + "\n");
            String compressedOutput = lzwCompress.main(tests);
            String decompressedOutput = lzwDecompress.main(compressedOutput);
            System.out.print(decompressedOutput + "\n");
            System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(tests)) + "\n\n");

            assertEquals(tests, lzwDecompress.main(compressedOutput));
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void fails() {
        for (String tests : fail) {
            lzwCompress = new LZWCompress();
            lzwDecompress = new LZWDecompress();
            lzwCompress.main(tests);
            lzwDecompress.main(tests);
        }
    }

}
