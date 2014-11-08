package editor;
public class Link {
 public String data;
 public Link next;
 public int index = 0;
 public Link(String data){
  this.data = data;
 }
 public void display(){
  System.out.println(index + ": "+toString());
 }
 public String toString(){
  return data; 
 }
 
 public int index(){
   return this.index;
 }
 
}