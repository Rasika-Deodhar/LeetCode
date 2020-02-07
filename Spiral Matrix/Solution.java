import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> l = new ArrayList<>();

        if(matrix.length==0){
            return l;
        }
        if(matrix.length==1){
            for(int i=0; i<matrix[0].length; i++){
                l.add(matrix[0][i]);
            }
            return l;
        }
        if(matrix[0].length==1){
            // l.add(matrix[0][0]);
            // for(int i=matrix.length-1; i>0; i--){
            //     l.add(matrix[i][0]);
            // }
            for(int i=0; i<matrix.length; i++){
                l.add(matrix[i][0]);
            }
            return l;
        }

    int i_min=0, i_max=matrix.length-1, j_min=0, j_max=matrix[0].length-1;

        while(i_min<=i_max && j_min<=j_max){
            if(i_min == j_min){
                for(int j=j_min; j<=j_max; j++){
                    l.add(matrix[i_min][j]);
                }
                i_min++;
            }
            else{
                for(int i=i_min; i<=i_max; i++){
                    l.add(matrix[i][j_max]);
                }
                j_max--;
                for(int j=j_max; j>=j_min; j--){
                    l.add(matrix[i_max][j]);
                }
                i_max--;
                for(int i=i_max; i>=i_min; i--){
                    if(!l.contains(matrix[i][j_min]))
                        l.add(matrix[i][j_min]);
                }
                j_min++;
            }
        }

        return l;

    }
    public static void main(String args[]){
        Solution s = new Solution();

        int[][] matrix = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        List<Integer> l = new ArrayList<>();
        l = s.spiralOrder(matrix);

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0; i<l.size(); i++){
            System.out.println(l.get(i));
        }
    }
}