package assignment1;

public class StackSet implements StackSet_Interface {
	private Node head;  //current top of stack
	private final int limit;  //defines the maximum size the stackset may contain
	private int size;   //current count of elements in the stackset 
	
	public StackSet( int maxNumElts ) { 
		head = null;                
		limit = maxNumElts;       
		size = 0;
	}
	
	public Node getRoot(){ 
		return head;        
	}
	
	@Override
	public boolean push(double elt) {
		
		//moving existing node to top
		if(this.contains(elt)) {
			if(this.peek() == elt)
				return true;
			else {
				//find and remove existing node by iterating with prev and temp; 
				//if temp value == elt, set prev.next to temp.next.
				Node temp = head;
				Node prev = new NodeImpl(0, temp);
				while(temp != null) {
					if(temp.getValue() == elt) {
						prev.setNext(temp.getNext());
						//after successful removal, call push(elt) again
						this.size -= 1;
						return(this.push(elt));
					}
					prev = temp;
					temp = temp.getNext();
				}
				return false;
			}
		
		//pushing new node
		} else {
			if(this.isFull())
				return false;
			else {
				Node newHead = new NodeImpl(elt, this.head);
				this.head = newHead;
				this.size += 1;
				return true;
			}
		}
	}

	@Override
	public boolean pop() {
		if(!this.isEmpty()) {
			head = head.getNext();
			this.size -= 1; 
			return true;
		}	
		else {
			return false;
		}
	}

	@Override
	public double peek() {
		if(this.isEmpty()) {
			return Double.NaN;
		} else {
			return head.getValue();
		}
	}

	@Override
	public boolean contains(double elt) {
		Node temp = head;
		
		while(temp != null) {
			if(temp.getValue() == elt)
				return true;
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int limit() {
		// TODO Auto-generated method stub
		return this.limit;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.size == limit;
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}

}
