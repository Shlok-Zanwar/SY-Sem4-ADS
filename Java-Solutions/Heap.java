import java.util.Scanner;

public class Heap {
    int heapLen = 16;
    int currIndex = 0;
    int []minHeap = new int [heapLen];
    int []maxHeap = new int [heapLen];


    void insertMin(int marks){
        int i = currIndex, myParent, temp;
        minHeap[currIndex] = marks;
        
        while( i != 0){
            myParent = (i - 1)/2;
            if(minHeap[i] < minHeap[myParent]){
                temp = minHeap[i];
                minHeap[i] = minHeap[myParent];
                minHeap[myParent] = temp;
                i = myParent;
            }
            else{
                break;
            }
        }
    }


    void insertMax(int marks){
        int i = currIndex, myParent, temp;
        maxHeap[currIndex] = marks;
        
        while( i != 0){
            myParent = (i - 1)/2;
            if(maxHeap[i] > maxHeap[myParent]){
                temp = maxHeap[i];
                maxHeap[i] = maxHeap[myParent];
                maxHeap[myParent] = temp;
                i = myParent;
            }
            else{
                break;
            }
        }
    }


    void insert(int marks){
        insertMin(marks);
        insertMax(marks);
        currIndex += 1;
    }


    int log2(int n){
        int result = (int)(Math.log(n) / Math.log(2));
        return result;
    }


    public static void main(String[] args) {
        Heap studentMarks = new Heap();
        int marks = 10, i, choice;
        Scanner input = new Scanner(System.in);
        // studentMarks.insertMin(2);
        while(true){
            System.out.println("\nEnter operation to perform");
            System.out.println("1) Insert Marks");
            System.out.println("2) Print Heaps");
            System.out.println("3) Print min and max marks");
            System.out.println("0) Exit");
            System.out.print("Operation : ");
            choice = input.nextInt();
            System.out.println();

            if(choice == 1){
                System.out.print("    Enter Marks : ");
                marks = input.nextInt(); 
                studentMarks.insert(marks);
            }
            else if(choice == 2){
                System.out.print("Min Heap Array : ");
                for(i = 0; i < 16; i ++){
                    System.out.print(studentMarks.minHeap[i] + " ");
                }
                System.out.print("\nMax Heap Array : ");
                for(i = 0; i < 16; i ++){
                    System.out.print(studentMarks.maxHeap[i] + " ");
                }
                System.out.println();
            }
            else if(choice == 3){
                System.out.println("    Minimum Marks = " + studentMarks.minHeap[0]);
                System.out.println("    Maximum Marks = " + studentMarks.maxHeap[0]);
            }
            else if(choice == 0){
                System.out.println("    Thank You !!!\n\n");
                break;
            }
            else{
                System.out.println("    Invalid Operation");
            }

        }

    }
}
