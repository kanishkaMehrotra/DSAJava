package Medium;

public class Koko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.print(s.minEatingSpeed(new int [] {805306368,805306368,805306368},1000000000));
		//805306368
		//1000000000
	}

}
//recursive method 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max=0;
        for(int p:piles)
        {
        max=Math.max(max,p);
        }
       int min = findmin(piles,1,max,h);
        return min;
    }

    public boolean eat (int[] piles, int h,int n)
    {
        long hours=0;
        for(int i =0;i<piles.length;i++)
        {
         hours=hours +(int)Math.ceil((double)piles[i]/n);
        } 
        if(hours<=h)
        return true;
        else return false;
    }

    public int findmin(int []piles,int s,int e,int h)
    {
        int mid =(s+e)/2;
      if (s<=e)
      {
          if(! eat(piles,h,mid))
          return findmin(piles,mid+1,e,h);
          else 
          return findmin(piles,s,mid-1,h);
          
      }
      return s;
    }
}

//iterative method 
class Solution2 {

	 public int minEatingSpeed(int[] piles, int h) {
	        
	        int max=0;
	        for(int p:piles)
	        {
	        max=Math.max(max,p);
	        }
	       int l=1;
	       int r=max;
	       while(l<r)
	       {
	           int m =(l+r)/2;
	           int total=0;
	           for(int p :piles)
	               total=total+(p+m-1)/m;
	          if(total>h)     
	          l=m+1;
	          else 
	          r=m;
	       }

	       return l;
	    }
}