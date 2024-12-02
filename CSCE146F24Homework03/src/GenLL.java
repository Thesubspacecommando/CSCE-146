/*
 * James E
 */
public class GenLL <T> {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; //First element of the LL
	private ListNode current; //Node that is being pointed to
	private ListNode prev; //One behind current
	private int  size;
	public GenLL() {
		head = current = prev = null;
		size = 0;
	}
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);//Link == null as it is at the end
		if(head == null) {
			head = current = newNode;
			size = 1;
		} else {
			ListNode temp = head;
			while(temp.link != null) {
				temp = temp.link;
			}
			temp.link = newNode;
			size++;
		}
	}
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void goToNext() {
		if(current != null) {
			prev = current;
			current = current.link;
		}
	}
	public void reset() {
		current = head;
		prev = null;
	}
	public boolean hasMore() {
		return current != null;
	}
	public T getCurrent() {
		if(current == null) {
			return null;
		} else {
			return current.data;
		}
	}
	public void setCurrent(T aData) {
		if(current == null) {
			return;
		}
		current.data = aData;
	}
	public void removeCurrent() {
		if(current != null && prev == null) { //current == head
			head = head.link;
			current = head;
		} else if(current != null && prev != null) {
			prev.link = current.link;
			current = current.link;
		}
	}
	public void addAfterCurrent(T aData) {
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	public int getSize() {
		return size;
	}
}
