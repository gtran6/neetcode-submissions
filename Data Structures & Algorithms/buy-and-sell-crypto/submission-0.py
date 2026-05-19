class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        right = 1
        maxP = 0

        while right < len(prices):
            if prices[left] < prices[right]:
                currP = prices[right] - prices[left]
                maxP = max(maxP, currP)
            else:
                left = right
            right += 1
        
        return maxP