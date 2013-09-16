package me.nengzhe.base.utils.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class CommonPropertyPlaceholderConfigurer  extends
        PropertyPlaceholderConfigurer {

	public CommonPropertyPlaceholderConfigurer() {
		super();
	}

	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		String value = PreferenceService.getCommonConfiguration()
				.getString(placeholder);
		if (value == null) {
			return super.resolvePlaceholder(placeholder, props);
		} else
			return value;
	}
}
