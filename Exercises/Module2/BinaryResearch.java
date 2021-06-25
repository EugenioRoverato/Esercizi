package ToDo;

public class BinaryResearch
{
    public static void main(String[] args)
    {
        int[] numbers = new int[]{1,3,7,8,9,15,18,29,30,31};
        int numToFind = 18;
        int start = 0, end = numbers.length-1, mid = (start+end)/2;
        System.out.println(binaryResearch(numbers, numToFind, start, end, mid));
    }

    public static int binaryResearch(int[] nums, int target, int start, int end, int mid)
    {
        if (target == nums[mid]) return mid;
        if (target < nums[mid])
            return binaryResearch(nums, target, start, (end+start)/2, (end+start)/2-1);
        else
            return binaryResearch(nums, target, (end+start)/2, end, (end+start)/2+1);
    }
}
