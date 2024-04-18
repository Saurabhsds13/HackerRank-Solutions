package advanced;
/*Design Pattern Used:
Visitor Pattern: This pattern is used to separate algorithms from the objects on which they operate. Here, each concrete visitor (SumInLeavesVisitor, ProductRedNodesVisitor, and FancyVisitor) implements a specific algorithm to operate on the tree structure, without modifying the tree itself. The TreeVis abstract class defines the interface for visiting nodes and leaves, providing a common interface for all concrete visitors.
Logic and Functionality:
The code constructs a tree based on the input provided, where each node has a value and a color (red or green).
It then applies three different visitors to the tree, each calculating a specific result based on the nodes' values and colors.
After visiting the tree with each visitor, it retrieves the result from each visitor and prints them as required.
In summary, the code efficiently utilizes the Visitor pattern to apply different algorithms (visitors) to a tree structure without modifying the tree itself. It separates the concerns of tree traversal and algorithm implementation, making the code modular, maintainable, and extensible.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
  RED,
  GREEN
}

abstract class Tree {
  private int value;
  private Color color;
   int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }

  public Color getColor() {
    return color;
  }

  public int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree { //  Represents a node in the tree structure. It has properties such as value, color, depth, and children. It's used for non-leaf nodes.
  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree { //Represents a leaf node in the tree structure. It has properties similar to TreeNode but without children. It's used for leaf nodes.

  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis { //This is an abstract class representing the Visitor pattern. It defines methods getResult, visitNode, and visitLeaf which are to be implemented by concrete visitor classes.

  public abstract int getResult(); // Returns the result of visiting the tree.

  public abstract void visitNode(TreeNode node); //Method to visit non-leaf nodes in the tree.

  public abstract void visitLeaf(TreeLeaf leaf);//Method to visit leaf nodes in the tree.
}

class SumInLeavesVisitor extends TreeVis { //Calculates the sum of the values in the tree's leaves only.

	private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // We don't need to do anything with non-leaf nodes for this visitor
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis { //: Calculates the product of values stored in all red nodes, including leaves, computed modulo 10^9 + 7.

	 private long result = 1;
	    private static final int MOD = 1000000007;

	    public int getResult() {
	        return (int) result;
	    }

	    public void visitNode(TreeNode node) {
	        if (node.getColor() == Color.RED) {
	            result = (result * node.getValue()) % MOD;
	        }
	    }

	    public void visitLeaf(TreeLeaf leaf) {
	        if (leaf.getColor() == Color.RED) {
	            result = (result * leaf.getValue()) % MOD;
	        }
	    }
}

class FancyVisitor extends TreeVis { // Calculates the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and the sum of values stored in the tree's green leaf nodes.

	private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class JavaVisitorPattern {
	 private static int[] values;
	    private static Color[] colors;
	   private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();
	    
  public static Tree solve() {  //Constructs the tree from the input provided. It reads the number of nodes, their values, colors, and edges connecting them. It constructs tree nodes and leafs accordingly.
	  System.out.println("Enter details : ");
		Scanner in=new Scanner(System.in);
		int nnodes=in.nextInt();
		values= new int[nnodes];
		for(int i=0;i<nnodes;i++)values[i]=in.nextInt();
		colors = new Color[nnodes];
		for(int i=0;i<nnodes;i++)colors[i]=(in.nextInt()==0)?Color.RED:Color.GREEN;
		Tree rootNode;
		if(nnodes==1){
			rootNode=new TreeLeaf(values[0],colors[0],0);
		}else{
			rootNode=new TreeNode(values[0],colors[0],0);
			for(int i=0;i<(nnodes-1);i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				
				Set<Integer> uEdges = nodesMap.get(u);
				if(uEdges==null)uEdges = new HashSet<>();
				uEdges.add(v);
				nodesMap.put(u, uEdges);
				Set<Integer> vEdges = nodesMap.get(v);
				if(vEdges==null)vEdges = new HashSet<>();
				vEdges.add(u);
				nodesMap.put(v, vEdges);
			}
			for(int nodeid:nodesMap.get(1)){
				nodesMap.get(nodeid).remove(1);
				createEdge(rootNode, nodeid);
			}
		}
		in.close();
		return rootNode;
}

  private static void createEdge(Tree parent,int nodeid){
		Set<Integer> nodeEdges = nodesMap.get(nodeid);
		boolean hasChild = nodeEdges!=null && !nodeEdges.isEmpty();
		if(hasChild){
			TreeNode node = new TreeNode(values[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
			((TreeNode)parent).addChild(node);
			for(int neighborid:nodeEdges){
				nodesMap.get(neighborid).remove(nodeid);
				createEdge(node, neighborid);
			}
		}else{
			TreeLeaf leaf = new TreeLeaf(values[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
			((TreeNode)parent).addChild(leaf);
		}
	}

  public static void main(String[] args) { 
/*After constructing the tree, the code creates instances of each visitor (SumInLeavesVisitor, ProductRedNodesVisitor, and FancyVisitor).
It then applies each visitor to the tree root using the accept method. Each visitor traverses the tree, visiting nodes and/or leaves as per their logic.
Finally, it retrieves the result from each visitor and prints them.*/
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    int res1 = vis1.getResult();
    int res2 = vis2.getResult();
    int res3 = vis3.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
}