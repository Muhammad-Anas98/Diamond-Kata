package com.example.playground.service;

import com.example.playground.exception.InvalidInputException;

public class DiamondService {

    private static final Character BASE_CHAR = 'A';
    private final String input;

    public DiamondService(String input) {
        this.input = input;
    }

    public void printDiamond() { // Time Complexity O(k + k) -> O(k) where k is the count of characters to process. Space complexity is O(1).
        validateInput(input);

        Character c = input.charAt(0);
        int charCount = (c - BASE_CHAR) + 1;
        char currentCharacter = BASE_CHAR;

        for (int i = 0; i < charCount; i++) { // first half of the diamond
            currentCharacter = (char) (BASE_CHAR + i);
            printDiamondLine(currentCharacter, i, charCount);
        }

        for (int i = charCount - 2; i >= 0; i--) { // second half of the diamond (Logic implemented without using extra space(array/list))
            currentCharacter = (char) (currentCharacter - 1);
            printDiamondLine(currentCharacter, i, charCount);
        }
    }

    public void printDiamondLine(Character c, int index, int charCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, charCount - index))); // initial spaces
        sb.append(c); // first character

        if (c != BASE_CHAR)
        {
            sb.append(" ".repeat(Math.max(0, 2 * index - 1))); // in between characters spaces
            sb.append(c); // second character
        }

        System.out.println(sb);
    }

    public void validateInput(String c){
        if (c == null || c.length() != 1) {
            throw new InvalidInputException("Input must be a single character.");
        }

        char inputChar = c.charAt(0);
        if (!Character.isUpperCase(inputChar)) {
            throw new InvalidInputException("Input must be an uppercase alphabetic character.");
        }
    }
}
