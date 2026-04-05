class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i  = 0 ;
        int j  = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                merge[index] = nums1[i];
                i++;
            } else {
                merge[index] = nums2[j];
                j++;
            }
            index++; 
        }
        while (i < nums1.length){
            merge[index] = nums1[i];
            index++;
            i++;
        }

        while (j < nums2.length){
            merge[index] = nums2[j];
            index++;
            j++;
        }

        if (index % 2 == 1){
            return merge[index / 2] * 1.0; 
        }
        return (merge[index / 2] + merge[(index / 2) - 1]) / 2.0;
    }
}
