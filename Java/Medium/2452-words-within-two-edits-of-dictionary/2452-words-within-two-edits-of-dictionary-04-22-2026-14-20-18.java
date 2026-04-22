class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // 1. 准备一个 List 用来装结果
        List<String> result = new ArrayList<>();
        
        // 2. 第一层循环：遍历每一个查询单词
        for (String q : queries) {
            
            // 3. 第二层循环：遍历字典里的每一个单词
            for (String d : dictionary) {
                int diff = 0; // 记录不同字符的数量
                
                // 4. 第三层循环：逐个对比字符
                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        diff++;
                    }
                }
                
                // 5. 核心判断与剪枝
                if (diff <= 2) {
                    result.add(q);
                    break; // 关键点：只要匹配上一个字典词，就立刻跳出内层循环，检查下一个 q
                }
            }
        }
        
        return result;
    }
}
