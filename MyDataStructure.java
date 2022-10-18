import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyDataStructure<T> {
    private final int INITIAL_NUM_BUCKETS = 25;
    private List<T>[] buckets;
    private int size;

    public MyDataStructure(){
        buckets = new List[INITIAL_NUM_BUCKETS];
        Arrays.fill(buckets, null);
        size = 0;
    }

    public void add(T element){
        if(size / buckets.length >= 2){
            increaseBuckets();
        }
        int hash = element.hashCode();
        int index = hash % this.buckets.length;
        List<T> children = this.buckets[index];

        if(children == null){
            List<T> linkedlst = new LinkedList<>();
            linkedlst.add(element);
            buckets[index] = linkedlst;
            size++;
        }else{
            if(!children.contains(element)){
                children.add(element);
                size++;
            }
        }
    }

    private void increaseBuckets(){
        int newBucketsNum = buckets.length * 2;
        List<T>[] newBuckets = new List[newBucketsNum];
        Arrays.fill(newBuckets, null);

        for(int i = 0; i < buckets.length; i++){
            LinkedList<T> tmp = (LinkedList<T>) buckets[i];
            for(int j = 0; j < tmp.size(); j++){
                T element = tmp.get(i);
                int hash = element.hashCode();
                int index = hash % newBucketsNum;
                if(newBuckets[index] == null){
                    List<T> linkedlst = new LinkedList<>();
                    linkedlst.add(element);
                    newBuckets[index] = linkedlst;
                }else{
                    if(!newBuckets[index].contains(element)){
                        newBuckets[index].add(element);
                    }
                }
            }
        }

        buckets = newBuckets;
    }

    public void remove(T element){
        int hash = element.hashCode();
        int index = hash % buckets.length;

        LinkedList<T> children = (LinkedList<T>) buckets[index];
        if(children != null){
            if(children.remove(element)) size--;
        }
    }

    public int size(){
        return this.size;
    }
}
