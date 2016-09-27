

public class Tree {
  public Node root;
  public int typeTree;
  // ================================================
  public String Tree_2_Preorder(Tree myTree){
	  String resultString;
	  int i_debug;
//	  i_debug=Debug.i_debug;
//	  if(i_debug==0) System.out.println("do-Dump: Tree_2_Preorder. " );
      //
	  if ( myTree.root==null )
	  {
		  resultString="()";
	  }
	  else
	  {
	   resultString = myTree.root.Node_2_Preorder();
	  }
	  return resultString;
  }; // Tree_2_String(Tree myTree)
//================================================
  public int Tree_2_Screen(String title,Screen myScreen){
	  //
	  // Plotting a tree: Prefix notation
	  //
	  // Input: 
	  // ======
	  // title - the title of the tree
	  //
	  // Input/Output:
	  // =============
	  // myScreen - the matrix, representing the tree
	  //            to be printed, in a separate command.
	  //
	  int resultWarning;
	  int i_row, i_col;
	  int max_i_col;
	  
	  // ----------------------------
	  max_i_col=0;  // Initialization
	  // -----------------------------
	  if ( this.root==null )
	  {
		  //resultString="()";
		  resultWarning=1;
	  }
	  else
	  {
	   i_row=0;
	   i_col=0;

	   resultWarning=this.root.Node_2_Screen(myScreen,
			   i_row,i_col, max_i_col);

	   //resultWarning=myScreen.Screen2Print(title);
	  }
	  return resultWarning;
  } // Tree_2_Screen(Tree myTree)
//	 ================================================
	  public int Tree_Nodes_Number(Tree myTree){
		  int resultNumber;
		  if ( myTree.root==null )
		  {
			  resultNumber=0;
		  }
		  else
		  {
			  resultNumber = myTree.root.NodesNumber();
		  }
		  return resultNumber;
	 }; // Tree_Nodes_Number(Tree myTree)
  // ================================================
  public Tree(){ 
	  //root=new Node();
	  root=null;
  } // Tree()
//================================================
  public Tree(Node rootNode){ 
	  root=rootNode;
  } // Tree(Node rootNode)
  // =============================================
//	 ================================================
  public int Tree_insert_Node(Node myNode){
	  //
	  // Input
	  // =====
	  // myNode - a nNode to be inserted to a binary tree.
	  //
	  // Input/Output
	  // ============
	  // this - 1) the tree before inserting,
	  //        2) and after it.
	  //
	  int resultNumber;
	  resultNumber=-1;
	  int i_debug;	
	  i_debug=Debug.i_debug;
	  if(i_debug==0) System.out.println("do-Dump: Tree_insert_Node: ");
	  //
	  if ( this.root==null )
	  {
		  resultNumber=0;
		  this.root=myNode;
	  }
	  else
	  {
		  this.root.Node_insert_Node(myNode);
		  resultNumber = 999;
	  }
	  return resultNumber;
 }; // Tree_insert_Node(Node myNode)
 // ==================================
} // class Tree
