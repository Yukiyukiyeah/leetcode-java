class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
      Set<String> wordSet = new HashSet<>();
      for (String s: wordList) {
          wordSet.add(s);
      }
      Set<String> visited = new HashSet<>();
      Set<String> beginVisited = new HashSet<>();
      Set<String> endVisited = new HashSet<>();
      beginVisited.add(beginWord);
      endVisited.add(endWord);
      int length = 1;
      while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
          if (beginVisited.size() > endVisited.size()) {
              Set tmp = beginVisited;
              beginVisited = endVisited;
              endVisited = tmp;
          }
          Set<String> nextLevelVisited = new HashSet<>();
          for (String word: beginVisited) {
              if (changeOne(word, endVisited, visited, wordSet, nextLevelVisited)) {
                  return length + 1;
              }
          }
          beginVisited = nextLevelVisited;
          length ++;
      }
      return 0;
  }
  private boolean changeOne(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
      char[] charArray = word.toCharArray();
      for (int i = 0; i < word.length(); i++) {
          char originChar = charArray[i];
          for (char c = 'a'; c <= 'z'; c++) {
              if (c == originChar) {
                  continue;
              }
              charArray[i] = c;
              String nextWord = new String(charArray);
              if (wordSet.contains(nextWord)) {
                  if (endVisited.contains(nextWord)) {
                  return true;
                  }
                  if (!visited.contains(nextWord)) {
                      visited.add(nextWord);
                      nextLevelVisited.add(nextWord);
                  }
              }
          }
          charArray[i] = originChar;
      }
      return false;
  }
}