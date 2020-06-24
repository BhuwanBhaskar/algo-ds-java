package gfg.array;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

import utils.Utils;

// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements/0

/**
    Given an unsorted array arr[] of size N, rotate it by D elements (clockwise). 

    Input:
    The first line of the input contains T denoting the number of testcases. First line of each test case contains two space separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. Subsequent line will be the N space separated array elements.

    Output:
    For each testcase, in a new line, output the rotated array.

    Constraints:
    1 <= T <= 200
    1 <= N <= 107
    1 <= D <= N
    0 <= arr[i] <= 105

    Example:
    Input:
    2
    5 2
    1 2 3 4 5 
    10 3
    2 4 6 8 10 12 14 16 18 20

    Output:
    3 4 5 1 2
    8 10 12 14 16 18 20 2 4 6

    Explanation :
    Testcase 1: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
 */
public class Rotations {

    // Move from right to left K must be positive
    // Note: Defn
    // Clockwise: Right to left
    // Counter-Clockwise: Left to Right

    // Simple: create and use an auxilliary space to rotate
    // Space: O(Size of Array)
    // Time: O(Size of Array)
    private static void method1(int[] arr, int k) {
        if(k <= 0 || k == arr.length) {
            return;
        }

        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i += 1) {
            temp[i] = arr[(i+k) % arr.length];
        }
        for(int i = 0; i < temp.length; i += 1) {
            arr[i] = temp[i];
        }
    }

    // Improvement over previous method in terms of space
    // Space: O(k)
    // Time: O(Size of arr)
    private static void method2(int[] arr, int k) {
        // from above method, it is obvious that temp does not have to be full
        // array with size of original array

        // we would need to store only first k element since for subsequent passes
        // some part of array itself would serve as cache
        int[] firstPassCache = new int[k];

        // (i + k) % k = 0 would find positions (i) which would be starting point for
        // each subsequent pass..
        // Element from 0 till i would be stored in above temp array
        // After that in each pass we would move element from i to (i - k) position
        // We would continue doing so untill i reaches till last possible solution of above eqn

        for(int i = 0; i < k; i += 1) {
            firstPassCache[i] = arr[i];
        }

        int last = 0;
        for(int i = k; i < arr.length; i += k) {
            // now we would need to move each element by k to right
            for(int j = i; j < arr.length && j < i + k; j += 1) {
                arr[last] = arr[j];
                last += 1;
            }
        }

        // now fill stored cache
        for(int i = 0; i < firstPassCache.length; i += 1) {
            arr[last + i] = firstPassCache[i];
        }
    }

    // Improvement over previous in term of space with bad time
    // This would rotate 1 by 1
    // Time: O(Size of arr * k)
    // Space: O(1)
    private static void rotateClockwiseByK(int[] arr, int k) {
        for(int i = 0; i < k; i += 1) {
            int temp = arr[0];
            for(int j = 0; (j + 1) < arr.length; j += 1) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        Rotations.rotateClockwiseByK(a, 2);
        Utils.prettyPrintArr(a);

        Rotations.rotateClockwiseByK(b, 3);
        Utils.prettyPrintArr(b);

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // int T = Integer.parseInt(st.nextToken());

        // int[][] testCases = new int[T][];
        // int[] rotations = new int[T];

        // for (int t = 0; t < T; t += 1) {
        //     st = new StringTokenizer(br.readLine());

        //     int N = Integer.parseInt(st.nextToken());
        //     rotations[t] = Integer.parseInt(st.nextToken());

        //     st = new StringTokenizer(br.readLine());
            
        //     testCases[t] = new int[N];
        //     for(int i = 0; i < N; i += 1) {
        //         testCases[t][i] = Integer.parseInt(st.nextToken());
        //     }
        // }

        // for(int t = 0; t < T; t += 1) {
        //     Rotations.rotateClockwiseByK(testCases[t], rotations[t]);
        //     Utils.printArray(testCases[t]);
        // }
    }
}