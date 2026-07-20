class Solution {
    public int reverseBits(int n) {
        int result = 0;
        System.out.println("input: " + n);

        for (int i = 0; i < 32; i++) {
            System.out.println("Iteration: " + (i+1));
            System.out.println("result before left shift: " + result);
            result <<= 1; 
            System.out.println("result after left shift: " + result);
            result |= (n & 1);
            System.out.println("result after ORRING with least significant bit: " + result);
            System.out.println("n before right shift: " + n);
            n >>>= 1;
            System.out.println("n after right shift: " + n);
            System.out.println("End of Iteration: " + (i+1));
            
        }

        return result;
    }
}
