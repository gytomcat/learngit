package cn.com.faw.crowdsourcing.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文管理器
 * 
 * <pre>
 * 负责保存Spring的上下文,提供上下文及获取上下文管理的对象等功能.
 * 项目中需要手动从Spring中取得被托管的Bean时可调用本类静态方法获取.
 * 本类中的上下文是通过继承Spring的接口,在Spring初始化的时候获取上下文的
 * 因此使用本类时需要在Spring配置文件中对本类进行配置,参见配置方式.
 * </pre>
 *
 * <h3>配置方式</h3>
 * 
 * <p>
 * XML:
 * {@code <bean id="springContextHolder" class="coma.cata.common.spring.SpringContextHolder" />}
 * </p>
 * <p>
 * Groovy DSL: {@code springContextHolder(SpringContextHolder)}
 * </p>
 * 
 * @author zbq
 * @since 2015年4月29日
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

	/**
	 * Spring上下文
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 设置Spring上下文
	 * 
	 * <pre>
	 * 继承ApplicationContextAware类时必须要实现该方法,通过该方法获取Spring的上下文
	 * </pre>
	 *
	 * @param applicationContext
	 *            Spring上下文
	 * @throws BeansException
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 * 
	 * @author zbq
	 * @since 2015年4月29日
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 获取Spring上下文
	 *
	 * @return Spring上下文
	 *
	 * @author zbq
	 * @since 2015年4月29日
	 */
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new NullPointerException("spring application context is null");
		}
		return applicationContext;
	}

	/**
	 * 根据名称从上下文中获取该名称对应的被Spring管理的对象
	 *
	 * @param beanName
	 *            bean名称
	 * @return 对应的实例化对象
	 *
	 * @author zbq
	 * @since 2015年4月29日
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		Object o = getApplicationContext().getBean(beanName);
		if (o == null) {
			throw new NullPointerException("no bean named '" + beanName + "' in spring");
		}
		return (T) o;
	}

	/**
	 * 根据名称从上下文中获取该名称对应的被Spring管理的对象并强制转换为相应类型
	 *
	 * <pre>
	 * 该方法获取的对象是已经被强制转换为指定类型的对象,调用者无需再次转换可直接使用对象的方法和属性
	 * SpringContextHolder.getBean(X.getClass()).xxx();
	 * 其中xxx为对象X中的某个方法. 
	 * SpringContextHolder.getBean(String beanName)方法获取的对象无法直接调用xxx方法
	 * </pre>
	 * 
	 * @param beanType
	 *            对象类型,取得bean后自动转换为该类型返回
	 * @return 对应的实例化对象(类型为T)
	 *
	 * @author zbq
	 * @since 2015年4月29日
	 */
	public static <T> T getBean(Class<T> beanType) {
		return getApplicationContext().getBean(beanType);
	}

}
