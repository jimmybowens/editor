package editor;

import java.util.*;

public class List<E>
{
 private Node<E> head;

 public List()
 {
  head = null;
 }
 
   public boolean empty()
   {
      return head == null;
   }
 
 public void addFirst(E item)
 {
  head = new Node<E>(item, head);
 }

 public E getFirst()
 {
  if(head == null) throw new NoSuchElementException();

  return head.data;
 }

 public E removeFirst()
 {
  E tmp = getFirst();
  head = head.next;
  return tmp;
 }
 
 public void addLast(E item)
 {
  if( head == null)
   addFirst(item);
  else
   addLast(head, item);
 }
 private void addLast(Node<E> node, E item)
 {
  if(node.next != null) addLast(node.next, item);
  else
   node.next = new Node<E>(item, null);
 }

   public String toString()
   {
      return toString(head);
   }
   private String toString(Node node)
   {
      if(node == null) return "";
      else
       return node.data + " " + toString(node.next);
   }

   public void insertAfter(E key, E toInsert)
   {
      insertAfter(head, key, toInsert);
   }

   public void insertAfter(Node<E> node, E key, E toInsert)
   {
      if(node == null)
         return;
      else
      if(node.data.equals(key))
         node.next = new Node<E>(toInsert, node.next);
      else
         insertAfter(node.next, key, toInsert);
   }

   public void insertBefore(E key, E toInsert)
   {
      head = insertBefore(head, key, toInsert);
   }

   public Node<E> insertBefore(Node<E> node, E key, E toInsert)
   {
      if(node == null)
         return null;
      else
      if(node.data.equals(key))
         return new Node<E>(toInsert, node);
      else
         node.next = insertBefore(node.next, key, toInsert);

      return node;
   }
 
   public void remove(E x)
   {
      head = remove(head, x);
   }
   private Node<E> remove(Node<E> node, E x)
   {
      if (node == null)
         throw new java.util.NoSuchElementException("cannot remove.");
      else
      if(node.data.equals(x))
         return node.next;
      else
         node.next = remove(node.next, x);

      return node;
   }
 
   public void removeAt(int p)
   {
      head = removeAt(p, head);
   }
   public Node<E> removeAt(int p, Node<E> node)
   {
      if(node == null)
         throw new java.util.NoSuchElementException("cannot remove.");
      else
      if(p == 0)
         return node.next;
      else
         node.next = removeAt(p-1, node.next);

      return node;
   }

 public List<E> clone()
 {
  List<E> twin = new List<E>();
  twin.head = cloneR(head);
  return twin;
 }
 private Node<E> cloneR(Node<E> p)
 {
  if(p == null)
   return null;
  else
   return new Node<E>(p.data, cloneR(p.next) );
 }

 public void removeAllGreaterItems(Comparable<E> keyItem)
 {
  head = removeAllGreaterItems(head, keyItem);
 }
 private Node<E> removeAllGreaterItems(Node<E> p, Comparable<E> key)
 {
  if(p == null) return null;
  else
  if(key.compareTo(p.data) < 0)
   return removeAllGreaterItems(p.next, key);
  else
   p.next = removeAllGreaterItems(p.next, key);
  return p;
 }

   public void removeAllLesserItems(Comparable<E> keyItem)
   {
      head = removeAllLesserItems(head, keyItem);
   }
   private Node<E> removeAllLesserItems(Node<E> p, Comparable<E> key)
   {
      if(p == null) return null;
      else
      if(key.compareTo(p.data) > 0)
         return removeAllLesserItems(p.next, key);
      else
         p.next = removeAllLesserItems(p.next, key);
      return p;
   }
 
 private static class Node<E>
 {
  private E data;
  private Node<E> next;

  public Node(E data, Node<E> next)
  {
   this.data = data;
   this.next = next;
     }
    }

 /*public static void main(String[] args)
   {
  List<String> list = new List<String>();
  list.addLast("m");
  list.addLast("i");
  list.addLast("s");
  list.addLast("t");
  list.insertBefore("l", "s");
  list.remove("s");
  System.out.println(list);
 }*/
}