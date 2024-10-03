public class LinkedList
{
    private int listCount;
    private Node head;

    public LinkedList()
    {
        head = new Node();
        listCount = 0;
    }
    
    public void add(Node nextNode, int number)
    {
    	if (listCount == 0)
    	{
    		//for first node//
        	head = new Node(number);
        	head.setData(number);
    	}
    	else
    	{
    		//for every other node//
        	head = new Node(number, nextNode);
        	head.setNextNode(nextNode);
        	head.setData(number);
    	}
    	listCount++;
    }
    
    public void insert()
    {
    	head = new Node(nodeData, newNode);
    }
    
    public Node get(int index)
    {
    	head.getData;
    	return head.getNextNode;
    }
    
    public void remove()
    {
    	
    }
    
    public int size()
    {
    	
    }
}
