class MedianFinder {

    PriorityQueue<Integer> p1;
    PriorityQueue<Integer> p2;
    Integer maxP1;
    Integer minP2;

    public MedianFinder() {
        p1 = new PriorityQueue<Integer>(new MinimumComparator());
        p2 = new PriorityQueue<Integer>(new MaximumComparator());
        maxP1 = Integer.MAX_VALUE;
        minP2 = Integer.MIN_VALUE;
    }
    
    public void addNum(int num) {
        if(num < maxP1)
          p1.add(num);
        else 
          p2.add(num);
        if(p1.size() - p2.size() > 1){
          p2.add(p1.poll());     
        }
        if(p2.size() - p1.size() > 1){
          p1.add(p2.poll());
        }
        if(!p1.isEmpty())
          maxP1 = p1.element();
        if(!p2.isEmpty())
          minP2 = p2.element();
    }
    
    public double findMedian() {
      if(p1.size()>p2.size())
        return p1.element();
      if(p2.size()>p1.size())
        return p2.element();
      return ((p1.element()+p2.element())/2.0);
    }
}

class MinimumComparator implements Comparator<Integer>{
    //Largest element comes first
    public int compare(Integer a, Integer b){
        if (a < b)
                    return 1;
        else if (a > b)
                    return -1;
        return 0;
    }
}

class MaximumComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        if(a<b)
          return -1;
        else
          return 1;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
