
/**
 * Name         : Raymond Victorio Handoko
 * Matric. No   : A0187525W
 * PLab Acct.   : 
 */

import java.util.*;

public class Generate {
   private void run() {
      Scanner sc = new Scanner(System.in);
      String word = sc.next();
      boolean[] used = new boolean[word.length()];
      String curr = "";

      permute(curr, used, word);
      // list.sort((String a, String b) -> {
      // return a.compareTo(b);
      // });
      Collections.sort(list);

      for (int i = 0; i < list.size() - 1; i++) {
         System.out.println(list.get(i));
      }
      System.out.print(list.get(list.size() - 1));

      ArrayList<String> subsets = subset(word);
      // subsets.sort((String a, String b) -> {
      // return a.compareTo(b);
      // });
      Collections.sort(subsets);
      for (String s : subsets) {
         System.out.println(s);
      }
   }

   ArrayList<String> list = new ArrayList<String>();

   public void permute(String curr, boolean[] used, String word) {
      if (curr.length() == used.length) {
         // System.out.println(curr);
         list.add(curr);
         return;
      }

      for (int i = 0; i < word.length(); i++) {
         if (used[i]) {
            continue;
         }
         used[i] = true;
         permute(curr + word.charAt(i), used, word);
         used[i] = false;
      }
   }

   private ArrayList<String> subset(String s) {
      if (s.length() == 0) {
         ArrayList<String> answer = new ArrayList<>();
         answer.add("");
         return answer;
      }
      ArrayList<String> sub = subset(s.substring(1));
      ArrayList<String> answer = new ArrayList<>(sub);
      for (String x : sub) {
         answer.add(s.charAt(0) + x);
      }
      return answer;
   }

   public static void main(String[] args) {
      Generate newGenerate = new Generate();
      newGenerate.run();
   }
}
