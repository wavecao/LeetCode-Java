package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-08  20:32
 */
public class LC_122 {
    /**
     * 贪心算法：
     * <pre>
     *     我们借助 “差分” 这个概念，可以证明 “贪心算法” 的有效性。贪心算法就是选择那些所有差分（严格）大于 0 的数，把它们相加即可。
     *
     * 使用反证法：假设 “贪心算法” 得到的解并不是最优解，即我们还能够找到一个可行解比 “贪心算法” 得到的利润还多。差分数组中除了差分为正数的项以外，还有就是差分为 0 的项与差分为负数的项。“贪心算法” 是所有差分为正数的项的和。
     *
     * 1、如果可行解在 “贪心算法” 的基础上，选择了差分为 0 的项，得到的结果与“贪心算法”得到的结果一样，因此加上差分为 0 的项不会比“贪心算法”得到的结果更好；
     *
     * 2、如果可行解在 “贪心算法” 的基础上，选择了差分为负数的项，加上一个负数得到的结果一定比 “贪心算法” 得到的结果要少，加上差分为负数的项，一定比 “贪心算法” 得到的结果更少；
     *
     * 3、如果可行解在 “贪心算法” 的基础上，去掉了任何一个差分为正数的项，同上，得到的结果一定比 “贪心算法” 得到的结果要小，因此，“贪心算法” 的所有组成项不能删去任何一个。
     *
     * 综上，除了 “贪心算法” 以外，找不到一个更优的解法，因此 “贪心算法” 就是最优解。（证完）
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * </pre>
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) maxProfit += diff;
        }
        return maxProfit;
    }

    public int maxProfit_1(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        //状态 dp[i][j] 定义如下:
        //第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
        //第二维 j 表示索引为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票（stock）。
        int[][] dp = new int[len][2];
        //第0天什么都不做，收益为0
        dp[0][0] = 0;
        //第0天买入，收益为当天价格的相反数
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //                  ↓前一天没持有股票，今天也不买     ↓前一天持有股票，今天卖了
            dp[i][0] = Math.max(dp[i-1][0],                 dp[i-1][1]+prices[i]);
            //                  ↓前一天持有股票，今天不卖        ↓前一天没持有股票，今天买了
            dp[i][1] = Math.max(dp[i-1][1],                 dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}
