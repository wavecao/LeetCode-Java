    /*
    先对直径d  进行升序排序，如果遇到 d 相同的情况，则按照高度 h 降序排序。之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
    
    这个解法的关键在于，对于直径d相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证在 d 相同的数对中最多只选取一个。
    */
    public int maxBoxes(int[][] boxes) {
        int n = boxes.length;
        Arrays.sort(boxes,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] == b[1] ? b[0]-a[0] : a[1]-b[1];
            }
        });
        
        int[] heights = new int[n];
        for(int i=0; i<n; i++)
            heights[i] = boxes[i][0];
        
        return lengthOfLIS(heights);
    }
    
    public int lengthOfLIS(int[] nums) { //动态规划 最长递增子数组  dp[i]:以num[i]结尾的最长递增子数组   N^2
    int[] dp = new int[nums.length];
    // base case：dp 数组全都初始化为 1
    Arrays.fill(dp, 1);
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) 
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    int res = 0;
    for (int i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
}
