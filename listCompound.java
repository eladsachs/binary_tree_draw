import java.util.StringTokenizer;
import java.util.Stack;
import java.lang.Object;
import java.lang.String;

//import basics.SearchTree.Node;

public class listCompound {
	public String str_paranthesis;
	// The string mode of a list as "(a ( b c ) )"
	public Stack stackList;
	public String type;  
	// pure: {a b c}, compound: (a ( b c ) )
	// =========================================
	public listCompound(String myString){
        // paranthesis_pair=" ( )";    // Empty list
        // paranthesis_pair=" ( xx )"; // Only root
        // paranthesis_pair=" ( xx yy)"; // Only root and son		
		str_paranthesis=myString;
		stackList=this.listCompound_2_Stack();
	}
	//==========================================
	public listCompound(){
		str_paranthesis="";
		stackList=new Stack();
	}
	// =========================================
public Tree listCompound_2_Tree()
	  {
		 int paranthesisValue; // ( +    ||   // ) -     
		 Tree localTree;
    	 int eq;
		
		 String currentToken;
		 Object currentObject;
		 Object tempObject;
		 String objectClassName;
		 String tempObjectClassName;
		 int n_stack; // number elements in a stack
		 Stack stackTokens = new Stack();
		 int i, j;
		 int i_debug;
		 i_debug=0;
		// if(i_debug==0)	 System.out.println("do_Dump: listCompound_2_Tree");
		 int indexChar; // type of a char
		 Node myNode;       // 8.12.07
		 myNode=new Node(); // 8.12.07
		 localTree=new Tree(myNode);
		 
		 n_stack=stackList.size();
		 if(n_stack==1)
		 {
			 localTree.root.a_value=(String)stackList.elementAt(0);
		 }

		 //
		 paranthesisValue=0;
		 //while (!stackList.empty())
		 for(i=0;i<n_stack;i++)
	     {	 
			 if(n_stack==1) break;
			 currentToken=(String)stackList.elementAt(i);
			 currentObject=stackList.elementAt(i);
    	     objectClassName=currentObject.getClass().getName();
	         //
    	     indexChar=3;
    	     if(objectClassName.equals("java.lang."+"String"))
    	     {
		    	 eq=currentToken.compareTo("(");
		    	 if (eq==0) {indexChar=1;}
		    	 eq=currentToken.compareTo(")");
		    	 if (eq==0) {indexChar=2;}
    	     }
	    	 //
	    	 switch(indexChar){
	    	    // ( 
	    	    case 1: if(i_debug==1)System.out.println("do- " + "(" + "===" + currentToken); 
	    	    paranthesisValue++;
	    	    stackTokens.push(currentToken);
	    	    break;
	    	    // -----------------------------
	    	    // )
	    	    case 2: if(i_debug==1)System.out.println("do- " + ")" + "===" + currentToken); 
		    	    paranthesisValue--;
		    	    stackTokens.push(currentToken);
		    	    String internalString, tempString;
		    	    internalString="";
		    	    eq=1;
		    	    tempString="";
		    	    // from ( a (b c) ) gives (b c)
		    	    listCompound localListCompound;
		    	    localListCompound=new listCompound("");
		    	    j=0;
		    	    while(eq!=0) 
		    	    {
		    	     j++;
		    	     tempObject=stackTokens.pop();
		    	     tempObjectClassName=tempObject.getClass().getName();
		    	     if(tempObjectClassName.equals("java.lang."+"String"))
		    	     {
			    	     tempString=(String)tempObject;
			    	     localListCompound.stackList.push(tempObject);
			    	     eq=tempString.compareTo("(");
			    	     internalString=tempString + " " + internalString; // reverse
		    	     }
		    	     else
		    	     {
		    	    	 localListCompound.stackList.push(tempObject);
		    	     }
		    	     // internaString - pure list
		    	    }
		    	    localTree=localListCompound.reverse().listPure_2_Tree();
		    	    if(i_debug==1)System.out.println(internalString);
		    	    //stackTokens.push("*");
		    	    stackTokens.push(localTree.root);
	    	    break;
	    	    // -------------------------------------
	    	    // any token
	    	    case 3: 
	    	    	if(i_debug==1)System.out.println("do- " + " Any token." + "===" + currentToken);
	    	        //stackTokens.push(currentToken);
	    	        stackTokens.push(currentObject);        
	    	       break;
	    	   // ---------------------------------------
	    	    default:
	    	    	if(i_debug==1)System.out.println("do- " + " Err. default.");
	    	    	break;
	    	    // ---------------------------------------
	    	 } // switch
	     } // while
	     return localTree;	    	    	 	         
	  }  // listCompound_2_Tree	
//	==========================================
	public Tree listPure_2_Tree()
	  {
        // ------------------------------
		//  listPure: (a bc d * f)
		//
		//  * can be another sub-tree.
		//
		// -----------------------------
		Tree localTree;
		Node myNode;       // default Node
		myNode=new Node(); // default Node;
        localTree=new Tree(myNode);
        int i_debug;
        i_debug=Debug.i_debug;
        //if(i_debug>=0) System.out.println("do_dump: listPure_2_Tree");
        // ----------------------------
		 //StringTokenizer st;
		 //st = new StringTokenizer(myString);
		 int stam;
		 int tokenNum;
		 int n_stack; // number of elements in a stack.
//		 The sum of paranthesis considering their opening ( or ).
		 //int paranthesisValue; 
		 
		 //String currentToken;
		 String objectType; 
		 // The type of the Object: String, Node
		 Object currentObject;
		 // The name of the class of the object
		 String objectClassName; 
		 //String tempToken;
		 //
		 Node previousNode;
		 previousNode= new Node();
		 tokenNum=0;
		 localTree.root.a_value="zz";
		 stam=27;
		 localTree.root.syntaxType=17;
		 //
		 n_stack=stackList.size();
		 //
		 for(int i=0;i<n_stack;i++)
	     {	 
			 currentObject=stackList.elementAt(i);
    	     objectClassName=currentObject.getClass().getName();
	         //
    	     if(objectClassName.equals("java.lang."+"String"))
    	     {
    	    	 objectType="String";
    	     }
    	     else
    	     {
    	    	 objectType="Node";
    	     }
		 //		 	 
	    	 Node tempNode;
	    	 tempNode=new Node();
	    	 int eq;
	    	 if (objectType.equals("String"))
	    	 {eq=((String)currentObject).compareTo("("); }
	    	 else{  eq=99; }
	    	 
	    	 if (eq==0) {tokenNum=0;}
	    	 else { 	    		    
		    		 //eq=((String)currentObject).compareTo(")");
		    		 if (objectType.equals("String"))
			    	 {eq=((String)currentObject).compareTo(")"); }
			    	 else{  eq=99; }
		    		 if (eq==0)
			    	 {
			    		 previousNode.T_Brother=null;
			    		 break;
			    	 }
			    	 else
			    	 {
		    		     tokenNum++; // number of the token
			    	 }
		    	 }
	    	 // -----------------------------
	    	 if(tokenNum==1)
	    	    {
	    		 localTree.root.a_value=((String)currentObject);
	    		 previousNode=tempNode;
	    		 if(i_debug==1)System.out.println(((String)currentObject));
	    	    }
	    	 
	    	 if(tokenNum==2)
	    	    {
	    		 if(objectType.equals("String") )
	    		 { // String
		    		 localTree.root.T_Son=tempNode;
		    		 tempNode.T_Father=localTree.root;
		    		 tempNode.a_value=((String)currentObject);
		    		 previousNode=tempNode;
		    		 if(i_debug==1)System.out.println(((String)currentObject));
	    		 }
	    		 else
	    		 { // Node
	    			 tempNode=(Node)currentObject;
	    			 localTree.root.T_Son=tempNode;
		    		 tempNode.T_Father=localTree.root;
		    		 //tempNode.a_value=tempToken;
		    		 previousNode=tempNode;
		             //System.out.println(tempToken);
	    		 }
	    		 
	    	    }
	    	 
	    	 if(tokenNum>2)
		    	 {    		     	    		    
	        	     objectClassName=currentObject.getClass().getName();
	    	         //
	        	     if(objectClassName.equals("java.lang."+"String"))
	        	     {
	        	    	 //objectType="String";
	        	    	 tempNode.a_value=(String)currentObject;
	        	     }
	        	     else
	        	     {
//	        	    	objectType="Node";
	    		        tempNode=(Node)currentObject;
	        	     }
	        	     previousNode.T_Brother=tempNode;
	    		     previousNode=tempNode;
		    	 }
		    	 	 
	     }; // for
         //
         // After first sweep parsing.
	     //
	      stam=23;
	      if(i_debug==1)System.out.println("do-" + stam);
	      if (tokenNum==0)
	      {
	    	  localTree.root=null;
	      }
	      //
	      if (tokenNum==1)
	      {
	    	  localTree.root.T_Son=null;
	    	  localTree.root.T_Brother=null;
	      } 
        // ----------------------
        return localTree;
	  } // Tree listPure_2_Tree()
	// ===========================================
	public Stack listCompound_2_Stack()
	  { 
		 Stack localStack;
		 StringTokenizer st;
		 String myString;
		 String currentToken;
	     int i_debug;
	     i_debug=Debug.i_debug;
	     //if(i_debug>=0) System.out.println("do_dump: listCompound_2_Stack");
	     // ----------------------------		 
		 myString=this.str_paranthesis;
	 	 
		 st = new StringTokenizer(myString);
		 localStack=new Stack(); 
		 //
		 while (st.hasMoreTokens()) 
	     {	 
	    	 currentToken=st.nextToken();
	    	 localStack.push(currentToken);
         } // while
		 //
	     return localStack;	    	    	 	         
	  }  // listCompound_2_Stack 
//	 ===========================================
	  public listCompound reverse()
	  {
		 // 
		 //  "( a b c )"  -->   "( c b a )"
		 //
		 listCompound localListCompound;
		 Object currentObject;
		 StringTokenizer st;
		 String myString;
		 String currentToken;
		 int n_Stack; // number of elements in the stack.
		 int i;
		 
		 myString=this.str_paranthesis; 
		 st = new StringTokenizer(myString);
		 localListCompound=new listCompound();
		 localListCompound.str_paranthesis="";
		 while (st.hasMoreTokens()) 
	     {	 
	    	 currentToken=st.nextToken();
	    	 localListCompound.str_paranthesis=
	    		 currentToken + localListCompound.str_paranthesis;
         } // while
		 //--------------------------------
		 n_Stack=this.stackList.size();
		 for (i=0;i<n_Stack;i++)
		 {
			 currentObject=this.stackList.get(n_Stack-i-1);
			 localListCompound.stackList.push(currentObject);
		 }
	     return localListCompound;	    	    	 	         
	  }  // listCompound_2_Stack 	

//===========================================
	public boolean isCorrect()
	{
		 // 
		 //  Checking a standard listCompound
		 //
		 //  "( a )(b c )"  -->   False
		 //
		 
		 String myString;
		 int i;
		 char localChar;
		 int n_paranthesis;
		 boolean localBoolean;
		 
		 n_paranthesis=0;
		 myString=this.str_paranthesis; 
		 i=2;
		 localBoolean=true;
		 for (i=0;i<myString.length();i++)
		 {
		  localChar=myString.charAt(i);
		  if(localChar=='(') n_paranthesis++; 
		  if(localChar==')') n_paranthesis--;
		  if (n_paranthesis<0)localBoolean=false;
		  if (n_paranthesis==0 && i< (myString.length()-1))
			  localBoolean=false;
		 }
		 return localBoolean;
	} // boolean isCorrect()
//	===========================================
	public listCompound spaced()
	{
		 // 
		 //  Checking a standard listCompound:
		 //           with spaces before and after the paranthesis
		 //
		 //  "(a (b c ) )"  -->   "( a ( b c ) )"
		 //
		 
		 String myString;
		 String resultString;
		 //StringBuffer buf = new StringBuffer("");
		 listCompound localListCompound;

		 int i,j;
		 char localChar;
		 char nextChar;

		 myString=this.str_paranthesis; 
		 j=-1;
		 resultString="";

		 for (i=0;i<myString.length();i++)
		 {
		  localChar=myString.charAt(i);
		  if(i<myString.length()-1)
		   nextChar=myString.charAt(i+1);
		  else
		   nextChar=' ';
		  j++;
		  
		  resultString=resultString+localChar;
          //buf.setCharAt(j, localChar);
		 
		  if( ((localChar=='(' || localChar==')') && nextChar!=' ') 
				  ||
			  ( (nextChar=='(' || nextChar==')') && localChar!=' ')
			)
			  {
			    j++;
			    resultString=resultString + ' ';
			    //buf.setCharAt(j, ' ');
			  }
		 }
		 //resultString=buf.toString();
		 localListCompound= new listCompound(resultString);
		 return localListCompound;
	} // String spaced()
//	==========================================
} // class listCompound
