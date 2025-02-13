/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordcount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author dungvnzx1
 */
public class word {

    private Map<String, Integer> wordCount = new HashMap<>();
    private Map<Character, Integer> charCount = new HashMap<>();
    
    String wordOutPut =""; 
    String charOutPut  = ""; 
    
    // tao ten ti 
    public void count() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(input);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

            for (char c : word.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("Word counts: " + wordCount);
        System.out.println("Character counts: " + charCount);
    }

 
        

    }


