public class RepeatCheck {

    public static String ReplaceRepeatitive(String s){
        String[] list = s.split("\\s+");
        String out = "";
        for(int i=0;i<list.length;i++){
            int j=i+1;
            while(j<list.length){
                if(!list[i].toLowerCase().equals(list[j].toLowerCase())) {
                    break;
                }
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
        String[] input = {"I want 2 2 go to THE tHe thE zoo ZOo Zoo zOO ","I want 2        2 2 go to        tHE     tHe the zoo Zoo   "};
        String output = "I want REPEAT go to REPEAT REPEAT";
        String re;
        for(String i:input){
            re = ReplaceRepeatitive(i);
            System.out.println("test with  : "+i+"\nexpected   : "+output+"\nreal output: "+re+"\n---------------");
            if(!re.equals(output)) return false;
        }
        return true;
    }
}