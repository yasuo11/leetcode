package algorithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        // 倒推
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(deck[deck.length - 1]);
        for (int i = deck.length - 2;i >= 0; i--) {
            deque.offerFirst(deque.pollLast());
            deque.offerFirst(deck[i]);
        }

        int[] res = new int[deck.length];
        for (int i = 0;i < deck.length;i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(new Problem_950().deckRevealedIncreasing(nums)));
    }
}
