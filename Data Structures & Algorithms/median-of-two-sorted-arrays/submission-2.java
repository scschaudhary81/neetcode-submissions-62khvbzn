class Solution {


         /*
         1. Divide the array in left and right partion
         2. Done binary search on shorter array bcz if selecting bigger array there maybe lead to selecting a left  array that is greater than totalSize/2;
         3. If in left A end goes < 0 set mid/ i to -1
         4. If even rightmost of Left  + leftMost of right /2;
         5. If odd leftMost of right
         6. If leftMost element is out of array its -infinity && if  rightMost if out of array + Infinity



         []
         [1,2]

         -inf +inf
         1     2

          */
    double max(double a, double b) {
        return a > b ? a : b;
    }

    double min(double a, double b) {
        return a < b ? a : b;
    }

    public double findMid(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        int partion = (lenA + lenB) / 2;
        int start = 0;
        int end = a.length - 1;
        while (true) {
            int i = end < 0 ? -1 : (start + end) / 2;
            int j = partion - i - 2;
            double leftA = i >= 0 ? a[i] : Integer.MIN_VALUE;
            double rightA = i + 1 >= lenA ? Integer.MAX_VALUE : a[i + 1];
            double leftB = j >= 0 ? b[j] : Integer.MIN_VALUE;
            double rightB = j + 1 >= lenB ? Integer.MAX_VALUE : b[j + 1];

            if (leftA <= rightB && leftB <= rightA) {
                if ((lenA + lenB) % 2 == 0) {
                    return (min(rightA, rightB) + max(leftA, leftB)) / 2;
                } else {
                    return min(rightA, rightB);
                }
            } else if (leftA > rightB) {
                end = i - 1;
            } else {
                start = i + 1;
            }
        }

    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        return lenA < lenB ? findMid(a, b) : findMid(b, a);
    }
}