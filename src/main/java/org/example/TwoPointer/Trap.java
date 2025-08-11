package org.example.TwoPointer;

import java.util.Arrays;
import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for(int i = 1; i < height.length; i++){
            int peek = height[stack.peek()];
            if(peek > height[i]){
                stack.push(i);
            }else if(peek < height[i]){
                while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int mid = stack.pop();
                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        int high = Math.min(height[left], height[i]) - height[mid];
                        int width = i - left - 1;
                        int area = high * width;
                        if(area > 0) res += area;
                    }
                }
                stack.push(i);
            }
            else{
                stack.pop();
                stack.push(i);
            }
        }
        return res;
    }
}
