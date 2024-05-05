#include <iostream>
using namespace std;

int main (){
	int n;
	cin>>n;
	while (n--){
		string a;
		cin>>a;
		if (a.length()>10){
			cout<<a[0]<<a.length()-2<<a[a.length()-1];
		} else {
			cout<<a;
		}
		cout<<endl;
	}
	return 0;
}
