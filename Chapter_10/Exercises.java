import java.util.ArrayList;

public class Exercises {
    public void swapPairs(ArrayList<String> arrayList) {
        ArrayList<String> tempList = new ArrayList<String>();

        // Swap the first item with the item after
        for(int i = 0; i < arrayList.size(); i+=2) {
            tempList.add(arrayList.get(i + 1));
            tempList.add(arrayList.get(i));
        }

        // If the ArrayList is odd, tack on the last item
        if(arrayList.size() % 2 == 1)
            tempList.add(arrayList.get(arrayList.size() - 1));

        arrayList.clear();
        arrayList = tempList;
    }

    public void minToFront(ArrayList<Integer> arrayList) {
        
    }
}
