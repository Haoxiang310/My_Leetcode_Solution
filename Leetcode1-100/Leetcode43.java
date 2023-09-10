class Solution {
    public String multiply(String num1, String num2) {
        //num1.length() > num2.length()
        if(num1.length() == 1 && Integer.valueOf(num1) == 0 || num2.length() == 1 && Integer.valueOf(num2) == 0) return "0";
        int p2 = num2.length() - 1;
        int l = num2.length() - 1;
        String res = "";
        while(p2 >= 0){
            int digit = num2.charAt(p2) - '0';
            int shift = l - p2;
            StringBuilder multiOneDigit = new StringBuilder(multiplyOneDigit(num1,digit));
            while(shift > 0){
                multiOneDigit.append("0");
                shift--;
            }
            res = addTwo(res, multiOneDigit.toString());
            p2--;
        }
        return res;
    }

    public String multiplyOneDigit(String num1, int digit){
        int carry = 0;
        int p = num1.length() - 1;
        StringBuilder res = new StringBuilder();
        while(p >= 0){
            int d = ((num1.charAt(p) - '0') * digit + carry) % 10;
            carry = ((num1.charAt(p) - '0') * digit + carry) / 10;
            res.append(String.valueOf(d));
            p--;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public String addTwo(String num1, String num2){
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(p1 >= 0 && p2 >= 0){
            int digit = (num1.charAt(p1) - '0' + num2.charAt(p2) - '0' + carry) % 10;
            carry = (num1.charAt(p1) - '0' + num2.charAt(p2) - '0' + carry) /10;
            res.append(String.valueOf(digit));
            p1--;
            p2--;
        }
        if(p1 < 0){
            while(p2 >= 0){
                int digit = ((num2.charAt(p2) - '0') + carry) % 10;
                carry = (num2.charAt(p2) - '0' + carry) /10;
                res.append(digit);
                p2--;
            }
        }
        if(p2 < 0){
            while(p1 >= 0){
                int digit = ((num1.charAt(p1) - '0') + carry) % 10;
                carry = (num1.charAt(p1) - '0' + carry) /10;
                res.append(digit);
                p1--;
            }
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
