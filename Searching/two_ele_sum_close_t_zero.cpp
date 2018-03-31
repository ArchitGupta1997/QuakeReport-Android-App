#include<bits/stdc++.h>
using namespace std;

void exchange(int *x,int *y)
{

    int temp=*x;
    *x=*y;
    *y=temp;
}
int partition(int a[],int l,int r)
{

    int x=a[r];
    int i=l-1;
    int j;
    for(j=l;j<r;j++)
    {

        if(a[j] <=x)
        {

            i++;
            exchange(&a[i],&a[j]);
        }
    }
    exchange(&a[i+1],&a[r]);
    return i+1;
}

void qs(int a[],int l,int r)
{
    int q;
    if(l<r)
    {
        q=partition(a,l,r);
        qs(a,l,q-1);
        qs(a,q+1,r);
    }
}


void minAbsSumPair(int a[],int n)
{
    int sum,min_sum = INT_MAX;
    int l=0,r=(n-1);
    int min_l = l,min_r = (n-1);
    qs(a,0,(n-1));

    while(l < r)
    {
        sum = a[l] + a[r];
        if(abs(sum) < abs(min_sum))
        {

            min_sum = sum;
            min_l = l;
            min_r = r;
        }
        if(sum < 0)
            l++;
        else
            r--;
    }

    cout<<"The two elements whose sum is min are"<<a[min_l]<<","<<a[min_r];

}

int main()
{
  int a[]={1,60,-10,70,-80,85};
  int n = sizeof(a)/sizeof(a[0]);
  minAbsSumPair(a,n);
  return 0;
}
