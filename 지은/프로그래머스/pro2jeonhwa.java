import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++) {
            //어차피 다음거랑 다르면 그 뒤 꺼도 다 다를거기 때문에 다른 것들은 비교할 필요가 없음
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        return true;
    }
}