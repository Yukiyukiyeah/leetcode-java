class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();
      int wordNum = words.length;
      if (wordNum == 0) return res;
      int wordLen = words[0].length();
      HashMap<String, Integer> allWords = new HashMap<>();
      for (String w: words) {
          int value = allWords.getOrDefault(w, 0);
          allWords.put(w, value + 1);
      }
      for (int i = 0; i < s.length() - wordLen * wordNum + 1; i++) {
          HashMap<String, Integer> hasWord = new HashMap<>();
          int num = 0;
          while (num < wordNum) {
              String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
              if (allWords.containsKey(word)) {
                  int value = hasWord.getOrDefault(word, 0);
                  hasWord.put(word, value + 1);
                  if (hasWord.get(word) > allWords.get(word)) {
                      break;
                  }
              } else {
                  break;
              }
              num++;
          }
          if (num == wordNum) {
              res.add(i);
          }
      }
      return res;
  }
}