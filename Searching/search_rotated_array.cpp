#include<bits/stdc++.h>
using namespace std;
int pivot_find(int a[],int l,int h)
{
    if(h<l)
        return -1;
    if(l==h)
        return l;
    int mid = (l+h)/2;
    if((a[mid]>a[mid+1])&&mid<h)
        return mid;
    if((a[mid]<a[mid-1])&&mid>l)
        return (mid-1);
    if(a[l]>=a[mid])
        return pivot_find(a,l,mid-1);
    if(a[l]<a[mid])
        return pivot_find(a,mid+1,h);
}
int bs(int a[],int l,int h,int e)
{

    int mid = (l+h)/2;
    if(h<l)
       return -1;
    if(a[mid] == e)
    return mid;
    else if(a[mid]>e)
        return bs(a,l,(mid-1),e);
    return bs(a,(mid+1),h,e);
}
int search_element(int a[],int n,int e)
{
    int pivot = pivot_find(a,0,(n-1));
    if(pivot==-1)
        return bs(a,0,(n-1),e);
    if(a[pivot] == e)
        return pivot;
    if(a[0]<=e)
        return bs(a,0,(pivot-1),e);
    return bs(a,(pivot+1),(n-1),e);
}


int main()
{
    int a[]={2,3,4,5,1,2};
    int n=sizeof(a)/sizeof(a[0]);
    int e;
    cout<<"Enter the element to be searched for:";
    cin>>e;
    int i=search_element(a,n,e);
    cout<<"\nElement found at location:"<<i;
    return 0;
}
