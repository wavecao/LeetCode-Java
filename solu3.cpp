#include<cstdio>
#include<cmath>
#include<cstring>
using namespace std;
int n,m,r,c,s[20][20],ans=1e9,p[20];
void pd(){
    int f[20][20],u,h;
    memset(f,0,sizeof(f));
    for (int i=1;i<=c;i++)
    for (int j=0;j<m;j++)
    {
        f[i][j]=1e9;u=0;
        for (int k=1;k<r;k++)
        u+=abs(s[p[k]][j]-s[p[k-1]][j]);
        if (i<2)
        {f[i][j]=u;if (i==c && f[i][j]<ans)ans=f[i][j];continue;}
        for (int k=0;k<j;k++)
        {
            h=0;
            for (int l=0;l<r;l++)
            h+=abs(s[p[l]][k]-s[p[l]][j]);
            if (i<2)h=0;
            if (f[i-1][k]+u+h<f[i][j])f[i][j]=f[i-1][k]+u+h;
        }
        if (i==c && f[i][j]<ans)ans=f[i][j];
    }
}
void ccj(int x,int y){
    if (y>r)return;
    if (x==n)
    {
        if (y<r)return;
        pd();
        return;
    }
    p[y]=x;ccj(x+1,y+1);ccj(x+1,y);
}
int main()
{
    scanf("%d%d%d%d",&n,&m,&r,&c);
    for (int i=0;i<n;i++)
    for (int j=0;j<m;j++)
    scanf("%d",&s[i][j]);
    ccj(0,0);
    printf("%d",ans);
    return 0;
