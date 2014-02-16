public class GooglePrep{
    //Group intervals so that if a new interval is asked you merge the ones it overlaps and create one big interval.
    static class Interval {
        Date start;
        Date end;
        //get..set
    }
    public ArrayList<Interval> groupIntervals (ArrayList<Interval> set, Interval newInterval){
        for(int i=0; i<set.size(); i++){
              if(set.get(i).getEnd().compare(newInterval.getStart()<=0){
                  newInterval = mergeIntervals(set.get(i), newInterval);
                  set.remove(i);
              } else if (set.get(i).getStart().compare(newInterval.getEnd()>=0){
                  newInterval = mergeIntervals(newInterval, set.get(i));
                  set.remove(i);
              }
        }
        set.add(newInterval);
    }
    public Interval mergeIntervals(Interval start, Interval end){
        return new Interval(start.getStart(), end.getEnd());
    }
    
    //Guessing game - I pick a number between 1 and 100 and you are trying to guess it. Every time you query a number I tell you if it is higher or lower.
    //Part 1- Write the code of it, if cost of querying a number is equal.
    //Part 2- How about if cost of querying number x is x? How would you change the algorithm?
    public int guessNum(int min, int max){
        int mid = (max-min)/2;
        //If number to be found is less
        while(true){
            if(queryNum(mid)<0){
                max = mid;
                mid = (max+min)/2;
            } else if (queryNum(mid) > 0){
                min = mid;
                mid = (max+min)/2;
            } else {
                return mid;
            }
        }
    }
    
    //Given a TV remote, write a script that would give directions to input some letters. 
    //Starting from the upper left-hand corner. If the buttons were in 3 columns, 
    //and you wanted to type "feed", you would want the output of the program to say 
    //"right, right, down, PRESS, left, PRESS, PRESS, left, PRESS"
    public class Remote{
        int row = 0, col = 0;
        
        public void getDirections(String str){
            char [] letters = str.toCharArray();
            for(int i=0; i<letters.length; i++){
                printCommands(letter[i]);
            }
        }
        
        public void printCommand(char c){
            int y = (c - 'a') / 3;
            int x = (c - 'a') % 3;
            printDirections(x,y);
        }
        
        public void printDirections(int x, int y){
            int dx = Math.abs(col - x);
            int dy = Math.abs(row - y);
            for(int i = dx; i >0; i--){
                if(col < x)
                    System.out.print("right");
                else
                    System.out.print("left");
            }
            for(int i = dy; i >0; i--){
                if(row < y)
                    System.out.print("down");
                else
                    System.out.print("up");
            }
            System.out.print("PRESS");
            row = y;
            col = x;
        }
    }
    
}
