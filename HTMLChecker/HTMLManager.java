import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html){
   if(html == null){
      throw new IllegalArgumentException();
   } else {
      this.tags = html;
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
      str += temp;
      tags.add(temp);
   }
   return str;
  }

  void fixHTML(){
   
  }

}
