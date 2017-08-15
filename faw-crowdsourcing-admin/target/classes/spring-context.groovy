import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.web.multipart.commons.CommonsMultipartResolver

import cn.com.faw.crowdsourcing.common.SpringContextHolder

import com.alibaba.druid.pool.DruidDataSource

beans {

	xmlns context: "http://www.springframework.org/schema/context"
	xmlns tx: "http://www.springframework.org/schema/tx"
	xmlns util: "http://www.springframework.org/schema/util"

	// scan annotation
	context.'component-scan'('base-package': "cn.com.faw.crowdsourcing.service")

	// properties file config
	context.'property-placeholder'('location': "classpath:/config.properties")

	// global server url for freemarker
	util.map(id : 'globalMap') {
		entry(key: "webServer", value: '${server.webapp}')
		entry(key: "jsServer", value: '${server.js}')
		entry(key: "cssServer", value: '${server.css}')
		entry(key: "imgServer", value: '${server.img}')
		entry(key: "fileServer", value: '${server.file}')
	}

	// spring context holder
	springContextHolder(SpringContextHolder)

	// file upload config
	multipartResolver(CommonsMultipartResolver){
		defaultEncoding = "UTF-8"
		maxUploadSize = "5000000"
		maxInMemorySize = "30720"
	}

	// database connection config
	dataSource(DruidDataSource){
		driverClassName = '${database.driver}'
		url = '${database.url}'
		username = '${database.user}'
		password = '${database.password}'
		filters = "stat"
		maxActive = 20
		initialSize = 5
	}

	// mybatis config
	sqlSessionFactory(SqlSessionFactoryBean) {
		dataSource = ref("dataSource")
		typeAliasesPackage = "cn.com.faw.crowdsourcing.model"
		mapperLocations = "classpath*:/cn/com/faw/crowdsourcing/dao/*_mapper.xml"
	}

	// mybatis mapper scan, need interface only
	mapperScannerConfigurer(MapperScannerConfigurer){
		basePackage = "cn.com.faw.crowdsourcing.dao"
		annotationClass = "org.springframework.stereotype.Repository"
	}

	// transaction config
	transactionManager(DataSourceTransactionManager){  dataSource = ref("dataSource")  }
	tx.'annotation-driven'('transaction-manager': "transactionManager")

}
