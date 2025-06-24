package name.lorenzani.andrea.leet.metaprep._20250518.nestedlistweightsum;

import java.util.List;

interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // The result is undefined if this NestedInteger holds a nested list
      Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // The result is undefined if this NestedInteger holds a single integer
      List<NestedInteger> getList();
  }


public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int level) {
        int result = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) result += ni.getInteger() * level;
            else result += depthSum(ni.getList(), level+1);
        }
        return result;
    }
}
