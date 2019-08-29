//package com.benqio.push.portal.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.benqio.uc.common.model.User;
//import com.benqio.push.common.annotation.OperLogAnnotation;
//import com.benqio.push.common.model.OperLog;
//import com.benqio.push.framework.Constant;
//import com.benqio.push.portal.util.IpUtils;
//import com.benqio.push.portal.util.ServletUtils;
//import lombok.extern.log4j.Log4j2;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.util.Date;
//import java.util.Map;
//import java.util.Objects;
//
//@Log4j2
//@Aspect
//@Component
//@EnableAsync
//public class OperLogAspect {
//
//    @Resource
//    private IOperLogService operLogService;
//
//
//    @Pointcut("@annotation(com.benqio.push.common.annotation.OperLogAnnotation)")
//    public void logPointCut(){
//
//    }
//
//    /**
//     * 后置通知，用于拦截操作
//     * @param point
//     * @return
//     * @throws Throwable
//     */
//    @AfterReturning("logPointCut()")
//    public void around(JoinPoint point) throws Throwable{
//        handleLog(point,null);
//    }
//
//
//
//    /**
//     * 拦截异常操作
//     *
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(value = "logPointCut()", throwing = "e")
//    public void doAfter(JoinPoint joinPoint, Exception e)
//    {
//
//        handleLog(joinPoint, e);
//    }
//
//
//    @Async
//    protected void handleLog(final JoinPoint joinPoint, final Exception e)
//    {
//        try
//        {
//            // 获得注解
//            OperLogAnnotation controllerLog = getAnnotationLog(joinPoint);
//            if (controllerLog == null)
//            {
//                return;
//            }
//
//
//             Object object = ServletUtils.getSession().getAttribute(Constant.$USER);
//             User currentUser = null;
//             if(!Objects.isNull(object)){
//                 currentUser = (User) object;
//             }
//
//            // *========数据库日志=========*//
//            OperLog operLog = new OperLog();
//            operLog.setOperStatus((byte)0);
//            operLog.setOperTime(new Date());
//            // 请求的地址
//            String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
//            operLog.setOperIp(ip);
//            // 操作地点
////            operLog.setOperLocation(AddressUtils.getRealAddressByIP(ip));
//            final String uri = ServletUtils.getRequest().getRequestURI().replace("//","/");
//            operLog.setOperUrl(uri);
//            if (!Objects.isNull(currentUser))
//            {
//                operLog.setOperName(currentUser.getName());
////                operLog.setDeptName(currentUser.getDeptName());
//            }
//
//            if (e != null)
//            {
//                operLog.setOperStatus((byte)1);
//                operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
//            }
//            // 设置方法名称
//            String className = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            operLog.setMethod(className + "." + methodName + "()");
//            // 处理设置注解上的参数
//            getControllerMethodDescription(controllerLog, operLog,joinPoint,uri);
//            // 保存数据库
//           operLogService.save(operLog);
//        }
//        catch (Exception exp)
//        {
//            // 记录本地异常日志
//            log.error("==后置通知异常==");
//            log.error("异常信息:{}", exp.getMessage());
//            exp.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取注解中对方法的描述信息 用于Controller层注解
//     *
//     * @param
//     * @return 方法描述
//     * @throws Exception
//     */
//    public void getControllerMethodDescription(OperLogAnnotation log, OperLog operLog,JoinPoint joinPoint,String uri) throws Exception
//    {
//        // 设置action动作
//        operLog.setAction(log.action());
//        // 设置标题
//        operLog.setTitle(log.title());
//        // 设置channel
//        operLog.setChannel(log.channel());
//        // 是否需要保存request，参数和值
//        if (log.isSaveRequestData())
//        {
//            // 获取参数的信息，传入到数据库中。
//            setRequestValue(operLog,joinPoint,uri);
//        }
//    }
//
//    /**
//     * 获取请求的参数，放到log中
//     *
//     * @param operLog
//     * @param
//     */
//    private void setRequestValue(OperLog operLog,JoinPoint joinPoint,String uri)
//    {
//        Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
//        if(map.isEmpty()){
//            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//            Object[] arguments = joinPoint.getArgs();
//            for(Parameter parameter : methodSignature.getMethod().getParameters()){
//                if(parameter.isAnnotationPresent(RequestBody.class)){
//                    for(Object obj:arguments){
//                        if(obj.getClass().getName().equals(parameter.getParameterizedType().getTypeName())){
//                            String param = JSONObject.toJSONString(obj);
//                            if(uri.endsWith("/login")){
//                                param.replace("password","******");
//                            }
//                            operLog.setOperParam(param);
//                        }
//                    }
//                }
//            }
//        }else{
//            String params = JSONObject.toJSONString(map);
//            operLog.setOperParam(StringUtils.substring(params, 0, 255));
//        }
//    }
//
//    /**
//     * 是否存在注解，如果存在就获取
//     */
//    private OperLogAnnotation getAnnotationLog(JoinPoint joinPoint) throws Exception
//    {
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//
//        if (method != null)
//        {
//            return method.getAnnotation(OperLogAnnotation.class);
//        }
//        return null;
//    }
//
//}
