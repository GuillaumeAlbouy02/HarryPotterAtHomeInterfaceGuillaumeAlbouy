package com.example.harrypotterathomeinterface.controller;



import com.example.harrypotterathomeinterface.controller.display.Display;

import java.io.File;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScanner {
    private Scanner sc;
    private Display ds;
    public SafeScanner(InputStream in, Display ds){
        this.sc = new Scanner(in);
        this.ds = ds;

    }


    public int getInt(){
        int result = 0;
        boolean inputValid=false;
        while (!inputValid)
        {
            try{
                ds.printText("Veuillez saisir un entier");
                result=this.sc.nextInt();

                inputValid=true;

            }
            catch (InputMismatchException e){
                this.sc.next();

            }
        }
        return result;

    }

    public int getInt2(String message){
        ds.printText(message);
        while(!sc.hasNextInt()){
            ds.printText(message);
            sc.next();
        }
        return sc.nextInt();
    }
    public String getString(String message){
        ds.printText(message);
        while(!sc.hasNextLine()){
            ds.printText(message);
            sc.next();
        }
        return sc.nextLine();
    }

public void closeScanner(){
        sc.close();
}


}


