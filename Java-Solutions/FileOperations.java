import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// import java.io.BufferedReader;
// import java.io.FileOutputStream;
// import java.io.FileReader;
// import java.io.PrintWriter;
// import java.util.Scanner;


public class FileOperations {
    public static void main(String[] args) {
        String name;
        int id;
        float balance;
        File file = new File("out.txt");
        if(file.exists()){
            System.out.println(file.length());
        }
        else{
            try{
                file.createNewFile();
                Scanner inFile = new Scanner(file);
                while(inFile.hasNextLine()){
                    name = inFile.next();
                    id = inFile.nextInt();
                    balance = inFile.nextFloat();

                    System.out.println(name + " " + id + " " + balance);
                }


                inFile.close();
            }
            
            catch(IOException e){
            }

            

        }
    }
}


//         Scanner input = new Scanner(System.in);
//         String str;
//         String filename = "./Java-Solutions/file.txt";

//         PrintWriter writer = null;
//         try{
//             // Write mode
//             writer  = new PrintWriter(new FileOutputStream(filename));
//         }
//         catch(Exception e){
//             System.out.println("Error while handling file " + e.getMessage() );
//             System.exit(0);
//         }

//         for (int i = 1; i <= 3; i++) {
//             str = input.nextLine();
//             writer.println(i + " " + str);
//         }
//         writer.close();
        


//         try{
//             // Append mode
//             writer  = new PrintWriter(new FileOutputStream(filename, true));
//         }
//         catch(Exception e){
//             System.out.println("Error while handling file " + e.getMessage() );
//             System.exit(0);
//         }

//         for (int i = 4; i <= 6; i++) {
//             str = input.nextLine();
//             writer.println(i + " " + str);
//         }
//         writer.close();



//         BufferedReader reader = null;
//         try{
//             // Read mode
//             reader  = new BufferedReader(new FileReader(filename));
//             str = reader.readLine();
//             while(str != null){
//                 System.out.println(str);
//                 str = reader.readLine();
//             }
            
//         }
//         catch(Exception e){
//             System.out.println("Error while handling file " + e.getMessage() );
//             System.exit(0);
//         }

//         input.close();