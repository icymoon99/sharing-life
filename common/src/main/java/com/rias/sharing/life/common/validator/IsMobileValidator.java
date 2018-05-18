package com.rias.sharing.life.common.validator;

import com.rias.sharing.life.common.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required = false;
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return ValidatorUtil.isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return ValidatorUtil.isMobile(value);
			}
		}
	}

}
