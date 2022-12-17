class Solution {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                sb.append('M');
                continue;
            }
            if (num >= 900) {
                num -= 900;
                sb.append("CM");
                continue;
            }
            if (num >= 500) {
                num -= 500;
                sb.append('D');
                continue;
            }

            if (num >= 400) {
                num -= 400;
                sb.append("CD");
                continue;
            }

            if (num >= 100) {
                num -= 100;
                sb.append('C');
                continue;
            }

            if (num >= 90) {
                num -= 90;
                sb.append("XC");
                continue;
            }

            if (num >= 50) {
                num -= 50;
                sb.append('L');
                continue;
            }

            if (num >= 40) {
                num -= 40;
                sb.append("XL");
                continue;
            }

            if (num >= 10) {
                num -= 10;
                sb.append('X');
                continue;
            }

            if (num >= 9) {
                num -= 9;
                sb.append("IX");
                continue;
            }

            if (num >= 5) {
                num -= 5;
                sb.append('V');
                continue;
            }

            if (num == 4) {
                num -= 4;
                sb.append("IV");
                continue;
            }

            num -= 1;
            sb.append('I');
        }

        return sb.toString();
    }
}