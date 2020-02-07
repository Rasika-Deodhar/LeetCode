import java.util.ArrayList;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        
        if(matrix.length == 0){
            int[] s = {};
            return s;
        }
                
        if(matrix.length == 1){
            int[] s = { };
                s = new int[matrix[0].length];
                for(int i=0; i<s.length; i++){
                    s[i] = matrix[0][i];
                }
                return s;
        }
        
        if(matrix[0].length==1){
            int[] s = { };
                s = new int[matrix.length];
                for(int i=0; i<s.length; i++){
                    s[i] = matrix[i][0];
                }
                return s;
        }
        
        int m = matrix.length, n = matrix[0].length;
        //int[] output = new int[m*n];
        ArrayList<Integer> output = new ArrayList<Integer>();
        int sum_of_indices = (m-1)+(n-1);
        
        //int[][] array = new int[sum_of_indices][];
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(sum_of_indices);
        ArrayList<Integer> row;
        
        for(int i=0; i<=sum_of_indices; i++){
            row = new ArrayList<Integer>();
            array.add(row);
        }
        
        for(int k=0; k<=sum_of_indices; k++){
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i+j==k)
                    array.get(i+j).add(matrix[i][j]);
                }
            }   
        }
        
        for(int i=0; i<array.size(); i++){
            for(int j=0; j<array.get(i).size(); j++){
                System.out.print(array.get(i).get(j));
            }
            System.out.println();
        }
        
        int even=1;
        
        for(int i=0; i<=sum_of_indices; i++){
            if(even==0){
                for(int j=0; j<array.get(i).size(); j++){
                    // output[k] = array.get(i).get(j).intValue();
                    // k++;
                    output.add(array.get(i).get(j));
                }
            }
            else{
                for(int j=array.get(i).size()-1; j>-1; j--){
                    // output[k] = array.get(i).get(j).intValue();
                    // k++;
                    output.add(array.get(i).get(j));
                }
            }
            even = toggle(even);
        }
        
        int[] o = new int[output.size()];
        int index=0;
        for(Integer i: output){
            o[index++] = i.intValue();
        }
        
        return o;
    }
    
    int toggle(int a){
        if(a==0)
            return 1;
        else
            return 0;
    }

    public static void main(String args[]) {
        Solution s = new Solution();

        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{2,5},{8,4},{0,-1}};
        int[] answer = s.findDiagonalOrder(matrix);

        System.out.println("Output");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}