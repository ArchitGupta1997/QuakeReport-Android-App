#include<bits/stdc++.h>
using namespace std;

int median(int a[],int n)
{

    if(n%2==0)
        return (a[n/2]+a[(n-1)/2])/2;
    else
        return a[n/2];
}
int get_median(int a1[],int a2[],int n)
{
    if(n==1)
        return (a1[0]+a2[0])/2;
    int m1 = median(a1,n);
    int m2 = median(a2,n);

    if(m1==m2)
        return m1;
    if(n==2)
        return (max(a1[0],a2[0])+min(a1[1],a2[1]))/2;
    if(m1<m2)
    {

        if(n%2==0)
            return get_median(a1+n/2-1,a2,n-n/2+1);
         return get_median(a1+n/2,a2,n-n/2);
    }
    if(n%2==0)
        return get_median(a2+n/2-1,a1,n-n/2+1);
    return get_median(a2+n/2,a1,n-n/2);
}
    int main()
{
    int ar1[] = {1, 12, 15, 17,26,38};
    int ar2[] = {2,11,13,16,19,30};
    int n1 = sizeof(ar1)/sizeof(ar1[0]);
    int n2 = sizeof(ar2)/sizeof(ar2[0]);
    if (n1 == n2)
        printf("Median is %d", get_median(ar1, ar2, n1));
    else
        printf("Doesn't work for arrays of unequal size");
    return 0;
}


