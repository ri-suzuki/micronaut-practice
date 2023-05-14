package personal.bean.scope;

import jakarta.inject.Singleton;

import java.util.random.RandomGenerator;

/**
 * {@link Singleton}がつけられたBeanはアプリケーション上にひとつだけ作られる。
 * 他のクラスにBeanを複数回注入しても、同じBeanを使う。
 */
@Singleton
public class SingletonBean implements Value {

    private final RandomGenerator randomGenerator = RandomGenerator.getDefault();

    private final int value = randomGenerator.nextInt(100);

    @Override
    public int getValue() {
        return value;
    }
}
