
//User function Template for Java
class Person{
        Integer height;
        Integer order;
        Person(Integer height, Integer order){
            this.height = height;
            this.order = order;
        }
}

class CustomComparator implements java.util.Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
        if(p1.height > p2.height)
            return -1;
        if(p1.height < p2.height)
            return 1;
        else{
            if(p1.order > p2.order)
                return 1;
            else
                return -1;
        }
    }
}
    
class Sol
{
    ArrayList<Integer> arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Person> persons = new ArrayList<Person>();
       // Sort the heights in descending order
       // If there are two people with the same height sort them in increasing order of their B[] value. 
       // Add elements of this new custom sorted array one by one and place them in the output array 
       // at the indexes equal to their corresponding B[] values.
       
        for(int i=0;i<n;i++){
          Person p = new Person(A.get(i),B.get(i));
          persons.add(p);
        }
        
        Collections.sort(persons, new CustomComparator());
          
        for(int i=0;i<n;i++){
          result.add(persons.get(i).order,persons.get(i).height);
        }
        return result;
    }
}
