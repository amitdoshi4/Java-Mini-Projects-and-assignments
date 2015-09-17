class TreeNode{
   // package access members
   TreeNode left;   // left node
   String data;        // data item
   TreeNode right;  // right node

   // Constructor: initialize data to d and make this a leaf node
   public TreeNode( Object d )
   { 
      data = (String) d;              
      left = right = null;  // this node has no children
   }

   // Insert a TreeNode into a Tree that contains nodes.
   // Ignore duplicate values.
   public boolean add( Object d )
   {
      if ( ((String)d).compareTo(data) < 0 ) {
         if ( left == null )
            left = new TreeNode( d );
         else
            left.add( d );
      }
      else if ( ((String)d).compareTo(data) > 0 ) {
         if ( right == null )
            right = new TreeNode( d );
         else
            right.add( d );
         
      }
      return true;
   }
   
   public void display() {
	   
   }
}