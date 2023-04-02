package Medium;

public class findMinInRoatatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class SolutionfindMinInRoatatedArray {
    public int findMin(int[] nums) {
        int start =0;
        int end =nums.length-1;

        if(nums[start]<nums[end])
        return nums[start];

       while(start<end)
       {
           int mid =(end+start)/2;

           if(nums[mid]>nums[mid+1])
           return nums[mid+1];
           else if (nums[mid]<nums[mid-1])
           return nums[mid];
           else if(nums[mid]>nums[0]) 
          start=mid+1;
           else 
           end =mid-1;
           
       } 
        return nums[start];
    }
}