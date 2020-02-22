//Yirong_Li  2458304L

//do not include package statement 
//do not import any classes
//just complete the methods indicated,
//namely:
//insertTail
//deleteAlternate and
//merge

public class AssessmentSLL<E extends Comparable<E>> {

	// Each SLL object is the header of
	// a singly-linked-list

	private Node<E> first;

	/**
	 * constructor
	 */
	public AssessmentSLL() {
		// Construct an empty SLL.
		first = null;
	}

	// //////// Inner class //////////
	private static class Node<E> {
		// Each Node object is a node of a
		// singly-linked-list.
		protected E element;
		protected Node<E> next;

		public Node(E elem, Node<E> n) {
			element = elem;
			next = n;
		}

	}

	// ////////////////////////////////

	/**
	 * print all elements starting from first node
	 */
	public void printFirstToLast() {
		// Print all elements in this SLL, in first-to-last order.
		Node<E> curr = first;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.next;
		}
	}

	/**
	 * insert new node containing elem at front of list
	 * 
	 */
	public void insert(E elem) {
		Node<E> newNode = new Node<E>(elem, first);
		first = newNode;
	}

	/**
	 * add new node to end of list
	 */
	public void insertTail(E elem) {
		Node<E> ins = new Node(elem, null);
		Node<E> curr = first;
		if(curr == null) {
			first = ins;
			return;
		}
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = ins;
	}

	/** delete every alternate element
	 *  imagine the elements are indexed 0, 1, 2, ... , n-1
	 *  delete all the odd indexed elements
	 *  so if list had values ant, badger, cat, dog
	 *  the method would delete nodes containing badger and dog
	 */
	public void deleteAlternate() {
		Node<E> curr = first;
		Node<E> alt;
		if(curr == null) return;
		while(curr.next != null) {
			alt = curr.next;
			curr.next = alt.next;
			curr = alt.next;
			if(curr == null) return;
		}
	}

	/**
	 * method to merge two ordered lists with this one whilst removing duplicates
	 * order should be preserved
	 * you need to replace the type list1, list2 and list3 and the return type
	 * with the new name of this class
	 */
	public  AssessmentSLL<E> merge(AssessmentSLL<E> list1, AssessmentSLL<E> list2){
		AssessmentSLL<E> mergedList = new AssessmentSLL<E>();
		mergedList = mergeHelper(list1);
		mergedList = mergedList.mergeHelper(list2);
		return mergedList;
	}
	/**
	 * helper method that merge two ordered lists (one of them is this one)
	 * whilst removing duplicates
	 * and preserved the order
	 */
	public AssessmentSLL<E> mergeHelper(AssessmentSLL<E> list2){
		AssessmentSLL<E> mergedList = new AssessmentSLL<E>();
		AssessmentSLL<E> list1 = this;
		Node<E> dummy = new Node<E>(null, null);
		mergedList.first = dummy;
		Node<E> curr3 = mergedList.first;
		Node<E> curr1 = list1.first;
		Node<E> curr2 = list2.first;
		while(curr1 != null && curr2 != null) {
			int compare = curr1.element.compareTo(curr2.element);
			if(compare < 0) {
				Node<E> copy = new Node(curr1.element,null);
				curr3.next = copy;
				curr1 = curr1.next;
			}else if(compare > 0) {
				Node<E> copy = new Node(curr2.element,null);
				curr3.next = copy;
				curr2 = curr2.next;
			}else if(compare == 0) {
				Node<E> copy = new Node(curr1.element,null);
				curr3.next = copy;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			curr3 = curr3.next;
		}
		while(curr1 != null) {
			Node<E> copy = new Node<E>(curr1.element, null);
			curr3.next = copy;
			curr1 = curr1.next;
			curr3 = curr3.next;
		}
		while(curr2 != null) {
			Node<E> copy = new Node<E>(curr2.element, null);
			curr3.next = copy;
			curr2 = curr2.next;
			curr3 = curr3.next;
		}
		
		mergedList.first = mergedList.first.next;
		return mergedList;
	}

}

