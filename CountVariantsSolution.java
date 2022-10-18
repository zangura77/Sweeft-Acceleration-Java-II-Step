public class CountVariantsSolution {

    /* Recursive approach */
    private int countVariantsRecursive(int stairCount){
        if(stairCount == 1 || stairCount == 2){
            return stairCount;
        }else if(stairCount <= 0){
            return 0;
        }

        return countVariantsRecursive(stairCount - 1) + countVariantsRecursive(stairCount - 2);
    }

    /* If we look closely this recursion is same as fibonacci recursion */
    private int countVariantsIterative(int stairCount){
        if(stairCount == 1 || stairCount == 2){
            return stairCount;
        }else if(stairCount <= 0){
            return 0;
        }

        int first = 0;
        int second = 1;
        int result = 0;

        for(int i = 0; i < stairCount; i++){
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

}
