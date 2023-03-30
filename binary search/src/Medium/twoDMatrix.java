package Medium;

public class twoDMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchMatrix(new int [][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));

	}
	
	  
	//space complexity O(1) time complexity -->O(log m n) 
	public static boolean searchMatrix(int[][] matrix, int target) {

	        int r=matrix.length;
	        int c =matrix[0].length-1;

	        int low =0;
	        int high =r-1;

	        while(low<=high)
	        {
	            int mid=(high+low)/2;
	            if (matrix[mid][0]<target)
	            low =mid+1;
	            else if(matrix[mid][0]>target)
	            high =mid-1;
	            else
	            return true;
	        }

	        if(high>=0)
	{


	         int left=0;
	         int right =c;
	        while(left<=right)
	        {
	            int mid=(right+left)/2;
	            if(matrix[high][mid]==target)
	            return true;
	            else if(matrix[high][mid]>target)
	            right=mid-1;
	            else 
	            left =mid+1;
	        }
	}
	        return false;
	    }

//	space complexity O(m*n) time complexity -->O(log m n) 
	public boolean searchMatrix1(int[][] matrix, int target) {

        int n =matrix.length;
        int m =matrix[0].length;
        int arr[]=new int [n*m];
        int len =arr.length;
        int k=0;
        for(int i =0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[k]=matrix[i][j];
                k++;
            }
        }
        if(binarySearch(0,len-1,arr,target)>-1)
        return true;
        else 
        return false;
    }

     public int binarySearch(int start,int end,int[]nums,int target)
   {
       
       
       if(end>=start)
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
}
