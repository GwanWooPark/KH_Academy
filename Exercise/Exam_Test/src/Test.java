public class Test {

    public static void main(String[] args) {

        Person[] pArr = {new Person("박관우",'M'),
                         new Person("손흥민",'M'),
                         new Person("김연아",'W')};

        for (int i = 0; i < pArr.length; i++) {
            System.out.println(pArr[i].getName());
        }
    }
}
