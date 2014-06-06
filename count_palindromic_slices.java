/* COUNT PALINDROMIC SLICES
 In this problem we consider only strings consisting of lower-case English letters (a−z).
 A string is a palindrome if it reads exactly the same from left to right as it does from right to left.
 For example, these strings are palindromes: aza, abba, abacaba
 These strings are not palindromes: zaza, abcd, abacada
 Given a string S of length N, a slice of S is a substring of S specified by a pair of integers (p, q),
 such that 0 ≤ p < q < N. A slice (p, q) of string S is palindromic if the string consisting of letters
 S[p], S[p+1], ..., S[q] is a palindrome. For example, in a string S = abbacada:
 slice (0, 3) is palindromic because abba is a palindrome,
 slice (6, 7) is not palindromic because da is not a palindrome,
 slice (2, 5) is not palindromic because baca is not a palindrome,
 slice (1, 2) is palindromic because bb is a palindrome.
 Write a function
 int solution(char *S);
 that, given a string S of length N letters, returns the number of palindromic slices of S. The function
 should return −1 if this number is greater than 100,000,000.
 For example, for string S = baababa the function should return 6, because exactly six of its slices are
 palindromic; namely: (0, 3), (1, 2), (2, 4), (2, 6), (3, 5), (4, 6).
 Assume that:
 N is an integer within the range [0..20,000];
 string S consists only of lower-case letters (a−z).
 Complexity:
 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

// IDEA : we need to check 2 things first.
// 1. if we found the palindromic slices at (i-1)-th index, check the beginning of that palindrome first.
// 2. check (i-1)-th index and (i-2)-th index to make sure if there is any palindomic slice exists
int palindromSlices(String str){

    int front=-1;
    int back=-1; // storing the back of the previous found palindromic slices
    int len = str.length();
    int count=0;
    for(int i=0; i<len; i++){
        char cur=str.charAt(i);

        if((i-1)>=0 && back==(i-1) && front-1 >=0 && str.charAt(front-1)==cur){ front=front-1; back=i; count++; } //previously p-slice was found
        if((i-1)>=0 && str.charAt(i-1)==cur){ front=i-1; back=i-1; count++; }
        if((i-2)>=0 && str.charAt(i-2)==cur){ front=i-2; back=i-1;}
    }
    return count;

}