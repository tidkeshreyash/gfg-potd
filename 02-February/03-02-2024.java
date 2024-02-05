class Solution
{
    static final long MOD = 1000000007;
   long DecimalValue(Node head)
   {
 	    long result = 0;

        while (head != null) {
            result = (result * 2 + head.data) % MOD;
            head = head.next;
        }

        return result;
   }
}
