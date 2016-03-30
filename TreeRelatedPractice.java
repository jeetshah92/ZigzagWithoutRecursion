
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;
public class TreeRelatedPractice {
	
	int data;
	TreeRelatedPractice left;
	TreeRelatedPractice right;
	
	public static void insert(TreeRelatedPractice node, TreeRelatedPractice root) {
		
		  if(node.data < root.data) {
			  
			  if(root.left != null) {
				  
				  insert(node, root.left);
				  
			  } else {
				  
				  root.left = node;
				  
			  }
			  
			  
		  } else if(node.data >= root.data) {
			  
			  if(root.right != null) {
				  
				  insert(node, root.right);
				  
			  } else {
				  
				  root.right = node;
				  
			  }
			  
		  }
		
	}
	
	public static void inorder(TreeRelatedPractice root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}
	
	public static void DFS(TreeRelatedPractice root) {
		
		Stack<TreeRelatedPractice> s = new Stack<>();
		
		s.push(root);
		
		while(!s.isEmpty()) {
			
			TreeRelatedPractice node  = s.pop();
			System.out.println(node.data);
			
			if(node.right != null)
			s.push(node.right);
			
			if(node.left != null)
			s.push(node.left);
			
		}
		
	}
	
	
	public static void BFS(TreeRelatedPractice root) {
		
		Queue<TreeRelatedPractice> s = new LinkedList<>();
		
		s.offer(root);
		
		while(!s.isEmpty()) {
			
			TreeRelatedPractice node  = s.poll();
			System.out.println(node.data);
			
			if(node.left != null)
			s.offer(node.left);
			
			if(node.right != null)
			s.offer(node.right);
			
		}
		
	}
	
	public static void zigzag(TreeRelatedPractice root) {
		
		Queue<TreeRelatedPractice> s = new LinkedList<>();
		boolean isReverse = false;
		List<TreeRelatedPractice> buffer = new ArrayList<>();
		s.offer(root);
		
		while(!s.isEmpty()) {
			
			TreeRelatedPractice node = s.peek();
			//System.out.println("entering from queue to buffer" + node.data);
			buffer.add(node);
			
			
			
			if(s.size() == 1) {
				
				s.poll();
				printLevel(buffer, isReverse);
				isReverse = !isReverse;
				
				Iterator<TreeRelatedPractice> itr =  buffer.iterator();
				
				
				while(itr.hasNext()) {
						
					TreeRelatedPractice n = itr.next();
					if(n.left != null)  {
						
						//System.out.println("entering from queue to buffer" + n.data);
						s.offer(n.left);
					}
						
					if(n.right != null) {
						
						//System.out.println("entering from queue to buffer" + n.data);
						s.offer(n.right);
						
					}
						
						
				}
				
				buffer.clear();
				
			} else {
				
				//System.out.println("----polling from queue----");
				s.poll();
			}
			
			
			
		}
		
		
		
		
		
	}
	
	public static void printLevel(List buffer, boolean isReverse) {
		
		Iterator<TreeRelatedPractice> itr =  buffer.iterator();
		
		if(isReverse) {
			
			Collections.reverse(buffer);
			while(itr.hasNext()) {
				
				System.out.println(itr.next().data);
					
			}
			Collections.reverse(buffer);
			
		} else {
			
			while(itr.hasNext()) {
				
				System.out.println(itr.next().data);
					
			}
			
		}
			
	}
	
	
	public TreeRelatedPractice(int d) {
		// TODO Auto-generated constructor stub
		data = d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeRelatedPractice root = new TreeRelatedPractice(15);
		insert(new TreeRelatedPractice(2), root);
		insert(new TreeRelatedPractice(30), root);
		insert(new TreeRelatedPractice(29), root);
		insert(new TreeRelatedPractice(0), root);
		insert(new TreeRelatedPractice(12), root);
		insert(new TreeRelatedPractice(11), root);
		insert(new TreeRelatedPractice(13), root);
		insert(new TreeRelatedPractice(14), root);
		insert(new TreeRelatedPractice(8), root);
		
		System.out.println("1) ----- inorder");
		inorder(root);
		
		System.out.println("2) ----- DFS");
		DFS(root);
		
		System.out.println("3) ----- BFS");
		BFS(root);
		
		System.out.println("4) ------ ZigZag");
		zigzag(root);
		
		
		
		

	}

}
