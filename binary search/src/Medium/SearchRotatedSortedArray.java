package Medium;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionSearchRotatedSortedArray s=new SolutionSearchRotatedSortedArray();
		System.out.print(s.search(new int [] {4,5,6,7,0,1,2},0));
	}
}
	class SolutionSearchRotatedSortedArray {
	    public int search(int[] nums, int target) {

	        int s=0;
	        int e =nums.length-1;
	        if(nums[s]<=nums[e])
	        return binarySearch(nums,s,e,target);
	       else
	       {
	        int mid =findPivot(nums,s,e);

	        if(nums[mid] == target)
	        return mid;
	        else if((mid+1)<=e && target >= nums[mid+1]  && target <=nums[e])
	        return binarySearch(nums,mid+1,e,target);
	        else 
	        return  binarySearch(nums,s,mid-1,target);
	       }
	     }

	     public int findPivot(int [] nums,int s,int e)
	     {
	         while(s<e)
	         {
	                 int mid=(s+e)/2;
	 	            if(nums[mid+1] <nums[mid])
	 	            return mid+1;
	 	            else if(nums[mid]<nums[mid-1]) 
	 	            return mid-1;
	 	            else if(nums[mid]>nums[0])
	 	            s= mid+1;
	 	            else 
	 	            e=mid-1;
	         }
	         return s;
	     }

	     public int binarySearch(int[] nums,int s,int e ,int target)
	     {
	         while(s<=e)
	         {
	             int mid =(s+e)/2;
	             if(target==nums[mid])
	             return mid;
	             else if(target >nums[mid])
	             s=mid+1;
	             else
	             e =mid-1;
	         }
	         return -1;
	     }
	}

