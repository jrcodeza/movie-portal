package sk.portal.movie.conf;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Mapper dozerMapper(List<BeanMappingBuilder> beanMappingBuilders) {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		beanMappingBuilders.forEach(beanMappingBuilder -> dozerBeanMapper.addMapping(beanMappingBuilder));
		return dozerBeanMapper;
	}

}
