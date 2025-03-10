import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> skillList = new ArrayList<>();
        
        for(int i=0; i<skill.length(); i++) {
            skillList.add(skill.charAt(i));
        }
        
        for(String s : skill_trees) {
            List<Character> temp = new ArrayList<>(skillList);
            int id = 0;
            boolean check = true;
            for(int j=0; j<s.length(); j++) {
                if(temp.contains(s.charAt(j))) {
                    if(temp.get(id) == s.charAt(j)) {
                        id++;
                        check = true;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }
            
            if(check) answer++;
        }
        
        
        return answer;
    }
}