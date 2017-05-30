package com.marklanger.lzw_compressor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LZWFullCompressionTest {
    LZWCompress lzwCompress;
    LZWDecompress lzwDecompress;
    String input[];

    @Before
    public void setUp () {
        input = new String[4];
        input[0] = "ABABYUHABSLKBHJKHJHIUGGGIUGSIXJISJKMINIONCIONOINNKLNLKNLMLKMIOJISIHCUHIJXNZJ";
        input[1] = "THEFLYINGDUTCHMAN";
        input[2] = "MARYPOPPINSANDTHESUPERCALIFRAGILISTEPEALODOCIOUSDAY";
        input[3] = "NOWTHISISASTORYALLABOUTHOWMYLIFEGOTFLIPPEDTURNEDUPSIDEDOWNANDIDLIKETOTAKEAMINUTEJUSTSITRIGHTTHERE" +
                "ILLTELLYOUHOWIBECAMETHEPRINCEOFATOWNCALLEDBELAIR";
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
            boolean correct = decompressedOutput.matches(tests);
            System.out.print("Output matches input: " + String.valueOf(correct));

            assertEquals(tests, lzwDecompress.main(compressedOutput));
        }
    }

}
