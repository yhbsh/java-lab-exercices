import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");

    final Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    final int number = scanner.nextInt();

    System.out.print("Enter a character: ");
    final char character = scanner.next().charAt(0);

    scanner.close();

    char curr = character;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        final boolean condition = i == 0 || i == number - 1 || j == 0 || j == number - 1;
        if (condition)
          curr = character;
        else
          curr = ' ';

        System.out.print(curr);
      }

      System.out.println();

      // if (i == 0 || i == number - 1) {
      // for (int j = 0; j < number; j++) {
      // System.out.print(character);
      // }
      // } else {
      // System.out.print(character);
      // for (int j = 1; j < number - 1; j++) {
      // System.out.print(" ");
      // }
      // System.out.print(character);
      // }
      // System.out.println();
    }
  }
}
