# randomized-quick-sort-java
RandomizedQuickSort java

Randomized Quick Sort algorithm.

PARTITION (A, p, r)
1. x = A[p]
2. i = p
3.  for j←p+1 to q
4.    do if A[j] ≤ x
1.      then i ← i+1
5.        exchange A[i]↔A[i]
6. exchange A[p] ↔A[i]
7. return i

RANDOMIZED-PARTITION (A, p, r)
1. I←RANDOM (p, r)
2. exchange A[p]↔A[i]
3. return PARTITION (A, p, r)

RANDOMIZED-QUICKSORT (A,p,r)
1. if p<r
2. then q←RANDOMIZED-PARTITION (A, p, r)
        RANDOMIZED-QUICKSORT (A, p, q-1)
        RANDOMIZED-QUICKSORT (A, q+1, r)
