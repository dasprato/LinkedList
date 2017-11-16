import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.JarEntry;

class Node {
    private String Data;
    private Node Link;

    Node(String newData, Node nextLink) {
        Data = newData;
        Link = nextLink;
    }

    String getData() {
        return Data;
    }

    Node getNextLink() {
        return Link;
    }

    void setNextLink(Node nextLink) {
        this.Link = nextLink;
    }
}

class LinkedList {
    private Node headNode = null;

    void add(String data){
        if (headNode == null) {
            headNode = new Node(data, null);
        }
        else {
            Node nextNode = headNode;
            headNode = new Node(data, nextNode);
        }
    }

    @Override
    public String toString() {
        String toReturn = "The data from the nodes:";
        int count = 0;
        if (headNode != null) {
            String headDataToAdd = "\n" + headNode.getData();
            toReturn += headDataToAdd;
            Node nextNode = headNode.getNextLink();
            count++;
            while (nextNode != null) {
                String dataToAdd = "\n" + nextNode.getData();
                toReturn += dataToAdd;
                count++;
                nextNode = nextNode.getNextLink();
            }
        }
        String countString = "\n" + "There are " + count + " data values";
        toReturn += countString;
        return toReturn;
    }

     void sort() {
        LinkedList LLToReturn = new LinkedList();
        ArrayList<String> StoreArray = new ArrayList<>();

        if (this.headNode != null && this.headNode.getNextLink() == null) {
            StoreArray.add(this.headNode.getData());
        }
        else if (this.headNode != null && this.headNode.getNextLink() != null) {
            int totalNumber = 1;
            Node nextNodeForTotalNumber = this.headNode.getNextLink();
            while (nextNodeForTotalNumber != null) {
                totalNumber++;
                nextNodeForTotalNumber = nextNodeForTotalNumber.getNextLink();
            }
            while (StoreArray.size() != totalNumber) {
                String smallestValue = this.headNode.getData();

                Node nextNode = this.headNode.getNextLink();
                while (nextNode != null) {
                    if (smallestValue.compareTo(nextNode.getData()) > 0) {
                        smallestValue = nextNode.getData();

                    }
                    nextNode = nextNode.getNextLink();
                }
                if (this.headNode.getData().equals(smallestValue)) {
                    this.headNode = this.headNode.getNextLink();
                } else {
                    Node currentNode = this.headNode;
                    while (currentNode.getNextLink() != null) {
                        if (currentNode.getNextLink().getData().equals(smallestValue)) {
                            if (currentNode.getNextLink().getNextLink() == null) {
                                currentNode.setNextLink(null);
                                break;
                            } else {
                                currentNode.setNextLink(currentNode.getNextLink().getNextLink());
                                break;
                            }
                        }
                        currentNode = currentNode.getNextLink();
                    }
                 }
                StoreArray.add(smallestValue);
            }
        }
        for (int i = StoreArray.size() - 1; i > -1; i--) {
            LLToReturn.add(StoreArray.get(i));
        }
        this.headNode = LLToReturn.headNode;
    }
}

