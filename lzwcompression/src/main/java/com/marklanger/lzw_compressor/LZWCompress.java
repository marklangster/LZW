package com.marklanger.lzw_compressor;

import java.util.HashMap;
import java.util.Map;

public class LZWCompress {
    private static final int ASCII_TABLE_INCREMENT_CONSTANT = 65; //static value used to populate our library
    // with ASCII table values.

    Map<String, Byte> encoderLibrary; //HashMap for storage. Since we are encoding, the String value is our key.
    StringBuilder encodedOutput = new StringBuilder(); //Output String

    public String main(String input) {
        encoderLibrary = initializeLibrary(); //Giving the encoder A-Z initialization from ASCII values

        Byte librarySize = 26; // Initial size of our HashMap + 1

        StringBuilder previousKeyToCompare = new StringBuilder(); //String to save most recent "found" value
        // in our table.

        for (int i = 0; i < input.length(); i++) { //For each iteration, we will check if that pattern is found.
            // If it is, we will check the next value. If it is not, we will save the value of the last found pattern to
            // our output and save the new pattern to our table.

            StringBuilder keyToCompare = new StringBuilder();
            keyToCompare.append(previousKeyToCompare.toString() + input.charAt(i));

            if (encoderLibrary.containsKey(keyToCompare.toString())) {
                previousKeyToCompare = keyToCompare;
            } else {
                addValueToOutput(previousKeyToCompare.toString());
                encoderLibrary.put(keyToCompare.toString(), librarySize);
                librarySize++;
                previousKeyToCompare = new StringBuilder();
                previousKeyToCompare.append(input.charAt(i));
            }
        }

        if (previousKeyToCompare.length() != 0) { //We now need to check if we have missed the end of our input
            // because the code had no determined if the
            // If we have, we will add any of the remaining "buffer" to our end result.

            addValueToOutput(previousKeyToCompare.toString());
        }
        return encodedOutput.toString();
    }

    private void addValueToOutput(String addCompressedValue) { //Automates the addition of new encoded items to our output
        if (encodedOutput.length() != 0) {
            encodedOutput.append(",");
        }
        encodedOutput.append(Integer.toBinaryString(encoderLibrary.get(addCompressedValue)));
    }

    private Map<String, Byte> initializeLibrary() { //Initializes our HashMap with uppercase ASCII characters.
        Map<String, Byte> initializationLibrary = new HashMap<String, Byte>();
        for (Byte i = 0; i < 26; i++) {
            initializationLibrary.put(String.valueOf(Character.toString((char) ((int) i
                    + ASCII_TABLE_INCREMENT_CONSTANT))), i);
        }
        return initializationLibrary;
    }
}
