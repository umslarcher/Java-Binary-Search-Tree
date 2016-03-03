
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Will Smith
 */


public class BinarySearchTree 
{
    Node root;
    
    //Adding Nodes
    public void addNode(int key, String name)
    {
        Node newNode = new Node(key, name);
        
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            Node focusNode = root;
            
            Node parent;
            
            while(true)
            {
                parent = focusNode;
                
                if(key < focusNode.key)
                {
                    focusNode = focusNode.leftChild;
                    
                    if(focusNode == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    focusNode = focusNode.rightChild;
                    
                    if(focusNode == null)
                    {
                        parent.rightChild = newNode;
                        return;  
                    }   
                }
            }
        }
    }
    
    // In order traversal 
    public void inOrderTraverseTree(Node focusNode)
    {
        
        if(focusNode != null)
        {
            
           inOrderTraverseTree(focusNode.leftChild);
           
           System.out.println(focusNode);
            
           inOrderTraverseTree(focusNode.rightChild);
            
        }
    }
    
    
    // Preorder traversal 
    public void preorderTraverseTree(Node focusNode)
    {
        
        if(focusNode != null)
        {
            
           System.out.println(focusNode);
           
           preorderTraverseTree(focusNode.leftChild);
            
           preorderTraverseTree(focusNode.rightChild);
            
        }
    }
    
    
    // Post Order traversal 
    public void postOrderTraverseTree(Node focusNode)
    {
        if(focusNode != null)
        {

           postOrderTraverseTree(focusNode.leftChild);
            
           postOrderTraverseTree(focusNode.rightChild);
            
           System.out.println(focusNode);
        }
    }
    
    
    // Find a Node
    public Node findNode(int key)
    {
    	Node focusNode = root;
    	
    	while(focusNode.key != key)
    	{
    		
    		if(key < focusNode.key)
    		{
    			
    			focusNode = focusNode.leftChild;
    			
    		}
    		else
    		{
    			focusNode = focusNode.rightChild;
    			
    		}
    		if(focusNode == null)
    			return null;
    		
    	}
    	return focusNode;
    	
    }
    
    
    //method to remove a key
    public boolean remove(int key)
    {
		    	Node focusNode = root;
		    	Node parent = root;
		    	
		    	boolean isItALeftChild = true;
		    	
		    	while(focusNode.key != key)
		    	{
		    		parent = focusNode;
		    		
		    		isItALeftChild = true;
		    		
		    		focusNode = focusNode.leftChild;
		    	}
		    	
		        //else{
		    	if(focusNode.key == key){
		    		
		        	isItALeftChild = false;
		    		
		    		focusNode = focusNode.rightChild;
		    	}
		        
		    	if(focusNode == null)
		    	
		    		return false;
    	
	
			    if(focusNode.leftChild == null && focusNode.rightChild == null)
			    {
			    	
			    	if(focusNode == root)
			    	{
			    		root = null;
			    	}
			    	else if(isItALeftChild)
			    	{
			    		parent.leftChild = null;
			    	}
			    	else
			    	{
			    		parent.rightChild = null;
			    	}	
			    }
			    else if(focusNode.rightChild == null){
			    	
			    	if(focusNode == root){
			    		root = focusNode.leftChild;
			    	}
			    	else if(isItALeftChild){
			    		parent.leftChild = focusNode.leftChild;
			    	}
			    	else{
			    		parent.rightChild = focusNode.leftChild;
			    	}
			    }
			    else if(focusNode.leftChild == null){
			    	
			    	if(focusNode == root)// {} not needed, just inserting for my readability
			    	{  
			    		root = focusNode.rightChild;
			    	}
			    	else if(isItALeftChild)
			    	{
			    		parent.leftChild = focusNode.rightChild;	
			    	}
			    	else
			    	{
			    		parent.rightChild = focusNode.leftChild;
			    	}
			    	
			    }
			    // to handle if there are 2 children are involved
			    else
			    {
			    	Node replacement = getReplacementNode(focusNode);
			    	
			    	if(focusNode == root)
			    	{
			    		root = replacement;
			    	}
			    	else if(isItALeftChild)
			    	{
			    		parent.leftChild = replacement;		    		
			    	}
			    	else
			    	{
			    		parent.rightChild = replacement;
			    	}
			    	replacement.leftChild = focusNode.leftChild;
			    	
			    }
			    return true;
		    
    }
    
	
	public Node getReplacementNode(Node replacableNode){
		
		Node replacementParent = replacableNode;
		Node replacement = replacableNode;
		
		Node focusNode = replacableNode.rightChild;
		
		while(focusNode != null){
			
			replacementParent = replacement;
			
			replacement = focusNode;
			
			focusNode = focusNode.leftChild;
			
		}
		
		if(replacement != replacableNode.rightChild){
			
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacableNode.rightChild;
			
			
		}
		return replacement;
		
	}
	
	
    public static void main(String[] args) 
    {
        //int searchInputKey;
        
        BinarySearchTree theTree = new BinarySearchTree();
        
        theTree.addNode(50, "Tom");
        theTree.addNode(25, "Dick");        
        theTree.addNode(45, "Harry");        
        theTree.addNode(55, "Burt");     
        theTree.addNode(30, "Ernie");
        theTree.addNode(65, "Jane");        
 
        
        // Just playing around with adding, removing, and reordering
 /*       System.out.println("");
        System.out.println("inOrder");
        theTree.inOrderTraverseTree(theTree.root);
       
        System.out.println("");
        System.out.println("Preorder");

        theTree.preorderTraverseTree(theTree.root);        
        
        System.out.println("");
        System.out.println("Post Order");
        
*/ 

        
        //System.out.println("Search for 30");
        
        System.out.println("");
        System.out.println(theTree.findNode(25));
        System.out.println("");
        
//        System.out.println("");
//        System.out.println("Remove key 25");
//        theTree.remove(25);        
        
//        System.out.println("");
//        System.out.print("Key 25 is now ");
        
        System.out.println("");

        
        System.out.println("");
        theTree.postOrderTraverseTree(theTree.root);
        
    }
    
}




class Node
{
    int key;
    String name;
    
    Node leftChild;
    Node rightChild;
    
    //Node constructor
    Node(int key, String name){
        
        this.key = key;
        this.name = name;
        
    }
    
    public String toString(){
        
        return name + " has a key of " + key;
        
    }
}
