import java.util.LinkedList;
import java.util.Scanner;

public class Editor{
  LinkedList data = new LinkedList();
  public Editor(){
    askForText();
  }//end of editor constructor
  
  public void askForText(){
    Scanner getInput = new Scanner(System.in);     //call scanner
    
    while(getInput.hasNext()){
      data.add(getInput.nextLine());
      //System.out.println(data);
      if(getInput.hasNext("$")){
        System.out.println(data);
      }
    }
    
  }
  
  public static void main(String args[]) {
    new Editor();
  }//end of main
}