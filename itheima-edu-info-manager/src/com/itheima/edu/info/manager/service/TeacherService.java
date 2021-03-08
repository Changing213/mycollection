package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();


    public boolean addTeacher(Teacher t) {
        return teacherDao.addTeacher(t);




    }


    public boolean isExists(String id) {
        //获取库管对象中的数组
        //遍历数组去除每一个元素，进行判断

        Teacher[] teachers = teacherDao.findAllTeacher();
        boolean exists = false;

        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if(teacher != null && teacher.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        boolean flag = false;


        for (int i = 0; i < allTeacher.length; i++) {
            Teacher t = allTeacher[i];
            if(t != null){
                flag = true;
                break;
            }
        }
        if(flag){
            return allTeacher;
        }else{
            return null;
        }

    }

    public void delTeacherById(String id) {
        teacherDao.delTeacherById(id);
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        teacherDao.updateTeacher(id,newTeacher);

    }
}
