import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        List<String> citiesCache = new ArrayList<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(citiesCache.contains(city)) {
                citiesCache.remove(city);
                answer += 1;
            } else {
                if(citiesCache.size() == cacheSize) citiesCache.remove(0);
                answer += 5;
            }
            citiesCache.add(city);
        }
        return answer;
    }
}