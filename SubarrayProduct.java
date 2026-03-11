// Given an array of positive numbers, calculate the number of possible contiguous
// subarrays having product lesser than a given number K.
// Input : arr[] = [1, 2, 3, 4]
// K=10
// Output : 7
// The subarrays are {1}, {2}, {3}, {4}, {1, 2}, {1, 2, 3} and {2, 3}
// Input : arr[] = [1, 9, 2, 8, 6, 4,3]
// K=100
// Output : 16
// Input : arr[] = [10, 5, 2, 6]
// K=100
// Output : 8
public class SubarrayProduct {

    static int countSubarrays(int arr[], int k) {
        if (k <= 1) return 0;

        int product = 1;
        int left = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];

            while (product >= k) {
                product /= arr[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int arr1[] = {1,2,3,4};
        int k1 = 10;
        System.out.println(countSubarrays(arr1, k1));

        int arr2[] = {1,9,2,8,6,4,3};
        int k2 = 100;
        System.out.println(countSubarrays(arr2, k2));

        int arr3[] = {10,5,2,6};
        int k3 = 100;
        System.out.println(countSubarrays(arr3, k3));
    }
}