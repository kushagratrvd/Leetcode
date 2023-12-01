import java.util.Scanner;

class Solution {
    static int[] twoSum(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Return an empty array if no solution is found
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int l = sc.nextInt();
        int nums[] = new int[l];
        System.out.println("Enter the elements of the array: ");
        for (int k = 0; k < l; k++) {
            nums[k] = sc.nextInt();
        }
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("[" + result[0] + "," + result[1] + "]");
        } else {
            System.out.println(" No solution found.");
        }
    }
}

