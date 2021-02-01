
public class BinaryTree {
    static int temp[] = new int[Task38.nooffilewords];
    static int i = 0;


    public Node createNode(Word word) {
        Node node = new Node();
        node.word = word;
        node.left = null;
        node.right = null;
        return node;
    }

    public Node insert(Node node, Word word) {
        if (node == null) {
            node = createNode(word); 
            return node; 
        }
        if (node.word.getWord().compareTo(word.getWord()) == 0) {
            node.word.setWordsRepeated();
            return node;
        } else {
            if (word.getWord().compareTo(node.word.getWord()) < 0) {
                node.left = insert(node.left, word);
            } else if (word.getWord().compareTo(node.word.getWord()) > 0) {
                node.right = insert(node.right, word);
            } else if (word.getWord().compareTo(node.word.getWord()) == 0) {
                node = insert(node, word);
            } else
                return node;
        }
        return node;
    }

    public void showReverseorder(Node node) {
        if (node != null) {
            showReverseorder(node.right);

            System.out.println(node.word.getWord() + "  " + node.word.getWordsRepeated()); Task38.noofwords++;
            Task38.nodeData[i] = node.word;  
            Task38.wordsrepeated[i] = node.word.getWordsRepeated(); i++;  
            showReverseorder(node.left);

        }
    }

    public void showInOrder(Node node) {
        if (node != null) {
            System.out.println(node.word.getWord() + "  " + node.word.getWordsRepeated());
            showInOrder(node.left);
            showInOrder(node.right);
            
        }
    }

    public void frequencyReverse() {
        // System.out.println(Task38.nooffilewords);
        for(int j=0; j< Task38.noofwords;j++){
        for(int i=0; i< Task38.noofwords-1 ; i++){
            if(Task38.wordsrepeated[i]< Task38.wordsrepeated[i+1]){
                int temp = Task38.wordsrepeated[i];
                Task38.wordsrepeated[i] = Task38.wordsrepeated[i+1];
                Task38.wordsrepeated[i+1] = temp;
                Word tmp = Task38.nodeData[i];
                Task38.nodeData[i] = Task38.nodeData[i+1];
                Task38.nodeData[i+1] = tmp;

            }           
        }}
        for( int i=0; i<Task38.noofwords; i++){
            System.out.println(Task38.nodeData[i].getWord()+ " " + Task38.wordsrepeated[i]);
        }
    }

    public Node left() {
        if (Task38.node != null) {
            return Task38.node.left;
        } else
            return null;
    }

    public Node right() {
        if (Task38.node.right != null) {
            return Task38.node.right;
        } else
            return null;
    }

    public boolean hasLeft() {
        if (Task38.node.left != null) {
            return true;
        }
        return false;
    }

    public boolean hasRight() {
        if (Task38.node.right != null) {
            return true;
        }
        return false;
    }

    public boolean isInternal() {
        if (Task38.node.left != null || Task38.node.right != null) {
            return true;
        }
        return false;
    }

    public boolean isExternal() {
        if (Task38.node.left == null && Task38.node.right == null) {
            return true;
        }
        return false;
    }

    public boolean isRoot() {
        if (Task38.node != null) {
            return true;
        }
        return false;
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public boolean isEmpty() {
        if (Task38.node == null) {
            return true;
        }
        return false;
    }

    public void insertLeft(Word word) {
        if (Task38.node.left == null) {
            Task38.node.left.word = word;
        } else
            System.exit(1);
    }

    public void insertRight(Word word) {
        if (Task38.node.right == null) {
            Task38.node.right.word = word;
        } else
            System.exit(1);
    }

    public void addRoot(Word word) {
        if (Task38.node == null) {
            Task38.node.word = word;
        } else
            System.exit(1);
    }

}
