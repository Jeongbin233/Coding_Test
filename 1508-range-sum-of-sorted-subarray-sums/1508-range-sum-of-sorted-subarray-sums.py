class Solution(object):
    def rangeSum(self, nums, n, left, right):
        """
        :type nums: List[int]
        :type n: int
        :type left: int
        :type right: int
        :rtype: int
        """

        arr = []
        for i in range(len(nums)):
            sum = 0
            index = i
            while(index < len(nums)):
                sum+=nums[index]
                arr.append(sum)
                index += 1
        
        arr.sort()
        ans = 0
        for i in range(left-1, right):
            ans += arr[i]

        return ans%(10**9+7)
        