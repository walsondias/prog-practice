public class ArraysAndSequences{
  /*Given an array of numbers including negative, print the highest sum of the continuous sequence*/
  public void highestSumSequence(int []arr){
    if(arr.length == 0)
      return;
    if (arr.length == 1)
      System.out.println(arr[0]);
    else
      int start = 0, end = 0;
      int currSum = arr[0];
      for(int i=1; i<arr.length; i++){
        if(arr[i] > 0){
          if(currSum <= 0){
            currSum = arr[i];
            start = i;
            end = i;
          }
          else{
            currSum += arr[i];
            end = i;
          }
        }
        else{
          if(currSum <= arr[i]){
            currSum = arr[i];
            start = i;
            end = i;
          }
          else{
            currSum += arr[i];
            end = i;
          }
        }
      }
      for(int i=start; i<=end; i++){
        System.out.print(arr[i]+""\t);
      }
  }
}
