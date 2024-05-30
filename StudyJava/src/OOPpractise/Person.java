package OOPpractise;

public class Person {
     String name;
     int age;
     String sex;

     private Person() {

     }

     public static Person getInstance(){
          Person person=new Person();
          person.name="小明";
          return person;
     }

     public void setName(){
          this.name=name;
     }

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }

     public String getSex() {
          return sex;
     }

     public void setSex(String sex) {
          this.sex = sex;
     }

     public String getName(){
          return name;
     }
}
