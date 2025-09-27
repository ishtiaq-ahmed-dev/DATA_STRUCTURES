#include<iostream>
#include <cstdlib> 
using namespace std;

int main(){
	int T_Workers,P_Workers,presents=0;
	
	cout<<"Enter the Number of Total workers: ";
	cin>>T_Workers;
	
	
	bool *ptrCalloc = (bool*) calloc(T_Workers , (sizeof(bool)));
	cout<<"\nEnter the Roll No of the Present Workers One by One and Type ( 0 ) Once Done: ";

	for(int x=0;x<T_Workers;x++){
	cin>>P_Workers;
	if (P_Workers==0){
		break;
	}
	if (P_Workers>0 && P_Workers<=T_Workers){
		ptrCalloc[P_Workers-1]=1;
		presents++;
	}else{
		cout<<"Please enter the Roll No in Range.";
	}}

	
	for(int x=0;x<T_Workers;x++){
		if (ptrCalloc[x]==1){
			cout<<"Roll No "<<x+1<<" is Present.\n";
		}
	}
	
	cout<<"\nTotal Present Workers are :" <<presents;
	cout<<"\nTotal Absent Workers are :" <<T_Workers-presents;
	free(ptrCalloc);
	ptrCalloc = nullptr;
	return 0;
}