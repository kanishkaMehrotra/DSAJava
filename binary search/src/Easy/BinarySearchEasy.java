package Easy;

public class BinarySearchEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {-1,0,3,5,9,12};
		int s=0;
		int e =arr.length;
		
		System.out.println(search(arr,13));
	}

	public static int binarySearch(int start,int end,int[]nums,int target)
	   {
		 if(end>=start && start<=nums.length)
	       {
	           int mid =start+(end-start)/2;
	           if (nums[mid]==target)
	           return mid;
	           if(target<nums[mid])
	           return binarySearch(start,mid-1,nums,target);
	            
	           return binarySearch(mid+1,end,nums,target);

	       }
	       
	       return -1;
	   }
    public static int search(int[] nums, int target) {

        int s=0;
        int e =nums.length-1;
        return binarySearch(s,e,nums,target);
      }
	
}
