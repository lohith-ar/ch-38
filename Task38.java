import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task38 {
    static int nooffilewords = 0;
    static Node node = null;
    static BinaryTree bt = new BinaryTree();
    static int noofwords = 0;
    static Word nodeData[] = new Word[154];
    static int wordsrepeated[] = new int[154];

    public static void main(String[] args) throws Exception {
        Task38.readFromFile("daffodils.txt");
        bt.showInOrder(node);
        System.out.println("----------Reverse order------------");
        bt.showReverseorder(node);

        // System.out.println(noofwords + "\n");
        System.out.println("-----------Frequency reverse order-----------");

        bt.frequencyReverse();

        // System.out.println("----------------------");
        // bt.showFrequentWords(node);
        // System.out.println("\n" + BinaryTree.noofwords);
        // for(int i=0; i<BinaryTree.temp.length-1; i++){
        // System.out.print(BinaryTree.temp[i]+" ");
        // }
    }

    public static void readFromFile(String fileName) throws Exception {
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] words = null;
            int i = 0;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[,':;.?]", "");
                words = line.split(" ");
                for (String word1 : words) {
                    Task38.nooffilewords++;
                    node = bt.insert(node, new Word(word1));
                    // w[i] = new Word(word1); i++;
                }
            }
        }

    }
}
