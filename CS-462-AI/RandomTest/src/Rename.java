import java.util.*;
import Copy.java;
public class Rename {
  /* Command:
             rename nameA nameB
             Action:
             Renames the file nameA to the file nameB.
             Use your classes Copy and Delete for this.
             Errors:
             The user enters:
             
rename              The names nameA and nameB are missing.
          When there is an error println a message and return (not exit).*/


  public Rename(String name) {
    f(name);
  }

  private void f(String name) {
      StringTokenizer tokenizer = new StringTokenizer(name); 
      String nameA = tokenizer.nextToken();
      String nameB = tokenizer.nextToken();
      new Copy(nameA, nameB);
      Delete(nameA);
  }
}