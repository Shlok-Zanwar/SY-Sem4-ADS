import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentRecords {

    static boolean rollNumberExists(int rollNumber){
        String str;
        String [] nameRollNo;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
            str = reader.readLine();
            while(str != null){
                nameRollNo = str.split("!");
                if(nameRollNo.length == 2){
                    if(Integer.parseInt(nameRollNo[1]) == rollNumber){
                        reader.close();
                        return true;
                    }
                }
                str = reader.readLine();
            }

            reader.close();
        }
        catch (Exception e) {
        }

        return false;
    }


    static void addRecord(String name, int rollNo){
        try {
            boolean rollNoExists = rollNumberExists(rollNo);

            if(rollNoExists){
                System.out.println("\n        Roll number already exists.");
            }
            else{
                PrintWriter writer  = new PrintWriter(new FileOutputStream("StudentData.txt", true));
                writer.println(name + "!" + rollNo);
                System.out.println("\n        Record '" + name + " " + rollNo + "' added successfully");
                writer.close();
            }
        } 
        catch (Exception e) {
            System.out.println("    Couldnt add record. " + e.getMessage());
        }
    }


    static void deleteRecord(int rollNo){
        try {
            String str, finalStr = "";
            String [] nameRollNo;
            boolean found = false;

            BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
            str = reader.readLine();
            while(str != null){
                nameRollNo = str.split("!");
                if(nameRollNo.length == 2){
                    if(Integer.parseInt(nameRollNo[1]) != rollNo){
                        finalStr += str;
                        finalStr += "\n";
                    }
                    else{
                        found = true;
                    }
                }
                str = reader.readLine();
            }
            reader.close();

            PrintWriter writer  = new PrintWriter(new FileOutputStream("StudentData.txt"));
            writer.println(finalStr);
            writer.close();

            if(found){
                System.out.println("\n        Roll Number '" + rollNo + "' deleted successfully");
            }
            else{
                System.out.println("\n        Roll number dosent exist.");
            }

        }
        catch (Exception e) {
            System.out.println("    Couldnt delete record. " +  e.getMessage());
        }
        
    }


    static void searchRecord(String name, int rollNo){
        try{
            String str;
            String [] nameRollNo;
            boolean found = false;

            BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
            str = reader.readLine();
            
            while(str != null){
                nameRollNo = str.split("!");
                if(nameRollNo.length == 2){
                    if(Integer.parseInt(nameRollNo[1]) == rollNo || nameRollNo[0] == name){
                        System.out.println("    Record found : " + nameRollNo[0] + " " + nameRollNo[1]);
                        found = true;
                    }
                }
                str = reader.readLine();
            }
            reader.close();


            if(!found){
                System.out.println("    No record found.");
            }

        }
        catch (Exception e) {
            System.out.println("    No record found.");
        }
    }


    static void showAllRecords(){
        try{
            String str;
            String [] nameRollNo;
            boolean found = false;

            BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
            str = reader.readLine();
            
            while(str != null){
                nameRollNo = str.split("!");
                if(nameRollNo.length == 2){
                    System.out.println("    " + nameRollNo[0] + "\t\t" + nameRollNo[1]);
                    found = true;
                }
                str = reader.readLine();
            }
            reader.close();

            if(!found){
                System.out.println("    No record found.");
            }

        }
        catch (Exception e) {
            System.out.println("    Couldnt search record. " +  e.getMessage());
        }
    }


    public static void main(String[] args) {
        int operation;
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("\n\nEnter the operation : ");
            System.out.println("1) Add Record");
            System.out.println("2) Delete Record");
            System.out.println("3) Search by roll Number");
            System.out.println("4) Show all records");
            System.out.println("0) Exit");
            System.out.print("Operation : ");

            
            // input.next();
            operation = input.nextInt();

            String name;
            int rollNo;

            if (operation == 0){
                System.out.println("\n        Thank You !!!");
                break;
            }

            switch (operation) {
                case 1:
                    System.out.print("    Enter the (first) name : ");
                    name = input.next();
                    System.out.print("    Enter the roll number  : ");
                    rollNo = input.nextInt();

                    if(rollNo <=0 ){
                        System.out.print("        Invalid roll number.");
                        break;
                    }

                    addRecord(name, rollNo);
                    break;
            
                case 2:
                    System.out.print("    Enter the roll number to delete : ");
                    rollNo = input.nextInt();
                    deleteRecord(rollNo);
                    break;

                case 3:
                    System.out.print("    Enter the roll number : ");
                    rollNo = input.nextInt();
                    searchRecord("-", rollNo);
                    break;

                case 4:
                    showAllRecords();
                    break;

                default:
                    System.out.println("Invalid Operation");
                    break;
            }

        }

        input.close();
    }
}
