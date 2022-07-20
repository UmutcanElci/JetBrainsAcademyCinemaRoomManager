import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
try {
    String string = scanner.nextLine();
    int index = scanner.nextInt();
    System.out.println(string.charAt(index));
}
catch (ArrayEm){
    System.out.println("Out of bounds!");
}

    }
}