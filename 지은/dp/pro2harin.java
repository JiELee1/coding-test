import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int res = 0;

        for(int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> map = reset(want, number);
            if(oper(map, discount, i)) res++;
        }
        return res;
    }

    boolean oper(Map<String, Integer> want, String[] discount, int i) {
        for(int j=i; j<i+10; j++) {
            if(want.containsKey(discount[j])) {
                if(want.get(discount[j])-1 == 0) want.remove(discount[j]);
                else want.put(discount[j], want.get(discount[j])-1);
            }
        }
        return want.isEmpty();
    }
    
    Map<String, Integer> reset(String[] want, int[] number) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        return map;
    }
}