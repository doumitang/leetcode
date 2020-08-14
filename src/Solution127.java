import java.util.List;

public class Solution127 {

    private boolean[] visit = null;
    private String beginWord, endWord;
    private List<String> wordList;
    private int ans = Integer.MAX_VALUE;

    /**
     * Time Limit Exceeded
     *
     * Last executed input:
     * "qa"
     * "sq"
     * ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        visit = new boolean[wordList.size()];
        this.wordList = wordList;
        recursion(beginWord, 1);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void recursion(String cur, int count) {
        if (cur.equals(endWord)) ans = Math.min(ans, count);
        for (int i = 0; i < wordList.size(); i++) {
            if (visit[i]) continue;
            String word = wordList.get(i);
            if (isValidConvert(cur, word)) {
                visit[i] = true;
                recursion(word, count + 1);
                visit[i] = false;
            }
        }
    }

    private boolean isValidConvert(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
