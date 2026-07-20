class Solution {
    public int reverseBits(int n) {
        var binary = Integer.toBinaryString(n);
        var padding = ("0").repeat(32 - binary.length());
        
        StringBuilder sb = new StringBuilder();
        sb.append(padding);
        sb.append(binary);
        sb.reverse();

        return Integer.parseInt(sb.toString(), 2);
    }
}
