public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int right = 0;
        char tmp;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' '){
                right = i - 1;
                while (left < right){
                    tmp = chars[right];
                    chars[left++] = chars[right];
                    chars[right--] = tmp;
                }
                left = i + 1;
            }
        }
        right = n - 1;
        while (left < right){
            tmp = chars[right];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }
