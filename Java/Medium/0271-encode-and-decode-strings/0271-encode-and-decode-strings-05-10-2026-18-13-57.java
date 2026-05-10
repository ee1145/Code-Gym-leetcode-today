public class Codec {

    // 编码
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // 解码
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // 找到 # 的位置
            int j = i;
            while (s.charAt(j) != '#') j++;

            // 读出长度
            int len = Integer.parseInt(s.substring(i, j));

            // 截取字符串
            result.add(s.substring(j + 1, j + 1 + len));

            // 移动指针
            i = j + 1 + len;
        }
        return result;
    }
}
