class RandomizedSet {
    static int count = 0;
    HashSet<Integer> hashSet;
    public RandomizedSet() {
       hashSet = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return hashSet.add(val);
    }
    
    public boolean remove(int val) {
        return hashSet.remove(val);
    }
    
    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(hashSet);
        int r=(int)(Math.random()*hashSet.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
