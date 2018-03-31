#include<iostream>
using namespace std;
int bsearch(int low,int high);
int f(int x)
{
	return (x*x -10*x -20);
}
int findfirst()
{
	if(f(0)>0)
	return 0;
	int i=1;
	while(f(i)<=0)
	i=i*2;
	return bsearch(i/2,i);
}
int bsearch(int low,int high)
{
	if(high>=low)
	{
		int mid=low+(high-low)/2;
		if(f(mid)>0 && (mid==low||f(mid-1)<=0))
		return mid;
		if(f(mid)<=0)
		return bsearch((mid+1),high);
		else
		return bsearch(low,(mid-1)); 
	}
	return -1;
}
int main()
{
	cout<<"The value of n where f becomes positive is"<<findfirst();
	return 0;
}
