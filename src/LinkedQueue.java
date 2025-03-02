public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    /**
     * This class implements a PriorityQueue with linked nodes as the underlying
     * data structure to handle sorting and creating the queue. It contains methods
     * to enqueueing generic T type data, dequeueing generic T type data, and checking
     * if the queue is empty.
     * @author Nick Tibbels nst2038@gmail.com
     * @author Sam Whitney shw9601@rit.edu
     * */

    public class Link {
        /**
         * This class is the linked node, labeled link, which contains generic T
         * type data, and a link pointing to the next node.
         * @author Nick Tibbels nst2038@gmail.com
         * @author Sam Whitney shw9601@rit.edu
         * */
        private T data;
        private Link link;
        //Constructor to make a link that points to another link
        public Link(T data, Link link){
            this.data = data;
            this.link = link;
        }
        //Constructor to make a Link that points to null
        public Link(T data){
            this.data = data;
            this.link = null;
        }

        public T getData(){return data;}
        public Link getLink(){return link;}
        public void setLink(Link link){this.link = link;}
        public void setData(T data){this.data = data;}
    }

    public Link front;
    public Link back;

    public LinkedQueue(){}

    public T dequeue() {
        /**
         * This method removes the front T from the queue and returns it. Returns
         * null if the queue is empty.
         * */
        if (isEmpty()) {
            return null;
        } else {
            T toReturn = front.getData();
            front = front.getLink();
            return toReturn;
        }
    }

    public void enqueue(T toInsert) {
        /**
         * This method adds a T to the queue based on T's underlying
         * compareTo method for hierarchical positioning in the queue.
         * */
        if (this.isEmpty()) {
            //if the queue is empty, set front and back to point to the node
            //added, it is always front and back as the only link in the queue
            front = new Link(toInsert);
            back = front;
        } else {
            //if the queue is not empty we want to walk the queue to find the
            //position of where the link should be added
            Link walker = front;
            T check = walker.getData();
            if (check.compareTo(toInsert) <= 0) {
                //if what is to be inserted is larger than the first link, the
                //added link is the new front of the queue
                front = new Link(toInsert,front);
            } else {
                //if what is to be added is not added to the front there are cases:
                if (front.equals(back)) {
                    //for one node we add to the back and evade nullPointerException
                    Link insert = new Link(toInsert);
                    front.setLink(insert);
                    back = insert;
                } else {
                    //if the queue has > 1 link, look to the data walker's current link
                    //is pointing to and compare, then walk if the data to be inserted
                    //does not get inserted after walker
                    check = walker.getLink().getData();
                    while (check.compareTo(toInsert) > 0 && !walker.equals(back)) {
                        walker = walker.getLink();
                        if (!walker.equals(back)) {
                            //prevents nullPointerExceptions
                            check = walker.getLink().getData();
                        }
                    }
                    //if walker reaches the end of the queue without finding a place
                    //to insert, the data to be inserted is inserted at the end
                    if (walker.equals(back)) {
                        back = new Link(toInsert);
                        walker.setLink(back);
                    } else {
                        //otherwise add the data to be inserted after walker
                        Link insert = new Link(toInsert, walker.getLink());
                        //make whatever link walker currently is to point to
                        //the new link added in
                        walker.setLink(insert);
                    }
                }
            }
        }
    }

    public boolean isEmpty() {return front == null;}

    private void setFront(Link front){this.front = front;}

    private void setBack(Link back){this.back = back;}
}
