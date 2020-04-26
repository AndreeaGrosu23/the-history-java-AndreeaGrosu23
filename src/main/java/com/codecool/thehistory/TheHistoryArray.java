package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] newWords = text.trim().split("\\s+");
        String[] allWords = new String[newWords.length+wordsArray.length];

        for (int i=0; i<wordsArray.length; i++) {
            allWords[i] = wordsArray[i];
        }
        for (int i=wordsArray.length; i<allWords.length; i++) {
            allWords[i] = newWords[i-wordsArray.length];
        }

        wordsArray = new String[allWords.length];
        for (int i=0; i<allWords.length; i++) {
            wordsArray[i] = allWords[i];
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        String[] intermediaryArray = new String[wordsArray.length];

        int occurence = 0;

        for (int i=0; i<wordsArray.length; i++) {
            if (wordsArray[i].equals(wordToBeRemoved)) {
                occurence++;
            } else {
                intermediaryArray[i-occurence] = wordsArray[i];
            }
        }

        wordsArray = new String[intermediaryArray.length-occurence];
        for (int i=0; i<wordsArray.length; i++) {
            wordsArray[i] = intermediaryArray[i];
        }
    }

    @Override
    public int size() {
//        int number = wordsArray.length;
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int i=0; i<wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
