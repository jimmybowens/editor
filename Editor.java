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
 public void insert(String token, LinkedList data){
  System.out.println("TODO");
 }
 
 public void getInput(){
  Scanner getTextInput = new Scanner(System.in);
  String token = getTextInput.next();
  if (token.equalsIgnoreCase("$")){
   token = getTextInput.next();
   if(token.equalsIgnoreCase("insert")){
    insert(token, data);
    getInput();
   }
   else if(token.equalsIgnoreCase("delete")){
    insert(token, data);
    getInput();
   }
   
  }
  else{
   System.out.println("Please enter a '$' followed by a command.");
   getInput();
  }
 }

 public static void main(String[] args) {
  System.out.println("Welcome to the Editor");
  new Editor();
 }

}
