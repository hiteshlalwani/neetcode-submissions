class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // Parse the length and move pointer to the start of the actual string
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            
            // Extract the string based on the parsed length
            res.add(str.substring(i, i + length));
            i += length;
        }
        return res;
    }
}
