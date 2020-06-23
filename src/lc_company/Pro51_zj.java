package lc_company;

public class Pro51_zj {
    public static void main(String[] args) {
        Pro51_zj p = new Pro51_zj();
        int[] data = {237};
        System.out.println(p.validUtf8(data));
    }
    public boolean validUtf8(int[] data) {
        //别人经典的实现。。。
        int n = 0;
        for(int i=0;i<data.length;i++){
            if(n>0){
                if(data[i]>>6!=2)return false;//就是前两位是否是10
                n--;
            }else if(data[i]>>7==0){//第一位是否为0
                n=0;
            }else if(data[i]>>5==0b110){
                n=1;
            }else if(data[i]>>4==0b1110){
                n=2;
            }else if(data[i]>>3==0b11110){
                n=3;
            }else{
                return false;
            }
        }
        return n==0;
        //我的丑陋的实现，差别也太大了
//        if(data == null || data.length == 0)
//            return false;
//        int needonenum = 0;
//        for(int d:data) {
//            String temp = Integer.toString(d, 2);
//            int len = temp.length(), onenum = 0;
//            if(len >= 8)
//            {
//                String Top5 = temp.substring(len-8,len-3);
//                if(Top5.substring(0,1).equals("0"))
//                {
//                    onenum = 0;
//                }
//                else if(Top5.substring(0,2).equals("10"))
//                {
//                    onenum = 1;
//                }else if(Top5.substring(0,3).equals("110"))
//                {
//                    onenum = 2;
//                }else if(Top5.substring(0,4).equals("1110"))
//                {
//                    onenum = 3;
//                }else if(Top5.substring(0,5).equals("11110"))
//                {
//                    onenum = 4;
//                }else
//                {
//                    return false;
//                }
//            }
//            if(needonenum >= 1 && onenum!= 1 || needonenum == 0 && onenum == 1)
//                return false;
//
//            if(onenum > 1)
//                needonenum = onenum - 1;
//            else if(onenum == 1)
//                needonenum--;
//        }
//        if(needonenum > 0)
//            return false;
//        return true;
    }
}
