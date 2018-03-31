#include<bits/stdc++.h>
using namespace std;

int find_min(int a[],int l,int h)
{
    if(h<l)
        return a[l];
    if(h==l)
        return a[l];
    int mid = (l+h)/2;

    if(mid<h&&a[mid+1]<a[mid])
        return a[mid+1];
    if(mid>l&&a[mid]<a[mid-1])
        return a[mid];
    if(a[h] > a[mid])
        return find_min(a,l,mid-1);
    return find_min(a,(mid+1),h);
}

int main()
{
    int a[] = {5,0,1,2,3,4};
    int n = 6;
    cout<<find_min(a,0,(n-1));
    return 0;

}
