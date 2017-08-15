import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver

import cn.com.faw.crowdsourcing.common.UTF8StringBeanPostProcessor

beans {

	xmlns context: "http://www.springframework.org/schema/context"
	xmlns mvc: "http://www.springframework.org/schema/mvc"
	xmlns util: "http://www.springframework.org/schema/util"

	// spring mvc controller scan
	context.'component-scan'('base-package': "cn.com.faw.crowdsourcing.web")
	mvc.'annotation-driven'()

	// UTF-8 for @ResponseBody when return String
	UTF8StringBeanPostProcessor(UTF8StringBeanPostProcessor)

	// properties file config
	context.'property-placeholder'('location': "classpath:/config.properties")

	// json
	requestMappingHandlerAdapter(RequestMappingHandlerAdapter){
		messageConverters: [
			MappingJackson2HttpMessageConverter
		]
	}

	// view resolver -> use freemarker
	viewResolver(FreeMarkerViewResolver) {
		suffix = ".ftl"
		viewClass = "org.springframework.web.servlet.view.freemarker.FreeMarkerView"
		contentType = "text/html;charset=utf-8"
		attributes = ref("globalMap")
	}

	// freemarker config
	freemarkerConfigurer(FreeMarkerConfigurer){
		templateLoaderPath = "/WEB-INF/view/"
		freemarkerSettings = [
			"template_update_delay": "0",
			"defaultEncoding": "UTF-8",
			"number_format": "#",
			"date_format": "yyyy-MM-dd",
			"classic_compatible": "true",
			"auto_import": "/macro/layout.ftl as layout"
		]
	}

}
