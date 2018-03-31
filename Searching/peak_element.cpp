#include<bits/stdc++.h>
using namespace std;

int find_peak(int a[],int l,int h)
{
    /*
    if(l==h)
        return l;
    if((l==(h+1))&&a[l]>=a[h])
        return l;
    if((l==(h+1))&&a[l]<a[h])
        return h;
        */
    if(h>l)
    {

        int mid = (l+h)/2;
        if((mid==0||a[mid]>=a[mid-1])&&(mid==(h-1)||a[mid]>=a[mid+1]))
            return mid;
        if(mid<(h-1)&&a[mid]<a[mid+1])
            return find_peak(a,(mid+1),h);
        else
            return find_peak(a,0,(mid-1));
    }
}

int main()
{
    int a[] =  {80, 90, 100, 165, 169, 170, 174};
    int n = sizeof(a)/sizeof(a[0]);
    int index = find_peak(a,0,(n-1));
    cout<<a[index];
    return 0;
}
