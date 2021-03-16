public class PrimsMST {
    int noOfVertices = 8;

    int getMinIndex(boolean usedBools[], int weigth[]){
        int i, min = Integer.MAX_VALUE, minIndex = -1;
        for(i = 0; i < noOfVertices; i ++){
            if(!usedBools[i] && weigth[i] < min){
                min = weigth[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    void printPrimsMST(boolean usedBools[], int weigth[], int foundBy[] ){
        int i;
        for(i = 0; i< noOfVertices; i++){
            System.out.println((char)(65+i) + " " + usedBools[i] + " " + weigth[i] + " " + (char)(foundBy[i] + 65) );
        }
    }


    void generateMST(int graph[][]) {

        boolean usedBools[] = new boolean[noOfVertices];
        int weigth[] = new int[noOfVertices]; 
        int foundBy[] = new int[noOfVertices];

        int i, j;
        for(i = 0; i < noOfVertices; i ++ ){
            weigth[i] = Integer.MAX_VALUE;
            usedBools[i] = false;
            foundBy[i] = -20;
        }
        
        int currentSearch, startWith = 0;
        weigth[startWith] = 0;

        // noOfVertices to make last one true else noOFVerties -1
        for(i = 0; i < noOfVertices ; i ++ ){
            currentSearch = getMinIndex(usedBools, weigth);
            usedBools[currentSearch] = true;

            for(j = 0; j < noOfVertices; j ++){
                if(!usedBools[j]){
                    if( graph[currentSearch][j] != 0 && graph[currentSearch][j] < weigth[j] ){
                        weigth[j] = graph[currentSearch][j];
                        foundBy[j] = currentSearch;
                    }
                }
            }

        }

        printPrimsMST(usedBools, weigth, foundBy);

    }

    public static void main(String[] args) {
        PrimsMST mst = new PrimsMST();
        int graph[][] = new int[][] { 
                                        { 0, 8, 0, 0, 0, 10, 0, 4}, 
                                        { 8, 0, 4, 0, 10, 7, 0, 9 }, 
                                        { 0, 4, 0, 3, 0, 3, 0, 0 }, 
                                        { 0, 0, 3, 0, 25, 18, 2, 0 }, 
                                        { 0, 10, 0, 25, 0, 2, 7, 0 },
                                        { 10, 7, 3, 18, 2, 0, 0, 0 },
                                        { 0, 0, 0, 2, 7, 0, 0, 3 },
                                        { 4, 9, 0, 0, 0, 0, 3, 0 }
                                    }; 
        mst.generateMST(graph);

    }
}
