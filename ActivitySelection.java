class Activity{
    int start;
    int end;
    
    public Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}
    
class Solution
{
    
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        int result = 1;
        Activity arr[] = new Activity[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = new Activity(start[i],end[i]);
        }
        Arrays.sort(arr,(first,second)->(first.end - second.end));
        
        int prevEndTime=arr[0].end;
        for(int j=1;j<n;j++){
             if (arr[j].start > prevEndTime) {
                result++;
                prevEndTime = arr[j].end;
            }
        }
        return result;
    }
}

