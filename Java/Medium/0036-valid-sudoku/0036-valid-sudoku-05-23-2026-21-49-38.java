class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // 三组 HashSet
        HashSet<Character>[] rows  = new HashSet[N];
        HashSet<Character>[] cols  = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i]  = new HashSet<>();
            cols[i]  = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                if (val == '.') continue;  // 空格跳过

                // 计算宫格编号
                int boxIndex = (r / 3) * 3 + (c / 3);

                // 三个规则同时检查
                if (rows[r].contains(val) ||
                    cols[c].contains(val) ||
                    boxes[boxIndex].contains(val)) {
                    return false;          // 有重复 → 无效
                }

                // 没重复，加入记录
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}
