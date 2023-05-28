package main.java.hello.hellospring.domain;

public class Member {

    //회원 id, 이름
    private Long id;
    private String name;

    //getter and setter 추가
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
