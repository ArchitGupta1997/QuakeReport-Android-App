#include<bits/stdc++.h>
using namespace std;

int first(int a[],int l,int h,int x,int n)
{
    if(h>=l)
    {
        int mid = (l+h)/2;
        if((mid==0||x>a[mid-1])&&a[mid] == x)
            return mid;
        else if(x>=a[mid])
            return first(a,mid+1,h,x,n);
        else
            return first(a,l,mid-1,x,n);
    }
    return -1;
}
int last(int a[],int l,int h,int x,int n)
{
    if(h>=l)
    {
        int mid = (l+h)/2;
        //cout<<mid<<" ";
        if((mid==n-1||a[mid+1]>x)&&a[mid] == x)
            return mid;
        else if(x>=a[mid])
            return last(a,(mid+1),h,x,n);
        else
            return last(a,l,mid-1,x,n);

    }
    //cout<<'\n';
    return -1;
}
int count(int a[],int x,int n)
{
    int i,j;
    i = first(a,0,(n-1),x,n);
    if(i == -1)
        return i;
    j = last(a,0,(n-1),x,n);
    //cout<<i<<j<<'\n';
    return (j-i+1);

}
int main()
{
    int a[] = {1,2,2,3,3,3,3};
    int x=1;
    int n=7;
    int c = count(a,x,n);
    cout<<c<<'\n';
    return 0;
}
