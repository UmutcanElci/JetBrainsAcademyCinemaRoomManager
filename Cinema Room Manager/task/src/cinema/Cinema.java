package cinema;

import java.util.Scanner;

public class Cinema {
    public static int row;
    public static int col;
   public static int sitrow = 0;
    public static int sitcol = 0;
    public static int total = 0;
    public  static int totalTickets = 0;
    public static  float percentage;
    public static  int sale = 0;
    public static float money;
    public static void main(String[] args) {
        // Write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        row = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        col = input.nextInt();
        total = row * col;

        String number1 = " 123456789";
        String number2 = " 123456789";
        char[][] a = new char[row+1][col+1];
        for (int i = 0; i <col+1;i++){
            a[0][i] = number1.charAt(i);
        }
        for (int i = 0; i <row+1;i++){
            a[i][0] = number2.charAt(i);
        }

        for(int i = 1; i<row+1;i++){
            for (int j = 1; j<col+1; j++){
                a[i][j] = 'S';
            }
        }

        float front,back;
        float frontprice = 10;
        float backprice = 8;
        if(total > 60 ){
            if(row % 2 == 1){
                front = ((row-1)/2)*col;
                back = ((row+1)/2)*col;
                money = (front*frontprice)+(back*backprice);
            }
            else{
                front = row /2;
                back = row /2;
                money = (front*frontprice)+(back*backprice);
            }

        }
        else{
            money =(row*col) *frontprice;
        }
        while(true){
            int s;
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            s = input.nextInt();
            if(s == 1){
                System.out.println("Cinema:");
                showTheSeats(a);
            }
            else if(s == 2){
                while(true) {
                        System.out.println("Enter a row number:");
                        sitrow = input.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        sitcol = input.nextInt();
                    if (sitrow > row || sitcol > col) {
                        System.out.println("Wrong input!");
                    }
                    else if(a[sitrow][sitcol] == 'B'){
                        System.out.println("That ticket has already been purchased!");
                    }
                    else {
                        calculatingTickets(sitrow,sitcol);
                        calculatingPercent();
                        a[sitrow][sitcol] = 'B';
                        break;
                    }
                }

            }
            else if (s == 3){
                System.out.println("Number of purchased tickets: "+sale);
                String str = String.format("Percentage: %.2f%%",percentage);
                System.out.println(str);
                System.out.println("Current income:  $"+totalTickets);
                String str2 = String.format("Total income: $%.0f",money);
                System.out.println(str2);
            }
            else{
                break;
            }
        }

    }

    public static void showTheSeats(char[][] a) {
        for (int i = 0; i < row+1; i++) {
            for (int j = 0; j < col+1; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void calculatingTickets(int row,int col){
        int frontprice = 10;
        int backprice = 8;
        int frontrow = row;
        int backrow = row;

        int sum = 0;
        if (total > 60){
            if(total % 2 ==1){
                if(sitrow == 1 ||sitrow ==2 || sitrow == 3 || sitrow == 4){
                    sum = frontprice;
                    totalTickets += sum;
                    sale++;
                }
                else {
                    sum = backprice;
                    totalTickets += sum;
                    sale++;
                }
            }
        }
        else{
            sum = frontprice;
            totalTickets += sum;
            sale++;
        }
        System.out.println("Ticket price: $"+sum  );
    }
    public static void calculatingPercent(){
        float front,back;
        float frontprice = 10;
        float backprice = 8;
        float point1 = sale;
        float point2 = total;
        if(total > 60 ){
            if(row % 2 == 1){
                front = ((row-1)/2)*col;
                back = ((row+1)/2)*col;
                money = (front*frontprice)+(back*backprice);
                percentage = (point1 / point2)*100;
            }
            else{
                front = row /2;
                back = row /2;
                money = (front*frontprice)+(back*backprice);
                percentage = (point1 / point2)*100;
            }

        }
        else{
            money =(row*col) *frontprice;
            percentage = (point1 / point2)*100;
        }
    }
}