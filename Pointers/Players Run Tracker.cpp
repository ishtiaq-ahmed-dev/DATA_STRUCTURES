#include<iostream>
#include <cstdlib>

using namespace std;

int main(){
	
	int T_Players,count=0;
	cout<<"Enter the Total Players participating: ";
	cin>>T_Players;
	
	int *ptrMalloc = (int*) malloc(T_Players * (sizeof(int)));
	
	while(count < T_Players){
		
		cout<<"Enter the Score of player "<<count+1<<" : " ;
		cin>>ptrMalloc[count];
		count++;
	}
	
	for (int i=0;i <T_Players ;i++){
		cout<<"Player "<<i+1<<" Runs are "<<ptrMalloc[i] <<"\n";
	}
	free(ptrMalloc);
	ptrMalloc=nullptr;
	
	return 0;
}