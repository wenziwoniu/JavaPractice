package javase.test.reflect;

import javase.test.enums.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;import java.lang.reflect.Type;
import java.util.List;

class Group {

    public Group(String name) {

    }
}

class User {
    private int age;
    private String name;

    //无参数构造
    public User() {
        super();
    }
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;

    }
    public void setAge(int i) {
        // TODO Auto-generated method stub
        this.age = i;

    }

    //2个参数构造
    public User(String name, Long age) {
        super();
        this.name = name;
    }

    //一个参数构造
    public User(String name) {
        super();
        this.name = name;
    }

    //一个参数构造
    public User(List<String> name) {
    }


    /**
     * 私有构造
     * @param age
     * @param name
     */
    @SuppressWarnings("unused")
    private User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "My name is " + name + ", age is " + age;
    }


}

@SuppressWarnings("serial")
public class ReflectConstructDemo implements Serializable{
    public static void main(String[] args) throws Exception {

        Class<?> clazz = null;

        //获取User类对应的Class对象的引用
        clazz = User.class;

        //第一种方法，实例化默认构造方法，User必须有无参构造函数,否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println("user:" + user);

        System.out.println("--------------------------------------------");

        Constructor[] cs0 = clazz.getConstructors();
        Constructor cs00 = clazz.getConstructor(List.class);
        Type[] types = cs00.getGenericParameterTypes();

        //获取带String参数的public构造函数
        Constructor cs1 = clazz.getConstructor(String.class);
        cs1.getGenericParameterTypes();

        //创建User
        User user1= (User) cs1.newInstance("Tom");
        user1.setAge(22);
        System.out.println("user1:" + user1);

        System.out.println("--------------------------------------------");

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2 = clazz.getDeclaredConstructor(int.class,String.class);
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        //创建user对象
        User user2= (User) cs2.newInstance(25,"Like");
        System.out.println("user2:"+user2);

        System.out.println("--------------------------------------------");

        //获取所有构造包含private
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        //查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造函数参数类型
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:"+cons[i].toString() );
            System.out.print("参数类型["+i+"]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
    }
}
