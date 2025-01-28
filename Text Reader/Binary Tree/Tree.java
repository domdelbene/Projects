package edu.monmouth.tree;

public class Tree {
	
	private Node root; // first node of tree
   
	public Node min() {
		if(root == null) {
			return null;
		}
		Node current = root;
		while(current.leftChild != null) {
			current = current.leftChild;
		}
		return current;
	}
   
	public Node max() { 
		if(root == null) {
			return null;
		}
		Node current = root;
		while(current.rightChild != null) {
			current = current.rightChild;
		}
		return current;
	}
   
	public Node find(int key) { 
		if(root == null) {
			return null;
		}
		Node current = root;

		while(current.getkey() != key) {
			if(key < current.getkey()) { 
				current = current.leftChild;
            }
			else { 
				current = current.rightChild;
            }
			if(current == null) 
				return null;
        }
		return current;	
    } 
   
	public void insert(int key, double value) {
		Node newNode = new Node(key, value); // make new node
		if(root == null) // no node in root
			root = newNode;
			else { // root occupied
				Node current = root; // start at root
				Node parent;
				while(true) { // (exits internally)
					parent = current;
					if(key < current.getkey()) { // go left?
						current = current.leftChild;
						if(current == null) { // if end of the line, insert on left
							parent.leftChild = newNode;
							return;
						}
					} // end if go left
					else { // or go right?
						current = current.rightChild;
						if(current == null) { // if end of the line, insert on right
							parent.rightChild = newNode;
							return;
						}
					} // end else go right
				} // end while
			} // end else not root
      } // end insert()

	public boolean delete(int key) { // delete node with given key, (assumes non-empty list)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while(current.getkey() != key) { // search for node
			parent = current;
			if(key < current.getkey()) { // go left?
				isLeftChild = true;
				current = current.leftChild;
            }
			else { // or go right?
				isLeftChild = false;
				current = current.rightChild;
            }
			if(current == null) // end of the line,
				return false; // didn't find it
         } // end while
		 // found node to delete

		// if no children, simply delete it
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) // if root, tree is empty
				root = null; 
			else if(isLeftChild)
				parent.leftChild = null; // disconnect from parent
			else                           
				parent.rightChild = null;
        }

		// if no right child, replace with left subtree
		else if(current.rightChild == null)
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		// if no left child, replace with right subtree
		else if(current.leftChild==null)
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		else { // two children, so replace with inorder successor
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);

			// connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		}  // end else two children
		// (successor cannot have a left child)
		
		return true; // success
	} // end delete()
// -------------------------------------------------------------
	// returns node with next-highest value after delNode
	// goes to right child, then right child's left descendents
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child until no more left children
		while(current != null) { 
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
        }
        if(successor != delNode.rightChild) {              // if successor not right child, make connections
        	successorParent.leftChild = successor.rightChild;
        	successor.rightChild = delNode.rightChild;
        }
        return successor;
	}
// -------------------------------------------------------------
   	public void traverse(int traverseType) {
   		switch(traverseType) {
   			case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
   			case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
   			case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
   		}
   		System.out.println();
   	}
// -------------------------------------------------------------
   	private void preOrder(Node localRoot) {
	   if(localRoot != null) {
		   System.out.print(localRoot.getkey() + " ");
		   preOrder(localRoot.leftChild);
		   preOrder(localRoot.rightChild);
        }
    }
// -------------------------------------------------------------
   	private void inOrder(Node localRoot) {
   		if(localRoot != null) {
   			inOrder(localRoot.leftChild);
   			System.out.print(localRoot.getkey() + " ");
   			inOrder(localRoot.rightChild);
   		}
   	}
// -------------------------------------------------------------
   	private void postOrder(Node localRoot) {
   		if(localRoot != null) {
   			postOrder(localRoot.leftChild);
   			postOrder(localRoot.rightChild);
   			System.out.print(localRoot.getkey() + " ");
        }
   	}
  }