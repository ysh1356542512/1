package rockhomework4LV1;

public class ysh implements master{
    public void getInformation(long result,int x){
        switch (x){
            case 1:
                System.out.println("阶乘的结果是"+result);
                break;
            case 2:
                System.out.println("求和的结果是"+result);
                break;
            case 3:
                System.out.println("该项为"+result);
            default:
                break;
        }
    }
}
