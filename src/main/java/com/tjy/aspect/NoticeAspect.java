package com.tjy.aspect;

import com.tjy.dao.UserDao;
import com.tjy.domian.Notice;
import com.tjy.domian.Work;
import com.tjy.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class NoticeAspect{

    @Autowired
    UserDao userDao;
    @Pointcut("execution(public * com.tjy.controller.*.*(..)) || execution(public * com.tjy.controller.admin.*.*(..)) ")
    public void doOperation() {
    }

    @After("doOperation()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //打印请求的内容
        log.info("请求开始时间：{}", LocalDateTime.now());
        log.info("请求Url : {}", request.getRequestURL().toString());
        log.info("请求方式 : {}", request.getMethod());
        log.info("请求ip : {}", request.getRemoteAddr());
        log.info("请求方法 : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数 : {}", Arrays.toString(joinPoint.getArgs()));
        log.info("当前登录用户 : {}", UserUtil.getUser());
        log.info("-------------------------------------");

        if ("receiveWork".equals(joinPoint.getSignature().getName()) && UserUtil.getUser() != null) {
            String name = (String) joinPoint.getArgs()[1];
            Integer id = (Integer) joinPoint.getArgs()[0];
            String mes = name+"领取了"+id+"号任务";
            insertNotice(mes,1,"");
        } else if ("updateWorkTeacher".equals(joinPoint.getSignature().getName()) && UserUtil.getUser() != null) {
            Work work = (Work) joinPoint.getArgs()[0];
            String msg = "管理员"+UserUtil.getUser().getName() +"将"+work.getId()+"号任务分配给您！";
            insertNotice(msg,0,work.getOwnerName());
        } else if("addWork".equals(joinPoint.getSignature().getName()) && UserUtil.getUser() != null) {
            Work work = (Work) joinPoint.getArgs()[0];
            String msg = "管理员"+UserUtil.getUser().getName() +"添加了新任务，快去看看吧！";
            insertNotice(msg,5,work.getOwnerName());
        }
    }


    /**
     * 通知类别
     * 1：管理员，0：督导，2：老师，3：学生，4：全体,5:全体督导
     */

    private void insertNotice(String msg,int type,String name) {
        Notice notice = new Notice();
        notice.setMessage(msg);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = ft.format(new Date());
        notice.setTime(format);
        notice.setType(type);
        if (type != 1 && type != 4) {
            notice.setPeopleName(name);
        }
        try {
            userDao.insertNotice(notice);
        }catch (Exception e) {
            log.error(e.toString());
        }
        System.out.println(msg);
    }
}
