/**
 * Name         :Raymond Victorio Handoko
 * Matric. No   :A0187525W
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {
	private void run() {
		Scanner sc = new Scanner(System.in);
      long N = sc.nextLong();
      int T = sc.nextInt();

      //Arithmetic
      if(T==1){
         long A = sc.nextLong();
         long D = sc.nextLong();
         for(long i = 0; i<N; i++){
            if(i<N-1){
            System.out.print(A);
            System.out.print(" ");
            } else {
               System.out.println(A);
            }

            A+=D;
         }

      //Geometric
      } else if(T==2){
         long X = sc.nextLong();
         long R = sc.nextLong();

         for(long i = 0; i<N; i++){
            if(i<N-1){
               System.out.print(X);
               System.out.print(" ");
            } else {
               System.out.println(X);
            }
            X*=R;
         }
   }

	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
      }
}
