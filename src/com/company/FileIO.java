package com.company;

import java.io.*;

public class FileIO {

    static File f= new File("src/com/company/test.txt");
    public static void read(BinarySearchTree bst) throws IOException {

        if(!f.exists())
            f.createNewFile();

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String input="";
        while((input= br.readLine())!=null){
            if(input.length()!=0){
                String[] line = input.split(",");
                bst.add(bst.root, (new Patient(line[0],line[1],line[2],line[3],line[4])));
            }

        }
        br.close();
        fr.close();

    }

    public static void write(String input) throws IOException {
        if(!f.exists())
            f.createNewFile();

        FileWriter fw= new FileWriter(f,true);
        BufferedWriter bw= new BufferedWriter(fw);
        bw.write(input);
        bw.close();
        fw.close();


    }


}
