// Add your import statements here.


import java.io.BufferedReader;
import java.io.FileReader;

public class Test
{
    public static void main(String[] args)
    {
        LinkedList linkedList;  // the linked list of words

        linkedList = new LinkedList();
        buildLinkedList(linkedList);
        System.out.println(linkedList);
        linkedList.sort();
        System.out.println();
        System.out.println(linkedList);
    }

    public static void  buildLinkedList(LinkedList linkedList){
        /**
         * Open and read a file, and return the lines in the file as a list
         * of Strings.
         */

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splited = line.split(" ");
                for (int i = 0; i < splited.length; i++) {
                    linkedList.add(splited[i]);
                }
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
    
}