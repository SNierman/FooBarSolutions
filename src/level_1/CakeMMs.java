package level_1;

public class CakeMMs {

	    public static int solution(String x) {
	    	//Write a function called solution(s) that, 
	    	//given a non-empty string less than 200 
	    	//characters in length describing the sequence 
	    	//of M&Ms, returns the maximum number of equal 
	    	//parts that can be cut from the cake without 
	    	//leaving any leftovers.
	    	
	    	if (x.length() > 200  || x.length() == 0){
	    	    System.exit(0);
	    	}
	    	String firstSubstring = x;
    		boolean isSame = false;
    		int divisor;
    			// divide string into equal parts
    	    	for (divisor = x.length(); divisor > 1; divisor--) {
    	    		// get the length of the first string
    	    		int len = x.length()/divisor;
    	    		for (int dividend = len; dividend > 0; dividend /= 2) {
    	    			firstSubstring = x.substring(0, len);
        	    		if (x.length() > len) {
        	    			// compare to string that starts at len
            	    		String secondSubstring = x.substring(len, len+len);
                			if (!firstSubstring.equals(secondSubstring)) {
            	    			continue;
                			}
                			isSame = compareRest(x, secondSubstring);
        	    		}
    	    		}
    	    		if (isSame) {
    	    			return divisor;
    	    		}
    	    	}
	    	return 1;
	    }
	    
	    public static boolean compareRest(String x, String secondSubstring) {
	    	int len = secondSubstring.length();
	    	while(x.length() >= secondSubstring.length()) {
	    		String compString = x.substring(0, len);
	    		if (!compString.equals(secondSubstring)) {
	    			return false;
	    		}
	    		x = x.substring(len);

	    	}
	    	if (x.length() > 0) {
	    		return false;
	    	}   	
	    	return true;
	    }
	}