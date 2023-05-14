package personal.bean.scope;

import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Singleton;

import java.util.random.RandomGenerator;

/**
 * {@link Prototype}がつけられたBeanは、Beanに注入されるたびに新しく作成される。
 */
@Prototype
public class PrototypeBean implements Value {
    private RandomGenerator randomGenerator = RandomGenerator.getDefault();

    private final int value = randomGenerator.nextInt(100);

    @Override
    public int getValue() {
        return value;
    }
}
