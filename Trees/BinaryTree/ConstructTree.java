package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class ConstructTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Integer arr []= {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		
		//1 ->left 2->right 3->pop
		
		Node root=new Node(arr[0], null, null);
		Pair rop =new Pair(root, 1);
		
		Stack<Pair> st=new  Stack<Pair>();
		st.push(rop);
		
		//check if stack is not null;
		int idx=0;
		
		while(st.size()>0)
		{
			Pair top =st.peek();
			if(top.state==1)
			{
				idx++;
				if(arr[idx]!=null)
				{
				top.node.left=new Node(arr[idx], null, null);
				Pair lp=new Pair(top.node.left, 1);
				st.push(lp);
				}
				else
				{
					top.node.left=null;
				}
				top.state++;
			}
			else if(top.state==2)
			{
				idx++;
				if(arr[idx]!=null)
				{
				top.node.right=new Node(arr[idx], null, null);
				Pair rp=new Pair(top.node.right, 1);
				st.push(rp);
				}
				else
				{
					top.node.right=null;
				}
				top.state++;
			}
			else
			{
				st.pop();
			}
		}
		
		//display (root);
		/*System.out.println("size is "+size(root));
		System.out.println("sum is "+sum(root));
		System.out.println("max node is "+maxNode(root));
		System.out.println("min node is "+minNode(root));
		System.out.println("height  is "+height(root));
		System.out.println("sum of leaves  is "+sumofLeaves(root));
		System.out.println("sum of left leaves  is "+sumofleftLeaves(root));
		System.out.println("preorder is "+preorder(root));
		System.out.println("postorder is "+postorder(root));
		System.out.println("inOrder is "+inOrder(root));*/
		//System.out.println("leveloder is ");
		//levelOrder(root);
		 path =new ArrayList<Integer>();
		System.out.println("node to root");
		find(root,30 );
		System.out.println(path);

	}
	private static void display(Node node) {
		// TODO Auto-generated method stub
		
		if(node==null)
			return ;
		
		//self work 
		StringBuilder sb=new StringBuilder();
		sb.append(node.left==null?".":node.left.data);
		sb.append("->");
		sb.append(node.data);
		sb.append("->");
		sb.append(node.right==null?".":node.right.data);
	
		System.out.println(sb);
		
		display(node.left);
		display(node.right);
	}
	
	public static int size(Node node)
	{		
		if(node ==null)
			return 0;
		return size(node.left)+size(node.right)+1;
	}
	public static int sum(Node node)
	{		
		if(node ==null)
			return 0 ;
		return sum(node.left)+sum(node.right)+node.data;
	}

	
	public static int maxNode(Node node)
	{
		if(node==null)
			return Integer.MIN_VALUE;
		//int max =node.data;
		int lmax =maxNode(node.left);
		//max=Math.max(max,lmax);
		int rmax=maxNode(node.right);
		return Math.max(Math.max(lmax,rmax),node.data);
	}
	
	public static int minNode(Node node)
	{
		if(node==null)
			return Integer.MAX_VALUE;
		//int max =node.data;
		int lmin =minNode(node.left);
		//max=Math.max(max,lmax);
		int rmin=minNode(node.right);
		return Math.min(Math.min(lmin,rmin),node.data);
	}
	public static int height(Node node)
	{
		if(node==null)
			return 0;
		return Math.max(height(node.left),height(node.right))+1;
	}
	
	public static int sumofLeaves(Node node)
	{
		if(node==null)
			return 0;
		else if(node.left==null && node.right==null)
			return node.data;
		
		return sumofLeaves(node.left)+sumofLeaves(node.right);
	}
	
	public static int sumofleftLeaves(Node node)
	{
		
		int ans=0;
		if(node==null)
			return 0;
		if(node.left!=null)
		{
			if(node.left.left==null && node.left.right==null)
				 ans+=node.left.data;
			else
				 ans+=sumofleftLeaves(node.left);
				
		}
		
		 ans+=sumofleftLeaves(node.right);
		 return ans;
	}
	
	public static StringBuilder preorder(Node node)
	{
		StringBuilder sb =new StringBuilder();
		
		if(node==null)
			return sb;
		
		sb.append(node.data +" ");
		sb.append(preorder(node.left));
		sb.append(preorder(node.right));
		
		return sb;
	}
	public static StringBuilder postorder(Node node)
	{
		StringBuilder sb =new StringBuilder();
		
		if(node==null)
			return sb;
		
		sb.append(postorder(node.left));
		sb.append(postorder(node.right));
		sb.append(node.data +" ");

		
		return sb;
	}
	public static StringBuilder inOrder(Node node)
	{
		StringBuilder sb =new StringBuilder();
		
		if(node==null)
			return sb;
		
		sb.append(inOrder(node.left));
		sb.append(node.data +" ");
		sb.append(inOrder(node.right));

		
		return sb;
	}
	
	
	public static void levelOrder(Node node)
	{
		
	
		Queue<Node> level=new ArrayDeque<Node>();
		level.add(node);
		level.add(new Node(-1));

		while(level.size()>0)
		{
			Node n=level.poll();
			if(n.data==-1)
			{
				System.out.println();
				if (level.size()>0)
					level.add(new Node(-1));

			}
			else
			{
				System.out.print(n.data+" ");
				if(n.left!=null)
					level.add(n.left);
				if(n.right!=null)
					level.add(n.right);
			}
		}
		
	}
	static ArrayList<Integer> path;
	public static boolean find(Node root,int data)
	{
		
	
		
		if(root ==null)
			return false;
		if(root.data==data)
		{
			path.add(root.data);

		return true;
		}
		boolean flc=find(root.left, data);
		if(flc)
		{
			path.add(root.left.data);
			return true;
			
		}
		
		boolean frc=find(root.right, data);

		if (frc)
		{
			path.add(root.right.data);
			return true;
		}
		
		
			return false;

	}
	
	
}
 class Node
{
	 int data;
	 Node left;
	 Node right;
	 
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(int i) {
		// TODO Auto-generated constructor stub
		this.data=i;
	}
	
}

 class Pair 
 {
	Node node;
	int state;
	public Pair(Node node, int state) {
		super();
		this.node = node;
		this.state = state;
	}
	
 }