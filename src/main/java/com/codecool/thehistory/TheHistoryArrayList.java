package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] newWords = text.split("\\s+");

        for (String word : newWords) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int[] indexes = getIndexesOfSentence(fromWords);
        ArrayList<String> newArray = new ArrayList<>();
        int i=0;
        for (int index : indexes) {
            while ( i<index)
                newArray.add(wordsArrayList.get(i++));
            for (int j=0;j<toWords.length;j++)
                newArray.add(toWords[j]);
            i+=fromWords.length;

        }

        while (i<wordsArrayList.size())
            newArray.add(wordsArrayList.get(i++));

        wordsArrayList = newArray;
    }


    public int[] getIndexesOfSentence(String[] sentence) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int i = 0;
        while (i<wordsArrayList.size()-(sentence.length-1)) {
            if (wordsArrayList.get(i).equals(sentence[0])) {
                int j = 0;
                while (j<sentence.length && wordsArrayList.get(i+j).equals(sentence[j]))
                    j++;
                if (j==sentence.length) {
                    indexes.add(i);
                    i += j;
                } else
                    i++;
            } else i++;

        }

        int[] res = new int[indexes.size()];
        for (i=0;i<res.length;i++)
            res[i] = indexes.get(i);

        return res;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
