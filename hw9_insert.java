/*
*   Carter Mooring
*   CSPC 321: Databases
*   hw9_insert.java
*   Nov. 30th, 2020
*
*   Description: This file will auto genereate insert statements for the 3 sql
                  files, each file has different amounts of statements and is
                  randomly populated.
*/

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.*;

public class hw9_insert {
  public static void main(String[] args) {
    int ten = 10000;
    int hun = 100000;
    int mil = 1000000;
    String Ten = "hw9-data-10000.sql";
    String Hun = "hw9-data-100000.sql";
    String Mil = "hw9-data-1M.sql";

    try {
      //Populate files
      insert(ten, Ten);
      insert(hun, Hun);
      insert(mil, Mil);

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  //Generates a random number between 12000 and 150000
  public static int randomSalary(){
    return (int) ((Math.random() * 138000) + 12000);
  }

  //Uses variables and randomSalary to populate the file and file size passed in
  public static void insert(int sqlSize, String file) throws IOException {
    int salary1;
    int salary2;
    int salary3;
    int salary4;
    int i1;
    int i2;
    int i3;
    String admin = "administrator";
    String eng = "engineer";
    String man = "manager";
    String sale =  "salesperson";

    //FileWriter to write to the files inserted
    FileWriter myWriter = new FileWriter(file);
    myWriter.write("INSERT INTO Employee VALUES \n");
    System.out.println("Successfully added INSERT statement for " + file + ". Now Adding VALUES...");

    //Population loop, jumps 4 spaces to maintain 25% per title
    for(int i = 1; i < sqlSize; i+=4){
      //Variables
      i1 = i + 1;
      i2 = i + 2;
      i3 = i + 3;
      salary1 = randomSalary();
      salary2 = randomSalary();
      salary3 = randomSalary();
      salary4 = randomSalary();

      //Write to file
      myWriter.write("(" + i + ", " + salary1 + ", '" + admin + "'), \n");
      myWriter.write("(" + i1 + ", " + salary2 + ", '" + eng + "'), \n");
      myWriter.write("(" + i2 + ", " + salary3 + ", '" + man + "'), \n");
      //This loop will print the last line with a semicolon or comma otherwise
      if(i3 == sqlSize){
        myWriter.write("(" + i3 + ", " + salary4 + ", '" + sale + "');");
      }else{
        myWriter.write("(" + i3 + ", " + salary4 + ", '" + sale + "'), \n");
      }
    }
    myWriter.close();
    System.out.println("Successfully populated INSERT of " + file + " with " + sqlSize + " values. \n");
  }

}
