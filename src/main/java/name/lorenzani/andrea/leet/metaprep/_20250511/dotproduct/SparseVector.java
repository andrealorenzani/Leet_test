package name.lorenzani.andrea.leet.metaprep._20250511.dotproduct;

import java.util.HashMap;

class SparseVector {

    HashMap<Integer, Integer> sparsevector;

    SparseVector(int[] nums) {
        sparsevector = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]!=0){
                sparsevector.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        HashMap<Integer, Integer> bigger, smaller;
        if(sparsevector.size()>=vec.sparsevector.size()){
            bigger = sparsevector;
            smaller = vec.sparsevector;
        }
        else {
            bigger = vec.sparsevector;
            smaller = sparsevector;
        }
        for(Integer key: smaller.keySet()){
            if(bigger.containsKey(key)) {
                result += smaller.get(key) * bigger.get(key);
            }
        }
        return result;
    }
}
