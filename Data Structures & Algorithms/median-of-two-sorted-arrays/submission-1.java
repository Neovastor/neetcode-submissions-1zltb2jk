class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrA;
        int[] arrB;
        if (nums1.length < nums2.length){
            arrA = nums1;
            arrB = nums2;
        } else {
            arrA = nums2;
            arrB = nums1;
        }
        int aLeft = 0;
        int aRight = arrA.length;
        int total = nums1.length + nums2.length;
        int half = total / 2;
    
        while (true) {
            int aMid = (aLeft + aRight) / 2 ;
            int bMid = half - aMid;

            int aLeftVal = aMid > 0 ? arrA[aMid - 1] : Integer.MIN_VALUE;
            
            int aRightVal = aMid < arrA.length ? arrA[aMid] : Integer.MAX_VALUE;
            
            int bLeftVal = bMid > 0 ? arrB[bMid - 1] : Integer.MIN_VALUE;

            int bRightVal = bMid < arrB.length ? arrB[bMid] : Integer.MAX_VALUE;


            if ((aLeftVal <= bRightVal) && (bLeftVal <= aRightVal) ) {
                if (total % 2 == 1){
                    return Math.min(aRightVal, bRightVal) / 1.0;
                } else {
                    return (Math.max(aLeftVal, bLeftVal) + Math.min(aRightVal, bRightVal)) / 2.0;
                }
            } else if (aLeftVal > bRightVal){
                aRight = aMid - 1;

            } else {
                aLeft = aMid + 1;
            }
        }

    }
}
