public class Node{
    public Node next;
    int value;
}

public class LinkedList{
    public Node first;
    
    /*Find intersection point of two lists (Y shaped)*/
    public static Node intersection(LinkedList l1, LinkedList l2){
        //Implementation using HashSet
        HashSet <Nodee> set = new HashSet <Node>();
        Node curr = l1.first;
        while(curr !=null){
            set.add(curr);
            curr = curr.next;
        }
        curr = l2.first;
        while(curr != null){
            if(set.contains(curr))
                return curr;
            curr = curr.next;
        }
        return null;
    }
    public static Node intersection(LinkedList l1, LinkedList l2){
        //Implementation without using extra storage
        int len1 = l1.length();
        int len2 = l2.length();
        Node n1, n2;
        if(len1 >= len2){
            n1 = l1.first;
            n2 = l2.first;
        }
        else{
            n2 = l1.first;
            n1 = l2.first;
        }
        for(int i=0; i<Math.abs(len1-len2); i++){
            n1 = n1.next;
        }
        while(n1!=null && n2!=null){
            if(n1 == n2)
                return n1;
            n1 = n1.next;
            n2 = n2.next;
        }
    }
    /*Function to het the length of a list*/
    public int length(){
        Node curr = first;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;            
        }
        return count;
    }
    
    /*Find if a linked list has a loop*/
    public boolean hasLoop(){
        Node slow = first;
        Node fast = first;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }
    
    /*Delete duplicates in a singly linked list*/
    public deleteDuplicates(){
        HashSet <Node> set = new HashSet <Node> ();
        Node curr = first;
        Node follower = null;
        while(curr!=null){
            if(set.contains(node)){
                follower.next = curr.next;
                curr = curr.next;
            }
            else{
                follower = curr;
                curr = curr.next;
            }
        }
    }
    
    /*Merge two sorted linked lists*/
    public LinkedList merge(LinkedList l1, LinkedList l2){
        LinkedList lst = new LinkedList(merge(l1.first, l2.first));
    }
    public Node merge(Node n1, Node n2){
        ArrayList <Node> lst = new ArrayList <Node>();
        while(n1!=null || n2!=null){
            if(n1.value <= n2.value){
                lst.add(n1);
                n1=n1.next;
            }
            else{
                lst.add(n2);
                n2=n2.next;
            }
        }
        Node first = lst.get(0);
        for(int i=0; i<lst.size()-1; i++){
            lst.get(i).next = lst.get(i+1);
        }
    }
}
