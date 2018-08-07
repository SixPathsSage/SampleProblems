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
public class WordBreak {

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
    
    public void wordBreak(String word, int size, String result)
    {
        for(int i = 1; i <= size; i ++)
        {
            String prefix = word.substring(0, i);
            if(dictionaryContains(prefix))
            {
                if(i == size)
                {
                    System.out.println(result +" "+ prefix);
                }
                else
                {
                    wordBreak(word.substring(i, size), size-i, result + " " + prefix);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String word = "onpinsandneedles"; // Coder Snack test case
        String word2 = "pineapplepenapple"; // Leet Code test case
        
        new WordBreak().wordBreak(word, word.length(), "");
        
        new WordBreak().wordBreak(word2, word2.length(), "");
    }
    
}
