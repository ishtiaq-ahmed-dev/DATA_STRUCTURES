#include<iostream>
using namespace std;
struct node{
    int rating;
    string name;
    int hp;
    node* left;
    node* right;

    node(int val,string n,int h){
        rating=val;
        name=n;
        hp=h;
        left=nullptr;
        right=nullptr;
    }
};

class BST_FOR_LABEXAM{
private:
    node* root;
    node* add_new(node* root,int rat,string name,int hp){
        if(root==nullptr){
            node* n=new node(rat,name,hp);
            return n;}
        if(root->rating>rat){
            root->left =add_new(root->left,rat,name,hp);
        }else if(root->rating<rat){
            root->right=add_new(root->right,rat,name,hp);}
        return root;}

    node* findMin(node* root){
        while(root->left!=nullptr){
            root=root->left;}
        return root;
}

    node* findMaa(node* root){
        while(root->right!=nullptr){
            root=root->right;}
        return root;
    }

    node* leave(node* root,int rat,bool& found){
        if(root==nullptr){
        return nullptr;  }
        if(rat <root->rating){
            root->left =leave(root->left,rat,found);
        }else if(rat> root->rating){
            root->right=leave(root->right,rat,found);
        }else{
            found=true;
            if(root->left==nullptr&&root->right==nullptr){
                delete root;
                return nullptr;
            }else if(root->left==nullptr){
                node* temp= root->right;
                delete root;
                return temp;
            }else if(root->right==nullptr){
                node* temp=root->left;
                delete root;
                return temp;
            }else{
                node* succesor=findMin(root->right);
                root->rating=succesor->rating;
                root->name=succesor->name;
                root->hp=succesor->hp;
                bool dummy=false;
                root->right=leave(root->right,succesor->rating,dummy);
            }}
        return root;
    }

    node* search(node* root,int rat){
        if(root==nullptr){
            return nullptr;
        }
        if(root->rating==rat){
            return root;}
        if(rat<root->rating){
            return search(root->left,rat);
        }
        return search(root->right,rat);}

    node* findPrev(node* root,int a,node* b){
        if(root==nullptr){
            return b;
        } 
        if(root->rating<a){
            b=root;
            return findPrev(root->right,a,b);
        }else{
            return findPrev(root->left, a, b);
}   }

    node* findNeat(node* root,int a,node* b){
        if(root == nullptr){
            return b;
        }if(root->rating>a){
            b=root;
            return findNeat(root->left,a,b);
        }else{
            return findNeat(root->right,a,b);}
        }
    int countLess(node* root,int a){
        if(root == nullptr) {
            return 0;
        }if(root->rating<a){
            int c=1 + countLess(root->left, a) + countLess(root->right, a);
            return c;
        }else{
            return countLess(root->left,a);
        } }
    int countTotal(node* root){
        if(root ==nullptr) return 0;
        int d=1 + countTotal(root->left) + countTotal(root->right);
        return d;
    }

    node* findKth(node* root, int& k){
        if(root==nullptr){return nullptr;}
        node* left =findKth(root->left, k);
        if(left !=nullptr){return left;}
        k--;
        if(k == 0){return root;}
        return findKth(root->right,k);}

    void inorderRange(node* root,int L,int R,bool& found){
        if(root == nullptr) return;
        inorderRange(root->left,L,R,found);
        if(root->rating >=L && root->rating<=R){
            cout<<root->rating<<" "<<root->name<<" "<<root->hp<<"\n";
            found=true;}
        inorderRange(root->right,L,R,found);
    }

    int getHeight(node* root){
        if(root==nullptr){
            return -1;}
        int leftH=getHeight(root->left);
        int rightH=getHeight(root->right);
        
        return 1 + (leftH > rightH ? leftH : rightH);
    }

    int countLeaves(node* root){
        if(root==nullptr) return 0;
        if(root->left==nullptr && root->right==nullptr){
            return 1;
        }
        return countLeaves(root->left) + countLeaves(root->right);
    }

    bool findPath(node* root,int rat,node** path,int& pathLen){
        if(root==nullptr){
            return false;
        }
        path[pathLen++]=root;
        if(root->rating==rat){
            return true;
        } 
        if(rat < root->rating){
            if(findPath(root->left,rat,path,pathLen)){
                return true;}
        }else{
            if(findPath(root->right,rat,path,pathLen)) {
                return true;}
        }
        pathLen--;
        return false;
    }
public:
    BST_FOR_LABEXAM(){
        root=nullptr;
    }

    void join(int rat,string name,int hp){
        node* eaisting=search(root,rat);
        if(eaisting!=nullptr){
            cout<<"DUPLICATE\n";
        }else{
            root=add_new(root,rat,name,hp);
            cout<<"JOINED\n";
        }}

    void leave(int rat){
        bool found=false;
        root =leave(root,rat,found);
        if(found){
            cout<<"LEFT\n";
        }else{
            cout<<"NOT FOUND\n";
        }}

    void status(int rat){
        node* player=search(root,rat);
        if(player==nullptr){
            cout<<"NOT FOUND\n";
        }else{
            cout<<player->rating<<" "<<player->name<<" "<<player->hp<<"\n";
        }}

