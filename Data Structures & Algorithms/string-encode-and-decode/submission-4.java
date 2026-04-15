class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        //length#str
        for (var str: strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();

        while (i < str.length()) {
            int j = i;
            
            // find hash
            while (str.charAt(j) != '#')
                j++;
            
            int length = Integer.parseInt(str.substring(i, j));
            j++; // move past #

            String substr = str.substring(j, j+length);
            result.add(substr);

            i = j + length;
        }

        return result;
    }
}
