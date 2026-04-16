class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            char[] keyArr = str.toCharArray();
            Arrays.sort(keyArr);
            String key = String.valueOf(keyArr);
            groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        for (List<String> group : groupMap.values()) {
            res.add(group);
        }
        return res;
    }
}
