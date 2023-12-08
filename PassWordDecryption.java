
class Solution
{
    boolean valid(String p,String s)
    {
        int n=p.length();
        int m=s.length();
        if(m<n)
        {
            return false;
        }
    int l=0;
    int r=0;
    
    // Create two hash arrays of size 26 each
    // for storing frequency of characters
    // h1[]: stores frequency of characters of password String
    // h[]: stores frequency of characters of encrypted string
    //          of window of length p.size()
    int h1[]=new int[128];
    int h[]=new int[128];
    
    // Calculate frequency of password string P
    for(int i=0;i<n;i++)
        h1[p.charAt(i)]+=1;
        
    // Traverse the encrypted string with
    // window of size P.size()
    while(r<m)
    {
        if(r-l+1<n)
        {
            h[s.charAt(r)]+=1;
            r=r+1;
        }
        else if(r-l+1==n)
        {
            int flag=1;
            h[s.charAt(r)]+=1;
            
            // If all characters in current window is same as 
            // that of Password string, we return true
            for(int i='a';i<='z';i++)
            {
                if(h[i]!=h1[i])
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            return true;
            r=r+1;
            h[s.charAt(l)]-=1;
            l=l+1;
        }
    }
    return false;
    }
}
