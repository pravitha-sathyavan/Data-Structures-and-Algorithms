/*
Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> results = new ArrayList<Integer>();
        results.add(asteroids[0]);
        for(int i=1;i<n;i++){
            results.add(asteroids[i]);
            results = processAsteroid(results);
        }
        return results.stream().mapToInt(i -> i).toArray();
    }
    
    List<Integer> processAsteroid(List<Integer> results){
        int n = results.size();
        if(n>1 && results.get(n-2) >0 && results.get(n-1) <0){
            if(Math.abs(results.get(n-2))==Math.abs(results.get(n-1))){
                results.remove(n-1);
                results.remove(n-2);
            }
            else if(Math.abs(results.get(n-2))<Math.abs(results.get(n-1))){
                int x = results.get(n-1);
                results.remove(n-1);
                results.remove(n-2);
                results.add(x);
                processAsteroid(results);
            }else{
                results.remove(n-1);
            }
        }
        return results;
    }
}
