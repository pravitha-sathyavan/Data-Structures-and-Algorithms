// Graph If two nodes are connected

class TestClass {

    private static boolean DFS(HashMap<Integer,List<Integer>> members, int start, int end){
        if (start == end) {
        	return true;
    	}
	List<Integer> neighbours = members.get(start);
        if (neighbours != null) {
        for (int neighbor : neighbours) {
            if (!visited.contains(neighbor) && DFS(members, neighbor, end, visited)) {
                return true;
            }
        }
   	 }
        return false;
    }


    // The method to call DFS with proper initialization of the visited set
	private static boolean isReachable(HashMap<Integer, List<Integer>> members, int start, int end) {
    		Set<Integer> visited = new HashSet<>();
    		return DFS(members, start, end, visited);
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
            currentNeighbour = members.getOrDefault(member1,currentNeighbour);
            currentNeighbour.add(member2);
            members.put(member1,currentNeighbour);
            i++;
        }
        Integer start = s.nextInt();;
        Integer end = s.nextInt();; 
        boolean isPossible = isReachable(members,start,end);
        if(isPossible)
            System.out.print(1);
        else
            System.out.print(0);
    }
}
