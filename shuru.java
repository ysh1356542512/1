package rockhomework4LV3;

//  每个数字或者符号或者括号之间要加空格！！！！！！！！！！！！！！！！！！！！！！
import java.util.Scanner;
import java.util.ArrayList;
public class shuru implements choiceCalculate{
    ArrayList<Double> number = new ArrayList<>();   //分成四个数组  左括号数组 右括号数组  数字数组 符号数组
    ArrayList<String> operate = new ArrayList<>();
    ArrayList<String> leftPara = new ArrayList<>();
    ArrayList<String> rightPara = new ArrayList<>();

    @Override
    public void dingyi() {               //用户输入要计算的式子
        System.out.println("输入要计算的算式(支持括号,就是每个数字符号括号之间加空格)：");
        Scanner sc = new Scanner(System.in);
        String y;
        y = sc.next();
        while (!y.equals("=")) {           //当输入=时结束运行
            if (y.equals("(")) {            //如果为左右括号  左右括号数组加一
                leftPara.add(y);
            } else if (y.equals(")")) {
                rightPara.add(y);
            } else if (y.equals("*") || y.equals("/") || y.equals("+") || y.equals("-") || y.equals("^")) {
                operate.add(y);                   //将右括号和符号数组联系在一起  因为右括号在符号的左边
                if (operate.size() != rightPara.size()) {  //如果直接输入符号 那么右括号数组对应的索引为""
                    rightPara.add("");
                }
            } else {
                try {
                    double d = Double.parseDouble(y);  //道理与右括号和符号一样 将数字和左括号联系在一起
                    number.add(d);
                    if (number.size() != leftPara.size()) {
                        leftPara.add("");
                    }
                } catch (NumberFormatException e) {     //因为类型转换需要在确定为double类型的情况下进行  所以抛出当y不为数字的情况的异常
                }
            }
            y = sc.next();
        }
    }

    public void calculate(int j){          //用来计算的方法  加减乘除平方
        double x = 1;
        switch(operate.get(j)){
            case "*":
                x = number.get(j)*number.get(j+1);
                break;
            case "/":
                x = number.get(j)/number.get(j+1);
                break;
            case "+":
                x = number.get(j)+number.get(j+1);
                break;
            case "-":
                x = number.get(j)-number.get(j+1);
                break;
            case "^":
                x = Math.pow(number.get(j),number.get(j+1));
                break;
            default:
                break;
        }
        operate.remove(j);
        number.remove(j);
        number.remove(j);
        number.add(j,x);
        leftPara.remove(j);
        rightPara.remove(j);
    }

    @Override
    public double choiceCalculate(int i){   //用来选择运算顺序的方法
        for(int a = i;a<leftPara.size();a++){    //优先计算括号中的运算  但遵循先次方  再乘除  最后加减
            int count = 0;                   //用count来判断整个计算式子中是否还有括号
            for(int b = i+1;b<rightPara.size();b++){      //因为右括号一定在左括号右边多一格 防止出现右括号在左括号的旁边的情况
                if(leftPara.get(a).equals("(")&&rightPara.get(b).equals(")")){
                    for(int j = a;j<b;j++){
                        if(operate.get(j).equals("^")){
                            calculate(j);
                            count ++;
                        }
                    }
                    for(int k = a;k<b;k++){
                        if(operate.get(k).equals("*")||operate.get(k).equals("/")){
                            calculate(k);
                            count ++;
                        }
                    }
                    for(int l = a;l<b;l++){
                        if(operate.get(l).equals("+")||operate.get(l).equals("-")){
                            calculate(l);
                            count ++;
                        }
                    }
                    if(count !=0) {
                        choiceCalculate(0);
                        break;
                    }
                }
            }
        }
            for (int j = 0; j < operate.size(); j++) {     //再计算完括号里的运算后在进行括号外的运算
                if (operate.get(j).equals("^")) {
                    calculate(j);
                }
            }
            for (int k = 0; k < operate.size(); k++) {
                if (operate.get(k).equals("*") || operate.get(k).equals("/")) {
                    calculate(k);
                }
            }
            for (int l = 0; l < operate.size(); l++) {
                if (operate.get(l).equals("+") || operate.get(l).equals("-")) {
                    calculate(l);
                }
            }
        return number.get(0);
    }
}
