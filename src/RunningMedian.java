import java.util.*;

/**
 * Implement the algorithm to solve running median problem
 * Two heaps*/
public class RunningMedian {
	PriorityQueue<Integer> upperQueue;
	PriorityQueue<Integer> lowerQueue;
	
	public RunningMedian(){
		lowerQueue = new PriorityQueue<Integer>(20, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return -o1.compareTo(o2);
			}
		});
		upperQueue = new PriorityQueue<Integer>();
		upperQueue.add(Integer.MAX_VALUE);
		lowerQueue.add(Integer.MIN_VALUE);
	}
	
	/**
	 * Put new number in the heap and get median value
	 * @param num
	 * @return*/
	public double getMedian(int num){
		if(num >= upperQueue.peek())
			upperQueue.add(num);
		else
			lowerQueue.add(num);
		if(upperQueue.size() - lowerQueue.size() == 2)
			lowerQueue.add(upperQueue.poll());
		else if(lowerQueue.size() - upperQueue.size() == 2)
			upperQueue.add(lowerQueue.poll());
		if(upperQueue.size() == lowerQueue.size())
			return(upperQueue.peek() + lowerQueue.peek()) / 2.0;
		else if(upperQueue.size() > lowerQueue.size())
			return upperQueue.peek();
		else 
			return lowerQueue.peek();
	}
}
