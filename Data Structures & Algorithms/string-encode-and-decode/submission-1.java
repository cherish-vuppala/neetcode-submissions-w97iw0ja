class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < strs.size(); j++) {
            String str = strs.get(j);
            if (str.isEmpty())
                sb.append("EMPTY");
            for (int i = 0; i < str.length(); i++) {
                int asciiValue = (int) str.charAt(i);
                asciiValue = (asciiValue + 1) % 256;
                sb.append((char)asciiValue);
            }
            if (j != strs.size()-1)
                    sb.append(";");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] strings = str.split(";");
        List<String> strs = new ArrayList<>();

        for (String string: strings) {
            StringBuilder sb = new StringBuilder();
            if (!"EMPTY".equals(string)) {
                for (int i = 0; i < string.length(); i++) {
                    int asciiValue = (int)string.charAt(i);
                    int originalValue = (asciiValue - 1) < 0 ? 256 + (asciiValue - 1) : 
                                        (asciiValue - 1);
                    sb.append((char)originalValue);
                }
                strs.add(sb.toString());
            } else {
                strs.add("");
            }
        }

        return strs;
    }
}
