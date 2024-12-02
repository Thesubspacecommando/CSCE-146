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
	public GenLL() {
		head = current = null;
	}
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);//Link == null as it is at the end
		if(head == null) {
			head = current = newNode;
		} else {
			ListNode temp = head;
			while(temp.link != null) {
				temp = temp.link;
			}
			temp.link = newNode;
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
			current = current.link;
		}
	}
	public void reset() {
		current = head;
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
	public void addAfterCurrent(T aData) {
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	
}
