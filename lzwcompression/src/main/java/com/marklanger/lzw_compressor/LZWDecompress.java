package com.marklanger.lzw_compressor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LZWDecompress {
    private static final int ASCII_TABLE_INCREMENT_CONSTANT = 65; //static value used to populate our HashMap

    public String main(String input) {
        Map<Byte, String> decoderLibrary = initializeLibrary(); //HashMap for storage of values.
        // Since we are now decoding, Bytes will be our key.
        Queue<String> encodedValues = new LinkedList<String>(Arrays.asList(input.split(","))); //I decided to go
        // with a queue here rather than track the index of the string array I was decoding.
        StringBuilder decompressedOutput = new StringBuilder(); //Our output holder

        checkForValidInput(input); //Checks for valid inputs

        StringBuilder previouslyCheckedStr =
                new StringBuilder(decoderLibrary.get(Byte.parseByte(encodedValues.poll(), 2))); //We know the
        // first input is not compressed so we can immediately take it out of the queue simpling later logic.

        decompressedOutput.append(previouslyCheckedStr); //Add our first letter to our output

        Byte librarySize = 26; //Initial HashMap size

        while (!encodedValues.isEmpty()) { //While our queue is not empty, we will check for whether we already have
            // decoded a value. We should be building our HashMap exactly the same way as the compress class does.

            StringBuilder valueStr = new StringBuilder();
            Byte encodedValue = Byte.parseByte(encodedValues.poll(), 2);

            if (decoderLibrary.containsKey(encodedValue)) { //Each time we find the correct key,
                // we add it to our output.
                valueStr.append(decoderLibrary.get(encodedValue));
                decompressedOutput.append(decoderLibrary.get(encodedValue));
            } else {
                valueStr.append(previouslyCheckedStr + String.valueOf(previouslyCheckedStr.charAt(0)));
                decompressedOutput.append(valueStr);
            }
            decoderLibrary.put(librarySize, previouslyCheckedStr.toString() + valueStr.charAt(0)); //We add each new
            // pattern to our HashMap.

            librarySize++;
            previouslyCheckedStr = valueStr;
        }
        return decompressedOutput.toString();
    }

    private void checkForValidInput(String input) { //Only checks for null or empty inputs
        if (input == null || input.length() == 0){
            throw new IllegalArgumentException("Input was either null or empty");
        }
    }

    private Map<Byte, String> initializeLibrary() { //Initializes our HashMap with uppercase ASCII characters.
        Map<Byte, String> initializationLibrary = new HashMap<Byte, String>();
        for (Byte i = 0; i < 26; i++) {
            initializationLibrary.put(i, String.valueOf(Character.toString((char) ((int) i
                    + ASCII_TABLE_INCREMENT_CONSTANT))));
        }
        return initializationLibrary;
    }
}
