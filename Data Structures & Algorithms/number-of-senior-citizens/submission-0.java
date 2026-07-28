class Person{
    String phoneNumber;
    String gender;
    int seatNumber;
    int age;

    Person(String data){
         parsePerson(data);
    }


    public void parsePerson(String data){
        phoneNumber = data.substring(0,10);
        gender = data.substring(10,11);
        age = Integer.parseInt(data.substring(11,13));
        seatNumber = Integer.parseInt(data.substring(13));
        System.out.println(age);
    }
}
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details){
            Person person = new Person(detail);
            if(person.age > 60){
                count++;
            }
        }
        return count;
    }
}