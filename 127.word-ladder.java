class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord) || wordList.size() == 0) return 0;
      Set<String> wordset = new HashSet<>();
      for (String s: wordList) {
          wordset.add(s);
      }
      Set<String> visited = new HashSet<>();
      Queue<String> q = new LinkedList<>();
      q.offer(beginWord);
      visited.add(beginWord);
      int length = 1;
      while (!q.isEmpty()) {
          int sz = q.size();
          for (int i = 0; i < sz; i ++) {
              String cur = q.poll();
              if (changeOne(cur, endWord, q, visited, wordset)) {
                  return length + 1;
              }
          }
          length ++;
      }
      return 0;
  }
  private boolean changeOne(String cur, String endWord, Queue<String> q, Set<String> visited, Set<String> wordset) {
      char[] charArray = cur.toCharArray();
      for (int i = 0; i < endWord.length(); i++) {
          char originChar = charArray[i];
          for (char j = 'a'; j  <= 'z'; j++) {
              if (j == originChar) continue;
              charArray[i] = j;
              String nextWord = new String(charArray);
              if (wordset.contains(nextWord)) {
                  if (nextWord.equals(endWord)) {
                      return true;
                  }
                  if (!visited.contains(nextWord)) {
                      q.offer(nextWord);
                      visited.add(nextWord);
                  }
              }
          }
          charArray[i] = originChar;
      }
      return false;
  }
      
      
}