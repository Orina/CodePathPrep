# CodePathPrep
## Checkpoint 1
<img src="https://github.com/Orina/CodePathPrep/blob/master/checkpoint1.png"></img>

## Checkpoint 2
<img src="https://github.com/Orina/CodePathPrep/blob/master/checkpoint2.png"></img>
### Prettyprint
Print concentric rectangular pattern in a 2d matrix.

Solution:
  1. calculate the number of rows/cols as N = 2*a - 1
  2. create an empty matrix (List of List) and populate it with zeroes
  3. print by layer from offset = 0 to a
        1. print top horizontal line
        2. print right vertical line
        3. print bottom horizontal line
        4. print left vertical line.
  4. return matrix
 
  time: O(N^2)  
  space: O(N^2)  
 
## Checkpoint 3
<img src="https://github.com/Orina/CodePathPrep/blob/master/checkpoint3.png"></img>
### KthSmallest
Find the kth smallest element in an unsorted array of non-negative integers.

Solution: As we can't modify the array, we can't do any sorting with it. Therefore we will use an additional data structure - max-heap of size k
  
  1. Create an empty heap and add first k-elements to it.
  2. Traverse through the array from a[k]...a[n-1]
  3. each a[i] element compare with top heap element (max element in the heap), if the top heap is greater than current element:
      1. remove the heap top
      2. add current element to the heap
 4. return the top heap element - it will be the k-th smallest element in the initial array
 
  time: O(n), n - number of elements in the array  
  space: O(k), k - given number
 
### NumRange
Given an array of non negative integers A, and a range (B, C), find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Solution: brute-force with 2 loops
Has to be a better solution, but don't know how to do.

Time: O(N^2)  
Space: O(1)  
 
## Checkpoint 4
<img src="https://github.com/Orina/CodePathPrep/blob/master/checkpoint4.png"></img>
### NextGreater
Given an array, find the next greater element G[i] for every element A[i] in the array.

Solution: traverse the array from right to left and if we meet a number A[i] bigger than already seen numbers A[i+1], A[i+2], ..A[N-1], than smallest numbers A[i+1], etc. are no longer needed.
 
  1. Create an empty stack
  2. Traverse initial array from right to left
  3. Remove from the stack elements which are smaller or equal to the current element
  4. Add top stack element to the result list (or -1 if stack is empty)
  5. Push to the stack current element.
  6. Reverse the result list (as we go backward)
 
  time: O(N), as we push/pop one element in stack only once  
  space: O(N)

### Subtract
Given a singly linked list, modify the value of first half nodes such that :
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value, and so on …
 
  Solution:
  1. find the middle element (use slow and fast pointers)
  2. separate the first half of the list from the second part
  3. reverse the second part of the list
  4. iterate in tandem the first and reversed second parts, update the values in the first part of the list
  5. reverse again the second part back to it's initial state
  6. concat the first and second parts of the list.
 
  time: O(n), n - number of nodes in the list  
  space: O(1)
 
## Checkpoint 5
<img src="https://github.com/Orina/CodePathPrep/blob/master/checkpoint5.png"></img>
### All Unique Permutations
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

  Main idea: 
  1. use recursion
  2. use hash map with key = distinct value
                       value = count of frequences of that value in the array
 
  time: O(n!)  
  space: O(n)

### Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Solution: create a hash map with key = value of elements in the array
  value = boolean indicates did we already we count the consecutive sequence with that number or not
 
  1. create a hash map and put all elements with false values, as we did not process any element yet
  2. maintain a global maxCount
  3. traverse through the array and check every element a[i]
      1. if element a[i] has "true" value in hash map, this means that we already calculate the count of that consecutive sequence, ignore it
      2. go to the left side: check if there exists values = a[i]-1, a[i]-2, etc in the hash map, if so, increment the local count and update the hash map for that values
      3. do the same for the right side.
      4. compare local max with global max.
 4. return global max.
 
  time: O(n)?  
  space: O(n)
