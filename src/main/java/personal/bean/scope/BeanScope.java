package personal.bean.scope;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.runtime.context.scope.Refreshable;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Prototype
public class BeanScope {
    private final SingletonBean singletonBean;

    private final PrototypeBean prototypeBean;

    /**
     * コンストラクターインジェクション
     *
     * @param singletonBean {@link jakarta.inject.Singleton}が付与されたBean
     * @param prototypeBean 　{@link io.micronaut.context.annotation.Prototype}が付与されたBean
     */
    public BeanScope(SingletonBean singletonBean, PrototypeBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    /**
     * 各BeanからValueを取得
     *
     * @return Key：Beanの名前（クラス名）, Value：BeanのValue
     */
    public Map<String, Integer> getValueFromEachBean() {
        var map = new HashMap<String, Integer>(2);
        map.put(singletonBean.getClass().getSimpleName(), singletonBean.getValue());
        map.put(prototypeBean.getClass().getSimpleName(), prototypeBean.getValue());
        return map;
    }
}
