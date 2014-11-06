package editor;

import java.util.LinkedList;
import java.util.Scanner;

public class Editor {
 public static boolean run = true;
 @SuppressWarnings("rawtypes")
 public static LinkedList data = new LinkedList();
 public Editor(){
  getInput();
 }
 
 @SuppressWarnings("rawtypes")
 public void insert(Scanner input, LinkedList data){
  System.out.println("TODO");
 }
 
 public void getInput(){
  Scanner getTextInput = new Scanner(System.in);
  boolean hasCommand = false;
  while(getTextInput.hasNext()){
   if(getTextInput.next().equalsIgnoreCase("$")){
    while(hasCommand != true){
     if(getTextInput.next().equalsIgnoreCase("insert")){
      insert(getTextInput,data);
      hasCommand = true;
      getInput();
     }
    }
   }
   System.out.println("Please enter a '$' followed by a command.");
   getInput();
  }
  
 }

 public static void main(String[] args) {
  System.out.println("Welcome to the Editor");
  new Editor();
 }

}
