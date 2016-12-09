import java.util.*;


public class problem1{
	/*
	*Recursively walk through each GNode's children and them to the list
	*
	*Make an  arraylist of GNodes, add self
	*Beginning with the first node, check if it has children
	*	if it does: call walkGraph(GNode) on each of its children and add the results of each call to the current arraylist
	*	if it does not: do nothing
	*return the list
	*/
	public static ArrayList<GNode> walkGraph(GNode g){
		ArrayList<GNode> walkGraphList = new ArrayList<GNode>();//this will list 
		walkGraphList.add(g);//add self first
		GNode[] currentChildren = g.getChildren();
		if (currentChildren.length > 0){//if have children
			for(int i=0; i<currentChildren.length; i++){//For each child currently have

				ArrayList<GNode> tempList = walkGraph(currentChildren[i]);//ArrayList of children current children have
				for(int j=0; j<tempList.size(); j++){//For each child of current children

					walkGraphList.add(tempList.get(j));//add them to list of everything of current and below
				}

			}
		}

		return walkGraphList;//should never return an empty arraylist

	}




	public static void walkGraphTester(){
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

		b.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);

		f.addChild(h);
		f.addChild(i);

		i.addChild(j);

		ArrayList<GNode> walk = walkGraph(a);
		for(int k=0; k<walk.size();k++){//loop through all the nodes we added from the walkGraph() function
			System.out.println(walk.get(k).getName());//print their names (easy visualization)
		}
	}


public static void main (String[] args){

	walkGraphTester();


}

}


