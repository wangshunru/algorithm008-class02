public  static  String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        if (chars.length < 2) return S;
        int left = 0;
        int right = chars.length-1;
        while (left < right){
            while (left < right && !isChar(chars[left])) left++;
            while (left < right && !isChar(chars[right])) right--;
            if (left < right){
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left ++;
                right--;
            }
        }
        return new String(chars);
    }
    public static boolean isChar(char c){
        return  (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }
