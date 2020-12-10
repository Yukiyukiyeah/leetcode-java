/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
      int left = 1;
      int right = n;
      int num = 0;
      while (left <= right) {
          num = left + (right - left) / 2;
          if (guess(num) == 1) {
              left = num + 1;
          } else if (guess(num) == -1) {
              right = num - 1;
          }
          else {
              break;
          }
      }
      return num;
  }
}