# LZWCompression

Component compresses using the LZW compression algorithm. 

To run a test: gradle test

Space complexity:
In the worst case, there are no repeating patterns in our input and our output would be uncompressed. 
In this case, our worse space complexity would be O(n).

Time complexity:
Both our compression loop and our decompression loop run through the input once giving us approximately 
(removing constants) O(n) for both.

Assumptions:
- Since a single string of bits was discussed, I made the choice to output a single string of binary for my 
compression output.
- Because a byte array output was discussed as a real-world use, I used that as my variable choice for my 
encoding and decoding.
- Leading binary zeros seemed unnecessary so I left them out.
- I used "," to designate the end of one compression binary and start of the next. 


Items I would add:
What I have built works for inputs within specific tolerances. If I were to build this out fully I would:


- On the compression side, check to see if the input I was receiving was a capital letter.
- Make sure I didn't run over the byte max value as I am storing patterns.
- On decompression, check for values outside an appropriate range (largest possible pattern number by that point,
 cannot number cannot be negative).
- On decompression, check for non-binary inputs.