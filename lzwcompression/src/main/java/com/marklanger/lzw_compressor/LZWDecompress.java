package com.marklanger.lzw_compressor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LZWDecompress {
    private static final int ASCII_TABLE_INCREMENT_CONSTANT = 65; //static value used to populate our HashMap

    public String main(String input) {
        Map<Byte, String> decoderLibrary = initializeLibrary();
        Queue<String> encodedValues = new LinkedList<String>(Arrays.asList(input.split(",")));
        StringBuilder decompressedOutput = new StringBuilder();
        StringBuilder previouslyCheckedStr = new StringBuilder(decoderLibrary.get(Byte.parseByte(encodedValues.poll(), 2)));
        decompressedOutput.append(previouslyCheckedStr);
        Byte librarySize = 26;
        while (!encodedValues.isEmpty()) {
            StringBuilder valueStr = new StringBuilder();
            Byte encodedValue = Byte.parseByte(encodedValues.poll(), 2);
            if (decoderLibrary.containsKey(encodedValue)) {
                valueStr.append(decoderLibrary.get(encodedValue));
                decompressedOutput.append(decoderLibrary.get(encodedValue));
            } else {
                valueStr.append(previouslyCheckedStr + String.valueOf(previouslyCheckedStr.charAt(0)));
                decompressedOutput.append(valueStr);
            }
            decoderLibrary.put(librarySize, previouslyCheckedStr.toString() + valueStr.charAt(0));
            librarySize++;
            previouslyCheckedStr = valueStr;
        }
        return decompressedOutput.toString();
    }

    private Map<Byte, String> initializeLibrary() {
        Map<Byte, String> initializationLibrary = new HashMap<Byte, String>();
        for (Byte i = 0; i < 26; i++) {
            initializationLibrary.put(i, String.valueOf(Character.toString((char) ((int) i
                    + ASCII_TABLE_INCREMENT_CONSTANT))));
        }
        return initializationLibrary;
    }
}
