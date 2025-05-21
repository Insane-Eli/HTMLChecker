import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html){
   if(html == null){
      throw new IllegalArgumentException();
   } else {
      tags = html;
   }
  }
  
  public Queue<HTMLTag> getTags(){
   return tags;  
  }
  
  public String toString(){
   String str = "";
   int size = tags.size();
   for(int i = 0; i < size; i++){
      HTMLTag temp = tags.remove();
      str += temp.toString().trim();
      tags.add(temp);
   }
   return str;
  }

  public void fixHTML(){
  
   // make a stack
   Stack<HTMLTag> stack = new Stack<HTMLTag>();   
   int size = tags.size();
   for(int i = 0; i < size; i++){ // go through every tag in the queue
   
      HTMLTag temp = tags.remove(); // take the tag out of the queue
      
      if(temp.isOpening()){
         stack.add(temp);
         tags.add(temp);         
      } else if (temp.isClosing() && !stack.empty()){ // closer
         
         if(temp.matches(stack.peek())){ // if the closer matches the opener at the top of the stack
            stack.pop(); // remove the tag from the stack
            tags.add(temp); // add the closer to the queue
         } else { //if it doesn't
            tags.add(stack.pop().getMatching()); // add the closer yourself and pop the stack
         }
         
      } else if (temp.isSelfClosing()){
         tags.add(temp);
      }
    }
    
    size = stack.size();
    for(int i = 0; i < size; i++){
      tags.add(stack.pop().getMatching());
    }
   }

}
