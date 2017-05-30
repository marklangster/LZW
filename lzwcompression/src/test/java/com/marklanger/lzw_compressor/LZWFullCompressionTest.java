package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LZWFullCompressionTest {
    private LZWCompress lzwCompress;
    private LZWDecompress lzwDecompress;
    private String input[];
    private String fail[];

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
    public void test1() {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        System.out.print(input[0] + "\n");
        String compressedOutput = lzwCompress.main(input[0]);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(input[0])) + "\n\n");

        assertEquals(input[0], lzwDecompress.main(compressedOutput));
    }

    @Test
    public void test2() {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        System.out.print(input[1] + "\n");
        String compressedOutput = lzwCompress.main(input[1]);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(input[1])) + "\n\n");

        assertEquals(input[1], lzwDecompress.main(compressedOutput));
    }

    @Test
    public void test3() {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        System.out.print(input[2] + "\n");
        String compressedOutput = lzwCompress.main(input[2]);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(input[2])) + "\n\n");

        assertEquals(input[2], lzwDecompress.main(compressedOutput));
    }

    @Test
    public void test4() {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        System.out.print(input[3] + "\n");
        String compressedOutput = lzwCompress.main(input[3]);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(input[3])) + "\n\n");

        assertEquals(input[3], lzwDecompress.main(compressedOutput));
    }

    @Test
    public void test5() {
        lzwCompress = new LZWCompress();
        lzwDecompress = new LZWDecompress();
        System.out.print(input[4] + "\n");
        String compressedOutput = lzwCompress.main(input[4]);
        String decompressedOutput = lzwDecompress.main(compressedOutput);
        System.out.print(decompressedOutput + "\n");
        System.out.print("Output matches input: " + String.valueOf(decompressedOutput.matches(input[4])) + "\n\n");

        assertEquals(input[4], lzwDecompress.main(compressedOutput));
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
