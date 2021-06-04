# Java Backend Course - Tree School
## Exercises

#### _Module 1_ - Syntax and Naming

Level | Contents
:---: | :---: |
:kick_scooter: | [Arithmetic operators](Exercises/ArithmeticOperators.java)
:kick_scooter: | [Even and odd](Exercises/EvenOdd.java)
:kick_scooter: | [Invert string](Exercises/InvertString.java)
:kick_scooter: | [Replace intruders](Exercises/ReplaceIntruders.java)
:kick_scooter: | [Compare strings](Exercises/CompareStrings.java)

#### _Module 2_ - Syntax and Naming

Level | Contents
:---: | :---: |
:kick_scooter: | [Count occurrences in a string](Exercises/)
:kick_scooter: | [String reverse](Exercises/)
:kick_scooter: | [Prime number](Exercises/)
:kick_scooter: | [Factorial](Exercises/)
:kick_scooter: | [Harmonic sum](Exercises/)
:kick_scooter: | [Palindrome string](Exercises/)
:kick_scooter: | [Seconds to days, hours, minutes and seconds](Exercises/)
:kick_scooter: | [Fibonacci](Exercises/)
:kick_scooter: | [Anagrams](Exercises/)
:kick_scooter: | [Min and Max](Exercises/)
:kick_scooter: | [Diagonal sum](Exercises/)
:motor_scooter: | [Bingo](Exercises/)
:kick_scooter: | [Stack overflow](Exercises/)
:kick_scooter: | [Cipher of Caesar](Exercises/)
:kick_scooter: | [Find the prime numbers](Exercises/)
:motor_scooter: | [Sum array values ricursively](Exercises/)
:motor_scooter: | [Recursive palindrome string](Exercises/)
:motor_scooter: | [Triangle of tartaglia](Exercises/)
:motor_scooter: | [Find the perfect numbers](Exercises/)
:motorcycle: | [Binary search](Exercises/)
:motorcycle: | [Mergesort](Exercises/)
:motorcycle: | [Full bingo](Exercises/)
:motorcycle: | [Crossword puzzle](Exercises/)

#### _Module 3_ - Git

Level | Contents
:---: | :---: |
:motorcycle: | [Labyrinth](Exercises/)

### Leetcode Exercises

<details>
<summary> [Two Sum] (https://leetcode.com/problems/two-sum/) </summary>
  
    public static void main(String[] args)
    {
        int[] a = new int[] {3,3};
        int b = 6;

        for (int element : twoSum(a,b))
            System.out.println(element);
    }
    
    public static int[] twoSum(int[] a, int b) 
    {
        int[] temp = new int[2];
        for (int k = 0 ; k < a.length - 1 ; k++)
        {
            for (int i = 0 ; i < a.length; i ++)
            {
                if (a[k] + a[i] == b && k != i)
                {
                    temp[0] = k;
                    temp[1] = i;
                    return temp;
                }
            }
        }
        return temp;
    }
</details>

<details>
<summary> [Merge Sorted Array] (https://leetcode.com/problems/merge-sorted-array/) </summary>
  
    public static void main(String[] args)
    {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] n1, int m, int[] n2, int n)
    {
        for (int i = m; i < m+n; i++)
            n1[i]=n2[i-m];
        Arrays.sort(n1);
        for (int y : n1) System.out.print(y);
    }
</details>
  
<details>
<summary> [Move Zeroes] (https://leetcode.com/problems/move-zeroes/) </summary>

    public static void main(String[] args)
    {
        int[] array = new int[] {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(array);
    }

    static void moveZeroes(int[] a)
    {
        for (int k = 0 ; k < a.length ; k ++)
        {
            if (a[k] == 0)
            {
                for (int j = k+1 ; j < a.length ; j++)
                {
                    if (a[j] != 0)
                    {
                        a[k] = a[j];
                        a[j] = 0;
                        break;
                    }
                }
            }
        }

        for (int x : a)
            System.out.println(x);
    }
</details>
  
<details>
<summary> [Shuffle the Array] (https://leetcode.com/problems/shuffle-the-array/) </summary>
  
    public static void main(String[] args)
    {
        int[] array = new int[] {7,6,4,3,1,9,8,1};
        int target = 4;

        for (int x : shuffle(array, target))
        {
            System.out.print(x + " ");
        }
    }

    public static int[] shuffle(int[] nums, int n)
    {
        int[] temp = new int[2*n];
        int k = 0, z = n;
        for (float i = 0 ; i < 2*n ; i++)
        {
            if (i % 2 == 0) // Se pari --> X
            {
                temp[(int)i] = nums[k];
                k++;
            }
            else // Se dispari --> Y
            {
                temp[(int)i] = nums[z];
                z++;
            }
        }

        return temp;
    }
</details>
  
<details>
<summary> [Array Partition I] (https://leetcode.com/problems/array-partition-i/) </summary>
  
    public static void main(String[] args)
    {
    int[] array = new int[] {6,2,6,5,1,2};
    System.out.print(arrayPairSum(array));
    }

    public static int arrayPairSum(int[] a)
    {
        Arrays.sort(a);
        int res = 0;
        for (int i = 0 ; i < a.length ; i ++)
        {
            if (i % 2 == 0)
            {
                res+=a[i];
            }
        }
        return res;
    }
</details>

<details>
<summary> [Best Time to Buy and Sell Stock II] (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) </summary>
  
    public static void main(String[] args)
    {
        int[] array = new int[] {};

        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] a)
    {
        int profit = 0;

        for (int i = 0 ; i < a.length - 1 ; i++)
        {
            if (a[i] < a[i+1])
            {
                profit += a[i+1]-a[i];
            }
        }

        return profit;
    }
</details>
  
<details>
<summary> [Partition Array Into Three Parts With Equal Sum] (https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/) </summary>
  
    public static void main(String[] args)
    {
        int[] array = new int[] {0,0,0,0};
        System.out.print(canThreePartsEqualSum(array));
    }

    public static boolean canThreePartsEqualSum(int[] a)
    {
        float sum = 0;
        for (int x : a)
            sum += x;

        if (sum % 3 != 0)
            return false;

        sum /= 3;

        int temp = 0;
        int count = 0;
        for (int i = 0 ; i < a.length ; i++)
        {
            temp += a[i];
            if (temp == sum)
            {
                count++;
                temp = 0;
            }
        }

        if (count >= 3)
            return true;

        return false;
    }
</details>
