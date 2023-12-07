//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    class Patient{
        int i;
        int j;
        int level;
        
        Patient(int i,int j,int level){
            this.i=i;
            this.j=j;
            this.level=level;
        }
    }
     public int helpaterp(int[][] hospital) {
        Queue<Patient> queue = new LinkedList<>();
        int m = hospital.length;
        int n = hospital[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(hospital[i][j]==2)
                {   Patient p = new Patient(i,j,0);
                    queue.add(p);
                }
            }
        }
        int max = 0;
        while(!queue.isEmpty()){
             Patient p = queue.poll();
             if(p.i+1<m && hospital[p.i+1][p.j]==1){
               Patient p1 = new Patient(p.i+1,p.j,p.level+1);
               queue.add(p1);
               hospital[p.i+1][p.j]=2;
             }
              if(p.i-1>=0 && hospital[p.i-1][p.j]==1){
                 Patient p1 = new Patient(p.i-1,p.j,p.level+1);
                 queue.add(p1);
                 hospital[p.i-1][p.j]=2;
             }
             if(p.j+1<n && hospital[p.i][p.j+1]==1){
                 Patient p1 = new Patient(p.i,p.j+1,p.level+1);
                 queue.add(p1);
                 hospital[p.i][p.j+1]=2;
             }
              if(p.j-1>=0 && hospital[p.i][p.j-1]==1){
                 Patient p1 = new Patient(p.i,p.j-1,p.level+1);
                 queue.add(p1);
                 hospital[p.i][p.j-1]=2;
             }
             if(p.level>max)
                max = p.level;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(hospital[i][j]==1)
                        return -1;
            }
        }
        return max;
    }
}
