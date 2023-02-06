
import java.util.Scanner;

public class lab2{
    
    private static final int MAX_LENGTH = 1024;
    private static String[] names = new String[MAX_LENGTH];
    private static int namesCount = 0;

      

  public static void main(String[] args) {
    int choice;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("1. Enter a name");
      System.out.println("2. Search for a name");
      System.out.println("3. Remove a name");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter a name: ");
          String name = scanner.next();
  
          // Validate name
          if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            break;
          }
          for (int i = 0; i < namesCount; i++) {
            if (names[i].equals(name)) {
              System.out.println("Error: Name already exists");
              break;
            }
          }
  
          // Add name
          names[namesCount++] = name;
          System.out.println("Name added successfully");
          break;
        case 2:
          System.out.print("Enter a name to search: ");
          String searchName = scanner.next();
  
          int index = -1;
          for (int i = 0; i < namesCount; i++) {
            if (names[i].equals(searchName)) {
              index = i;
              break;
            }
          }
  
          if (index == -1) {
            System.out.println("Error: Name not found");
          } else {
            System.out.println("Name found at index " + index);
          }
          break;
        case 3:
          System.out.print("Enter a name to remove: ");
          String removeName = scanner.next();
  
          int removeIndex = -1;
          for (int i = 0; i < namesCount; i++) {
            if (names[i].equals(removeName)) {
              removeIndex = i;
              break;
            }
          }
  
          if (removeIndex == -1) {
            System.out.println("Error: Name not found");
          } else {
            for (int i = removeIndex; i < namesCount - 1; i++) {
              names[i] = names[i + 1];
            }
            namesCount--;
            System.out.println("Name removed successfully");
          }
          break;
        case 0:
          System.out.println("Exiting program...");
          break;
        default:
          System.out.println("Error: Invalid choice");
      }
    } while (choice != 0);
  }
}
    


    

