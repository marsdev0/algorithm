package code.two_pointers.lc_658;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author geyan
 * @date 2025/11/29
 */
class Solution {

    // 双指针实现
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (right - left + 1 == k) {
                break;
            }
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.delta != o2.delta) {
                    return o1.delta - o2.delta;
                }
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            int delta = Math.abs(arr[i] - x);
            queue.offer(new Node(arr[i], delta));
        }

        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            k--;
            result.add(queue.poll().val);
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return result;
    }

    static class Node {
        int val;
        int delta;

        Node(int val, int delta) {
            this.val = val;
            this.delta = delta;
        }
    }
}
