package editor;

class LinkedList{
 public Link firstLink; 
 public int size = 0;
 LinkedList(){
  firstLink = null;  
 }
 
 public int getSize(){
   int size = 0;
   Link currentLink = firstLink;
   while(currentLink != null){
     currentLink.index = size;
     currentLink = currentLink.next;
     size++;
   } 
   return size;
 }
 
 public boolean isEmpty(){
  return(firstLink == null);
 }
 
 //add to the back of the list
 public void add(String data){
  Link newLink = new Link(data);
  newLink.next = firstLink;
  firstLink = newLink;
  newLink.index = getSize();
 }
 
 
 //remove from the back of the list
 public Link remove(){
  Link linkReference = firstLink;
  if(!isEmpty()){
   firstLink = firstLink.next;
   size--;//important
  
  } else {
   
   System.out.println("Empty LinkedList"); 
  }
  return linkReference;
 }
 
 /*
 public void display(){
  Link theLink = firstLink;
  while(theLink != null){
   theLink.display();
   theLink = theLink.next;
  }
 }
 */
 
 //find a link based on its data
 public Link find(String data){
  Link theLink = firstLink;
  if(!isEmpty()){
   while(theLink.data != data){
    if(theLink.next == null){
     return null;
    } else {
     theLink = theLink.next;
    }
   }
  } else {
   System.out.println("Empty LinkedList");
  }
  return theLink; 
 }
 
 //return the link matching the index
 public Link getIndex(int index){
  Link theLink = firstLink;
  if(!isEmpty()){
   while(theLink.index != index){
    if(theLink.next == null){
     return null;
    } else {
     theLink = theLink.next;
    }
   }
  } else {
   System.out.println("Empty LinkedList");
  }
  return theLink; 
 }
 
 //remove the link matching the data
 public Link remove(String data){
  Link currentLink = firstLink;
  Link previousLink = firstLink;
  while(currentLink.data != data){
   if(currentLink.next == null){
    return null; 
   } else {
    previousLink = currentLink; 
    currentLink = currentLink.next;
   }
  }
  if(currentLink == firstLink){
   firstLink = firstLink.next;
  } else {
   System.out.println("FOUND A MATCH");
   System.out.println("currentLink: " + currentLink);
   System.out.println("firstLink: " + firstLink);
   previousLink.next = currentLink.next;
  }
  return currentLink;
 }
 
 public Link remove(int index){
	  Link currentLink = firstLink;
	  Link previousLink = firstLink;
	  while(currentLink.index != index){
	   if(currentLink.next == null){
	    return null; 
	   } else {
	    previousLink = currentLink; 
	    currentLink = currentLink.next;
	   }
	  }
	  if(currentLink == firstLink){
	   firstLink = firstLink.next;
	  } else {
	   System.out.println("FOUND A MATCH");
	   System.out.println("currentLink: " + currentLink);
	   System.out.println("firstLink: " + firstLink);
	   previousLink.next = currentLink.next;
	  }
	  return currentLink;
	 }
}