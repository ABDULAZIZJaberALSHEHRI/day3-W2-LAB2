import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        //Question '1'
        System.out.println("Question '1'");
        System.out.println("-Find all of the longest word in a given dictionary.");
        String[] words = {"cat", "dog", "red", "is", "am"};

        int length_2 = 0;
        for (int i = 0; i < words.length; i++) {
            int length_1 = words[i].length();

            if (length_1 >= length_2) {
                length_2 = length_1;

                System.out.println("-" + words[i]);
            }


        }


        //Question '2'
        System.out.println("\nQuestion '2'");
        System.out.println("-Displays the number of occurrences of an element in the array.");

        int[] aryr = {1, 1, 1, 3, 3, 5};

        System.out.println("3 occurs " + occurence(aryr, 3) + " times");
        System.out.println("1 occurs " + occurence(aryr, 1) + " times");
        System.out.println("9 occurs " + occurence(aryr, 9) + " times");


        //Question '3'
        System.out.println("\nQuestion '3'");

        Integer arr_num[] = new Integer[]{1, 4, 17, 7, 25, 3, 100};
        System.out.println(Arrays.toString(arr_num));
        System.out.println("-Enter numbers of large numbers you want display.");

        int set_numbers = input.nextInt();
        if (set_numbers > arr_num.length) {
            System.out.println("''number you entered is bigger than the array lingth.''");
        } else {
            Arrays.sort(arr_num, Collections.reverseOrder());

            System.out.println(set_numbers + " largest elements of the said array are: ");
            for (int i = 0; i < set_numbers; i++) {
                System.out.print("'" + arr_num[i] + "'.");
            }
        }


        //Question 4
        System.out.println("\n\nQuestion '4'");
        int[] arr = {5, 4, 3, 2, 1};
        revers_array(arr);


        //Question 5
        System.out.println("\n\nQuestion '5'");
        int menu = 0;
        System.out.println("-To initialize the array please enter the array length: ");
        int arr_length = input.nextInt();
        int[] numbers_1 = new int[arr_length];
        int i =0;
        System.out.println("The array is initialized, now chose one of these options: ");
        do {
            System.out.println("\n1. Add elements in the array\n" +
                    "2. Display elements of an array\n" +
                    "3. Search the element within array\n" +
                    "4. Sort the array\n" +
                    "5. To Stop");
            menu=input.nextInt();

            if (menu == 1) {

                System.out.println("Enter integer element to add it in the array: ");
                int arr_add = input.nextInt();

                for (int j = 0; j <1 ; j++) {

                    numbers_1[i] = arr_add;
                    i++;
                }

            } else if (menu == 2) {
                for (int k:numbers_1) {
                    System.out.print("|" + k);
                }System.out.print("|");

            }else if (menu == 3){
                System.out.println("Enter the element to search it: ");
                int search = input.nextInt();
                for (int l = 0; l < numbers_1.length; l++) {
                    if (search == numbers_1[l]) {
                        System.out.println("The element found: " + numbers_1[l]);
                    }
                }

            }else if (menu == 4){

                Arrays.sort(numbers_1);
                for (int s:numbers_1){
                    System.out.print("|"+s);
                }System.out.print("|");
            }else if (menu > 5)System.out.println("incorrect number, try again please :");

            else System.out.println("Exit!");

        }while (menu !=5);




        //Question 6
        System.out.println("\nQuestion '6'");
        System.out.println("-The program will generate random numbers, define the numbers range and limit of generate: ");
        System.out.println("Enter the minimum value of the range: ");
        int min = input.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int max = input.nextInt();
        System.out.println("Enter the limit of random numbers generate : ");
        int limit = input.nextInt();

        randomNUM_generator(min, max, limit);


        //Question 7
        System.out.println("\nQuestion '7' ");
        System.out.println("-The password should contain capital and small latter's and special character and"
                +"\nmore than 8 characters to be strong."+
                "\nEnter a password: ");
        input.nextLine();
        String password = input.next();
        int points = 0;

        if (checkLength(password) == 3){
            points = 3;
        } else if (checkLength(password) == 2) {
            points = 2;
        }else {
            points = 0;
        }

        if (checkSpecialCharacters(password)==0){
        }else {
            points = points + 2;
        }


        if (checkUpperCaseLowerCase(password) == 3){
            points = points+3;
        }




        if (points >=8){
            System.out.println("Password is strong.");
        } else if (points >= 5 && points<8) {
            System.out.println("Password is moderately strong.");
        }else System.out.println("Password is weak.");

        System.out.println("points " + points);


        //Question 8
        System.out.println("\nQuestion '8'");

        System.out.println("-Enter the number you want to convert it to fibonacci: ");
        int number = input.nextInt();
        System.out.println("Fibonacci sequence with " + "'"+number+"'"+ " terms:");
        fibonacci(number);
    }
    // ----------------------- METHODS ------------------------
    //Question '2'
    public static int occurence(int numb[], int wanted_num) {
        int count_1 = 0;
        for (int k : numb) {
            if (k == wanted_num) {
                count_1++;


            }
        }
        return count_1;
    }



    //Question 4
    public static void revers_array(int[] arr){

        System.out.println("Original array:");
        for(int l:arr){
            System.out.print(l+",");
        }
        System.out.println("\nreversed array:");
        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]+",");
        }

    }



    //Question 6

    public static void randomNUM_generator(int min, int max, int limit){
        int numbers = 0;
        Random rand_num = new Random();

        for (int i = 0; i < limit; i++) {
            numbers = rand_num.nextInt((max - min) + 1 ) + min;
            System.out.println(numbers);
        }
    }
    //question 7

    //check the length of the password
    public static int checkLength(String pass){

        int point =0;
        if (pass.length()>=0 && pass.length()<=5){
            return point;
        }else if (pass.length()>=6 && pass.length()<=7){
            point = 2;
        }else point=3;
        return point;
    }

    //check if the password contain special characters
    public static int checkSpecialCharacters(String pass){
        int point =0;
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher SpecialCharacters = special.matcher(pass);

        boolean checkSpecial = SpecialCharacters.find();
        if (checkSpecial){
            point = 2;
        }else point=0;
        return point;
    }

    //check if the password contain both upper and lower case
    public static int checkUpperCaseLowerCase (String pass){
        int point =0;

        Pattern upper_case = Pattern.compile("[A-Z]");
        Matcher isUpper = upper_case.matcher(pass);

        boolean up_case = isUpper.find();

        Pattern lower_case = Pattern.compile("[a-z]");
        Matcher isLower = lower_case.matcher(pass);

        boolean low_case = isLower.find();

        Pattern upper_lower = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])");
        Matcher isUpper_lower = upper_lower.matcher(pass);
        boolean up_Low = isUpper_lower.find();

        if (up_Low){
            point=3;
        } else point =0;

        return point;
    }


    //Question 8
    public static void fibonacci(int number){
        int num_1 = 0;
        int num_2 = 1;
        int num_3 = 0;
        for (int i = 0; i < number; i++) {
            System.out.print(num_1+ " ");

            num_3 = num_1+num_2;
            num_1 = num_2;
            num_2 = num_3;
        }
    }




}