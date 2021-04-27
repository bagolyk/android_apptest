package com.example.neptunname;

public class NeptunChanger {
    public String neptunIdchanger(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            // My neptun: K9 PG L0
            switch(currentChar) {
                case 'k':
                case 'K':
                    result.append('9'); break;
                case 'P':
                    result.append('G'); break;
                case 'p':
                    result.append('g'); break;
                case 'l':
                case 'L':
                    result.append('0'); break;
                default:
                    result.append(currentChar);
            }
        }
        return result.toString();
    }

    public int asciiSum(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i);
        }
        return result;
    }
}
