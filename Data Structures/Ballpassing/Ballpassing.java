/**
 * Name         : Raymond Victorio Handoko
 * Matric. No   : A0187525W
 * PLab Acct.   : -
 */

import java.util.*;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Ballpassing {
	private void run() {

      Scanner sc = new Scanner(System.in);
      int numStudents = sc.nextInt();
		
      LinkedList<String> list = new LinkedList<String>();

      for(int i = 0; i<numStudents; i++){
         list.add(sc.next());
      }

      //Debug:
      //System.out.println("List : " + list);
 
      int numEvents = sc.nextInt();
      
      //iterator indexed before first student
      ListIterator<String> iterator = list.listIterator();
     
      String ballAt = iterator.next();
      //Debug:
      //System.out.println("first student with ball : " + ballAt);
  
      for(int i = 0; i<numEvents; i++){
         String event = sc.next();

         if(event.equals("NEXT")){
            if(iterator.hasNext()){
               ballAt = iterator.next();
               System.out.println(ballAt);
            }else{
               iterator = list.listIterator();
               ballAt = iterator.next();
               System.out.println(ballAt);
            }
         }

         if(event.equals("JOIN")){
            //Debug:
            //System.out.println("Enter person name: ");
            String name = sc.next();

            //inserts element immediately before element that would be returned by next(), 
            //or after the element that would be returned by previous()
            iterator.add(name);
            ballAt = iterator.previous();
            System.out.println(ballAt);
            iterator.next();
            //Debug
            //System.out.println(list);
         }

        if(event.equals("LEAVE")){
           iterator.previous();
           iterator.remove();
           
           if(iterator.hasNext()){
               ballAt = iterator.next();
               System.out.println(ballAt);
            }else{
               iterator = list.listIterator();
               ballAt = iterator.next();
               System.out.println(ballAt);
            }

      
        }  
      }
   }

  
	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
