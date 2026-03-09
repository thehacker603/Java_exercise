import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CustomCollection implements Iterable<String> {
   
private List<String> collection = new ArrayList<>();
public CustomCollection(String [] items) {
    /* 
    for (String item : items) {
        collection.add(item);
        }
    }*/
    collection.addAll(Arrays.asList(items));
    // commented method and add all doesthe exat same thing but uin a much efficent way
}

@Override
public Iterator<String> iterator() {
    return collection.iterator();
}
}