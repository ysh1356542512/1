package rockhomework4LV2;

public class Student {
    private String card;//学号
    private String name;
    private String year;
    private float math,English,Chinese,science;
    private float average;
    private float sum;
    public Student(){
        this("999999","张三","18");
    }
    public Student(String card,String name,String age){
        this.card = card;this.year = age;this.name = name;
    }
    public String getCard() { return card; }
    public void setCard(String card) { this.card = card; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void setMath(float math) { this.math = math; }
    public void setEnglish(float english) { English = english; }
    public void setChinese(float chinese) { Chinese = chinese; }
    public void setScience(float science) { this.science = science; }
    public void setAverage(float average) { this.average = average; }
    public void setSum(float sum) { this.sum = sum; }
    public float getMath() { return math; }
    public float getEnglish() { return English; }
    public float getChinese() { return Chinese; }
    public float getScience() { return science; }
    public float getAverage() { return average; }
    public float getSum() { return sum; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    @Override
    public String toString() {
        return "学生:"+name+" 学号:"+card+"[数学:"+math+" 语文:"+Chinese+" 英语:"+English+" 化学:"+science+" 总分:"+sum+" 平均分:"+average+"]";
    }
}

