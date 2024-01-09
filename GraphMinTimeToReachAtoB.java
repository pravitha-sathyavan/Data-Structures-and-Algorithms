// Given a graph, each edge has an associated time. Find min time to reach from A to B
// Check this code again, Not sure if working for all test cases

private static int DFS(HashMap<Integer,List<List<Integer>>> members, int start, int end){
        if(start == end)
            return 0;
        List<List<Integer>> neighbours = members.get(start);
        if (neighbours == null || neighbours.isEmpty()) {
            return Integer.MAX_VALUE; 
        }
        int currTime = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<neighbours.size();i++){
            List<Integer> currentNeighbour = neighbours.get(i);
            if(currentNeighbour.get(0)==end)
                minTime = Math.min(currentNeighbour.get(1),minTime);
            else{
                Integer newTime = DFS(members, neighbours.get(i).get(0), end);
                if(newTime!=Integer.MAX_VALUE){
                    currTime  = neighbours.get(i).get(1) + newTime;
                    if(currTime<minTime)
                        minTime = currTime;
                }
            }
        }
        return minTime;
    }


class TestClass {

    private static int DFS(HashMap<Integer,List<List<Integer>>> members, int start, int end){
        List<List<Integer>> neighbours = members.get(start);
        int currTime = 0;
        int minTime = 0;
        for(int i=0;i<neighbours.size();i++){
            List<Integer> currentNeighbour = neighbours.get(i);
            if(currentNeighbour.get(0)==end)
                minTime = currentNeighbour.get(1);
        }
        for(int i=0;i<neighbours.size();i++)
            {
                currTime  = neighbours.get(i).get(1) + DFS(members, neighbours.get(i).get(0), end);
                if(currTime<minTime)
                    minTime = currTime;
            }
        return minTime;
    }


    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);

        Integer noOfMembers = s.nextInt();
        HashMap<Integer,List<List<Integer>>> members = new HashMap<>();
        int i=0;
        while(i<noOfMembers){
            List<List<Integer>> neighbours = new ArrayList<>();
            Integer member = s.nextInt();
            members.put(member,neighbours);
            i++;
        }
        Integer noOfEdges = s.nextInt();
        i=0;
        while(i<noOfEdges){
            List<Integer> edge = new ArrayList<>();
            Integer member1 = s.nextInt();
            Integer member2 = s.nextInt();
            Integer time = s.nextInt();
            edge.add(member2);
            edge.add(time);
            List<List<Integer>> currentNeighbour = members.getOrDefault(member1,new ArrayList<>());
            currentNeighbour.add(edge);
            members.put(member1,currentNeighbour);
            i++;
        }
       // System.out.println(members);
        Integer start = s.nextInt();;
        Integer end = s.nextInt();;
        
        Integer time = DFS(members,start,end);
        
        System.out.println(time);

    }
}
