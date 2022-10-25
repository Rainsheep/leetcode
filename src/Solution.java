class Solution {

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (int j = 0; j < str.length(); j++) {
                if (j == 0 || str.charAt(j) == str.charAt(j - 1)) {
                    num++;
                    continue;
                }
                sb.append(num);
                sb.append(str.charAt(j - 1));
                num = 1;
            }

            sb.append(num);
            sb.append(str.charAt(str.length() - 1));

            str = sb.toString();
        }

        return str;
    }
}