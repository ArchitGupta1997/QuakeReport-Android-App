#include<bits/stdc++.h>
using namespace std;
void pair_diff(int a[],int n,int x)
{
    int i,diff,j;
    for(i=0,j=1;i<n&&j<n;)
    {
        diff = a[j] - a[i];
        if(i!=j&&diff == x)
        {
            cout<<a[i]<<","<<a[j]<<'\n';
            break;
        }
        else if(diff < x)
            j++;
        else
            i++;
    }
}
int main()
{
    int a[1000];
    int n,i;
    cout<<"Enter the no of elements:";
    cin>>n;
    for(i=0;i<n;i++)
    {
        cin>>a[i];
    }
    sort(a,a+n);
    int x;
    cout<<"Enter the difference between pair:";
    cin>>x;
    pair_diff(a,n,x);
    return 0;
}
