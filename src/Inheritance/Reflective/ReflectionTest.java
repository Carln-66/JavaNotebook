package Inheritance.Reflective;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

//以下程序展示了如何打印一个类的全部信息。这个程序将提醒用户输入类名，然后输出类中所有方法和构造器的签名，以及全部实例字段名
public class ReflectionTest {

    public static void main(String[] args)
            throws ReflectiveOperationException
    {
            //read class name from command line args or user input
            String name;
            if (args.length > 0) name = args[0];
            else
            {
                var in = new Scanner(System.in);
                System.out.println("Enter class name (e.g. java.util.Date): ");
                name = in.next();
            }

            //print class name and superclass name (if != Object)
        Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
        System.out.println("class " + name);
        if (supercl != null && supercl != Object.class) System.out.print("extends "
                + supercl.getName());

        System.out.println("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.println(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

        public static void printMethods(Class cl)
        {
            Method[] methods = cl.getDeclaredMethods();

            for (Method m : methods)
            {
                Class reType = m.getReturnType();
                String name = m.getName();

                System.out.print("   ");
                //print modifiers, return type and method name
                String modifiers = Modifier.toString(m.getModifiers());
                if (modifiers.length() > 0) System.out.print(modifiers + " ");
                System.out.print(reType.getName() + " " + name + "(");

                //print parameter types
                Class[] paramTypes = m.getParameterTypes();
                for (int j = 0; j < paramTypes.length; j++)
                {
                    if (j > 0) System.out.print(", ");
                    System.out.print(paramTypes[j].getName());
                }
                System.out.println(");");
            }
        }

        public static void printFields(Class cl)
        {
            Field[] fields = cl.getDeclaredFields();

            for (Field f : fields)
            {
                Class type = f.getType();
                String name = f.getName();
                System.out.print("   ");
                String modifiers = Modifier.toString(f.getModifiers());
                if (modifiers.length() > 0) System.out.print(modifiers + " ");
                System.out.println(type.getName() + " " + name + ";");
            }
        }
    }

