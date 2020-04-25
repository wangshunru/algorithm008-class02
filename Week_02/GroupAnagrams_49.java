public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> l:lists) {
            System.out.println(l);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0;i < strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> value = new ArrayList<String>();
                value.add(strs[i]);
                map.put(key,value);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
