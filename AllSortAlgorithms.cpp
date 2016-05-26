#include<iostream>
using namespace std;
	
//Function definition for each sort algorighms
void selectionSort(int A[],int n){
		//Scan the the minimumm values move till n-2
		for(int i=0;i<n-1;i++){
			//hold the minimum value by an other variable
			int iMin=i;
			//Go through the whole index to update iMin values
			for(int j=i+1;j<n;j++){
				if(A[j]<A[iMin])
					iMin=j;
			}
//			int temp=A[i];
//			A[i]=A[iMin];
//			A[iMin]=temp;
			//use built in function called swap() from "algorithm" class library
			if(iMin!=i){
				swap(A[i],A[iMin]);
			}
			
		}
}

void bubbleSort(int B[],int n){
	for(int k=0;k<n;k++){
		int flag=0;
		for(int i=0;i<n-1;i++){
			if(B[i]>B[i+1]){
				swap(B[i],B[i+1]);
				flag=1;
			}
		}
		if(flag==0){
				break;
			}
	}
}

void insertionSort(int C[],int n){
	int i,j;
	for(i=1;i<n;i++){
		j=i;
		while(j>0 && C[j-1]>C[j]){
			swap(C[j],C[j-1]);
			j--;
		}
	}
}

int main(int argc, char **argv)
{
		int SIZE;
		cout<<"Enter the amounts of array.\n";
		cin>>SIZE;
		int* a=new int[SIZE];//Dynamic memory allocation
		cout<<"Enter each Elements: \n";
		for(int k=0;k<SIZE;k++){
			cout<<"Enter index "<<k<<": ";
			cin>>a[k];
		}
	//	int a[]={5,2,4,1,9};
		cout<<"Arrays before Sort : ";
		for(int k=0;k<SIZE;k++){
			cout<<" "<<a[k];
		}
		cout<<"\n";

//		selectionSort(a,SIZE);
		bubbleSort(a,SIZE);
	//	insertionSort(a,SIZE);
		cout<<"Array after Sort : ";
		for(int i=0;i<SIZE;i++)
		cout<<" "<<a[i];
		cout<<"\n";
	
	return 0;
}


