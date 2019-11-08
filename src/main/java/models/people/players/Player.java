package models.people.players;


public class Player {
    Double balance = 0.00;
    String name;
    Integer age;
    Integer id;

    public Player() {
        this.id = generatePlayerID();
    }

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.id = generatePlayerID();
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double newBalance) {
        this.balance = newBalance;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Integer generatePlayerID() {
        Integer max = 9999999;
        Integer min = 1000000;
        Integer range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }


}
