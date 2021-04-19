package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner =new Scanner(System.in);
        String[] input=null;
        String str="";


        int choise=8;
        while(true){
        menu();
        choise= scanner.nextInt();
            switch (choise){
                case 1: input=inputTaker();
                        bst.add(bst.root,new Patient(input[0],input[1],input[2],input[3],input[4]));
                        break;
                case 2: input=inputTaker();
                        bst.removeGiven(input);
                        break;
                case 3: bst.inorderTraversal(bst.root);
                        break;
                case 4: input=inputTaker();
                        str=  (bst.search(bst.root,input[0])!=null) ? (bst.search(bst.root,input[0])).data.toString(): "Given patient not found..";
                        System.out.println(str);
                        break;
                case 5: System.out.println("Enter patient name..");
                        scanner.nextLine();
                        str = scanner.nextLine();
                        bst.list(bst.root,str);
                        break;
                case 6: FileIO.write(bst.toString(bst.root));
                        break;
                case 7: FileIO.read(bst);
                        break;
                case 8:
                    return;
                default:
                    System.out.println("Wrong input try again...");
                    break;

            }
        }




    }

    public static String[] inputTaker(){
        Scanner scanner =new Scanner(System.in);
        String line="";
        System.out.println("Enter your input");
        line=scanner.nextLine();
        return line.split(",");
    }

    public static void menu() {
        System.out.println("HOSPITAL RECORDS\n" +
                "1. Add\n" +
                "2. Remove\n" +
                "3. Display\n" +
                "4. Search\n" +
                "5. List\n" +
                "6. Save\n" +
                "7. Load\n" +
                "8. Exit\n");
    }
}
