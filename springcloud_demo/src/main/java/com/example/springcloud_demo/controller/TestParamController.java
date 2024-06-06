package com.example.springcloud_demo.controller;

import com.example.springcloud_demo.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description Spring MVC中Controller接收请求参数的常见方式
 * @Author zhangtao
 * @Date 2024/6/4 10:02
 */
@Controller
@RequestMapping("/param")
@Slf4j
public class TestParamController {

    // 普通请求方式
    // 通过访问：GET http://localhost:8080/param/add?name=张三&pwd=123456
    /**
     * 请求参数名和Controller方法的参数一致
     * produces 设置返回参数的编码格式可以设置返回数据的类型以及编码，可以是json或者xml
     * {
     *     @RequestMapping(value="/xxx",produces = {"application/json;charset=UTF-8"})
     *      或
     *     @RequestMapping(value="/xxx",produces = {"application/xml;charset=UTF-8"})
     *      或
     *     @RequestMapping(value="/xxx",produces = "{text/html;charset=utf-8}")
     * }
     * @param name 用户名
     * @param pwd 密码
     * @return
     *
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addUser(String name,String pwd){
//        log.debug("name:"+name+",pwd:"+pwd);
        log.info("name:"+name+",pwd:"+pwd);
        return "name:" + name + ",pwd:" + pwd;
    }

    // 对象请求方式
    // 通过访问：GET http://127.0.0.1:8080/param/employee?lastName=战三&email=33453432@qq.com
    @GetMapping("/employee")
    public String addEmployee(Employee employee){
        return "lastName:"+employee.getLastName()+",email:"+employee.getEmail();
    }


    // 通过HttpServletRequst接收请求参数
    // GET  http://localhost:8080/param/add?name=张三&pwd=123456
    @RequestMapping(value = "/add2")
    public String add(HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        return "name:" + name + ",pwd:" + pwd;
    }

    // 通过@RequestParam注解接收请求参数
    // RequestParam注解作用：把请求中的指定名称的参数传递给控制器中的形参赋值
    // 注解属性：value：请求参数中的名称 required：请求参数中是否必须提供此参数，默认值是true，必须提供 defaultValue：设置默认值，仅当传入参数为空时有效
    // GET http://localhost:8080/param/add?name=张三&pwd=123456
    @RequestMapping(value = "/add3")
    public String add(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "pwd", required = false) String pwd) {
        return "name:" + name + ",pwd:" + pwd;
    }

    // 通过PathVariable注解接收请求参数
    // PathVariable注解作用：拥有绑定url中的占位符的。例如：url中有/delete/{id}，{id}就是占位符 注解属性 value：指定url中的占位符名称 优点：Restful风格的URL 请求路径一样，
    // 可以根据不同的请求方式去执行后台的不同方法
    // GET http://localhost:8080/param/hello/1
    @RequestMapping(path = "/hello/{id}")
    public String sayHello(@PathVariable(value = "id") String id) {
        return "id=" + id;
    }

    // JSON格式接收请求入参

    // JSON格式接收普通对象
    @PostMapping("/test")
    public String addEmployee1(@RequestBody Employee employee){
        return "lastName:"+employee.getLastName()+",email:"+employee.getEmail();
    }

}
