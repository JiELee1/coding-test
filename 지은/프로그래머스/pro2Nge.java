import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        boolean check = false;
        int max = 0;
        while(true) {
            max = arr[arr.length-1] * count;
            
            for(int i=0; i<arr.length-1; i++) {
                if(max % arr[i] != 0) {
                    check = false;
                    count++;
                    break;
                }
                check = true;
            }
            if(check) break;
        }
        return max;
    }
}