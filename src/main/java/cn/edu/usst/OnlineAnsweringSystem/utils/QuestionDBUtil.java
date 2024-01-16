package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.CourseImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.QuestionImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.TCImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.CourseDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.QuestionDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.TCDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;

import java.util.ArrayList;

public class QuestionDBUtil {
    static private QuestionDao questionDao=new QuestionImpl();

    public static boolean update(Question question){
        try {
        return questionDao.update(question);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //添加问题方法
    public static boolean addQuestion (Question question){
        try {
        return questionDao.addQuestion(question);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 按id删除问题方法
    public static boolean delQuestion (int id){
        try {
        return questionDao.delQuestion(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 教师界面：按course_id查询问题方法
    public static ArrayList<Question> findByCid_All (int cid){
        try {
            String sql = "SELECT * FROM Question WHERE cid =? ORDER BY DATE DESC";
            return questionDao.query(sql, new Object[]{cid});
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 学生页面，按course_id查询问题(只显示那些open=1的或者是自己发布的)
    public static ArrayList<Question> findByCid (int cid, int sid){
        try {
            ArrayList<Question> questionList=findByCid_All(cid);
            questionList.removeIf(question -> question.getOpen() == 0 && question.getSid() != sid);
            return questionList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 学生页面，按student_id查询问题方法(open=1的也要显示)
    public static ArrayList<Question> findBySid (int sid){
        try {
            String sql = "SELECT * FROM Question WHERE sid =? OR OPEN=1 ORDER BY DATE DESC";
            return questionDao.query(sql, new Object[]{sid});
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 按question_id查询问题方法
    public static Question findByQid(int question_id){
        try {
            String sql = "SELECT * FROM Question WHERE id =? ";
            ArrayList<Question> questionList = questionDao.query(sql, new Object[]{question_id});
            return questionList.get(0);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 教师界面：按teacher_id查询问题方法
    public static ArrayList<Question> findByTid(int tid){
        try {
            //根据tid找到所有的cid
            ArrayList<TC> tcList = TCDBUtil.findByTId(tid);
            //根据cid找到question
            ArrayList<Question> questionList=new ArrayList<>();
            for(TC tc:tcList) {
                String sql2 = "SELECT * FROM Question WHERE cid =? ORDER BY DATE DESC";
                questionList.addAll(questionDao.query(sql2, new Object[]{tc.getCid()}));
            }
            return questionList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 查询全部问题的
    public static ArrayList<Question> findAllQuestion() {
        try {
            String sql2 = "SELECT * FROM Question";
            ArrayList<Question> questionList = questionDao.query(sql2, new Object[]{});
            return questionList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
