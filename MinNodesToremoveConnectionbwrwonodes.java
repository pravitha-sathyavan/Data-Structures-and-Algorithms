// minimum nodes to remove to stop A reaching B

import java.util.*;
class TestClass {

    //static HashSet<Integer> commonSet = new HashSet<>(); 
    private static HashSet<Integer> DFS(HashMap<Integer,List<Integer>> members, Integer start, Integer end){
        HashSet<Integer> set = new HashSet<>(); 
        List<Integer> neighbours = members.get(end);
        if(neighbours.contains(start)){
           set.add(start);
           set.add(end);
        }
        for(int i=0;i<neighbours.size();i++)
            {
                if(neighbours.get(i)!=start)
                    set.addAll(DFS(members, start, neighbours.get(i)));
            }
      //  System.out.println(set);
        return set;
    }


    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer noOfMembers = s.nextInt();
        HashMap<Integer,List<Integer>> members = new HashMap<>();
        int i=0;
        while(i<noOfMembers){
            List<Integer> neighbours = new ArrayList<>();
            Integer member = s.nextInt();
            members.put(member,neighbours);
            i++;
        }
        Integer noOfEdges = s.nextInt();
        i=0;
        while(i<noOfEdges){
            List<Integer> currentNeighbour = new ArrayList<>();
            Integer member1 = s.nextInt();
            Integer member2 = s.nextInt();
            currentNeighbour = members.getOrDefault(member2,currentNeighbour);
            currentNeighbour.add(member1);
            members.put(member2,currentNeighbour);
            i++;
        }
        Integer start = s.nextInt();;
        Integer end = s.nextInt();;
        HashSet<Integer> set = new HashSet<>(); 
        set = DFS(members,start,end);
        set.remove(end);
        for(Integer x: set)
            System.out.println(x);
    }
}
