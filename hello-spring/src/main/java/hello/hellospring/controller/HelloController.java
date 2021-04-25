package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // 정적 컨텐츠 - 파일을 그대로 내려준다.
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // 템플릿 엔진 - 렌더링이 된 html을 내려줌. 페이지 소스코드 보기 하면 html 코드 나옴
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") // data를 그대로 내려줌. 그래서 페이지 소스코드 보기하면 html 코드가 없음
    @ResponseBody
    public String heeloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") // Json 스타일로 반환.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name); // 문자가 아닌 객체를 넘김
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
