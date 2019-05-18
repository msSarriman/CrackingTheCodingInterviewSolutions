/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 * Hints: #5, #13, #29, #61, #101
 * - A palindrome is something which is the same when written forwards and backwards.
 * What if you reversed the linked list?
 * - Try using a stack
 * - Assume you have the length of the linked list. Can you implement this recursively?
 * - In the recursive approach (we have the length of the list), the middle is the base case:
 * iSPermutation(middle) is true. The node x to the immediate left of the middle:
 * What can that node do to check if x- >middle- >y forms a palindrome? Now suppose
 * that checks out. What about the previous node a? If x- >middle- >y is a palindrome,
 * how can it check that a - >x - >middle - >y- >b is a palindrome?
 * - Go back to the previous hint. Remember:There are ways to return multiple values. You
 * can do this with a new class.
 */
package chapter._02two;


public class IntQuest6 {
    public static void main(String[] args) {
        MyLinkedList<Character> myList = new MyLinkedList<>(); // Is a palindrome
        myList.addNode('a');
        myList.addNode('b');
        myList.addNode('c');
        myList.addNode('d');
        myList.addNode('k');
        myList.addNode('d');
        myList.addNode('c');
        myList.addNode('b');
        myList.addNode('a');

        MyLinkedList<Character> myList1 = new MyLinkedList<>(); // Is not a palindrome
        myList1.addNode('a');
        myList1.addNode('b');
        myList1.addNode('c');
        myList1.addNode('d');
        myList1.addNode('e');
        myList1.addNode('f');

        System.out.println(myList.isPalindrome());
        System.out.println(myList1.isPalindrome());
    }
}
