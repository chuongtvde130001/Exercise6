public class RepeatCheck {

    public static String replaceRepeatitive(String s){
        String[] list = s.split("\\s+");
        String out = "";
        for(int i=0;i<list.length;i++){
            int j=i+1;
            if(list[i].length() == 1 && !Character.isLetterOrDigit(list[i].charAt(0))){
                out+=list[i]+" ";
                continue;
            }
            while(j<list.length){
                if(!list[i].toLowerCase().equals(list[j].toLowerCase())) break;
                j++;
            }
            if(j==i+1) out+=list[i]+" ";
            else{
                out+="REPEAT ";
                i=j-1;
            }
        }
        return out.trim();
    }

    public static void main(String[] args) {
        System.out.println("Test result: "+test());
    }

    public static boolean test(){
        String[] in = {"I want 2  2 2 go to tHE  tHe the zoo Zoo   ","toi , toi la Tran Tran , Tran Nam . . ."};
        String[] out = { "I want REPEAT go to REPEAT REPEAT","toi , toi la REPEAT , Tran Nam . . ."};
        String re;
        for(int i=0;i<in.length;i++){
            re = replaceRepeatitive(in[i]);
            System.out.println("test with  : "+in[i]+"\nexpected   : "+out[i]+"\nreal output: "+re+"\n---------------");
            if(!re.equals(out[i])) return false;
        }
        return true;
    }
}