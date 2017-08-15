package cn.com.faw.crowdsourcing.common;

import java.nio.charset.Charset;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

/**
 * 自定义在Spring初始化StringHttpMessageConverter初始化完成后对其设置UTF-8编码
 *
 * <pre>
 * 在Spring中,采用@ResponseBody标签进行Json返回时,当返回值类型为字符串(String)时,
 * Spring采用了{@link StringHttpMessageConverter}转化器对返回字符串进行转换.
 * 该类默认使用"ISO-8859-1"编码进行转换,从而导致返回值为字符串出现乱码.
 * {@code StringHttpMessageConverter}中的编码无法更改,因此在初始化完成后单独进行设置
 * </pre>
 * 
 * <pre>
 * 在{@link StringHttpMessageConverter}初始化完成后,设置其使用UTF-8编码进行字符串转换
 * 当{@code StringHttpMessageConverter}处理控制器(Controller)返回字符串类型时即可使用UTF-8编码
 * 从而避免乱码情况发生.项目使用时需要在Spring配置文件中对本对象进行配置,参见配置方式.
 * </pre>
 * 
 * <h3>配置方式</h3>
 * 
 * <p>
 * <strong>XML:</strong>
 * {@code <bean id="UTF8StringBeanPostProcessor" class="coma.cata.common.spring.UTF8StringBeanPostProcessor" />}
 * </p>
 * <p>
 * <strong>Groovy DSL:</strong> {@code UTF8StringBeanPostProcessor(UTF8StringBeanPostProcessor)}
 * </p>
 * 
 * @author zbq
 * @since 2015年4月30日
 */
@Component
public class UTF8StringBeanPostProcessor implements BeanPostProcessor {

    /**
     * UTF-8编码格式
     */
    private static final MediaType UTF8_TYPE = new MediaType("text", "html", Charset.forName("UTF-8"));

    /**
     * Bean初始化完成后处理
     * 
     * <pre>
     * 当转化器{@link StringHttpMessageConverter}初始化完成后,为其设置采用UTF-8编码处理
     * 避免使用@ResponseBody标签返回单一字符串时出现乱码的情况
     * </pre>
     *
     * @param bean 转化器
     * @param beanName 转化器名称
     * @return StringHttpMessageConverter时返回设置UTF-8的转化器,其他正常返回
     * @throws BeansException
     * 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object,
     *      java.lang.String)
     * 
     * @author zbq
     * @since 2015年4月30日
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof StringHttpMessageConverter) {
            ((StringHttpMessageConverter) bean).setSupportedMediaTypes(Lists.newArrayList(UTF8_TYPE));
        }
        return bean;
    }

    /**
     * Bean初始化前暂不进行任何处理
     *
     *
     * @param bean 转化器
     * @param beanName 转化器名称
     * @return 未进行任何处理的Bean
     * @throws BeansException
     * 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object,
     *      java.lang.String)
     * 
     * @author zbq
     * @since 2015年4月30日
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
