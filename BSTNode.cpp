#include <stdio.h>
#include <iostream>
using namespace std;

struct BSTNode{
	int data;
	BSTNode *left;
	BSTNode *right;
};


struct BSTNode* newNode(int data) 
{
   BSTNode* root = new BSTNode;
                      
  root->data  = data;
  root->left  = NULL;
  root->right = NULL;
   
  return(root);
}
 

struct BSTNode* InsertTree(struct BSTNode* root, int data) 
{
  /* 1. If the tree is empty, return a new,     
      single node */
  if (root == NULL) 
    return(newNode(data));  
  else
  {
    /* 2. Otherwise, recur down the tree */
    if (data <= root->data) 
        root->left  = InsertTree(root->left, data);
    else
        root->right = InsertTree(root->right, data);
   
    /* return the (unchanged) node pointer */
    return root; 
  }
}
 

int minValue(struct BSTNode* root) {
  struct BSTNode* current = root;
 
  /* loop down to find the leftmost leaf */
  while (current->left != NULL) {
    current = current->left;
  }
  return(current->data);
}
 

void Preorder(BSTNode *root){
	if(root==NULL) return;
	cout<<"Data are : "<<root->data<<endl;
	Preorder(root->left);
	Preorder(root->right);
}

void Inorder(BSTNode *root){
	if(root==NULL) return;
	Inorder(root->left);
	cout<<"Data are : "<<root->data<<endl;
	Inorder(root->right);
}

void Postorder(BSTNode *root){
	if(root==NULL) return;
	Postorder(root->left);
	Postorder(root->right);
	cout<<"Data are : "<<root->data<<endl;
}

int main()
{
	BSTNode* root=NULL;
	int ch;
	
	label:
	cout<<"\t\t Menu \n";
	cout<<"\t1. For Insertion.\n";
	cout<<"\t2. For Preorder.\n";
	cout<<"\t3. For Inorder.\n";
	cout<<"\t4. For Postorder.\n";	
	cout<<"\t5. For Find Min.\n";
	cout<<"\t6. For Exit\n";
	cout<<"\tSelect Option.\n";
	cin>>ch;
	
	switch(ch){
		case 1:
			int data;
			int nodes;
			cout<<"How many times u want to Insert ?\n";
			cin>>nodes;
			for(int i=1;i<=nodes;i++){
				cout<<"Enter Data to be Inserted.\n";
				cin>>data;
				root=InsertTree(root,data);
				cout<<"Inserted.\n";	
			}
			
			break;
		case 2:
			Preorder(root);
			break;
		case 3:
			Inorder(root);
			break;
		case 4:
			Postorder(root);
			break;
		case 5:
			minValue(root);
			break;
		case 6:
			cout<<"Good bye..!\n";
			break;
		default:
			cout<<"Out of Inputs.\n";
	}
	
	if(ch!=5)goto label;
	return 0;
}

