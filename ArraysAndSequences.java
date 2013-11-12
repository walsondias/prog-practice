public class ArraysAndSequences{
  /*Given an array of numbers including negative, print the highest sum of the continuous sequence*/
  public void highestSumSequence(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
        } else {
            int start = 0, end = 0, startactual = 0, endactual = 0;
            int currSum = arr[0], maxSum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > 0) {
                    if (currSum <= 0) {
                        currSum = arr[i];
                        start = i;
                        end = i;
                    } else {
                        currSum += arr[i];
                        end = i;
                    }
                } else {
                    if (currSum <= arr[i]) {
                        currSum = arr[i];
                        start = i;                        
                    } else {
                        currSum += arr[i];
                    }
                }
                if(currSum > maxSum){
                    maxSum = currSum;
                    endactual = end;
                    startactual = start;
                }
            }
            for (int i = startactual; i <= endactual; i++) {
                System.out.print(arr[i] + "\t");
            }
        }
    }
  
  /*Compute factorial*/
  long factorial(long num){
    if(num == 1)
      return 1;
    else
      return num * factorial(num - 1);
  }
  long factorialByIteration(long num){
    for(long i = num-1; i>=1; i--){
      num = num * i;
    }
    return num;
  }
  
  /*Given an integer array, find any integer that occurs more than once.*/
  int findAnyRepeatedInteger(int [] arr){
    //Solution using a hashset data structure: O(n) complexity
    HashSet <Integer> set = new HashSet <Integer>();
    for(int i: arr){
      if(set.contains(i))
        return i;
      else
        set.add(i);
    }
    return -1;//Return -1 if no duplicates found
  }
  int findAnyRepeatedInteger2(int [] arr){
    //Solution without using any extra data structure: O(n.log n) due to sorting
    Arrays.sort(arr);
    for(int i=0; i<arr.length-1; ++){
      if(arr[i)==arr[i+1])
        return arr[i];
    }
    return -1;
  }
  
  /*Find the first repeated character in a string*/
  public char firstRepeatedCharInString(String str){
    HashSet <String> set = new HashSet <String>();
    for(int i=0; i<str.length(); i++){
      if(set.contains(str.charAt(i))
        return str.charAt(i);
      else
        set.add(str.charAt(i));
    }
  }
  
  /*Find the nth fibonacci number*/
  public long fibonacci(int n){
    //Recursive implementation: Time-O(n2) Space-O(1)
    if(n == 1)
      return 0;
    else if(n == 2)
      return 1;
    else
      return fibonacci(n-1)+fibonacci(n-2);
  }
  public long fibonacci(int n){
    //Iterative implementation: Time-O(n) Space: O(n)
    long []fibs = new long [n];
    fibs[0] = 0;
    fibs[1] = 1;
    for(int i=2; i<n; i++){
      fibs[i]=fibs[i-1]+fibs[i-2];
    }
    return fibs[n-1];
  }
  public long fibonacci3(int n){
    //Iterative implementation: TIme-O(n) Space-O(1)
    if(n == 1)
      return 0;
    else if(n == 2)
      return 1;
    else{
      int a = 0, b = 1, fib;
      for(int i=3; i<=n; i++){
        fib = a+b;
        a = b;
        b = fib;
      }
    }
  }
  
  /*Given an integer array. Find 3 numbers with the largest product*/
  long largestProduct(int [] arr){
    int len = arr.length;
    for(int i=0; i<len; i++){
      arr[i] = Math.abs(i);
    }
    Arrays.sort(arr);
    return arr[len-1]*arr[len-2]*arr[len-3];
  }
  
  /*Write a function that takes two strings and returns whether they are permutations*/
  public boolean arePermutations(String s1, String s2){
    HashSet <String> set = new HashSet <String>();
    for(int i=0; i<s1.length(); i++){
        set.add(s1.charAt(i));
    }
    for(int i=0; i<s2.length(); i++){
      if(!set.contains(s2.charAt(i))
        return false;
    }
    return true;
  }
  
  /*Given aa array with numbers from 1-250 in random order, but missing 1 number. Find the missed number.*/
  public int missingNumber(int [] arr){
    boolean [] isPresent = new boolean [251];
    for(int i: arr)
      isPresent[i] = true;
    for(int i=0; i<251; i++){
      if(!isPresent[i])
        return i;
    }
  }
  
  /*TODO: Given 2 int arrays containing single digit ints. Each array represents a huge number. 
   *Multiply the 2 huge numbers and return result as an int array*/
   public int [] multiplyHugeNum(int []arr1, int[]arr2){
    int []res = new int[arr1.length + arr2.length];
    int carry = 0;
    for(int i=1; i<=arr1.length; i++){
      for(int j=1; j<=arr2.length; j++){
        int tmp = res[res.length - j - i + 1];
        res[res.length - j - i + 1] = (tmp + (carry + arr1[arr1.length - i]*arr2[arr2.length - j]))%10;
        carry = (tmp + (carry + arr1[arr1.length - i]*arr2[arr2.length - j]))/10;
      }
      if(carry > 0)
        res[res.length - arr2.length - i] = res[res.length - arr2.length - i - 1] + carry;
      carry = 0;
    }
    return res;
   }
   
   /*Given an integer array. If the element is +k you can move fwd k steps or 
   if the value -k you can move backward k steps. You need to check whether you can navigate 
   from 0 index to last index in the array.*/
   public boolean isLastReachable(int [] arr){
    int i = 0, sum = 0;
    while(i >=0 && i<= arr.length-1){
        sum += arr[i];
        if(sum == arr.length -1)
            return true;
        else if(sum == 0){
            return false;
        }
        i += arr[i];
     }
     return false;
   }
   
   /*Write a program to find whether a word is anagram or not*/
   public boolean isAnagram(String s1, String s2){
        if(s1==null || s2==null || s1.length()!=s2.length)
            return false;
        char [] s1Arr = s1.toCharArray();
        char [] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        for(int i=0; i<s1Arr.length(); i++){
            if(s1Arr[i] != s2Arr[i])
                return false;
        }
        return true;
   }
   /*Design an algorithm to take a list of strings as well as a single input string, 
    *and return the indices of the list which are anagrams of the input string, 
    *disregarding special characters.*/
    public ArrayList <Integer> getAnagramIndices(String s, String [] arr){
        s = s.replaceAll("\\W", "");
        ArrayList <Integer> indices = new ArrayList <Integer> ();
        for(int i=0; i<arr.length(); i++){
            if(isAnagram(s, arr[i].replaceAll("\\W", ""))
                indices.add(i);
        }
        return indices;
    }
    
    /*Given an integer N and an array of unsorted integers A 
     *find all pairs of numbers within A which add up to N*/
     public void checkIfAddingToN(int n, int [] arr){
         Arrays.sort(arr);
         int i=0, j=0;
         while(i<j){
            if(arr[i]+arr[j] == n){
                System.out.println(i + " & " + j);
                i++;
                j--;
            }
            else if(arr[i]+arr[j] < n){
                i++;
            }
            else{
                j--;
            }
         }
     }
     
     /*Code an algorithm to find the longest palindrome in a string*/
     public void longestPalindrome(String s){
         char [] arr = s.toCharArray();
         int start=0, end=0;
         for(int i=0; i<arr.length-2; i++){
             for(int j=i+end-start; j<arr.length-1; j++){
                 if(isPalindrome(arr, i, j)){
                     start = i;
                     end = j;
                 }
             }
         }
         for(int i=start; i<=end; i++){
             System.out.print(arr[i]);
         }
     }
     public boolean isPalindrome(char []arr, int start, int end){
         while(start < end){
             if(arr[start] == arr[end]){
                 start++;
                 end--;
             }
             else
                return false;
         }
         return true;
     }
     
     /*Compress a string? If "AAABBAAA" the resultant string should be 3A2B3A.*/
     public String compress(String s){
         int count = 1;
         char past=s.get(0), curr;
         StringBuilder out = new StringBuilder("");
         for(int i=1; i<s.length(); i++){
             curr = s.charAt(i);
             if (past == curr){
                 count++;
             }
             else{
                 out.append(count+""+past);
                 past = curr;
                 count = 1;
             }
         }
         out.append(count+""+curr);
         return out.toString();
     }
     
     /*Compute sum of the elements in an integer array recursively*/
     public int sumOfArray(int [] arr){
         if(arr.length == 0)
            return 0;
        else
            return arr[1]+sum(arr, 2);
     }
     public int sum(int []arr, int index){
         if(index < arr.length){
             return arr[index] + sum(arr, index + 1);
         }
         else{
             return 0;
         }
     }
     
     /*Find the top two largest integers from an unsorted array*/
     public int [] topTwo(int [] arr){
         int [] top = new int [2];
         if(arr==null || arr.size() <=2)
            return arr;
        else
            top[0] = Math.max(arr[0], arr[1]);
            top[1] = Math.min(arr[0], arr[1]);
            for(int i=2; i<arr.size; i++){
                if(arr[i] > top[0]){
                    top[1] = top[0];
                    top[0] = arr[i];
                }
                else if(arr[i] > top[1]){
                    top[1] = arr[i];
                }
            }
            return top;
     }
}



