#include<bits/stdc++.h>
using namespace std;

int search(int a[],int l,int h,int key)
{
    if(l>h)
        return -1;
    int mid = (l+h)/2;
    if(a[mid] == key)
        return mid;
    if(a[l]<=a[mid])
    {
        if(key>=a[l]&&key<=a[mid])
            return search(a,l,mid-1,key);
        return search(a,mid+1,h,key);
    }
    if(key>=a[mid]&&key<=a[h])
        return search(a,mid+1,h,key);
    return search(a,l,mid-1,key);
}
int main()
{
    int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    int key = 9;
    int i = search(arr, 0, n-1, key);
    if (i != -1) cout << "Index: " << i << endl;
    else cout << "Key not found\n";
    return 0;
}
