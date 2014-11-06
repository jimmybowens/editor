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
  data.add(getTextInput.nextLine());
 }
 
 public void delete(){}
 
 public void print(){
  if(data.size() == 0){
   System.out.println("You do not have any text in the file.");
  }
  else{
   for(int i = 0; i < data.size(); i ++){
    System.out.println(i + " "+ data.get(i));
   }
  }
 }
 
 public void getInput(){
  String token = getTextInput.next();
  if(token.equalsIgnoreCase("$insert")){
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
