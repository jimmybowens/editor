package editor;

import java.util.LinkedList;
import java.util.Scanner;

public class Editor {
 public static boolean run = true;
 @SuppressWarnings("rawtypes")
 public static LinkedList data = new LinkedList();
 public static Scanner getTextInput = new Scanner(System.in);
 public static Scanner insert = new Scanner(System.in);
 public Editor(){
  getInput();
 }
 
 @SuppressWarnings({ "rawtypes", "unchecked", "resource" })
 public void insert(){
  data.add(insert.nextLine());
 }
 
 public void delete(){}
 
 public void print(){
  String token = getTextInput.nextLine();
  System.out.println(token);
 }
 
 public void getInput(){
  String token = getTextInput.next();
  if(token.equalsIgnoreCase("$insert")){
   System.out.println("Enter text to insert");
   insert();
   getInput();
  }
  else if(token.equalsIgnoreCase("$delete")){
   insert();
   getInput();
  }
  else if(token.equalsIgnoreCase("$print")){
   print();
   getInput();
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
