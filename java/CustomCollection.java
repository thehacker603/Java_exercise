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
    this.collection.addAll(Arrays.asList(items));
    // commented method and addall doesthe exat same thing but in a much efficent way
}

@Override
public Iterator<String> iterator() {
    return collection.iterator();
}
}
public class Main {
    public static void main(String[] args) {
        String[] items = {"apple", "banana", "cherry"};
        CustomCollection customCollection = new CustomCollection(items);
        
        for (String item : customCollection) {
            System.out.println(item);
        }
    }
}
// for now we can simpli use string but if we would have had class A class B extend A and class C extend A 
// we could have used A as the type and then we could have added both B and C to the collection and then 
// we could have iterated over it and we would have gotten both B and C objects.