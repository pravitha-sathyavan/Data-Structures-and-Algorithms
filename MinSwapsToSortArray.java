/* Find the cycles present in the array. If we got a cycle of length l, the min no of rotations to sort it is l-1.
   Find length of all cycles. Add length-1 to result */


static int minimumSwaps(int[] arr) {
            int n = arr.length;
            boolean isVisited[] = new boolean[n];
            int minswaps = 0,j,count;
            
            for(int i=0;i<n;i++){
                if(!isVisited[i]){
                    j=i;
                    count = 1;
                    while(arr[j]-1!=i){
                        j = arr[j]-1;
                        count++;
                        isVisited[j] = true;
                    }
                    minswaps += count -1;
                }
            }
            return minswaps;

    }
