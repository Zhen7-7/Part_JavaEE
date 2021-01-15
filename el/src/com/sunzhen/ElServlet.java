package com.sunzhen;

import com.sunzhen.entity.Address;
import com.sunzhen.entity.User;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;




/**
 * El表达式:
 *      概念:
 *          Expression Language:一种表达式语言,语法简单
 *      作用:
 *          方便jsp中获取作用域的属性:
 *      语法规则:
 *          ${expression}  可以使用.或者[]来获取属性值或者指定位置的索引
 *          获取值的时候,直接使用作用域的中的key即可,使用.来引用属性,使用[]来获取指定索引的对象
 *      作用域:
 *          pageContext-->request-->session-->application
 *          由小到大
 *      获取作用域的顺序:
 *          从小的作用域开始查询,如果找到返回对应的值,不断向着大范围寻找数据;
 *          当四种作用域在相同key属性的时候,可以通过配置pageScope ,requestScope,sessionScope,applicationScope获取指定作用域的数据;
 *       el表达时可以进行算数运算和逻辑关系运算
 *          直接在表达式中世界写入算法操作即可,如果是关系运算,返回true或false
 *          注意:在el表达时中"+"表示加法操作而不是字符串连接符
 *
 *
 *
 *
 *
 * */

public class ElServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从请求中获取数据:
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        //给request对象单独设置属性:
        request.setAttribute("aa","aaaaaaa");

        //给request添加对象
        User user = new User(1, "莫玉丹", new Address("黑龙江", "齐齐哈尔", "克山县"));
        User user1 = new User(2,"孙朕",new Address("黑龙江","哈尔滨","香坊区"));

        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        request.setAttribute("user",user);

        //给request对象设置集合:
        request.setAttribute("list",list);


        //给request对象设置map对象:
        HashMap<String,String> map = new HashMap<>();
        map.put("China","beijing");
        map.put("Haerbin","xiangfang");

        request.setAttribute("map",map);

        HashMap<String,User> map2 = new HashMap<>();
        map2.put("a1",user);
        map2.put("a2",user1);
        request.setAttribute("map2",map2);



        //通过某一个请求转发的方式跳转到jsp页面
        request.getRequestDispatcher("el.jsp").forward(request,response);

    }
}
