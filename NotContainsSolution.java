import java.util.HashSet;

public class NotContainsSolution {

    private int notContains(int[] array){
        HashSet<Integer> nums = new HashSet<>();

        for(int i = 0; i < array.length; i++){
            nums.add(array[i]);
        }

        for(int i = 1; i <= Integer.MAX_VALUE; i++){
            if(!nums.contains(i)){
                return i;
            }
        }

        return -1;
    }

}
