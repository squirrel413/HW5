public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    public class Link {
        private T data;
        private Link link;

        public Link(T data, Link link){
            this.data = data;
            this.link = link;
        }

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
        if (isEmpty()) {
            return null;
        } else {
            T toReturn = front.getData();
            front = front.getLink();
            return toReturn;
        }
    }

    public void enqueue(T toInsert) {
        if (this.isEmpty()) {
            front = new Link(toInsert);
            back = front;
        } else {
            //Link walker = new Link(front.getData(), front.getLink());
            Link walker = front;
            T check = walker.getData();
            if (check.compareTo(toInsert) <= 0) {
                front = new Link(toInsert,front);
            } else {
                //get the data of what walker is pointing to
                if (front.equals(back)) {
                    Link insert = new Link(toInsert);
                    front.setLink(insert);
                    back = insert;
                } else {
                    check = walker.getLink().getData();
                    while (check.compareTo(toInsert) > 0 && !walker.equals(back)) {
                        walker = walker.getLink();
                        if (!walker.equals(back)) {
                            check = walker.getLink().getData();
                        }
                    }
                    if (walker.equals(back)) {
                        back = new Link(toInsert);
                        walker.setLink(back);
                    } else {
                        Link insert = new Link(toInsert, walker.getLink());
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
