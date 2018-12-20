package algorithm;

import java.util.List;

public class Problem_385 {

      // This is the interface that allows for creating nested lists.
       // You should not implement it, or speculate about its implementation
       public interface NestedInteger {

           // @return true if this NestedInteger holds a single integer, rather than a nested list.
           public boolean isInteger();

           // @return the single integer that this NestedInteger holds, if it holds a single integer
           // Return null if this NestedInteger holds a nested list
           public Integer getInteger();

           // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
     }

    public NestedInteger deserialize(String s) {
        return new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public void setInteger(int value) {

            }

            @Override
            public void add(NestedInteger ni) {

            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        }
    }
}
