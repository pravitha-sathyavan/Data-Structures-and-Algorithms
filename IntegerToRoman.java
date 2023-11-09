class Solution {
    public String intToRoman(int num) {
        String roman = "";
        if(num >= 1000){
            int thousandSymbol = num/1000;
            num = num%1000;
            for(int i=1;i<=thousandSymbol;i++){
                roman += "M";
            }
        }
        if(num >= 100){
            int hundredSymbol = num/100;
            num = num%100;
            switch(hundredSymbol){
                case 1: roman += "C";
                        break;
                case 2: roman += "CC";
                        break;
                case 3: roman += "CCC";
                        break;
                case 4: roman += "CD";
                        break;
                case 5: roman += "D";
                        break;
                case 6: roman += "DC";
                        break;
                case 7: roman += "DCC";
                        break;
                case 8: roman += "DCCC";
                        break;
                case 9: roman += "CM";
                        break;
            }
        }
        if(num >= 10){
            int tens = num/10;
            num = num%10;
            switch(tens){
                case 1: roman += "X";
                        break;
                case 2: roman += "XX";
                        break;
                case 3: roman += "XXX";
                        break;
                case 4: roman += "XL";
                        break;
                case 5: roman += "L";
                        break;
                case 6: roman += "LX";
                        break;
                case 7: roman += "LXX";
                        break;
                case 8: roman += "LXXX";
                        break;
                case 9: roman += "XC";
                        break;
            }
        }
        if(num>0){
            switch(num){
                case 1: roman += "I";
                        break;
                case 2: roman += "II";
                        break;
                case 3: roman += "III";
                        break;
                case 4: roman += "IV";
                        break;
                case 5: roman += "V";
                        break;
                case 6: roman += "VI";
                        break;
                case 7: roman += "VII";
                        break;
                case 8: roman += "VIII";
                        break;
                case 9: roman += "IX";
                        break;
            }
        }
        return roman;
    }
}
