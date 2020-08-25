//class MinCost {
//public:
//    int findMinCost(string A, int n, string B, int m, int c0, int c1, int c2) {
//        // write code here
//        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
//        for(int i=0;i<=n;i++)
//            dp[i][0]=c1*i;
//        for(int i=1;i<=m;i++)
//            dp[0][i]=c0*i;
//        for(int i=1;i<=n;i++)
//        {
//            for(int j=1;j<=m;j++)
//            {
//                if(A[i-1]==B[j-1])
//                    dp[i][j]=dp[i-1][j-1];
//                else
//                    dp[i][j]=min(dp[i-1][j-1]+c2,min(dp[i-1][j]+c1,dp[i][j-1]+c0));
//            }
//        }
//        return dp[n][m];
//    }
//};