    void damage(int rat,int amount){
        node* player=search(root,rat);
        if(player==nullptr){
        cout<<"NOT FOUND\n";
        }else{
            player->hp=player->hp - amount;
            if(player->hp < 0) player->hp=0;
            cout<<"DAMAGED "<<player->hp<<"\n";
        }}

    void heal(int rat,int amount){
        node* player=search(root,rat);
        if(player==nullptr){
            cout<<"NOT FOUND\n";
        }else{
            player->hp=player->hp + amount;
            cout <<"HEALED "<< player->hp << "\n";
        }}
    void match(int a){
        if(root==nullptr){
            cout<<"EMPTY\n";
            return;
    }
        
        node* prev=findPrev(root,a,nullptr);
        node* neat=findNeat(root,a,nullptr);
        
        node* chosen=nullptr;
        
        if(prev != nullptr && neat == nullptr){
            chosen =prev;
        } else if(prev==nullptr && neat != nullptr){
            chosen =neat;
        } else if(prev != nullptr && neat != nullptr){
            int distPrev=a - prev->rating;
            int distNeat=neat->rating-a;
            if(distPrev<=distNeat){
                chosen=prev;
            }else{
                chosen=neat;
            }}
        if(chosen != nullptr){
            cout<<chosen->rating<<" "<<chosen->name<<" "<<chosen->hp<<"\n";
        }else{
            cout<<"EMPTY\n";
        }}

    void neat(int a){
        node* player=findNeat(root,a,nullptr);
        
        if(player==nullptr){
            cout<<"NONE\n";
        }else{
            cout<<player->rating<<" "<<player->name<<" "<<player->hp<<"\n";
        }}

    void prev(int a){
        node* player=findPrev(root,a,nullptr);
        if(player==nullptr){
        cout<<"NONE\n";
        }else{
            cout<<player->rating<<" "<<player->name<<" "<<player->hp<<"\n";
        }}

    void range(int L,int R){
        bool found=false;
        inorderRange(root,L,R,found);
        if(!found){
            cout<<"EMPTY\n";
        } }

    void rank(int a){
        int count=countLess(root,a);
        cout<<count<<"\n";
    }

    void kth(int k){
        int total=countTotal(root);
        if(k<1||k>total){
            cout<<"OUT OF RANGE\n";
            return;}
        int kCopy=k;
        node* player=findKth(root,kCopy);
        if(player!=nullptr){
            cout<<player->rating<<" "<<player->name<<" "<<player->hp<<"\n";
        }}

    void duel(int A,int B){
        if(search(root,A)==nullptr||search(root,B)==nullptr){
            cout<<"NOT FOUND\n";
            return;}
        
        node* pathA[1000];
        node* pathB[1000];
        int lenA=0,lenB=0;
        findPath(root,A,pathA,lenA);
        findPath(root,B,pathB,lenB);
        int i=0;
        while(i<lenA&&i<lenB&&pathA[i]==pathB[i]){
            i++; }
        int dist=(lenA-i)+(lenB-i);
        cout<<"DIST "<<dist<<"\n";
    }

    void stats(){
        int total=countTotal(root);
        cout<<"PLAYERS "<<total<<"\n";
        if(root==nullptr){
            cout<<"MIN NONE\n";
            cout<<"MAa NONE\n";
        }else{
            node* minNode=findMin(root);
            node* maaNode=findMaa(root);
            cout <<"MIN "<< minNode->rating<<"\n";
            cout <<"MAa "<<maaNode->rating<<"\n";}
        int h=getHeight(root);
        cout<<"HEIGHT "<<h<<"\n";
        
        int leaves=countLeaves(root);
        cout <<"LEAVES "<<leaves<<"\n";
    }
};

int main(){
    int Q;
    cin>>Q;
    BST_FOR_LABEXAM bst;
    for(int i=0;i< Q;i++){
        string command;
        cin>>command;
        if(command=="JOIN"){
            int rating,hp;
            string name;
            cin>>rating>>name>>hp;
            bst.join(rating,name,hp);
        }else if(command=="LEAVE"){
            int rating;
            cin>>rating;
            bst.leave(rating);
        }else if(command=="STATUS"){
            int rating;
            cin>>rating;
            bst.status(rating);
        }else if(command=="DAMAGE"){
            int rating,amount;
            cin>>rating>>amount;
            bst.damage(rating,amount);
        }else if(command=="HEAL"){
            int rating,amount;
            cin>>rating>>amount;
            bst.heal(rating,amount);
        }else if(command=="MATCH"){
            int a;
            cin>>a;
            bst.match(a);
        }else if(command=="NEAT"){
            int a;
            cin>>a;
            bst.neat(a);
        }else if(command=="PREV"){
            int a;
            cin>>a;
            bst.prev(a);
        }else if(command=="RANGE"){
            int L,R;
            cin>>L>>R;
            bst.range(L,R);
        }else if(command=="RANK"){
            int a;
            cin>>a;
            bst.rank(a);
        }else if(command=="KTH"){
            int k;
            cin>>k;
            bst.kth(k);
        }else if(command=="DUEL"){
            int A,B;
            cin>>A>>B;
            bst.duel(A,B);
        }else if(command=="STATS"){
            bst.stats();
        }}
    return 0;
}