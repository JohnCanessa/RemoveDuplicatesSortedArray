import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class RemoveDuplicatesSortedArray {


    /**
     * Auxiliary method to swap values in array.
     * Switched to in-line code for performance.
     * 
     * !!! NO LONGER USED !!!
     */
    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * Given a sorted array nums, 
     * remove the duplicates in-place such that each element appears only once 
     * and returns the new length.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 40.9 MB, less than 43.42% of Java online submissions.
     */
    static int removeDuplicates1(int[] nums) {
       
        // **** sanity checks ****
        if (nums == null || nums.length <= 1)
            return nums.length;
        
        // **** initialization ****
        int i = 0;
        int j = 1;

        // **** traverse array swapping elements ****
        while (i < (nums.length - 1) && j < nums.length) {

            // **** compare elements ****
            for ( ; j < nums.length; j++) {

                // **** swap elements (if needed) ****
                if (nums[i] < nums[j]) {

                    // **** swap elements ****
                    // swap(nums, i + 1, j);
                    int tmp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = tmp;

                    // **** increment index ****
                    i++;
                }
            }
        }

        // **** return new length ****
        return i + 1;
    }


    /**
     * Given a sorted array nums, 
     * remove the duplicates in-place such that each element appears only once 
     * and returns the new length.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 41.2 MB, less than 13.42% of Java online submissions.
     */
    static int removeDuplicates(int[] nums) {

        // **** sanity checks ****
        if (nums == null || nums.length <= 1)
            return nums.length;

        // **** initialization ****
        int i = 1;

        // **** traverse nums array O(n) ****
        for (int j = 0; j < nums.length - 1; j++) {

            // **** update nums[i] and i (if needed) ****
            if (nums[j] != nums[j + 1])
                nums[i++] = nums[j + 1];

            // ???? ????
            // System.out.println("<<< j: " + j + " nums: " + Arrays.toString(nums));
        }

        // **** return new length ****
        return i;
    }


    /**
     * Test scaffold.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
     
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] array ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();
        
        // ????? ????
        System.out.println("main <<<   nums: " + Arrays.toString(nums));
        
        // **** make a copy of nums ****
        int[] tmp = nums.clone();

        // **** invoke method and display results ****
        System.out.println("main <<< output: " + removeDuplicates1(nums));

        // **** restore nums ****
        nums = tmp.clone();

        // ????? ????
        System.out.println("main <<<   nums: " + Arrays.toString(nums));      

        // **** invoke method and display results ****
        System.out.println("main <<< output: " + removeDuplicates(nums));
    }
}