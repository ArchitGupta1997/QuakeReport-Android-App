#include<iostream>
#include<math.h>
using namespace std;
int main()
{
	int n;
	cout<<"Enter the size of the array:";
	cin>>n;
	int i;
	int a[n];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	int step=floor(sqrt(n));
	i=0;
	int x,fag=0;
	cout<<"Enter the value of x to find:";
	cin>>x;
	while(x>=a[i])
	{
		if(x==a[i])
		{
		
		cout<<"Found at:"<<i;
		flag=1;
	}
		else
		i=i+step;
	}
	
	return 0;
}
