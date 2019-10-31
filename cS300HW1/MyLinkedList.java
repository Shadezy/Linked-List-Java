package cS300HW1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedList {
	
	private class Node {
		private Object nodeData;
		private Node nextNode;
		
		private Node(Object data, Node next) {
			this.nodeData = data;
			this.nextNode = next;
		}
		
		private Node(Object data) {
			this.nodeData = data;
			this.nextNode = null;
		}
		
		private Node() {
		}
		
		private boolean equals(Node data) {
			return nodeData == data.nodeData;
		}
	}//node over
	
	public class MyIterator implements Iterator<Object>{
		private Node cur;
		private int index;
		
		
		public MyIterator(Node head) {
			this.cur = head;
			this.index = 0;
		}
		
		public boolean hasNext() {
			return cur != null;
		}
		
		public Object next() {
			if(hasNext()) {
				Object data = cur.nodeData;
				cur = cur.nextNode;
				return data;
			}
			throw new NoSuchElementException();
		}
		
		public Node giveNode(int realIndex) {
			int counter = 0;
			
			while (counter < realIndex) {
				cur = cur.nextNode;
				counter++;
			}
			return cur;
		}
	}
	
	private Node head;
	private int size;
	
	public MyLinkedList() {
		this.head = new Node(null);
		this.size = 0;
	}
	
	public Iterator<Object> Iterator() {
		MyIterator myItr = new MyIterator(this.head.nextNode);
		return myItr;
	}
	
	public List<Object> subList(int fromIndex, int toIndex) {
		if (fromIndex >= this.size || toIndex >= this.size || fromIndex < 0 || toIndex < 0 || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		MyIterator itr = new MyIterator(this.head);
		List<Object> dataList = new ArrayList<Object>();
		int counter = -1;
		while (itr.hasNext() && counter <= toIndex) {
			Object itrData = itr.next();
			if (counter >= fromIndex) {
				dataList.add(itrData);	
			}
			counter++;
		}
		return dataList;
	}
	
	public void reset() {
		clear();
		addFirst("pineapple");
		addFirst("pear");
		addFirst("cherry");
		addFirst("banana");
		addFirst("apple");
	}
	
	public boolean addAll(Collection<Object> data) {
		if (data == null) {
			throw new NullPointerException();
		}
		Iterator<Object> itr = data.iterator();
		boolean yesorno = false;
		
		while (itr.hasNext()) {
			yesorno = add(itr.next());
		}
		return yesorno;	
	}
	
	public boolean addAll(int index, Collection<Object> data) {
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if (data == null) {
			throw new NullPointerException();
		}
		
		int counter = 0;
		Iterator<Object> itr = data.iterator();
		MyIterator myItr = new MyIterator(this.head);
		Node cur = myItr.giveNode(index + 1);//index+1 because this node is going to go at index
		myItr = new MyIterator(this.head);
		Node prev;
		if (index > 0) {
			prev = myItr.giveNode(index);
		}
		else {
			prev = this.head;
		}
		
		while (itr.hasNext()) {
		Node dataNode = new Node(itr.next());
		dataNode.nextNode = cur;
		prev.nextNode = dataNode;
		prev = dataNode;
		counter++;
		this.size++;
		}
		
		if (counter != 0) {
			return true;
		}
		return false;
	}
	
	public boolean retainAll(Collection<Object> data) {
		if (data == null) {
			throw new NullPointerException("data is null");
		}
		
		if (data.iterator() == null) {
			throw new UnsupportedOperationException("data does not have iterator");
		}
		
		MyIterator myItr = new MyIterator(this.head);
		int counter = 0;
		
		while (myItr.hasNext()) {
			Object element = myItr.next();
			boolean yesorno = false;
			Iterator<Object> itr = data.iterator();
			
			while (itr.hasNext()) {
				Object theirElement = itr.next();
				if (element == theirElement) {
					yesorno = true;
					counter++;
				}
			}
			if (!yesorno) {
				remove(element);
			}
		}
		if (counter > 0) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		/*if (this.size==0) {
			return true;
		}
		else {
			return false;
		}*/
		return this.size == 0;
	}
	
	public Object get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		
		Node cur = this.head.nextNode;
		int counter = 0;
		
		while (cur != null) {
			if (counter == index) {
				return cur.nodeData;
			}
			else {
				cur = cur.nextNode;
				counter++;
			}
		}
		throw new NoSuchElementException("haha");
	}
	
	public boolean contains(Object nodeData) {
		Node cur = this.head.nextNode;
		
		while (cur != null) {
			if (nodeData == cur.nodeData) {
				return true;
			}
			
			cur = cur.nextNode;
		}
		
		return false;
	}
	
	public boolean containsAll(Collection<Object> nodeDatas) {
		if (nodeDatas == null) {
			throw new NullPointerException("data is null");
		}
		Iterator<Object> itr = nodeDatas.iterator();
		
		while (itr.hasNext()) {
			if (!contains(itr.next())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Object linkedListToCompare) {
		try {
		MyLinkedList list2 = (MyLinkedList)linkedListToCompare;
		}
		catch (Exception e) {
			throw new ClassCastException("list in wrong format");
		}
		
		MyLinkedList list2 = (MyLinkedList)linkedListToCompare;
		Node cur = this.head.nextNode;
		Node cur2 = list2.head.nextNode;
		
		if (this.size == list2.size && cur.equals(list2.head.nextNode)) {
			while (cur != null || cur2 != null) {
			
				if (cur.nodeData != cur2.nodeData) {
					return false;
				}
				cur = cur.nextNode;
				cur2 = cur2.nextNode;
			}
			return true;
		}
		return false;
	}
	
	public Object set(int index, Object data) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		
		if (data == null) {
			throw new NullPointerException("data is null");
		}
		
		Node cur = this.head.nextNode;
		Object removed;
		int counter = 0;
		
		while (cur != null) {
			if (counter == index) {
				removed = cur.nodeData;
				cur.nodeData = data;
				return removed.toString();
			}
			cur = cur.nextNode;
			counter++;
		}
		throw new NoSuchElementException(); 
		
		
	}
	public boolean remove(Object dataToRemove) {
		Node prev = this.head;
		Node cur = this.head.nextNode;
		
		while (cur != null) {
			if (cur.nodeData == dataToRemove) {
				prev.nextNode = cur.nextNode;
				size--;
				return true;
			}
			prev = cur;
			cur = cur.nextNode;
		}
		return false;
	}
	
	public Object remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		Node prev = this.head;
		Node cur = this.head.nextNode;
		Node removed = null;
		int counter = 0;
		
		while (cur != null) {
			if (counter == index) {
				removed = cur;
				prev.nextNode = cur.nextNode;
				size--;
				return removed.nodeData.toString();
			}
			prev = cur;
			cur = cur.nextNode;
			counter++;
		}
		throw new NoSuchElementException("haha");
	}
	
	public boolean removeAll(Collection<Object> datas) {
		if (datas == null) {
			throw new NullPointerException("data is null");
		}
		
		if (datas.iterator() == null) {
			throw new UnsupportedOperationException("data does not have iterator");
		}
		
		boolean yesorno = false;
		Iterator<Object> itr = datas.iterator();
		
		while (itr.hasNext()) {
			Object next = itr.next();
			while (contains(next)) {
				remove(next);
				yesorno = true;
			}
		}
		return yesorno;
	}
	
	public boolean add(Object newNodeData) {
		if (newNodeData == null) {
			return false;
		}
			
		Node cur = this.head;
		Node newNode = new Node(newNodeData, null);
		
		while (cur.nextNode != null) {
			cur = cur.nextNode;
		}
		cur.nextNode = newNode;
		this.size++;
		return true;
		
		
	}
	
	public void add(int index, Object newNodeData) {
		if (this.size < index || index < 0) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		
		if (isEmpty()) {
			Node newNode = new Node(newNodeData, null);
			this.head.nextNode = newNode;
			this.size++;
		}
		
		else if (index == 0) {
			Node newNode = new Node(newNodeData, this.head.nextNode);
			this.head.nextNode = newNode;
			this.size++;
		}
		
		else if (index > 0) {
			MyIterator it = new MyIterator(this.head);
			/*int counter = 0;
			Node cur = this.node;*/
			
			Node cur = it.giveNode(index);
			
			/*while (counter < index) {
				cur = cur.nextNode;
				counter++;
			}*/
			
			Node newNode = new Node(newNodeData, cur.nextNode);
			cur.nextNode = newNode;	
			this.size++;
		}
	}
	
	public void addFirst(Object newNodeData) {
		if (newNodeData == null) {
			return;
		}
		
		Node newNode = new Node(newNodeData, this.head.nextNode);
		this.head.nextNode = newNode;
		this.size++;
	}
	
	public void addLast(Object newNodeData) {
		if (newNodeData == null) {
			return;
		}
		
		add(newNodeData);
	}
	
	public void clear() {
		this.head.nextNode = null;
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public int indexOf(Object nodeData) {
		if (contains(nodeData)) {
			Node cur = this.head;
			int counter = -1;
		
			while (nodeData != cur.nodeData) {
				cur = cur.nextNode;
				counter++;
			}
			return counter;
		}
		
		return -1;
	}
	
	public int lastIndexOf(Object nodeData) {
		if (contains(nodeData)) {
			Node cur = this.head.nextNode;
			int counter = 0;
			int occurrence = 0;
			
			while (cur != null) {
			
				/*while (nodeData != cur.nodeData) {
					cur = cur.nextNode;
					counter++;
				}*/
				
				if (nodeData == cur.nodeData && counter > occurrence) {
					occurrence = counter;
				}
				
				counter++;
				cur = cur.nextNode;
			}
				return occurrence;
		}
		return -1;
	}
	
	public String toString() {
		Node cur = this.head.nextNode;
		String nodeString = "";
		
		if (cur == null) {
			return "This list is empty";
		}
		
		if (cur.nextNode == null) {
			nodeString = cur.nodeData.toString();
			return nodeString;
		}
		
		while (cur.nextNode != null) {
			nodeString = nodeString + ", " + cur.nodeData.toString();
			cur = cur.nextNode;
		}
		
		nodeString = nodeString.substring(2) + ", " + cur.nodeData.toString();
		
		return nodeString;
	}
}