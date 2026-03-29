class Solution {
    public boolean validWordAbbreviation(String a, String b) {
        int startA = 0;
        int startB = 0;
        a+=" ";
        b+=" ";
        int m = a.length();
        int n = b.length();
        String integer = "";
        boolean isInteger = false;
        boolean isValid = true;

        while(startB < n && startA < m){
            if(!isValid) break;
            char current = b.charAt(startB++);
            if((current >= 'a' && current <= 'z') || current == ' '){
                // check if previous value is integer
                if(isInteger){
                    if(integer.charAt(0)=='0') isValid=false;
                    startA+=Integer.parseInt(integer);
                    if(startA>m) isValid=false;
                }
                // check if current charcaters are same for not
                if(startA >= m || current!=a.charAt(startA++)) isValid = false;
                isInteger = false;
                integer = "";
            }else{
                // just keep storing the integer
               isInteger = true;
               integer+=current;
            }
        }
        return isValid;
    }
}