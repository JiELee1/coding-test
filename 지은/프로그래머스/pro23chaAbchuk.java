import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int start = 0;
        String curStr = "";
        
        for(int i=1; i<27; i++) {
            dictionary.put(String.valueOf((char) (i+64)), i);
        }
        
         while(start < msg.length()) {
            curStr += msg.charAt(start);
            if(!dictionary.containsKey(curStr)) {
                answer.add(dictionary.get(curStr.substring(0,curStr.length()-1)));
                dictionary.put(curStr, dictionary.size()+1);
                curStr = "";
                continue;
            }
            start++;
        }
        if(!curStr.isEmpty()) answer.add(dictionary.get(curStr));
        return answer.stream().mapToInt(i->i).toArray();
    }
}