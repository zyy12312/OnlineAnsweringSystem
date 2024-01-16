package main.java.cn.edu.usst.OnlineAnsweringSystem.model.service;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.StudentDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.TeacherDBUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    public static Map<String, String> getNameAndKind(int userId, String password){
        String userKind = null;
        String userName = null;
        Map<String, String> map=new HashMap<>();
        if (userId == 501) { //adm
            if(!password.equals("123123")) {
                map.put("error","User ID Or Password Error!");
                return map;
            }
            userKind = "admin";
            userName = "admin";
        }
        else if (userId < 200) { //stu
            Student student = StudentDBUtil.findById(userId);
            if(student.getId()==0 || !student.getPassword().equals(password)) {
                map.put("error","User ID Or Password Error!");
                return map;
            }
            userName = student.getName();
            userKind = "student";
        } else { //tea
            Teacher teacher = TeacherDBUtil.findById(userId);
            if(teacher.getId()==0 || !teacher.getPassword().equals(password)){
                map.put("error","User ID Or Password Error!");
                return map;
            }
            userName = teacher.getName();
            userKind = "teacher";
        }
        map.put("userName",userName);
        map.put("userKind",userKind);
        return map;
    }
}
