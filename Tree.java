
public class Tree {

	Node root;
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root ==null) {
			root = newNode;
			
		}else {
			Node focusNode = root;
			
			Node parent;
			while(true) {
				parent = focusNode;
				if(key < focusNode.Key) {
					focusNode = focusNode.leftChild;
					if (focusNode ==null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);

		}
	}
	
	public void preOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			System.out.println(focusNode);
			
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
			
		}
	}
		
	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			
			
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key) {
		Node focusNode = root;
		while(focusNode.Key != key) {
			if (key < focusNode.Key) {
				focusNode = focusNode.leftChild;
				
			}else {focusNode = focusNode.rightChild;		
			}
			if (focusNode == null) return null;
			
		} return focusNode;
		
	}
	
	public static void main(String[] args) {

		Tree theTree = new Tree();
		
		theTree.addNode(50, "Prime");
		theTree.addNode(25, "Alpha");
		theTree.addNode(15, "Beta");
		theTree.addNode(30, "Gamma");
		theTree.addNode(10, "Delta");
		theTree.addNode(75, "Theta");
		
		System.out.println("In Order Traversal:");
		theTree.inOrderTraverseTree(theTree.root);
		
		System.out.println();
		System.out.println("Preorder Traversal:");
		theTree.preOrderTraverseTree(theTree.root);
		
		System.out.println();
		System.out.println("Postorder Traversal:");
		theTree.postOrderTraverseTree(theTree.root);
		
		System.out.println();
		System.out.println("Search for 30: ");
		System.out.println(theTree.findNode(30));

	}
		
	class Node{
		int Key;
		String name;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name){
			this.Key = key;
			this.name = name;
			
		}
		
		public String toString() {
			return name + " has a key " + Key;
		}
		
	}

}
