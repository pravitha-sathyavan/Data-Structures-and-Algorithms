
import java.util.HashMap;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		int leftP  = 0;
		int maxLength = 0;
		int length = 0;
		HashMap<Character,Integer> m = new HashMap<>();

		for(int rightP=0;rightP<str.length();rightP++){
			char c = str.charAt(rightP);
			if(m.containsKey(c))
				m.put(c,(m.get(c)+1));
			else{
				if(k>0){
					m.put(c,1);
					k--;
				}
				else{
				    while(k<=0){
						char charleftP = str.charAt(leftP);
						m.put(charleftP,(m.get(charleftP)-1));
					    if(m.get(charleftP)==0){
							  m.remove(charleftP);
							  k++;
						}
					    leftP++;
				    }
				    m.put(c,1);
					k--;
				}
			}
			length = rightP - leftP + 1;
			if(maxLength<length)
				maxLength = length;
		}
	return maxLength;
	}

}
