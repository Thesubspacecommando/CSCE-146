/*
 * James E
 */
public class LLQueue<T> implements QueueI<T> {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	public LLQueue() {
		head = tail = null;
	}
	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = tail = newNode;
		} else {
			tail.link = newNode;
			tail = tail.link;
		}
	}
	public T dequeue() {
		if(head == null) {
			return null;
		}
		T temp = head.data;
		head = head.link;
		return temp;
	}
	
	public T peek() {
		if(head == null) {
			return null;
		}
		return head.data;
	}
	
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public boolean hasMore() { // method to create a while loop to cycle through the queue.
		return head != null; //Queue is not empty
	}
}
