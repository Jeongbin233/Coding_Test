class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []

        for i in range(numRows):
            sub = []
            for j in range(i+1):
                if j==0 or j==i:
                    sub.append(1)
                else:
                    sub.append(ans[i-1][j-1]+ans[i-1][j])
            ans.append(sub)

        return ans