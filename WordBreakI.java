/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbreak;

/**
 *
 * @author Siddharth
 */
public class WordBreakI {

    /**
     * @param word
     * @return 
     */
    
    public boolean dictionaryContains(String word)
    {
        String[] dictionary = {
            "on", "pin", "pins", "and", "sand", "need", "needles", 
            "apple", "pen", "applepen", "pine", "pineapple"
        };
        for (String dictionaryWord : dictionary) {
            if (word.equals(dictionaryWord)) {
                return true;
            }
        }
        return false;
    }
    
    public int wordBreak(String word, int size, int result)
    {
        for(int i = 1; i <= size; i ++)
        {
            String prefix = word.substring(0, i);
            if(dictionaryContains(prefix))
            {
                if(i == size)
                {
                    return ++result;
                }
                else
                {
                    result = wordBreak(word.substring(i, size), size-i, result);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String word = "onpinsandneedles"; // Coder Snack test case
        String word2 = "pineapplepenapple"; // Leet Code test case
        
        int wordResult = new WordBreakI().wordBreak(word, word.length(), 0);
        System.out.println(wordResult > 0);
        
        int word2Result = new WordBreakI().wordBreak(word2, word2.length(), 0);
        System.out.println(word2Result > 0);
    }
}