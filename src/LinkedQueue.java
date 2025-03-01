public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private class Link {
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

    private Link front;
    private Link back;

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
        if (isEmpty()) {
            front = new Link(toInsert);
            back = front;
        } else {
            Link walker = front;
            T check = walker.getData();
            while (check.compareTo(toInsert) > 0){
                walker.setLink(walker.getLink());
            }
            Link insert = new Link(toInsert);

        }
    }

    public boolean isEmpty() {return back.getData() == null;}

    private void setFront(Link front){this.front = front;}

    private void setBack(Link back){this.back = back;}
}
