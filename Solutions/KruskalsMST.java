import java.util.*;

public class KruskalsMST {

    boolean isNotUsed(ArrayList<ArrayList<Integer>> mapArr, int position){
        int i, count1 = 0, count2 = 0;
        // System.out.println((char)(65+mapArr.get(position).get(0))+ " " + (char)(65+mapArr.get(position).get(1))+ " " + mapArr.get(position).get(2)+ " " + position);

        for(i = 0; i < position; i++ ){

            if(mapArr.get(position).get(0) == mapArr.get(i).get(0) || mapArr.get(position).get(0) == mapArr.get(i).get(1)){
                count1 ++;
            }
            if(mapArr.get(position).get(1) == mapArr.get(i).get(0) || mapArr.get(position).get(1) == mapArr.get(i).get(1)){
                count2 ++;
            }

            if(count1 >= 1 && count2 >= 1){
                return false;
            }
        }

        return true;
    }


    void printKruskalsMST(ArrayList<ArrayList<Integer>> mapArr, Boolean used[]){
        int i;
        for(i = 0; i < mapArr.size(); i++ ){
            System.out.println( (char)(65+mapArr.get(i).get(0)) + " " + (char)(65+mapArr.get(i).get(1)) + " " + mapArr.get(i).get(2) + " " + used[i]);
        }
    }


    void generateMst(int graph[][]){
        ArrayList<ArrayList<Integer>> mapArr = new ArrayList<ArrayList<Integer>>();
        

        int i, j;

        for(i = 0; i < graph.length; i ++){
            for(j = i + 1; j < graph[0].length; j ++){
                
                if(graph[i][j] != 0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(graph[i][j]);
                    mapArr.add(temp);
                }
            }
            // System.out.println(mapArr.toString());
        }

        Collections.sort(mapArr, new Comparator<ArrayList<Integer>>() {    
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }               
        });

        System.out.println(mapArr.toString());

        Boolean used[] = new Boolean[mapArr.size()];
        for(i = 0; i < used.length; i ++){
            used[i] = false;
        }

        int countElements = 0, countPath = 0;
        for(i = 0; i < mapArr.size(); i ++){
            used[i] = isNotUsed(mapArr, i);
            if(used[i]){
                countElements ++;
                countPath = countPath + mapArr.get(i).get(2);
                if(countElements == graph.length - 1){
                    break;
                }
            }
        }
        System.out.println("\nKruskals Minimum spanning path = " + countPath);
        System.out.println("\nTable : ");
        printKruskalsMST(mapArr, used);

    }
    

    public static void main(String[] args) {
        KruskalsMST mst = new KruskalsMST();
        int graph[][] = new int[][] { 
            { 0, 8, 0, 0, 0, 10, 0, 5}, 
            { 8, 0, 4, 0, 4, 4, 0, 4 }, 
            { 0, 4, 0, 3, 0, 3, 0, 0 }, 
            { 0, 0, 3, 0, 1, 6, 2, 0 }, 
            { 0, 4, 0, 1, 0, 0, 3, 0 },
            { 10, 4, 3, 6, 0, 0, 0, 0 },
            { 0, 0, 0, 2, 3, 0, 0, 3 },
            { 5, 4, 0, 0, 0, 0, 3, 0 }
        }; 
        mst.generateMst(graph);
    }
}
