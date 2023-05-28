package main.java.hello.hellospring.controller;

public class MemberForm { // html에서 이름을 받아 저장하기 위해 만든 객체
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
