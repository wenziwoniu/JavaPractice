package javase.test.designpattern.strategypattern.firststep;

/**
 * 定义飞行接口，将Duck里的飞行方法去除，如果有子类想要拥有飞行行为，则继承该接口
 * 但如果有多个子类，则需要实现该接口，而且造成代码不可复用
 */
public interface Flyable {

    void flyable();
}
