#include<bits/stdc++.h>

using namespace std;

int max_ele(int a[],int l,int h)
{
    if(l==h)
        return a[l];
    if(h==(l+1)&&a[l]>a[h])
        return a[l];
    if(h==(l+1)&&a[l]<=a[h])
    return a[h];

    int mid = (l+h)/2;

    if(a[mid]>a[mid-1]&&a[mid]>a[mid+1])
        return a[mid];
    if(a[mid]>a[mid-1]&&a[mid]<a[mid+1])
        return max_ele(a,(mid+1),h);
    else
        return max_ele(a,l,mid-1);
}

int main()
{

    int a[]={1,3,50,10,9,7,6};
    int n = 7;
    cout<<max_ele(a,0,n-1);
    return 0;
}
