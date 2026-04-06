class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }

        int[] mainArr = new int[26];
        int[] arrMov = new int[26];

        for (int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            mainArr[ch - 'a']++;

            char ch2 = s2.charAt(i);
            arrMov[ch2 - 'a']++;
        }
        if (Arrays.equals(mainArr, arrMov)){
            return true;
        }


        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()){
            
            char leftCh = s2.charAt(left);
            char rightCh = s2.charAt(right);
            if (right >= s1.length()){
                arrMov[rightCh - 'a']++;            
            }

            if (Arrays.equals(mainArr, arrMov)){
                return true;
            }
            
            arrMov[leftCh - 'a']--;            
            left++;
            right++;
        }
        return false;
    }
}
