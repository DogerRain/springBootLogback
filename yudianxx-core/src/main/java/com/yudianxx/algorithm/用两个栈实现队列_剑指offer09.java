package com.yudianxx.algorithm;

import java.util.Stack;

/**
 * @author huangyongwen
 * @date 2021/3/12
 * @Description 两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 用两个栈实现队列_剑指offer09 {

    public static void main(String[] args) {
//        栈   先进后出

//        队列 先进先出

        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);


//        Stack<Integer> stacks = cQueue.getCQueue();
//        while (!stacks.empty()){
//            System.out.print(stacks.pop()+" ");
//        }
        System.out.println(cQueue.deleteHead());
    }

    //    static class CQueue {
//        Stack<Integer> stack1;
//        Stack<Integer> stack2;
//
//        public CQueue() {
//            stack2 = new Stack<>();
//        }
//
//        public void appendTail(int value) {
//            stack1 = new Stack<>();
//            while (!stack2.empty()){
//                stack1.push(stack2.pop());
//            }
//            stack2.push(value);
//
//            while (!stack1.empty()){
//                stack2.push(stack1.pop());
//            }
//        }
//
//        public int deleteHead() {
//            if (stack2.empty()){
//                return -1;
//            }
//           return stack2.pop();
//        }
//
//        public Stack getCQueue(){
//            return stack2;
//        }
//    }

}

/**
 * 真的强
 *
 * stack1 负责入列
 * stack2 负责删除
 *
 * 只需要把stack1、stack2转换一次就够了，等到stack2空了，就再转换一次
 *
 *
 */
class CQueue {
    //两个栈，一个出栈，一个入栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}