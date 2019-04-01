/**
 * Name         : Raymond Victorio Handoko
 * Matric. No   : A0187525W
 * PLab Acct.   : 
 */

import java.util.*;
import java.util.Scanner;

public class Censorship {
 private void run() {
  //implement your "main" method here
      Scanner sc = new Scanner(System.in);

      int numWords = sc.nextInt();
      String censoredWords [] = new String[numWords];
      
      for(int i = 0; i<numWords; i++){
         censoredWords[i] = sc.next();
      }
       
     // System.out.println(Arrays.toString(censoredWords));
    
      sc.nextLine();

      String sentence = sc.nextLine();

      //System.out.println(sentence);

      String wordsInSentence[] = sentence.split(" ");
      String censoredSentence[] = new String[wordsInSentence.length];

      for(int i = 0; i<wordsInSentence.length; i++){
         for(int j = 0; j<numWords; j++){
            if(censoredWords[j].equalsIgnoreCase(wordsInSentence[i])){
               for(int k = 0; k<wordsInSentence[i].length(); k++){
                 if(k==0){
                    //deletes the censored word and replaces the word with * first
                   censoredSentence[i] = "*";
                 } else {
                  censoredSentence[i] += "*";
                 }
               }
               break;
               //break so that when matching with other words, the censored word will remain asterisked
            }
            censoredSentence[i]=wordsInSentence[i];
         }
      }
      
      
      //PRINT
      for(int i = 0; i<censoredSentence.length-1;i++){
         System.out.print(censoredSentence[i] + " ");
      }
      System.out.println(censoredSentence[censoredSentence.length-1]);
   }


 public static void main(String[] args) {
  Censorship newCensorship = new Censorship();
  newCensorship.run();
 }
}
