#include<bits/stdc++.h>

using namespace std;

int fixed_point(int a[],int l,int h)
{
    if(h>=l)
    {
        int mid =(l+h)/2;
        if(a[mid] == mid)
            return mid;
        if(mid>a[mid])
            return fixed_point(a,(mid+1),h);
        else
            return fixed_point(a,l,mid-1);
    }
    return -1;
}
int main()
{

    int a[]={-10,-1,0,3,10,11,30,50,100};
    int n = 9;
    int ans = fixed_point(a,0,(n-1));
    cout<<ans;
    return 0;
}


