# CodePathPrep

## Checkpoint 2

### Prettyprint
Print concentric rectangular pattern in a 2d matrix.

Solution

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

### KthSmallest
Find the kth smallest element in an unsorted array of non-negative integers.

Solution:
Idea: As we can't modify the array, we can't do any sorting with it
  Therefore we will use an additional space - heap of size k
  
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

## Checkpoint 5

