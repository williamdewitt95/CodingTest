import java.util.*;




// public GNode[] getChildren(){

// }
public class problem2{
	/*
	*Recursively walk through each GNode's children until we hit the end leaf(s)
	*
	*Make an  arraylist of ArrayList<GNode>
	*Check if the current node (passed in as GNode node) has children
	*	if it does: call paths(GNode) on each of its children 
	*				add the current node on to front of each path, then add the results of each call to the current arraylist of arraylists
	*	if it does not: make a new path, add current node to it, add it to the arraylist of arraylists
	*return the list
	*/
	public static ArrayList<ArrayList<GNode>> paths(GNode node){//If the function was without
		ArrayList<ArrayList<GNode>> allPaths = new ArrayList<ArrayList<GNode>>();
		
		GNode[] currentChildren = node.getChildren();
		if (currentChildren.length > 0){//if have children
			for(int i=0; i<currentChildren.length; i++){//For each child currently have

				ArrayList<ArrayList<GNode>> tempList = paths(currentChildren[i]);//ArrayList of paths from current children down to the current children's leaves
				for(int j=0; j<tempList.size(); j++){//For each path
					ArrayList<GNode> tempPath = tempList.get(j);//this will always be an arraylist of GNodes
					tempPath.add(0,node);//Add self to front since everything is branching from self
					allPaths.add(tempPath);//add them to list of everything of current and below
				}
			}

		}
		else{
			ArrayList<GNode> path = new ArrayList<GNode>();
			path.add(node);//add self first
			allPaths.add(path);
		}

		return allPaths;//should never return an empty arraylist

	}





	public static void pathsTester(){//will match the output given in the example output for problem 2
		GNode a = new GNode("A");
		GNode b = new GNode("B");
		GNode c = new GNode("C");
		GNode d = new GNode("D");
		GNode e = new GNode("E");
		GNode f = new GNode("F");
		GNode g = new GNode("G");
		GNode h = new GNode("H");
		GNode i = new GNode("I");
		GNode j = new GNode("J");


		a.addChild(b);
		a.addChild(c);
		a.addChild(d);

		b.addChild(e);
		b.addChild(f);

		c.addChild(g);
		c.addChild(h);
		c.addChild(i);
		
		d.addChild(j);

		ArrayList<ArrayList<GNode>> allPaths = paths(a);
		System.out.print("\n( ");
		for(int k=0; k<allPaths.size();k++){//go through all the paths we have from the paths() method
			System.out.print("(");
			for(int m=0; m<allPaths.get(k).size();m++){//go through all the nodes in the path
				ArrayList<GNode> tempPrint = allPaths.get(k);//the arraylists contained in allPaths will always be ArrayList<GNode>
				System.out.print(tempPrint.get(m).getName());//print the names of the nodes (easy visualization)
			
			}
			System.out.print(") ");
		}
		System.out.print(")");
	}


public static void main (String[] args){
	
	pathsTester();


}

}


