package com.dll;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public Node pop() {
    	// if the DLL is empty, there is nothing to pop. return null.
    	if(this.tail == null) {
    		return null;
    	}
    	Node LastNode = this.tail;
    	// if there is only one node in the DLL, set both head and tail to null, and return that node.
    	if(this.tail.previous == null) {
    		this.head = null;
    		this.tail = null;
    		return LastNode;
    	}
    	// if there is more than one node in the DLL, set the tail to the previous node after setting the node's next to null
		this.tail.previous.next = null;
		this.tail = this.tail.previous;
		// if the new tail is the only node in the DLL, set the head to the tail
		if(this.tail.previous == null) {
			this.head = this.tail;
		}
    	return LastNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    
    public void printValuesBackwards() {
    	// find the last node, aka tail.
    	Node current = this.tail;
    	
    	// while the current node exists...
    	while(current != null) {
    		// print it's value
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    
    public boolean contains(Integer value) {
    	boolean hasValue = false;
    	Node current = this.head;
    	while(current != null)
    	{
    		if(current.value == value) {
    			hasValue = true;
    		}
    		current = current.next;
    	}
    	return hasValue;
    }
    
    public int size() {
    	Node current = this.head;
    	int size = 0;
    	while(current != null) {
    		size++;
    		current = current.next;
    	}
    	return size;
    }
}
