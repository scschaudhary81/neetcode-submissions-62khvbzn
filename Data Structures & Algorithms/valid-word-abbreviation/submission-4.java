class Solution {
    public boolean validWordAbbreviation(String a, String b) {
        

        int startA = 0;
        int startB = 0;
        int m = a.length();
        int n = b.length();
        String current = "";
        boolean isInteger = false;
        boolean result = true;

        while(startB < n && startA < m){
            char c = b.charAt(startB);
            if(c >= 'a' && c <= 'z'){
                // check for previous value
                if(isInteger){
                    if(current.charAt(0)=='0'){
                        result=false;
                        break;
                    }
                    int shift = Integer.parseInt(current);
                    System.out.println(shift + " "+ startA);
                    startA+=shift;
                    if(startA>=m){
                        result=false;
                        System.out.println("A");
                        break;
                    }
                }
                isInteger = false;
                current = "";
                // process current value
                if(c!=a.charAt(startA)){
                    System.out.println("B");
                    result = false;
                    break;
                }
                startA++;
            }else{
               isInteger = true;
               current+=c;
            }
            startB++;
        }

        // check for previous value
                if(isInteger){
                     if(current.charAt(0)=='0'){
                        result=false;
                    }
                    int shift = Integer.valueOf(current);
                    startA+=shift;
                    if(startA>m){
                        System.out.println(shift + " "+ startA);
                        result=false;
                    }
                }


        return result;
    }
}