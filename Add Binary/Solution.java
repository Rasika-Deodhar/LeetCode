class Solution {
    public String addBinary(String a, String b) {
        
        if(a.length() == 0){
            return b;
        }
        if(b.length() == 0){
            return a;
        }
        int length_diff = Math.abs(a.length()-b.length());
        if(a.length() > b.length()){
            StringBuilder add_on = new StringBuilder("");
            for(int i=0; i<length_diff; i++){
                add_on.append("0");
            }
            String new_a = add_on.toString() + b;
            
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        String a = "", b = "";
        System.out.println(s.addBinary(a, b));
    }
}