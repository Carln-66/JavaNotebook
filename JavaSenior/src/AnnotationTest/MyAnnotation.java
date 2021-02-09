package AnnotationTest;

/**
 * @Auther: Carl
 * @Date: 2021/02/09/10:48
 * @Description:
 */
public @interface MyAnnotation {
    String value() default "测试注解";
}
